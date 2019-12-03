package com.morelinks.service.micro.order.service;

import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.micro.order.api.model.ConfigOrderExtraInfo;
import com.morelinks.service.micro.order.mapper.ConfigOrderExtraInfoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ConfigOrderExtraInfoService extends BaseServiceWithQueryPage<ConfigOrderExtraInfo, Integer, ConfigOrderExtraInfoMapper> {
	public Integer deleteByOrderExtraInfo(ConfigOrderExtraInfo extraInfo) {
		Integer num = this.mapper.deleteByOrderExtraInfo(extraInfo);
		return num;
	}

	public ConfigOrderExtraInfo findTop(ConfigOrderExtraInfo extraInfo) {

		return this.findTop1(extraInfo);
	}
}