package com.morelinks.service.micro.product.service;

import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.micro.product.api.model.ProductExtraInfo;
import com.morelinks.service.micro.product.mapper.ProductExtraInfoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ProductExtraInfoService extends BaseServiceWithQueryPage<ProductExtraInfo,Integer,ProductExtraInfoMapper> {
}