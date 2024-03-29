package com.morelinks.service.micro.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@ServletComponentScan
@SpringBootApplication
@MapperScan("com.morelinks.**.mapper") //配置扫描mapper接口的地址
@EnableFeignClients
@EnableDiscoveryClient
public class MicroOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroOrderApplication.class, args);
	}
}
