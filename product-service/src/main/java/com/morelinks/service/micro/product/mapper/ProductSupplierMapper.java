package com.morelinks.service.micro.product.mapper;

import com.morelinks.core.mapper.BaseMapperWithQueryPage;
import com.morelinks.feign.micro.product.api.model.ProductSupplier;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSupplierMapper extends BaseMapperWithQueryPage<ProductSupplier,Integer> {
}