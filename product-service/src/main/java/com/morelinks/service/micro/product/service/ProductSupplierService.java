package com.morelinks.service.micro.product.service;

import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.micro.product.api.model.ProductSupplier;
import com.morelinks.service.micro.product.mapper.ProductSupplierMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ProductSupplierService extends BaseServiceWithQueryPage<ProductSupplier,Integer,ProductSupplierMapper> {
}