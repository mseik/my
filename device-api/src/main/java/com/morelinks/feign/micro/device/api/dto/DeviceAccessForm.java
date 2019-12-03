package com.morelinks.feign.micro.device.api.dto;

/**
 * 设备接入提交的form
 */
public class DeviceAccessForm {
	private String openDeviceId;
	private String DeviceTypeId;
	private String appId;
	private String ipAddress;

	public String getOpenDeviceId() {
		return openDeviceId;
	}

	public void setOpenDeviceId(String openDeviceId) {
		this.openDeviceId = openDeviceId;
	}

	public String getDeviceTypeId() {
		return DeviceTypeId;
	}

	public void setDeviceTypeId(String deviceTypeId) {
		DeviceTypeId = deviceTypeId;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
}
