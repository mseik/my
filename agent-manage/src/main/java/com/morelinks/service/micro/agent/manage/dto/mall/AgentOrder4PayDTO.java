package com.morelinks.service.micro.agent.manage.dto.mall;

/**
 * 订单详情对象
 */
public class AgentOrder4PayDTO {

	/**
	 * 订单Id
	 */
	private String orderId;
	/**
	 * 订单Id
	 */
	private String payOrderId;
	/**
	 * 支付类型 1：线下支付 2：在线支付
	 */
	private Integer payType;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 总价格
	 */
	private Double totalAmount;
	/**
	 * 普通产品价格
	 */
	private Double commonProductAmount;
	/**
	 * 核心产品价格
	 */
	private Double coreProductAmount;
	/**
	 * 货款余额
	 */
	private Double goodsAccountAmount;
	/**
	 * 账户余额
	 */
	private Double accountAmount;
	/**
	 * 货款支付金额
	 */
	private Double goodsPayAmount;
	/**
	 * 账户支付金额
	 */
	private Double accountPayAmount;
	/**
	 * 剩余支付金额
	 */
	private Double waitPayAmount;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Double getCommonProductAmount() {
		return commonProductAmount;
	}

	public void setCommonProductAmount(Double commonProductAmount) {
		this.commonProductAmount = commonProductAmount;
	}

	public Double getCoreProductAmount() {
		return coreProductAmount;
	}

	public void setCoreProductAmount(Double coreProductAmount) {
		this.coreProductAmount = coreProductAmount;
	}

	public Double getGoodsAccountAmount() {
		return goodsAccountAmount;
	}

	public void setGoodsAccountAmount(Double goodsAccountAmount) {
		this.goodsAccountAmount = goodsAccountAmount;
	}

	public Double getAccountAmount() {
		return accountAmount;
	}

	public void setAccountAmount(Double accountAmount) {
		this.accountAmount = accountAmount;
	}

	public Double getWaitPayAmount() {
		return waitPayAmount;
	}

	public void setWaitPayAmount(Double waitPayAmount) {
		this.waitPayAmount = waitPayAmount;
	}

	public String getPayOrderId() {
		return payOrderId;
	}

	public void setPayOrderId(String payOrderId) {
		this.payOrderId = payOrderId;
	}

	public Double getGoodsPayAmount() {
		return goodsPayAmount;
	}

	public void setGoodsPayAmount(Double goodsPayAmount) {
		this.goodsPayAmount = goodsPayAmount;
	}

	public Double getAccountPayAmount() {
		return accountPayAmount;
	}

	public void setAccountPayAmount(Double accountPayAmount) {
		this.accountPayAmount = accountPayAmount;
	}
}
