package com.morelinks.service.micro.inner.user.service;

import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.micro.inner.user.api.model.UserTicket;
import com.morelinks.service.micro.inner.user.mapper.UserTicketMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserTicketService extends BaseServiceWithQueryPage<UserTicket,String,UserTicketMapper> {
}