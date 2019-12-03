package com.morelinks.feign.micro.order.api.dto;

import java.math.BigDecimal;

public class AgentOrderAmountModifyForm {
	private String agentOrderId;
	private BigDecimal goodsModifyAmount;
	private BigDecimal commonModifyAmount;
	private String operator;
	private String remark;

	public String getAgentOrderId() {
		return agentOrderId;
	}

	public void setAgentOrderId(String agentOrderId) {
		this.agentOrderId = agentOrderId;
	}

	public BigDecimal getGoodsModifyAmount() {
		return goodsModifyAmount;
	}

	public void setGoodsModifyAmount(BigDecimal goodsModifyAmount) {
		this.goodsModifyAmount = goodsModifyAmount;
	}

	public BigDecimal getCommonModifyAmount() {
		return commonModifyAmount;
	}

	public void setCommonModifyAmount(BigDecimal commonModifyAmount) {
		this.commonModifyAmount = commonModifyAmount;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
