package com.morelinks.feign.micro.device.api.dto;

import com.morelinks.feign.micro.device.api.model.AppDeviceType;
import com.morelinks.feign.micro.device.api.model.DeviceInfo;
import com.morelinks.feign.micro.device.api.model.OpenCloudAppInfo;

/**
 * 设备信息扩展
 */
public class DeviceInfoDTO extends DeviceInfo {
	/**
	 * appInfo 信息
	 */
	public OpenCloudAppInfo appInfo;

	public OpenCloudAppInfo getAppInfo() {
		return appInfo;
	}

	public void setAppInfo(OpenCloudAppInfo appInfo) {
		this.appInfo = appInfo;
	}
}
