package com.morelinks.feign.micro.inner.user.api.model;

import java.util.Date;

/**
 * 描述:user_weixin_map表的实体类
 * @version
 * @author:  sgfily
 * @创建时间: 2018-12-13
 */
public class UserWeiXinMap {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String appId;

    /**
     * 
     */
    private String openId;

    /**
     * 
     */
    private Integer systemType;

    /**
     * 
     */
    private String unionId;

    /**
     * 
     */
    private Integer userId;

    /**
     * 
     */
    private Integer isBind;

    /**
     * 
     */
    private Date bindTime;

    /**
     * 
     */
    private Date unbindTime;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

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
     * @return open_id 
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 
     * @param openId 
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    /**
     * 
     * @return system_type 
     */
    public Integer getSystemType() {
        return systemType;
    }

    /**
     * 
     * @param systemType 
     */
    public void setSystemType(Integer systemType) {
        this.systemType = systemType;
    }

    /**
     * 
     * @return union_id 
     */
    public String getUnionId() {
        return unionId;
    }

    /**
     * 
     * @param unionId 
     */
    public void setUnionId(String unionId) {
        this.unionId = unionId == null ? null : unionId.trim();
    }

    /**
     * 
     * @return user_id 
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 
     * @param userId 
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 
     * @return is_bind 
     */
    public Integer getIsBind() {
        return isBind;
    }

    /**
     * 
     * @param isBind 
     */
    public void setIsBind(Integer isBind) {
        this.isBind = isBind;
    }

    /**
     * 
     * @return bind_time 
     */
    public Date getBindTime() {
        return bindTime;
    }

    /**
     * 
     * @param bindTime 
     */
    public void setBindTime(Date bindTime) {
        this.bindTime = bindTime;
    }

    /**
     * 
     * @return unbind_time 
     */
    public Date getUnbindTime() {
        return unbindTime;
    }

    /**
     * 
     * @param unbindTime 
     */
    public void setUnbindTime(Date unbindTime) {
        this.unbindTime = unbindTime;
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
}