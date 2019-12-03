package com.morelinks.service.micro.order.controller;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.order.api.model.ConfigPrintOrder;
import com.morelinks.feign.micro.order.api.model.ConfigPrintOrderDetail;
import com.morelinks.feign.micro.order.api.model.ConfigPrintOrderExtraInfo;
import com.morelinks.feign.micro.order.api.model.dto.PrintingDTO;
import com.morelinks.feign.micro.order.api.service.IConfigPrintOrderController;
import com.morelinks.service.micro.order.service.ConfigPrintOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ConfigPrintOrderController implements IConfigPrintOrderController {
    @Autowired
ConfigPrintOrderService orderService;

@Override
public ReturnValue<Integer> insert(@RequestBody ConfigPrintOrder obj) {
    return  ReturnValue.get200OK(this.orderService.insert(obj));
}

@Override
public ReturnValue<ConfigPrintOrder> getByPrimaryKey(@RequestParam(name = "id") String id) {
    return  ReturnValue.get200OK(this.orderService.getByPrimaryKey(id));
}

@Override
public ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id") String id) {
    return  ReturnValue.get200OK(this.orderService.deleteByPrimaryKey(id));
}

@Override
public ReturnValue<Integer> updateByPrimaryKey(@RequestBody ConfigPrintOrder obj) {
    return  ReturnValue.get200OK(this.orderService.updateByPrimaryKey(obj));
}

@Override
public ReturnValue<List<ConfigPrintOrder>> find(@RequestBody QueryPageParam<ConfigPrintOrder> query) {
    return  ReturnValue.get200OK(this.orderService.find(query.getQuery(),query.getPage()));
}

@Override
public ReturnValue<QueryResult<ConfigPrintOrder>> getQueryResult(@RequestBody QueryPageParam<ConfigPrintOrder> query) {
    return  ReturnValue.get200OK(this.orderService.getQueryResult(query.getQuery(),query.getPage()));
}

@Override
public ReturnValue<Integer> PrintingOrder(@RequestBody  PrintingDTO  obj) {
    return  ReturnValue.get200OK(this.orderService.PrintingOrder(obj.getOrder(),obj.getListDetail(),obj.getListExtraInfo()));
}
}
