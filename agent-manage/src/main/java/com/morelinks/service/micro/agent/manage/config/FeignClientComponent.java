package com.morelinks.service.micro.agent.manage.config;

import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

/**
 * Feign客户端注解
 */
@Component
@ComponentScan(
		basePackages = {"com.morelinks.feign.**.api.client",},
		excludeFilters = {@ComponentScan.Filter(
				type = FilterType.CUSTOM,
				classes = {TypeExcludeFilter.class}
		), @ComponentScan.Filter(
				type = FilterType.CUSTOM,
				classes = {AutoConfigurationExcludeFilter.class}
		)}
)
@EnableFeignClients(basePackages={"com.morelinks.**.api.client",})
public class FeignClientComponent {
}
