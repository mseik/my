package com.morelinks.feign.micro.product.api.client;

import com.morelinks.feign.micro.product.api.service.IConfigProductPropertyController;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "${micro.feign.proxy.product.name:morelinks-product-service}")
public interface ConfigProductPropertyFeignClient extends IConfigProductPropertyController {
}
