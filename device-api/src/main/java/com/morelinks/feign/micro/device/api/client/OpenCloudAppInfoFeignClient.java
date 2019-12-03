package com.morelinks.feign.micro.device.api.client;

import com.morelinks.feign.micro.device.api.service.IOpenCloudAppInfoController;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "${micro.feign.proxy.device.name:morelinks-device-service}")
public interface OpenCloudAppInfoFeignClient extends IOpenCloudAppInfoController {

}