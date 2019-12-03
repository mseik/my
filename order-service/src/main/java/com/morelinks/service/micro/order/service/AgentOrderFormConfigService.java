package com.morelinks.service.micro.order.service;

import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.micro.order.api.model.AgentOrderFormConfig;
import com.morelinks.service.micro.order.mapper.AgentOrderFormConfigMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class AgentOrderFormConfigService extends BaseServiceWithQueryPage<AgentOrderFormConfig,Integer,AgentOrderFormConfigMapper> {
}