package com.morelinks.service.micro.agent.manage.dto.mall;

/**
 * 订单form对象
 */
public class AgentOrderFormDTO {

	/**
	 * 配送地址Id
	 */
	private String addressId;
	/**
	 * 支付类型 1：线下支付 2：在线支付
	 */
	private Integer payType;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 页面显示价格
	 */
	private String showAmount;

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
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

	public String getShowAmount() {
		return showAmount;
	}

	public void setShowAmount(String showAmount) {
		this.showAmount = showAmount;
	}
}
