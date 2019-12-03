package com.morelinks.feign.micro.device.api.service;


import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.device.api.dto.DeviceAccessForm;
import com.morelinks.feign.micro.device.api.model.DeviceInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//import org.springframework.cloud.netflix.feign.FeignClient;

@RequestMapping("/deviceInfo")
public interface IDeviceInfoController {

	@RequestMapping(value = "/deviceAccess", method = {RequestMethod.POST})
	ReturnValue<DeviceInfo> deviceAccess(@RequestBody DeviceAccessForm form);
}