package com.morelinks.feign.micro.common.api.model;

/**
 * 描述:p_weather_city表的实体类
 * @version
 * @author:  sgfily
 * @创建时间: 2019-01-21
 */
public class WeatherCity {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 城市ID
     */
    private String cityId;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 城市类型 1：省 2：市 3：县
     */
    private Integer cityType;

    /**
     * 
     */
    private String parentCityId;

    /**
     * 
     */
    private String cityPinyin;

    /**
     * 
     */
    private Double latitude;

    /**
     * 
     */
    private Double longitude;

    /**
     * 主键
     * @return ID 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 城市ID
     * @return CITY_ID 城市ID
     */
    public String getCityId() {
        return cityId;
    }

    /**
     * 城市ID
     * @param cityId 城市ID
     */
    public void setCityId(String cityId) {
        this.cityId = cityId == null ? null : cityId.trim();
    }

    /**
     * 城市名称
     * @return CITY_NAME 城市名称
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * 城市名称
     * @param cityName 城市名称
     */
    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    /**
     * 城市类型 1：省 2：市 3：县
     * @return city_type 城市类型 1：省 2：市 3：县
     */
    public Integer getCityType() {
        return cityType;
    }

    /**
     * 城市类型 1：省 2：市 3：县
     * @param cityType 城市类型 1：省 2：市 3：县
     */
    public void setCityType(Integer cityType) {
        this.cityType = cityType;
    }

    /**
     * 
     * @return parent_city_id 
     */
    public String getParentCityId() {
        return parentCityId;
    }

    /**
     * 
     * @param parentCityId 
     */
    public void setParentCityId(String parentCityId) {
        this.parentCityId = parentCityId == null ? null : parentCityId.trim();
    }

    /**
     * 
     * @return city_pinyin 
     */
    public String getCityPinyin() {
        return cityPinyin;
    }

    /**
     * 
     * @param cityPinyin 
     */
    public void setCityPinyin(String cityPinyin) {
        this.cityPinyin = cityPinyin == null ? null : cityPinyin.trim();
    }

    /**
     * 
     * @return latitude 
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * 
     * @param latitude 
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     * 
     * @return longitude 
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * 
     * @param longitude 
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}