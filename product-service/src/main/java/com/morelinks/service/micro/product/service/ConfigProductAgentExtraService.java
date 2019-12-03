package com.morelinks.service.micro.product.service;

import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.micro.product.api.model.ConfigProductAgentExtra;
import com.morelinks.service.micro.product.mapper.ConfigProductAgentExtraMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ConfigProductAgentExtraService extends BaseServiceWithQueryPage<ConfigProductAgentExtra,Integer,ConfigProductAgentExtraMapper> {
}