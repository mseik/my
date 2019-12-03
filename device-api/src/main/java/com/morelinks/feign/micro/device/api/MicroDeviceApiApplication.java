package com.morelinks.feign.micro.device.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class MicroDeviceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroDeviceApiApplication.class, args);
	}

}

