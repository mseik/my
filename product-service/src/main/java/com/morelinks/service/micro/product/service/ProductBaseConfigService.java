package com.morelinks.service.micro.product.service;

import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.micro.product.api.model.ProductBaseConfig;
import com.morelinks.service.micro.product.mapper.ProductBaseConfigMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ProductBaseConfigService extends BaseServiceWithQueryPage<ProductBaseConfig,Integer,ProductBaseConfigMapper> {
}