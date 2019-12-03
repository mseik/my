package com.morelinks.feign.micro.product.api.service;


import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.product.api.model.ProductBrand;
import com.morelinks.feign.micro.product.api.model.dto.QueryProduct;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//import org.springframework.cloud.netflix.feign.FeignClient;

@RequestMapping("/productBrand")
public interface IProductBrandController {

    @RequestMapping(value = "/insert", method = {RequestMethod.POST})
    ReturnValue<Integer> insert(@RequestBody ProductBrand obj);

    @RequestMapping(value = "/getByPrimaryKey", method = {RequestMethod.GET})
    ReturnValue<ProductBrand> getByPrimaryKey(@RequestParam(name = "id") Integer id);

    @RequestMapping(value = "/deleteByPrimaryKey", method = {RequestMethod.GET})
    ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id") Integer id);

    @RequestMapping(value = "/updateByPrimaryKey", method = {RequestMethod.POST})
    ReturnValue<Integer> updateByPrimaryKey(@RequestBody ProductBrand obj);

    @RequestMapping(value = "/find", method = {RequestMethod.POST})
    ReturnValue<List<ProductBrand>> find(@RequestBody QueryPageParam<ProductBrand> query);

    @RequestMapping(value = "/getQueryResult", method = {RequestMethod.POST})
    ReturnValue<QueryResult<ProductBrand>> getQueryResult(@RequestBody QueryPageParam<ProductBrand> query);

    @RequestMapping(value = "/queryProduct", method = {RequestMethod.POST})
    ReturnValue< List<ProductBrand>> queryProduct(@RequestBody QueryProduct product);




}