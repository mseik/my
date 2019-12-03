package com.morelinks.service.micro.product.controller;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.product.api.model.ConfigProductProperty;
import com.morelinks.feign.micro.product.api.service.IConfigProductPropertyController;
import com.morelinks.service.micro.product.service.ConfigProductPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConfigProductPropertyController implements IConfigProductPropertyController {
    @Autowired
ConfigProductPropertyService  propertyService;
@Override
public ReturnValue<Integer> insert(@RequestBody ConfigProductProperty obj) {
    return ReturnValue.get200OK(this.propertyService.insert(obj));
}

@Override
public ReturnValue<ConfigProductProperty> getByPrimaryKey(@RequestParam(name = "id") Integer id) {
    return ReturnValue.get200OK(this.propertyService.getByPrimaryKey(id));
}

@Override
public ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id") Integer id) {
    return ReturnValue.get200OK(this.propertyService.deleteByPrimaryKey(id));
}

@Override
public ReturnValue<Integer> updateByPrimaryKey(@RequestBody ConfigProductProperty obj) {
    return ReturnValue.get200OK(this.propertyService.updateByPrimaryKey(obj));
}

@Override
public ReturnValue<List<ConfigProductProperty>> find(@RequestBody QueryPageParam<ConfigProductProperty> query) {
    return ReturnValue.get200OK(this.propertyService.find(query.getQuery(),query.getPage()));
}

@Override
public ReturnValue<QueryResult<ConfigProductProperty>> getQueryResult(@RequestBody QueryPageParam<ConfigProductProperty> query) {
    return ReturnValue.get200OK(this.propertyService.getQueryResult(query.getQuery(),query.getPage()));
}
}
