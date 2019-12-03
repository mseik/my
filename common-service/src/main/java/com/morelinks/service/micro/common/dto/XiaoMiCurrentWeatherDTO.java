package com.morelinks.service.micro.common.dto;

import com.alibaba.fastjson.JSON;

/**
 * 小米实时天气信息
 */
public class XiaoMiCurrentWeatherDTO {
	/**
	 * 当前天气信息
	 */
	private XiaoMiRealTimeWeatherDTO realtime;
	/**
	 * 日出日落信息
	 */
	private XiaoMiSunInfo sunInfo;
	/**
	 * 日出日落信息
	 */
	private String accu_f0;



	public XiaoMiRealTimeWeatherDTO getRealtime() {
		return realtime;
	}

	public void setRealtime(XiaoMiRealTimeWeatherDTO realtime) {
		this.realtime = realtime;
	}

	public String getAccu_f0() {
		return JSON.toJSONString(sunInfo);
	}

//	public void setAccu_f0(String accu_f0) {
////		this.accu_f0 = accu_f0;
//	}

	public XiaoMiSunInfo getSunInfo() {
		return sunInfo;
	}

	public void setSunInfo(XiaoMiSunInfo sunInfo) {
		this.sunInfo = sunInfo;
	}
}
