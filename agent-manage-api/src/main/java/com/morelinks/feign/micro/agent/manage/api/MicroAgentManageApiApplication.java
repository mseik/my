package com.morelinks.feign.micro.agent.manage.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class MicroAgentManageApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroAgentManageApiApplication.class, args);
	}
}
