package com.morelinks.service.micro.inner.user.service;

import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.micro.inner.user.api.model.MenuInfo;
import com.morelinks.service.micro.inner.user.mapper.MenuInfoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class MenuInfoService extends BaseServiceWithQueryPage<MenuInfo,Integer,MenuInfoMapper> {
}