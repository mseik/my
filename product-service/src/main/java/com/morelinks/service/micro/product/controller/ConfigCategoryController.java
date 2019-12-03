package com.morelinks.service.micro.product.controller;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.product.api.dto.ConfigCategoryMenuDTO;
import com.morelinks.feign.micro.product.api.model.ConfigCategory;
import com.morelinks.feign.micro.product.api.model.dto.QueryParentAggregate;
import com.morelinks.feign.micro.product.api.service.IConfigCategoryController;
import com.morelinks.service.micro.product.service.ConfigCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConfigCategoryController implements IConfigCategoryController {
	@Autowired
	ConfigCategoryService configCategoryService;


	@Override
	public ReturnValue<Integer> insert(@RequestBody ConfigCategory category) {

		return ReturnValue.get200OK(this.configCategoryService.insert(category));
	}

	@Override
	public ReturnValue<ConfigCategory> getByPrimaryKey(@RequestParam(name = "id") Integer id) {
		return ReturnValue.get200OK(this.configCategoryService.getByPrimaryKey(id));
	}

	@Override
	public ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id") Integer id) {
		return ReturnValue.get200OK(this.configCategoryService.deleteByPrimaryKey(id));
	}

	@Override
	public ReturnValue<Integer> updateByPrimaryKey(@RequestBody ConfigCategory obj) {
		return ReturnValue.get200OK(this.configCategoryService.updateByPrimaryKey(obj));
	}

	@Override
	public ReturnValue<List<ConfigCategory>> find(@RequestBody QueryPageParam<ConfigCategory> query) {
		return ReturnValue.get200OK(this.configCategoryService.find(query.getQuery(), query.getPage()));
	}

	@Override
	public ReturnValue<QueryResult<ConfigCategory>> getQueryResult(@RequestBody QueryPageParam<ConfigCategory> query) {
		return ReturnValue.get200OK(this.configCategoryService.getQueryResult(query.getQuery(), query.getPage()));
	}

	@Override
	public ReturnValue<List<ConfigCategoryMenuDTO>> getConfigCategoryMenus(@RequestBody List<Integer> category) {
		return ReturnValue.get200OK(this.configCategoryService.getTreeQuery(category));
	}

	/**
	 * 查找所有的类别 包含子类别
	 * @param query
	 * @return
	 */
	@Override
	public ReturnValue<List<Integer>> findAllCateogyrIds(@RequestBody List<Integer> lstId) {

		return ReturnValue.get200OK(this.configCategoryService.findAllCateogyrIds(lstId));

	}
	@Override
	public ReturnValue<ConfigCategory> getTopConfigCategory(@RequestParam(name = "id") Integer id) {
		return ReturnValue.get200OK(this.configCategoryService.CategoryTopFloor(id));
	}
}
