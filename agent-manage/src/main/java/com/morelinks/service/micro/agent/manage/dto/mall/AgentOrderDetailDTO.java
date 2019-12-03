package com.morelinks.service.micro.agent.manage.dto.mall;

public class AgentOrderDetailDTO {

	/**
	 * 索引 1开始
	 */
	private Integer index;
	/**
	 * 产品名称
	 */
	private String productName;
	/**
	 * 产品Id
	 */
	private String productId;
	/**
	 * 产品图片
	 */
	private String productPic;
	/**
	 * 产品数量
	 */
	private Integer productCount;
	/**
	 * 订单Id
	 */
	private String orderId;
	/**
	 * 同一订单产品类型数量 用以前端展示
	 */
	private Integer orderDetailCount;



	private String userName;

	private Double totalAmount;

	private Integer orderStatus;
	/**
	 * 订单状态名称
	 */
	private String orderStatusName;

	private Integer payType;

	private Integer payStatus;

	private String deliveryAddress;
	private String contactTel;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductPic() {
		return productPic;
	}

	public void setProductPic(String productPic) {
		this.productPic = productPic;
	}

	public Integer getProductCount() {
		return productCount;
	}

	public void setProductCount(Integer productCount) {
		this.productCount = productCount;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Integer getOrderDetailCount() {
		return orderDetailCount;
	}

	public void setOrderDetailCount(Integer orderDetailCount) {
		this.orderDetailCount = orderDetailCount;
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

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
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
