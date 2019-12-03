package com.morelinks.service.micro.product.mapper;

import com.morelinks.core.mapper.BaseMapperWithQueryPage;
import com.morelinks.core.model.Page;
import com.morelinks.feign.micro.product.api.model.ProductModel;
import com.morelinks.feign.micro.product.api.model.dto.Query4ProductModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductModelMapper extends BaseMapperWithQueryPage<ProductModel,Integer> {
	List<ProductModel> queryPageResultNew(
			@Param(value="condition") Query4ProductModel query,
			@Param(value="page")Page page);
	Integer queryPageResultCountNew(@Param(value="condition")Query4ProductModel query);
}