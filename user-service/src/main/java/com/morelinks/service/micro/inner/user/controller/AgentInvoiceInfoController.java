package com.morelinks.service.micro.inner.user.controller;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.inner.user.api.model.AgentInvoiceInfo;
import com.morelinks.feign.micro.inner.user.api.service.IAgentInvoiceInfoController;
import com.morelinks.service.micro.inner.user.service.AgentInvoiceInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AgentInvoiceInfoController
   implements IAgentInvoiceInfoController
{
    private Logger logger = LoggerFactory.getLogger(AgentInvoiceInfoController.class);
    @Autowired
    public AgentInvoiceInfoService baseService;

    @Override
    public ReturnValue<Integer> insert(@RequestBody AgentInvoiceInfo obj)
    {
        baseService.insert(obj);
        return ReturnValue.get200OK(obj.getId());
    }

    @Override
    public ReturnValue<AgentInvoiceInfo> getByPrimaryKey(@RequestParam(name = "id") Integer id)
    {
        return ReturnValue.get200OK(baseService.getByPrimaryKey(id));
    }

    @Override
    public ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id")Integer id)
    {
        return ReturnValue.get200OK(baseService.deleteByPrimaryKey(id));
    }

    @Override
    public ReturnValue<Integer> updateByPrimaryKey(@RequestBody AgentInvoiceInfo obj)
    {
        return ReturnValue.get200OK(baseService.updateByPrimaryKey(obj));
    }

    @Override
    public ReturnValue<List<AgentInvoiceInfo>> find(@RequestBody QueryPageParam<AgentInvoiceInfo> query) {
        return ReturnValue.get200OK(baseService.find(query.getQuery(), query.getPage()));
    }
    @Override
    public ReturnValue<QueryResult<AgentInvoiceInfo>> getQueryResult(@RequestBody QueryPageParam<AgentInvoiceInfo> query) {
        return ReturnValue.get200OK(baseService.getQueryResult(query.getQuery(), query.getPage()));
    }

    @Override
    public ReturnValue<AgentInvoiceInfo> getByAgentId(@RequestParam(name = "agentId") Integer agentId)
    {
        AgentInvoiceInfo query = new AgentInvoiceInfo();
        query.setAgentId(agentId);
        return ReturnValue.get200OK(baseService.findTop1(query));
    }


}
