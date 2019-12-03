package com.morelinks.feign.micro.order.api.model;

import java.util.Date;

/**
 * 描述:agent_order_form_config表的实体类
 * @version
 */
public class AgentOrderFormConfig {
    /**
     * 
     */
    private Integer userId;

    /**
     * 最近一次地址Id
     */
    private Integer lastAddressId;

    /**
     * 最近一次支付类别
     */
    private Byte lastPayType;

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
     * 最近一次地址Id
     * @return last_address_id 最近一次地址Id
     */
    public Integer getLastAddressId() {
        return lastAddressId;
    }

    /**
     * 最近一次地址Id
     * @param lastAddressId 最近一次地址Id
     */
    public void setLastAddressId(Integer lastAddressId) {
        this.lastAddressId = lastAddressId;
    }

    /**
     * 最近一次支付类别
     * @return last_pay_type 最近一次支付类别
     */
    public Byte getLastPayType() {
        return lastPayType;
    }

    /**
     * 最近一次支付类别
     * @param lastPayType 最近一次支付类别
     */
    public void setLastPayType(Byte lastPayType) {
        this.lastPayType = lastPayType;
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