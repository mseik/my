package com.morelinks.service.micro.order.controller;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.order.api.dto.ConfigOrder4Creator;
import com.morelinks.feign.micro.order.api.model.ConfigOrder;
import com.morelinks.feign.micro.order.api.model.dto.Query4ConfigOrder;
import com.morelinks.feign.micro.order.api.service.IConfigOrderController;
import com.morelinks.service.micro.order.service.ConfigOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ConfigOrderController implements IConfigOrderController {
    @Autowired
ConfigOrderService configOrderService;
@Override
public ReturnValue<String> insert(@RequestBody ConfigOrder obj) {
    return ReturnValue.get200OK(this.configOrderService.insert(obj));
}

@Override
public ReturnValue<ConfigOrder> getByPrimaryKey(@RequestParam(name = "id") String id) {
    return ReturnValue.get200OK(this.configOrderService.getByPrimaryKey(id));
}

@Override
public ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id") String id) {
    return ReturnValue.get200OK(this.configOrderService.deleteByPrimaryKey(id));
}

@Override
public ReturnValue<Integer> updateByPrimaryKey(@RequestBody ConfigOrder obj) {
    return ReturnValue.get200OK(this.configOrderService.updateByPrimaryKey(obj));
}

@Override
public ReturnValue<List<ConfigOrder>> find(@RequestBody QueryPageParam<ConfigOrder> query) {
    return ReturnValue.get200OK(this.configOrderService.find(query.getQuery(),query.getPage()));
}

@Override
public ReturnValue<QueryResult<ConfigOrder>> getQueryResult(@RequestBody QueryPageParam<ConfigOrder> query) {
    return  ReturnValue.get200OK(this.configOrderService.getQueryResult(query.getQuery(),query.getPage()));
}

@Override
public ReturnValue<ConfigOrder> createrConfigOrder(@RequestBody ConfigOrder4Creator configOrder4Creator) {

    return ReturnValue.get200OK(this.configOrderService.createrConfigOrder(configOrder4Creator));
}

@Override
public ReturnValue<QueryResult<ConfigOrder>> getQueryResultNew(@RequestBody Query4ConfigOrder query) {

    return  ReturnValue.get200OK(this.configOrderService.getQueryResultNew(query));
}

@Override
public ReturnValue<Integer> deleteProject(@RequestParam(name = "id") String id) {
    System.out.println("调用了");
    return ReturnValue.get200OK(this.configOrderService.deleteProject(id));
}
}
