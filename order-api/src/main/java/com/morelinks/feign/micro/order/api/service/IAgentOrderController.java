package com.morelinks.feign.micro.order.api.service;


import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.order.api.dto.AgentOrder4Submit;
import com.morelinks.feign.micro.order.api.dto.AgentOrderAmountModifyForm;
import com.morelinks.feign.micro.order.api.model.AgentOrder;
import com.morelinks.feign.micro.order.api.model.dto.Query4Order;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//import org.springframework.cloud.netflix.feign.FeignClient;

@RequestMapping("/agentOrder")
public interface IAgentOrderController {

    @RequestMapping(value = "/insert", method = {RequestMethod.POST})
    ReturnValue<String> insert(@RequestBody AgentOrder obj);

    @RequestMapping(value = "/getByPrimaryKey", method = {RequestMethod.GET})
    ReturnValue<AgentOrder> getByPrimaryKey(@RequestParam(name = "id") String id);

    @RequestMapping(value = "/deleteByPrimaryKey", method = {RequestMethod.GET})
    ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id") String id);

    @RequestMapping(value = "/updateByPrimaryKey", method = {RequestMethod.POST})
    ReturnValue<Integer> updateByPrimaryKey(@RequestBody AgentOrder obj);

    @RequestMapping(value = "/find", method = {RequestMethod.POST})
    ReturnValue<List<AgentOrder>> find(@RequestBody QueryPageParam<AgentOrder> query);

    @RequestMapping(value = "/getQueryResult", method = {RequestMethod.POST})
    ReturnValue<QueryResult<AgentOrder>> getQueryResult(@RequestBody QueryPageParam<AgentOrder> query) ;

    @RequestMapping(value = "/submitOrder", method = {RequestMethod.POST})
    ReturnValue<AgentOrder> submitOrder(@RequestBody AgentOrder4Submit obj);

    @RequestMapping(value = "/getQueryResultNew", method = {RequestMethod.POST})
    ReturnValue<QueryResult<AgentOrder>> getQueryResultNew(@RequestBody QueryPageParam<Query4Order> query);

    @RequestMapping(value = "/cancelOrderByUser", method = {RequestMethod.POST})
    ReturnValue<AgentOrder> cancelOrderByUser(@RequestParam(name = "id")String id,
                                              @RequestParam(name = "reasonType")Integer reasonType,
                                              @RequestParam(name = "reason")String reason
    );

    @RequestMapping(value = "/confirmOrderSuccByUser", method = {RequestMethod.POST})
    ReturnValue<AgentOrder> confirmOrderSuccByUser(
            @RequestParam(name = "id")String id
    );

    @RequestMapping(value = "/modifyOrderAmount", method = {RequestMethod.POST})
    ReturnValue<AgentOrder> modifyOrderAmount(@RequestBody AgentOrderAmountModifyForm form);
}