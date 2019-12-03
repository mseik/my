package com.morelinks.service.micro.product.mapper;

import com.morelinks.core.mapper.BaseMapperWithQueryPage;
import com.morelinks.feign.micro.product.api.model.ConfigProductPropertyMap;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConfigProductPropertyMapMapper extends BaseMapperWithQueryPage<ConfigProductPropertyMap,Integer> {
 List<ConfigProductPropertyMap> queryPageResultNew(@Param("condition") List<Integer> list);

}