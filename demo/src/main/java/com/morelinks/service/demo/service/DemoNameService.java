package com.morelinks.service.demo.service;

import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.demo.api.model.DemoName;
import com.morelinks.service.demo.mapper.DemoNameMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class DemoNameService extends BaseServiceWithQueryPage<DemoName,Integer,DemoNameMapper> {
}