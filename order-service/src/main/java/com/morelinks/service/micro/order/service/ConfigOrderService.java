package com.morelinks.service.micro.order.service;

import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.exception.BusinessException;
import com.morelinks.core.model.Page;
import com.morelinks.core.model.QueryResult;
import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.core.util.GenIdUtil;
import com.morelinks.core.util.IntUtil;
import com.morelinks.feign.micro.inner.user.api.client.AgentInfoFeignClient;
import com.morelinks.feign.micro.inner.user.api.model.AgentInfo;
import com.morelinks.feign.micro.order.api.dto.ConfigOrder4Creator;
import com.morelinks.feign.micro.order.api.dto.SelectedProducts;
import com.morelinks.feign.micro.order.api.model.ConfigOrder;
import com.morelinks.feign.micro.order.api.model.ConfigOrderDiscountInfo;
import com.morelinks.feign.micro.order.api.model.ConfigOrderExtraInfo;
import com.morelinks.feign.micro.order.api.model.dto.Query4ConfigOrder;
import com.morelinks.service.micro.order.mapper.ConfigOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
@Service
public class ConfigOrderService extends BaseServiceWithQueryPage<ConfigOrder, String, ConfigOrderMapper> {
//private final  String phoneVerification="^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";

	@Autowired
	ConfigOrderDetailService configOrderDetailService;
	@Autowired
	AgentInfoFeignClient agentInfoFeignClient;
	@Autowired
	ConfigOrderDiscountInfoService discountInfoService;
	@Autowired
	ConfigOrderExtraInfoService extraInfoService;

	public ConfigOrder createrConfigOrder(ConfigOrder4Creator configOrder4Creator) {

		if (!IntUtil.isGreaterThanZero(configOrder4Creator.getUerId())) {
			throw new IllegalArgumentException("userId invalid");
		}

		if (configOrder4Creator.getOrderName() == null || "".equals(configOrder4Creator.getOrderName())) {

			throw new BusinessException("请输入项目名称");

		}
		if (configOrder4Creator.getConfigCategoryIds() == null || "".equals(configOrder4Creator.getConfigCategoryIds())) {
			throw new BusinessException("请选择功能列表");
		}
		if (configOrder4Creator.getCityId() == null || "".equals(configOrder4Creator.getCityId())) {

			throw new BusinessException("城市id不存在");
		}
		if (configOrder4Creator.getCustomerName() == null && "".equals(configOrder4Creator.getCustomerName())) {
			throw new BusinessException("请输入姓名");

		}

		if (configOrder4Creator.getCustomerTel() == null && "".equals(configOrder4Creator.getCustomerTel())) {
			throw new BusinessException("请输入手机号码");
		}

 /*   if(!configOrder4Creator.getCustomerTel().trim().matches(phoneVerification)){

        throw  new BusinessException("请输入正确手机号");
    }*/
		AgentInfo agentUserInfo = null;
		ReturnValue<AgentInfo> retAgent = agentInfoFeignClient.getByUserId(configOrder4Creator.getUerId());
		if (retAgent.getCode() != 200 || retAgent.getObj() == null) {
			throw new BusinessException("系统繁忙，请稍后再试");
		}
		agentUserInfo = retAgent.getObj();
		ConfigOrder configOrder = new ConfigOrder();
		configOrder.setAgentId(agentUserInfo.getId());
		configOrder.setId(GenIdUtil.getIdByTimeStamp(configOrder4Creator.getUerId().toString(), 16, false));
		configOrder.setUserId(configOrder4Creator.getUerId());
		configOrder.setProjectId(null);
		configOrder.setConfigCategoryIds(configOrder4Creator.getConfigCategoryIds());
		configOrder.setOrderStatus(0);
		configOrder.setCreateTime(new Date());
		configOrder.setUpdateTime(new Date());
		configOrder.setConfigPrintOrderId(null);
		configOrder.setOrderName(configOrder4Creator.getOrderName());
		configOrder.setCityId(configOrder4Creator.getCityId());
		configOrder.setProjectAddress(configOrder4Creator.getProjectAddress());
		configOrder.setCustomerName(configOrder4Creator.getCustomerName());
		configOrder.setCustomerTel(configOrder4Creator.getCustomerTel());
		configOrder.setDelStatus((byte) 0);
		configOrder.setInstallAmountType(2);
		configOrder.setDebugAmountType(2);
		configOrder.setTaxAmountType(1);
		if (this.insert(configOrder) == 0) {

			throw new BusinessException("系统繁忙，请稍后再试");
		}


		return configOrder;

	}

	public QueryResult<ConfigOrder> getQueryResultNew(Query4ConfigOrder query) {
		QueryResult<ConfigOrder> result = new QueryResult<>();

		List<ConfigOrder> list = this.mapper.queryPageResultNew(query);
		System.out.println(list);
		if (list == null) {

			throw new BusinessException("系统繁忙请稍再试");
		}
		result.setItems(list);
  /*  ConfigOrder configOrder = new ConfigOrder();
    configOrder.setUserId(query.getUerId());
    configOrder.setOrderName(query.getOrderName());
    configOrder.setCustomerName(query.getCustomerName());
    configOrder.setCustomerTel(query.getCustomerTel());
    configOrder.setOrderStatus(query.getOrderStatus());*/
		result.setTotalCount(this.mapper.queryPageResultCountNew(query));

		return result;
	}

	public Integer deleteProject(String orderId) {


		int RowNumber = this.deleteByPrimaryKey(orderId);
		SelectedProducts products = new SelectedProducts();
		products.setOrderId(orderId);
		int RowNumber1 = this.configOrderDetailService.deleteDetail(products);
		ConfigOrderDiscountInfo orderDiscountInfo = new ConfigOrderDiscountInfo();
		orderDiscountInfo.setConfigOrderId(orderId);
		int RowNumber2 = this.discountInfoService.deleteByPrimaryKeySelective(orderDiscountInfo);
		ConfigOrderExtraInfo discountInfo = new ConfigOrderExtraInfo();
		discountInfo.setConfigOrderId(orderId);
		int RowNumber3 = this.extraInfoService.deleteByOrderExtraInfo(discountInfo);
		return RowNumber3;
	}


}