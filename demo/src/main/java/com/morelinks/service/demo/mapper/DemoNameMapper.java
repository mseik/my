package com.morelinks.service.demo.mapper;

import com.morelinks.core.mapper.BaseMapperWithQueryPage;
import com.morelinks.feign.demo.api.model.DemoName;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoNameMapper extends BaseMapperWithQueryPage<DemoName,Integer> {
}