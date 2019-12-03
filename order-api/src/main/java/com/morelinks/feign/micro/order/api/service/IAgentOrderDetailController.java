package com.morelinks.feign.micro.order.api.service;


import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.order.api.model.AgentOrderDetail;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//import org.springframework.cloud.netflix.feign.FeignClient;

@RequestMapping("/agentOrderDetail")
public interface IAgentOrderDetailController {

    @RequestMapping(value = "/insert", method = {RequestMethod.POST})
    ReturnValue<Integer> insert(@RequestBody AgentOrderDetail obj);

    @RequestMapping(value = "/getByPrimaryKey", method = {RequestMethod.GET})
    ReturnValue<AgentOrderDetail> getByPrimaryKey(@RequestParam(name = "id") Integer id);

    @RequestMapping(value = "/deleteByPrimaryKey", method = {RequestMethod.GET})
    ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id") Integer id);

    @RequestMapping(value = "/updateByPrimaryKey", method = {RequestMethod.POST})
    ReturnValue<Integer> updateByPrimaryKey(@RequestBody AgentOrderDetail obj);

    @RequestMapping(value = "/find", method = {RequestMethod.POST})
    ReturnValue<List<AgentOrderDetail>> find(@RequestBody QueryPageParam<AgentOrderDetail> query);

    @RequestMapping(value = "/getQueryResult", method = {RequestMethod.POST})
    ReturnValue<QueryResult<AgentOrderDetail>> getQueryResult(@RequestBody QueryPageParam<AgentOrderDetail> query) ;

    @RequestMapping(value = "/getByOrderId", method = {RequestMethod.GET})
    ReturnValue<List<AgentOrderDetail>> getByOrderId(@RequestParam(name = "orderId") String orderId);
}