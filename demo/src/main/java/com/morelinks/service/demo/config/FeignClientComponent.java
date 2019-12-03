package com.morelinks.service.demo.config;

import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(
		basePackages = {
				"com.morelinks.feign.micro.**.api.client"
		},//,"com.morelinks.feign"
		excludeFilters = {@ComponentScan.Filter(
				type = FilterType.CUSTOM,
				classes = {TypeExcludeFilter.class}
		), @ComponentScan.Filter(
				type = FilterType.CUSTOM,
				classes = {AutoConfigurationExcludeFilter.class}
		)}
)
@EnableFeignClients(basePackages={
		"com.morelinks.feign.micro.**.api.client"})//"com.morelinks.feign",
public class FeignClientComponent {
}
