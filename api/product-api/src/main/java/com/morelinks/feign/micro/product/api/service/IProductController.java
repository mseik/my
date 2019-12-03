package com.morelinks.feign.micro.product.api.service;


import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.product.api.dto.ProductDTO;
import com.morelinks.feign.micro.product.api.model.Product;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

//import org.springframework.cloud.netflix.feign.FeignClient;

@RequestMapping("/product")
public interface IProductController {

    @RequestMapping(value = "/insert", method = {RequestMethod.POST})
    ReturnValue<Integer> insert(@RequestBody Product obj);

    @RequestMapping(value = "/getByPrimaryKey", method = {RequestMethod.GET})
    ReturnValue<Product> getByPrimaryKey(@RequestParam(name = "id") Integer id);

    @RequestMapping(value = "/deleteByPrimaryKey", method = {RequestMethod.GET})
    ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id") Integer id);

    @RequestMapping(value = "/updateByPrimaryKey", method = {RequestMethod.POST})
    ReturnValue<Integer> updateByPrimaryKey(@RequestBody Product obj);

    @RequestMapping(value = "/find", method = {RequestMethod.POST})
    ReturnValue<List<Product>> find(@RequestBody QueryPageParam<Product> query);

    @RequestMapping(value = "/getQueryResult", method = {RequestMethod.POST})
    ReturnValue<QueryResult<Product>> getQueryResult(@RequestBody QueryPageParam<Product> query) ;

    @RequestMapping(value = "/getProductDTO", method = {RequestMethod.GET})
    ReturnValue<ProductDTO> getProductDTO(@RequestParam(name = "id")Integer id);

    @RequestMapping(value = "/calProductShowAmount", method = {RequestMethod.GET})
    ReturnValue<BigDecimal> calProductShowAmount(@RequestParam(name = "productAmount")BigDecimal productAmount,
                                                    @RequestParam(name = "memberAmount",required = false)BigDecimal memberAmount,
                                                    @RequestParam(name = "userLevel",required = false)Integer userLevel,
                                                    @RequestParam(name = "noTaxBill",required = false)Integer noTaxBill,
                                                    @RequestParam(name = "discountRate",required = false)BigDecimal discountRate,
                                                    @RequestParam(name = "deduceGoods",required = false)Integer deduceGoods);

    @RequestMapping(value = "/getUserDiscountRate", method = {RequestMethod.GET})
    ReturnValue<BigDecimal> getUserDiscountRate(@RequestParam(name = "userLevel",required = false)Integer userLevel);
}