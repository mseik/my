package com.morelinks.feign.micro.device.api.service;


import com.morelinks.core.dto.ReturnValue;
import com.morelinks.feign.micro.device.api.model.OpenCloudAppInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//import org.springframework.cloud.netflix.feign.FeignClient;

@RequestMapping("/openCloudAppInfo")
public interface IOpenCloudAppInfoController {

	@RequestMapping(value = "/getByAppId", method = {RequestMethod.GET})
	ReturnValue<OpenCloudAppInfo> getByAppId(@RequestParam(name = "id") String appId);
}