package com.morelinks.service.micro.order.service;

import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.micro.order.api.model.TemplatePdf;
import com.morelinks.service.micro.order.mapper.TemplatePdfMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TemplatePdfService extends BaseServiceWithQueryPage<TemplatePdf,Integer,TemplatePdfMapper> {
}