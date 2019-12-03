package com.morelinks.feign.micro.pay.api.model.dto;

import java.util.Date;
import java.util.List;

/**
 * 订单查询对象
 */
public class Query4PayOrder {
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
	private Integer inAccountId;
	private Integer outAccountId;




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

	public Integer getInAccountId() {
		return inAccountId;
	}

	public void setInAccountId(Integer inAccountId) {
		this.inAccountId = inAccountId;
	}

	public Integer getOutAccountId() {
		return outAccountId;
	}

	public void setOutAccountId(Integer outAccountId) {
		this.outAccountId = outAccountId;
	}
}
