package com.morelinks.feign.micro.order.api.service;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.order.api.model.ConfigPrintOrderExtraInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@RequestMapping("/configPrintOrderExtraInfo")
public interface IConfigPrintOrderExtraInfoController {
@RequestMapping(value = "/insert", method = {RequestMethod.POST})
ReturnValue<Integer> insert(@RequestBody ConfigPrintOrderExtraInfo obj);

@RequestMapping(value = "/getByPrimaryKey", method = {RequestMethod.GET})
ReturnValue<ConfigPrintOrderExtraInfo> getByPrimaryKey(@RequestParam(name = "id") Integer id);

@RequestMapping(value = "/deleteByPrimaryKey", method = {RequestMethod.GET})
ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id") Integer id);

@RequestMapping(value = "/updateByPrimaryKey", method = {RequestMethod.POST})
ReturnValue<Integer> updateByPrimaryKey(@RequestBody ConfigPrintOrderExtraInfo obj);

@RequestMapping(value = "/find", method = {RequestMethod.POST})
ReturnValue<List<ConfigPrintOrderExtraInfo>> find(@RequestBody QueryPageParam<ConfigPrintOrderExtraInfo> query);

@RequestMapping(value = "/getQueryResult", method = {RequestMethod.POST})
ReturnValue<QueryResult<ConfigPrintOrderExtraInfo>> getQueryResult(@RequestBody QueryPageParam<ConfigPrintOrderExtraInfo> query);
}
