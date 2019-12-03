package com.morelinks.feign.micro.common.api.client;

import com.morelinks.feign.micro.common.api.service.ICommonController;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "${micro.feign.proxy.common.name:morelinks-common-service}")
public interface CommonFeignClient extends ICommonController {

}