package com.morelinks.feign.micro.product.api.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述:config_product_agent_extra表的实体类
 * @version
 */
public class ConfigProductAgentExtra {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer configProductId;

    /**
     * 
     */
    private Integer agentId;

    /**
     * 代理商定的产品价格
     */
    private BigDecimal agentProductAmount;

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
     * @return config_product_id 
     */
    public Integer getConfigProductId() {
        return configProductId;
    }

    /**
     * 
     * @param configProductId 
     */
    public void setConfigProductId(Integer configProductId) {
        this.configProductId = configProductId;
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
     * 代理商定的产品价格
     * @return agent_product_amount 代理商定的产品价格
     */
    public BigDecimal getAgentProductAmount() {
        return agentProductAmount;
    }

    /**
     * 代理商定的产品价格
     * @param agentProductAmount 代理商定的产品价格
     */
    public void setAgentProductAmount(BigDecimal agentProductAmount) {
        this.agentProductAmount = agentProductAmount;
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