package com.morelinks.service.micro.agent.manage.dto.configorder;

import java.math.BigDecimal;

/**
 * 订单商品列表单元
 */
public class ConfigCategorySelectedProductListUnit implements Comparable<ConfigCategorySelectedProductListUnit>{
	/**
	 * 类别Id
	 */
	private Integer categoryId;
	/**
	 * 类别名
	 */
	private String categoryName;
	/**
	 * 原始总价格
	 */
	private BigDecimal totalAmount;

	/**
	 * 折扣率 0-100
	 */
	private Integer discountRate;
	/**
	 * 折扣后总价格
	 */
	private BigDecimal finalAmount;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Integer getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(Integer discountRate) {
		this.discountRate = discountRate;
	}

	public BigDecimal getFinalAmount() {
		return finalAmount;
	}

	public void setFinalAmount(BigDecimal finalAmount) {
		this.finalAmount = finalAmount;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

@Override
public int compareTo(ConfigCategorySelectedProductListUnit o) {
	return this.categoryId-o.getCategoryId()>0 ? 1 : -1;
}

@Override
public String toString() {
	return "ConfigCategorySelectedProductListUnit{" +
		"categoryId=" + categoryId +
		", categoryName='" + categoryName + '\'' +
		", totalAmount=" + totalAmount +
		", discountRate=" + discountRate +
		", finalAmount=" + finalAmount +
		'}';
}
}
