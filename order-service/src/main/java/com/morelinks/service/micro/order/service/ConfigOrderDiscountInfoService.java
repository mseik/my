package com.morelinks.service.micro.order.service;

import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.micro.order.api.model.ConfigOrderDiscountInfo;
import com.morelinks.service.micro.order.mapper.ConfigOrderDiscountInfoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Transactional
@Service
public class ConfigOrderDiscountInfoService extends BaseServiceWithQueryPage<ConfigOrderDiscountInfo, Integer, ConfigOrderDiscountInfoMapper> {
	public Integer deleteByPrimaryKeySelective(ConfigOrderDiscountInfo discountInfo) {

		return this.mapper.deleteByPrimaryKeySelective(discountInfo);
	}
}