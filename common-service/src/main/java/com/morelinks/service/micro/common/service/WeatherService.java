package com.morelinks.service.micro.common.service;

import com.morelinks.feign.micro.common.api.dto.WeatherSunRealTimeInfo;
import com.morelinks.feign.micro.common.api.dto.WeatherSunTimeInfo;
import com.morelinks.service.micro.common.dto.XiaoMiCurrentWeatherDTO;

import java.util.Map;

public interface WeatherService {
    XiaoMiCurrentWeatherDTO getWeather(String cityId);

    Map<String,WeatherSunTimeInfo> getWeatherSunTimeMap(String cityId);

    WeatherSunRealTimeInfo getCurrentWeather(String cityId);
}
