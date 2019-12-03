package com.morelinks.feign.micro.product.api.service;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.product.api.dto.ConfigCategoryMenuDTO;
import com.morelinks.feign.micro.product.api.model.ConfigCategory;
import com.morelinks.feign.micro.product.api.model.dto.QueryParentAggregate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/configCategory")
public interface IConfigCategoryController {
	@RequestMapping(value = "/insert", method = {RequestMethod.POST})
	ReturnValue<Integer> insert(@RequestBody ConfigCategory category);

	@RequestMapping(value = "/getByPrimaryKey", method = {RequestMethod.GET})
	ReturnValue<ConfigCategory> getByPrimaryKey(@RequestParam(name = "id") Integer id);

	@RequestMapping(value = "/deleteByPrimaryKey", method = {RequestMethod.GET})
	ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id") Integer id);

	@RequestMapping(value = "/updateByPrimaryKey", method = {RequestMethod.POST})
	ReturnValue<Integer> updateByPrimaryKey(@RequestBody ConfigCategory obj);

	@RequestMapping(value = "/find", method = {RequestMethod.POST})
	ReturnValue<List<ConfigCategory>> find(@RequestBody QueryPageParam<ConfigCategory> query);

	@RequestMapping(value = "/getQueryResult", method = {RequestMethod.POST})
	ReturnValue<QueryResult<ConfigCategory>> getQueryResult(@RequestBody QueryPageParam<ConfigCategory> query);

	@RequestMapping(value = "/getConfigCategoryMenus", method = {RequestMethod.POST})
	ReturnValue<List<ConfigCategoryMenuDTO>> getConfigCategoryMenus(@RequestBody List<Integer> treeRoot);

	@RequestMapping(value = "/getTopConfigCategory", method = {RequestMethod.POST})
	ReturnValue<ConfigCategory> getTopConfigCategory(@RequestParam(name = "id") Integer id);

	@RequestMapping(value = "/findAllCateogyrIds", method = {RequestMethod.POST})
	ReturnValue<List<Integer>> findAllCateogyrIds(@RequestBody List<Integer> lstId);
}
