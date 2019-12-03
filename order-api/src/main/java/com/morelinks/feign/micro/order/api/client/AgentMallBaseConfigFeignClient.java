package com.morelinks.feign.micro.order.api.client;

import com.morelinks.feign.micro.order.api.service.IAgentMallBaseConfigController;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "${micro.feign.proxy.order.name:morelinks-order-service}")
public interface AgentMallBaseConfigFeignClient extends IAgentMallBaseConfigController {

}