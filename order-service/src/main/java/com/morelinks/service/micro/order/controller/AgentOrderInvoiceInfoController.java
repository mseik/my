package com.morelinks.service.micro.order.controller;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.order.api.model.AgentOrderDetail;
import com.morelinks.feign.micro.order.api.model.AgentOrderInvoiceInfo;
import com.morelinks.feign.micro.order.api.service.IAgentOrderInvoiceInfoController;
import com.morelinks.service.micro.order.service.AgentOrderDetailService;
import com.morelinks.service.micro.order.service.AgentOrderInvoiceInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AgentOrderInvoiceInfoController
   implements IAgentOrderInvoiceInfoController
{
    private Logger logger = LoggerFactory.getLogger(AgentOrderInvoiceInfoController.class);
    @Autowired
    public AgentOrderInvoiceInfoService baseService;

    @Override
    public ReturnValue<AgentOrderInvoiceInfo> getByPrimaryKey(@RequestParam(name = "id") String id)
    {
        return ReturnValue.get200OK(baseService.getByPrimaryKey(id));
    }
}
