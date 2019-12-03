package com.morelinks.feign.demo.api.client;

import com.morelinks.feign.demo.api.service.ITestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "${micro.feign.proxy.demo.name:morelinks-demo-service}")
public interface TestFeignClient extends ITestController {

}