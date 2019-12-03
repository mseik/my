package com.morelinks.feign.micro.device.api.service;


import com.morelinks.core.dto.ReturnValue;
import com.morelinks.feign.micro.device.api.model.AppDeviceType;
import com.morelinks.feign.micro.device.api.model.OpenCloudAppInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//import org.springframework.cloud.netflix.feign.FeignClient;

@RequestMapping("/appDeviceType")
public interface IAppDeviceTypeController {

	@RequestMapping(value = "/getByTypeId", method = {RequestMethod.GET})
	ReturnValue<AppDeviceType> getByTypeId(@RequestParam(name = "id") String typeId);
}