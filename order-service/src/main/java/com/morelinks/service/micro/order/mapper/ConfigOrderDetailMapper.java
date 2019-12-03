package com.morelinks.service.micro.order.mapper;

import com.morelinks.core.mapper.BaseMapperWithQueryPage;
import com.morelinks.feign.micro.order.api.dto.QuerySelectedProducts;
import com.morelinks.feign.micro.order.api.dto.SelectedProducts;
import com.morelinks.feign.micro.order.api.model.ConfigOrderDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConfigOrderDetailMapper extends BaseMapperWithQueryPage<ConfigOrderDetail,String> {
    int deleteSelectedProducts(@Param("condition") SelectedProducts selectedProducts);
   List<ConfigOrderDetail>    querySelectedProducts(@Param("condition") QuerySelectedProducts products);
}