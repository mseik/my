package com.morelinks.service.micro.order.mapper;

import com.morelinks.core.mapper.BaseMapperWithQueryPage;
import com.morelinks.feign.micro.order.api.model.AgentCart;
import org.apache.ibatis.annotations.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface AgentCartMapper extends BaseMapperWithQueryPage<AgentCart,Integer> {

	Integer getCountByUserId(@Param(value="userId")Integer userId);

	void updateCartSelStatus(@Param(value="userId")Integer userId,
	                         @Param(value="selected")Boolean selected,
	                         @Param(value="updateTime")Date updateTime);
}