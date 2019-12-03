package com.morelinks.feign.micro.order.api.service;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.order.api.model.ConfigOrderDiscountInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@RequestMapping("/configOrderDiscountInfo")
public interface IConfigOrderDiscountInfoController {
@RequestMapping(value = "/insert", method = {RequestMethod.POST})
ReturnValue<Integer> insert(@RequestBody ConfigOrderDiscountInfo obj);

@RequestMapping(value = "/getByPrimaryKey", method = {RequestMethod.GET})
ReturnValue<ConfigOrderDiscountInfo> getByPrimaryKey(@RequestParam(name = "id") Integer id);

@RequestMapping(value = "/deleteByPrimaryKey", method = {RequestMethod.GET})
ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id") Integer id);

@RequestMapping(value = "/updateByPrimaryKey", method = {RequestMethod.POST})
ReturnValue<Integer> updateByPrimaryKey(@RequestBody ConfigOrderDiscountInfo obj);

@RequestMapping(value = "/find", method = {RequestMethod.POST})
ReturnValue<List<ConfigOrderDiscountInfo>> find(@RequestBody QueryPageParam<ConfigOrderDiscountInfo> query);

@RequestMapping(value = "/getQueryResult", method = {RequestMethod.POST})
ReturnValue<QueryResult<ConfigOrderDiscountInfo>> getQueryResult(@RequestBody QueryPageParam<ConfigOrderDiscountInfo> query) ;

@RequestMapping(value = "/findTop1", method = {RequestMethod.POST})
ReturnValue<ConfigOrderDiscountInfo>  findTop1(@RequestBody ConfigOrderDiscountInfo obj);

@RequestMapping(value = "/deleteByPrimaryKeySelective", method = {RequestMethod.POST})
ReturnValue<Integer> deleteByPrimaryKeySelective(ConfigOrderDiscountInfo obj);



}
