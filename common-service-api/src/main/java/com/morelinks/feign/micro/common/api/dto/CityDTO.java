package com.morelinks.feign.micro.common.api.dto;

/**
 * 城市基础对象
 */
public class CityDTO {
	/**
	 * 城市Id
	 */
	private String cityId;
	/**
	 * 城市名
	 */
	private String cityName;
	/**
	 * 城市类型 1:省 2：市 3：区
	 */
	private Integer cityType;
	/**
	 * 上级Id
	 */
	private String parentCityId;

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Integer getCityType() {
		return cityType;
	}

	public void setCityType(Integer cityType) {
		this.cityType = cityType;
	}

	public String getParentCityId() {
		return parentCityId;
	}

	public void setParentCityId(String parentCityId) {
		this.parentCityId = parentCityId;
	}
}
