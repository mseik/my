package com.morelinks.service.micro.inner.user.service;

import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.micro.inner.user.api.model.ManageSystemInfo;
import com.morelinks.service.micro.inner.user.mapper.ManageSystemInfoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ManageSystemInfoService extends BaseServiceWithQueryPage<ManageSystemInfo,Integer,ManageSystemInfoMapper> {

	public ManageSystemInfo getBySystemName(String systemName) {
		ManageSystemInfo querySystem = new ManageSystemInfo();
		querySystem.setSystemName(systemName);
		return  this.findTop1(querySystem);
	}
}