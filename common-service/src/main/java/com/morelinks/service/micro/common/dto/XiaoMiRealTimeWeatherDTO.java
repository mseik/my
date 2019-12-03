package com.morelinks.service.micro.common.dto;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 小米天气实时信息
 *  "SD": "47%",
 *  "WD": "南风",
 *  "WS": "2级",
 *  "WSE": "",
 *  "city": "",
 *  "cityid": "101010100",
 *  "isRadar": "1",
 *  "radar": "JC_RADAR_AZ9010_JB",
 *  "temp": "16",
 *  "time": "17:03",
 *  "weather": "晴"
 */
public class XiaoMiRealTimeWeatherDTO {
	/**
	 * 天气情况
	 */
	private String weather;
	/**
	 * 风力
	 */
	@JSONField(name ="WS")
	private String WS;
	/**
	 * 湿度
	 */
	@JSONField(name ="SD")
	private String SD;
	/**
	 * 风向
	 */
	@JSONField(name ="WD")
	private String WD;
	/**
	 * 温度
	 */
	private String temp;
	/**
	 * PM2.5数值
	 */
	private String pm25;
	/**
	 * 空气质量 数值
	 */
	private String aqi;
	/**
	 * 空气质量 显示
	 */
	private String quality;

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getWS() {
		return WS;
	}

	public void setWS(String WS) {
		this.WS = WS;
	}

	public String getSD() {
		return SD;
	}

	public void setSD(String SD) {
		this.SD = SD;
	}

	public String getWD() {
		return WD;
	}

	public void setWD(String WD) {
		this.WD = WD;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getPm25() {
		return pm25;
	}

	public void setPm25(String pm25) {
		this.pm25 = pm25;
	}

	public String getAqi() {
		return aqi;
	}

	public void setAqi(String aqi) {
		this.aqi = aqi;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}
}
