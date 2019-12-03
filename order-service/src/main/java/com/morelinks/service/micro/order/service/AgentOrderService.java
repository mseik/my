package com.morelinks.service.micro.order.service;

import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.exception.BusinessException;
import com.morelinks.core.model.Page;
import com.morelinks.core.model.QueryResult;
import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.core.util.GenIdUtil;
import com.morelinks.core.util.IntUtil;
import com.morelinks.core.util.StringUtil;
import com.morelinks.feign.micro.inner.user.api.client.AgentInfoFeignClient;
import com.morelinks.feign.micro.inner.user.api.client.AgentInvoiceInfoFeignClient;
import com.morelinks.feign.micro.inner.user.api.model.AgentInfo;
import com.morelinks.feign.micro.inner.user.api.model.AgentInvoiceInfo;
import com.morelinks.feign.micro.order.api.dto.AgentOrder4Submit;
import com.morelinks.feign.micro.order.api.dto.AgentOrderAmountModifyForm;
import com.morelinks.feign.micro.order.api.model.*;
import com.morelinks.feign.micro.order.api.model.dto.Query4Order;
import com.morelinks.feign.micro.pay.api.client.PayOrderFeignClient;
import com.morelinks.feign.micro.pay.api.model.PayOrder;
import com.morelinks.feign.micro.product.api.client.ProductFeignClient;
import com.morelinks.feign.micro.product.api.model.Product;
import com.morelinks.service.micro.order.mapper.AgentCartMapper;
import com.morelinks.service.micro.order.mapper.AgentOrderDetailMapper;
import com.morelinks.service.micro.order.mapper.AgentOrderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Transactional
@Service
public class AgentOrderService extends BaseServiceWithQueryPage<AgentOrder,String,AgentOrderMapper> {

	private Logger logger = LoggerFactory.getLogger(AgentOrderService.class);
	@Autowired
	AgentCartMapper cartMapper;
	@Autowired
	AgentOrderMapper orderMapper;
	@Autowired
	AgentOrderDetailMapper orderDetailMapper;
	@Autowired
	ProductFeignClient productFeignClient;
	@Autowired
	AgentInfoFeignClient agentInfoFeignClient;
	@Autowired
	PayOrderFeignClient payOrderFeignClient;
	@Autowired
	AgentInvoiceInfoFeignClient invoiceInfoFeignClient;
	@Autowired
	AgentOrderInvoiceInfoService orderInvoiceInfoService;
	@Autowired
	AgentDeliveryAddressService deliveryAddressService;
	@Autowired
	AgentOrderLogService orderLogService;
	@Autowired
	ExpressService expressService;
	public QueryResult<AgentOrder> getQueryResultNew(Query4Order query, Page page) {
		if (query != null && page != null) {
			QueryResult<AgentOrder> result = new QueryResult();
			result.setTotalCount(this.mapper.queryPageResultCountNew(query));
			result.setItems(this.mapper.queryPageResultNew(query, page));
			return result;
		} else {
			return null;
		}
	}

	public  AgentOrder submitOrder(AgentOrder4Submit obj)
	{
		if(!IntUtil.isGreaterThanZero(obj.getUserId()))
		{
			throw  new IllegalArgumentException("userId invalid");
		}
		if(!IntUtil.isGreaterThanZero(obj.getAddressId()))
		{
			throw  new IllegalArgumentException("addressId invalid");
		}
		AgentDeliveryAddress address = deliveryAddressService.getByPrimaryKey(obj.getAddressId());
		if(address==null)
		{
			throw  new BusinessException("请填写配送地址");
		}
		BigDecimal discountRate =BigDecimal.valueOf(1d);
		int userLevel =-1;
		Integer noTaxBill =0;
		AgentInfo agentUserInfo=null;
		ReturnValue<AgentInfo> retAgent = agentInfoFeignClient.getByUserId(obj.getUserId());
		if(retAgent.getCode()!=200)
		{
			throw  new BusinessException("系统繁忙，请稍后再试");
		}
		agentUserInfo = retAgent.getObj();
		if(agentUserInfo!=null) {
			noTaxBill=agentUserInfo.getNoTaxBill();
			if (agentUserInfo != null && agentUserInfo.getAgentLevel() != null && agentUserInfo.getLevelStatus() != null
					&& agentUserInfo.getLevelStatus() == 1
					&& (agentUserInfo.getLevelStartTime() == null || agentUserInfo.getLevelStartTime().before(new Date()))
					&& (agentUserInfo.getLevelEndTime() == null || agentUserInfo.getLevelEndTime().after(new Date()))
					) {
				userLevel = agentUserInfo.getAgentLevel();
			}
			ReturnValue<BigDecimal> retRate = productFeignClient.getUserDiscountRate(userLevel);
			if(retRate.getCode()==200 && retRate.getObj()!=null)
			{
				discountRate=retRate.getObj();
			}
		}
		AgentCart query = new AgentCart();
		query.setUserId(obj.getUserId());
		query.setSelected(true);
		Page page = new Page();
		page.setOffset(0);
		page.setLimit(1000);
		List<AgentCart> lstCart = cartMapper.queryPageResult(query,page);
		if(lstCart==null || lstCart.size()<=0)
		{
			throw new BusinessException("未选中商品");
		}
		AgentOrder order = new AgentOrder();
		order.setAgentId(agentUserInfo.getId());
		order.setCreateTime(new Date());
		order.setDiscountAmount(new BigDecimal("0"));
		order.setFromType(1);
		order.setId(GenIdUtil.getIdByTimeStamp(obj.getUserId().toString(),18,false));
		order.setOrderAmount(obj.getTotalAmount());
		order.setOrderStatus(1);
		order.setOrderType(0);
		order.setOriAmount(obj.getTotalAmount());
		order.setPayStatus(0);
//		order.setPaySuccessTime();
//		order.setReceiptTime();
		order.setPayType(obj.getPayType());
		order.setRemark(obj.getRemark());
//		order.setSendTime();
		order.setUpdateTime(new Date());
		order.setUserId(obj.getUserId().toString());
		order.setDeliveryAddressId(obj.getAddressId());
		order.setDeliveryAddress(address.getDeliveryAddress());
		order.setDeliveryCityId(address.getCityId());
		order.setDeliveryContactTel(address.getContactTel());
		order.setDeliveryUserName(address.getUserName());
		order.setCommonModifyAmount(new BigDecimal("0"));
		order.setGoodsModifyAmount(new BigDecimal("0"));
		order.setCommonAmount(new BigDecimal("0"));
		order.setGoodsAmount(new BigDecimal("0"));
		this.insert(order);
		//牵扯到版本号 需要查询下
		order = this.getByPrimaryKey(order.getId());
		BigDecimal totalCalAmount =new BigDecimal("0");
        BigDecimal goodsAmount =new BigDecimal("0");
		BigDecimal commonAmount =new BigDecimal("0");
		for (AgentCart cart:lstCart
				) {
			ReturnValue<Product> retProduct = productFeignClient.getByPrimaryKey(cart.getProductId());
			if(retProduct.getObj()==null)
			{
				continue;
			}
			Product product = retProduct.getObj();
			ReturnValue<BigDecimal> retAmount =  productFeignClient.calProductShowAmount(product.getProductAmount(),
					product.getProductMemberAmount(),
					userLevel,noTaxBill,
					discountRate,
					product.getDeduceGoodsAccount());
			if((retAmount.getCode()!=200 && retAmount.getObj()==null) ||retAmount.getObj().compareTo(BigDecimal.valueOf(0d))<=0)
			{
				throw  new BusinessException("计算金额失败");
			}
			BigDecimal orderAmount = retAmount.getObj().multiply(new BigDecimal(cart.getQuantity().toString()))
					.setScale(2,BigDecimal.ROUND_UP);
			AgentOrderDetail orderDetail = new AgentOrderDetail();
			orderDetail.setAgentOrderId(order.getId());
			orderDetail.setCreateTime(new Date());
			orderDetail.setDiscountAmount(BigDecimal.valueOf(0d));
			orderDetail.setDiscountDesc("");
			orderDetail.setOriAmount(orderAmount);
			orderDetail.setProductAmount(orderAmount);
			orderDetail.setProductId(cart.getProductId());
			orderDetail.setProductName(product.getShowName());
			orderDetail.setProductNum(cart.getQuantity());
			orderDetail.setRemark("");
			orderDetail.setUpdateTime(new Date());
			orderDetail.setCoreProductType(0);
			if(product.getDeduceGoodsAccount()!=null && product.getDeduceGoodsAccount()==1) {
				orderDetail.setCoreProductType(1);
			}
			if(orderDetail.getCoreProductType()==0)
			{
				commonAmount=commonAmount.add(orderDetail.getProductAmount()) ;
			}
			if(orderDetail.getCoreProductType()==1)
			{
				goodsAmount=goodsAmount.add(orderDetail.getProductAmount());
			}
			orderDetailMapper.insert(orderDetail);
			cartMapper.deleteByPrimaryKey(cart.getId());
			logger.info("计算商品金额 商品："+cart.getProductId()+" 金额："+orderDetail.getProductAmount());
//			totalCalAmount+=orderDetail.getProductAmount();
		}
		totalCalAmount=commonAmount.add(goodsAmount);
		logger.info("比较金额totalCalAmount："+totalCalAmount+" 提交金额："+obj.getTotalAmount());
		if(totalCalAmount.compareTo(obj.getTotalAmount().setScale(2,BigDecimal.ROUND_UP))!=0)
		{
			throw  new BusinessException("金额异常");
		}
		order.setCommonAmount(commonAmount);
		order.setGoodsAmount(goodsAmount);
		this.updateByPrimaryKey(order);
		if(IntUtil.isGreaterThanZero(obj.getInvoiceId())
				&& (agentUserInfo.getNoTaxBill()==null || agentUserInfo.getNoTaxBill()!=1)){
			ReturnValue<AgentInvoiceInfo> retInvoiceInfo = invoiceInfoFeignClient.getByPrimaryKey(obj.getInvoiceId());
			if(retInvoiceInfo.getObj()==null)
			{
				throw  new BusinessException("发票信息出错");
			}
			AgentInvoiceInfo invoiceInfo = retInvoiceInfo.getObj();
			AgentOrderInvoiceInfo orderInvoiceInfo = new AgentOrderInvoiceInfo();
			orderInvoiceInfo.setCreateTime(new Date());
			orderInvoiceInfo.setInvoiceBankAccount(invoiceInfo.getDepositBankAccount());
			orderInvoiceInfo.setInvoiceBankName(invoiceInfo.getDepositBankName());
			orderInvoiceInfo.setInvoiceCompanyAddress(invoiceInfo.getCompanyAddress());
			orderInvoiceInfo.setInvoiceCompanyTel(invoiceInfo.getCompanyTel());
			orderInvoiceInfo.setInvoiceId(invoiceInfo.getId());
			orderInvoiceInfo.setInvoiceNo(invoiceInfo.getTaxNo());
			orderInvoiceInfo.setInvoiceTitle(invoiceInfo.getCompanyName());
			orderInvoiceInfo.setOrderId(order.getId());
			orderInvoiceInfo.setUpdateTime(new Date());
			orderInvoiceInfoService.insert(orderInvoiceInfo);
		}
		AgentOrderLog orderLog = new AgentOrderLog();
		orderLog.setAfterOrderStatus(order.getOrderStatus());
		orderLog.setCreateTime(new Date());
		orderLog.setLogContent("用户下单");
		orderLog.setLogType(1);
		orderLog.setOrderId(order.getId());
		orderLog.setOriOrderStatus(0);
		orderLog.setUpdateTime(new Date());
		orderLog.setModifyRecord("");
		orderLog.setOperator(obj.getUserId().toString());
		orderLog.setOperatorType(1);
		orderLogService.insert(orderLog);
		return order;
	}

	/**
	 * 调整订单金额
	 * @param form
	 * @return
	 */
	public AgentOrder modifyOrderAmount(AgentOrderAmountModifyForm form)
	{
		if(form==null)
		{
			throw new IllegalArgumentException("form invalid");
		}
		if(StringUtil.isTrimBlank(form.getAgentOrderId()))
		{
			throw new IllegalArgumentException("agentOrderId invalid");
		}
		AgentOrder order = this.getByPrimaryKey(form.getAgentOrderId());
		if(order==null)
		{
			throw new IllegalArgumentException("AgentOrder invalid");
		}
		AgentOrderLog orderLog = new AgentOrderLog();
		String logContent="";
		if(form.getGoodsModifyAmount()!=null)
		{
			logContent+="核心货款调整："+form.getGoodsModifyAmount()+" ";
			order.setGoodsModifyAmount(form.getGoodsModifyAmount());
		}
		if(form.getCommonModifyAmount()!=null)
		{
			logContent+="通用货款调整："+form.getCommonModifyAmount();
			order.setCommonModifyAmount(form.getCommonModifyAmount());
		}
		order.setOrderAmount(order.getCommonAmount().add(order.getGoodsAmount()).add(form.getGoodsModifyAmount())
				.add(form.getCommonModifyAmount()).setScale(2,BigDecimal.ROUND_UP));
		this.updateByPrimaryKey(order);
		orderLog.setOriOrderStatus(order.getOrderStatus());
		orderLog.setAfterOrderStatus(order.getOrderStatus());
		orderLog.setLogContent(logContent);
		orderLog.setLogType(2);
		orderLog.setOrderId(order.getId());
		orderLog.setCreateTime(new Date());
		orderLog.setUpdateTime(new Date());
		orderLog.setModifyRecord("");
		orderLog.setOperator(form.getOperator());
		orderLog.setOperatorType(3);
		orderLog.setRemark(form.getRemark());
		orderLogService.insert(orderLog);
		return order;
	}


	public  AgentOrder cancelOrderByUser(String id,Integer reasonType,String reason)
	{
		AgentOrder order =mapper.selectByPrimaryKey(id);
		if(order==null)
		{
			throw new BusinessException("订单非法");
		}
		if(order.getOrderStatus()!=1 || (order.getPayStatus()!=null && order.getPayStatus()==2))
		{
			throw new BusinessException("当前订单不允许取消，请联系管理员");
		}
		order.setOrderStatus(5);
		order.setUpdateTime(new Date());
		this.updateByPrimaryKey(order);
		AgentOrderLog orderLog = new AgentOrderLog();
		orderLog.setOriOrderStatus(order.getOrderStatus());
		order.setOrderStatus(1);
		orderLog.setAfterOrderStatus(5);
		orderLog.setLogContent("取消订单");
		orderLog.setLogType(1);
		orderLog.setOrderId(order.getId());
		orderLog.setCreateTime(new Date());
		orderLog.setUpdateTime(new Date());
		orderLog.setModifyRecord("");
		orderLog.setOperator(order.getUserId());
		orderLog.setOperatorType(1);
		orderLog.setRemark(reason);
		orderLogService.insert(orderLog);
		return order;
	}

	public AgentOrder confirmOrderSuccByUser(String id
	)
	{
		AgentOrder order =mapper.selectByPrimaryKey(id);
		if(order==null)
		{
			throw new BusinessException("订单非法");
		}
		if(order.getOrderStatus()!=3)
		{
			throw new BusinessException("当前订单不允许完结，请联系管理员");
		}
		order.setOrderStatus(4);
		order.setUpdateTime(new Date());
		this.updateByPrimaryKey(order);
		AgentOrderLog orderLog = new AgentOrderLog();
		orderLog.setOriOrderStatus(order.getOrderStatus());
		order.setOrderStatus(3);
		orderLog.setAfterOrderStatus(4);
		orderLog.setLogContent("订单完成");
		orderLog.setLogType(1);
		orderLog.setOrderId(order.getId());
		orderLog.setCreateTime(new Date());
		orderLog.setUpdateTime(new Date());
		orderLog.setModifyRecord("");
		orderLog.setOperator(order.getUserId());
		orderLog.setOperatorType(1);
		orderLog.setRemark("用户确认收货");
		orderLogService.insert(orderLog);
		return order;
	}


	public void paySucc(String payOrderId)
	{
		ReturnValue<PayOrder> retPayOrder = payOrderFeignClient.getById(payOrderId);
		if(retPayOrder.getCode()!=200)
		{
			throw new BusinessException("paySucc error:"+payOrderId+" msg:"+StringUtil.getErrorMsg(retPayOrder.getMsg()));
		}
		PayOrder payOrder = retPayOrder.getObj();
		if(payOrder==null)
		{
			throw new BusinessException("paySucc error null:"+payOrderId);
		}
		//判断是否为代理商支付订单
		if(payOrder.getOrderType()==null || payOrder.getOrderType()!=1)
		{
			return;
		}
		AgentOrder order = mapper.selectByPrimaryKey(payOrder.getMerchantOrderId());
		if(order==null)
		{
			throw new BusinessException("order invalid payOrderId:"+payOrderId);
		}
		AgentOrderLog orderLog = new AgentOrderLog();
		order.setPayStatus(2);
		order.setPaySuccessTime(payOrder.getPaySuccessTime());
		order.setUpdateTime(new Date());
		orderLog.setOriOrderStatus(order.getOrderStatus());
		if(order.getOrderStatus()!=null && order.getOrderStatus()==1)
		{
			order.setOrderStatus(2);
			orderLog.setAfterOrderStatus(2);
			orderLog.setLogContent("订单支付成功");
			orderLog.setLogType(1);
			orderLog.setOrderId(order.getId());
			orderLog.setCreateTime(new Date());
			orderLog.setUpdateTime(new Date());
			orderLog.setModifyRecord("");
			orderLog.setOperator("system");
			orderLog.setOperatorType(2);
			orderLogService.insert(orderLog);
		}
		mapper.updateByPrimaryKey(order);

	}

	public void sendExpress(ExpressOrder expressOrder)
	{
		if(StringUtil.isTrimBlank(expressOrder.getOrderId()))
		{
			throw new BusinessException("订单信息未录入");
		}
		AgentOrder order = this.getByPrimaryKey(expressOrder.getOrderId());
		if(order==null)
		{
			throw new BusinessException("订单不存在");
		}
		//检查订单状态 是否可以发送快递
		if(order.getOrderStatus()!=2)
		{
			throw new BusinessException("当前订单不允许发送快递");
		}
		Express express = expressService.getByPrimaryKey(expressOrder.getExpressId());
		if(express==null)
		{
			throw new BusinessException("快递信息错误");
		}
		order.setOrderStatus(3);
		order.setUpdateTime(new Date());
		this.updateByPrimaryKey(order);
		AgentOrderLog orderLog = new AgentOrderLog();
		orderLog.setOriOrderStatus(order.getOrderStatus());
		order.setOrderStatus(2);
		orderLog.setAfterOrderStatus(3);
		orderLog.setLogContent(
				String.format("发送快递：\n快递公司：%s\n快递单号：%s"
				,express.getExpressName()
				,expressOrder.getExpressNo()));
		orderLog.setLogType(1);
		orderLog.setOrderId(order.getId());
		orderLog.setCreateTime(new Date());
		orderLog.setUpdateTime(new Date());
		orderLog.setModifyRecord("");
		orderLog.setOperator("system");
		orderLog.setOperatorType(2);
		orderLog.setRemark("发送快递");
		orderLogService.insert(orderLog);
		return;
	}
}