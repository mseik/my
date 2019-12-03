package com.morelinks.feign.micro.device.config.api.service;


import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.feign.micro.device.config.api.model.DriverController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//import org.springframework.cloud.netflix.feign.FeignClient;

@RequestMapping("/driverController")
public interface IDriverControllerController {

    @RequestMapping(value = "/insert", method = {RequestMethod.POST})
    int insert(@RequestBody DriverController obj);

    @RequestMapping(value = "/insertSelective", method = {RequestMethod.POST})
    int insertSelective(@RequestBody DriverController  log);

    @RequestMapping(value = "/updateByPrimaryKeySelective", method = {RequestMethod.POST})
    int updateByPrimaryKeySelective(@RequestBody DriverController  obj);

    @RequestMapping(value = "/getByPrimaryKey", method = {RequestMethod.GET})
    DriverController getByPrimaryKey(@RequestParam(name = "id") Integer id);

    @RequestMapping(value = "/deleteByPrimaryKey", method = {RequestMethod.GET})
    int deleteByPrimaryKey(@RequestParam(name = "id") Integer id);

    @RequestMapping(value = "/updateByPrimaryKey", method = {RequestMethod.POST})
    int updateByPrimaryKey(@RequestBody DriverController obj);

    @RequestMapping(value = "/find", method = {RequestMethod.POST})
    List<DriverController> find(@RequestBody QueryPageParam<DriverController> query);

}