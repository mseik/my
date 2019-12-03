package com.morelinks.service.micro.agent.manage.controller.api.ice.mall;

import com.morelinks.core.dto.IceAjaxResult;
import com.morelinks.core.dto.IcePageData;
import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.exception.BusinessException;
import com.morelinks.core.model.Page;
import com.morelinks.core.model.QueryResult;
import com.morelinks.core.util.IntUtil;
import com.morelinks.core.util.StringUtil;
import com.morelinks.core.util.TelUtil;
import com.morelinks.core.webutil.ResourceUtil;
import com.morelinks.feign.micro.common.api.client.WeatherCityFeignClient;
import com.morelinks.feign.micro.common.api.model.WeatherCity;
import com.morelinks.feign.micro.inner.user.api.client.AgentInfoFeignClient;
import com.morelinks.feign.micro.inner.user.api.client.AgentInvoiceInfoFeignClient;
import com.morelinks.feign.micro.inner.user.api.model.AgentInfo;
import com.morelinks.feign.micro.inner.user.api.model.AgentInvoiceInfo;
import com.morelinks.feign.micro.inner.user.api.model.UserInfo;
import com.morelinks.feign.micro.order.api.client.AgentCartFeignClient;
import com.morelinks.feign.micro.order.api.client.AgentOrderDetailFeignClient;
import com.morelinks.feign.micro.order.api.client.AgentOrderFeignClient;
import com.morelinks.feign.micro.order.api.dto.AgentOrder4Submit;
import com.morelinks.feign.micro.order.api.model.AgentCart;
import com.morelinks.feign.micro.order.api.model.AgentOrder;
import com.morelinks.feign.micro.order.api.model.AgentOrderDetail;
import com.morelinks.feign.micro.order.api.model.dto.Query4Order;
import com.morelinks.feign.micro.pay.api.client.AccountFeignClient;
import com.morelinks.feign.micro.pay.api.client.PayOrderFeignClient;
import com.morelinks.feign.micro.pay.api.model.Account;
import com.morelinks.feign.micro.pay.api.model.PayOrder;
import com.morelinks.feign.micro.product.api.client.ProductFeignClient;
import com.morelinks.feign.micro.product.api.client.ProductInfoFeignClient;
import com.morelinks.feign.micro.product.api.client.ProductModelFeignClient;
import com.morelinks.feign.micro.product.api.client.ProductSupplierFeignClient;
import com.morelinks.feign.micro.product.api.dto.ProductDTO;
import com.morelinks.feign.micro.product.api.model.Product;
import com.morelinks.service.micro.agent.manage.dto.*;
import com.morelinks.service.micro.agent.manage.dto.mall.*;
import com.morelinks.service.micro.agent.manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 订单
 */
@RestController
@RequestMapping("/api/agentorder")
public class AgentOrderController {
	@Autowired
	ProductInfoFeignClient productInfoFeignClient;
	@Autowired
	ProductSupplierFeignClient supplierFeignClient;
	@Autowired
	ProductModelFeignClient productModelFeignClient;
	@Autowired
	ProductFeignClient productFeignClient;
	@Autowired
	ResourceUtil resourceUtil;
	@Autowired
	AgentCartFeignClient agentCartFeignClient;
	@Autowired
	UserService userService;
	@Autowired
	AgentOrderFeignClient orderFeignClient;
	@Autowired
	AgentOrderDetailFeignClient orderDetailFeignClient;
	@Autowired
	AccountFeignClient accountFeignClient;
	@Autowired
	PayOrderFeignClient payOrderFeignClient;

	@Autowired
	AgentInfoFeignClient agentInfoFeignClient;
	@Autowired
	AgentInvoiceInfoFeignClient invoiceInfoFeignClient;

	@Autowired
	WeatherCityFeignClient cityFeignClient;
	//region 购物车相关

	/**
	 * 添加商品进购物车
	 * @param productId
	 * @param num
	 * @return
	 */
	@RequestMapping(value = "/addProductToCart", method = {RequestMethod.GET,RequestMethod.POST})
	public IceAjaxResult addProductToCart(Integer productId,Integer num,UserInfo user) {
		if(!IntUtil.isGreaterThanZero(productId))
		{
			return IceAjaxResult.getFailResult("商品非法");
		}
		if(user==null || user.getUserStatus()!=1)
		{
			return IceAjaxResult.getFailResult("用户不存在");
		}
		ReturnValue<Product> retProduct = productFeignClient.getByPrimaryKey(productId);
		if(retProduct.getCode()!=200 ||retProduct.getObj()==null ||  retProduct.getObj().getProductStatus()!=1)
		{
			return IceAjaxResult.getFailResult("商品不存在");
		}
		ReturnValue<AgentCart> ret = agentCartFeignClient.addOrSetProductNum(user.getId(),productId,num,false);
		if(ret.getCode()!=200)
		{
			return IceAjaxResult.getFailResult("添加购物车失败");
		}
		IceAjaxResult result = new IceAjaxResult();
		result.setMessage("商品已成功加入购物车");
		return result;
	}


	/**
	 * 添加商品进购物车
	 * @param productId
	 * @param num
	 * @return
	 */
	@RequestMapping(value = "/updateCartProductNum", method = {RequestMethod.GET,RequestMethod.POST})
	public IceAjaxResult updateCartProductNum(Integer productId,Integer num,UserInfo user) {
		if(!IntUtil.isGreaterThanZero(productId))
		{
			return IceAjaxResult.getFailResult("商品非法");
		}
		if(user==null || user.getUserStatus()!=1)
		{
			return IceAjaxResult.getFailResult("用户不存在");
		}
		ReturnValue<Product> retProduct = productFeignClient.getByPrimaryKey(productId);
		if(retProduct.getCode()!=200 || retProduct.getObj()==null || retProduct.getObj().getProductStatus()!=1)
		{
			return IceAjaxResult.getFailResult("商品不存在");
		}
		ReturnValue<AgentCart> ret = agentCartFeignClient.addOrSetProductNum(user.getId(),productId,num,true);
		if(ret.getCode()!=200)
		{
			return IceAjaxResult.getFailResult("添加购物车失败");
		}
		IceAjaxResult result = new IceAjaxResult();
		result.setMessage("");
		return result;
	}

	@RequestMapping(value = "/getProductCartListDTO", method = {RequestMethod.GET,RequestMethod.POST})
	public IceAjaxResult<ProductCartListDTO> getProductCartListDTO(Boolean selected,UserInfo user
	) {
		IceAjaxResult<ProductCartListDTO> result = new IceAjaxResult<ProductCartListDTO>();
		if(user==null || user.getUserStatus()!=1)
		{
			return IceAjaxResult.getFailResult("用户不存在");
		}
		BigDecimal discountRate =new BigDecimal("1");
		int userLevel =-1;
		Integer noTaxBill =0;
		AgentInfo agentUserInfo=null;
		if(user!=null && user.getId()>0)
		{
			ReturnValue<AgentInfo> retAgent = agentInfoFeignClient.getByUserId(user.getId());
			if(retAgent.getCode()!=200)
			{
				IceAjaxResult.getFailResult("系统繁忙请稍后再试");
			}
			agentUserInfo = retAgent.getObj();
			if(agentUserInfo!=null) {
				noTaxBill=agentUserInfo.getNoTaxBill();
				userLevel = userService.getUserLevel(agentUserInfo);
				ReturnValue<BigDecimal> retRate = productFeignClient.getUserDiscountRate(userLevel);
				if(retRate.getCode()==200 && retRate.getObj()!=null)
				{
					discountRate=retRate.getObj();
				}
			}
		}
		BigDecimal totalAmount = new BigDecimal(0);
		ProductCartListDTO dto = new ProductCartListDTO();
		dto.setList(new ArrayList<ProductCartUnit>());
		dto.setSelectedKeys(new ArrayList<String>());
		dto.setTotalAmount(0);
		QueryPageParam<AgentCart> queryPageParam = new QueryPageParam<AgentCart>();
		AgentCart query = new AgentCart();
		query.setUserId(user.getId());
		queryPageParam.setQuery(query);
		ReturnValue<List<AgentCart>> retResult = agentCartFeignClient.find(queryPageParam);
		if(retResult.getCode()==200 && retResult.getObj()!=null)
		{
			for (AgentCart cart:retResult.getObj()
			     ) {
				if(selected!=null && cart.getSelected()!=null && !cart.getSelected().equals(selected))
				{
					continue;
				}
				ProductCartUnit unit = new ProductCartUnit();
				unit.setId(cart.getId());
				ReturnValue<ProductDTO> retProductDTO = productFeignClient.getProductDTO(cart.getProductId());
				if(retProductDTO.getCode()!=200 || retProductDTO.getObj()==null)
				{
					continue;
				}
				ProductDTO productDTO=retProductDTO.getObj();
				unit.setProductId(productDTO.getId().toString());
				unit.setProductName(productDTO.getProductName());
				unit.setCoverPicUrl(resourceUtil.getImgUrl("/i/product/img/nopic.png"));
				if(productDTO.getLstImg()!=null && productDTO.getLstImg().size()>0) {
					unit.setCoverPicUrl(resourceUtil.getImgUrl(productDTO.getLstImg().get(0).getImgPath()));
				}
				unit.setProductAmount(productDTO.getProductAmount().doubleValue());
				if(productDTO.getProductAmount()==null)
				{
					continue;
				}
				ReturnValue<BigDecimal> retAmount =  productFeignClient.calProductShowAmount(productDTO.getProductAmount(),
						productDTO.getProductMemberAmount(),
						userLevel,noTaxBill,
						discountRate,
						productDTO.getDeduceGoodsAccount());
				if(retAmount.getCode()!=200 )
				{
					continue;
				}
				if( retAmount.getObj()==null ||retAmount.getObj().compareTo(new BigDecimal(0))<=0)
				{
					continue;
				}
				unit.setProductAmount(retAmount.getObj().doubleValue());
				BigDecimal finalAmount = retAmount.getObj().multiply(new BigDecimal(cart.getQuantity().toString()))
						.setScale(2,BigDecimal.ROUND_UP);
				unit.setProductFinalAmount(finalAmount.doubleValue());
				unit.setProductResume("");
				unit.setProductNum(cart.getQuantity());
				unit.setLstProperty(productDTO.getLstProperty());
				if(cart.getSelected()!=null && cart.getSelected())
				{
					dto.getSelectedKeys().add(unit.getProductId());
					totalAmount =totalAmount.add(finalAmount);
				}
				dto.getList().add(unit);
			}
		}
		dto.setTotalAmount(totalAmount.doubleValue());
		result.setData(dto);
		return result;
	}

	@RequestMapping(value = "/getProductCartCount", method = {RequestMethod.GET,RequestMethod.POST})
	public IceAjaxResult<CountDTO> getProductCartCount(UserInfo user
	)
	{
		IceAjaxResult<CountDTO> result = new IceAjaxResult<CountDTO>();
		CountDTO count = new CountDTO();
		count.setCount(0);
		result.setData(count);
		if(user==null || user.getUserStatus()!=1)
		{
			return IceAjaxResult.getFailResult("用户不存在");
		}
		ReturnValue<Integer> ret = agentCartFeignClient.getCountByUserId(user.getId());
		if(ret.getCode()!=200)
		{
			return IceAjaxResult.getFailResult(ret.getMsg());
		}
		if(ret.getObj()!=null)
		{
			count.setCount(ret.getObj());
		}
		return result;
	}

	/**
	 * 更新购物车商品选择状态
	 * @param productId
	 * @param selected
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/updateCartProductSelStatus", method = {RequestMethod.GET,RequestMethod.POST})
	public IceAjaxResult updateCartProductSelStatus(Integer productId,Boolean selected,UserInfo user) {
		if(!IntUtil.isGreaterThanZero(productId))
		{
			return IceAjaxResult.getFailResult("商品非法");
		}
		if(user==null || user.getUserStatus()!=1)
		{
			return IceAjaxResult.getFailResult("用户不存在");
		}
		if(selected==null)
		{
			selected=false;
		}
		ReturnValue ret = agentCartFeignClient.updateProductSelStatus(user.getId(),productId,selected);
		if(ret.getCode()!=200)
		{
			return IceAjaxResult.getFailResult("添加购物车失败");
		}
		IceAjaxResult result = new IceAjaxResult();
		result.setMessage("");
		return result;
	}

	/**
	 * 更新购物车所有商品选择状态
	 * @param selected
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/updateCartSelStatus", method = {RequestMethod.GET,RequestMethod.POST})
	public IceAjaxResult updateCartSelStatus(Boolean selected,UserInfo user) {
		if(user==null || user.getUserStatus()!=1)
		{
			return IceAjaxResult.getFailResult("用户不存在");
		}
		if(selected==null)
		{
			selected=false;
		}
		ReturnValue ret = agentCartFeignClient.updateCartSelStatus(user.getId(),selected);
		if(ret.getCode()!=200)
		{
			return IceAjaxResult.getFailResult("添加购物车失败");
		}
		IceAjaxResult result = new IceAjaxResult();
		result.setMessage("");
		return result;
	}

	/**
	 * 删除购物车中商品
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delCartById", method = {RequestMethod.GET,RequestMethod.POST})
	public IceAjaxResult delCartById(Integer id
	) {
		if(!IntUtil.isGreaterThanZero(id))
		{
			return IceAjaxResult.getFailResult("id非法");
		}
		agentCartFeignClient.deleteByPrimaryKey(id);
		IceAjaxResult result = new IceAjaxResult();
		result.setMessage("删除成功");
		return result;
	}

	/**
	 * 删除购物车中商品
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/delCartByIds", method = {RequestMethod.GET,RequestMethod.POST})
	public IceAjaxResult delCartByIds(String ids
	) {
		if(StringUtil.isTrimBlank(ids))
		{
			return IceAjaxResult.getFailResult("id非法");
		}
		String[] arr =ids.split(",");
		if(arr==null || arr.length<=0)
		{
			return IceAjaxResult.getFailResult("id非法");
		}
		for (String id:arr
		     ) {
			Integer nId = IntUtil.parseInt(id,false);
			if(IntUtil.isGreaterThanZero(nId)) {
				agentCartFeignClient.deleteByPrimaryKey(nId);
			}
		}
		IceAjaxResult result = new IceAjaxResult();
		result.setMessage("删除成功");
		return result;
	}

	//endregion

	//region 订单相关
	@RequestMapping(value = "/submitOrder", method = {RequestMethod.GET,RequestMethod.POST})
	public IceAjaxResult<IdDTO> submitOrder(@RequestBody AgentOrderFormDTO form, UserInfo user) {
		if(form==null)
		{
			return IceAjaxResult.getFailResult("请确认订单信息");
		}
		if(form.getAddressId()==null)
		{
			return IceAjaxResult.getFailResult("请确认收货地址");
		}
		Integer addressId = IntUtil.parseInt(form.getAddressId(),false);
		if(!IntUtil.isGreaterThanZero(addressId))
		{
			return IceAjaxResult.getFailResult("请确认收货地址");
		}
		if(form.getPayType()==null)
		{
			return IceAjaxResult.getFailResult("请选择支付方式");
		}
		if(StringUtil.isTrimBlank(form.getShowAmount()))
		{
			return IceAjaxResult.getFailResult("金额有误，请确认");
		}
		BigDecimal totalAmount = new BigDecimal(form.getShowAmount());
		if(totalAmount==null || totalAmount.compareTo(new BigDecimal("0"))<=0)
		{
			return IceAjaxResult.getFailResult("金额有误，请确认");
		}
		totalAmount =totalAmount.setScale(2,BigDecimal.ROUND_UP);
		if(user==null || user.getUserStatus()!=1)
		{
			return IceAjaxResult.getFailResult("用户不存在");
		}
		ReturnValue<AgentInfo> retAgent = agentInfoFeignClient.getByUserId(user.getId());
		if(retAgent.getCode()!=200 || retAgent.getObj()==null)
		{
			throw new BusinessException("用户信息错误，请联系管理员");
		}

		AgentOrder4Submit formSubmit = new AgentOrder4Submit();
		AgentInfo agent = retAgent.getObj();
		if(agent.getNoTaxBill()==null || agent.getNoTaxBill()!=1)
		{
			ReturnValue<AgentInvoiceInfo> retInvoice = invoiceInfoFeignClient.getByAgentId(agent.getId());
			if(retInvoice.getCode()!=200)
			{
				throw new BusinessException(StringUtil.getErrorMsg(retInvoice.getMsg()));
			}
			if(retInvoice.getObj()==null)
			{
				throw new BusinessException("请先在个人中心商城设置里确认发票信息！");
			}
			formSubmit.setInvoiceId(retInvoice.getObj().getId());
		}
		formSubmit.setAddressId(addressId);
		formSubmit.setPayType(form.getPayType());
		formSubmit.setRemark(form.getRemark());
		formSubmit.setTotalAmount(totalAmount);
		formSubmit.setUserId(user.getId());
		ReturnValue<AgentOrder> ret = orderFeignClient.submitOrder(formSubmit);
		if(ret.getCode()!=200)
		{
			return IceAjaxResult.getFailResult(StringUtil.getErrorMsg(ret.getMsg()));
		}
		IceAjaxResult<IdDTO> result = new IceAjaxResult<IdDTO>();
		result.setMessage("");
		IdDTO dto = new IdDTO();
		dto.setId(ret.getObj().getId());
		result.setData(dto);
		return result;
	}

	@RequestMapping(value = "/getOrderDetail", method = {RequestMethod.GET,RequestMethod.POST})
	public IceAjaxResult<AgentOrderDetailPageDTO> getOrderDetail(String orderId, UserInfo user
	)
	{
		IceAjaxResult<AgentOrderDetailPageDTO> result = new IceAjaxResult<AgentOrderDetailPageDTO>();
		ReturnValue<AgentOrder> retOrder = orderFeignClient.getByPrimaryKey(orderId);
		if(retOrder.getCode()!=200 || retOrder.getObj()==null)
		{
			return IceAjaxResult.getFailResult("订单不存在");
		}
		AgentOrder order = retOrder.getObj();
		AgentOrderDetailPageDTO dto = new AgentOrderDetailPageDTO();
		dto.setOrderId(order.getId());
		dto.setOrderStatus(order.getOrderStatus());
		dto.setOrderStatusName(getOrderStatusName(order.getOrderStatus(),order.getPayStatus()));
		dto.setPayStatus(order.getPayStatus());
		dto.setPayType(order.getPayType());
		dto.setTotalAmount(order.getOrderAmount().doubleValue());
		dto.setUserName(order.getDeliveryUserName());
		result.setData(dto);
		return result;
	}

	@RequestMapping(value = "/getOrderList", method = {RequestMethod.GET,RequestMethod.POST})
	public IceAjaxResult<IcePageData<AgentOrderListUnitDTO>> getOrderList(Integer orderStatusType,
	                                                                      Integer page, Integer pageSize, UserInfo user
	) {
		if(user==null || user.getUserStatus()!=1)
		{
			return IceAjaxResult.getFailResult("用户不存在");
		}
		IceAjaxResult<IcePageData<AgentOrderListUnitDTO> > result = new IceAjaxResult<IcePageData<AgentOrderListUnitDTO> >();
		if(!IntUtil.isGreaterThanZero(page))
		{
			page =1;
		}
		if(!IntUtil.isGreaterThanZero(pageSize))
		{
			pageSize =10;
		}
		IcePageData<AgentOrderListUnitDTO> pageResult = new IcePageData<AgentOrderListUnitDTO>();
		pageResult.setCurrentPage(page);

		QueryPageParam<Query4Order> queryPageParam = new QueryPageParam<Query4Order>();
		Query4Order query = new Query4Order();
		query.setUserId(user.getId().toString());
		List<Integer> lstOrderStatus = new ArrayList<>();
		if(IntUtil.isGreaterThanZero(orderStatusType))
		{
			switch (orderStatusType)
			{
				case 1:break;
				//待付款
				case 2:lstOrderStatus.add(1);break;
				//待收货
				case 3:lstOrderStatus.add(2);lstOrderStatus.add(3);break;
				//已完成
				case 4:lstOrderStatus.add(4);break;
			}
		}
		query.setOrderStatuss(lstOrderStatus);


		queryPageParam.setQuery(query);
		Page pageQuery = new Page();
		pageQuery.setLimit(pageSize);
		pageQuery.setOffset((page-1)*pageSize);
		pageQuery.setOrder(" desc");
		pageQuery.setSort(" create_time");
		queryPageParam.setPage(pageQuery);
		ReturnValue<QueryResult<AgentOrder>> retResult =	orderFeignClient.getQueryResultNew(queryPageParam);
		if(retResult.getCode()!=200)
		{
			return IceAjaxResult.getFailResult("系统繁忙，请稍后再试");
		}
		if(retResult.getObj()!=null)
		{
			if(retResult.getObj().getItems()!=null)
			{
				List<AgentOrderListUnitDTO> lstUnit = new ArrayList<>();
				for (AgentOrder order:retResult.getObj().getItems()
						) {
					AgentOrderListUnitDTO unitDTO = new AgentOrderListUnitDTO();
					unitDTO.setOrderId(order.getId());
					unitDTO.setOrderStatus(order.getOrderStatus());
					unitDTO.setOrderStatusName(getOrderStatusName(order.getOrderStatus(),order.getPayStatus()));
					unitDTO.setPayStatus(order.getPayStatus());
					unitDTO.setPayType(order.getPayType());
					unitDTO.setTotalAmount(order.getOrderAmount().setScale(2,BigDecimal.ROUND_UP).doubleValue());
					unitDTO.setUserName(order.getDeliveryUserName());
					String address = "";
					if(StringUtil.isNotTrimBlank(order.getDeliveryCityId())) {
						ReturnValue<Map<Integer, WeatherCity>> retMapCity = cityFeignClient.getMapCityByCityId(order.getDeliveryCityId());
						if(retMapCity.getCode()==200 && retMapCity.getObj()!=null) {
							Map<Integer, WeatherCity> mapCity = retMapCity.getObj();
							if (mapCity.containsKey(1)) {
								address += mapCity.get(1).getCityName() + " ";
							}
							if (mapCity.containsKey(2)) {
								address += mapCity.get(2).getCityName() + " ";
							}
							if (mapCity.containsKey(3)) {
								address += mapCity.get(3).getCityName() + " ";
							}
//						if (cityName.endsWith(" ")) {
//							cityName = cityName.substring(0, cityName.length() - 1);
//						}
						}
					}
					if(StringUtil.isNotTrimBlank(order.getDeliveryAddress()))
					{
						address += order.getDeliveryAddress();
					}
					List<AgentOrderDetailDTO> lstDetailDTO = new ArrayList<>();
					QueryPageParam<AgentOrderDetail> param = new QueryPageParam<AgentOrderDetail>();
					AgentOrderDetail queryDetail = new AgentOrderDetail();
					queryDetail.setAgentOrderId(order.getId());
					param.setQuery(queryDetail);
					ReturnValue<List<AgentOrderDetail>> retLstDetail = orderDetailFeignClient.find(param);
					if(retLstDetail.getCode()==200 && retLstDetail.getObj()!=null)
					{
						int index =0;
						int len = retLstDetail.getObj().size();
						for (AgentOrderDetail orderDetail:retLstDetail.getObj()
								) {
							index++;
							AgentOrderDetailDTO detailDTO = new AgentOrderDetailDTO();
							detailDTO.setIndex(index);
							detailDTO.setOrderDetailCount(len);
							detailDTO.setOrderId(order.getId());
							detailDTO.setProductCount(orderDetail.getProductNum());
							detailDTO.setProductId(orderDetail.getProductId().toString());
							detailDTO.setProductName(orderDetail.getProductName());
							detailDTO.setProductPic(resourceUtil.getImgUrl("/i/product/img/nopic.png"));
							detailDTO.setOrderStatus(order.getOrderStatus());
							detailDTO.setOrderStatusName(unitDTO.getOrderStatusName());
							detailDTO.setPayStatus(order.getPayStatus());
							detailDTO.setPayType(order.getPayType());
							detailDTO.setTotalAmount(order.getOrderAmount().setScale(2,BigDecimal.ROUND_UP).doubleValue());
							detailDTO.setUserName(order.getDeliveryUserName());
							ReturnValue<Product> retProduct = productFeignClient.getByPrimaryKey(orderDetail.getProductId());
							if(retProduct.getCode()==200 && retProduct.getObj()!=null && StringUtil.isNotTrimBlank(retProduct.getObj().getCoverImgPath())) {
								detailDTO.setProductPic(resourceUtil.getImgUrl(retProduct.getObj().getCoverImgPath()));
							}
							if(index==1)
							{
								detailDTO.setDeliveryAddress(address);
								detailDTO.setContactTel(TelUtil.getTelShow(order.getDeliveryContactTel()));
							}
							lstDetailDTO.add(detailDTO);
						}
					}
					unitDTO.setChildren(lstDetailDTO);
					lstUnit.add(unitDTO);
				}
				pageResult.setList(lstUnit);
			}
			pageResult.setTotal(retResult.getObj().getTotalCount());
			pageResult.setPageSize(pageSize);
		}
		result.setData(pageResult);
		return result;
	}

	@RequestMapping(value = "/getOrder4Pay", method = {RequestMethod.GET,RequestMethod.POST})
	public IceAjaxResult<AgentOrder4PayDTO> getOrder4Pay(String orderId, UserInfo user
	)
	{
		IceAjaxResult<AgentOrder4PayDTO> result = new IceAjaxResult<AgentOrder4PayDTO>();
		ReturnValue<AgentOrder> retOrder = orderFeignClient.getByPrimaryKey(orderId);
		if(user==null || user.getUserStatus()!=1)
		{
			return IceAjaxResult.getFailResult("用户不存在");
		}
		if(retOrder.getCode()!=200 || retOrder.getObj()==null)
		{
			return IceAjaxResult.getFailResult("订单不存在");
		}
		AgentOrder4PayDTO dto = getOrder4Pay( retOrder.getObj(), user.getId());
		result.setData(dto);
		return result;
	}


	private AgentOrder4PayDTO getOrder4Pay(AgentOrder order,Integer userId)
	{
		ReturnValue<AgentInfo> retAgent = agentInfoFeignClient.getByUserId(userId);
		if(retAgent.getCode()!=200 || retAgent.getObj()==null)
		{
			 throw new BusinessException("用户信息错误，请联系管理员");
		}
		AgentInfo agent = retAgent.getObj();
		//payOrderFeignClient
		ReturnValue<Account> retAccount = accountFeignClient.getAccount(agent.getId().toString(), 1);
		if (retAccount.getCode() != 200) {
			throw new BusinessException("系统繁忙，请稍后再试！");
		}
		Account account = retAccount.getObj();
		if (retAccount.getObj()==null) {
			ReturnValue<Integer> retCreateAccount = accountFeignClient.createAccount(agent.getId().toString(), 1);
			if (retCreateAccount.getCode() != 200 || !IntUtil.isGreaterThanZero(retCreateAccount.getObj())) {
				throw new BusinessException("交易失败，请稍后再试");
			}
		}
		ReturnValue<Account> retGoodsAccount = accountFeignClient.getAccount(agent.getId().toString(), 2);
		if (retGoodsAccount.getCode() != 200) {
			throw new BusinessException("系统繁忙，请稍后再试！");
		}
		Account goodsAccount = retGoodsAccount.getObj();
		if (retGoodsAccount.getObj()==null) {
			ReturnValue<Integer> retCreateGoodsAccount = accountFeignClient.createAccount(agent.getId().toString(), 2);
			if (retCreateGoodsAccount.getCode() != 200 || !IntUtil.isGreaterThanZero(retCreateGoodsAccount.getObj())) {
				throw new BusinessException("交易失败，请稍后再试");
			}
		}
		return getOrder4Pay(order,account,goodsAccount);
	}

	private AgentOrder4PayDTO getOrder4Pay(AgentOrder order,Account account,Account goodsAccount)
	{
		AgentOrder4PayDTO dto = new AgentOrder4PayDTO();
		dto.setOrderId(order.getId());
		dto.setAccountAmount(0d);
		dto.setGoodsAccountAmount(0d);
		dto.setAccountPayAmount(0d);
		dto.setGoodsPayAmount(0d);
		BigDecimal accountAmount =new BigDecimal("0");
		BigDecimal goodsAccountAmount =new BigDecimal("0");
		if(account!=null && account.getBalance()!=null) {
			accountAmount = account.getBalance().setScale(2,BigDecimal.ROUND_DOWN);
			dto.setAccountAmount(accountAmount.doubleValue());
		}
		if(goodsAccount!=null && goodsAccount.getBalance()!=null) {
			goodsAccountAmount = goodsAccount.getBalance().setScale(2,BigDecimal.ROUND_DOWN);
			dto.setGoodsAccountAmount(goodsAccountAmount.doubleValue());
		}
		BigDecimal commonProductAmount = order.getCommonAmount().add(order.getCommonModifyAmount()).setScale(2,BigDecimal.ROUND_UP);
		BigDecimal coreProductAmount = order.getGoodsAmount().add(order.getGoodsModifyAmount()).setScale(2,BigDecimal.ROUND_UP);
		BigDecimal waitPayAmount = new BigDecimal("0");
		dto.setGoodsPayAmount(coreProductAmount.doubleValue());
		dto.setAccountPayAmount(dto.getAccountAmount());
		if(goodsAccountAmount.compareTo(coreProductAmount)<0)
		{
			dto.setGoodsPayAmount(goodsAccountAmount.doubleValue());
			waitPayAmount=coreProductAmount.subtract(goodsAccountAmount);
		}
		if(waitPayAmount.add(commonProductAmount).compareTo(accountAmount)<0)
		{
			dto.setAccountPayAmount(waitPayAmount.add(commonProductAmount).doubleValue());
			waitPayAmount =new BigDecimal("0");
		}
		else{
			waitPayAmount = waitPayAmount.add(commonProductAmount).subtract(accountAmount);
		}
		dto.setCommonProductAmount(commonProductAmount.doubleValue());
		dto.setCoreProductAmount(coreProductAmount.doubleValue());
		dto.setPayOrderId("");
		dto.setPayType(order.getPayType());
		dto.setRemark("");
		dto.setTotalAmount(order.getOrderAmount().doubleValue());
		dto.setWaitPayAmount(waitPayAmount.doubleValue());
		return dto;
	}
	@RequestMapping(value = "/commitPay", method = {RequestMethod.GET,RequestMethod.POST})
	public IceAjaxResult commitPay(String orderId,Double goodsPayAmount,Double accountPayAmount,UserInfo user)
	{
		IceAjaxResult result = new IceAjaxResult();
		ReturnValue<AgentOrder> retOrder = orderFeignClient.getByPrimaryKey(orderId);
		if(user==null || user.getUserStatus()!=1)
		{
			return IceAjaxResult.getFailResult("用户不存在");
		}
		if(retOrder.getCode()!=200 ||  retOrder.getObj()==null)
		{
			return IceAjaxResult.getFailResult("订单不存在");
		}
		AgentOrder order = retOrder.getObj();
		if(order.getOrderStatus()!=1 || (order.getPayStatus()!=null && order.getPayStatus()!=0 && order.getPayStatus()!=1))
		{
			return IceAjaxResult.getFailResult("当前订单状态不允许支付");
		}
		String payOrderId ="";
		ReturnValue<PayOrder> retPayOrder = payOrderFeignClient.getValidPayOrderByMerchantOrderId(orderId,1);
		if(retPayOrder.getCode()!=200)
		{
			return IceAjaxResult.getFailResult("支付失败，请稍后再试");
		}
		if(retPayOrder.getObj()!=null)
		{
			payOrderId = retPayOrder.getObj().getId();
		}
		ReturnValue<AgentInfo> retAgent = agentInfoFeignClient.getByUserId(user.getId());
		if(retAgent.getCode()!=200 || retAgent.getObj()==null)
		{
			throw new BusinessException("用户信息错误，请联系管理员");
		}
		AgentInfo agent = retAgent.getObj();
		//payOrderFeignClient
		ReturnValue<Account> retAccount = accountFeignClient.getAccount(agent.getId().toString(), 1);
		if (retAccount.getCode() != 200) {
			throw new BusinessException("系统繁忙，请稍后再试！");
		}
		Integer accountId =0;
		Account account = retAccount.getObj();
		if (account==null) {
			ReturnValue<Integer> retCreateAccount = accountFeignClient.createAccount(agent.getId().toString(), 1);
			if (retCreateAccount.getCode() != 200 || !IntUtil.isGreaterThanZero(retCreateAccount.getObj())) {
				throw new BusinessException("交易失败，请稍后再试");
			}
			accountId=retCreateAccount.getObj();
		}
		else{
			accountId = account.getId();
		}
		ReturnValue<Account> retGoodsAccount = accountFeignClient.getAccount(agent.getId().toString(), 2);
		if (retGoodsAccount.getCode() != 200) {
			throw new BusinessException("系统繁忙，请稍后再试！");
		}
		Integer goodsAccountId =0;
		Account goodsAccount = retGoodsAccount.getObj();
		if (goodsAccount==null) {
			ReturnValue<Integer> retCreateGoodsAccount = accountFeignClient.createAccount(agent.getId().toString(), 2);
			if (retCreateGoodsAccount.getCode() != 200 || !IntUtil.isGreaterThanZero(retCreateGoodsAccount.getObj())) {
				throw new BusinessException("交易失败，请稍后再试");
			}
			goodsAccountId=retCreateGoodsAccount.getObj();
		}
		else{
			goodsAccountId = goodsAccount.getId();
		}
		AgentOrder4PayDTO payDTO = getOrder4Pay( order, account, goodsAccount);

		if(goodsPayAmount==null)
		{
			goodsPayAmount=0d;
		}
		if(accountPayAmount==null)
		{
			accountPayAmount=0d;
		}
		if(!goodsPayAmount.equals(payDTO.getGoodsPayAmount())
			|| !accountPayAmount.equals(payDTO.getAccountPayAmount()))
		{
			throw new BusinessException("交易失败，请重新支付");
		}

		if(retPayOrder.getObj()==null) {
			PayOrder payOrder = new PayOrder();
			payOrder.setOrderType(1);
			payOrder.setMerchantOrderId(order.getId());
			payOrder.setPaySuccessTime(null);
			payOrder.setOrderStatus(1);
			payOrder.setOrigAmount(order.getOrderAmount());
			payOrder.setWaitPayAmount(order.getOrderAmount());
			payOrder.setCreateTime(new Date());
			payOrder.setAppName("");
			payOrder.setOperator("");
			payOrder.setOrderDesc("用户下单");
			payOrder.setOrderTitle("123");
			payOrder.setUpdateTime(new Date());
			payOrder.setOutAccountId(accountId);
			ReturnValue<String> retCreatePayOrder = payOrderFeignClient.createPayOrder(payOrder);
			if (retCreatePayOrder.getCode() != 200 || StringUtil.isTrimBlank(retCreatePayOrder.getObj())) {
				return IceAjaxResult.getFailResult("支付失败，请稍后再试");
			}
			payOrderId =retCreatePayOrder.getObj();
		}
		if(StringUtil.isTrimBlank(payOrderId))
		{
			return IceAjaxResult.getFailResult("支付失败，请稍后再试");
		}
		if(IntUtil.isGreaterThanZero(goodsAccountId) && payDTO.getGoodsPayAmount()>0) {
			ReturnValue retAccountPay = payOrderFeignClient.accountPay(payOrderId,goodsAccountId,BigDecimal.valueOf(payDTO.getGoodsPayAmount()),"");
			if (retAccountPay.getCode() != 200 ) {
				return IceAjaxResult.getFailResult(StringUtil.getErrorMsg(retAccountPay.getMsg()));
			}
		}
		if(IntUtil.isGreaterThanZero(accountId) && payDTO.getAccountPayAmount()>0) {
			ReturnValue retAccountPay = payOrderFeignClient.accountPay(payOrderId,accountId,BigDecimal.valueOf(payDTO.getAccountPayAmount()),"");
			if (retAccountPay.getCode() != 200 ) {
				return IceAjaxResult.getFailResult(StringUtil.getErrorMsg(retAccountPay.getMsg()));
			}
		}
		result.setMessage("支付成功");
		return result;
	}

	private String getOrderStatusName(Integer status,Integer payStatus)
	{
		String statusName ="未知";
		if(!IntUtil.isGreaterThanZero(status))
		{
			return statusName;
		}
		//1：下单 2：等待发货 3：等待收货 4：订单完成 5：订单取消
		switch (status)
		{
			case 1:
				if(payStatus==null || payStatus<2)
				{
					statusName="等待付款";
				}
				else
				{
					statusName="等待确认";
				}
				break;
			case 2:statusName="等待发货";break;
			case 3:statusName="等待收货";break;
			case 4:statusName="订单完成";break;
			case 5:statusName="订单取消";break;
		}
		return statusName;
	}

	@RequestMapping(value = "/cancelOrder", method = {RequestMethod.POST})
	public IceAjaxResult cancelOrder(String id,UserInfo user
	) {
		if(StringUtil.isTrimBlank(id))
		{
			return IceAjaxResult.getFailResult("id非法");
		}
		if(user==null || user.getUserStatus()!=1)
		{
			return IceAjaxResult.getFailResult("用户不存在");
		}
		ReturnValue<AgentOrder> retOrder = orderFeignClient.getByPrimaryKey(id);
		if(retOrder.getCode()!=200 || retOrder.getObj()==null )
		{
			return IceAjaxResult.getFailResult("订单不存在");
		}
		AgentOrder order =retOrder.getObj();
		if(!order.getUserId().equalsIgnoreCase(user.getId().toString()))
		{
			return IceAjaxResult.getFailResult("没有权限操作该订单");
		}
		ReturnValue<AgentOrder> ret = orderFeignClient.cancelOrderByUser(id,0,"");
		if(ret.getCode()!=200)
		{
			return IceAjaxResult.getFailResult(StringUtil.getErrorMsg(ret.getMsg()));
		}
		IceAjaxResult result = new IceAjaxResult();
		result.setMessage("取消成功");
		return result;
	}


	@RequestMapping(value = "/confirmOrderSucc", method = {RequestMethod.POST})
	public IceAjaxResult confirmOrderSucc(String id,UserInfo user
	) {
		if(StringUtil.isTrimBlank(id))
		{
			return IceAjaxResult.getFailResult("id非法");
		}
		if(user==null || user.getUserStatus()!=1)
		{
			return IceAjaxResult.getFailResult("用户不存在");
		}
		ReturnValue<AgentOrder> retOrder = orderFeignClient.getByPrimaryKey(id);
		if(retOrder.getCode()!=200 || retOrder.getObj()==null )
		{
			return IceAjaxResult.getFailResult("订单不存在");
		}
		AgentOrder order = retOrder.getObj();
		if(!order.getUserId().equalsIgnoreCase(user.getId().toString()))
		{
			return IceAjaxResult.getFailResult("没有权限操作该订单");
		}
		ReturnValue<AgentOrder> ret = orderFeignClient.confirmOrderSuccByUser(id);
		if(ret.getCode()!=200)
		{
			return IceAjaxResult.getFailResult(StringUtil.getErrorMsg(ret.getMsg()));
		}
		IceAjaxResult result = new IceAjaxResult();
		result.setMessage("订单完成");
		return result;
	}

	//endregion
}
