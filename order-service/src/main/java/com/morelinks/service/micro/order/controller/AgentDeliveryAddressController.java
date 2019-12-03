package com.morelinks.service.micro.order.controller;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.core.util.IntUtil;
import com.morelinks.feign.micro.order.api.model.AgentDeliveryAddress;
import com.morelinks.feign.micro.order.api.service.IAgentDeliveryAddressController;
import com.morelinks.service.micro.order.service.AgentDeliveryAddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class AgentDeliveryAddressController
   implements IAgentDeliveryAddressController
{
    private Logger logger = LoggerFactory.getLogger(AgentDeliveryAddressController.class);
    @Autowired
    public AgentDeliveryAddressService baseService;

    @Override
    public ReturnValue<Integer> insert(@RequestBody AgentDeliveryAddress obj)
    {
        baseService.insert(obj);
        return ReturnValue.get200OK(obj.getId());
    }

    @Override
    public ReturnValue<AgentDeliveryAddress> getByPrimaryKey(@RequestParam(name = "id") Integer id)
    {
        return ReturnValue.get200OK(baseService.getByPrimaryKey(id));
    }

    @Override
    public ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id")Integer id)
    {
        return ReturnValue.get200OK(baseService.deleteByPrimaryKey(id));
    }

    @Override
    public ReturnValue<Integer> updateByPrimaryKey(@RequestBody AgentDeliveryAddress obj)
    {
        return ReturnValue.get200OK(baseService.updateByPrimaryKey(obj));
    }

    @Override
    public ReturnValue<List<AgentDeliveryAddress>> find(@RequestBody QueryPageParam<AgentDeliveryAddress> query) {
        return ReturnValue.get200OK(baseService.find(query.getQuery(), query.getPage()));
    }
    @Override
    public ReturnValue<QueryResult<AgentDeliveryAddress>> getQueryResult(@RequestBody QueryPageParam<AgentDeliveryAddress> query) {
        return ReturnValue.get200OK(baseService.getQueryResult(query.getQuery(), query.getPage()));
    }

}
