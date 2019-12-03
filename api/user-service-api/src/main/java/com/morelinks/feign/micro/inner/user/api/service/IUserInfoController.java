package com.morelinks.feign.micro.inner.user.api.service;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.inner.user.api.dto.UserLoginDTO;
import com.morelinks.feign.micro.inner.user.api.dto.UserRegisterForm;
import com.morelinks.feign.micro.inner.user.api.model.UserInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//import org.springframework.cloud.netflix.feign.FeignClient;

	@RequestMapping("/userinfo")
	public interface IUserInfoController {

		@RequestMapping(value = "/insert", method = {RequestMethod.POST})
		ReturnValue<Integer> insert(@RequestBody UserInfo obj);

		@RequestMapping(value = "/getByPrimaryKey", method = {RequestMethod.GET})
		ReturnValue<UserInfo> getByPrimaryKey(@RequestParam(name = "id") Integer id);

		@RequestMapping(value = "/deleteByPrimaryKey", method = {RequestMethod.GET})
		ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id") Integer id);

		@RequestMapping(value = "/updateByPrimaryKey", method = {RequestMethod.POST})
		ReturnValue<Integer> updateByPrimaryKey(@RequestBody UserInfo obj);

		@RequestMapping(value = "/find", method = {RequestMethod.POST})
		ReturnValue<List<UserInfo>> find(@RequestBody QueryPageParam<UserInfo> query);

		@RequestMapping(value = "/getQueryResult", method = {RequestMethod.POST})
		ReturnValue<QueryResult<UserInfo>> getQueryResult(@RequestBody QueryPageParam<UserInfo> query) ;

		@RequestMapping(value = "/loginByPassword", method = {RequestMethod.POST})
		ReturnValue<UserLoginDTO> loginByPassword(@RequestParam(name = "userName")String userName,
		                                          @RequestParam(name = "password")String password,
		                                          @RequestParam(name = "systemName")String systemName,
		                                          @RequestParam(name = "ticketValidTime",required = false)Integer ticketValidTime);

		@RequestMapping(value = "/logoutByTicket", method = {RequestMethod.POST})
		ReturnValue logoutByTicket(@RequestParam(name = "ticket")String ticket) ;

			@RequestMapping(value = "/getUserLoginDTOByToken", method = {RequestMethod.GET})
		ReturnValue<UserLoginDTO> getUserLoginDTOByToken(@RequestParam(name = "token")String token);

		@RequestMapping(value = "/checkUserTokenValid", method = {RequestMethod.GET})
		ReturnValue<Boolean> checkUserTokenValid(@RequestParam(name = "token")String token);

		@RequestMapping(value = "/getUserInfoByToken", method = {RequestMethod.GET})
		ReturnValue<UserInfo> getUserInfoByToken(@RequestParam(name = "token")String token);

		@RequestMapping(value = "/loginByWeiXinMap", method = {RequestMethod.POST})
		ReturnValue<UserLoginDTO> loginByWeiXinMap(@RequestParam(name = "appId")String appId,
		                                           @RequestParam(name = "openId")String openId,
		                                           @RequestParam(name = "systemName")String systemName,
		                                           @RequestParam(name = "ticketValidTime",required = false)Integer ticketValidTime);

		@RequestMapping(value = "/modifyByPassword", method = {RequestMethod.POST})
		ReturnValue modifyByPassword(@RequestParam(name = "userId")Integer userId,
		                             @RequestParam(name = "oldPassword")String oldPassword,
		                             @RequestParam(name = "newPassword")String newPassword);

		@RequestMapping(value = "/registerUser", method = {RequestMethod.POST})
		ReturnValue<UserInfo> registerUser(@RequestBody UserRegisterForm form);

		@RequestMapping(value = "/resetPassword", method = {RequestMethod.POST})
		ReturnValue resetPassword(@RequestParam(name = "userId")Integer userId,
		                          @RequestParam(name = "operator",required = false)String operator,
		                          @RequestParam(name = "remark",required = false)String remark);
	}