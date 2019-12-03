package com.morelinks.feign.micro.order.api.service;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.order.api.model.ConfigPrintOrderDetail;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IConfigPrintOrderDetailController {
@RequestMapping(value = "/insert", method = {RequestMethod.POST})
ReturnValue<Integer> insert(@RequestBody ConfigPrintOrderDetail obj);

@RequestMapping(value = "/getByPrimaryKey", method = {RequestMethod.GET})
ReturnValue<ConfigPrintOrderDetail> getByPrimaryKey(@RequestParam(name = "id") Integer id);

@RequestMapping(value = "/deleteByPrimaryKey", method = {RequestMethod.GET})
ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id") Integer id);

@RequestMapping(value = "/updateByPrimaryKey", method = {RequestMethod.POST})
ReturnValue<Integer> updateByPrimaryKey(@RequestBody ConfigPrintOrderDetail obj);

@RequestMapping(value = "/find", method = {RequestMethod.POST})
ReturnValue<List<ConfigPrintOrderDetail>> find(@RequestBody QueryPageParam<ConfigPrintOrderDetail> query);

@RequestMapping(value = "/getQueryResult", method = {RequestMethod.POST})
ReturnValue<QueryResult<ConfigPrintOrderDetail>> getQueryResult(@RequestBody QueryPageParam<ConfigPrintOrderDetail> query) ;
}
