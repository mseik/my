package com.morelinks.service.micro.order.service;

import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.micro.order.api.model.ConfigPrintOrderDetail;
import com.morelinks.service.micro.order.mapper.ConfigPrintOrderDetailMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ConfigPrintOrderDetailService extends BaseServiceWithQueryPage<ConfigPrintOrderDetail,Integer,ConfigPrintOrderDetailMapper> {
}