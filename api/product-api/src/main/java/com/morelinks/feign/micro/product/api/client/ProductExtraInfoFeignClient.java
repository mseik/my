package com.morelinks.feign.micro.product.api.client;

import com.morelinks.feign.micro.product.api.service.IProductExtraInfoController;
import com.morelinks.feign.micro.product.api.service.IProductInfoController;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "${micro.feign.proxy.product.name:morelinks-product-service}")
public interface ProductExtraInfoFeignClient extends IProductExtraInfoController {

}