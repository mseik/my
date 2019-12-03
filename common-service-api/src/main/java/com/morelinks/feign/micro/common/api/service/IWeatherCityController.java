package com.morelinks.feign.micro.common.api.service;


import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.common.api.dto.TreeCityDTO;
import com.morelinks.feign.micro.common.api.model.WeatherCity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

//import org.springframework.cloud.netflix.feign.FeignClient;

@RequestMapping("/weatherCity")
public interface IWeatherCityController {

    @RequestMapping(value = "/insert", method = {RequestMethod.POST})
    ReturnValue<Integer> insert(@RequestBody WeatherCity obj);

    @RequestMapping(value = "/getByPrimaryKey", method = {RequestMethod.GET})
    ReturnValue<WeatherCity> getByPrimaryKey(@RequestParam(name = "id") Integer id);

    @RequestMapping(value = "/deleteByPrimaryKey", method = {RequestMethod.GET})
    ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id") Integer id);

    @RequestMapping(value = "/updateByPrimaryKey", method = {RequestMethod.POST})
    ReturnValue<Integer> updateByPrimaryKey(@RequestBody WeatherCity obj);

    @RequestMapping(value = "/find", method = {RequestMethod.POST})
    ReturnValue<List<WeatherCity>> find(@RequestBody QueryPageParam<WeatherCity> query);

    @RequestMapping(value = "/getQueryResult", method = {RequestMethod.POST})
    ReturnValue<QueryResult<WeatherCity>> getQueryResult(@RequestBody QueryPageParam<WeatherCity> query) ;

    @RequestMapping(value = "/getByCityName", method = {RequestMethod.GET})
    ReturnValue<List<WeatherCity>> getByCityName(@RequestParam(name = "cityName") String cityName);

    @RequestMapping(value = "/getByCityId", method = {RequestMethod.GET})
    ReturnValue<WeatherCity> getByCityId(@RequestParam(name = "cityId") String cityId);

    /**
     * 通过城市Id 获取城市树状结构Map
     * @param cityId
     * @return
     */
    @RequestMapping(value = "/getMapCityByCityId", method = {RequestMethod.GET})
    ReturnValue<Map<Integer,WeatherCity>> getMapCityByCityId(@RequestParam(name = "cityId") String cityId);

    @RequestMapping(value = "/getTreeCityListByCityId", method = {RequestMethod.GET})
    ReturnValue<List<TreeCityDTO>> getTreeCityListByCityId();
}