package com.morelinks.service.micro.agent.manage.dto.configorder;

import com.morelinks.core.dto.IceSelectData;
import com.morelinks.service.micro.agent.manage.dto.mall.CascaderSelectDTO;

import java.util.List;

/**
 * 配单添加或修改 提交表单
 */
public class ConfigOrderForm {
	/**
	 * 订单Id 无值为添加 有值为修改
	 */
	private String id;
	/**
	 * 订单名称
	 */
	private String orderName;
	/**
	 * 顾客姓名
	 */
	private String customerName;
	/**
	 * 顾客联系方式
	 */
	private String customerTel;
	/**
	 * 默认选择的类别
	 */
	private List<String> lstCategorySelData;
	/**
	 * 可选择的类别列表 提交时不需要
	 */
	private List<IceSelectData> lstCategory;
	/**
	 * 城市Id
	 */
	private String cityId;
	/**
	 * 可选择的城市列表 提交时不需要
	 */
	private List<CascaderSelectDTO> listCity;
	/**
	 * 地址
	 */
	private String address;

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getOrderName() {
	return orderName;
}

public void setOrderName(String orderName) {
	this.orderName = orderName;
}

public String getCustomerName() {
	return customerName;
}

public void setCustomerName(String customerName) {
	this.customerName = customerName;
}

public String getCustomerTel() {
	return customerTel;
}

public void setCustomerTel(String customerTel) {
	this.customerTel = customerTel;
}

public List<String> getLstCategorySelData() {
	return lstCategorySelData;
}

public void setLstCategorySelData(List<String> lstCategorySelData) {
	this.lstCategorySelData = lstCategorySelData;
}

public List<IceSelectData> getLstCategory() {
	return lstCategory;
}

public void setLstCategory(List<IceSelectData> lstCategory) {
	this.lstCategory = lstCategory;
}

public String getCityId() {
	return cityId;
}

public void setCityId(String cityId) {
	this.cityId = cityId;
}

public List<CascaderSelectDTO> getListCity() {
	return listCity;
}

public void setListCity(List<CascaderSelectDTO> listCity) {
	this.listCity = listCity;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

@Override
public String toString() {
	return "ConfigOrderForm{" +
		"id='" + id + '\'' +
		", orderName='" + orderName + '\'' +
		", customerName='" + customerName + '\'' +
		", customerTel='" + customerTel + '\'' +
		", lstCategorySelData=" + lstCategorySelData +
		", lstCategory=" + lstCategory +
		", cityId='" + cityId + '\'' +
		", listCity=" + listCity +
		", address='" + address + '\'' +
		'}';
}
}
