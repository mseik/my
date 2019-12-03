package com.morelinks.feign.micro.device.api.model;

import java.util.Date;

/**
 * 描述:app_device_type表的实体类
 * @version
 * @author:  sgfily
 */
public class AppDeviceType {
    /**
     * 
     */
    private String typeId;

    /**
     * 
     */
    private String appId;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String remark;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 类别状态 0:添加 1:测试联调 2：生效上线 3：失效下线（不允许新设备上线）
     */
    private Integer typeStatus;

    /**
     * 心跳间隔时间 单位为秒
     */
    private Integer heartInterval;

    /**
     * 心跳超时时长 比较两次心跳的间隔 或者超时则断开
     */
    private Integer heartExpire;

    /**
     * 
     * @return type_id 
     */
    public String getTypeId() {
        return typeId;
    }

    /**
     * 
     * @param typeId 
     */
    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    /**
     * 
     * @return app_id 
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 
     * @param appId 
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * 
     * @return name 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name 
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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
     * 类别状态 0:添加 1:测试联调 2：生效上线 3：失效下线（不允许新设备上线）
     * @return type_status 类别状态 0:添加 1:测试联调 2：生效上线 3：失效下线（不允许新设备上线）
     */
    public Integer getTypeStatus() {
        return typeStatus;
    }

    /**
     * 类别状态 0:添加 1:测试联调 2：生效上线 3：失效下线（不允许新设备上线）
     * @param typeStatus 类别状态 0:添加 1:测试联调 2：生效上线 3：失效下线（不允许新设备上线）
     */
    public void setTypeStatus(Integer typeStatus) {
        this.typeStatus = typeStatus;
    }

    /**
     * 心跳间隔时间 单位为秒
     * @return heart_interval 心跳间隔时间 单位为秒
     */
    public Integer getHeartInterval() {
        return heartInterval;
    }

    /**
     * 心跳间隔时间 单位为秒
     * @param heartInterval 心跳间隔时间 单位为秒
     */
    public void setHeartInterval(Integer heartInterval) {
        this.heartInterval = heartInterval;
    }

    /**
     * 心跳超时时长 比较两次心跳的间隔 或者超时则断开
     * @return heart_expire 心跳超时时长 比较两次心跳的间隔 或者超时则断开
     */
    public Integer getHeartExpire() {
        return heartExpire;
    }

    /**
     * 心跳超时时长 比较两次心跳的间隔 或者超时则断开
     * @param heartExpire 心跳超时时长 比较两次心跳的间隔 或者超时则断开
     */
    public void setHeartExpire(Integer heartExpire) {
        this.heartExpire = heartExpire;
    }
}