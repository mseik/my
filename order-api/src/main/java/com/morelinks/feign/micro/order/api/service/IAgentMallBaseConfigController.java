package com.morelinks.feign.micro.order.api.service;


import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.order.api.model.AgentMallBaseConfig;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//import org.springframework.cloud.netflix.feign.FeignClient;

@RequestMapping("/agentMallBaseConfig")
public interface IAgentMallBaseConfigController {

    @RequestMapping(value = "/insert", method = {RequestMethod.POST})
    ReturnValue<Integer> insert(@RequestBody AgentMallBaseConfig obj);

    @RequestMapping(value = "/getByPrimaryKey", method = {RequestMethod.GET})
    ReturnValue<AgentMallBaseConfig> getByPrimaryKey(@RequestParam(name = "id") Integer id);

    @RequestMapping(value = "/deleteByPrimaryKey", method = {RequestMethod.GET})
    ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id") Integer id);

    @RequestMapping(value = "/updateByPrimaryKey", method = {RequestMethod.POST})
    ReturnValue<Integer> updateByPrimaryKey(@RequestBody AgentMallBaseConfig obj);

    @RequestMapping(value = "/find", method = {RequestMethod.POST})
    ReturnValue<List<AgentMallBaseConfig>> find(@RequestBody QueryPageParam<AgentMallBaseConfig> query);

    @RequestMapping(value = "/getQueryResult", method = {RequestMethod.POST})
    ReturnValue<QueryResult<AgentMallBaseConfig>> getQueryResult(@RequestBody QueryPageParam<AgentMallBaseConfig> query) ;

    @RequestMapping(value = "/getByConfigType", method = {RequestMethod.GET})
    ReturnValue<List<AgentMallBaseConfig>> getByConfigType(@RequestParam(name = "configType")String configType);

    @RequestMapping(value = "/getByConfigTypeAndConfigKey", method = {RequestMethod.GET})
    ReturnValue<AgentMallBaseConfig> getByConfigTypeAndConfigKey(@RequestParam(name = "configType")String configType,
                                                                 @RequestParam(name = "configKey")String configKey);
}