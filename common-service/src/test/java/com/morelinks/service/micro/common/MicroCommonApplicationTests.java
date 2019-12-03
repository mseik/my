package com.morelinks.service.micro.common;

import com.morelinks.feign.micro.common.api.dto.WeatherSunRealTimeInfo;
import com.morelinks.service.micro.common.service.WeatherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes =  MicroCommonApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MicroCommonApplicationTests {


	@Autowired
	@Qualifier("xiaoMiWeatherServiceImpl")
	public WeatherService xmWeatherService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void test1() throws Exception {
		WeatherSunRealTimeInfo dto = xmWeatherService.getCurrentWeather("101190101");
	}

}
