package com.morelinks.feign.micro.product.api.service;


import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.product.api.dto.ProductModelDTO;
import com.morelinks.feign.micro.product.api.model.ProductModel;
import com.morelinks.feign.micro.product.api.model.dto.Query4ProductModel;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//import org.springframework.cloud.netflix.feign.FeignClient;

@RequestMapping("/productModel")
public interface IProductModelController {

    @RequestMapping(value = "/insert", method = {RequestMethod.POST})
    ReturnValue<Integer> insert(@RequestBody ProductModel obj);

    @RequestMapping(value = "/getByPrimaryKey", method = {RequestMethod.GET})
    ReturnValue<ProductModel> getByPrimaryKey(@RequestParam(name = "id") Integer id);

    @RequestMapping(value = "/deleteByPrimaryKey", method = {RequestMethod.GET})
    ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id") Integer id);

    @RequestMapping(value = "/updateByPrimaryKey", method = {RequestMethod.POST})
    ReturnValue<Integer> updateByPrimaryKey(@RequestBody ProductModel obj);

    @RequestMapping(value = "/find", method = {RequestMethod.POST})
    ReturnValue<List<ProductModel>> find(@RequestBody QueryPageParam<ProductModel> query);

    @RequestMapping(value = "/getQueryResult", method = {RequestMethod.POST})
    ReturnValue<QueryResult<ProductModel>> getQueryResult(@RequestBody QueryPageParam<ProductModel> query) ;

    @RequestMapping(value = "/getModelDTOQueryResult", method = {RequestMethod.POST})
    ReturnValue<QueryResult<ProductModelDTO>> getModelDTOQueryResult(@RequestBody QueryPageParam<Query4ProductModel> query);

    @RequestMapping(value = "/getModelDTO", method = {RequestMethod.GET})
    ReturnValue<ProductModelDTO> getModelDTO(@RequestParam(name = "id")Integer id);
}