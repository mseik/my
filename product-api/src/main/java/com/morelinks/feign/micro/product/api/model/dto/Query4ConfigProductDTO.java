package com.morelinks.feign.micro.product.api.model.dto;

import com.morelinks.core.model.Page;

import java.util.List;

/**
 * 查询产品对象
 */
public class Query4ConfigProductDTO {
	/**
	 * 品牌Id 列表
	 */
	private List<Integer> brandIds;
	/**
	 * 类别列表
	 */
	private List<Integer> categoryIds;
	/**
	 * 产品名称
	 */
	private String productName;
	/**
	 * 代理商Id
	 */
	private Integer agentId;

	private Integer productStatus;

	public List<Integer> getBrandIds() {
		return brandIds;
	}

	public void setBrandIds(List<Integer> brandIds) {
		this.brandIds = brandIds;
	}

	public List<Integer> getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(List<Integer> categoryIds) {
		this.categoryIds = categoryIds;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}


	public Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

	public Integer getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(Integer productStatus) {
		this.productStatus = productStatus;
	}
}
