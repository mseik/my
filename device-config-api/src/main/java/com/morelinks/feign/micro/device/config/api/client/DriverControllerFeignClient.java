package com.morelinks.feign.micro.device.config.api.client;

import com.morelinks.feign.micro.device.config.api.service.IDeviceTypeController;
import com.morelinks.feign.micro.device.config.api.service.IDriverControllerController;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "${micro.feign.proxy.device-config.name:morelinks-device-config-service}")
public interface DriverControllerFeignClient extends IDriverControllerController {

}