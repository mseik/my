package com.morelinks.service.micro.agent.manage.dto.configorder;

/**
 * 其他金额设置对象
 */
public class ConfigCategoryAmountSetUnit {

	/**
	 * 类别Id
	 */
	private Integer categoryId;
	/**
	 * 类别名称
	 */
	private String categoryName;
	/**
	 * 1：参与折扣 2：不参与折扣 3： 一口价
	 */
	private Integer amountType;
	/**
	 * 数值
	 */
	private String amount;

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getAmountType() {
		return amountType;
	}

	public void setAmountType(Integer amountType) {
		this.amountType = amountType;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

@Override
public String toString() {
	return "ConfigCategoryAmountSetUnit{" +
		"categoryId=" + categoryId +
		", categoryName='" + categoryName + '\'' +
		", amountType=" + amountType +
		", amount='" + amount + '\'' +
		'}';
}
}
