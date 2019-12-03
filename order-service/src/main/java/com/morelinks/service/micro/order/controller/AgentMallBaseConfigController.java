package com.morelinks.service.micro.order.controller;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.order.api.model.AgentMallBaseConfig;
import com.morelinks.feign.micro.order.api.service.IAgentMallBaseConfigController;
import com.morelinks.service.micro.order.service.AgentMallBaseConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AgentMallBaseConfigController
   implements IAgentMallBaseConfigController
{
    private Logger logger = LoggerFactory.getLogger(AgentMallBaseConfigController.class);
    @Autowired
    public AgentMallBaseConfigService baseService;

    @Override
    public ReturnValue<Integer> insert(@RequestBody AgentMallBaseConfig obj)
    {
        baseService.insert(obj);
        return ReturnValue.get200OK(obj.getId());
    }

    @Override
    public ReturnValue<AgentMallBaseConfig> getByPrimaryKey(@RequestParam(name = "id") Integer id)
    {
        return ReturnValue.get200OK(baseService.getByPrimaryKey(id));
    }

    @Override
    public ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id")Integer id)
    {
        return ReturnValue.get200OK(baseService.deleteByPrimaryKey(id));
    }

    @Override
    public ReturnValue<Integer> updateByPrimaryKey(@RequestBody AgentMallBaseConfig obj)
    {
        return ReturnValue.get200OK(baseService.updateByPrimaryKey(obj));
    }

    @Override
    public ReturnValue<List<AgentMallBaseConfig>> find(@RequestBody QueryPageParam<AgentMallBaseConfig> query) {
        return ReturnValue.get200OK(baseService.find(query.getQuery(), query.getPage()));
    }
    @Override
    public ReturnValue<QueryResult<AgentMallBaseConfig>> getQueryResult(@RequestBody QueryPageParam<AgentMallBaseConfig> query) {
        return ReturnValue.get200OK(baseService.getQueryResult(query.getQuery(), query.getPage()));
    }

    @Override
    public ReturnValue<List<AgentMallBaseConfig>> getByConfigType(@RequestParam(name = "configType")String configType) {
        AgentMallBaseConfig query = new AgentMallBaseConfig();
        query.setConfigType(configType);
        return ReturnValue.get200OK(baseService.find(query,null));
    }

    @Override
    public ReturnValue<AgentMallBaseConfig> getByConfigTypeAndConfigKey(@RequestParam(name = "configType")String configType,
                                                                              @RequestParam(name = "configKey")String configKey) {
        AgentMallBaseConfig query = new AgentMallBaseConfig();
        query.setConfigType(configType);
        query.setConfigKey(configKey);
        return ReturnValue.get200OK(baseService.findTop1(query));
    }
}
