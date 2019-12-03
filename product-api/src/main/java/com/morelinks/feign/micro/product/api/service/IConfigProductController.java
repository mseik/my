package com.morelinks.feign.micro.product.api.service;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.product.api.dto.ConfigProductDTO;
import com.morelinks.feign.micro.product.api.model.ConfigProduct;
import com.morelinks.feign.micro.product.api.model.dto.Query4ConfigProductDTO;
import com.morelinks.feign.micro.product.api.model.dto.QueryAgentProduct;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/configProduct")
public interface IConfigProductController {
	@RequestMapping(value = "/insert", method = {RequestMethod.POST})
	ReturnValue<Integer> insert(@RequestBody ConfigProduct obj);

	@RequestMapping(value = "/getByPrimaryKey", method = {RequestMethod.GET})
	ReturnValue<ConfigProduct> getByPrimaryKey(@RequestParam(name = "id") Integer id);

	@RequestMapping(value = "/deleteByPrimaryKey", method = {RequestMethod.GET})
	ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id") Integer id);

	@RequestMapping(value = "/updateByPrimaryKey", method = {RequestMethod.POST})
	ReturnValue<Integer> updateByPrimaryKey(@RequestBody ConfigProduct obj);

	@RequestMapping(value = "/find", method = {RequestMethod.POST})
	ReturnValue<List<ConfigProduct>> find(@RequestBody QueryPageParam<ConfigProduct> query);

	@RequestMapping(value = "/getQueryResult", method = {RequestMethod.POST})
	ReturnValue<QueryResult<ConfigProduct>> getQueryResult(@RequestBody QueryPageParam<ConfigProduct> query);

//	@RequestMapping(value = "/QuerySortProduct", method = {RequestMethod.POST})
//	ReturnValue<List<ConfigProduct>> QuerySortProduct(@RequestBody QueryAgentProduct query);

	@RequestMapping(value = "/queryConfigProductDTOs", method = {RequestMethod.POST})
	ReturnValue<QueryResult<ConfigProductDTO>> queryConfigProductDTOs(@RequestBody QueryPageParam<Query4ConfigProductDTO> query);
}
