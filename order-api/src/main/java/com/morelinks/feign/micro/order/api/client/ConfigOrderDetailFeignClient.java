package com.morelinks.feign.micro.order.api.client;

import com.morelinks.feign.micro.order.api.service.IConfigOrderDetailController;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "${micro.feign.proxy.order.name:morelinks-order-service}")
public interface ConfigOrderDetailFeignClient extends IConfigOrderDetailController {
}
