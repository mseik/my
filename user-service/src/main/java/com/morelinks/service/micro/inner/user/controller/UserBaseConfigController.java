package com.morelinks.service.micro.inner.user.controller;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.exception.BusinessException;
import com.morelinks.core.model.QueryResult;
import com.morelinks.core.util.DateUtil;
import com.morelinks.core.util.IntUtil;
import com.morelinks.core.util.StringUtil;
import com.morelinks.feign.micro.inner.user.api.dto.UserLoginDTO;
import com.morelinks.feign.micro.inner.user.api.dto.UserRegisterForm;
import com.morelinks.feign.micro.inner.user.api.model.*;
import com.morelinks.feign.micro.inner.user.api.service.IUserBaseConfigController;
import com.morelinks.service.micro.inner.user.service.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
	public class UserBaseConfigController
			implements IUserBaseConfigController
	{
		private Logger logger = LoggerFactory.getLogger(UserBaseConfigController.class);
		@Autowired
		public UserBaseConfigService baseService;

		@Autowired
		UserSystemRoleService systemRoleService;

		@Autowired
		ManageSystemInfoService manageSystemInfoService;

		@Autowired
		UserTicketService ticketService;
		@Autowired
		UserWeiXinMapService weiXinMapService;

		@Override
		public ReturnValue<Integer> insert(@RequestBody UserBaseConfig obj)
		{
			baseService.insert(obj);
			return ReturnValue.get200OK(obj.getId());
		}

		@Override
		public ReturnValue<UserBaseConfig> getByPrimaryKey(@RequestParam(name = "id") Integer id)
		{
			return ReturnValue.get200OK(baseService.getByPrimaryKey(id));
		}

		@Override
		public ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id")Integer id)
		{
			return ReturnValue.get200OK(baseService.deleteByPrimaryKey(id));
		}

		@Override
		public ReturnValue<Integer> updateByPrimaryKey(@RequestBody UserBaseConfig obj)
		{
			return ReturnValue.get200OK(baseService.updateByPrimaryKey(obj));
		}

		@Override
		public ReturnValue<List<UserBaseConfig>> find(@RequestBody QueryPageParam<UserBaseConfig> query) {
			return ReturnValue.get200OK(baseService.find(query.getQuery(), query.getPage()));
		}


		@Override
		public ReturnValue<QueryResult<UserBaseConfig>> getQueryResult(@RequestBody QueryPageParam<UserBaseConfig> query) {
			return ReturnValue.get200OK(baseService.getQueryResult(query.getQuery(), query.getPage()));
		}
		@Override
		public ReturnValue<List<UserBaseConfig>> getByConfigType(@RequestParam(name = "configType")String configType) {
			ReturnValue<List<UserBaseConfig>> ret = new ReturnValue<>();
			UserBaseConfig query = new UserBaseConfig();
			query.setConfigType(configType);
			ret.setObj(baseService.find(query,null));
			return ret;
		}

		@Override
		public ReturnValue<UserBaseConfig> getByConfigTypeAndConfigKey(@RequestParam(name = "configType")String configType,
		                                                                    @RequestParam(name = "configKey")String configKey) {
			UserBaseConfig query = new UserBaseConfig();
			query.setConfigType(configType);
			query.setConfigKey(configKey);
			return ReturnValue.get200OK(baseService.findTop1(query));
		}

	}
