package com.morelinks.feign.micro.inner.user.api.model;

import java.util.Date;

/**
 * 描述:user_agent_map表的实体类
 * @version
 * @author:  sgfily
 * @创建时间: 2018-12-13
 */
public class UserAgentMap {
    /**
     * 
     */
    private Integer userId;

    /**
     * 
     */
    private Integer agentId;

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