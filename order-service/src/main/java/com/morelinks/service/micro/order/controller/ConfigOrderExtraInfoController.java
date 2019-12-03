package com.morelinks.service.micro.order.controller;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.order.api.model.ConfigOrderExtraInfo;
import com.morelinks.feign.micro.order.api.model.ConfigPrintOrderExtraInfo;
import com.morelinks.feign.micro.order.api.service.IConfigOrderExtraInfoController;
import com.morelinks.service.micro.order.service.ConfigOrderExtraInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ConfigOrderExtraInfoController implements IConfigOrderExtraInfoController {
    @Autowired
ConfigOrderExtraInfoService  extraInfoService;

@Override
public ReturnValue<Integer> insert(@RequestBody ConfigOrderExtraInfo obj) {
    return  ReturnValue.get200OK(this.extraInfoService.insert(obj));
}

@Override
public ReturnValue<ConfigOrderExtraInfo> getByPrimaryKey(@RequestParam(name = "id") Integer id) {
    return  ReturnValue.get200OK(this.extraInfoService.getByPrimaryKey(id));
}

@Override
public ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id") Integer id) {
    return ReturnValue.get200OK(this.extraInfoService.deleteByPrimaryKey(id));
}

@Override
public ReturnValue<Integer> updateByPrimaryKey(@RequestBody ConfigOrderExtraInfo obj) {
    return ReturnValue.get200OK(this.extraInfoService.updateByPrimaryKey(obj));
}

@Override
public ReturnValue<List<ConfigOrderExtraInfo>> find(@RequestBody QueryPageParam<ConfigOrderExtraInfo> query) {
    return  ReturnValue.get200OK(this.extraInfoService.find(query.getQuery(),query.getPage()));
}

@Override
public ReturnValue<QueryResult<ConfigOrderExtraInfo>> getQueryResult(@RequestBody QueryPageParam<ConfigOrderExtraInfo> query) {
    return ReturnValue.get200OK(this.extraInfoService.getQueryResult(query.getQuery(),query.getPage()));
}

@Override
public ReturnValue<Integer> deleteByOrderExtraInfo(@RequestBody ConfigOrderExtraInfo extraInfo) {
    return ReturnValue.get200OK(this.extraInfoService.deleteByOrderExtraInfo(extraInfo));
}

@Override
public ReturnValue<ConfigOrderExtraInfo> findTop(@RequestBody ConfigOrderExtraInfo extraInfo) {
    return  ReturnValue.get200OK(this.extraInfoService.findTop(extraInfo));
}
}
