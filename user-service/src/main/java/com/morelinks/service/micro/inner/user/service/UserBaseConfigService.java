package com.morelinks.service.micro.inner.user.service;

import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.micro.inner.user.api.model.UserBaseConfig;
import com.morelinks.service.micro.inner.user.mapper.UserBaseConfigMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserBaseConfigService extends BaseServiceWithQueryPage<UserBaseConfig,Integer,UserBaseConfigMapper> {
}