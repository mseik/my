package com.morelinks.service.micro.order.mapper;

import com.morelinks.core.mapper.BaseMapperWithQueryPage;
import com.morelinks.feign.micro.order.api.model.AgentMallBaseConfig;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentMallBaseConfigMapper extends BaseMapperWithQueryPage<AgentMallBaseConfig,Integer> {
}