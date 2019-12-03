package com.morelinks.service.micro.order.mapper;

import com.morelinks.core.mapper.BaseMapperWithQueryPage;
import com.morelinks.feign.micro.order.api.model.TemplatePdf;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplatePdfMapper extends BaseMapperWithQueryPage<TemplatePdf,Integer> {
}