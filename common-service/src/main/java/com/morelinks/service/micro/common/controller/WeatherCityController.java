package com.morelinks.service.micro.common.controller;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.common.api.dto.TreeCityDTO;
import com.morelinks.feign.micro.common.api.model.WeatherCity;
import com.morelinks.feign.micro.common.api.service.IWeatherCityController;
import com.morelinks.service.micro.common.service.impl.WeatherCityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class WeatherCityController
   implements IWeatherCityController
{
    private Logger logger = LoggerFactory.getLogger(WeatherCityController.class);
    @Autowired
    public WeatherCityService baseService;

    @Override
    public ReturnValue<Integer> insert(@RequestBody WeatherCity obj)
    {
        baseService.insert(obj);
        return ReturnValue.get200OK(obj.getId());
    }

    @Override
    public ReturnValue<WeatherCity> getByPrimaryKey(@RequestParam(name = "id") Integer id)
    {
        return ReturnValue.get200OK(baseService.getByPrimaryKey(id));
    }

    @Override
    public ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id")Integer id)
    {
        return ReturnValue.get200OK(baseService.deleteByPrimaryKey(id));
    }

    @Override
    public ReturnValue<Integer> updateByPrimaryKey(@RequestBody WeatherCity obj)
    {
        return ReturnValue.get200OK(baseService.updateByPrimaryKey(obj));
    }

    @Override
    public ReturnValue<List<WeatherCity>> find(@RequestBody QueryPageParam<WeatherCity> query) {
        return ReturnValue.get200OK(baseService.find(query.getQuery(), query.getPage()));
    }

    @Override
    public ReturnValue<WeatherCity> getByCityId(@RequestParam(name = "cityId") String cityId)
    {
        WeatherCity query = new WeatherCity();
        query.setCityId(cityId);
        return ReturnValue.get200OK(baseService.findTop1(query));
    }

    @Override
    public ReturnValue<QueryResult<WeatherCity>> getQueryResult(@RequestBody QueryPageParam<WeatherCity> query) {
        return ReturnValue.get200OK(baseService.getQueryResult(query.getQuery(), query.getPage()));
    }

    @Override
    public ReturnValue<List<WeatherCity>> getByCityName(@RequestParam(name = "cityName") String cityName) {
        return ReturnValue.get200OK(baseService.getByCityName(cityName));
    }

    @Override
    public ReturnValue<Map<Integer,WeatherCity>> getMapCityByCityId(@RequestParam(name = "cityId") String cityId){
        Map<Integer,WeatherCity> map = new HashMap<Integer,WeatherCity>();
         baseService.getMapCityByCityId(cityId,map);
        return ReturnValue.get200OK(map);
    }

    @Override
    public ReturnValue<List<TreeCityDTO>> getTreeCityListByCityId(){
    return ReturnValue.get200OK(baseService.getTreeCityListByCityId());
}
}
