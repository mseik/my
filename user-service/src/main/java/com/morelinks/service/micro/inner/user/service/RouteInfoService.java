package com.morelinks.service.micro.inner.user.service;

import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.micro.inner.user.api.model.RouteInfo;
import com.morelinks.service.micro.inner.user.mapper.RouteInfoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class RouteInfoService extends BaseServiceWithQueryPage<RouteInfo,Integer,RouteInfoMapper> {
}