package com.morelinks.service.micro.order.controller;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.order.api.model.ConfigPrintOrderExtraInfo;
import com.morelinks.feign.micro.order.api.service.IConfigPrintOrderExtraInfoController;
import com.morelinks.service.micro.order.service.ConfigPrintOrderExtraInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ConfigPrintOrderExtraInfoController implements IConfigPrintOrderExtraInfoController {
    @Autowired
ConfigPrintOrderExtraInfoService  extraInfoService;
@Override
public ReturnValue<Integer> insert(@RequestBody ConfigPrintOrderExtraInfo obj) {
    return ReturnValue.get200OK(this.extraInfoService.insert(obj));
}

@Override
public ReturnValue<ConfigPrintOrderExtraInfo> getByPrimaryKey(@RequestParam(name = "id") Integer id) {
    return ReturnValue.get200OK(this.extraInfoService.getByPrimaryKey(id));
}

@Override
public ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id") Integer id) {
    return ReturnValue.get200OK(this.extraInfoService.deleteByPrimaryKey(id));
}

@Override
public ReturnValue<Integer> updateByPrimaryKey(@RequestBody ConfigPrintOrderExtraInfo obj) {
    return ReturnValue.get200OK(this.extraInfoService.updateByPrimaryKey(obj));
}

@Override
public ReturnValue<List<ConfigPrintOrderExtraInfo>> find(@RequestBody QueryPageParam<ConfigPrintOrderExtraInfo> query) {
    return ReturnValue.get200OK(this.extraInfoService.find(query.getQuery(),query.getPage()));
}

@Override
public ReturnValue<QueryResult<ConfigPrintOrderExtraInfo>> getQueryResult(@RequestBody QueryPageParam<ConfigPrintOrderExtraInfo> query) {
    return ReturnValue.get200OK(this.extraInfoService.getQueryResult(query.getQuery(),query.getPage()));
}
}
