package com.morelinks.feign.micro.order.api.service;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.order.api.dto.AgentOrder4Submit;
import com.morelinks.feign.micro.order.api.dto.ConfigOrder4Creator;
import com.morelinks.feign.micro.order.api.model.ConfigOrder;
import com.morelinks.feign.micro.order.api.model.ConfigOrder;
import com.morelinks.feign.micro.order.api.model.dto.Query4ConfigOrder;
import com.morelinks.feign.micro.order.api.model.dto.Query4Order;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@RequestMapping("/configOrder")
public interface IConfigOrderController {
@RequestMapping(value = "/insert", method = {RequestMethod.POST})
ReturnValue<String> insert(@RequestBody ConfigOrder obj);

@RequestMapping(value = "/getByPrimaryKey", method = {RequestMethod.GET})
ReturnValue<ConfigOrder> getByPrimaryKey(@RequestParam(name = "id") String id);

@RequestMapping(value = "/deleteByPrimaryKey", method = {RequestMethod.GET})
ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id") String id);

@RequestMapping(value = "/updateByPrimaryKey", method = {RequestMethod.POST})
ReturnValue<Integer> updateByPrimaryKey(@RequestBody ConfigOrder obj);

@RequestMapping(value = "/find", method = {RequestMethod.POST})
ReturnValue<List<ConfigOrder>> find(@RequestBody QueryPageParam<ConfigOrder> query);

@RequestMapping(value = "/getQueryResult", method = {RequestMethod.POST})
ReturnValue<QueryResult<ConfigOrder>> getQueryResult(@RequestBody QueryPageParam<ConfigOrder> query) ;

@RequestMapping(value = "/createrConfigOrder", method = {RequestMethod.POST})
ReturnValue<ConfigOrder>   createrConfigOrder(@RequestBody ConfigOrder4Creator configOrder4Creator);

@RequestMapping(value = "/getQueryResultNew", method = {RequestMethod.POST})
ReturnValue<QueryResult<ConfigOrder>> getQueryResultNew(@RequestBody Query4ConfigOrder query);

@RequestMapping(value = "/deleteProject", method = {RequestMethod.POST})
ReturnValue<Integer>  deleteProject(@RequestParam(name = "id") String id);
}
