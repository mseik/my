package com.morelinks.service.micro.product.service;

import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.micro.product.api.model.ProductStockInfo;
import com.morelinks.service.micro.product.mapper.ProductStockInfoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ProductStockInfoService extends BaseServiceWithQueryPage<ProductStockInfo,Integer,ProductStockInfoMapper> {
}