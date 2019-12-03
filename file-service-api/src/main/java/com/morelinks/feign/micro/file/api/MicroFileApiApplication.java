package com.morelinks.feign.micro.file.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class MicroFileApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroFileApiApplication.class, args);
	}
}
