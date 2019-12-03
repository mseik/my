package com.morelinks.feign.micro.product.api.service;


import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.product.api.model.ProductExtraInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//import org.springframework.cloud.netflix.feign.FeignClient;

@RequestMapping("/productExtraInfo")
public interface IProductExtraInfoController {

    @RequestMapping(value = "/insert", method = {RequestMethod.POST})
    ReturnValue<Integer> insert(@RequestBody ProductExtraInfo obj);

    @RequestMapping(value = "/getByPrimaryKey", method = {RequestMethod.GET})
    ReturnValue<ProductExtraInfo> getByPrimaryKey(@RequestParam(name = "id") Integer id);

    @RequestMapping(value = "/deleteByPrimaryKey", method = {RequestMethod.GET})
    ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id") Integer id);

    @RequestMapping(value = "/updateByPrimaryKey", method = {RequestMethod.POST})
    ReturnValue<Integer> updateByPrimaryKey(@RequestBody ProductExtraInfo obj);

    @RequestMapping(value = "/find", method = {RequestMethod.POST})
    ReturnValue<List<ProductExtraInfo>> find(@RequestBody QueryPageParam<ProductExtraInfo> query);

    @RequestMapping(value = "/getQueryResult", method = {RequestMethod.POST})
    ReturnValue<QueryResult<ProductExtraInfo>> getQueryResult(@RequestBody QueryPageParam<ProductExtraInfo> query) ;

    @RequestMapping(value = "/getByExtraKey", method = {RequestMethod.GET})
    ReturnValue<ProductExtraInfo> getByExtraKey(@RequestParam(name = "extraKey")String extraKey,
                                                @RequestParam(name = "extraType")Integer extraType);

}