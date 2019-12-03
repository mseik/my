package com.morelinks.service.micro.order.service;

import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.micro.order.api.model.AgentDeliveryAddress;
import com.morelinks.service.micro.order.mapper.AgentDeliveryAddressMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class AgentDeliveryAddressService extends BaseServiceWithQueryPage<AgentDeliveryAddress,Integer,AgentDeliveryAddressMapper> {
}