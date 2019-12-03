package com.morelinks.feign.micro.order.api.service;


import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.order.api.model.AgentCart;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//import org.springframework.cloud.netflix.feign.FeignClient;

@RequestMapping("/agentCart")
public interface IAgentCartController {

    @RequestMapping(value = "/insert", method = {RequestMethod.POST})
    ReturnValue<Integer> insert(@RequestBody AgentCart obj);

    @RequestMapping(value = "/getByPrimaryKey", method = {RequestMethod.GET})
    ReturnValue<AgentCart> getByPrimaryKey(@RequestParam(name = "id") Integer id);

    @RequestMapping(value = "/deleteByPrimaryKey", method = {RequestMethod.GET})
    ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id") Integer id);

    @RequestMapping(value = "/updateByPrimaryKey", method = {RequestMethod.POST})
    ReturnValue<Integer> updateByPrimaryKey(@RequestBody AgentCart obj);

    @RequestMapping(value = "/find", method = {RequestMethod.POST})
    ReturnValue<List<AgentCart>> find(@RequestBody QueryPageParam<AgentCart> query);

    @RequestMapping(value = "/getQueryResult", method = {RequestMethod.POST})
    ReturnValue<QueryResult<AgentCart>> getQueryResult(@RequestBody QueryPageParam<AgentCart> query) ;

    @RequestMapping(value = "/addOrSetProductNum", method = {RequestMethod.POST})
    ReturnValue<AgentCart> addOrSetProductNum(@RequestParam(name = "userId") Integer userId,
                                              @RequestParam(name = "productId") Integer productId,
                                              @RequestParam(name = "num") Integer num,
                                              @RequestParam(name = "isSet") Boolean isSet);

    @RequestMapping(value = "/updateCartProductSelStatus", method = {RequestMethod.POST})
    ReturnValue updateProductSelStatus(@RequestParam(name = "userId") Integer userId,
                                           @RequestParam(name = "productId") Integer productId,
                                           @RequestParam(name = "selected") Boolean selected);

    @RequestMapping(value = "/updateCartSelStatus", method = {RequestMethod.POST})
    ReturnValue updateCartSelStatus(@RequestParam(name = "userId") Integer userId,
                                    @RequestParam(name = "selected") Boolean selected);
    @RequestMapping(value = "/getCountByUserId", method = {RequestMethod.GET})
    ReturnValue<Integer> getCountByUserId(@RequestParam(name = "userId") Integer userId);

}