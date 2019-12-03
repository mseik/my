package com.morelinks.service.micro.agent.manage.controller.api.ice.configorder;

import com.morelinks.core.dto.IceAjaxResult;
import com.morelinks.core.dto.IceValueDTO;
import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.inner.user.api.model.UserInfo;
import com.morelinks.feign.micro.order.api.client.ConfigOrderDetailFeignClient;
import com.morelinks.feign.micro.order.api.client.ConfigOrderFeignClient;
import com.morelinks.feign.micro.order.api.model.ConfigOrder;
import com.morelinks.feign.micro.order.api.model.ConfigOrderDetail;
import com.morelinks.feign.micro.product.api.client.ConfigCategoryFeignClient;
import com.morelinks.feign.micro.product.api.client.ProductBrandFeignClient;
import com.morelinks.feign.micro.product.api.dto.ConfigCategoryMenuDTO;
import com.morelinks.feign.micro.product.api.model.ConfigCategory;
import com.morelinks.feign.micro.product.api.model.ProductBrand;
import com.morelinks.service.micro.agent.manage.dto.CategoryDTO;
import com.morelinks.service.micro.agent.manage.dto.mall.BrandDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 配单 商品类别
 */
@RestController
@RequestMapping("/api/config/category")
public class ConfigProductCategoryController {
	@Autowired
	ConfigCategoryFeignClient configCategoryFeignClient;
	@Autowired
	ConfigOrderFeignClient configOrderFeignClient;
	@Autowired
	ConfigOrderDetailFeignClient configOrderDetailFeignClient;
	@Autowired
	ProductBrandFeignClient productBrandFeignClient;

	@RequestMapping(value = "/getCategoryMenus", method = {RequestMethod.GET, RequestMethod.POST})
	public IceAjaxResult<IceValueDTO<List<ConfigCategoryMenuDTO>>> getCategoryMenus(UserInfo userInfo, String orderId
	) {
		if (userInfo == null || userInfo.getUserStatus() != 1) {
			return IceAjaxResult.getFailResult("用户不存在");

		}

		if (orderId == null || "".equals(orderId.trim())) {
			return IceAjaxResult.getFailResult("无效订单信息");
		}
		QueryPageParam<ConfigOrder> configOrderQueryPageParam = new QueryPageParam<>();
		ConfigOrder order = new ConfigOrder();
		order.setUserId(userInfo.getId());
		order.setId(orderId);
		configOrderQueryPageParam.setQuery(order);
		ReturnValue<QueryResult<ConfigOrder>> queryResult = this.configOrderFeignClient.getQueryResult(configOrderQueryPageParam);
		if (queryResult == null) {

			return IceAjaxResult.getFailResult("系统繁忙请稍后再试");
		}
		if (queryResult.getObj().getItems().size() != 1) {
			return IceAjaxResult.getFailResult("无此订单");
		}
		String[] Ids = queryResult.getObj().getItems().get(0).getConfigCategoryIds().split(",");
		List<Integer> list = new ArrayList<>();

		for (String s : Ids) {

			list.add(Integer.parseInt(s));
		}
		ReturnValue<List<ConfigCategoryMenuDTO>> listReturnValue = this.configCategoryFeignClient.getConfigCategoryMenus(list);

		if (listReturnValue == null) {
			return IceAjaxResult.getFailResult("系统繁忙请稍后再试");

		}
		if (listReturnValue.getObj() == null) {

			return IceAjaxResult.getFailResult("未知分类信息");
		}

		for (ConfigCategoryMenuDTO dto : listReturnValue.getObj()) {
			QueryPageParam<ConfigOrderDetail> pageParam = new QueryPageParam<>();
			ConfigOrderDetail orderDetail = new ConfigOrderDetail();
			orderDetail.setFirstCategory(dto.getId());
			orderDetail.setOrderId(orderId);
			pageParam.setQuery(orderDetail);
			ReturnValue<QueryResult<ConfigOrderDetail>> returnValue = this.configOrderDetailFeignClient.getQueryResult(pageParam);
			if (returnValue.getObj().getItems().size() != 0) {
				Integer num = 0;
				for (ConfigOrderDetail detail : returnValue.getObj().getItems()) {

					num = num + detail.getProductNum();

				}
				dto.setNum(num.toString());
			} else {
				dto.setNum("0");

			}

		}
		IceAjaxResult<IceValueDTO<List<ConfigCategoryMenuDTO>>> result = new IceAjaxResult<>();
		IceValueDTO<List<ConfigCategoryMenuDTO>> listIceValueDTO = new IceValueDTO<>();
		listIceValueDTO.setValue(listReturnValue.getObj());
		result.setData(listIceValueDTO);
		result.setMessage("");
		return result;
	}

	@RequestMapping(value = "/getBrandList", method = {RequestMethod.GET, RequestMethod.POST})
	public IceAjaxResult<List<BrandDTO>> getBrandList(UserInfo userInfo) {
		if (userInfo == null || userInfo.getUserStatus() != 1) {
			return IceAjaxResult.getFailResult("用户不存在");

		}
		QueryPageParam<ProductBrand> queryPageParam = new QueryPageParam<>();
		ProductBrand brand = new ProductBrand();
		queryPageParam.setQuery(brand);
		ReturnValue<QueryResult<ProductBrand>> returnValue = this.productBrandFeignClient.getQueryResult(queryPageParam);
		List<BrandDTO> brandDTOList = new ArrayList<>();
		for (ProductBrand productBrand : returnValue.getObj().getItems()) {
			BrandDTO brandDTO = new BrandDTO();
			brandDTO.setValue(productBrand.getId());
			brandDTO.setLabel(productBrand.getBrandName());
			brandDTOList.add(brandDTO);
		}
		IceAjaxResult<List<BrandDTO>> result = new IceAjaxResult<>();
		result.setData(brandDTOList);
		result.setMessage("");
		return result;
	}

	@RequestMapping(value = "/getClassification", method = {RequestMethod.GET, RequestMethod.POST})
	public IceAjaxResult<List<CategoryDTO>> getClassification(String orderId, UserInfo userInfo) {
		if (userInfo == null || userInfo.getUserStatus() != 1) {
			return IceAjaxResult.getFailResult("用户不存在");

		}
		if (orderId == null || "".equals(orderId.trim())) {
			return IceAjaxResult.getFailResult("无效订单信息");
		}
		ConfigOrder order = this.configOrderFeignClient.getByPrimaryKey(orderId).getObj();
		String categoryIds = order.getConfigCategoryIds();
		List<Integer> ids = new ArrayList<>();
		if (categoryIds != null && !"".equals(categoryIds.trim())) {
			String[] id = categoryIds.split(",");
			for (String category : id) {
				ids.add(Integer.parseInt(category));
			}
		}
		List<ConfigCategory> categoryList = new ArrayList<>();
		for (Integer i : ids) {
			QueryPageParam<ConfigCategory> param = new QueryPageParam<>();
			ConfigCategory category = new ConfigCategory();
			category.setParentId(i);
			param.setQuery(category);
			List<ConfigCategory> configCategoryList = this.configCategoryFeignClient.getQueryResult(param).getObj().getItems();
			categoryList.addAll(configCategoryList);
		}
		List<CategoryDTO> dtos = new ArrayList<>();
		for (ConfigCategory category : categoryList) {
			CategoryDTO dto = new CategoryDTO();
			dto.setLabel(category.getCategoryName());
			dto.setValue(category.getId());
			dtos.add(dto);
		}
		IceAjaxResult<List<CategoryDTO>> result = new IceAjaxResult<>();
		result.setData(dtos);
		result.setMessage("");

		return result;
	}

}
