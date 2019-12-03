package com.morelinks.service.micro.order.mapper;

import com.morelinks.core.mapper.BaseMapperWithQueryPage;
import com.morelinks.feign.micro.order.api.model.ConfigPrintOrderExtraInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigPrintOrderExtraInfoMapper extends BaseMapperWithQueryPage<ConfigPrintOrderExtraInfo,Integer> {
}