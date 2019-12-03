package com.morelinks.service.micro.common.mapper;

import com.morelinks.core.mapper.BaseMapperWithQueryPage;
import com.morelinks.feign.micro.common.api.model.WeatherCity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeatherCityMapper extends BaseMapperWithQueryPage<WeatherCity,Integer> {
    List<WeatherCity> getByCityName(@Param(value="cityName")String cityName);
}