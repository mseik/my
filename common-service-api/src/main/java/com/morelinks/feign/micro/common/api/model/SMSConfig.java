package com.morelinks.feign.micro.common.api.model;

import java.util.Date;

/**
 * 描述:sms_config表的实体类
 * @version
 * @author:  sgfily
 * @创建时间: 2019-01-21
 */
public class SMSConfig {
    /**
     * 
     */
    private Integer id;

    /**
     * 来源：如morelinks,ziotai
     */
    private String fromSource;

    /**
     * 短信签名
     */
    private String signature;

    /**
     * 
     */
    private String ymUrl;

    /**
     * 
     */
    private String ymCdkey;

    /**
     * 
     */
    private String ymPassword;

    /**
     * 
     */
    private String ymSeqid;

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
     */
    private Integer validStatus;

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
     * 来源：如morelinks,ziotai
     * @return from_source 来源：如morelinks,ziotai
     */
    public String getFromSource() {
        return fromSource;
    }

    /**
     * 来源：如morelinks,ziotai
     * @param fromSource 来源：如morelinks,ziotai
     */
    public void setFromSource(String fromSource) {
        this.fromSource = fromSource == null ? null : fromSource.trim();
    }

    /**
     * 短信签名
     * @return signature 短信签名
     */
    public String getSignature() {
        return signature;
    }

    /**
     * 短信签名
     * @param signature 短信签名
     */
    public void setSignature(String signature) {
        this.signature = signature == null ? null : signature.trim();
    }

    /**
     * 
     * @return ym_url 
     */
    public String getYmUrl() {
        return ymUrl;
    }

    /**
     * 
     * @param ymUrl 
     */
    public void setYmUrl(String ymUrl) {
        this.ymUrl = ymUrl == null ? null : ymUrl.trim();
    }

    /**
     * 
     * @return ym_cdkey 
     */
    public String getYmCdkey() {
        return ymCdkey;
    }

    /**
     * 
     * @param ymCdkey 
     */
    public void setYmCdkey(String ymCdkey) {
        this.ymCdkey = ymCdkey == null ? null : ymCdkey.trim();
    }

    /**
     * 
     * @return ym_password 
     */
    public String getYmPassword() {
        return ymPassword;
    }

    /**
     * 
     * @param ymPassword 
     */
    public void setYmPassword(String ymPassword) {
        this.ymPassword = ymPassword == null ? null : ymPassword.trim();
    }

    /**
     * 
     * @return ym_seqid 
     */
    public String getYmSeqid() {
        return ymSeqid;
    }

    /**
     * 
     * @param ymSeqid 
     */
    public void setYmSeqid(String ymSeqid) {
        this.ymSeqid = ymSeqid == null ? null : ymSeqid.trim();
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
     * 
     * @return valid_status 
     */
    public Integer getValidStatus() {
        return validStatus;
    }

    /**
     * 
     * @param validStatus 
     */
    public void setValidStatus(Integer validStatus) {
        this.validStatus = validStatus;
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