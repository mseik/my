package com.morelinks.service.micro.common.service.impl;

import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.micro.common.api.model.WeatherLog;
import com.morelinks.service.micro.common.mapper.WeatherLogMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class WeatherLogService extends BaseServiceWithQueryPage<WeatherLog,Integer,WeatherLogMapper> {
}