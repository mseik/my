package com.morelinks.feign.micro.device.config.api.service;


import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.device.config.api.model.DriverType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//import org.springframework.cloud.netflix.feign.FeignClient;

@RequestMapping("/driverType")
public interface IDriverTypeController {

    @RequestMapping(value = "/insert", method = {RequestMethod.POST})
    int insert(@RequestBody DriverType obj);

    @RequestMapping(value = "/insertSelective", method = {RequestMethod.POST})
    int insertSelective(@RequestBody DriverType  log);

    @RequestMapping(value = "/updateByPrimaryKeySelective", method = {RequestMethod.POST})
    int updateByPrimaryKeySelective(@RequestBody DriverType  obj);

    @RequestMapping(value = "/getByPrimaryKey", method = {RequestMethod.GET})
    DriverType getByPrimaryKey(@RequestParam(name = "id") Integer id);

    @RequestMapping(value = "/deleteByPrimaryKey", method = {RequestMethod.GET})
    int deleteByPrimaryKey(@RequestParam(name = "id") Integer id);

    @RequestMapping(value = "/updateByPrimaryKey", method = {RequestMethod.POST})
    int updateByPrimaryKey(@RequestBody DriverType obj);

    @RequestMapping(value = "/find", method = {RequestMethod.POST})
    List<DriverType> find(@RequestBody QueryPageParam<DriverType> query);
    @RequestMapping(value = "/getQueryResult", method = {RequestMethod.POST})
    QueryResult<DriverType> getQueryResult(@RequestBody QueryPageParam<DriverType> query) ;
}