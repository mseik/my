package com.morelinks.feign.micro.device.config.api.service;


import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.feign.micro.device.config.api.model.DeviceTypeFun;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//import org.springframework.cloud.netflix.feign.FeignClient;

@RequestMapping("/deviceTypeFun")
public interface IDeviceTypeFunController {

    @RequestMapping(value = "/insert", method = {RequestMethod.POST})
    int insert(@RequestBody DeviceTypeFun obj);

    @RequestMapping(value = "/insertSelective", method = {RequestMethod.POST})
    int insertSelective(@RequestBody DeviceTypeFun  log);

    @RequestMapping(value = "/updateByPrimaryKeySelective", method = {RequestMethod.POST})
    int updateByPrimaryKeySelective(@RequestBody DeviceTypeFun  obj);

    @RequestMapping(value = "/getByPrimaryKey", method = {RequestMethod.GET})
    DeviceTypeFun getByPrimaryKey(@RequestParam(name = "id") Integer id);

    @RequestMapping(value = "/deleteByPrimaryKey", method = {RequestMethod.GET})
    int deleteByPrimaryKey(@RequestParam(name = "id") Integer id);

    @RequestMapping(value = "/updateByPrimaryKey", method = {RequestMethod.POST})
    int updateByPrimaryKey(@RequestBody DeviceTypeFun obj);

    @RequestMapping(value = "/find", method = {RequestMethod.POST})
    List<DeviceTypeFun> find(@RequestBody QueryPageParam<DeviceTypeFun> query);
}