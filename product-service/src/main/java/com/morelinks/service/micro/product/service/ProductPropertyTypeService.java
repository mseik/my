package com.morelinks.service.micro.product.service;

import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.micro.product.api.model.ProductPropertyType;
import com.morelinks.service.micro.product.mapper.ProductPropertyTypeMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ProductPropertyTypeService extends BaseServiceWithQueryPage<ProductPropertyType,Integer,ProductPropertyTypeMapper> {
}