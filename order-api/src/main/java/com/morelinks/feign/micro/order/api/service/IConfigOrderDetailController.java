package com.morelinks.feign.micro.order.api.service;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.order.api.dto.QuerySelectedProducts;
import com.morelinks.feign.micro.order.api.dto.SelectedProducts;
import com.morelinks.feign.micro.order.api.model.ConfigOrderDetail;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@RequestMapping("/configOrderDetail")
public interface IConfigOrderDetailController {
@RequestMapping(value = "/insert", method = {RequestMethod.POST})
ReturnValue<String> insert(@RequestBody ConfigOrderDetail obj);

@RequestMapping(value = "/getByPrimaryKey", method = {RequestMethod.GET})
ReturnValue<ConfigOrderDetail> getByPrimaryKey(@RequestParam(name = "id") String id);

@RequestMapping(value = "/deleteByPrimaryKey", method = {RequestMethod.GET})
ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id") String id);

@RequestMapping(value = "/updateByPrimaryKey", method = {RequestMethod.POST})
ReturnValue<Integer> updateByPrimaryKey(@RequestBody ConfigOrderDetail obj);

@RequestMapping(value = "/find", method = {RequestMethod.POST})
ReturnValue<List<ConfigOrderDetail>> find(@RequestBody QueryPageParam<ConfigOrderDetail> query);

@RequestMapping(value = "/getQueryResult", method = {RequestMethod.POST})
ReturnValue<QueryResult<ConfigOrderDetail>> getQueryResult(@RequestBody QueryPageParam<ConfigOrderDetail> query) ;

@RequestMapping(value = "/deleteSelectedProducts", method = {RequestMethod.POST})
ReturnValue<Integer>   deleteSelectedProducts(@RequestBody SelectedProducts selectedProducts);

@RequestMapping(value = "/querySelectedProducts", method = {RequestMethod.POST})
ReturnValue<List<ConfigOrderDetail>>   querySelectedProducts(@RequestBody QuerySelectedProducts products);
}
