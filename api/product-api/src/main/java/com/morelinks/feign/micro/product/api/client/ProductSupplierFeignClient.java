package com.morelinks.feign.micro.product.api.client;

import com.morelinks.feign.micro.product.api.service.IProductSupplierController;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "${micro.feign.proxy.product.name:morelinks-product-service}")
public interface ProductSupplierFeignClient extends IProductSupplierController {

}