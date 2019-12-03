package com.morelinks.feign.micro.product.api.service;


import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.product.api.model.DiscountInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//import org.springframework.cloud.netflix.feign.FeignClient;

@RequestMapping("/discountInfo")
public interface IDiscountInfoController {

    @RequestMapping(value = "/insert", method = {RequestMethod.POST})
    ReturnValue<Integer> insert(@RequestBody DiscountInfo obj);

    @RequestMapping(value = "/getByPrimaryKey", method = {RequestMethod.GET})
    ReturnValue<DiscountInfo> getByPrimaryKey(@RequestParam(name = "id") Integer id);

    @RequestMapping(value = "/deleteByPrimaryKey", method = {RequestMethod.GET})
    ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id") Integer id);

    @RequestMapping(value = "/updateByPrimaryKey", method = {RequestMethod.POST})
    ReturnValue<Integer> updateByPrimaryKey(@RequestBody DiscountInfo obj);

    @RequestMapping(value = "/find", method = {RequestMethod.POST})
    ReturnValue<List<DiscountInfo>> find(@RequestBody QueryPageParam<DiscountInfo> query);

    @RequestMapping(value = "/getQueryResult", method = {RequestMethod.POST})
    ReturnValue<QueryResult<DiscountInfo>> getQueryResult(@RequestBody QueryPageParam<DiscountInfo> query) ;

    @RequestMapping(value = "/getValidDiscounts", method = {RequestMethod.GET})
    ReturnValue<List<DiscountInfo>> getValidDiscounts(@RequestParam(name = "id")String discountKey,
                                                             @RequestParam(name = "discountType")Integer discountType,
                                                             @RequestParam(name = "memberLevel")Integer memberLevel
    );
}