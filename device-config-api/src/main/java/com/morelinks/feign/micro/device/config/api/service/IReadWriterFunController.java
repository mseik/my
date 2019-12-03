package com.morelinks.feign.micro.device.config.api.service;


import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.device.config.api.model.ReadWriterFun;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//import org.springframework.cloud.netflix.feign.FeignClient;

@RequestMapping("/readWriterFun")
public interface IReadWriterFunController {

    @RequestMapping(value = "/insert", method = {RequestMethod.POST})
    int insert(@RequestBody ReadWriterFun obj);

    @RequestMapping(value = "/insertSelective", method = {RequestMethod.POST})
    int insertSelective(@RequestBody ReadWriterFun  log);

    @RequestMapping(value = "/updateByPrimaryKeySelective", method = {RequestMethod.POST})
    int updateByPrimaryKeySelective(@RequestBody ReadWriterFun  obj);

    @RequestMapping(value = "/getByPrimaryKey", method = {RequestMethod.GET})
    ReadWriterFun getByPrimaryKey(@RequestParam(name = "id") Integer id);

    @RequestMapping(value = "/deleteByPrimaryKey", method = {RequestMethod.GET})
    int deleteByPrimaryKey(@RequestParam(name = "id") Integer id);

    @RequestMapping(value = "/updateByPrimaryKey", method = {RequestMethod.POST})
    int updateByPrimaryKey(@RequestBody ReadWriterFun obj);

    @RequestMapping(value = "/find", method = {RequestMethod.POST})
    List<ReadWriterFun> find(@RequestBody QueryPageParam<ReadWriterFun> query);

    @RequestMapping(value = "/getQueryResult", method = {RequestMethod.POST})
    QueryResult<ReadWriterFun> getQueryResult(@RequestBody QueryPageParam<ReadWriterFun> query) ;

}