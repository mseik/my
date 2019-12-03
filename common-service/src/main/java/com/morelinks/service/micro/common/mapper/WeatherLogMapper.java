package com.morelinks.service.micro.common.mapper;

import com.morelinks.core.mapper.BaseMapperWithQueryPage;
import com.morelinks.feign.micro.common.api.model.WeatherLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherLogMapper extends BaseMapperWithQueryPage<WeatherLog,Integer> {
}