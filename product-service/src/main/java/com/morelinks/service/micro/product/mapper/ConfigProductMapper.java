package com.morelinks.service.micro.product.mapper;

import com.morelinks.core.mapper.BaseMapperWithQueryPage;
import com.morelinks.core.model.Page;
import com.morelinks.feign.micro.product.api.model.ConfigProduct;
import com.morelinks.feign.micro.product.api.model.dto.Query4ConfigProductDTO;
import com.morelinks.feign.micro.product.api.model.dto.QueryAgentProduct;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConfigProductMapper extends BaseMapperWithQueryPage<ConfigProduct, Integer> {
//	List<ConfigProduct> QuerySortProduct(@Param("condition") QueryAgentProduct query);

	List<ConfigProduct> queryConfigProductPageResult(
			@Param(value="condition") Query4ConfigProductDTO query,
			@Param(value="page")Page page);
	Integer queryConfigProductPageResultCount(@Param(value="condition")Query4ConfigProductDTO query);

}