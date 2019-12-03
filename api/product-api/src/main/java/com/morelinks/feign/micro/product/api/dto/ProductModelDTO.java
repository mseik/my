package com.morelinks.feign.micro.product.api.dto;

import com.morelinks.feign.micro.product.api.model.*;

import java.util.List;

/**
 * 产品型号 dto对象 用于产品呈现
 */
public class ProductModelDTO extends ProductModel {
	/**
	 * 型号下 具体产品列表
	 */
	private List<ProductDTO> lstProduct;
	/**
	 * 型号图片 取十张
	 */
	private List<ProductImg> lstImg;
	/**
	 * 有关的属性
	 */
	private List<ProductPropertyType> lstPropertyType;
	/**
	 * 有关的属性
	 */
	private List<ProductProperty> lstProperty;

	public List<ProductDTO> getLstProduct() {
		return lstProduct;
	}

	public void setLstProduct(List<ProductDTO> lstProduct) {
		this.lstProduct = lstProduct;
	}

	public List<ProductImg> getLstImg() {
		return lstImg;
	}

	public void setLstImg(List<ProductImg> lstImg) {
		this.lstImg = lstImg;
	}

	public List<ProductProperty> getLstProperty() {
		return lstProperty;
	}

	public void setLstProperty(List<ProductProperty> lstProperty) {
		this.lstProperty = lstProperty;
	}

	public List<ProductPropertyType> getLstPropertyType() {
		return lstPropertyType;
	}

	public void setLstPropertyType(List<ProductPropertyType> lstPropertyType) {
		this.lstPropertyType = lstPropertyType;
	}
}
