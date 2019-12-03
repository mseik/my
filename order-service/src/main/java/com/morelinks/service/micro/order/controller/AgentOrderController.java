package com.morelinks.service.micro.order.controller;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.exception.BusinessException;
import com.morelinks.core.model.QueryResult;
import com.morelinks.core.util.IntUtil;
import com.morelinks.feign.micro.order.api.dto.AgentOrder4Submit;
import com.morelinks.feign.micro.order.api.dto.AgentOrderAmountModifyForm;
import com.morelinks.feign.micro.order.api.model.AgentOrder;
import com.morelinks.feign.micro.order.api.model.dto.Query4Order;
import com.morelinks.feign.micro.order.api.service.IAgentOrderController;
import com.morelinks.service.micro.order.service.AgentOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class AgentOrderController
   implements IAgentOrderController
{
    private Logger logger = LoggerFactory.getLogger(AgentOrderController.class);
    @Autowired
    public AgentOrderService baseService;

    @Override
    public ReturnValue<String> insert(@RequestBody AgentOrder obj)
    {
        baseService.insert(obj);
        return ReturnValue.get200OK(obj.getId());
    }

    @Override
    public ReturnValue<AgentOrder> getByPrimaryKey(@RequestParam(name = "id") String id)
    {
        return ReturnValue.get200OK(baseService.getByPrimaryKey(id));
    }

    @Override
    public ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id")String id)
    {
        return ReturnValue.get200OK(baseService.deleteByPrimaryKey(id));
    }

    @Override
    public ReturnValue<Integer> updateByPrimaryKey(@RequestBody AgentOrder obj)
    {
        return ReturnValue.get200OK(baseService.updateByPrimaryKey(obj));
    }

    @Override
    public ReturnValue<List<AgentOrder>> find(@RequestBody QueryPageParam<AgentOrder> query) {
        return ReturnValue.get200OK(baseService.find(query.getQuery(), query.getPage()));
    }
    @Override
    public ReturnValue<QueryResult<AgentOrder>> getQueryResult(@RequestBody QueryPageParam<AgentOrder> query) {
        return ReturnValue.get200OK(baseService.getQueryResult(query.getQuery(), query.getPage()));
    }


    @Override
    public ReturnValue<QueryResult<AgentOrder>> getQueryResultNew(@RequestBody QueryPageParam<Query4Order> query) {
        return ReturnValue.get200OK(baseService.getQueryResultNew(query.getQuery(), query.getPage()));
    }

    @Override
    public ReturnValue<AgentOrder> submitOrder(@RequestBody AgentOrder4Submit obj)
    {
        return ReturnValue.get200OK(baseService.submitOrder(obj)) ;
    }

    @Override
    public ReturnValue<AgentOrder> modifyOrderAmount(@RequestBody AgentOrderAmountModifyForm form)
    {
        return ReturnValue.get200OK(baseService.modifyOrderAmount(form)) ;
    }

    @Override
    public ReturnValue<AgentOrder> cancelOrderByUser(@RequestParam(name = "id")String id,
                                               @RequestParam(name = "reasonType")Integer reasonType,
                                               @RequestParam(name = "reason")String reason
    )
    {
        return ReturnValue.get200OK(baseService.cancelOrderByUser(id,reasonType,reason)) ;
    }

    @Override
    public ReturnValue<AgentOrder> confirmOrderSuccByUser(
            @RequestParam(name = "id")String id
    )
    {
        return ReturnValue.get200OK(baseService.confirmOrderSuccByUser(id)) ;
    }
}
