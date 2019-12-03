package com.morelinks.service.micro.product.controller;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.product.api.dto.ConfigProductDTO;
import com.morelinks.feign.micro.product.api.model.ConfigProduct;
import com.morelinks.feign.micro.product.api.model.ConfigProduct;
import com.morelinks.feign.micro.product.api.model.dto.Query4ConfigProductDTO;
import com.morelinks.feign.micro.product.api.model.dto.QueryAgentProduct;
import com.morelinks.feign.micro.product.api.service.IConfigProductController;
import com.morelinks.service.micro.product.service.ConfigCategoryService;
import com.morelinks.service.micro.product.service.ConfigProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ConfigProductController implements IConfigProductController {
	@Autowired
	ConfigProductService productService;

	@Autowired
	ConfigCategoryService configCategoryService;

	@Override
	public ReturnValue<Integer> insert(@RequestBody ConfigProduct obj) {

		return ReturnValue.get200OK(this.productService.insert(obj));
	}

	@Override
	public ReturnValue<ConfigProduct> getByPrimaryKey(@RequestParam(name = "id") Integer id) {
		return ReturnValue.get200OK(this.productService.getByPrimaryKey(id));
	}


	@Override
	public ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id") Integer id) {
		return ReturnValue.get200OK(this.productService.deleteByPrimaryKey(id));
	}

	@Override
	public ReturnValue<Integer> updateByPrimaryKey(@RequestBody ConfigProduct obj) {
		return ReturnValue.get200OK(this.productService.updateByPrimaryKey(obj));
	}

	@Override
	public ReturnValue<List<ConfigProduct>> find(@RequestBody QueryPageParam<ConfigProduct> query) {
		return ReturnValue.get200OK(this.productService.find(query.getQuery(), query.getPage()));
	}

	@Override
	public ReturnValue<QueryResult<ConfigProduct>> getQueryResult(@RequestBody QueryPageParam<ConfigProduct> query) {
		return ReturnValue.get200OK(this.productService.getQueryResult(query.getQuery(), query.getPage()));
	}

//	@Override
//	public ReturnValue<List<ConfigProduct>> QuerySortProduct(@RequestBody QueryAgentProduct query) {
//		return ReturnValue.get200OK(this.productService.QuerySortProduct(query));
//	}

	@Override
	public ReturnValue<QueryResult<ConfigProductDTO>> queryConfigProductDTOs(@RequestBody QueryPageParam<Query4ConfigProductDTO> query)
	{
		if(query.getQuery()==null)
		{
			return ReturnValue.get200OK(new QueryResult<>());
		}
		if( query.getQuery().getCategoryIds()!=null && query.getQuery().getCategoryIds().size()>0)
		{
			query.getQuery().setCategoryIds(configCategoryService.findAllCateogyrIds(query.getQuery().getCategoryIds()));
		}
		return ReturnValue.get200OK(this.productService.queryConfigProductDTOs(query.getQuery(), query.getPage()));
	}

}
