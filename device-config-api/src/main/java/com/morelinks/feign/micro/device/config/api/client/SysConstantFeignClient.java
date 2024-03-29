package com.morelinks.feign.micro.device.config.api.client;

import com.morelinks.feign.micro.device.config.api.service.IDeviceTypeController;
import com.morelinks.feign.micro.device.config.api.service.ISysConstantController;
import org.springframework.cloud.netflix.feign.FeignClient;

import java.io.InputStream;

@FeignClient(value = "${micro.feign.proxy.device-config.name:morelinks-device-config-service}")
public interface SysConstantFeignClient extends ISysConstantController {

}