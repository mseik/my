package com.morelinks.service.micro.order.mapper;

import com.morelinks.core.mapper.BaseMapperWithQueryPage;
import com.morelinks.feign.micro.order.api.model.AgentOrderDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentOrderDetailMapper extends BaseMapperWithQueryPage<AgentOrderDetail,Integer> {
}