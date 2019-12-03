package com.morelinks.service.micro.common.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 小米的日出日落信息
 */
public class XiaoMiSunInfo {
	/**
	 * 日出信息 精确到秒
	 */
	@JSONField(name ="Sun_EpochRise")
	private String Sun_EpochRise;
	/**
	 * 日落信息 精确到秒
	 */
	@JSONField(name ="Sun_EpochSet")
	private String Sun_EpochSet;

	public String getSun_EpochRise() {
		return Sun_EpochRise;
	}

	public void setSun_EpochRise(String sun_EpochRise) {
		Sun_EpochRise = sun_EpochRise;
	}

	public String getSun_EpochSet() {
		return Sun_EpochSet;
	}

	public void setSun_EpochSet(String sun_EpochSet) {
		Sun_EpochSet = sun_EpochSet;
	}
}
