package com.morelinks.service.micro.agent.manage.dto.mall;

import java.util.List;

/**
 * 产品属性类别对象
 */
public class SaleProductProperyTypeDTO {

	/**
	 * 产品属性类别Id
	 */
	private Integer propertyTypeId;
	/**
	 * 产品属性类别名称
	 */
	private String propertyTypeName;
	/**
	 * 产品属性列表
	 */
	private List<SaleProductProperyDTO> lstProperty;


	public Integer getPropertyTypeId() {
		return propertyTypeId;
	}

	public void setPropertyTypeId(Integer propertyTypeId) {
		this.propertyTypeId = propertyTypeId;
	}

	public List<SaleProductProperyDTO> getLstProperty() {
		return lstProperty;
	}

	public void setLstProperty(List<SaleProductProperyDTO> lstProperty) {
		this.lstProperty = lstProperty;
	}

	public String getPropertyTypeName() {
		return propertyTypeName;
	}

	public void setPropertyTypeName(String propertyTypeName) {
		this.propertyTypeName = propertyTypeName;
	}
}
