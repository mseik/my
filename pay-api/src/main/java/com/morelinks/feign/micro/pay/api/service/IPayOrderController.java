package com.morelinks.feign.micro.pay.api.service;


import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.pay.api.model.PayOrder;
import com.morelinks.feign.micro.pay.api.model.dto.Query4PayOrder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

//import org.springframework.cloud.netflix.feign.FeignClient;

@RequestMapping("/payOrder")
public interface IPayOrderController {

    @RequestMapping(value = "/getById", method = {RequestMethod.GET})
    ReturnValue<PayOrder> getById(@RequestParam(name = "id")String id);

    @RequestMapping(value = "/createPayOrder", method = {RequestMethod.POST})
    ReturnValue<String> createPayOrder(@RequestBody PayOrder obj);

    @RequestMapping(value = "/getValidPayOrderByMerchantOrderId", method = {RequestMethod.GET})
    ReturnValue<PayOrder> getValidPayOrderByMerchantOrderId(@RequestParam(name = "merchantOrderId")String merchantOrderId,
                                                            @RequestParam(name = "orderType")Integer orderType);
    @RequestMapping(value = "/accountPay", method = {RequestMethod.POST})
    ReturnValue accountPay(@RequestParam(name = "payOrderId")String payOrderId,
                           @RequestParam(name = "accountId")Integer accountId,
                           @RequestParam(name = "payAmount")BigDecimal payAmount,
                           @RequestParam(name = "remark",required = false)String remark);

    @RequestMapping(value = "/rechargeAccount", method = {RequestMethod.POST})
    ReturnValue rechargeAccount(@RequestParam(name = "payOrderId")String payOrderId,
                                @RequestParam(name = "operator",required = false)String operator,
                                @RequestParam(name = "remark",required = false)String remark);

    @RequestMapping(value = "/getQueryResultNew", method = {RequestMethod.POST})
    ReturnValue<QueryResult<PayOrder>> getQueryResultNew(@RequestBody QueryPageParam<Query4PayOrder>  query);

    @RequestMapping(value = "/payFail", method = {RequestMethod.POST})
    ReturnValue payFail(
            @RequestParam(name = "payOrderId")String payOrderId,
            @RequestParam(name = "operator",required = false)String operator,
            @RequestParam(name = "remark",required = false)String remark
    );

}