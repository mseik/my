package com.morelinks.service.micro.inner.user.service;

import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.micro.inner.user.api.model.MenuConfig;
import com.morelinks.service.micro.inner.user.mapper.MenuConfigMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class MenuConfigService extends BaseServiceWithQueryPage<MenuConfig,Integer,MenuConfigMapper> {
}