package com.morelinks.service.micro.common.mapper;

import com.morelinks.core.mapper.BaseMapperWithQueryPage;
import com.morelinks.feign.micro.common.api.model.SMSConfig;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SMSConfigMapper extends BaseMapperWithQueryPage<SMSConfig,Integer> {
    SMSConfig getByFromSource(@Param(value = "fromSource") String fromSource);
}