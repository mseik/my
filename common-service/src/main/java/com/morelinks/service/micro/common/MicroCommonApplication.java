package com.morelinks.service.micro.common;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@ServletComponentScan
@SpringBootApplication
@MapperScan("com.morelinks.**.mapper") //配置扫描mapper接口的地址
public class MicroCommonApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroCommonApplication.class, args);
	}
}
