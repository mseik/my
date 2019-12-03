package com.morelinks.feign.micro.product.api.dto;

import com.morelinks.feign.micro.product.api.model.*;

import java.util.List;

/**
 * 产品 dto对象 用于产品呈现
 */
public class ProductDTO extends Product {

	/**
	 * 有关的属性
	 */
	private List<ProductProperty> lstProperty;

	private List<ProductImg> lstImg;

	public List<ProductProperty> getLstProperty() {
		return lstProperty;
	}

	public void setLstProperty(List<ProductProperty> lstProperty) {
		this.lstProperty = lstProperty;
	}

	public List<ProductImg> getLstImg() {
		return lstImg;
	}

	public void setLstImg(List<ProductImg> lstImg) {
		this.lstImg = lstImg;
	}
}
