package com.morelinks.service.demo;

import com.morelinks.core.dto.IceAjaxResult;
import com.morelinks.feign.demo.api.model.DemoName;
import com.morelinks.service.demo.controller.TestController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	TestController testController;

	@Test
	public void contextLoads() {
	}

	@Test
	public void add(
	) {
		testController.add("i123");
	}
}
