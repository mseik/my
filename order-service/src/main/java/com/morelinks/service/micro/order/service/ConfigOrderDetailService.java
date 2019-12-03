package com.morelinks.service.micro.order.service;

import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.exception.BusinessException;
import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.micro.order.api.dto.QuerySelectedProducts;
import com.morelinks.feign.micro.order.api.dto.SelectedProducts;
import com.morelinks.feign.micro.order.api.model.ConfigOrderDetail;
import com.morelinks.feign.micro.product.api.client.ConfigCategoryFeignClient;
import com.morelinks.feign.micro.product.api.model.dto.QueryParentAggregate;
import com.morelinks.service.micro.order.mapper.ConfigOrderDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class ConfigOrderDetailService extends BaseServiceWithQueryPage<ConfigOrderDetail, String, ConfigOrderDetailMapper> {
	@Autowired
	ConfigCategoryFeignClient categoryFeignClient;

	public Integer deleteSelectedProducts(SelectedProducts selectedProducts) {
		if (selectedProducts == null) {
			throw new BusinessException("引用对象为null");

		}
		if (selectedProducts.getOrderId() == null || "".equals(selectedProducts.getOrderId().trim())) {
			throw new BusinessException("未知订单");

		}
		if (selectedProducts.getListId() == null || selectedProducts.getListId().size() == 0) {
			throw new BusinessException("商品为空");

		}

		return this.mapper.deleteSelectedProducts(selectedProducts);
	}

	public Integer deleteDetail(SelectedProducts selectedProducts) {
		if (selectedProducts.getOrderId() == null || "".equals(selectedProducts.getOrderId().trim())) {
			throw new BusinessException("未知订单");

		}
		return this.mapper.deleteSelectedProducts(selectedProducts);
	}


	public List<ConfigOrderDetail> querySelectedProducts(QuerySelectedProducts products) {
		if (products == null) {
			throw new BusinessException("对象引用为null");
		}

		if (products.getOrderId() == null || "".equals(products.getOrderId().trim())) {
			throw new BusinessException("未知订单信息");

		}
		if (products.getListCategoryId() == null || products.getListCategoryId().size() == 0) {
			throw new BusinessException("分类为空");

		}

		ReturnValue<List<Integer>> retCategory = this.categoryFeignClient.findAllCateogyrIds(products.getListCategoryId());
		if(retCategory.getObj()==null || retCategory.getObj().size()<=0)
		{
			throw new BusinessException("分类为空");
		}
		products.setListCategoryId( retCategory.getObj());
		List<ConfigOrderDetail> detailList = this.mapper.querySelectedProducts(products);

		if (detailList == null || detailList.size() == 0) {
			new ArrayList<>();

		}

		return detailList;
	}
}