package com.morelinks.service.micro.order.mapper;

import com.morelinks.core.mapper.BaseMapperWithQueryPage;
import com.morelinks.feign.micro.order.api.model.AgentDeliveryAddress;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentDeliveryAddressMapper extends BaseMapperWithQueryPage<AgentDeliveryAddress,Integer> {
}