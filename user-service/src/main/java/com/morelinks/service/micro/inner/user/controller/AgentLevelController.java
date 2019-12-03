package com.morelinks.service.micro.inner.user.controller;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.inner.user.api.model.AgentLevel;
import com.morelinks.feign.micro.inner.user.api.service.IAgentLevelController;
import com.morelinks.service.micro.inner.user.service.AgentLevelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AgentLevelController
   implements IAgentLevelController
{
    private Logger logger = LoggerFactory.getLogger(AgentLevelController.class);
    @Autowired
    public AgentLevelService baseService;

    @Override
    public ReturnValue<Integer> insert(@RequestBody AgentLevel obj)
    {
        baseService.insert(obj);
        return ReturnValue.get200OK(obj.getId());
    }

    @Override
    public ReturnValue<AgentLevel> getByPrimaryKey(@RequestParam(name = "id") Integer id)
    {
        return ReturnValue.get200OK(baseService.getByPrimaryKey(id));
    }

    @Override
    public ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id")Integer id)
    {
        return ReturnValue.get200OK(baseService.deleteByPrimaryKey(id));
    }

    @Override
    public ReturnValue<Integer> updateByPrimaryKey(@RequestBody AgentLevel obj)
    {
        return ReturnValue.get200OK(baseService.updateByPrimaryKey(obj));
    }

    @Override
    public ReturnValue<List<AgentLevel>> find(@RequestBody QueryPageParam<AgentLevel> query) {
        return ReturnValue.get200OK(baseService.find(query.getQuery(), query.getPage()));
    }
    @Override
    public ReturnValue<QueryResult<AgentLevel>> getQueryResult(@RequestBody QueryPageParam<AgentLevel> query) {
        return ReturnValue.get200OK(baseService.getQueryResult(query.getQuery(), query.getPage()));
    }

    @Override
    public ReturnValue<AgentLevel> getByLevel(@RequestParam(name = "level") Integer level)
    {
        AgentLevel query = new AgentLevel();
        query.setLevel(level);
        return ReturnValue.get200OK(baseService.findTop1(query));
    }


}
