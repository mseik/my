package com.morelinks.service.micro.common.mapper;

import com.morelinks.core.mapper.BaseMapperWithQueryPage;
import com.morelinks.feign.micro.common.api.model.WeatherRealTime;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRealTimeMapper extends BaseMapperWithQueryPage<WeatherRealTime,Integer> {
}