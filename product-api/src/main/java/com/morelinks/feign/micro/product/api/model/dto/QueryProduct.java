package com.morelinks.feign.micro.product.api.model.dto;

import com.morelinks.core.model.Page;

import java.util.List;

/**
 * 查询产品对象
 */
public class QueryProduct {
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
	/**
	 * 分页
	 */
	private Page page = new Page();

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

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}
}
