package com.morelinks.service.micro.agent.manage.dto.mall;

import java.util.List;

/**
 * 订单列表数据对象
 */
public class AgentOrderListUnitDTO {
	private String orderId;

	private String userName;
	private String deliveryAddress;
	private String contactTel;

	private Double totalAmount;

	private Integer orderStatus;
	/**
	 * 订单状态名称
	 */
	private String orderStatusName;

	private Integer payType;

	private Integer payStatus;

	/**
	 * 订单单产品详情对象
	 */
	private List<AgentOrderDetailDTO> children;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderStatusName() {
		return orderStatusName;
	}

	public void setOrderStatusName(String orderStatusName) {
		this.orderStatusName = orderStatusName;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public List<AgentOrderDetailDTO> getChildren() {
		return children;
	}

	public void setChildren(List<AgentOrderDetailDTO> children) {
		this.children = children;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getContactTel() {
		return contactTel;
	}

	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}
}
