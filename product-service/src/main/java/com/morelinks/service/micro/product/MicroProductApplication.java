package com.morelinks.service.micro.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@ServletComponentScan
@SpringBootApplication
@MapperScan("com.morelinks.**.mapper") //配置扫描mapper接口的地址
@EnableDiscoveryClient
public class MicroProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroProductApplication.class, args);
	}
}
