package com.morelinks.feign.micro.inner.user.api.service;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.inner.user.api.dto.UserLoginDTO;
import com.morelinks.feign.micro.inner.user.api.dto.UserRegisterForm;
import com.morelinks.feign.micro.inner.user.api.model.UserBaseConfig;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//import org.springframework.cloud.netflix.feign.FeignClient;

@RequestMapping("/userBaseConfig")
public interface IUserBaseConfigController {

	@RequestMapping(value = "/insert", method = {RequestMethod.POST})
	ReturnValue<Integer> insert(@RequestBody UserBaseConfig obj);

	@RequestMapping(value = "/getByPrimaryKey", method = {RequestMethod.GET})
	ReturnValue<UserBaseConfig> getByPrimaryKey(@RequestParam(name = "id") Integer id);

	@RequestMapping(value = "/deleteByPrimaryKey", method = {RequestMethod.GET})
	ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id") Integer id);

	@RequestMapping(value = "/updateByPrimaryKey", method = {RequestMethod.POST})
	ReturnValue<Integer> updateByPrimaryKey(@RequestBody UserBaseConfig obj);

	@RequestMapping(value = "/find", method = {RequestMethod.POST})
	ReturnValue<List<UserBaseConfig>> find(@RequestBody QueryPageParam<UserBaseConfig> query);

	@RequestMapping(value = "/getQueryResult", method = {RequestMethod.POST})
	ReturnValue<QueryResult<UserBaseConfig>> getQueryResult(@RequestBody QueryPageParam<UserBaseConfig> query) ;


	@RequestMapping(value = "/getByConfigType", method = {RequestMethod.GET})
	ReturnValue<List<UserBaseConfig>> getByConfigType(@RequestParam(name = "configType")String configType);

	@RequestMapping(value = "/getByConfigTypeAndConfigKey", method = {RequestMethod.GET})
	ReturnValue<UserBaseConfig> getByConfigTypeAndConfigKey(@RequestParam(name = "configType")String configType,
	                                                             @RequestParam(name = "configKey")String configKey);
}