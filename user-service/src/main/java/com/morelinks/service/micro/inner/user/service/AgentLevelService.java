package com.morelinks.service.micro.inner.user.service;

import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.micro.inner.user.api.model.AgentLevel;
import com.morelinks.service.micro.inner.user.mapper.AgentLevelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class AgentLevelService extends BaseServiceWithQueryPage<AgentLevel,Integer,AgentLevelMapper> {
}