package com.morelinks.service.micro.order.controller;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.order.api.model.AgentOrderFormConfig;
import com.morelinks.feign.micro.order.api.service.IAgentOrderFormConfigController;
import com.morelinks.service.micro.order.service.AgentOrderFormConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AgentOrderFormConfigController
   implements IAgentOrderFormConfigController
{
    private Logger logger = LoggerFactory.getLogger(AgentOrderFormConfigController.class);
    @Autowired
    public AgentOrderFormConfigService baseService;

    @Override
    public ReturnValue<Integer> insert(@RequestBody AgentOrderFormConfig obj)
    {
        baseService.insert(obj);
        return ReturnValue.get200OK(obj.getUserId());
    }

    @Override
    public ReturnValue<AgentOrderFormConfig> getByPrimaryKey(@RequestParam(name = "id") Integer id)
    {
        return ReturnValue.get200OK(baseService.getByPrimaryKey(id));
    }

    @Override
    public ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id")Integer id)
    {
        return ReturnValue.get200OK(baseService.deleteByPrimaryKey(id));
    }

    @Override
    public ReturnValue<Integer> updateByPrimaryKey(@RequestBody AgentOrderFormConfig obj)
    {
        return ReturnValue.get200OK(baseService.updateByPrimaryKey(obj));
    }

    @Override
    public ReturnValue<List<AgentOrderFormConfig>> find(@RequestBody QueryPageParam<AgentOrderFormConfig> query) {
        return ReturnValue.get200OK(baseService.find(query.getQuery(), query.getPage()));
    }
    @Override
    public ReturnValue<QueryResult<AgentOrderFormConfig>> getQueryResult(@RequestBody QueryPageParam<AgentOrderFormConfig> query) {
        return ReturnValue.get200OK(baseService.getQueryResult(query.getQuery(), query.getPage()));
    }

}
