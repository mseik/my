package com.morelinks.feign.micro.common.api.model;

import java.util.Date;

/**
 * 描述:p_weather_log表的实体类
 * @version
 * @author:  sgfily
 * @创建时间: 2019-01-21
 */
public class WeatherLog {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String cityId;

    /**
     * 统计时间
     */
    private Date statTime;

    /**
     * 
     */
    private Date sunRiseTime;

    /**
     * 
     */
    private Date sunSetTime;

    /**
     * 
     */
    private String weather;

    /**
     * 
     */
    private String windLevel;

    /**
     * 
     */
    private String temp;

    /**
     * 湿度 百分比
     */
    private String humidity;

    /**
     * 
     */
    private String windDirection;

    /**
     * 
     */
    private String windSpeed;

    /**
     * 
     */
    private String pm25Val;

    /**
     * 空气质量 数值
     */
    private String aqiVal;

    /**
     * 空气质量显示
     */
    private String quality;

    /**
     * 
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return city_id 
     */
    public String getCityId() {
        return cityId;
    }

    /**
     * 
     * @param cityId 
     */
    public void setCityId(String cityId) {
        this.cityId = cityId == null ? null : cityId.trim();
    }

    /**
     * 统计时间
     * @return stat_time 统计时间
     */
    public Date getStatTime() {
        return statTime;
    }

    /**
     * 统计时间
     * @param statTime 统计时间
     */
    public void setStatTime(Date statTime) {
        this.statTime = statTime;
    }

    /**
     * 
     * @return sun_rise_time 
     */
    public Date getSunRiseTime() {
        return sunRiseTime;
    }

    /**
     * 
     * @param sunRiseTime 
     */
    public void setSunRiseTime(Date sunRiseTime) {
        this.sunRiseTime = sunRiseTime;
    }

    /**
     * 
     * @return sun_set_time 
     */
    public Date getSunSetTime() {
        return sunSetTime;
    }

    /**
     * 
     * @param sunSetTime 
     */
    public void setSunSetTime(Date sunSetTime) {
        this.sunSetTime = sunSetTime;
    }

    /**
     * 
     * @return weather 
     */
    public String getWeather() {
        return weather;
    }

    /**
     * 
     * @param weather 
     */
    public void setWeather(String weather) {
        this.weather = weather == null ? null : weather.trim();
    }

    /**
     * 
     * @return wind_level 
     */
    public String getWindLevel() {
        return windLevel;
    }

    /**
     * 
     * @param windLevel 
     */
    public void setWindLevel(String windLevel) {
        this.windLevel = windLevel == null ? null : windLevel.trim();
    }

    /**
     * 
     * @return temp 
     */
    public String getTemp() {
        return temp;
    }

    /**
     * 
     * @param temp 
     */
    public void setTemp(String temp) {
        this.temp = temp == null ? null : temp.trim();
    }

    /**
     * 湿度 百分比
     * @return humidity 湿度 百分比
     */
    public String getHumidity() {
        return humidity;
    }

    /**
     * 湿度 百分比
     * @param humidity 湿度 百分比
     */
    public void setHumidity(String humidity) {
        this.humidity = humidity == null ? null : humidity.trim();
    }

    /**
     * 
     * @return wind_direction 
     */
    public String getWindDirection() {
        return windDirection;
    }

    /**
     * 
     * @param windDirection 
     */
    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection == null ? null : windDirection.trim();
    }

    /**
     * 
     * @return wind_speed 
     */
    public String getWindSpeed() {
        return windSpeed;
    }

    /**
     * 
     * @param windSpeed 
     */
    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed == null ? null : windSpeed.trim();
    }

    /**
     * 
     * @return pm25_val 
     */
    public String getPm25Val() {
        return pm25Val;
    }

    /**
     * 
     * @param pm25Val 
     */
    public void setPm25Val(String pm25Val) {
        this.pm25Val = pm25Val == null ? null : pm25Val.trim();
    }

    /**
     * 空气质量 数值
     * @return aqi_val 空气质量 数值
     */
    public String getAqiVal() {
        return aqiVal;
    }

    /**
     * 空气质量 数值
     * @param aqiVal 空气质量 数值
     */
    public void setAqiVal(String aqiVal) {
        this.aqiVal = aqiVal == null ? null : aqiVal.trim();
    }

    /**
     * 空气质量显示
     * @return quality 空气质量显示
     */
    public String getQuality() {
        return quality;
    }

    /**
     * 空气质量显示
     * @param quality 空气质量显示
     */
    public void setQuality(String quality) {
        this.quality = quality == null ? null : quality.trim();
    }
}