package com.morelinks.feign.micro.inner.user.api.service;

import com.morelinks.core.dto.ReturnValue;
import com.morelinks.feign.micro.inner.user.api.dto.MenuInfoDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//import org.springframework.cloud.netflix.feign.FeignClient;

@RequestMapping("/menu")
public interface IMenuController {
	/**
	 * 获取菜单树
	 * @param userId
	 * @param systemType 1：内部系统 2：代理商系统
	 * @return
	 */
	@RequestMapping(value = "/getMenuTree", method = {RequestMethod.GET})
	ReturnValue<List<MenuInfoDTO>> getMenuTree(@RequestParam(name = "userId") Integer userId,
	                                           @RequestParam(name = "systemType") Integer systemType);

}