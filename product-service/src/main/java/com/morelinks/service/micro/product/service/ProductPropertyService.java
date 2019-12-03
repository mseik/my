package com.morelinks.service.micro.product.service;

import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.micro.product.api.model.ProductProperty;
import com.morelinks.service.micro.product.mapper.ProductPropertyMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ProductPropertyService extends BaseServiceWithQueryPage<ProductProperty,Integer,ProductPropertyMapper> {
}