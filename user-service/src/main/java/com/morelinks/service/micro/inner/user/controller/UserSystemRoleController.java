package com.morelinks.service.micro.inner.user.controller;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.core.util.IntUtil;
import com.morelinks.feign.micro.inner.user.api.model.ManageSystemInfo;
import com.morelinks.feign.micro.inner.user.api.model.UserSystemRole;
import com.morelinks.feign.micro.inner.user.api.service.IUserSystemRoleController;
import com.morelinks.service.micro.inner.user.service.ManageSystemInfoService;
import com.morelinks.service.micro.inner.user.service.UserSystemRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class UserSystemRoleController
		implements IUserSystemRoleController
{
	private Logger logger = LoggerFactory.getLogger(UserSystemRoleController.class);
	@Autowired
	public UserSystemRoleService baseService;

	@Autowired
	ManageSystemInfoService manageSystemInfoService;

	@Override
	public ReturnValue<Integer> insert(@RequestBody UserSystemRole obj)
	{
		baseService.insert(obj);
		return ReturnValue.get200OK(obj.getId());
	}


	@Override
	public ReturnValue<UserSystemRole> getByPrimaryKey(@RequestParam(name = "id") Integer id)
	{
		return ReturnValue.get200OK(baseService.getByPrimaryKey(id));
	}

	@Override
	public ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id")Integer id)
	{
		return ReturnValue.get200OK(baseService.deleteByPrimaryKey(id));
	}

	@Override
	public ReturnValue<Integer> updateByPrimaryKey(@RequestBody UserSystemRole obj)
	{
		return ReturnValue.get200OK(baseService.updateByPrimaryKey(obj));
	}

	@Override
	public ReturnValue<List<UserSystemRole>> find(@RequestBody QueryPageParam<UserSystemRole> query) {
		return ReturnValue.get200OK(baseService.find(query.getQuery(), query.getPage()));
	}
	@Override
	public ReturnValue<QueryResult<UserSystemRole>> getQueryResult(@RequestBody QueryPageParam<UserSystemRole> query) {
		return ReturnValue.get200OK(baseService.getQueryResult(query.getQuery(), query.getPage()));
	}

	@Override
	public ReturnValue<UserSystemRole> getByUserIdAndSystemId(@RequestParam(name = "userId")Integer userId,
	                                                          @RequestParam(name = "systemId")Integer systemId){
		return ReturnValue.get200OK(baseService.getByUserIdAndSystemId(userId, systemId));
	}

	@Override
	public ReturnValue<UserSystemRole> getByUserIdAndSystemName(@RequestParam(name = "userId")Integer userId,
	                                                          @RequestParam(name = "systemName")String systemName){
		ReturnValue ret = new ReturnValue();
		ManageSystemInfo system = manageSystemInfoService.getBySystemName(systemName);
		if(system==null)
		{
			ret.setCode(500);
			ret.setMsg("未知系统");
			return ret;
		}
		return ReturnValue.get200OK(baseService.getByUserIdAndSystemId(userId, system.getId()));
	}

	@Override
	public ReturnValue<UserSystemRole> modifyUserRoles(@RequestParam(name = "userId")Integer userId,
	                                                   @RequestParam(name = "roles")String roles,
	                                                            @RequestParam(name = "systemName")String systemName){
		ReturnValue ret = new ReturnValue();
		ManageSystemInfo system = manageSystemInfoService.getBySystemName(systemName);
		if(system==null)
		{
			ret.setCode(500);
			ret.setMsg("未知系统");
			return ret;
		}
		UserSystemRole role = baseService.getByUserIdAndSystemId(userId,system.getId());
		if(role==null)
		{
			role=new UserSystemRole();
			role.setUserId(userId);
			role.setManageSystemId(system.getId());
			role.setCreateTime(new Date());
		}
		role.setRoles(roles);
		role.setUpdateTime(new Date());
		if(IntUtil.isGreaterThanZero(role.getId()))
		{
			baseService.updateByPrimaryKey(role);
		}
		else{
			baseService.insert(role);
		}
		return ReturnValue.get200OK(role);
	}
}
