package com.morelinks.feign.micro.inner.user.api.client;

import com.morelinks.feign.micro.inner.user.api.service.IAgentLevelController;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "${micro.feign.proxy.inner-user.name:morelinks-inner-user-service}")
public interface AgentLevelFeignClient extends IAgentLevelController {

}