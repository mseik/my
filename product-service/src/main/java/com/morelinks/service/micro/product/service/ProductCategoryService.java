package com.morelinks.service.micro.product.service;

import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.micro.product.api.model.ProductCategory;
import com.morelinks.service.micro.product.mapper.ProductCategoryMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ProductCategoryService extends BaseServiceWithQueryPage<ProductCategory,Integer,ProductCategoryMapper> {
}