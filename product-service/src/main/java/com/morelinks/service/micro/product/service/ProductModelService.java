package com.morelinks.service.micro.product.service;

import com.morelinks.core.model.Page;
import com.morelinks.core.model.QueryResult;
import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.micro.product.api.model.ProductModel;
import com.morelinks.feign.micro.product.api.model.dto.Query4ProductModel;
import com.morelinks.service.micro.product.mapper.ProductModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ProductModelService extends BaseServiceWithQueryPage<ProductModel,Integer,ProductModelMapper> {
	public QueryResult<ProductModel> getQueryResultNew(Query4ProductModel query, Page page) {
		if (query != null && page != null) {
			QueryResult<ProductModel> result = new QueryResult();
			result.setTotalCount(this.mapper.queryPageResultCountNew(query));
			result.setItems(this.mapper.queryPageResultNew(query, page));
			return result;
		} else {
			return null;
		}
	}

}