package com.morelinks.service.micro.order.service;

import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.micro.order.api.model.ConfigPrintOrderExtraInfo;
import com.morelinks.service.micro.order.mapper.ConfigPrintOrderExtraInfoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ConfigPrintOrderExtraInfoService extends BaseServiceWithQueryPage<ConfigPrintOrderExtraInfo,Integer,ConfigPrintOrderExtraInfoMapper> {
}