package com.morelinks.service.micro.product.mapper;

import com.morelinks.core.mapper.BaseMapperWithQueryPage;
import com.morelinks.feign.micro.product.api.model.ProductBrand;
import com.morelinks.feign.micro.product.api.model.dto.QueryProduct;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductBrandMapper extends BaseMapperWithQueryPage<ProductBrand,Integer> {
 List<ProductBrand> queryProduct(@Param("condition") QueryProduct product);
}