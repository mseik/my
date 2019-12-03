package com.morelinks.feign.micro.common.api.dto;

import java.util.Date;

/**
 * 天气的日出日落信息
 */
public class WeatherSunRealTimeInfo {
    /**
     * 日出时间
     */
    private Date sunRiseTime;
    /**
     * 日落时间
     */
    private Date sunSetTime;
    /**
     * 天气
     */
    private String curWeather;
    /**
     * 风力
     */
    private String curWindLevel;
    /**
     * 温度
     */
    private String temp;

    /**
     * 湿度 百分比
     */
    private String humidity;

    /**
     * 风向
     */
    private String windDirection;
    /**
     * 风速
     */
    private String windSpeed;
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

    public Date getSunRiseTime() {
        return sunRiseTime;
    }

    public void setSunRiseTime(Date sunRiseTime) {
        this.sunRiseTime = sunRiseTime;
    }

    public Date getSunSetTime() {
        return sunSetTime;
    }

    public void setSunSetTime(Date sunSetTime) {
        this.sunSetTime = sunSetTime;
    }

    public String getCurWeather() {
        return curWeather;
    }

    public void setCurWeather(String curWeather) {
        this.curWeather = curWeather;
    }

    public String getCurWindLevel() {
        return curWindLevel;
    }

    public void setCurWindLevel(String curWindLevel) {
        this.curWindLevel = curWindLevel;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
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
