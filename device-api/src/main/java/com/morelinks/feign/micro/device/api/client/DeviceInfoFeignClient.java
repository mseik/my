package com.morelinks.feign.micro.device.api.client;

import com.morelinks.feign.micro.device.api.service.IDeviceInfoController;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "${micro.feign.proxy.device.name:morelinks-device-service}")
public interface DeviceInfoFeignClient extends IDeviceInfoController {

}