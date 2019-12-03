package com.morelinks.feign.micro.inner.user.api.model;

import java.util.Date;

/**
 * 描述:agent_level表的实体类
 * @version
 */
public class AgentLevel {
    /**
     * 
     */
    private Integer id;

    /**
     * 等级
     */
    private Integer level;

    /**
     * 等级名称
     */
    private String levelName;

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
     * 等级
     * @return level 等级
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 等级
     * @param level 等级
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 等级名称
     * @return level_name 等级名称
     */
    public String getLevelName() {
        return levelName;
    }

    /**
     * 等级名称
     * @param levelName 等级名称
     */
    public void setLevelName(String levelName) {
        this.levelName = levelName == null ? null : levelName.trim();
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
}