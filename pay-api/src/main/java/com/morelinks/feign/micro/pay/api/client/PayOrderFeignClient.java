package com.morelinks.feign.micro.pay.api.client;

import com.morelinks.feign.micro.pay.api.service.IPayOrderController;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "${micro.feign.proxy.pay.name:morelinks-pay-service}")
public interface PayOrderFeignClient extends IPayOrderController {

}