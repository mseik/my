package com.morelinks.service.micro.inner.user.service;

import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.micro.inner.user.api.model.AgentInvoiceInfo;
import com.morelinks.service.micro.inner.user.mapper.AgentInvoiceInfoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class AgentInvoiceInfoService extends BaseServiceWithQueryPage<AgentInvoiceInfo,Integer,AgentInvoiceInfoMapper> {
}