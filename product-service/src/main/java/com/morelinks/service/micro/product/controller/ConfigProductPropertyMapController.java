package com.morelinks.service.micro.product.controller;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.product.api.model.ConfigProductPropertyMap;
import com.morelinks.feign.micro.product.api.service.IConfigProductPropertyMapController;
import com.morelinks.service.micro.product.service.ConfigProductPropertyMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ConfigProductPropertyMapController  implements IConfigProductPropertyMapController {
    @Autowired
ConfigProductPropertyMapService  mapService;
@Override
public ReturnValue<Integer> insert(@RequestBody ConfigProductPropertyMap obj) {
    return ReturnValue.get200OK(this.mapService.insert(obj));
}

@Override
public ReturnValue<ConfigProductPropertyMap> getByPrimaryKey(@RequestParam(name = "id") Integer id) {
    return ReturnValue.get200OK(this.mapService.getByPrimaryKey(id));
}

@Override
public ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id") Integer id) {
    return ReturnValue.get200OK(this.mapService.deleteByPrimaryKey(id));
}

@Override
public ReturnValue<Integer> updateByPrimaryKey(@RequestBody ConfigProductPropertyMap obj) {
    return ReturnValue.get200OK(this.mapService.updateByPrimaryKey(obj));
}

@Override
public ReturnValue<List<ConfigProductPropertyMap>> find(@RequestBody QueryPageParam<ConfigProductPropertyMap> query) {
    return ReturnValue.get200OK(this.mapService.find(query.getQuery(),query.getPage()));
}

@Override
public ReturnValue<QueryResult<ConfigProductPropertyMap>> getQueryResult(@RequestBody QueryPageParam<ConfigProductPropertyMap> query) {
    return ReturnValue.get200OK(this.mapService.queryPageResult(query.getQuery(),query.getPage()));
}

@Override
public ReturnValue<List<ConfigProductPropertyMap>> queryPageResultNew(@RequestBody List<Integer> list) {
    return ReturnValue.get200OK(this.mapService.queryPageResultNew(list));
}
}
