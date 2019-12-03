package com.morelinks.service.micro.product.controller;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.product.api.model.ConfigProductAgentExtra;
import com.morelinks.feign.micro.product.api.service.IConfigProductAgentExtraController;
import com.morelinks.service.micro.product.service.ConfigProductAgentExtraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ConfigProductAgentExtraController implements IConfigProductAgentExtraController {
    @Autowired
ConfigProductAgentExtraService  extraService;
@Override
public ReturnValue<Integer> insert(@RequestBody ConfigProductAgentExtra category) {
    return ReturnValue.get200OK(this.extraService.insert(category));
}

@Override
public ReturnValue<ConfigProductAgentExtra> getByPrimaryKey(@RequestParam(name = "id") Integer id) {
    return ReturnValue.get200OK(this.extraService.getByPrimaryKey(id));
}

@Override
public ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id") Integer id) {
    return ReturnValue.get200OK(this.extraService.deleteByPrimaryKey(id));
}

@Override
public ReturnValue<Integer> updateByPrimaryKey(@RequestBody ConfigProductAgentExtra obj) {
    return ReturnValue.get200OK(this.extraService.updateByPrimaryKey(obj));
}

@Override
public ReturnValue<List<ConfigProductAgentExtra>> find(@RequestBody QueryPageParam<ConfigProductAgentExtra> query) {
    return ReturnValue.get200OK(this.extraService.find(query.getQuery(),query.getPage()));
}

@Override
public ReturnValue<QueryResult<ConfigProductAgentExtra>> getQueryResult(@RequestBody QueryPageParam<ConfigProductAgentExtra> query) {
    return ReturnValue.get200OK(this.extraService.getQueryResult(query.getQuery(),query.getPage()));
}
}
