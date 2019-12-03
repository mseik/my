package com.morelinks.feign.micro.inner.user.api.service;


import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.inner.user.api.model.AgentInvoiceInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//import org.springframework.cloud.netflix.feign.FeignClient;

@RequestMapping("/agentInvoiceInfo")
public interface IAgentInvoiceInfoController {

    @RequestMapping(value = "/insert", method = {RequestMethod.POST})
    ReturnValue<Integer> insert(@RequestBody AgentInvoiceInfo obj);

    @RequestMapping(value = "/getByPrimaryKey", method = {RequestMethod.GET})
    ReturnValue<AgentInvoiceInfo> getByPrimaryKey(@RequestParam(name = "id") Integer id);

    @RequestMapping(value = "/deleteByPrimaryKey", method = {RequestMethod.GET})
    ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id") Integer id);

    @RequestMapping(value = "/updateByPrimaryKey", method = {RequestMethod.POST})
    ReturnValue<Integer> updateByPrimaryKey(@RequestBody AgentInvoiceInfo obj);

    @RequestMapping(value = "/find", method = {RequestMethod.POST})
    ReturnValue<List<AgentInvoiceInfo>> find(@RequestBody QueryPageParam<AgentInvoiceInfo> query);

    @RequestMapping(value = "/getQueryResult", method = {RequestMethod.POST})
    ReturnValue<QueryResult<AgentInvoiceInfo>> getQueryResult(@RequestBody QueryPageParam<AgentInvoiceInfo> query) ;

    @RequestMapping(value = "/getByAgentId", method = {RequestMethod.GET})
    ReturnValue<AgentInvoiceInfo> getByAgentId(@RequestParam(name = "agentId") Integer agentId);
}