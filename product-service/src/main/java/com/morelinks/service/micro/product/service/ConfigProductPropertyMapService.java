package com.morelinks.service.micro.product.service;

import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.micro.product.api.model.ConfigProductPropertyMap;
import com.morelinks.service.micro.product.mapper.ConfigProductPropertyMapMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ConfigProductPropertyMapService extends BaseServiceWithQueryPage<ConfigProductPropertyMap,Integer,ConfigProductPropertyMapMapper> {
public   List<ConfigProductPropertyMap> queryPageResultNew( List<Integer> list){
  return   this.mapper.queryPageResultNew(list);

}
}