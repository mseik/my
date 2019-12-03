package com.morelinks.feign.micro.device.api.model;

import java.util.Date;

/**
 * 描述:open_cloud_app_info表的实体类
 * @version
 * @author:  sgfily
 */
public class OpenCloudAppInfo {
    /**
     * 
     */
    private String appId;

    /**
     * 
     */
    private String appSecret;

    /**
     * 用于sha1的验证
     */
    private String token;

    /**
     * aes秘钥验证
     */
    private String aesKey;

    /**
     * 数据传输短连接加密模式 0：不加密 1：sha1 2：sha1+aes加密
     */
    private Integer httpEncryptType;

    /**
     * 长连接通信加密模式 0：不加密 1：sha1 2：sha1+aes加密
     */
    private Integer socketEncryptType;

    /**
     * 
     */
    private String appName;

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
     * @return app_secret 
     */
    public String getAppSecret() {
        return appSecret;
    }

    /**
     * 
     * @param appSecret 
     */
    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret == null ? null : appSecret.trim();
    }

    /**
     * 用于sha1的验证
     * @return token 用于sha1的验证
     */
    public String getToken() {
        return token;
    }

    /**
     * 用于sha1的验证
     * @param token 用于sha1的验证
     */
    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    /**
     * aes秘钥验证
     * @return aes_key aes秘钥验证
     */
    public String getAesKey() {
        return aesKey;
    }

    /**
     * aes秘钥验证
     * @param aesKey aes秘钥验证
     */
    public void setAesKey(String aesKey) {
        this.aesKey = aesKey == null ? null : aesKey.trim();
    }

    /**
     * 数据传输短连接加密模式 0：不加密 1：sha1 2：sha1+aes加密
     * @return http_encrypt_type 数据传输短连接加密模式 0：不加密 1：sha1 2：sha1+aes加密
     */
    public Integer getHttpEncryptType() {
        return httpEncryptType;
    }

    /**
     * 数据传输短连接加密模式 0：不加密 1：sha1 2：sha1+aes加密
     * @param httpEncryptType 数据传输短连接加密模式 0：不加密 1：sha1 2：sha1+aes加密
     */
    public void setHttpEncryptType(Integer httpEncryptType) {
        this.httpEncryptType = httpEncryptType;
    }

    /**
     * 长连接通信加密模式 0：不加密 1：sha1 2：sha1+aes加密
     * @return socket_encrypt_type 长连接通信加密模式 0：不加密 1：sha1 2：sha1+aes加密
     */
    public Integer getSocketEncryptType() {
        return socketEncryptType;
    }

    /**
     * 长连接通信加密模式 0：不加密 1：sha1 2：sha1+aes加密
     * @param socketEncryptType 长连接通信加密模式 0：不加密 1：sha1 2：sha1+aes加密
     */
    public void setSocketEncryptType(Integer socketEncryptType) {
        this.socketEncryptType = socketEncryptType;
    }

    /**
     * 
     * @return app_name 
     */
    public String getAppName() {
        return appName;
    }

    /**
     * 
     * @param appName 
     */
    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
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