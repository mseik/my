package com.morelinks.feign.micro.product.api.model;

import java.util.Date;

/**
 * 描述:config_product_property表的实体类
 * @version
 */
public class ConfigProductProperty {
    /**
     * 
     */
    private Integer id;

    /**
     * 属性名
     */
    private String propertyName;

    /**
     * 1:生效
     */
    private Byte propertyStatus;

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
     * 属性名
     * @return property_name 属性名
     */
    public String getPropertyName() {
        return propertyName;
    }

    /**
     * 属性名
     * @param propertyName 属性名
     */
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName == null ? null : propertyName.trim();
    }

    /**
     * 1:生效
     * @return property__status 1:生效
     */
    public Byte getPropertyStatus() {
        return propertyStatus;
    }

    /**
     * 1:生效
     * @param propertyStatus 1:生效
     */
    public void setPropertyStatus(Byte propertyStatus) {
        this.propertyStatus = propertyStatus;
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