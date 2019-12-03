package com.morelinks.service.micro.order.service;

import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.micro.order.api.model.AgentMallBaseConfig;
import com.morelinks.service.micro.order.mapper.AgentMallBaseConfigMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class AgentMallBaseConfigService extends BaseServiceWithQueryPage<AgentMallBaseConfig,Integer,AgentMallBaseConfigMapper> {
}