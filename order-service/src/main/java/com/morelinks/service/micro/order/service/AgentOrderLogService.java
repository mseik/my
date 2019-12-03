package com.morelinks.service.micro.order.service;

import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.micro.order.api.model.AgentOrderLog;
import com.morelinks.service.micro.order.mapper.AgentOrderLogMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class AgentOrderLogService extends BaseServiceWithQueryPage<AgentOrderLog,Integer,AgentOrderLogMapper> {
}