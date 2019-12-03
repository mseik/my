package com.morelinks.feign.micro.order.api.model.dto;

import java.util.Date;
import java.util.List;

/**
 * 订单查询对象
 */
public class Query4Order {

	private String userId;
	/**
	 * 代理商Id
	 */
	private Integer agentId;

	private List<Integer> orderStatuss;
	/**
	 * 下单开始时间
	 */
	private Date startOrderTime;

	/**
	 * 下单结束时间
	 */
	private Date endOrderTime;

	private Integer orderType;
	private Integer fromType;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<Integer> getOrderStatuss() {
		return orderStatuss;
	}

	public void setOrderStatuss(List<Integer> orderStatuss) {
		this.orderStatuss = orderStatuss;
	}

	public Date getStartOrderTime() {
		return startOrderTime;
	}

	public void setStartOrderTime(Date startOrderTime) {
		this.startOrderTime = startOrderTime;
	}

	public Date getEndOrderTime() {
		return endOrderTime;
	}

	public void setEndOrderTime(Date endOrderTime) {
		this.endOrderTime = endOrderTime;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public Integer getFromType() {
		return fromType;
	}

	public void setFromType(Integer fromType) {
		this.fromType = fromType;
	}

	public Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}
}
