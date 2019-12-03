package com.morelinks.service.demo.controller;

import com.morelinks.core.dto.IceAjaxResult;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.feign.demo.api.model.DemoName;
import com.morelinks.feign.demo.api.service.ITestController;
import com.morelinks.service.demo.service.DemoNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class TestController implements ITestController {

	@Autowired
	DemoNameService demoNameService;


	@Override
	public ReturnValue<DemoName> add(@RequestParam(name = "name") String name
	) {
		DemoName obj = new DemoName();
		obj.setName(name);
		obj.setCreateTime(new Date());
		obj.setUpdateTime(new Date());
		demoNameService.insert(obj);
		return ReturnValue.get200OK(obj);
	}


}
