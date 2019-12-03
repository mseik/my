package com.morelinks.service.micro.inner.user.service;

import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.micro.inner.user.api.model.UserWeiXinMap;
import com.morelinks.service.micro.inner.user.mapper.UserWeiXinMapMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserWeiXinMapService extends BaseServiceWithQueryPage<UserWeiXinMap,Integer,UserWeiXinMapMapper> {
}