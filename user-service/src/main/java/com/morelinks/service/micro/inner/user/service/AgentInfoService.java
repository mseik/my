package com.morelinks.service.micro.inner.user.service;

import com.morelinks.core.exception.BusinessException;
import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.core.util.IntUtil;
import com.morelinks.feign.micro.inner.user.api.dto.UserRegisterForm4Agent;
import com.morelinks.feign.micro.inner.user.api.model.AgentInfo;
import com.morelinks.feign.micro.inner.user.api.model.UserAgentMap;
import com.morelinks.feign.micro.inner.user.api.model.UserInfo;
import com.morelinks.service.micro.inner.user.mapper.AgentInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import rx.internal.operators.BackpressureUtils;

import java.util.Date;

@Transactional
@Service
public class AgentInfoService extends BaseServiceWithQueryPage<AgentInfo,Integer,AgentInfoMapper> {

	@Autowired
	UserInfoService userInfoService;
	@Autowired
	UserAgentMapService mapService;
	public UserInfo registerUser4Agent(UserRegisterForm4Agent form)
	{
		if(!IntUtil.isGreaterThanZero(form.getAgentId()))
		{
			throw new BusinessException("代理商不存在");
		}
		AgentInfo agent = mapper.selectByPrimaryKey(form.getAgentId());
		if(agent==null || agent.getAgentStatus()!=1)
		{
			throw new BusinessException("代理商不存在");
		}
		UserInfo user = userInfoService.registerUser(form);
		UserAgentMap map = new UserAgentMap();
		map.setAgentId(agent.getId());
		map.setUserId(user.getId());
		map.setCreateTime(new Date());
		map.setUpdateTime(new Date());
		mapService.insert(map);
		return user;
	}
}