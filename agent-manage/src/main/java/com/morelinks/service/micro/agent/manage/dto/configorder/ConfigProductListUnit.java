package com.morelinks.service.micro.agent.manage.dto.configorder;

import java.util.List;

/**
 * 商品列表单元
 */
public class ConfigProductListUnit {
	/**
	 * 商品记录Id
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
	 * 商品简述
	 */
	private String productResume;
	/**
	 * 型号名称
	 */
	private String modelName;

	private String brandName;
	/**
	 * 订单已选商品数量
	 */
	private String productNum;
	/**
	 * 商品价格
	 */
	private String productAmount;
	/**
	 * 图片Url
	 */
	private String logoUrl;
	/**
	 * 添加类型 1：普通按钮有数量  2：只有加号的按钮
	 */
	private  Integer addType;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductResume() {
		return productResume;
	}

	public void setProductResume(String productResume) {
		this.productResume = productResume;
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

	public Integer getProductType() {
		return productType;
	}

	public void setProductType(Integer productType) {
		this.productType = productType;
	}

	public Integer getAddType() {
		return addType;
	}

	public void setAddType(Integer addType) {
		this.addType = addType;
	}

	public String getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(String productAmount) {
		this.productAmount = productAmount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

public String getBrandName() {
	return brandName;
}

public void setBrandName(String brandName) {
	this.brandName = brandName;
}

@Override
public String toString() {
	return "ConfigProductListUnit{" +
		"id='" + id + '\'' +
		", productId='" + productId + '\'' +
		", productType=" + productType +
		", productName='" + productName + '\'' +
		", productResume='" + productResume + '\'' +
		", modelName='" + modelName + '\'' +
		", brandName='" + brandName + '\'' +
		", productNum='" + productNum + '\'' +
		", productAmount='" + productAmount + '\'' +
		", logoUrl='" + logoUrl + '\'' +
		", addType=" + addType +
		'}';
}
}
