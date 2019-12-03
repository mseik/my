package com.morelinks.feign.micro.order.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class MicroOrderApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroOrderApiApplication.class, args);
	}
}
