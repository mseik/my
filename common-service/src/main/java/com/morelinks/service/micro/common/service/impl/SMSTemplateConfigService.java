package com.morelinks.service.micro.common.service.impl;


import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.micro.common.api.model.SMSTemplateConfig;
import com.morelinks.service.micro.common.mapper.SMSTemplateConfigMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class SMSTemplateConfigService extends BaseServiceWithQueryPage<SMSTemplateConfig,Integer, SMSTemplateConfigMapper> {
}