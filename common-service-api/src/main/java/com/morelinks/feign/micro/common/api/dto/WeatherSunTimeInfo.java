package com.morelinks.feign.micro.common.api.dto;

import java.util.Date;

/**
 * 天气的日出日落信息
 */
public class WeatherSunTimeInfo {

    private Date weatherDate;
    /**
     * 日出时间
     */
    private Date sunRiseTime;
    /**
     * 日落时间
     */
    private Date sunSetTime;

    public Date getWeatherDate() {
        return weatherDate;
    }

    public void setWeatherDate(Date weatherDate) {
        this.weatherDate = weatherDate;
    }

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
}
