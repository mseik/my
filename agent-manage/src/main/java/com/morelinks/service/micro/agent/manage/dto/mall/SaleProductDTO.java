package com.morelinks.service.micro.agent.manage.dto.mall;

import com.morelinks.feign.micro.product.api.model.ProductProperty;

import java.util.List;

/**
 * 产品售卖对象
 */
public class SaleProductDTO {

	/**
	 * 产品Id
	 */
	private String productId;
	/**
	 * 产品名称
	 */
	private String productName;
	/**
	 * 产品简述
	 */
	private String productResume;
	/**
	 * 展示图片
	 */
	private String coverPicUrl;
	/**
	 * 产品属性
	 */
	private List<ProductProperty> lstProperty;
	/**
	 * 产品价格
	 */
	private Double productAmount;

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

	public String getCoverPicUrl() {
		return coverPicUrl;
	}

	public void setCoverPicUrl(String coverPicUrl) {
		this.coverPicUrl = coverPicUrl;
	}

	public List<ProductProperty> getLstProperty() {
		return lstProperty;
	}

	public void setLstProperty(List<ProductProperty> lstProperty) {
		this.lstProperty = lstProperty;
	}

	public Double getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(Double productAmount) {
		this.productAmount = productAmount;
	}
}
