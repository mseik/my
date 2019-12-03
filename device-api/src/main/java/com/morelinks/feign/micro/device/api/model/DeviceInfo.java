package com.morelinks.feign.micro.device.api.model;

import java.util.Date;

/**
 * 描述:device_info表的实体类
 * @version
 * @author:  sgfily
 */
public class DeviceInfo {
    /**
     * 
     */
    private Integer id;

    /**
     * 合作商 设备id
     */
    private String openDeviceId;

    /**
     * 设备类别Id
     */
    private String deviceTypeId;

    /**
     * 入网设备Id 最终树的根
     */
    private Integer netDeviceId;

    /**
     * 通信Id 网关下唯一
     */
    private String comDeviceId;

    /**
     * 网关合作商的应用Id 
     */
    private String appId;

    /**
     * 设备归属 同一个归属下 设备唯一 主要考虑更换网关的情况
     */
    private String belong;

    /**
     * 
     */
    private String ipAddress;

    /**
     * 软件版本
     */
    private String softwareVersion;

    /**
     * 硬件版本
     */
    private String hardwareVersion;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 设备状态0:创建 1:获取token 2.入网 正常运行 3.设备故障 
     */
    private Integer deviceStatus;

    /**
     * 父节点设备Id，默认-1代表根设备
     */
    private Integer parentId;

    /**
     * 是否是终节点 不是0 是1
     */
    private Integer isLast;

    /**
     * 设备的额外信息
     */
    private String extraInfo;

    /**
     * 
     */
    private String manufacturer;

    /**
     * 
     */
    private String manufactureTime;

    /**
     * 上下线状态 0：下线 1：上线 用以判断能否通信
     */
    private Integer onOffLineStatus;

    /**
     * 上下线时间 防止状态反复导致状态出错
     */
    private Date onOffTime;

    /**
     * 
     */
    private Long version;

    /**
     * 
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 合作商 设备id
     * @return open_device_id 合作商 设备id
     */
    public String getOpenDeviceId() {
        return openDeviceId;
    }

    /**
     * 合作商 设备id
     * @param openDeviceId 合作商 设备id
     */
    public void setOpenDeviceId(String openDeviceId) {
        this.openDeviceId = openDeviceId == null ? null : openDeviceId.trim();
    }

    /**
     * 设备类别Id
     * @return device_type_id 设备类别Id
     */
    public String getDeviceTypeId() {
        return deviceTypeId;
    }

    /**
     * 设备类别Id
     * @param deviceTypeId 设备类别Id
     */
    public void setDeviceTypeId(String deviceTypeId) {
        this.deviceTypeId = deviceTypeId == null ? null : deviceTypeId.trim();
    }

    /**
     * 入网设备Id 最终树的根
     * @return net_device_id 入网设备Id 最终树的根
     */
    public Integer getNetDeviceId() {
        return netDeviceId;
    }

    /**
     * 入网设备Id 最终树的根
     * @param netDeviceId 入网设备Id 最终树的根
     */
    public void setNetDeviceId(Integer netDeviceId) {
        this.netDeviceId = netDeviceId;
    }

    /**
     * 通信Id 网关下唯一
     * @return com_device_id 通信Id 网关下唯一
     */
    public String getComDeviceId() {
        return comDeviceId;
    }

    /**
     * 通信Id 网关下唯一
     * @param comDeviceId 通信Id 网关下唯一
     */
    public void setComDeviceId(String comDeviceId) {
        this.comDeviceId = comDeviceId == null ? null : comDeviceId.trim();
    }

    /**
     * 网关合作商的应用Id 
     * @return app_id 网关合作商的应用Id 
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 网关合作商的应用Id 
     * @param appId 网关合作商的应用Id 
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * 设备归属 同一个归属下 设备唯一 主要考虑更换网关的情况
     * @return belong 设备归属 同一个归属下 设备唯一 主要考虑更换网关的情况
     */
    public String getBelong() {
        return belong;
    }

    /**
     * 设备归属 同一个归属下 设备唯一 主要考虑更换网关的情况
     * @param belong 设备归属 同一个归属下 设备唯一 主要考虑更换网关的情况
     */
    public void setBelong(String belong) {
        this.belong = belong == null ? null : belong.trim();
    }

    /**
     * 
     * @return ip_address 
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * 
     * @param ipAddress 
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress == null ? null : ipAddress.trim();
    }

    /**
     * 软件版本
     * @return software_version 软件版本
     */
    public String getSoftwareVersion() {
        return softwareVersion;
    }

    /**
     * 软件版本
     * @param softwareVersion 软件版本
     */
    public void setSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion == null ? null : softwareVersion.trim();
    }

    /**
     * 硬件版本
     * @return hardware_version 硬件版本
     */
    public String getHardwareVersion() {
        return hardwareVersion;
    }

    /**
     * 硬件版本
     * @param hardwareVersion 硬件版本
     */
    public void setHardwareVersion(String hardwareVersion) {
        this.hardwareVersion = hardwareVersion == null ? null : hardwareVersion.trim();
    }

    /**
     * 
     * @return create_time 
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     * @param createTime 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 
     * @return update_time 
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 
     * @param updateTime 
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 设备状态0:创建 1:获取token 2.入网 正常运行 3.设备故障 
     * @return device_status 设备状态0:创建 1:获取token 2.入网 正常运行 3.设备故障 
     */
    public Integer getDeviceStatus() {
        return deviceStatus;
    }

    /**
     * 设备状态0:创建 1:获取token 2.入网 正常运行 3.设备故障 
     * @param deviceStatus 设备状态0:创建 1:获取token 2.入网 正常运行 3.设备故障 
     */
    public void setDeviceStatus(Integer deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    /**
     * 父节点设备Id，默认-1代表根设备
     * @return parent_id 父节点设备Id，默认-1代表根设备
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 父节点设备Id，默认-1代表根设备
     * @param parentId 父节点设备Id，默认-1代表根设备
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 是否是终节点 不是0 是1
     * @return is_last 是否是终节点 不是0 是1
     */
    public Integer getIsLast() {
        return isLast;
    }

    /**
     * 是否是终节点 不是0 是1
     * @param isLast 是否是终节点 不是0 是1
     */
    public void setIsLast(Integer isLast) {
        this.isLast = isLast;
    }

    /**
     * 设备的额外信息
     * @return extra_info 设备的额外信息
     */
    public String getExtraInfo() {
        return extraInfo;
    }

    /**
     * 设备的额外信息
     * @param extraInfo 设备的额外信息
     */
    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo == null ? null : extraInfo.trim();
    }

    /**
     * 
     * @return manufacturer 
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * 
     * @param manufacturer 
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
    }

    /**
     * 
     * @return manufacture_time 
     */
    public String getManufactureTime() {
        return manufactureTime;
    }

    /**
     * 
     * @param manufactureTime 
     */
    public void setManufactureTime(String manufactureTime) {
        this.manufactureTime = manufactureTime == null ? null : manufactureTime.trim();
    }

    /**
     * 上下线状态 0：下线 1：上线 用以判断能否通信
     * @return on_off_line_status 上下线状态 0：下线 1：上线 用以判断能否通信
     */
    public Integer getOnOffLineStatus() {
        return onOffLineStatus;
    }

    /**
     * 上下线状态 0：下线 1：上线 用以判断能否通信
     * @param onOffLineStatus 上下线状态 0：下线 1：上线 用以判断能否通信
     */
    public void setOnOffLineStatus(Integer onOffLineStatus) {
        this.onOffLineStatus = onOffLineStatus;
    }

    /**
     * 上下线时间 防止状态反复导致状态出错
     * @return on_off_time 上下线时间 防止状态反复导致状态出错
     */
    public Date getOnOffTime() {
        return onOffTime;
    }

    /**
     * 上下线时间 防止状态反复导致状态出错
     * @param onOffTime 上下线时间 防止状态反复导致状态出错
     */
    public void setOnOffTime(Date onOffTime) {
        this.onOffTime = onOffTime;
    }

    /**
     * 
     * @return version 
     */
    public Long getVersion() {
        return version;
    }

    /**
     * 
     * @param version 
     */
    public void setVersion(Long version) {
        this.version = version;
    }
}