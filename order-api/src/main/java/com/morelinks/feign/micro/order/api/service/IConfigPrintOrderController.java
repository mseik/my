package com.morelinks.feign.micro.order.api.service;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.order.api.model.ConfigPrintOrder;
import com.morelinks.feign.micro.order.api.model.ConfigPrintOrderDetail;
import com.morelinks.feign.micro.order.api.model.ConfigPrintOrderExtraInfo;
import com.morelinks.feign.micro.order.api.model.dto.PrintingDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@RequestMapping("configPrintOrder")
public interface IConfigPrintOrderController {
@RequestMapping(value = "/insert", method = {RequestMethod.POST})
ReturnValue<Integer> insert(@RequestBody ConfigPrintOrder obj);

@RequestMapping(value = "/getByPrimaryKey", method = {RequestMethod.GET})
ReturnValue<ConfigPrintOrder> getByPrimaryKey(@RequestParam(name = "id") String id);

@RequestMapping(value = "/deleteByPrimaryKey", method = {RequestMethod.GET})
ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id") String id);

@RequestMapping(value = "/updateByPrimaryKey", method = {RequestMethod.POST})
ReturnValue<Integer> updateByPrimaryKey(@RequestBody ConfigPrintOrder obj);

@RequestMapping(value = "/find", method = {RequestMethod.POST})
ReturnValue<List<ConfigPrintOrder>> find(@RequestBody QueryPageParam<ConfigPrintOrder> query);

@RequestMapping(value = "/getQueryResult", method = {RequestMethod.POST})
ReturnValue<QueryResult<ConfigPrintOrder>> getQueryResult(@RequestBody QueryPageParam<ConfigPrintOrder> query) ;

@RequestMapping(value = "/printingOrder", method = {RequestMethod.POST})
ReturnValue< Integer >    PrintingOrder(@RequestBody PrintingDTO  obj);
}
