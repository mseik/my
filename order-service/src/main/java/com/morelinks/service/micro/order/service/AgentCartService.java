package com.morelinks.service.micro.order.service;

import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.core.util.IntUtil;
import com.morelinks.feign.micro.order.api.model.AgentCart;
import com.morelinks.service.micro.order.mapper.AgentCartMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Transactional
@Service
public class AgentCartService extends BaseServiceWithQueryPage<AgentCart,Integer,AgentCartMapper> {

	public Integer getCountByUserId(Integer userId)
	{
		if(!IntUtil.isGreaterThanZero(userId))
		{
			return 0;
		}
		return mapper.getCountByUserId(userId);
	}

	public void updateCartSelStatus(Integer userId,Boolean seleced){
		if(!IntUtil.isGreaterThanZero(userId))
		{
			return;
		}
		if(seleced==null)
		{
			seleced=false;
		}
		mapper.updateCartSelStatus(userId,seleced,new Date());
	}
}