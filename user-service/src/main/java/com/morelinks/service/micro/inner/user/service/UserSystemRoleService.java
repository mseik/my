package com.morelinks.service.micro.inner.user.service;

import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.micro.inner.user.api.model.UserSystemRole;
import com.morelinks.service.micro.inner.user.mapper.UserSystemRoleMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserSystemRoleService extends BaseServiceWithQueryPage<UserSystemRole,Integer,UserSystemRoleMapper> {

	public UserSystemRole getByUserIdAndSystemId(Integer userId,Integer systemId)
	{
		UserSystemRole queryRole = new UserSystemRole();
		queryRole.setUserId(userId);
		queryRole.setManageSystemId(systemId);
		return this.findTop1(queryRole);
	}
}