package com.morelinks.service.micro.agent.manage.controller.api.ice.configorder;

import com.alibaba.fastjson.JSON;
import com.morelinks.core.dto.*;
import com.morelinks.core.model.Page;
import com.morelinks.core.model.QueryResult;
import com.morelinks.core.util.DateUtil;
import com.morelinks.core.util.GenIdUtil;
import com.morelinks.core.util.IntUtil;
import com.morelinks.core.util.StringUtil;
import com.morelinks.core.webutil.ResourceUtil;
import com.morelinks.feign.micro.inner.user.api.client.AgentInfoFeignClient;
import com.morelinks.feign.micro.inner.user.api.model.AgentInfo;
import com.morelinks.feign.micro.inner.user.api.model.UserInfo;
import com.morelinks.feign.micro.order.api.client.*;
import com.morelinks.feign.micro.order.api.dto.ConfigOrder4Creator;
import com.morelinks.feign.micro.order.api.dto.QuerySelectedProducts;
import com.morelinks.feign.micro.order.api.dto.SelectedProducts;
import com.morelinks.feign.micro.order.api.model.*;
import com.morelinks.feign.micro.order.api.model.dto.PrintingDTO;
import com.morelinks.feign.micro.order.api.model.dto.Query4ConfigOrder;
import com.morelinks.feign.micro.product.api.client.*;
import com.morelinks.feign.micro.product.api.model.*;
import com.morelinks.service.micro.agent.manage.controller.api.ice.mall.CommonController;
import com.morelinks.service.micro.agent.manage.dto.CategoryDTO;
import com.morelinks.service.micro.agent.manage.dto.ExtraDiscountDTO;
import com.morelinks.service.micro.agent.manage.dto.MeteringDTO;
import com.morelinks.service.micro.agent.manage.dto.PackagingProduct;
import com.morelinks.service.micro.agent.manage.dto.configorder.*;
import com.morelinks.service.micro.agent.manage.dto.mall.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//import com.sun.deploy.util.StringUtils;
import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Pattern;

/**
 * 配单列表页
 */
@RestController
@RequestMapping("/api/config/order")
public class ConfigOrderController {
	@Autowired
	ConfigProductCategoryController categoryController;
	@Autowired
	ConfigOrderFeignClient configOrderFeignClient;
	@Autowired
	ConfigOrderDetailFeignClient configOrderDetailFeignClient;
	@Autowired
	ConfigProductFeignClient productFeignClient;
	@Autowired
	ConfigProductAgentExtraFeignClient extraFeignClient;
	@Autowired
	ConfigCategoryFeignClient configCategoryFeignClient;
	@Autowired
	ProductBrandFeignClient productBrandFeignClient;
	@Autowired
	ConfigOrderDiscountInfoFeignClient discountInfoFeignClient;
	@Autowired
	ConfigOrderExtraInfoClient extraInfoClient;
	@Autowired
	CommonController commonController;
	@Autowired
	ConfigProductPropertyMapFeignClient configProductPropertyMapFeignClient;
	@Autowired
	ConfigProductPropertyFeignClient propertyFeignClient;
	@Autowired
	AgentInfoFeignClient agentInfoFeignClient;
	@Autowired
	TemplatePdfClient pdfClient;
	@Autowired
	ConfigPrintOrderDetailFeignClient printOrderDetail;
	@Autowired
	ConfigPrintOrderFeignClient printOrder;
	@Autowired
	ConfigPrintOrderExtraInfoClient printExtraInfoClient;
	@Autowired
	ResourceUtil resourceUtil;
	/**
	 * 获取配单列表
	 *
	 * @param page
	 * @param pageSize
	 * @param userInfo
	 * @return 搜索框
	 */

	@RequestMapping(value = "/getOrderList", method = {RequestMethod.GET, RequestMethod.POST})
	public IceAjaxResult<IcePageData<ConfigOrderListUnit>> getOrderList(
			String searchParam, String orderStatus,
			Integer page, Integer pageSize, UserInfo userInfo
	) {
		IceAjaxResult<IcePageData<ConfigOrderListUnit>> result = new IceAjaxResult<>();
		IcePageData<ConfigOrderListUnit> data = new IcePageData<>();
		List<ConfigOrderListUnit> listUnits = new ArrayList<>();
		data.setCurrentPage(page);
		data.setPageSize(pageSize);
		data.setList(listUnits);
		result.setData(data);
		result.setMessage("");
		data.setTotal(0);
		if (userInfo == null || userInfo.getUserStatus() != 1) {
			return IceAjaxResult.getFailResult("用户不存在");
		}
		Query4ConfigOrder query4ConfigOrder = new Query4ConfigOrder();
		System.out.println(JSON.toJSONString(query4ConfigOrder.getPage()));
		query4ConfigOrder.setUerId(userInfo.getId());
		query4ConfigOrder.setIsDelete((byte) 0);
		if ((StringUtil.isNotTrimBlank(searchParam))) {
			query4ConfigOrder.setCustomerTel(searchParam);
			query4ConfigOrder.setCustomerName(searchParam);
			query4ConfigOrder.setOrderName(searchParam);
		}
		if (StringUtil.isNotTrimBlank(orderStatus) && orderStatus.matches("[0-4]")) {
			query4ConfigOrder.setOrderStatus(Integer.parseInt(orderStatus));
		}

		query4ConfigOrder.getPage().setOffset((page - 1) * pageSize);
		query4ConfigOrder.getPage().setLimit(pageSize);
		ReturnValue<QueryResult<ConfigOrder>> queryResultNew = this.configOrderFeignClient.getQueryResultNew(query4ConfigOrder);
		System.out.println(JSON.toJSONString(queryResultNew.getObj().getItems()));
		if (queryResultNew == null || queryResultNew.getCode() != 200) {
			return IceAjaxResult.getFailResult("系统繁忙请稍后再试");
		}
		if (queryResultNew.getObj() == null) {
			return result;
		}
		for (ConfigOrder order : queryResultNew.getObj().getItems()) {
			ConfigOrderListUnit configOrderUnit = new ConfigOrderListUnit();
			configOrderUnit.setOrderId(order.getId());
			configOrderUnit.setCustomerName(order.getCustomerName());
			configOrderUnit.setCustomerTel(order.getCustomerTel());
			configOrderUnit.setOrderName(order.getOrderName());
			configOrderUnit.setOrderStatus(order.getOrderStatus());
			List<String> lstCategory = new ArrayList<>();
			if (StringUtil.isNotTrimBlank(order.getConfigCategoryIds())) {
				for (String id : order.getConfigCategoryIds().split(",")) {
					ReturnValue<ConfigCategory> retCategory = this.configCategoryFeignClient.getByPrimaryKey(Integer.parseInt(id));
					if (retCategory.getCode() != 200 || retCategory.getObj() == null) {
						continue;
					}
					lstCategory.add(retCategory.getObj().getCategoryName());
				}
			}
			configOrderUnit.setLstCategoryName(lstCategory);
			configOrderUnit.setFullAddress(order.getProjectAddress());
			configOrderUnit.setOrderTime(DateUtil.format(order.getCreateTime(), "yyyy年MM月dd日"));
			listUnits.add(configOrderUnit);
		}
		data.setTotal(queryResultNew.getObj().getTotalCount());
		return result;


	}

	/*
	 *
	 * 修改订单状态
	 * */
	@RequestMapping(value = "/modifyStatus", method = {RequestMethod.GET, RequestMethod.POST})
	public IceAjaxResult modifyStatus(String orderId, String state, UserInfo user) {
		if (user == null || user.getUserStatus() != 1) {
			return IceAjaxResult.getFailResult("用户不存在");

		}
		if (orderId == null || "".equals(orderId.trim())) {
			return IceAjaxResult.getFailResult("无效订单信息");
		}
		if (!state.trim().matches("[0-4]")) {
			return IceAjaxResult.getFailResult("状态信息错误");
		}
		ReturnValue<ConfigOrder> retOrder = this.configOrderFeignClient.getByPrimaryKey(orderId);
		if (retOrder.getObj() == null) {
			return IceAjaxResult.getFailResult("项目不存在");
		}
		ConfigOrder order = retOrder.getObj();
		order.setId(orderId);
		order.setOrderStatus(Integer.parseInt(state));
		order.setUpdateTime(new Date());
		ReturnValue<Integer> returnValue = this.configOrderFeignClient.updateByPrimaryKey(order);
		if (returnValue.getObj() == 0) {
			return IceAjaxResult.getFailResult("更新失败");

		}
		IceAjaxResult result = new IceAjaxResult();
		result.setMessage("");
		return result;
	}


	/*
	 * 统计供需数量
	 *
	 * */
	@RequestMapping(value = "/getStatistics", method = {RequestMethod.GET, RequestMethod.POST})
	public IceAjaxResult<List<MeteringDTO>> getStatistics(String orderId, UserInfo user) {
		if (user == null || user.getUserStatus() != 1) {
			return IceAjaxResult.getFailResult("用户不存在");

		}
		if (orderId == null || "".equals(orderId.trim())) {
			return IceAjaxResult.getFailResult("无效订单信息");
		}
		ConfigOrderDetail orderDetail = new ConfigOrderDetail();
		orderDetail.setOrderId(orderId);
		QueryPageParam<ConfigOrderDetail> pageParam = new QueryPageParam<>();
		pageParam.setQuery(orderDetail);
		ReturnValue<QueryResult<ConfigOrderDetail>> returnValue = this.configOrderDetailFeignClient.getQueryResult(pageParam);
		IceAjaxResult<List<MeteringDTO>> result = new IceAjaxResult<>();
		List<ConfigOrderDetail> detailList = returnValue.getObj().getItems();

		List<Integer> listId = new ArrayList<>();
		Map<Integer, Integer> record = new HashMap<>();
		for (ConfigOrderDetail obj : detailList) {
			listId.add(obj.getProductId());
			record.put(obj.getProductId(), obj.getProductNum());

		}

		Map<String, MeteringDTO> mapMeteringDTO = new HashMap<>();
		List<ConfigProductPropertyMap> mapList = this.configProductPropertyMapFeignClient.queryPageResultNew(listId).getObj();
		if (mapList == null || mapList.size() == 0) {
			result.setData(new ArrayList<>());
			result.setMessage("");
			return result;
		}
		for (ConfigProductPropertyMap map : mapList) {

			MeteringDTO meteringDTO = null;
			if (!mapMeteringDTO.containsKey(map.getPropertyId())) {
				meteringDTO = new MeteringDTO();
				meteringDTO.setNeed(0);
				meteringDTO.setPossess(0);
				meteringDTO.setNeedAll(0);
				ReturnValue<ConfigProductProperty> propertyReturnValue = this.propertyFeignClient.getByPrimaryKey(Integer.parseInt(map.getPropertyId()));

				meteringDTO.setName(propertyReturnValue.getObj().getPropertyName());
				mapMeteringDTO.put(map.getPropertyId(), meteringDTO);
			}
			meteringDTO = mapMeteringDTO.get(map.getPropertyId());
			int calNum = map.getPropertyNum() * (record.get(map.getMapId()) == null ? 0 : record.get(map.getMapId()));
			if (map.getNeedOfferStatus() == 1) {
				meteringDTO.setNeedAll(meteringDTO.getNeedAll() + calNum);
			}
			if (map.getNeedOfferStatus() == 2) {
				meteringDTO.setPossess(meteringDTO.getPossess() + calNum);
			}
			meteringDTO.getNeed();
		}
		List<MeteringDTO> dtoList = new ArrayList<>();
		dtoList.addAll(mapMeteringDTO.values());
		result.setData(dtoList);
		result.setMessage("");

		return result;

	}

	/*
	 * 设置折扣
	 *
	 * */
	@RequestMapping(value = "/putDiscount", method = {RequestMethod.GET, RequestMethod.POST})
	public IceAjaxResult putDiscount(String orderId, String classifyId, String percentage, UserInfo user) {
		if (user == null || user.getUserStatus() != 1) {
			return IceAjaxResult.getFailResult("用户不存在");

		}
		if (orderId == null || "".equals(orderId.trim())) {
			return IceAjaxResult.getFailResult("无效订单信息");
		}
		if(isLegal(percentage).getData().booleanValue()){
			return  new IceAjaxResult("",isLegal(percentage).getMessage());
		}
		BigDecimal decimal = new BigDecimal(percentage).divide(new BigDecimal("100"));
		percentage = decimal.toString();
		ConfigOrderDiscountInfo discountInfo = new ConfigOrderDiscountInfo();
		discountInfo.setConfigOrderId(orderId);
		discountInfo.setDiscountType(1);
		discountInfo.setDiscountKey(classifyId);
		ConfigOrderDiscountInfo orderDiscountInfo = null;
		orderDiscountInfo = this.discountInfoFeignClient.findTop1(discountInfo).getObj();
		ConfigOrderDiscountInfo discount = new ConfigOrderDiscountInfo();
		discount.setDiscountType(1);
		discount.setConditionType(1);
		discount.setDiscountKey(classifyId);
		discount.setFromType(2);
		ConfigOrderDiscountInfo defaultDiscount = this.discountInfoFeignClient.findTop1(discount).getObj();
		discount.setFromType(1);
		ConfigOrderDiscountInfo agentDiscount = this.discountInfoFeignClient.findTop1(discount).getObj();
		Double amount1 = defaultDiscount == null ? -1 : defaultDiscount.getConditionAmount().doubleValue();
		Double amount2 = agentDiscount == null ? -1 : agentDiscount.getConditionAmount().doubleValue();
		IceAjaxResult result = new IceAjaxResult();
		Boolean isDefault = true;//是否为默认代理商和迈联折扣
		if (percentage.equals(amount1.toString()) || percentage.equals(amount2.toString())) {
			isDefault = false;
		}
		if (orderDiscountInfo != null) {

			if (isDefault) {
				if (orderDiscountInfo.getConditionAmount() != new BigDecimal(percentage)) {

					orderDiscountInfo.setConditionAmount(new BigDecimal(percentage));

					this.discountInfoFeignClient.updateByPrimaryKey(orderDiscountInfo);
				}
				result.setMessage("更新成功");


			} else {
				this.discountInfoFeignClient.deleteByPrimaryKey(orderDiscountInfo.getId());
				result.setMessage("更新成功");

			}


		} else {
			if (isDefault) {
				ConfigOrderDiscountInfo discountInfo1 = new ConfigOrderDiscountInfo();
				discountInfo1.setConfigOrderId(orderId);
				discountInfo1.setConditionType(1);
				discountInfo1.setDiscountType(1);
				discountInfo1.setDiscountKey(classifyId);
				discountInfo1.setConditionAmount(new BigDecimal(percentage));
				this.discountInfoFeignClient.insert(discountInfo1);
			}
			result.setMessage("创建成功");

		}
		return result;
	}



/*
 * 系统费用设置
 *
 *
 * */

	@RequestMapping(value = "/putCostSetup", method = {RequestMethod.POST})
	public IceAjaxResult putCostSetup(@RequestBody ExtraDiscountDTO discountDTO, UserInfo user) {
		if (user == null || user.getUserStatus() != 1) {
			return IceAjaxResult.getFailResult("用户不存在");
		}
		if (discountDTO == null) {

			return IceAjaxResult.getFailResult("请设置表单信息");
		}
		if(isLegal(discountDTO.getEquipment()).getData().booleanValue()||
			isLegal(discountDTO.getDebugging()).getData().booleanValue()||
			isLegal(discountDTO.getTaxation()).getData().booleanValue()
		){

			return  new IceAjaxResult("","非法输入：请输入两位数百分比");

		}
		ReturnValue<AgentInfo> returnValue = this.agentInfoFeignClient.getByUserId(user.getId());
		QueryPageParam<ConfigOrderExtraInfo> pageParam = new QueryPageParam<>();
		ConfigOrderExtraInfo extra = new ConfigOrderExtraInfo();
		extra.setAgentId(returnValue.getObj().getId());
		pageParam.setQuery(extra);
		ReturnValue<QueryResult<ConfigOrderExtraInfo>> resultReturnValue = this.extraInfoClient.getQueryResult(pageParam);
		List<ConfigOrderExtraInfo> extraInfoList = resultReturnValue.getObj().getItems();
		int[] type = {1, 2, 3};//1：设备安装 2：设备调试 3：增值税 4:其他费用
		if (extraInfoList.size() == 0) {
			for (int i = 0; i < type.length; i++) {
				ConfigOrderExtraInfo extraInfo = new ConfigOrderExtraInfo();
				extraInfo.setAgentId(returnValue.getObj().getId());
				switch (type[i]) {
					case 1:
						extraInfo.setExtraAmount(getConvert(discountDTO.getEquipment()));
						extraInfo.setConditionType(2);
						break;
					case 2:
						extraInfo.setExtraAmount(getConvert(discountDTO.getDebugging()));
						extraInfo.setConditionType(2);
						break;
					case 3:
						extraInfo.setExtraAmount(getConvert(discountDTO.getTaxation()));
						break;
				}
				extraInfo.setExtraType(type[i]);
				extraInfo.setMapType(0);
				extraInfo.setCreateTime(new Date());
				extraInfo.setUpdateTime(new Date());
				this.extraInfoClient.insert(extraInfo);

			}


		} else {
			for (ConfigOrderExtraInfo extraInfo : extraInfoList) {
				switch (extraInfo.getExtraType()) {
					case 1:
						extraInfo.setExtraAmount(getConvert(discountDTO.getEquipment()));
						break;
					case 2:
						extraInfo.setExtraAmount(getConvert(discountDTO.getDebugging()));
						break;
					case 3:
						extraInfo.setExtraAmount(getConvert(discountDTO.getTaxation()));
						break;
				}
				this.extraInfoClient.updateByPrimaryKey(extraInfo);
			}


		}

		IceAjaxResult result = new IceAjaxResult();
		result.setMessage("");
		return result;
	}


	/*
	 * 获取系统费用设置
	 *
	 * */
	@RequestMapping(value = "/getCostSetup", method = {RequestMethod.POST})
	public IceAjaxResult<ExtraDiscountDTO> getCostSetup(UserInfo user) {
		if (user == null || user.getUserStatus() != 1) {
			return IceAjaxResult.getFailResult("用户不存在");
		}
		IceAjaxResult<ExtraDiscountDTO> result = new IceAjaxResult<>();
		QueryPageParam<ConfigOrderExtraInfo> pageParam = new QueryPageParam<>();
		ConfigOrderExtraInfo extraInfo = new ConfigOrderExtraInfo();
		AgentInfo info = this.agentInfoFeignClient.getByUserId(user.getId()).getObj();
		extraInfo.setAgentId(info.getId());
		pageParam.setQuery(extraInfo);
		ReturnValue<QueryResult<ConfigOrderExtraInfo>> returnValue = this.extraInfoClient.getQueryResult(pageParam);
		ExtraDiscountDTO discountDTO = new ExtraDiscountDTO();
		List<ConfigOrderExtraInfo> extraInfoList;
		if (returnValue.getObj().getItems().size() != 0) {
			extraInfoList = returnValue.getObj().getItems();

		} else {
			extraInfo.setAgentId(0);
			ReturnValue<QueryResult<ConfigOrderExtraInfo>> returnExtraInfo = this.extraInfoClient.getQueryResult(pageParam);
			extraInfoList = returnExtraInfo.getObj().getItems();
		}
		for (ConfigOrderExtraInfo obj : extraInfoList) {
			switch (obj.getExtraType()) {
				case 1:
					discountDTO.setEquipment(getPercentage(obj.getExtraAmount()).toString());
					break;
				case 2:
					discountDTO.setDebugging(getPercentage(obj.getExtraAmount()).toString());
					break;
				case 3:
					discountDTO.setTaxation(getPercentage(obj.getExtraAmount()).toString());
					break;
			}
		}
		result.setData(discountDTO);
		result.setMessage("");
		return result;
	}


	/*
	 * 报价模板参数设置
	 *
	 * */
	@RequestMapping(value = "/setTemplate", method = {RequestMethod.GET, RequestMethod.POST})
	public IceAjaxResult setTemplate(@RequestBody TemplatePdfDTO obj, UserInfo user) {
		if (user == null || user.getUserStatus() != 1) {
			return IceAjaxResult.getFailResult("用户不存在");
		}
		if (obj == null) {
			return IceAjaxResult.getFailResult("请填写表单信息");
		}
		IceAjaxResult result = new IceAjaxResult();
		AgentInfo agentInfo = this.agentInfoFeignClient.getByUserId(user.getId()).getObj();
		TemplatePdf pdf = new TemplatePdf();
		pdf.setAgentId(agentInfo.getId());
		TemplatePdf templatePdf = null;
		templatePdf = this.pdfClient.getTop1(pdf).getObj();
		if (templatePdf == null) {
			pdf.setUserId(user.getId());
			pdf.setFooterMessage(obj.getFooterMessage());
			pdf.setHeaderMessage(obj.getHeaderMessage());
			pdf.setTipsMessage(obj.getTipsMessage());
			pdf.setWatermarkMessage(obj.getWatermarkMessage());
			pdf.setCreateTime(new Date());
			pdf.setUpdateTime(new Date());
			this.pdfClient.insert(pdf);
			result.setMessage("创建成功");
		} else {
			templatePdf.setFooterMessage(obj.getFooterMessage());
			templatePdf.setHeaderMessage(obj.getHeaderMessage());
			templatePdf.setTipsMessage(obj.getTipsMessage());
			templatePdf.setWatermarkMessage(obj.getWatermarkMessage());
			templatePdf.setUpdateTime(new Date());
			this.pdfClient.updateByPrimaryKey(templatePdf);
			result.setMessage("更新成功");
		}
		return result;

	}

	/*
	 * 报价参数模板获取
	 * */
	@RequestMapping(value = "/getTemplate", method = {RequestMethod.GET, RequestMethod.POST})
	public IceAjaxResult<TemplatePdfDTO> getTemplate(UserInfo user) {
		if (user == null || user.getUserStatus() != 1) {
			return IceAjaxResult.getFailResult("用户不存在");
		}
		IceAjaxResult<TemplatePdfDTO> result = new IceAjaxResult<>();
		AgentInfo agentInfo = this.agentInfoFeignClient.getByUserId(user.getId()).getObj();
		TemplatePdf pdf = new TemplatePdf();
		pdf.setAgentId(agentInfo.getId());
		TemplatePdf pdf1 = this.pdfClient.getTop1(pdf).getObj();
		TemplatePdfDTO templatePdfDTO = new TemplatePdfDTO();
		if (pdf1 == null) {
			result.setData(templatePdfDTO);
			result.setMessage("");
		} else {

			templatePdfDTO.setWatermarkMessage(pdf1.getWatermarkMessage());
			templatePdfDTO.setTipsMessage(pdf1.getTipsMessage());
			templatePdfDTO.setHeaderMessage(pdf1.getHeaderMessage());
			templatePdfDTO.setFooterMessage(pdf1.getFooterMessage());
			result.setData(templatePdfDTO);
			result.setMessage("");
		}
		return result;
	}


	/*
	 * 订单打印
	 *
	 * */
	@RequestMapping(value = "/printingOrder", method = {RequestMethod.POST})
	public IceAjaxResult printingOrder(String orderId, UserInfo user) {
		if (user == null || user.getUserStatus() != 1) {
			return IceAjaxResult.getFailResult("用户不存在");
		}

		AgentInfo agentInfo = this.agentInfoFeignClient.getByUserId(user.getId()).getObj();
		ConfigPrintOrder printOrder = new ConfigPrintOrder();
		ConfigOrder order = this.configOrderFeignClient.getByPrimaryKey(orderId).getObj();
		ConfigOtherAmountSetForm form = this.getOtherAmountSetForm(orderId, user).getData();
		ConfigTotalSelectedProductDTO productDTO = this.getTotalSelectedProductDTO(orderId, user).getData();
		printOrder.setId(GenIdUtil.getIdByTimeStamp(user.getId().toString(), 18, false));
		printOrder.setAgentId(agentInfo.getId());
		printOrder.setProjectId(order.getProjectId());
		printOrder.setConfigCategoryIds(order.getConfigCategoryIds());
		printOrder.setOrderStatus(order.getOrderStatus());
		printOrder.setOriMount(productDTO.getProductTotalAmount());
		printOrder.setFinalAmount(productDTO.getTotalAmount());
		printOrder.setDiscountType(1);
		printOrder.setCreateTime(new Date());
		printOrder.setUpdateTime(new Date());
		printOrder.setInstallAmountType(form.getInstallAmountType());
		printOrder.setDebugAmountType(form.getDebugAmountType());
		printOrder.setTaxAmountType(form.getTaxType());

		QueryPageParam<ConfigOrderDetail> pageParam = new QueryPageParam<>();
		ConfigOrderDetail orderDetail = new ConfigOrderDetail();
		orderDetail.setOrderId(orderId);
		pageParam.setQuery(orderDetail);
		List<ConfigOrderDetail> detailList = this.configOrderDetailFeignClient.getQueryResult(pageParam).getObj().getItems();
		List<ConfigSelectedProductListUnit> listUnits = this.getSelectedProductList(orderId, 1, 10000, user).getData().getList();
		List<ConfigPrintOrderDetail> printOrderDetailsList = new ArrayList<>();
		List<ConfigPrintOrderExtraInfo> printOrderExtraInfos = new ArrayList<>();
		if (listUnits.size() != 0) {
			for (ConfigSelectedProductListUnit unit : listUnits) {
				ConfigPrintOrderDetail detaiPrint = new ConfigPrintOrderDetail();
				detaiPrint.setOrderId(orderId);
				detaiPrint.setMapKey(Integer.parseInt(unit.getProductId()));
				detaiPrint.setMapType(unit.getProductType());
				detaiPrint.setMapName(unit.getProductName());
				detaiPrint.setNum(Integer.parseInt(unit.getProductNum()));
				detaiPrint.setOriMount(new BigDecimal(unit.getProductAmount()));
				printOrderDetailsList.add(detaiPrint);

			}
			for (ConfigOrderDetail obj : detailList) {
				for (ConfigPrintOrderDetail unit : printOrderDetailsList) {
					if (obj.getProductId().toString().equals(unit.getMapKey().toString())) {
						BigDecimal amount = new BigDecimal(0);
						amount = this.getSystemCategoryDiscount(orderId, obj.getFirstCategory().toString());
						unit.setFinalAmount(unit.getOriMount().multiply(amount).setScale(2, BigDecimal.ROUND_HALF_UP));
						unit.setDiscountType(1);
						ReturnValue<ConfigProduct> retProduct = productFeignClient.getByPrimaryKey(unit.getMapKey());
						if(retProduct.getObj()==null)
						{
							return IceAjaxResult.getFailResult("有商品不存在，请核查");
						}
						ProductBrand brand = this.productBrandFeignClient.getByPrimaryKey(retProduct.getObj().getBrandId()).getObj();
						ConfigCategory category = this.configCategoryFeignClient.getByPrimaryKey(retProduct.getObj().getCategoryId()).getObj();
						unit.setBrandName(brand.getBrandName());
						unit.setBrandId(brand.getId());
						unit.setCategoryName(category.getCategoryName());
						unit.setCategoryId(category.getId());
						unit.setCreateTime(new Date());
						unit.setUpdateTime(new Date());
					}

				}

			}


		}
    /*
    * 是否有订单1：设备安装 2：设备调试 3：增值税
    * */
		Boolean install = true;
		Boolean debug = true;
		Boolean tax = true;
		Map<Integer, Boolean> booleanMap = new HashMap<>();
		booleanMap.put(1, install);
		booleanMap.put(2, debug);
		booleanMap.put(3, tax);
		QueryPageParam<ConfigOrderExtraInfo> queryParam = new QueryPageParam<>();
		ConfigOrderExtraInfo extraInfo = new ConfigOrderExtraInfo();
		extraInfo.setConfigOrderId(orderId);
		queryParam.setQuery(extraInfo);
		List<ConfigOrderExtraInfo> extraInfoList = this.extraInfoClient.getQueryResult(queryParam).getObj().getItems();
		for (ConfigOrderExtraInfo obj : extraInfoList) {
			if (obj.getExtraType() == 1) {

				install = false;

			}
			if (obj.getExtraType() == 2) {
				debug = false;

			}
			if (obj.getExtraType() == 3) {
				tax = false;
			}
			ConfigPrintOrderExtraInfo extra = new ConfigPrintOrderExtraInfo();
			extra.setConfigOrderId(obj.getConfigOrderId());
			extra.setExtraType(obj.getExtraType());
			extra.setConditionType(obj.getConditionType());
			extra.setMapType(obj.getMapType());
			extra.setMapKey(obj.getMapKey());
			extra.setExtraAmount(obj.getExtraAmount());
			extra.setExtraName(obj.getExtraName());
			extra.setExtraRemark(obj.getExtraRemark());
			extra.setCreateTime(new Date());
			extra.setUpdateTime(new Date());
			printOrderExtraInfos.add(extra);
		}
		ReturnValue<ConfigOrderExtraInfo> value;
		ConfigOrderExtraInfo orderExtraInfo = null;
		ConfigPrintOrderExtraInfo printOrderExtraInfo;
		for (Integer type : booleanMap.keySet()) {
			if (booleanMap.get(type)) {
				orderExtraInfo = new ConfigOrderExtraInfo();
				orderExtraInfo.setAgentId(agentInfo.getId());
				orderExtraInfo.setExtraType(type);
				orderExtraInfo.setConditionType(2);
				orderExtraInfo.setMapType(0);
				value = this.extraInfoClient.findTop(orderExtraInfo);
				orderExtraInfo.setAgentId(0);
				value = value.getObj() == null ? this.extraInfoClient.findTop(orderExtraInfo) : value;
				printOrderExtraInfo = new ConfigPrintOrderExtraInfo();
				printOrderExtraInfo.setConfigOrderId(orderId);
				printOrderExtraInfo.setExtraType(value.getObj().getExtraType());
				printOrderExtraInfo.setConditionType(value.getObj().getConditionType());
				printOrderExtraInfo.setMapType(value.getObj().getMapType());
				printOrderExtraInfo.setMapKey(value.getObj().getMapKey());
				printOrderExtraInfo.setExtraAmount(value.getObj().getExtraAmount());
				printOrderExtraInfo.setExtraName(value.getObj().getExtraName());
				printOrderExtraInfo.setExtraRemark(value.getObj().getExtraRemark());
				printOrderExtraInfo.setCreateTime(new Date());
				printOrderExtraInfo.setUpdateTime(new Date());
				printOrderExtraInfos.add(printOrderExtraInfo);

			}

		}

		PrintingDTO printing = new PrintingDTO();
		printing.setOrder(printOrder);
		printing.setListDetail(printOrderDetailsList);
		printing.setListExtraInfo(printOrderExtraInfos);
		Integer effect = this.printOrder.PrintingOrder(printing).getObj();
		IceAjaxResult result = new IceAjaxResult();

		if (effect != null && effect > 0) {
			result.setMessage("打印成功");

		} else {
			result.setMessage("打印失败");
		}
		return result;
	}


	/**
	 * 获取订单表单
	 *
	 * @param orderId
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/getOrderForm", method = {RequestMethod.GET, RequestMethod.POST})
	public IceAjaxResult<ConfigOrderForm> getOrderForm(String orderId, UserInfo user) {
		IceAjaxResult<ConfigOrderForm> result = new IceAjaxResult<>();
		ConfigOrderForm configOrderForm = new ConfigOrderForm();
		if (user == null || user.getUserStatus() != 1) {
			return IceAjaxResult.getFailResult("用户不存在");
		}

		IceAjaxResult<CascaderSelectLstDTO> lstResult = this.commonController.getCascaderSelectCitys(user);
		CascaderSelectLstDTO selectLstDTO = lstResult.getData();
		QueryPageParam<ConfigCategory> param = new QueryPageParam<>();
		ConfigCategory category = new ConfigCategory();
		category.setParentId(-1);
		param.setQuery(category);
		ReturnValue<QueryResult<ConfigCategory>> QueryResult = this.configCategoryFeignClient.getQueryResult(param);
		List<ConfigCategory> categoryList = QueryResult.getObj().getItems();
		List<IceSelectData> iceSelectData = new ArrayList<>();
		for (ConfigCategory configCategory : categoryList) {
			IceSelectData data = new IceSelectData();
			data.setLabel(configCategory.getCategoryName());
			data.setValue(configCategory.getId().toString());
			iceSelectData.add(data);

		}
		if (orderId == null || "".equals(orderId.trim())) {
			ConfigOrderForm forms = new ConfigOrderForm();
			forms.setListCity(selectLstDTO.getList());
			forms.setLstCategory(iceSelectData);
			result.setData(forms);
			return result;
		}
		ReturnValue<ConfigOrder> configOrder = this.configOrderFeignClient.getByPrimaryKey(orderId);
		if (configOrder.getCode() != 200 || configOrder.getObj() == null) {

			return IceAjaxResult.getFailResult("订单号不存在");

		}
		configOrderForm.setId(configOrder.getObj().getId());
		configOrderForm.setOrderName(configOrder.getObj().getOrderName());
		configOrderForm.setCustomerTel(configOrder.getObj().getCustomerTel());
		configOrderForm.setCustomerName(configOrder.getObj().getCustomerName());
		configOrderForm.setLstCategorySelData(Arrays.asList(configOrder.getObj().getConfigCategoryIds().split(",")));
		configOrderForm.setLstCategory(iceSelectData);
		configOrderForm.setCityId(configOrder.getObj().getCityId());
		configOrderForm.setAddress(configOrder.getObj().getProjectAddress());
		configOrderForm.setListCity(selectLstDTO.getList());
		result.setData(configOrderForm);
		result.setMessage("");
		return result;
	}

	/**
	 * 提交订单
	 *
	 * @param form
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/submitOrder", method = {RequestMethod.POST})
	public IceAjaxResult submitOrder(@RequestBody ConfigOrderForm form, UserInfo user) {
		if (user == null || user.getUserStatus() != 1) {
			return IceAjaxResult.getFailResult("用户不存在");

		}
		if (form == null) {

			return IceAjaxResult.getFailResult("请确认订单信息");
		}
		if (StringUtil.isTrimBlank(form.getOrderName())) {

			return IceAjaxResult.getFailResult("请输入项目名称");
		}
		if (form.getCustomerName() == null) {
			return IceAjaxResult.getFailResult("请输入顾客姓名");

		}
		if (form.getCustomerTel() == null) {

			return IceAjaxResult.getFailResult("请输入顾客手机号");
		}
		if (form.getLstCategorySelData() == null) {

			return IceAjaxResult.getFailResult("请选择分类");
		}
		if (form.getCityId() == null) {

			return IceAjaxResult.getFailResult("请填写城市地址");
		}
		if (form.getAddress() == null) {

			return IceAjaxResult.getFailResult("请填写城市地址");
		}
		IceAjaxResult result = new IceAjaxResult();
		ConfigOrder4Creator configOrder4Creator = new ConfigOrder4Creator();
		configOrder4Creator.setCustomerName(form.getCustomerName());
		configOrder4Creator.setCustomerTel(form.getCustomerTel());
		configOrder4Creator.setUerId(user.getId());
		System.out.println(user.getId());
		String ids = "";
		int num = 0;
		for (String i : form.getLstCategorySelData()) {
			ids = ++num < form.getLstCategorySelData().size() ? ids + i + "," : ids + i;

		}
		configOrder4Creator.setConfigCategoryIds(ids);
		configOrder4Creator.setCityId(form.getCityId());
		configOrder4Creator.setProjectAddress(form.getAddress());
		configOrder4Creator.setOrderName(form.getOrderName());

		if (form.getId() == null || "".equals(form.getId())) {


			if (this.configOrderFeignClient.createrConfigOrder(configOrder4Creator).getObj() == null) {
				return IceAjaxResult.getFailResult("系统繁忙请稍后再试");
			}

			result.setMessage("创建成功");
			result.setData("");
			return result;
		} else {
			ConfigOrder configOrder = null;
			configOrder = this.configOrderFeignClient.getByPrimaryKey(form.getId()).getObj();
			configOrder.setCustomerName(form.getCustomerName());
			configOrder.setCustomerTel(form.getCustomerTel());
			configOrder.setOrderName(form.getOrderName());
			configOrder.setConfigCategoryIds(ids);
			configOrder.setCityId(form.getCityId());
			configOrder.setProjectAddress(form.getAddress());
			configOrder.setUpdateTime(new Date());
			this.configOrderFeignClient.updateByPrimaryKey(configOrder);
			result.setMessage("更新成功");
			result.setData("");
			return result;

		}

	}

	/**
	 * 删除订单
	 *
	 * @param orderId
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/deleteOrder", method = {RequestMethod.POST})
	public IceAjaxResult deleteOrder(String orderId, UserInfo user) {
		if (user == null || user.getUserStatus() != 1) {
			return IceAjaxResult.getFailResult("用户不存在");

		}
		if (orderId == null || "".equals(orderId.trim())) {
			return IceAjaxResult.getFailResult("无效订单信息");
		}
		IceAjaxResult result = new IceAjaxResult();
		ReturnValue<ConfigOrder> orderReturnValue = this.configOrderFeignClient.getByPrimaryKey(orderId);
		ConfigOrder configOrder = orderReturnValue.getObj();
		configOrder.setDelStatus((byte) 1);
		ReturnValue<Integer> returnValue = this.configOrderFeignClient.updateByPrimaryKey(configOrder);
		//ReturnValue<Integer> returnValue = this.configOrderFeignClient.deleteProject(orderId);
		if (returnValue.getCode() == 200) {
			result.setMessage("删除成功");
			return result;
		} else {
			return IceAjaxResult.getFailResult("删除失败");

		}


	}

	/**
	 * 添加商品
	 *
	 * @param orderId 订单Id
	 * @param id      id表示
	 * @param num     添加的数量 空值 或者 在0以下 则为添加 否则为更新数量
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/addProduct", method = {RequestMethod.POST})
	public IceAjaxResult addProduct(String orderId, String id, String num, UserInfo user) {
		if (user == null || user.getUserStatus() != 1) {
			return IceAjaxResult.getFailResult("用户不存在");

		}
		if (orderId == null || "".equals(orderId.trim())) {
			return IceAjaxResult.getFailResult("无效订单信息");
		}
		Integer productId = IntUtil.parseInt(id,false);
		if (!IntUtil.isGreaterThanZero(productId)) {

			return IceAjaxResult.getFailResult("商品信息非法");
		}
		if (this.configOrderFeignClient.getByPrimaryKey(orderId) == null) {
			return IceAjaxResult.getFailResult("无效订单信息");

		}
		ReturnValue<ConfigProduct> retProduct = productFeignClient.getByPrimaryKey(productId);
		ConfigProduct product = retProduct.getObj();
		if(product==null)
		{
			return IceAjaxResult.getFailResult("未知商品");
		}
		QueryPageParam<ConfigOrderDetail> configOrderDetailQueryPageParam = new QueryPageParam<>();
		ConfigOrderDetail orderDetail = new ConfigOrderDetail();
		orderDetail.setOrderId(orderId);
		orderDetail.setProductId(Integer.parseInt(id));
		configOrderDetailQueryPageParam.setQuery(orderDetail);
		List<ConfigOrderDetail> returnValue = this.configOrderDetailFeignClient.find(configOrderDetailQueryPageParam).getObj();
		ConfigOrderDetail orderDetail1 = new ConfigOrderDetail();
		boolean condition = true;
		if (returnValue != null) {
			if (returnValue.size() == 1) {

				orderDetail1 = returnValue.get(0);
				condition = false;
			}
		}
		if (Integer.parseInt(num) == 0) {
			this.configOrderDetailFeignClient.deleteByPrimaryKey(orderDetail1.getId());
			IceAjaxResult result = new IceAjaxResult();
			result.setMessage("删除成功");
			return result;
		}
		if (condition) {
			ConfigOrderDetail formOrderDetail = new ConfigOrderDetail();
			formOrderDetail.setId(GenIdUtil.getIdByTimeStamp(user.getId().toString(), 16, false));
			formOrderDetail.setProductId(Integer.parseInt(id));
			formOrderDetail.setOrderId(orderId);
			formOrderDetail.setCategoryId(product.getCategoryId());
			formOrderDetail.setFirstCategory(this.configCategoryFeignClient.getTopConfigCategory(product.getCategoryId()).getObj().getId());
			formOrderDetail.setCreateTime(new Date());
			formOrderDetail.setUpdateTime(new Date());
			formOrderDetail.setProductNum(Integer.parseInt(num));
			formOrderDetail.setProductType((int) this.productFeignClient.getByPrimaryKey(Integer.parseInt(id)).getObj().getProductType());
			ReturnValue<String> returnValue1 = this.configOrderDetailFeignClient.insert(formOrderDetail);
			if (returnValue1.getCode() != 200 || returnValue1.getObj() == null) {

				return IceAjaxResult.getFailResult("系统繁忙请稍后再试");
			}
			IceAjaxResult result = new IceAjaxResult();
			result.setMessage("");
			return result;
		} else {
			orderDetail1.setProductNum(Integer.parseInt(num));
			orderDetail1.setUpdateTime(new Date());
			ReturnValue<Integer> update = this.configOrderDetailFeignClient.updateByPrimaryKey(orderDetail1);
			if (update == null) {
				return IceAjaxResult.getFailResult("系统繁忙请稍后再试");

			}
			if (update.getObj() != 1) {

				return IceAjaxResult.getFailResult("系统繁忙请稍后再试");
			}
			IceAjaxResult result = new IceAjaxResult();
			result.setMessage("更新成功");
			return result;

		}



	}


	/**
	 * 获取选中的商品列表购物车列表
	 *
	 * @param orderId
	 * @param page
	 * @param pageSize
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/getSelectedProductList", method = {RequestMethod.GET, RequestMethod.POST})
	public IceAjaxResult<IcePageData<ConfigSelectedProductListUnit>> getSelectedProductList(
			String orderId, Integer page, Integer pageSize, UserInfo user
	) {
		if (user == null || user.getUserStatus() != 1) {
			return IceAjaxResult.getFailResult("用户不存在");

		}
		if (orderId == null || "".equals(orderId.trim())) {
			return IceAjaxResult.getFailResult("无效订单信息");
		}
		if (this.configOrderFeignClient.getByPrimaryKey(orderId) == null) {
			return IceAjaxResult.getFailResult("无效订单信息");

		}

		IceAjaxResult<IcePageData<ConfigSelectedProductListUnit>> result = new IceAjaxResult<>();
		IcePageData<ConfigSelectedProductListUnit> data = new IcePageData<>();
		QueryPageParam<ConfigOrderDetail> queryResult = new QueryPageParam<>();
		ConfigOrderDetail orderDetail = new ConfigOrderDetail();
		Page page1 = new Page();
		page1.setSort("update_time");
		page1.setOrder(Page.ORDER_DESC);
		page1.setLimit(pageSize);
		page1.setOffset((page - 1) * pageSize);
		orderDetail.setOrderId(orderId);
		queryResult.setQuery(orderDetail);
		queryResult.setPage(page1);
		ReturnValue<QueryResult<ConfigOrderDetail>> returnValue = this.configOrderDetailFeignClient.getQueryResult(queryResult);
		if (returnValue == null) {
			return IceAjaxResult.getFailResult("系统繁忙请稍后再试");
		}
		if (returnValue.getObj().getItems().size() == 0) {
			data.setList(new ArrayList<>());
			result.setData(data);
			result.setMessage("无选择商品");
			return result;
		}
		data.setPageSize(returnValue.getObj().getItems().size());
		data.setTotal((page - 1) * pageSize + returnValue.getObj().getItems().size());
		List<ConfigOrderDetail> listOrderDetail = returnValue.getObj().getItems();
		List<ConfigSelectedProductListUnit> listUnits = new ArrayList<>();
		for (ConfigOrderDetail obj : listOrderDetail) {
			ConfigSelectedProductListUnit productListUnit = new ConfigSelectedProductListUnit();
			productListUnit.setProductId(obj.getProductId().toString());
			productListUnit.setProductType(obj.getProductType());
			productListUnit.setProductNum(obj.getProductNum().toString());
			ReturnValue<ConfigProduct> retProduct = productFeignClient.getByPrimaryKey(obj.getProductId());
			if(retProduct.getCode()!=200)
			{
				return IceAjaxResult.getFailResult(StringUtil.getErrorMsg(retProduct.getMsg()));
			}
			ConfigProduct product = retProduct.getObj();
			if(product==null)
			{
				return IceAjaxResult.getFailResult("已添加商品存在已失效的，请核查");
			}
			ReturnValue<ProductBrand> retBrand =  productBrandFeignClient.getByPrimaryKey(product.getBrandId());
			if(retBrand.getObj()!=null)
			{
				productListUnit.setBrandName(retBrand.getObj().getBrandName().toString());
			}
			productListUnit.setLogoUrl(resourceUtil.getImgUrl(product.getLogoPath()));
			productListUnit.setModelName(product.getModelName());
			productListUnit.setId(obj.getId());
			productListUnit.setProductName(product.getProductName());
			productListUnit.setProductResume(product.getProductResume());
			ReturnValue<ConfigProductAgentExtra> extraReturnValue = this.extraFeignClient.getByPrimaryKey(product.getId());
			if (extraReturnValue == null) {
				return IceAjaxResult.getFailResult("系统繁忙请稍后再试");

			}

			if (extraReturnValue.getObj() != null) {
				productListUnit.setProductAmount(new BigDecimal(extraReturnValue.getObj().getAgentProductAmount().toString()).multiply(new BigDecimal(productListUnit.getProductNum())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());//默认价格和自定义价格

			} else {
				productListUnit.setProductAmount(product.getProductAmount().multiply(new BigDecimal(productListUnit.getProductNum())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
			}
			listUnits.add(productListUnit);
		}
		data.setList(listUnits);


		result.setData(data);
		result.setMessage("");
		return result;
	}


	/**
	 * 删除选中的商品
	 *
	 * @param orderId 订单Id
	 * @param ids     id列表 逗号分隔
	 * @param user
	 * @return
	 */


	@RequestMapping(value = "/deleteSelectedProducts", method = {RequestMethod.POST})
	public IceAjaxResult deleteSelectedProducts(String orderId, String ids, UserInfo user) {
		if (user == null || user.getUserStatus() != 1) {
			return IceAjaxResult.getFailResult("用户不存在");

		}
		if (orderId == null || "".equals(orderId.trim())) {
			return IceAjaxResult.getFailResult("无效订单信息");
		}
		if (this.configOrderFeignClient.getByPrimaryKey(orderId) == null) {
			return IceAjaxResult.getFailResult("无效订单信息");

		}
		if (ids == null || "".equals(ids.trim())) {

			return IceAjaxResult.getFailResult("未知商品信息");
		}
		String[] productId = ids.split(",");
		List<Integer> list = new ArrayList<>();
		for (String Product : productId) {
			list.add(Integer.parseInt(Product));

		}
		SelectedProducts selectedProducts = new SelectedProducts();
		selectedProducts.setOrderId(orderId);
		selectedProducts.setListId(list);
		System.out.println(selectedProducts);
		ReturnValue<Integer> returnValue = this.configOrderDetailFeignClient.deleteSelectedProducts(selectedProducts);
		if (returnValue == null) {

			return IceAjaxResult.getFailResult("系统繁忙请稍后再试");
		}
		System.out.println(returnValue.getObj());
		if (returnValue.getObj() == 0) {
			return IceAjaxResult.getFailResult("系统繁忙请稍后再试");

		}

		IceAjaxResult result = new IceAjaxResult();
		result.setMessage("删除成功");

		return result;
	}

	/**
	 * PackagingProductList
	 * 获取各类别统计的选择列表
	 *
	 * @param orderId
	 * @param categoryId 类别Id
	 * @param page
	 * @param pageSize
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/getSumSelectedProductList", method = {RequestMethod.GET, RequestMethod.POST})
	public IceAjaxResult<PackagingProduct> getSumSelectedProductList(
			String orderId, String categoryId, Integer page, Integer pageSize, UserInfo user
	) {

		IceAjaxResult result = new IceAjaxResult();
		IcePageData<ConfigSumSelectedProductListUnit> data = new IcePageData<>();
		List<ConfigSumSelectedProductListUnit> listUnits = new ArrayList<>();
		if (user == null || user.getUserStatus() != 1) {
			return IceAjaxResult.getFailResult("用户不存在");

		}
		if (orderId == null || "".equals(orderId.trim())) {
			return IceAjaxResult.getFailResult("无效订单信息");
		}
		if (this.configOrderFeignClient.getByPrimaryKey(orderId) == null) {
			return IceAjaxResult.getFailResult("无效订单信息");

		}
		if (categoryId == null || "".equals(categoryId.trim())) {

			return IceAjaxResult.getFailResult("未知分类信息");
		}
		List<Integer> list = new ArrayList<>();
		String[] strings = categoryId.split(",");
		for (String ids : strings) {
			list.add(Integer.parseInt(ids));

		}
		QuerySelectedProducts selectedProducts = new QuerySelectedProducts();
		selectedProducts.setListCategoryId(list);
		selectedProducts.setOrderId(orderId);
		Page page1 = new Page();
		page1.setOffset((page - 1) * pageSize);
		page1.setLimit(pageSize);
		selectedProducts.setPage(page1);
		ReturnValue<List<ConfigOrderDetail>> returnValue = this.configOrderDetailFeignClient.querySelectedProducts(selectedProducts);
		if (returnValue == null) {
			return IceAjaxResult.getFailResult("系统繁忙请稍后再试");

		}
		if (returnValue.getObj() == null) {
			return IceAjaxResult.getFailResult("系统繁忙请稍后再试");
		}
		if (returnValue.getObj().size() == 0) {
			data.setPageSize(0);
			data.setTotal(0);
			data.setCurrentPage(1);
			data.setList(new ArrayList<>());
			PackagingProduct packagingProduct = new PackagingProduct();
			packagingProduct.setIcePageData(data);
			packagingProduct.setTotal(new BigDecimal(0));
			result.setData(packagingProduct);
			result.setMessage("无商品信息");
			return result;

		}
		BigDecimal decimal = new BigDecimal(0);
		for (ConfigOrderDetail orderDetail : returnValue.getObj()) {
			ReturnValue<ConfigProduct> retProduct = productFeignClient.getByPrimaryKey(orderDetail.getProductId());
			if(retProduct.getCode()!=200)
			{
				return IceAjaxResult.getFailResult(StringUtil.getErrorMsg(retProduct.getMsg()));
			}
			ConfigProduct configProduct = retProduct.getObj();
			if(configProduct==null)
			{
				return IceAjaxResult.getFailResult("存在未知的商品");
			}
			ReturnValue<ProductBrand> retBrand = this.productBrandFeignClient.getByPrimaryKey(configProduct.getBrandId());
			if (retBrand.getObj() == null) {
				return IceAjaxResult.getFailResult("存在未知的品牌");
			}
			ReturnValue<ConfigCategory> retCategory = configCategoryFeignClient.getTopConfigCategory(configProduct.getCategoryId());
			if(retCategory.getCode()!=200)
			{
				return IceAjaxResult.getFailResult(StringUtil.getErrorMsg(retProduct.getMsg()));
			}
			if (retCategory.getObj() == null) {
				return IceAjaxResult.getFailResult("存在未知的系统");
			}
			ConfigSumSelectedProductListUnit unit = new ConfigSumSelectedProductListUnit();
			unit.setId(orderId);
			unit.setBrandName(retBrand.getObj().getBrandName());
			unit.setProductId(configProduct.getId().toString());
			unit.setProductName(configProduct.getProductName());
			unit.setLogoUrl(resourceUtil.getImgUrl(configProduct.getLogoPath()) );
			unit.setModelName(configProduct.getModelName());
			ReturnValue<ConfigProductAgentExtra> extraReturnValue = this.extraFeignClient.getByPrimaryKey(configProduct.getId());
			if (extraReturnValue == null) {
				return IceAjaxResult.getFailResult("系统繁忙请稍后再试");

			}
			if (extraReturnValue.getObj() != null) {
				unit.setProductAmount(extraReturnValue.getObj().getAgentProductAmount().toString());//默认价格和自定义价格

			} else {
				unit.setProductAmount(configProduct.getProductAmount().toString());
			}
			unit.setCategoryName(retCategory.getObj().getCategoryName());
			unit.setProductNum(orderDetail.getProductNum().toString());
			BigDecimal totalAmount = new BigDecimal(orderDetail.getProductNum()).multiply(new BigDecimal(unit.getProductAmount()));
			unit.setTotalAmount(totalAmount.toString());
			decimal = decimal.add(totalAmount);
			listUnits.add(unit);
		}
		data.setList(listUnits);
		data.setCurrentPage(page);
		data.setTotal(((page - 1) * pageSize) + returnValue.getObj().size());
		data.setPageSize(returnValue.getObj().size());
		PackagingProduct packagingProduct = new PackagingProduct();
		packagingProduct.setIcePageData(data);
		packagingProduct.setTotal(decimal);
		result.setData(packagingProduct);
		result.setMessage("");
		return result;
	}

	/**
	 * 获取金额统计汇总
	 * 每个分类对应一个折扣
	 *
	 * @param orderId
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/getTotalSelectedProductDTO", method = {RequestMethod.GET, RequestMethod.POST})
	public IceAjaxResult<ConfigTotalSelectedProductDTO> getTotalSelectedProductDTO(
			String orderId, UserInfo user
	) {
		if (user == null || user.getUserStatus() != 1) {
			return IceAjaxResult.getFailResult("用户不存在");

		}
		if (orderId == null || "".equals(orderId.trim())) {
			return IceAjaxResult.getFailResult("无效订单信息");
		}
		if (this.configOrderFeignClient.getByPrimaryKey(orderId) == null) {
			return IceAjaxResult.getFailResult("无效订单信息");

		}
		ConfigOrderDetail orderDetail = new ConfigOrderDetail();
		orderDetail.setOrderId(orderId);
		QueryPageParam<ConfigOrderDetail> pageParam = new QueryPageParam<>();
		pageParam.setQuery(orderDetail);
		ReturnValue<QueryResult<ConfigOrderDetail>> returnValue = this.configOrderDetailFeignClient.getQueryResult(pageParam);
		if (returnValue == null) {
			return IceAjaxResult.getFailResult("系统繁忙请稍后再试");

		}
		IceAjaxResult<ConfigTotalSelectedProductDTO> result = new IceAjaxResult<>();
		if (returnValue.getObj().getItems().size() == 0) {
			ConfigTotalSelectedProductDTO SelectedDTO = new ConfigTotalSelectedProductDTO();
			SelectedDTO.setListProduct(new ArrayList<>());
			SelectedDTO.setLstOtherAmount(new ArrayList<>());
			SelectedDTO.setTotalAmount(new BigDecimal(0));
			SelectedDTO.setProductTotalAmount(new BigDecimal(0));
			result.setData(SelectedDTO);
			return result;

		}

		List<ConfigOrderDetail> detailList = returnValue.getObj().getItems();
		List<ConfigCategorySelectedProductListUnit> ListUnits = null;
		ListUnits = this.getCategoryListUnit(detailList, orderId, user);//获取类别统计集合
		ConfigTotalSelectedProductDTO productDTO = new ConfigTotalSelectedProductDTO();

		ConfigOrderDiscountInfo discountInfo = new ConfigOrderDiscountInfo();
		discountInfo.setConfigOrderId(orderId);
		ReturnValue<ConfigOrderDiscountInfo> returnDiscountInfo = this.discountInfoFeignClient.findTop1(discountInfo);
		if (returnDiscountInfo == null) {
			return IceAjaxResult.getFailResult("系统繁忙请稍后再试");

		}
		ConfigOrderDiscountInfo orderDiscountInfo = returnDiscountInfo.getObj();
		ListUnits = this.setCategoryListUnitDiscount(orderDiscountInfo, ListUnits, orderId);//系统折扣设置
		BigDecimal productAmount = new BigDecimal(0);//折扣后总价格
		BigDecimal originalAmount = new BigDecimal(0);//原始价格
		Collections.sort(ListUnits);
		productDTO.setListProduct(ListUnits);
		System.out.println(ListUnits);
		for (ConfigCategorySelectedProductListUnit Unit : ListUnits) {
			productAmount = productAmount.add(Unit.getFinalAmount());
			originalAmount = originalAmount.add(Unit.getTotalAmount());

		}
		List<Integer> categoryId = new ArrayList<>();
		Map<Integer, List<ConfigSumSelectedProductListUnit>> listMap = new HashMap<>();
		for (ConfigOrderDetail category : detailList) {
			if (!categoryId.contains(category.getCategoryId())) {
				categoryId.add(category.getCategoryId());
				IceAjaxResult<PackagingProduct> result2 = this.getSumSelectedProductList(orderId, category.getCategoryId().toString(), 1, 10000, user);
				listMap.put(category.getCategoryId(), result2.getData().getIcePageData().getList());

			}

		}

		ConfigOtherAmountSetForm amountSetForm = this.getOtherAmountSetForm(orderId, user).getData();
		List<ConfigOrderOtherAmountListUnit> listUnits = new ArrayList<>();
		ConfigOrderOtherAmountListUnit unit2 = new ConfigOrderOtherAmountListUnit();
		BigDecimal totalAmount = new BigDecimal(0);
		Integer type = amountSetForm.getInstallAmountType();
		if (type == 1 || type == 2) {
			totalAmount = type == 1 ? productAmount : originalAmount;
			totalAmount = totalAmount.multiply(getConvert(amountSetForm.getInstallAmountRate().toString()));

		} else {
			totalAmount = this.getAdditionalAmount(orderId, listMap, amountSetForm.getLstInstallCateogry());

		}
		unit2.setName("总设备安装费");
		unit2.setAmount(totalAmount);
		//unit2.setPercentage(totalAmount.divide(productAmount, 2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal("100")).setScale(2));
		listUnits.add(unit2);
		ConfigOrderOtherAmountListUnit unit3 = new ConfigOrderOtherAmountListUnit();
		BigDecimal totalAmountDebug = new BigDecimal(0);
		type = amountSetForm.getDebugAmountType();
		if (type == 1 || type == 2) {
			totalAmountDebug = type == 1 ? productAmount : originalAmount;
			totalAmountDebug = totalAmountDebug.multiply(getConvert(amountSetForm.getDebugAmountRate().toString()));
		} else {
			totalAmountDebug = this.getAdditionalAmount(orderId, listMap, amountSetForm.getLstDebugCateogry());

		}
		unit3.setAmount(totalAmountDebug);
		unit3.setName("总设备调试安装");
		listUnits.add(unit3);
		ConfigOrderOtherAmountListUnit unit4 = new ConfigOrderOtherAmountListUnit();
		BigDecimal totalAmountTax = new BigDecimal(0);
		if (amountSetForm.getTaxType() == 2) {
			System.out.println(amountSetForm.getTaxRate().toString() + "hhhh");
			totalAmountTax = productAmount.multiply(getConvert(amountSetForm.getTaxRate().toString()));
		} else {
			totalAmountTax = productAmount.multiply(getConvert(amountSetForm.getDefaultTaxRate().toString()));
		}
		unit4.setName("增值锐");
		unit4.setAmount(totalAmountTax);
		listUnits.add(unit4);
		BigDecimal totalAmountOther = new BigDecimal(0);
		if (amountSetForm.getOtherAmounts() != null && amountSetForm.getOtherAmounts().size() != 0) {
			for (ConfigOtherDefineAmountSetForm obj : amountSetForm.getOtherAmounts()) {
				totalAmountOther = totalAmountOther.add(new BigDecimal(obj.getAmount()));
			}
			ConfigOrderOtherAmountListUnit unitOther = new ConfigOrderOtherAmountListUnit();
			unitOther.setName("其它费用");
			unitOther.setAmount(totalAmountOther);
			listUnits.add(unitOther);
		}


		productDTO.setLstOtherAmount(listUnits);
		productDTO.setTotalAmount(productAmount.add(totalAmount).add(totalAmountDebug).add(totalAmountTax).add(totalAmountOther));
		productDTO.setProductTotalAmount(productAmount);
		result.setData(productDTO);
		System.out.println(JSON.toJSONString(productDTO));
		result.setMessage("");
		return result;
	}

	/**
	 * 获取订单 额外金额设置表单
	 *
	 * @param orderId
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/getOtherAmountSetForm", method = {RequestMethod.GET, RequestMethod.POST})
	public IceAjaxResult<ConfigOtherAmountSetForm> getOtherAmountSetForm(String orderId, UserInfo user) {
		if (user == null || user.getUserStatus() != 1) {
			return IceAjaxResult.getFailResult("用户不存在");

		}
		if (orderId == null || "".equals(orderId.trim())) {
			return IceAjaxResult.getFailResult("无效订单信息");
		}
		if (this.configOrderFeignClient.getByPrimaryKey(orderId) == null) {
			return IceAjaxResult.getFailResult("无效订单信息");

		}
		List<CategoryDTO> dtoList = this.categoryController.getClassification(orderId, user).getData();
		AgentInfo obj = this.agentInfoFeignClient.getByUserId(user.getId()).getObj();
		IceAjaxResult<ConfigOtherAmountSetForm> result = new IceAjaxResult<>();
		QueryPageParam<ConfigOrderExtraInfo> queryPageParam = new QueryPageParam<>();
		ConfigOrderExtraInfo extraInfo = new ConfigOrderExtraInfo();
		extraInfo.setConfigOrderId(orderId);
		queryPageParam.setQuery(extraInfo);
		ReturnValue<QueryResult<ConfigOrderExtraInfo>> returnValue = this.extraInfoClient.getQueryResult(queryPageParam);
		List<ConfigOrderExtraInfo> extraInfoList = returnValue.getObj().getItems();
		ConfigOtherAmountSetForm form = new ConfigOtherAmountSetForm();

		ConfigOrderExtraInfo orderExtraInfo = new ConfigOrderExtraInfo();
		orderExtraInfo.setAgentId(obj.getId());
		orderExtraInfo.setExtraType(3);
		orderExtraInfo.setMapType(0);
		ReturnValue<ConfigOrderExtraInfo> values = this.extraInfoClient.findTop(orderExtraInfo);
		if (values.getObj() != null) {

			form.setDefaultTaxRate(getPercentage(values.getObj().getExtraAmount()).doubleValue());
		} else {
			orderExtraInfo.setAgentId(0);
			ReturnValue<ConfigOrderExtraInfo> extraInfoClientTop = this.extraInfoClient.findTop(orderExtraInfo);
			form.setDefaultTaxRate(getPercentage(extraInfoClientTop.getObj().getExtraAmount()).doubleValue());

		}

		List<ConfigCategoryAmountSetUnit> unitList = new ArrayList<>();
		List<ConfigCategoryAmountSetUnit> unitList1 = new ArrayList<>();
		List<ConfigCategoryAmountSetUnit> showCategory = new ArrayList<>();
		for (CategoryDTO dto : dtoList) {
			ConfigCategoryAmountSetUnit unit = new ConfigCategoryAmountSetUnit();
			unit.setCategoryId(dto.getValue());
			unit.setCategoryName(dto.getLabel());
			unit.setAmountType(3);
			unit.setAmount("1000");
			showCategory.add(unit);
		}
		if (extraInfoList != null && extraInfoList.size() != 0) {
			List<ConfigOtherDefineAmountSetForm> defineAmountSetFormList = new ArrayList<>();
			boolean install = true;
			boolean debug = true;
			boolean tax = true;
			boolean showInstallCategory = true;
			boolean showDebugCategory = true;
			for (ConfigOrderExtraInfo info : extraInfoList) {

				if (info.getExtraType() == 1 && info.getMapType() == 2 && info.getConditionType() == 2) {
					form.setInstallAmountType(2);
					form.setInstallAmountRate(getPercentage(info.getExtraAmount()).doubleValue());
					install = false;
				}
				if (info.getExtraType() == 1 && info.getMapType() == 2 && info.getConditionType() == 1) {
					form.setInstallAmountType(1);
					form.setInstallAmountRate(getPercentage(info.getExtraAmount()).doubleValue());
					install = false;
				}
				if (info.getExtraType() == 2 && info.getMapType() == 2 && info.getConditionType() == 2) {
					form.setDebugAmountType(2);
					form.setDebugAmountRate(getPercentage(info.getExtraAmount()).doubleValue());
					debug = false;
				}
				if (info.getExtraType() == 2 && info.getMapType() == 2 && info.getConditionType() == 1) {
					form.setDebugAmountType(1);
					form.setDebugAmountRate(getPercentage(info.getExtraAmount()).doubleValue());
					debug = false;
				}
				if (info.getExtraType() == 1 && info.getMapType() == 1) {
					form.setInstallAmountType(3);
					ConfigCategoryAmountSetUnit unit = new ConfigCategoryAmountSetUnit();
					unit.setCategoryId(Integer.parseInt(info.getMapKey()));
					unit.setCategoryName(info.getExtraName());
					unit.setAmountType(info.getConditionType());
					unit.setAmount(getPercentage(info.getExtraAmount(), info.getConditionType()).toString());
					unitList.add(unit);
					install = false;
					showInstallCategory = false;
				}
				if (info.getExtraType() == 2 && info.getMapType() == 1) {
					form.setDebugAmountType(3);
					ConfigCategoryAmountSetUnit unit = new ConfigCategoryAmountSetUnit();
					unit.setCategoryId(Integer.parseInt(info.getMapKey()));
					unit.setCategoryName(info.getExtraName());
					unit.setAmountType(info.getConditionType());
					unit.setAmount(getPercentage(info.getExtraAmount(), info.getConditionType()).toString());
					unitList1.add(unit);
					debug = false;
					showDebugCategory = false;
				}
				if (info.getExtraType() == 3) {

					form.setTaxType(2);

					form.setTaxRate(getPercentage(info.getExtraAmount()).doubleValue());
					tax = false;
				}
				if (info.getExtraType() == 4) {
					ConfigOtherDefineAmountSetForm form1 = new ConfigOtherDefineAmountSetForm();
					form1.setName(info.getExtraName());
					form1.setAmount(info.getExtraAmount().toString());
					defineAmountSetFormList.add(form1);
				}

			}
			if (install) {
				ConfigOrderExtraInfo orderExtra = new ConfigOrderExtraInfo();
				orderExtra.setAgentId(obj.getId());
				orderExtra.setExtraType(1);
				orderExtra.setMapType(0);
				ReturnValue<ConfigOrderExtraInfo> value = this.extraInfoClient.findTop(orderExtra);
				if (value.getObj() != null) {
					form.setInstallAmountType(value.getObj().getConditionType());
					form.setInstallAmountRate(getPercentage(value.getObj().getExtraAmount()).doubleValue());

				} else {
					orderExtra.setAgentId(0);
					ReturnValue<ConfigOrderExtraInfo> OrderExtravalue = this.extraInfoClient.findTop(orderExtra);
					form.setInstallAmountType(OrderExtravalue.getObj().getConditionType());
					form.setInstallAmountRate(getPercentage(OrderExtravalue.getObj().getExtraAmount()).doubleValue());
				}


			}

			if (showInstallCategory) {
				unitList.addAll(showCategory);
			}

			if (debug) {
				ConfigOrderExtraInfo orderExtra = new ConfigOrderExtraInfo();
				orderExtra.setAgentId(obj.getId());
				orderExtra.setExtraType(2);
				orderExtra.setMapType(0);
				ReturnValue<ConfigOrderExtraInfo> value = this.extraInfoClient.findTop(orderExtra);
				if (value.getObj() != null) {
					form.setDebugAmountType(value.getObj().getConditionType());
					form.setDebugAmountRate(getPercentage(value.getObj().getExtraAmount()).doubleValue());
				} else {
					orderExtra.setAgentId(0);
					ReturnValue<ConfigOrderExtraInfo> value1 = this.extraInfoClient.findTop(orderExtra);
					form.setDebugAmountType(value1.getObj().getConditionType());
					form.setDebugAmountRate(getPercentage(value1.getObj().getExtraAmount()).doubleValue());

				}
			}
			if (showDebugCategory) {
				unitList1.addAll(showCategory);
			}


			if (tax) {
				form.setTaxType(1);
			}

			form.setLstInstallCateogry(unitList);
			form.setLstDebugCateogry(unitList1);
			form.setOtherAmounts(defineAmountSetFormList);
			result.setData(form);
			result.setMessage("");
			return result;

		} else {

			ConfigOrderExtraInfo order = new ConfigOrderExtraInfo();
			order.setAgentId(0);
			order.setMapType(0);
			QueryPageParam<ConfigOrderExtraInfo> pageParam = new QueryPageParam<>();
			pageParam.setQuery(order);
			ReturnValue<QueryResult<ConfigOrderExtraInfo>> resultReturnValue = this.extraInfoClient.getQueryResult(pageParam);
			List<ConfigOrderExtraInfo> orderExtraInfoList = resultReturnValue.getObj().getItems();
			for (ConfigOrderExtraInfo info : orderExtraInfoList) {
				if (info.getExtraType() == 1) {
					order.setAgentId(obj.getId());
					order.setExtraType(1);
					ReturnValue<ConfigOrderExtraInfo> value = this.extraInfoClient.findTop(order);
					if (value.getObj() != null) {
						form.setInstallAmountType(value.getObj().getConditionType());
						form.setInstallAmountRate(getPercentage(value.getObj().getExtraAmount()).doubleValue());

					} else {
						form.setInstallAmountType(info.getConditionType());
						form.setInstallAmountRate(getPercentage(info.getExtraAmount()).doubleValue());
					}


				}
				if (info.getExtraType() == 2) {
					order.setAgentId(obj.getId());
					order.setExtraType(2);
					ReturnValue<ConfigOrderExtraInfo> value = this.extraInfoClient.findTop(order);
					if (value.getObj() != null) {
						form.setDebugAmountType(value.getObj().getConditionType());
						form.setDebugAmountRate(getPercentage(value.getObj().getExtraAmount()).doubleValue());
					} else {
						form.setDebugAmountType(info.getConditionType());
						form.setDebugAmountRate(getPercentage(info.getExtraAmount()).doubleValue());

					}
				}

				if (info.getExtraType() == 3) {

					form.setTaxType(1);

				}

			}


			unitList.addAll(showCategory);
			unitList1.addAll(showCategory);
			form.setLstInstallCateogry(unitList);
			form.setLstDebugCateogry(unitList1);
			result.setData(form);
			result.setMessage("");
			return result;
		}


	}

	/**
	 * 提交额外金额设置表单
	 *
	 * @param form
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/submitOtherAmountSetForm", method = {RequestMethod.POST})
	public IceAjaxResult submitOtherAmountSetForm(@RequestBody ConfigOtherAmountSetForm form, UserInfo user) {
		System.out.println("代码执行了" + "" + form);
		if (user == null || user.getUserStatus() != 1) {
			return IceAjaxResult.getFailResult("用户不存在");

		}
		if (form.getOrderId() == null || "".equals(form.getOrderId().trim())) {
			return IceAjaxResult.getFailResult("无效订单信息");
		}

		if (this.configOrderFeignClient.getByPrimaryKey(form.getOrderId()) == null) {
			return IceAjaxResult.getFailResult("无效订单信息");

		}
		if (form == null) {

			return IceAjaxResult.getFailResult("请填写表单信息");
		}

		IceAjaxResult result = new IceAjaxResult();
		AgentInfo obj = this.agentInfoFeignClient.getByUserId(user.getId()).getObj();
		List<ConfigOrderExtraInfo>  insertList=new ArrayList<>();
		if (form.getInstallAmountType() == 2) {
			ConfigOrderExtraInfo orderExtraInfo = new ConfigOrderExtraInfo();
			orderExtraInfo.setAgentId(0);
			orderExtraInfo.setExtraType(1);
			orderExtraInfo.setMapType(0);
			ReturnValue<ConfigOrderExtraInfo> returnValue = this.extraInfoClient.findTop(orderExtraInfo);
			orderExtraInfo.setAgentId(obj.getId());
			ReturnValue<ConfigOrderExtraInfo> returnValue2 = this.extraInfoClient.findTop(orderExtraInfo);
			BigDecimal extra = returnValue.getObj().getExtraAmount();
			if (returnValue2.getObj() != null) {
				extra = returnValue2.getObj().getExtraAmount();
			}

			if(isLegal(form.getInstallAmountRate()).getData().booleanValue()){
				return new IceAjaxResult("",isLegal(form.getInstallAmountRate()).getMessage()) ;
			}
			if (getConvert(form.getInstallAmountRate().toString()).compareTo(returnValue.getObj().getExtraAmount())!=0
				 ||getConvert(form.getInstallAmountRate().toString()).compareTo(extra)!=0) {

				ConfigOrderExtraInfo orderExtra = new ConfigOrderExtraInfo();
				orderExtra.setConfigOrderId(form.getOrderId());
				orderExtra.setExtraType(1);
				orderExtra.setConditionType(2);
				orderExtra.setMapType(2);
				orderExtra.setExtraAmount(getConvert(form.getInstallAmountRate().toString()));
				orderExtra.setCreateTime(new Date());
				insertList.add(orderExtra);
			}

		}

		if (form.getInstallAmountType() == 1) {
			ConfigOrderExtraInfo configOrderExtraInfo = new ConfigOrderExtraInfo();
			configOrderExtraInfo.setConfigOrderId(form.getOrderId());
			configOrderExtraInfo.setExtraType(1);
			configOrderExtraInfo.setConditionType(1);
			configOrderExtraInfo.setMapType(2);
			if(isLegal(form.getInstallAmountRate()).getData().booleanValue()){
				return new IceAjaxResult("",isLegal(form.getInstallAmountRate()).getMessage()) ;
			}
			configOrderExtraInfo.setExtraAmount(getConvert(form.getInstallAmountRate().toString()));
			insertList.add(configOrderExtraInfo);
		}
		if (form.getInstallAmountType() == 3) {
			for (ConfigCategoryAmountSetUnit amountSetUnit : form.getLstInstallCateogry()) {
				ConfigOrderExtraInfo orderCategory = new ConfigOrderExtraInfo();
				orderCategory.setConfigOrderId(form.getOrderId());
				orderCategory.setExtraType(1);
				orderCategory.setConditionType(amountSetUnit.getAmountType());
				orderCategory.setMapType(1);
				if(isLegal(amountSetUnit.getAmount(),amountSetUnit.getAmountType()).getData().booleanValue()){
					return new IceAjaxResult("",isLegal(amountSetUnit.getAmount(),amountSetUnit.getAmountType()).getMessage()) ;
				}
				orderCategory.setMapKey(amountSetUnit.getCategoryId().toString());
				orderCategory.setExtraAmount(getConvert(amountSetUnit.getAmount(),amountSetUnit.getAmountType()));
				orderCategory.setExtraName(amountSetUnit.getCategoryName());
				insertList.add(orderCategory);
			}

		}

		if (form.getDebugAmountType() == 2) {
			ConfigOrderExtraInfo extraOrder = new ConfigOrderExtraInfo();
			extraOrder.setAgentId(0);
			extraOrder.setExtraType(2);
			extraOrder.setMapType(0);
			ReturnValue<ConfigOrderExtraInfo> returnValue = this.extraInfoClient.findTop(extraOrder);
			extraOrder.setAgentId(obj.getId());
			ReturnValue<ConfigOrderExtraInfo> returnExtraInfo = this.extraInfoClient.findTop(extraOrder);
			BigDecimal extra = returnValue.getObj().getExtraAmount();
			if (returnExtraInfo.getObj() != null) {

				extra = returnExtraInfo.getObj().getExtraAmount();
			}
			if(isLegal(form.getDebugAmountRate()).getData().booleanValue()){
				return new IceAjaxResult("",isLegal(form.getDebugAmountRate()).getMessage()) ;
			}
			if (getConvert(form.getDebugAmountRate().toString()).compareTo(returnValue.getObj().getExtraAmount())!=0
				||getConvert(form.getDebugAmountRate().toString()).compareTo(extra)!=0) {
				ConfigOrderExtraInfo orderExtraDebug = new ConfigOrderExtraInfo();
				orderExtraDebug.setConfigOrderId(form.getOrderId());
				orderExtraDebug.setExtraType(2);
				orderExtraDebug.setConditionType(2);
				orderExtraDebug.setMapType(2);
				orderExtraDebug.setExtraAmount(getConvert(form.getDebugAmountRate().toString()));
				orderExtraDebug.setCreateTime(new Date());
				insertList.add(orderExtraDebug);
			}

		}
		if (form.getDebugAmountType() == 1) {
			ConfigOrderExtraInfo orderExtraInfoType = new ConfigOrderExtraInfo();
			orderExtraInfoType.setConfigOrderId(form.getOrderId());
			orderExtraInfoType.setExtraType(2);
			orderExtraInfoType.setConditionType(1);
			orderExtraInfoType.setMapType(2);
			if(isLegal(form.getDebugAmountRate()).getData().booleanValue()){
				return new IceAjaxResult("",isLegal(form.getDebugAmountRate()).getMessage()) ;
			}
			orderExtraInfoType.setExtraAmount(getConvert(form.getDebugAmountRate().toString()));
			orderExtraInfoType.setCreateTime(new Date());
			insertList.add(orderExtraInfoType);
		}

		if (form.getDebugAmountType() == 3) {
			for (ConfigCategoryAmountSetUnit unit : form.getLstDebugCateogry()) {
				ConfigOrderExtraInfo configOrderExtraInfo = new ConfigOrderExtraInfo();
				configOrderExtraInfo.setConfigOrderId(form.getOrderId());
				configOrderExtraInfo.setExtraType(2);
				configOrderExtraInfo.setConditionType(unit.getAmountType());
				configOrderExtraInfo.setMapType(1);
				if(isLegal(unit.getAmount(),unit.getAmountType()).getData().booleanValue()){
					return new IceAjaxResult("",isLegal(unit.getAmount(),unit.getAmountType()).getMessage()) ;
				}
				configOrderExtraInfo.setMapKey(unit.getCategoryId().toString());
				configOrderExtraInfo.setExtraAmount(getConvert(unit.getAmount(),unit.getAmountType()));
				configOrderExtraInfo.setExtraName(unit.getCategoryName());
				insertList.add(configOrderExtraInfo);
			}

		}
		if (form.getTaxType() == 2) {
			ConfigOrderExtraInfo orderExtraInfoTax = new ConfigOrderExtraInfo();
			orderExtraInfoTax.setAgentId(0);
			orderExtraInfoTax.setExtraType(3);
			orderExtraInfoTax.setMapType(0);
			ReturnValue<ConfigOrderExtraInfo> returnValue = this.extraInfoClient.findTop(orderExtraInfoTax);
			orderExtraInfoTax.setAgentId(obj.getId());
			ReturnValue<ConfigOrderExtraInfo> returnExtraInfo = this.extraInfoClient.findTop(orderExtraInfoTax);
			BigDecimal extra = returnValue.getObj().getExtraAmount();
			;
			if (returnExtraInfo.getObj() != null) {
				extra = returnExtraInfo.getObj().getExtraAmount();

			}
			if(isLegal(form.getTaxRate()).getData().booleanValue()){
				return new IceAjaxResult("",isLegal(form.getTaxRate()).getMessage()) ;
			}
			if (getConvert(form.getTaxRate().toString()).compareTo(returnValue.getObj().getExtraAmount())!=0
				||getConvert(form.getTaxRate().toString()).compareTo(extra)!=0) {

				ConfigOrderExtraInfo orderExtraInfo = new ConfigOrderExtraInfo();
				orderExtraInfo.setConfigOrderId(form.getOrderId());
				orderExtraInfo.setExtraType(3);
				orderExtraInfo.setMapType(2);
				orderExtraInfo.setExtraAmount(getConvert(form.getTaxRate().toString()));
				orderExtraInfo.setCreateTime(new Date());
				insertList.add(orderExtraInfo);
			}

		}
		if (form.getOtherAmounts() != null && form.getOtherAmounts().size() != 0) {
			for (ConfigOtherDefineAmountSetForm otherDefineAmountSetForm : form.getOtherAmounts()) {
				ConfigOrderExtraInfo configOrderExtraInfo = new ConfigOrderExtraInfo();
				configOrderExtraInfo.setConfigOrderId(form.getOrderId());
				configOrderExtraInfo.setExtraType(4);
				configOrderExtraInfo.setExtraName(otherDefineAmountSetForm.getName());
				if(!isNum(otherDefineAmountSetForm.getAmount())){
				    return  new IceAjaxResult("","请输入正确数字");
                }
				configOrderExtraInfo.setExtraAmount(new BigDecimal(otherDefineAmountSetForm.getAmount()));
				insertList.add(configOrderExtraInfo);
			}

		}

		QueryPageParam<ConfigOrderExtraInfo> queryPageParam = new QueryPageParam<>();
		ConfigOrderExtraInfo extraInfo = new ConfigOrderExtraInfo();
		extraInfo.setConfigOrderId(form.getOrderId());
		queryPageParam.setQuery(extraInfo);
		ReturnValue<QueryResult<ConfigOrderExtraInfo>> queryResult = this.extraInfoClient.getQueryResult(queryPageParam);
		List<ConfigOrderExtraInfo> orderExtraInfos = queryResult.getObj().getItems();
		if (orderExtraInfos.size() != 0) {
			ConfigOrderExtraInfo orderExtraInfo = new ConfigOrderExtraInfo();
			orderExtraInfo.setConfigOrderId(form.getOrderId());
			this.extraInfoClient.deleteByOrderExtraInfo(orderExtraInfo);//删除所有

		}
		for(ConfigOrderExtraInfo info : insertList){
			this.extraInfoClient.insert(info);
		}
		result.setMessage("");
		return result;
	}


	/**
	 * pdf信息打印
	 */
	@RequestMapping(value = "/getSystemCommodity", method = {RequestMethod.POST})
	public IceAjaxResult<PdfInformationPrinting> getSystemCommodity(String orderId, UserInfo user) {
		if (user == null || user.getUserStatus() != 1) {
			return IceAjaxResult.getFailResult("用户不存在");

		}
		if (!StringUtil.isNotTrimBlank(orderId)) {
			return IceAjaxResult.getFailResult("无效订单信息");

		}
		ReturnValue<ConfigOrder> order = this.configOrderFeignClient.getByPrimaryKey(orderId);
		if (order == null || order.getObj() == null) {
			return IceAjaxResult.getFailResult("无效订单信息");
		}
		IceAjaxResult<PdfInformationPrinting> result = new IceAjaxResult<>();
		PdfInformationPrinting printing = new PdfInformationPrinting();
		result.setData(printing);
		TemplatePdfDTO pdfInfo = new TemplatePdfDTO();
		Map<Integer, CommodityPDF> commodityPDFMap = new HashMap<>();
		List<CommodityPDF> commodityPDFList = new ArrayList<>();
		EquipmentSummary summary = new EquipmentSummary();
		QueryPageParam<TemplatePdf> queryParam = new QueryPageParam<>();
		TemplatePdf templatePdf = new TemplatePdf();
		templatePdf.setUserId(user.getId());
		queryParam.setQuery(templatePdf);
		ReturnValue<QueryResult<TemplatePdf>> queryResult = this.pdfClient.getQueryResult(queryParam);
		if (queryResult.getObj().getItems().size() != 0) {
			templatePdf = queryResult.getObj().getItems().get(0);
			pdfInfo.setWatermarkMessage(templatePdf.getWatermarkMessage());
			pdfInfo.setTipsMessage(templatePdf.getTipsMessage());
			pdfInfo.setHeaderMessage(templatePdf.getHeaderMessage());
			pdfInfo.setFooterMessage(templatePdf.getFooterMessage());
		}
		IceAjaxResult<IcePageData<ConfigSelectedProductListUnit>> ProductListUnit = this.getSelectedProductList(orderId, 1, 100000, user);
		if (ProductListUnit.getData().getList().size() != 0) {
			for (ConfigSelectedProductListUnit obj : ProductListUnit.getData().getList()) {
				Integer productId = IntUtil.parseInt(obj.getProductId(),false);
				if(!IntUtil.isGreaterThanZero(productId))
				{
					return  IceAjaxResult.getFailResult("商品信息有误，请核查");
				}
				CommodityPDF commodityPDF = null;
				ReturnValue<ConfigProduct> retProduct =productFeignClient.getByPrimaryKey(productId);
				if(retProduct.getCode()!=200)
				{
					return  IceAjaxResult.getFailResult(StringUtil.getErrorMsg(retProduct.getMsg()));
				}
				if(retProduct.getObj()==null)
				{
					return  IceAjaxResult.getFailResult("商品信息有误，请核查");
				}
				ConfigCategory configCategory = this.configCategoryFeignClient.getTopConfigCategory(retProduct.getObj().getCategoryId()).getObj();
				if (!commodityPDFMap.containsKey(configCategory.getId())) {
					commodityPDF = new CommodityPDF();
					commodityPDF.setSystemName(configCategory.getCategoryName());
					commodityPDFMap.put(configCategory.getId(), commodityPDF);
				}
				CommodityDTO dto = new CommodityDTO();
				BeanUtils.copyProperties(obj, dto);
				dto.setUnitPrice(new BigDecimal(dto.getProductAmount()).divide(new BigDecimal(dto.getProductNum()), 2, BigDecimal.ROUND_HALF_UP));
				commodityPDF = commodityPDFMap.get(configCategory.getId());
				commodityPDF.getCommodityDTOList().add(dto);


			}

		}

		ConfigTotalSelectedProductDTO productDTO = this.getTotalSelectedProductDTO(orderId, user).getData();
		BeanUtils.copyProperties(productDTO, summary);
		printing.setOrderId(order.getObj().getId());
		printing.setOrderName(order.getObj().getOrderName());
		printing.setCustomerName(order.getObj().getCustomerName());
		printing.setCustomerTel(order.getObj().getCustomerTel());
		printing.setProjectAddress(order.getObj().getProjectAddress());
		printing.setTime(DateUtil.format(order.getObj().getCreateTime(), "yyyy/MM/d"));
		printing.setPdfInfo(pdfInfo);
		commodityPDFList.addAll(commodityPDFMap.values());
		printing.setCommodityPdfs(commodityPDFList);
		printing.setEquipmentSummary(summary);
		System.out.println(JSON.toJSONString(printing));
		result.setMessage("");
		return result;
	}

	private List<ConfigCategorySelectedProductListUnit> getCategoryListUnit(List<ConfigOrderDetail> detailList, String orderId, UserInfo user) {
		Map<ConfigCategory, List<ConfigSumSelectedProductListUnit>> listMap = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		for (ConfigOrderDetail category : detailList) {
			ReturnValue<ConfigCategory> categoryReturnValue = this.configCategoryFeignClient.getTopConfigCategory(category.getCategoryId());
			ConfigCategory category1 = categoryReturnValue.getObj();
			System.out.println(categoryReturnValue.getObj().getId());
			if (!list.contains(category1.getId())) {
				list.add(category1.getId());
				IceAjaxResult<PackagingProduct> result1 = this.getSumSelectedProductList(orderId, category1.getId().toString(), 1, 10000, user);
				System.out.println(result1.getData().getIcePageData().getList());
				listMap.put(category1, result1.getData().getIcePageData().getList());
			}

		}
		List<ConfigCategorySelectedProductListUnit> ListUnits = new ArrayList<>();
		for (ConfigCategory category : listMap.keySet()) {
			BigDecimal Amount = new BigDecimal(0);
			ConfigCategorySelectedProductListUnit unit1 = new ConfigCategorySelectedProductListUnit();
			unit1.setCategoryId(category.getId());
			unit1.setCategoryName(category.getCategoryName());
			for (ConfigSumSelectedProductListUnit unit : listMap.get(category)) {
				Amount = Amount.add(new BigDecimal(unit.getTotalAmount()));


			}

			unit1.setTotalAmount(Amount);
			ListUnits.add(unit1);
		}
		return ListUnits;
	}


	private List<ConfigCategorySelectedProductListUnit> setCategoryListUnitDiscount(ConfigOrderDiscountInfo orderDiscountInfo, List<ConfigCategorySelectedProductListUnit> ListUnits, String orderId) {

		if (orderDiscountInfo != null) {
			if (orderDiscountInfo.getDiscountType() == 0) {
				for (ConfigCategorySelectedProductListUnit Unit : ListUnits) {
					Unit.setDiscountRate(orderDiscountInfo.getConditionAmount().intValue());
					Unit.setFinalAmount(Unit.getTotalAmount().multiply(orderDiscountInfo.getConditionAmount()).setScale(2, BigDecimal.ROUND_UP));

				}

			} else {
				ConfigOrderDiscountInfo discount = new ConfigOrderDiscountInfo();
				discount.setConfigOrderId(orderId);
				discount.setDiscountType(1);
				QueryPageParam<ConfigOrderDiscountInfo> infoQueryPageParam = new QueryPageParam<>();
				infoQueryPageParam.setQuery(discount);

				ReturnValue<QueryResult<ConfigOrderDiscountInfo>> resultReturnValue = this.discountInfoFeignClient.getQueryResult(infoQueryPageParam);
				List<Integer> NotOrderType = new ArrayList<>();
				if (resultReturnValue.getObj().getItems().size() != 0) {
					for (ConfigOrderDiscountInfo info : resultReturnValue.getObj().getItems()) {
						for (ConfigCategorySelectedProductListUnit Unit : ListUnits) {
							if (Unit.getCategoryId().toString().equals(info.getDiscountKey())) {
								Unit.setDiscountRate(info.getConditionAmount().multiply(new BigDecimal("100")).intValue());
								Unit.setFinalAmount(Unit.getTotalAmount().multiply(info.getConditionAmount()).setScale(2, BigDecimal.ROUND_UP));

							}

						}

					}
					for (ConfigCategorySelectedProductListUnit Unit : ListUnits) {
						if (Unit.getDiscountRate() == null || Unit.getFinalAmount() == null) {
							NotOrderType.add(Unit.getCategoryId());

						}
					}

					for (Integer i : NotOrderType) {
						ConfigOrderDiscountInfo discountInfo1 = new ConfigOrderDiscountInfo();
						discountInfo1.setFromType(2);
						discountInfo1.setDiscountKey(i.toString());
						ConfigOrderDiscountInfo top1 = this.discountInfoFeignClient.findTop1(discountInfo1).getObj();
						discountInfo1.setFromType(1);
						top1 = top1 == null ? this.discountInfoFeignClient.findTop1(discountInfo1).getObj() : top1;
						for (ConfigCategorySelectedProductListUnit Unit : ListUnits) {
							if (Unit.getCategoryId().toString().equals(top1.getDiscountKey())) {
								if (Unit.getDiscountRate() == null || Unit.getFinalAmount() == null) {
									Unit.setDiscountRate(top1.getConditionAmount().multiply(new BigDecimal(100)).intValue());
									Unit.setFinalAmount(Unit.getTotalAmount().multiply(top1.getConditionAmount()).setScale(2, BigDecimal.ROUND_UP));
								}
							}

						}


					}

				}


			}


		} else {

			ConfigOrderDiscountInfo discountInfo1 = new ConfigOrderDiscountInfo();
			for (ConfigCategorySelectedProductListUnit Unit : ListUnits) {
				discountInfo1.setFromType(2);
				discountInfo1.setDiscountKey(Unit.getCategoryId().toString());
				ReturnValue<ConfigOrderDiscountInfo> value = this.discountInfoFeignClient.findTop1(discountInfo1);
				if (value.getObj() != null) {
					Unit.setDiscountRate(value.getObj().getConditionAmount().multiply(new BigDecimal(100)).intValue());
					Unit.setFinalAmount(Unit.getTotalAmount().multiply(value.getObj().getConditionAmount()).setScale(2, BigDecimal.ROUND_UP));
				} else {
					discountInfo1.setFromType(1);
					value = this.discountInfoFeignClient.findTop1(discountInfo1);
					if (value.getObj() != null) {
						Unit.setDiscountRate(value.getObj().getConditionAmount().multiply(new BigDecimal(100)).intValue());
						Unit.setFinalAmount(Unit.getTotalAmount().multiply(value.getObj().getConditionAmount()).setScale(2, BigDecimal.ROUND_UP));

					}

				}


			}


		}

		return ListUnits;
	}

	private BigDecimal getSystemCategoryDiscount(String orderId, String key) {
		ConfigOrderDiscountInfo orderDiscountInfo = new ConfigOrderDiscountInfo();
		orderDiscountInfo.setConfigOrderId(orderId);
		orderDiscountInfo.setDiscountKey(key);
		ConfigOrderDiscountInfo discountInfo = this.discountInfoFeignClient.findTop1(orderDiscountInfo).getObj();
		ConfigOrderDiscountInfo orderDiscount = new ConfigOrderDiscountInfo();
		orderDiscount.setAgentId(0);
		orderDiscount.setDiscountKey(key);
		ConfigOrderDiscountInfo discount = this.discountInfoFeignClient.findTop1(orderDiscount).getObj();
		//System.out.println(obj.getFirstCategory().toString());
		BigDecimal amount = new BigDecimal(0);
		if (discountInfo != null) {
			amount = discountInfo.getConditionAmount();

		} else {
			amount = discount.getConditionAmount();
		}
		return amount;
	}

	private BigDecimal getAdditionalAmount(String orderId, Map<Integer, List<ConfigSumSelectedProductListUnit>> listMap, List<ConfigCategoryAmountSetUnit> list) {
		BigDecimal totalAmount = new BigDecimal(0);
		for (Integer id : listMap.keySet()) {
			BigDecimal Amount = new BigDecimal(0);
			for (ConfigCategoryAmountSetUnit unit : list) {
				System.out.println(unit.getCategoryId() + "666666");
				if (unit.getCategoryId() == id) {
					for (ConfigSumSelectedProductListUnit unit1 : listMap.get(id)) {
						Amount = Amount.add(new BigDecimal(unit1.getTotalAmount()));

					}

					if (unit.getAmountType() == 1 || unit.getAmountType() == 2) {
						ConfigCategory TopFloor = this.configCategoryFeignClient.getTopConfigCategory(id).getObj();
						Amount = Amount.multiply(getSystemCategoryDiscount(orderId, TopFloor.getId().toString()));
						Amount = Amount.multiply(getConvert(unit.getAmount()));

					} else {

						Amount = new BigDecimal(unit.getAmount());
					}

				}


			}

			totalAmount = totalAmount.add(Amount);

		}

		return totalAmount;
	}

	private BigDecimal getPercentage(BigDecimal obj) {

		return obj.multiply(new BigDecimal("100")).setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	private BigDecimal getPercentage(BigDecimal obj, Integer type) {
		return obj = type == 1 || type == 2 ? obj.multiply(new BigDecimal("100")).setScale(2, BigDecimal.ROUND_HALF_UP) : obj;
	}
	private  BigDecimal getConvert(String obj){
		return  new BigDecimal(obj).divide(new BigDecimal("100"),2,BigDecimal.ROUND_HALF_UP);
	}
	private  BigDecimal getConvert(String obj, Integer type){
		BigDecimal decimal=new BigDecimal(obj);
		return  decimal=type == 1 || type == 2 ?decimal.divide(new BigDecimal("100"),2,BigDecimal.ROUND_HALF_UP):decimal;
	}
	private  IceAjaxResult<Boolean> isLegal(String obj){
		Boolean judge=false;
		IceAjaxResult<Boolean>  result=new IceAjaxResult<>();
		result.setData(judge);
		if(obj==null||(!isNum(obj))){
			judge=true;
			result.setData(judge);
			result.setMessage("非法输入：请输入两位数百分比");
			return  result;
		}

		BigDecimal decimal=new BigDecimal(obj).divide(new BigDecimal("100"),2,BigDecimal.ROUND_HALF_UP);

		if(!(decimal.doubleValue()>=0&&decimal.doubleValue()<=1)){
			judge=true;
			result.setData(judge);
			result.setMessage("非法输入：请输入两位数百分比");
			return   result;

		}
		return  result;
	}
private  IceAjaxResult<Boolean> isLegal(Double obj){
    Boolean judge=false;
    IceAjaxResult<Boolean> result=new IceAjaxResult<>();
    result.setData(judge);
	    if(obj==null){
            judge=true;
            result.setMessage("非法输入：请输入两位数百分比");
            result.setData(judge);
	        return  result;
        }else {
            result =isLegal(obj.toString());
        }
	    return  result;
}


private  IceAjaxResult<Boolean> isLegal(String obj,Integer type){
	IceAjaxResult<Boolean>  result=new IceAjaxResult<>();
	Boolean judge=false;
	result.setData(judge);
	if(type==1||type==2){
		result=	isLegal(obj);
	}else {
		if (!isNum(obj)){
			judge=true;
			result.setData(judge);
			result.setMessage("请输入正确数字");
		}
	}
	return  result;
}

private  IceAjaxResult<Boolean> isLegal(Double obj,Integer type){
    Boolean judge=false;
    IceAjaxResult<Boolean> result=new IceAjaxResult<>();
    result.setData(judge);
    if(obj==null){
        judge=true;
        result.setMessage("非法输入：请输入两位数百分比");
        result.setData(judge);
        return  result;
    }else {
        result= isLegal(obj.toString(),type);
    }
	   return  result;
}
/*
* 判断是否为数字
* */
private boolean isNum(String obj) {
	Pattern pattern = Pattern.compile("[0-9]*");
	if("".equals(obj)||obj.toCharArray()[0]=='-'){
		return false;
	}
	if (obj.indexOf(".") > 0) {
		if (obj.indexOf(".") == obj.lastIndexOf(".") && obj.split("\\.").length == 2) {
			return pattern.matcher(obj.replace(".", "")).matches();
		} else {
			return false;
		}
	} else {
		return pattern.matcher(obj).matches();
	}
}



}




