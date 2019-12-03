package com.morelinks.feign.micro.order.api.model;

import java.util.Date;

/**
 * 描述:agent_cart表的实体类
 * @version
 */
public class AgentCart {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer userId;

    /**
     * 
     */
    private Integer productId;

    /**
     * 
     */
    private Integer quantity;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 是否选中
     */
    private Boolean selected;

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
     * @return product_id 
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 
     * @param productId 
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 
     * @return quantity 
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * 
     * @param quantity 
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
     * 是否选中
     * @return selected 是否选中
     */
    public Boolean getSelected() {
        return selected;
    }

    /**
     * 是否选中
     * @param selected 是否选中
     */
    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
}