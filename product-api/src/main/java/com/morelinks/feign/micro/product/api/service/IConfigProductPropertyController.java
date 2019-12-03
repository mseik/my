package com.morelinks.feign.micro.product.api.service;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.product.api.model.ConfigProductProperty;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@RequestMapping(value = "/configProductProperty", method = {RequestMethod.POST})
public interface IConfigProductPropertyController {
@RequestMapping(value = "/insert", method = {RequestMethod.POST})
ReturnValue<Integer> insert(@RequestBody ConfigProductProperty obj);

@RequestMapping(value = "/getByPrimaryKey", method = {RequestMethod.GET})
ReturnValue<ConfigProductProperty> getByPrimaryKey(@RequestParam(name = "id") Integer id);

@RequestMapping(value = "/deleteByPrimaryKey", method = {RequestMethod.GET})
ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id") Integer id);

@RequestMapping(value = "/updateByPrimaryKey", method = {RequestMethod.POST})
ReturnValue<Integer> updateByPrimaryKey(@RequestBody ConfigProductProperty obj);

@RequestMapping(value = "/find", method = {RequestMethod.POST})
ReturnValue<List<ConfigProductProperty>> find(@RequestBody QueryPageParam<ConfigProductProperty> query);

@RequestMapping(value = "/getQueryResult", method = {RequestMethod.POST})
ReturnValue<QueryResult<ConfigProductProperty>> getQueryResult(@RequestBody QueryPageParam<ConfigProductProperty> query) ;

}
