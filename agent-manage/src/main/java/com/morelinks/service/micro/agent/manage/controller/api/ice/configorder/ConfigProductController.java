package com.morelinks.service.micro.agent.manage.controller.api.ice.configorder;

import com.morelinks.core.dto.IceAjaxResult;
import com.morelinks.core.dto.IcePageData;
import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.Page;
import com.morelinks.core.model.QueryResult;
import com.morelinks.core.util.IntUtil;
import com.morelinks.core.util.StringUtil;
import com.morelinks.core.webutil.ResourceUtil;
import com.morelinks.feign.micro.inner.user .api.model.UserInfo;
import com.morelinks.feign.micro.order.api.client.ConfigOrderDetailFeignClient;
import com.morelinks.feign.micro.order.api.client.ConfigOrderFeignClient;
import com.morelinks.feign.micro.order.api.model.ConfigOrder;
import com.morelinks.feign.micro.order.api.model.ConfigOrderDetail;
import com.morelinks.feign.micro.product.api.client.ConfigCategoryFeignClient;
import com.morelinks.feign.micro.product.api.client.ConfigProductAgentExtraFeignClient;
import com.morelinks.feign.micro.product.api.client.ConfigProductFeignClient;
import com.morelinks.feign.micro.product.api.client.ProductBrandFeignClient;
import com.morelinks.feign.micro.product.api.dto.ConfigProductDTO;
import com.morelinks.feign.micro.product.api.model.dto.Query4ConfigProductDTO;
import com.morelinks.service.micro.agent.manage.dto.configorder.ConfigProductListUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 配单 商品页
 */
@RestController
@RequestMapping("/api/config/product")
public class ConfigProductController {
	@Autowired
	ProductBrandFeignClient productBrandFeignClient;
	@Autowired
	ConfigOrderFeignClient configOrderFeignClient;
	@Autowired
	ConfigProductFeignClient productFeignClient;
	@Autowired
	ConfigProductAgentExtraFeignClient extraFeignClient;
	@Autowired
	ConfigOrderDetailFeignClient configOrderDetailFeignClient;
	@Autowired
	ConfigCategoryFeignClient configCategoryFeignClient;


	@Autowired
	ResourceUtil resourceUtil;

	/**
	 * 查询商品
	 *
	 * @param brandIds    品牌Id 逗号分隔
	 * @param productName 查询的商品名称
	 * @param categoryIds 类别Id 逗号分隔
	 * @param page
	 * @param pageSize
	 * @param user
	 * @return
	 */

	@RequestMapping(value = "/getConfigProductList", method = {RequestMethod.GET, RequestMethod.POST})
	public IceAjaxResult<IcePageData<ConfigProductListUnit>> getConfigProductList(
			String brandIds, String productName, String categoryIds, Integer page, Integer pageSize, UserInfo user
			, String orderId
	) {
		if (user == null || user.getUserStatus() != 1) {
			return IceAjaxResult.getFailResult("用户不存在");

		}
		if (orderId == null || "".equals(orderId.trim())) {
			return IceAjaxResult.getFailResult("无效订单信息");
		}
		ReturnValue<ConfigOrder> retConfigOrder = configOrderFeignClient.getByPrimaryKey(orderId);
		ConfigOrder configOrder = retConfigOrder.getObj();
		if (configOrder == null) {
			return IceAjaxResult.getFailResult("无效订单信息");
		}


		List<Integer> listBrand = new ArrayList<>();
		List<Integer> listCategory = new ArrayList<>();
		if (StringUtil.isNotTrimBlank(brandIds)) {
			for (String id : brandIds.split(",")) {
				Integer brandId = IntUtil.parseInt(id, false);
				if (!IntUtil.isGreaterThanZero(brandId)) {
					return IceAjaxResult.getFailResult("请选择正确的品牌");
				}
				listBrand.add(brandId);
			}
		}
		if (StringUtil.isNotTrimBlank(categoryIds)) {
			for (String id : categoryIds.split(",")) {
				Integer categoryId = IntUtil.parseInt(id, false);
				if (!IntUtil.isGreaterThanZero(categoryId)) {
					return IceAjaxResult.getFailResult("请选择正确的系统");
				}
				listCategory.add(categoryId);
			}
		}

		IceAjaxResult<IcePageData<ConfigProductListUnit>> result = new IceAjaxResult<>();
		IcePageData<ConfigProductListUnit> data = new IcePageData<>();
		List<ConfigProductListUnit> units = new ArrayList<>();
		data.setList(units);
		data.setCurrentPage(page);
		data.setPageSize(0);
		data.setTotal(0);
		result.setData(data);
		Page pageObj = new Page();
		pageObj.setOffset((page - 1) * pageSize);
		pageObj.setLimit(pageSize);
		Query4ConfigProductDTO queryProduct = new Query4ConfigProductDTO();
		queryProduct.setBrandIds(listBrand);
		queryProduct.setCategoryIds(listCategory);
		queryProduct.setProductName(productName);
		queryProduct.setAgentId(configOrder.getAgentId());
		queryProduct.setProductStatus(1);
		ReturnValue<QueryResult<ConfigProductDTO>> retProduct = this.productFeignClient.queryConfigProductDTOs(new QueryPageParam<Query4ConfigProductDTO>(queryProduct, pageObj));
		if (retProduct.getCode() != 200) {
			return IceAjaxResult.getFailResult(StringUtil.getErrorMsg(retProduct.getMsg()));
		}
		if (retProduct.getObj() == null || retProduct.getObj().getItems() == null || retProduct.getObj().getItems().size() <= 0) {
			return result;
		}
		QueryPageParam<ConfigOrderDetail> pageParam = new QueryPageParam<>();
		ConfigOrderDetail detail = new ConfigOrderDetail();
		detail.setOrderId(orderId);
		pageParam.setQuery(detail);
		ReturnValue<QueryResult<ConfigOrderDetail>> queryResultReturnValue = this.configOrderDetailFeignClient.getQueryResult(pageParam);
		List<ConfigOrderDetail> detailList = queryResultReturnValue.getObj().getItems();
		Map<Integer,Integer> mapOrderProductNum = new HashMap<>();
		if(queryResultReturnValue.getObj()!=null && queryResultReturnValue.getObj().getItems()!=null) {
			for (ConfigOrderDetail orderDetail : queryResultReturnValue.getObj().getItems()) {
				mapOrderProductNum.put(orderDetail.getProductId(),orderDetail.getProductNum());
			}
		}
		for (ConfigProductDTO product : retProduct.getObj().getItems()) {

			ConfigProductListUnit unit = new ConfigProductListUnit();
			unit.setId(orderId);
			unit.setProductId(product.getId().toString());
			unit.setProductName(product.getProductName());
			unit.setProductResume(product.getProductResume());
			unit.setModelName(product.getModelName());
			unit.setProductType((int) product.getProductType());
			unit.setBrandName(this.productBrandFeignClient.getByPrimaryKey(product.getBrandId()).getObj().getBrandName());
			unit.setProductAmount(product.getProductAmount().toString());
			if (product.getConfigProductAgentExtra() != null
					&& product.getConfigProductAgentExtra().getAgentProductAmount() != null
					&& product.getConfigProductAgentExtra().getAgentProductAmount().compareTo( new BigDecimal(0)) > -1) {
				unit.setProductAmount(product.getConfigProductAgentExtra().getAgentProductAmount().toString());
			}
			unit.setLogoUrl(resourceUtil.getImgUrl(product.getLogoPath()));
			if (mapOrderProductNum.containsKey(product.getId())) {
				unit.setProductNum(mapOrderProductNum.get(product.getId()).toString());
			}
			units.add(unit);
		}

		data.setList(units);
		data.setPageSize(units.size());
		data.setTotal(retProduct.getObj().getTotalCount());
		return result;
	}
}
