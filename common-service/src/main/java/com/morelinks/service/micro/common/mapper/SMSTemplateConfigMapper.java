package com.morelinks.service.micro.common.mapper;

import com.morelinks.core.mapper.BaseMapperWithQueryPage;
import com.morelinks.feign.micro.common.api.model.SMSConfig;
import com.morelinks.feign.micro.common.api.model.SMSTemplateConfig;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SMSTemplateConfigMapper extends BaseMapperWithQueryPage<SMSTemplateConfig,Integer> {
}