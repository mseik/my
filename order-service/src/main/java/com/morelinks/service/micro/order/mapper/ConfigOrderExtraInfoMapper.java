package com.morelinks.service.micro.order.mapper;

import com.morelinks.core.mapper.BaseMapperWithQueryPage;
import com.morelinks.feign.micro.order.api.model.ConfigOrderExtraInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigOrderExtraInfoMapper extends BaseMapperWithQueryPage<ConfigOrderExtraInfo,Integer> {
 int   deleteByOrderExtraInfo(@Param("condition") ConfigOrderExtraInfo  extraInfo);

}