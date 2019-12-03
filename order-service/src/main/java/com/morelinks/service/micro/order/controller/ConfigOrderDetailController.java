package com.morelinks.service.micro.order.controller;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.order.api.dto.QuerySelectedProducts;
import com.morelinks.feign.micro.order.api.dto.SelectedProducts;
import com.morelinks.feign.micro.order.api.model.ConfigOrderDetail;
import com.morelinks.feign.micro.order.api.service.IConfigOrderDetailController;
import com.morelinks.service.micro.order.service.ConfigOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ConfigOrderDetailController implements IConfigOrderDetailController {
    @Autowired
ConfigOrderDetailService  configOrderDetailService;
@Override
public ReturnValue<String> insert(@RequestBody ConfigOrderDetail obj) {
    return ReturnValue.get200OK(this.configOrderDetailService.insert(obj));
}

@Override
public ReturnValue<ConfigOrderDetail> getByPrimaryKey(@RequestParam(name = "id") String id) {
    return ReturnValue.get200OK(this.configOrderDetailService.getByPrimaryKey(id));
}

@Override
public ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id") String id) {
    return ReturnValue.get200OK(this.configOrderDetailService.deleteByPrimaryKey(id));
}

@Override
public ReturnValue<Integer> updateByPrimaryKey(@RequestBody ConfigOrderDetail obj) {
    return ReturnValue.get200OK(this.configOrderDetailService.updateByPrimaryKey(obj));
}

@Override
public ReturnValue<List<ConfigOrderDetail>> find(@RequestBody QueryPageParam<ConfigOrderDetail> query) {
    return  ReturnValue.get200OK(this.configOrderDetailService.find(query.getQuery(),query.getPage()));
}

@Override
public ReturnValue<QueryResult<ConfigOrderDetail>> getQueryResult(@RequestBody QueryPageParam<ConfigOrderDetail> query) {
    return ReturnValue.get200OK(this.configOrderDetailService.getQueryResult(query.getQuery(),query.getPage()));
}

@Override
public ReturnValue<Integer> deleteSelectedProducts(@RequestBody SelectedProducts selectedProducts) {
    return  ReturnValue.get200OK(this.configOrderDetailService.deleteSelectedProducts(selectedProducts));
}

@Override
public ReturnValue<List<ConfigOrderDetail>> querySelectedProducts(@RequestBody QuerySelectedProducts products) {

    return   ReturnValue.get200OK(this.configOrderDetailService.querySelectedProducts(products));
}

}
