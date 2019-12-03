package com.morelinks.feign.micro.common.api.model;

import java.util.Date;

/**
 * 描述:sms_template_config表的实体类
 * @version
 * @author:  sgfily
 * @创建时间: 2019-01-21
 */
public class SMSTemplateConfig {
    /**
     * 
     */
    private Integer id;

    /**
     * 来源 默认为common 如果没有配置的来源模板 则选择默认
     */
    private String fromSource;

    /**
     * 模板类型 1：场景触发通知
     */
    private Integer templateType;

    /**
     * 
     */
    private String content;

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
     * 来源 默认为common 如果没有配置的来源模板 则选择默认
     * @return from_source 来源 默认为common 如果没有配置的来源模板 则选择默认
     */
    public String getFromSource() {
        return fromSource;
    }

    /**
     * 来源 默认为common 如果没有配置的来源模板 则选择默认
     * @param fromSource 来源 默认为common 如果没有配置的来源模板 则选择默认
     */
    public void setFromSource(String fromSource) {
        this.fromSource = fromSource == null ? null : fromSource.trim();
    }

    /**
     * 模板类型 1：场景触发通知
     * @return template_type 模板类型 1：场景触发通知
     */
    public Integer getTemplateType() {
        return templateType;
    }

    /**
     * 模板类型 1：场景触发通知
     * @param templateType 模板类型 1：场景触发通知
     */
    public void setTemplateType(Integer templateType) {
        this.templateType = templateType;
    }

    /**
     * 
     * @return content 
     */
    public String getContent() {
        return content;
    }

    /**
     * 
     * @param content 
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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