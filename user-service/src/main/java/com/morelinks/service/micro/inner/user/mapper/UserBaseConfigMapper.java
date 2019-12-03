package com.morelinks.service.micro.inner.user.mapper;

import com.morelinks.core.mapper.BaseMapperWithQueryPage;
import com.morelinks.feign.micro.inner.user.api.model.UserBaseConfig;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBaseConfigMapper extends BaseMapperWithQueryPage<UserBaseConfig,Integer> {
}