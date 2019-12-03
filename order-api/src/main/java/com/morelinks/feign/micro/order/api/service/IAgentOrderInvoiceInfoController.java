package com.morelinks.feign.micro.order.api.service;


import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.order.api.model.AgentOrderDetail;
import com.morelinks.feign.micro.order.api.model.AgentOrderInvoiceInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//import org.springframework.cloud.netflix.feign.FeignClient;

@RequestMapping("/agentOrderInvoiceInfo")
public interface IAgentOrderInvoiceInfoController {

    @RequestMapping(value = "/getByPrimaryKey", method = {RequestMethod.GET})
    ReturnValue<AgentOrderInvoiceInfo> getByPrimaryKey(@RequestParam(name = "id") String id);

}