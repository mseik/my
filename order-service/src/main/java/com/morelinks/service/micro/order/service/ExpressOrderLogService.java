package com.morelinks.service.micro.order.service;

import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.micro.order.api.model.ExpressOrderLog;
import com.morelinks.service.micro.order.mapper.ExpressOrderLogMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ExpressOrderLogService extends BaseServiceWithQueryPage<ExpressOrderLog,Integer,ExpressOrderLogMapper> {
}