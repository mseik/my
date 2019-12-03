package com.morelinks.feign.micro.device.config.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class MicroDeviceConfigApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroDeviceConfigApiApplication.class, args);
	}
}
