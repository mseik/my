package com.morelinks.feign.micro.product.api.model.dto;

import java.util.Date;
import java.util.List;

public class Query4ProductModel {

	private List<Integer> categoryIds;
	private List<Integer> brandIds;
	/**
	 * like 查询
	 */
	private String modelLikeName;
	/**
	 * 产品状态 1：添加 2：上线零售 2：下架零售
	 */
	private List<Integer> modelStatuss;

	/**
	 * 对外显示名称
	 */
	private String showLikeName;
	/**
	 * 是否对外销售 0：不对外 1：对外
	 */
	private Integer isAgentSale;

	public List<Integer> getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(List<Integer> categoryIds) {
		this.categoryIds = categoryIds;
	}

	public List<Integer> getBrandIds() {
		return brandIds;
	}

	public void setBrandIds(List<Integer> brandIds) {
		this.brandIds = brandIds;
	}

	public String getModelLikeName() {
		return modelLikeName;
	}

	public void setModelLikeName(String modelLikeName) {
		this.modelLikeName = modelLikeName;
	}

	public List<Integer> getModelStatuss() {
		return modelStatuss;
	}

	public void setModelStatuss(List<Integer> modelStatuss) {
		this.modelStatuss = modelStatuss;
	}

	public String getShowLikeName() {
		return showLikeName;
	}

	public void setShowLikeName(String showLikeName) {
		this.showLikeName = showLikeName;
	}

	public Integer getIsAgentSale() {
		return isAgentSale;
	}

	public void setIsAgentSale(Integer isAgentSale) {
		this.isAgentSale = isAgentSale;
	}
}
