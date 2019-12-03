package com.morelinks.feign.micro.product.api.client;

import com.morelinks.feign.micro.product.api.service.IProductImgController;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "${micro.feign.proxy.product.name:morelinks-product-service}")
public interface ProductImgFeignClient extends IProductImgController {

}