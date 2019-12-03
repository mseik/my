package com.morelinks.service.micro.inner.user.mapper;

import com.morelinks.core.mapper.BaseMapperWithQueryPage;
import com.morelinks.feign.micro.inner.user.api.model.RouteInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteInfoMapper extends BaseMapperWithQueryPage<RouteInfo,Integer> {
}