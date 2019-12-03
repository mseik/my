package com.morelinks.service.micro.agent.manage.dto.mall;

import com.morelinks.feign.micro.product.api.model.ProductProperty;

import java.util.List;

/**
 * 产品售卖对象
 */
public class ProductCartUnit {

	/**
	 * 产品Id
	 */
	private Integer id;
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
	 * 产品单价
	 */
	private double productAmount;
	/**
	 * 产品数量
	 */
	private Integer productNum;
	/**
	 * 最终价格
	 */
	private double productFinalAmount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public double getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(double productAmount) {
		this.productAmount = productAmount;
	}

	public Integer getProductNum() {
		return productNum;
	}

	public void setProductNum(Integer productNum) {
		this.productNum = productNum;
	}

	public double getProductFinalAmount() {
		return productFinalAmount;
	}

	public void setProductFinalAmount(double productFinalAmount) {
		this.productFinalAmount = productFinalAmount;
	}
}
