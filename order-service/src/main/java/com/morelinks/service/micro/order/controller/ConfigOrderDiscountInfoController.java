package com.morelinks.service.micro.order.controller;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.order.api.model.ConfigOrderDiscountInfo;
import com.morelinks.feign.micro.order.api.service.IConfigOrderDiscountInfoController;
import com.morelinks.service.micro.order.service.ConfigOrderDiscountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ConfigOrderDiscountInfoController implements IConfigOrderDiscountInfoController {
    @Autowired
ConfigOrderDiscountInfoService  orderDiscountInfoService;
@Override
public ReturnValue<Integer> insert(@RequestBody ConfigOrderDiscountInfo obj) {
    return ReturnValue.get200OK(this.orderDiscountInfoService.insert(obj));
}

@Override
public ReturnValue<ConfigOrderDiscountInfo> getByPrimaryKey(@RequestParam(name = "id") Integer id) {
    return  ReturnValue.get200OK(this.orderDiscountInfoService.getByPrimaryKey(id));
}

@Override
public ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id") Integer id) {
    return ReturnValue.get200OK(this.orderDiscountInfoService.deleteByPrimaryKey(id));
}

@Override
public ReturnValue<Integer> updateByPrimaryKey(@RequestBody ConfigOrderDiscountInfo obj) {
    return ReturnValue.get200OK(this.orderDiscountInfoService.updateByPrimaryKey(obj));
}

@Override
public ReturnValue<List<ConfigOrderDiscountInfo>> find(@RequestBody QueryPageParam<ConfigOrderDiscountInfo> query) {
    return ReturnValue.get200OK(this.orderDiscountInfoService.find(query.getQuery(),query.getPage()));
}

@Override
public ReturnValue<QueryResult<ConfigOrderDiscountInfo>> getQueryResult(@RequestBody QueryPageParam<ConfigOrderDiscountInfo> query)
{
    return  ReturnValue.get200OK(this.orderDiscountInfoService.getQueryResult(query.getQuery(),query.getPage()));
}

@Override
public ReturnValue<ConfigOrderDiscountInfo>  findTop1(@RequestBody ConfigOrderDiscountInfo obj){
    return  ReturnValue.get200OK(this.orderDiscountInfoService.findTop1(obj));

}

@Override
public ReturnValue<Integer> deleteByPrimaryKeySelective(ConfigOrderDiscountInfo obj) {
    return ReturnValue.get200OK(this.deleteByPrimaryKeySelective(obj));
}
}
