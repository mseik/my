package com.morelinks.service.micro.order.service;

import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.micro.order.api.model.AgentOrderDetail;
import com.morelinks.service.micro.order.mapper.AgentOrderDetailMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class AgentOrderDetailService extends BaseServiceWithQueryPage<AgentOrderDetail,Integer,AgentOrderDetailMapper> {


}