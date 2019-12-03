package com.morelinks.service.micro.agent.manage.service;

import com.morelinks.feign.micro.inner.user.api.client.AgentInfoFeignClient;
import com.morelinks.feign.micro.inner.user.api.model.AgentInfo;
import com.morelinks.feign.micro.order.api.client.AgentMallBaseConfigFeignClient;
import com.morelinks.feign.micro.product.api.client.DiscountInfoFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

	@Autowired
	AgentInfoFeignClient agentInfoFeignClient;
	@Autowired
	DiscountInfoFeignClient discountInfoFeignClient;
	@Autowired
	AgentMallBaseConfigFeignClient agentMallBaseConfigFeignClient;



	public int getUserLevel(AgentInfo agentUserInfo)
	{
		int userLevel=-1;
		if (agentUserInfo != null && agentUserInfo.getAgentLevel() != null && agentUserInfo.getLevelStatus() != null
				&& agentUserInfo.getLevelStatus() == 1
				&& (agentUserInfo.getLevelStartTime() == null || agentUserInfo.getLevelStartTime().before(new Date()))
				&& (agentUserInfo.getLevelEndTime() == null || agentUserInfo.getLevelEndTime().after(new Date()))
				) {
			userLevel = agentUserInfo.getAgentLevel();
		}
		return userLevel;
	}




}
