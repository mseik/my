package com.morelinks.service.micro.agent.manage.config;

import com.morelinks.common.core.jpush.JPushUtil;
import com.morelinks.core.webutil.ResourceUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 资源配置
 */
@Component
public class CommonConfiguration {
	//    @ConfigurationProperties(prefix = "mqtt")
	@Bean
	public ResourceUtil resourceUtil() {
		ResourceUtil resourceUtil = new ResourceUtil();
		return resourceUtil;
	}
}
