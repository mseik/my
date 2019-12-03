package com.morelinks.feign.micro.order.api.service;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.order.api.model.ConfigOrderExtraInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@RequestMapping("/configOrderExtraInfo")
public interface IConfigOrderExtraInfoController {
@RequestMapping(value = "/insert", method = {RequestMethod.POST})
ReturnValue<Integer> insert(@RequestBody ConfigOrderExtraInfo obj);

@RequestMapping(value = "/getByPrimaryKey", method = {RequestMethod.GET})
ReturnValue<ConfigOrderExtraInfo> getByPrimaryKey(@RequestParam(name = "id") Integer id);

@RequestMapping(value = "/deleteByPrimaryKey", method = {RequestMethod.GET})
ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id") Integer id);

@RequestMapping(value = "/updateByPrimaryKey", method = {RequestMethod.POST})
ReturnValue<Integer> updateByPrimaryKey(@RequestBody ConfigOrderExtraInfo obj);

@RequestMapping(value = "/find", method = {RequestMethod.POST})
ReturnValue<List<ConfigOrderExtraInfo>> find(@RequestBody QueryPageParam<ConfigOrderExtraInfo> query);

@RequestMapping(value = "/getQueryResult", method = {RequestMethod.POST})
ReturnValue<QueryResult<ConfigOrderExtraInfo>> getQueryResult(@RequestBody QueryPageParam<ConfigOrderExtraInfo> query);

@RequestMapping(value = "/deleteByOrderExtraInfo", method = {RequestMethod.POST})
ReturnValue<Integer>  deleteByOrderExtraInfo(@RequestBody ConfigOrderExtraInfo extraInfo);

@RequestMapping(value = "/findTop", method = {RequestMethod.POST})
ReturnValue<ConfigOrderExtraInfo>  findTop(@RequestBody ConfigOrderExtraInfo extraInfo);
}
