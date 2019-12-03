package com.morelinks.feign.micro.device.config.api.service;


import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.device.config.api.model.DeviceType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//import org.springframework.cloud.netflix.feign.FeignClient;

@RequestMapping("/deviceType")
public interface IDeviceTypeController {

    @RequestMapping(value = "/insert", method = {RequestMethod.POST})
    int insert(@RequestBody DeviceType obj);

    @RequestMapping(value = "/insertSelective", method = {RequestMethod.POST})
    int insertSelective(@RequestBody DeviceType  log);

    @RequestMapping(value = "/updateByPrimaryKeySelective", method = {RequestMethod.POST})
    int updateByPrimaryKeySelective(@RequestBody DeviceType  obj);

    @RequestMapping(value = "/getByPrimaryKey", method = {RequestMethod.GET})
    DeviceType getByPrimaryKey(@RequestParam(name = "id") Integer id);

    @RequestMapping(value = "/deleteByPrimaryKey", method = {RequestMethod.GET})
    int deleteByPrimaryKey(@RequestParam(name = "id") Integer id);

    @RequestMapping(value = "/updateByPrimaryKey", method = {RequestMethod.POST})
    int updateByPrimaryKey(@RequestBody DeviceType obj);

    @RequestMapping(value = "/find", method = {RequestMethod.POST})
    List<DeviceType> find(@RequestBody QueryPageParam<DeviceType> query);

    @RequestMapping(value = "/getQueryResult", method = {RequestMethod.POST})
    QueryResult<DeviceType> getQueryResult(@RequestBody QueryPageParam<DeviceType> query) ;
}