package com.morelinks.feign.micro.inner.user.api.model;

import java.util.Date;

/**
 * 描述:user_ticket表的实体类
 * @version
 */
public class UserTicket {
    /**
     * 
     */
    private String token;

    /**
     * 
     */
    private Integer expired;

    /**
     * 
     */
    private Date expireTime;

    /**
     * 
     */
    private Date issueTime;

    /**
     * 
     */
    private Integer userId;

    /**
     * 
     */
    private String deviceId;

    /**
     * 
     */
    private String ipAddress;

    /**
     * 
     */
    private String extraInfo;

    /**
     * 所登录的系统Id
     */
    private Integer systemId;

    /**
     * 
     */
    private Integer systemType;

    /**
     * 
     * @return token 
     */
    public String getToken() {
        return token;
    }

    /**
     * 
     * @param token 
     */
    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    /**
     * 
     * @return expired 
     */
    public Integer getExpired() {
        return expired;
    }

    /**
     * 
     * @param expired 
     */
    public void setExpired(Integer expired) {
        this.expired = expired;
    }

    /**
     * 
     * @return expire_time 
     */
    public Date getExpireTime() {
        return expireTime;
    }

    /**
     * 
     * @param expireTime 
     */
    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    /**
     * 
     * @return issue_time 
     */
    public Date getIssueTime() {
        return issueTime;
    }

    /**
     * 
     * @param issueTime 
     */
    public void setIssueTime(Date issueTime) {
        this.issueTime = issueTime;
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
     * @return device_id 
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * 
     * @param deviceId 
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
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
     * 
     * @return extra_info 
     */
    public String getExtraInfo() {
        return extraInfo;
    }

    /**
     * 
     * @param extraInfo 
     */
    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo == null ? null : extraInfo.trim();
    }

    /**
     * 所登录的系统Id
     * @return system_id 所登录的系统Id
     */
    public Integer getSystemId() {
        return systemId;
    }

    /**
     * 所登录的系统Id
     * @param systemId 所登录的系统Id
     */
    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
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
}