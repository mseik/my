package com.morelinks.feign.micro.order.api.model;

import java.util.Date;

/**
 * 描述:template_pdf表的实体类
 * @version
 */
public class TemplatePdf {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer agentId;

    /**
     * 
     */
    private Integer userId;

    /**
     * 
     */
    private String headerMessage;

    /**
     * 
     */
    private String tipsMessage;

    /**
     * 
     */
    private String footerMessage;

    /**
     * 
     */
    private String watermarkMessage;

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
     * @return agent_id 
     */
    public Integer getAgentId() {
        return agentId;
    }

    /**
     * 
     * @param agentId 
     */
    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
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
     * @return header_message 
     */
    public String getHeaderMessage() {
        return headerMessage;
    }

    /**
     * 
     * @param headerMessage 
     */
    public void setHeaderMessage(String headerMessage) {
        this.headerMessage = headerMessage == null ? null : headerMessage.trim();
    }

    /**
     * 
     * @return tips_message 
     */
    public String getTipsMessage() {
        return tipsMessage;
    }

    /**
     * 
     * @param tipsMessage 
     */
    public void setTipsMessage(String tipsMessage) {
        this.tipsMessage = tipsMessage == null ? null : tipsMessage.trim();
    }

    /**
     * 
     * @return footer_message 
     */
    public String getFooterMessage() {
        return footerMessage;
    }

    /**
     * 
     * @param footerMessage 
     */
    public void setFooterMessage(String footerMessage) {
        this.footerMessage = footerMessage == null ? null : footerMessage.trim();
    }

    /**
     * 
     * @return watermark_message 
     */
    public String getWatermarkMessage() {
        return watermarkMessage;
    }

    /**
     * 
     * @param watermarkMessage 
     */
    public void setWatermarkMessage(String watermarkMessage) {
        this.watermarkMessage = watermarkMessage == null ? null : watermarkMessage.trim();
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