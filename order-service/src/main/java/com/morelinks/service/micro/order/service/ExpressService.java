package com.morelinks.service.micro.order.service;

import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.micro.order.api.model.Express;
import com.morelinks.service.micro.order.mapper.ExpressMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ExpressService extends BaseServiceWithQueryPage<Express,Integer,ExpressMapper> {
}