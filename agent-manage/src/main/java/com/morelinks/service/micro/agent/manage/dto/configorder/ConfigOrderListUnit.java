package com.morelinks.service.micro.agent.manage.dto.configorder;

import java.util.List;

/**
 * 配单列表单元
 */
public class ConfigOrderListUnit {
	private String orderId;
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
	 * 项目类别
	 */
	private List<String> lstCategoryName;
	/**
	 * 订单状态
	 */
	private Integer orderStatus;
	/**
	 * 订单日期
	 *
	 */
	private String orderTime;
	/**
	 * 项目完整地址
	 */
	private String fullAddress;

public String getOrderId() {
	return orderId;
}

public void setOrderId(String orderId) {
	this.orderId = orderId;
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

	public List<String> getLstCategoryName() {
		return lstCategoryName;
	}

	public void setLstCategoryName(List<String> lstCategoryName) {
		this.lstCategoryName = lstCategoryName;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public String getFullAddress() {
		return fullAddress;
	}


	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

@Override
public String toString() {
	return "ConfigOrderListUnit{" +
		"orderId='" + orderId + '\'' +
		", orderName='" + orderName + '\'' +
		", customerName='" + customerName + '\'' +
		", customerTel='" + customerTel + '\'' +
		", lstCategoryName=" + lstCategoryName +
		", orderStatus=" + orderStatus +
		", orderTime='" + orderTime + '\'' +
		", fullAddress='" + fullAddress + '\'' +
		'}';
}
}
