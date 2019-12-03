package com.morelinks.service.micro.agent.manage.dto.mall;

import com.morelinks.feign.micro.product.api.model.ProductProperty;

import java.util.List;

/**
 * 产品属性DTO
 */
public class SaleProductProperyDTO {

	/**
	 * 产品属性Id
	 */
	private Integer propertyId;
	/**
	 * 产品属性名称
	 */
	private String propertyName;
	/**
	 * 是否选中
	 */
	private String selected;

	public Integer getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Integer propertyId) {
		this.propertyId = propertyId;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}
}
