package com.morelinks.service.micro.order.service;

import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.micro.order.api.model.AgentOrderInvoiceInfo;
import com.morelinks.service.micro.order.mapper.AgentOrderInvoiceInfoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class AgentOrderInvoiceInfoService extends BaseServiceWithQueryPage<AgentOrderInvoiceInfo,String,AgentOrderInvoiceInfoMapper> {
}