package com.morelinks.service.micro.inner.user.service;

import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.micro.inner.user.api.model.UserAgentMap;
import com.morelinks.service.micro.inner.user.mapper.UserAgentMapMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserAgentMapService extends BaseServiceWithQueryPage<UserAgentMap,Integer,UserAgentMapMapper> {
}