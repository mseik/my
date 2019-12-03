package com.morelinks.feign.micro.product.api.service;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.product.api.model.ConfigProductPropertyMap;
import com.morelinks.feign.micro.product.api.model.ConfigProductPropertyMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@RequestMapping(value = "/configProductPropertyMap", method = {RequestMethod.POST})
public interface IConfigProductPropertyMapController {
@RequestMapping(value = "/insert", method = {RequestMethod.POST})
ReturnValue<Integer> insert(@RequestBody ConfigProductPropertyMap obj);

@RequestMapping(value = "/getByPrimaryKey", method = {RequestMethod.GET})
ReturnValue<ConfigProductPropertyMap> getByPrimaryKey(@RequestParam(name = "id") Integer id);

@RequestMapping(value = "/deleteByPrimaryKey", method = {RequestMethod.GET})
ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id") Integer id);

@RequestMapping(value = "/updateByPrimaryKey", method = {RequestMethod.POST})
ReturnValue<Integer> updateByPrimaryKey(@RequestBody ConfigProductPropertyMap obj);

@RequestMapping(value = "/find", method = {RequestMethod.POST})
ReturnValue<List<ConfigProductPropertyMap>> find(@RequestBody QueryPageParam<ConfigProductPropertyMap> query);

@RequestMapping(value = "/getQueryResult", method = {RequestMethod.POST})
ReturnValue<QueryResult<ConfigProductPropertyMap>> getQueryResult(@RequestBody QueryPageParam<ConfigProductPropertyMap> query) ;

@RequestMapping(value = "/queryPageResultNew", method = {RequestMethod.POST})
ReturnValue<List<ConfigProductPropertyMap>> queryPageResultNew(@RequestBody List<Integer> list);
}
