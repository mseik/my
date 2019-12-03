package com.morelinks.feign.micro.order.api.dto;

import com.morelinks.feign.micro.order.api.model.ExpressOrder;

public class ExpressOrder4Submit extends ExpressOrder {
	private String operator;
	private Integer operatorType;
	private String operatorRemark;

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Integer getOperatorType() {
		return operatorType;
	}

	public void setOperatorType(Integer operatorType) {
		this.operatorType = operatorType;
	}

	public String getOperatorRemark() {
		return operatorRemark;
	}

	public void setOperatorRemark(String operatorRemark) {
		this.operatorRemark = operatorRemark;
	}
}
