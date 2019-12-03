package com.morelinks.feign.demo.api.service;

import com.morelinks.core.dto.IceAjaxResult;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.feign.demo.api.model.DemoName;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/api/test")
public interface ITestController {
	@RequestMapping(value = "/add", method = {RequestMethod.GET})
	ReturnValue<DemoName> add(@RequestParam(name = "name") String name);
}
