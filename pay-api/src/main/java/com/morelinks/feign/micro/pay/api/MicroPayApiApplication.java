package com.morelinks.feign.micro.pay.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableAutoConfiguration
@ComponentScan
public class MicroPayApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroPayApiApplication.class, args);
	}
}
