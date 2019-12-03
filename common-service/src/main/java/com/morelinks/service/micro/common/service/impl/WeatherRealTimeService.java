package com.morelinks.service.micro.common.service.impl;

import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.micro.common.api.model.WeatherRealTime;
import com.morelinks.service.micro.common.mapper.WeatherRealTimeMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class WeatherRealTimeService extends BaseServiceWithQueryPage<WeatherRealTime,Integer,WeatherRealTimeMapper> {
}