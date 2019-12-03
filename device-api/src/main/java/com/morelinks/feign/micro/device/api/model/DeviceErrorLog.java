package com.morelinks.feign.micro.device.api.model;

import java.util.Date;

/**
 * 描述:device_error_log表的实体类
 * @version
 * @author:  sgfily
 */
public class DeviceErrorLog {
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
    private String errorCode;

    /**
     * 
     */
    private String errorMsg;

    /**
     * 处理状态 1：错误上报 未处理 2：处理完成
     */
    private Integer errorStatus;

    /**
     * 设备产生错误的时间
     */
    private Date updateTime;

    /**
     * 错误产生的本地时间
     */
    private String updateLocalTime;

    /**
     * 
     */
    private String errorCompleteUser;

    /**
     * 错误解决人员类型 system user
     */
    private String errorCompleteUserType;

    /**
     * 设备处理完成时间
     */
    private Date errorCompleteTime;

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
     * @return error_code 
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * 
     * @param errorCode 
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode == null ? null : errorCode.trim();
    }

    /**
     * 
     * @return error_msg 
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * 
     * @param errorMsg 
     */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg == null ? null : errorMsg.trim();
    }

    /**
     * 处理状态 1：错误上报 未处理 2：处理完成
     * @return error_status 处理状态 1：错误上报 未处理 2：处理完成
     */
    public Integer getErrorStatus() {
        return errorStatus;
    }

    /**
     * 处理状态 1：错误上报 未处理 2：处理完成
     * @param errorStatus 处理状态 1：错误上报 未处理 2：处理完成
     */
    public void setErrorStatus(Integer errorStatus) {
        this.errorStatus = errorStatus;
    }

    /**
     * 设备产生错误的时间
     * @return update_time 设备产生错误的时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设备产生错误的时间
     * @param updateTime 设备产生错误的时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 错误产生的本地时间
     * @return update_local_time 错误产生的本地时间
     */
    public String getUpdateLocalTime() {
        return updateLocalTime;
    }

    /**
     * 错误产生的本地时间
     * @param updateLocalTime 错误产生的本地时间
     */
    public void setUpdateLocalTime(String updateLocalTime) {
        this.updateLocalTime = updateLocalTime == null ? null : updateLocalTime.trim();
    }

    /**
     * 
     * @return error_complete_user 
     */
    public String getErrorCompleteUser() {
        return errorCompleteUser;
    }

    /**
     * 
     * @param errorCompleteUser 
     */
    public void setErrorCompleteUser(String errorCompleteUser) {
        this.errorCompleteUser = errorCompleteUser == null ? null : errorCompleteUser.trim();
    }

    /**
     * 错误解决人员类型 system user
     * @return error_complete_user_type 错误解决人员类型 system user
     */
    public String getErrorCompleteUserType() {
        return errorCompleteUserType;
    }

    /**
     * 错误解决人员类型 system user
     * @param errorCompleteUserType 错误解决人员类型 system user
     */
    public void setErrorCompleteUserType(String errorCompleteUserType) {
        this.errorCompleteUserType = errorCompleteUserType == null ? null : errorCompleteUserType.trim();
    }

    /**
     * 设备处理完成时间
     * @return error_complete_time 设备处理完成时间
     */
    public Date getErrorCompleteTime() {
        return errorCompleteTime;
    }

    /**
     * 设备处理完成时间
     * @param errorCompleteTime 设备处理完成时间
     */
    public void setErrorCompleteTime(Date errorCompleteTime) {
        this.errorCompleteTime = errorCompleteTime;
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