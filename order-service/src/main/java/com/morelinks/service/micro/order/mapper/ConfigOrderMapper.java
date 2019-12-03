package com.morelinks.service.micro.order.mapper;

import com.morelinks.core.mapper.BaseMapperWithQueryPage;
import com.morelinks.core.model.Page;
import com.morelinks.feign.micro.order.api.model.ConfigOrder;
import com.morelinks.feign.micro.order.api.model.dto.Query4ConfigOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConfigOrderMapper extends BaseMapperWithQueryPage<ConfigOrder,String> {

List<ConfigOrder> queryPageResultNew(
 @Param("condition")   Query4ConfigOrder query);

Integer  queryPageResultCountNew(
    @Param("condition")   Query4ConfigOrder query
);

}