package com.morelinks.service.micro.order.controller;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.order.api.model.ConfigPrintOrderDetail;
import com.morelinks.feign.micro.order.api.service.IConfigPrintOrderDetailController;
import com.morelinks.service.micro.order.service.ConfigPrintOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ConfigPrintOrderDetailController implements IConfigPrintOrderDetailController {
    @Autowired
ConfigPrintOrderDetailService detailService;

@Override
public ReturnValue<Integer> insert(@RequestBody ConfigPrintOrderDetail obj) {
    return ReturnValue.get200OK(this.detailService.insert(obj));
}

@Override
public ReturnValue<ConfigPrintOrderDetail> getByPrimaryKey(@RequestParam(name = "id") Integer id) {
    return ReturnValue.get200OK(this.detailService.getByPrimaryKey(id));
}

@Override
public ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id") Integer id) {
    return ReturnValue.get200OK(this.detailService.deleteByPrimaryKey(id));
}

@Override
public ReturnValue<Integer> updateByPrimaryKey(@RequestBody ConfigPrintOrderDetail obj) {
    return ReturnValue.get200OK(this.detailService.updateByPrimaryKey(obj));
}

@Override
public ReturnValue<List<ConfigPrintOrderDetail>> find(@RequestBody QueryPageParam<ConfigPrintOrderDetail> query) {
    return ReturnValue.get200OK(this.detailService.find(query.getQuery(),query.getPage()));
}

@Override
public ReturnValue<QueryResult<ConfigPrintOrderDetail>> getQueryResult(@RequestBody QueryPageParam<ConfigPrintOrderDetail> query) {
    return ReturnValue.get200OK(this.detailService.getQueryResult(query.getQuery(),query.getPage()));
}
}
