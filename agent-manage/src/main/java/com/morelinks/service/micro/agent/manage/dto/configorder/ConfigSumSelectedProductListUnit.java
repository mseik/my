package com.morelinks.service.micro.agent.manage.dto.configorder;

/**
 * 商品列表单元
 */
public class ConfigSumSelectedProductListUnit {
	/**
	 * 记录Id
	 */
	private String id;
	/**
	 * 商品Id
	 */
	private String productId;
	/**
	 * 商品类别 1：迈联商品 2：自定义商品 3：套餐商品
	 */
	private Integer productType;
	/**
	 * 商品名称
	 */
	private String productName;
	/**
	 * 品牌名称
	 */
	private String brandName;
	/**
	 * 商品类别
	 */
	private String categoryName;
	/**
	 * 型号名称
	 */
	private String modelName;
	/**
	 * 订单已选商品数量
	 */
	private String productNum;
	/**
	 * 图片Url
	 */
	private String logoUrl;
	/**
	 * 单价
	 */
	private String productAmount;
	/**
	 * 总价
	 */
	private String totalAmount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Integer getProductType() {
		return productType;
	}

	public void setProductType(Integer productType) {
		this.productType = productType;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getProductNum() {
		return productNum;
	}

	public void setProductNum(String productNum) {
		this.productNum = productNum;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public String getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(String productAmount) {
		this.productAmount = productAmount;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

@Override
public String toString() {
	return "ConfigSumSelectedProductListUnit{" +
		"id='" + id + '\'' +
		", productId='" + productId + '\'' +
		", productType=" + productType +
		", productName='" + productName + '\'' +
		", brandName='" + brandName + '\'' +
		", categoryName='" + categoryName + '\'' +
		", modelName='" + modelName + '\'' +
		", productNum='" + productNum + '\'' +
		", logoUrl='" + logoUrl + '\'' +
		", productAmount='" + productAmount + '\'' +
		", totalAmount='" + totalAmount + '\'' +
		'}';
}
}
