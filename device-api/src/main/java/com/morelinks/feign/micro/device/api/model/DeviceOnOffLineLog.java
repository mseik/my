package com.morelinks.feign.micro.device.api.model;

import java.util.Date;

/**
 * 描述:device_on_off_line_log表的实体类
 * @version
 * @author:  sgfily
 */
public class DeviceOnOffLineLog {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer deviceId;

    /**
     * 
     */
    private Integer onOffLineStatus;

    /**
     * 设备产生数据的时间
     */
    private Date updateTime;

    /**
     * 数据产生的本地时间
     */
    private String updateLocalTime;

    /**
     * 
     */
    private String remark;

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
     * 
     * @return device_id 
     */
    public Integer getDeviceId() {
        return deviceId;
    }

    /**
     * 
     * @param deviceId 
     */
    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * 
     * @return on_off_line_status 
     */
    public Integer getOnOffLineStatus() {
        return onOffLineStatus;
    }

    /**
     * 
     * @param onOffLineStatus 
     */
    public void setOnOffLineStatus(Integer onOffLineStatus) {
        this.onOffLineStatus = onOffLineStatus;
    }

    /**
     * 设备产生数据的时间
     * @return update_time 设备产生数据的时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设备产生数据的时间
     * @param updateTime 设备产生数据的时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 数据产生的本地时间
     * @return update_local_time 数据产生的本地时间
     */
    public String getUpdateLocalTime() {
        return updateLocalTime;
    }

    /**
     * 数据产生的本地时间
     * @param updateLocalTime 数据产生的本地时间
     */
    public void setUpdateLocalTime(String updateLocalTime) {
        this.updateLocalTime = updateLocalTime == null ? null : updateLocalTime.trim();
    }

    /**
     * 
     * @return remark 
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 
     * @param remark 
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}