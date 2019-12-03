package com.morelinks.service.micro.order.controller;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.order.api.model.AgentOrderDetail;
import com.morelinks.feign.micro.order.api.service.IAgentOrderDetailController;
import com.morelinks.service.micro.order.service.AgentOrderDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AgentOrderDetailController
   implements IAgentOrderDetailController
{
    private Logger logger = LoggerFactory.getLogger(AgentOrderDetailController.class);
    @Autowired
    public AgentOrderDetailService baseService;

    @Override
    public ReturnValue<Integer> insert(@RequestBody AgentOrderDetail obj)
    {
        baseService.insert(obj);
        return ReturnValue.get200OK(obj.getId());
    }

    @Override
    public ReturnValue<AgentOrderDetail> getByPrimaryKey(@RequestParam(name = "id") Integer id)
    {
        return ReturnValue.get200OK(baseService.getByPrimaryKey(id));
    }

    @Override
    public ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id")Integer id)
    {
        return ReturnValue.get200OK(baseService.deleteByPrimaryKey(id));
    }

    @Override
    public ReturnValue<Integer> updateByPrimaryKey(@RequestBody AgentOrderDetail obj)
    {
        return ReturnValue.get200OK(baseService.updateByPrimaryKey(obj));
    }

    @Override
    public ReturnValue<List<AgentOrderDetail>> find(@RequestBody QueryPageParam<AgentOrderDetail> query) {
        return ReturnValue.get200OK(baseService.find(query.getQuery(), query.getPage()));
    }
    @Override
    public ReturnValue<QueryResult<AgentOrderDetail>> getQueryResult(@RequestBody QueryPageParam<AgentOrderDetail> query) {
        return ReturnValue.get200OK(baseService.getQueryResult(query.getQuery(), query.getPage()));
    }

    @Override
    public ReturnValue<List<AgentOrderDetail>> getByOrderId(@RequestParam(name = "orderId") String orderId) {
        ReturnValue<List<AgentOrderDetail>> ret = new ReturnValue<List<AgentOrderDetail>>();
        AgentOrderDetail query = new AgentOrderDetail();
        query.setAgentOrderId(orderId);
        ret.setObj(baseService.find(query, null));
        return ret;
    }
}
