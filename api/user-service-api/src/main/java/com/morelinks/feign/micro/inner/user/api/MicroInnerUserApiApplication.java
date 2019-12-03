package com.morelinks.feign.micro.inner.user.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableAutoConfiguration
@ComponentScan
public class MicroInnerUserApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroInnerUserApiApplication.class, args);
	}
}
