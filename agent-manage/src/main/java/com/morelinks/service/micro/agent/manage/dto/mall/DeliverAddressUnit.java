package com.morelinks.service.micro.agent.manage.dto.mall;

import com.morelinks.core.util.StringUtil;
import com.morelinks.core.util.TelUtil;
import com.morelinks.feign.micro.order.api.model.AgentDeliveryAddress;

import java.util.List;

/**
 * 地址列表对象
 */
public class DeliverAddressUnit extends AgentDeliveryAddress {

	/**
	 * 城市名
	 */
	private String cityName;
	/**
	 * 显示的电话
	 */
	private String telShow;

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getTelShow() {
		return TelUtil.getTelShow(this.getContactTel());
	}

	public void setTelShow(String telShow) {
		this.telShow = telShow;
	}
}
