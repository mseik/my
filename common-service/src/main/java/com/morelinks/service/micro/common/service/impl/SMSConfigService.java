package com.morelinks.service.micro.common.service.impl;


import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.micro.common.api.model.SMSConfig;
import com.morelinks.service.micro.common.mapper.SMSConfigMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class SMSConfigService extends BaseServiceWithQueryPage<SMSConfig,Integer, SMSConfigMapper> {
    public SMSConfig getByFromSource(String fromSource)
    {
        return mapper.getByFromSource(fromSource);
    }
}