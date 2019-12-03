package com.morelinks.feign.micro.product.api.model;

import java.util.Date;

/**
 * 描述:product_property表的实体类
 * @version
 */
public class ProductProperty {//产品性能表
    /**
     * 产品属性Id
     */
    private Integer id;

    /**
     * 
     */
    private Integer modelId;

    /**
     * 产品类型：对应产品类型表的值
     */
    private String propertyName;

    /**
     * 
     */
    private String propertyDesc;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 属性状态
     */
    private Integer propertyStatus;

    /**
     * 品牌类型
     */
    private Integer propertyTypeId;

    /**
     * 产品属性Id
     * @return id 产品属性Id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 产品属性Id
     * @param id 产品属性Id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return model_id 
     */
    public Integer getModelId() {
        return modelId;
    }

    /**
     * 
     * @param modelId 
     */
    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    /**
     * 产品类型：对应产品类型表的值
     * @return property_name 产品类型：对应产品类型表的值
     */
    public String getPropertyName() {
        return propertyName;
    }

    /**
     * 产品类型：对应产品类型表的值
     * @param propertyName 产品类型：对应产品类型表的值
     */
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName == null ? null : propertyName.trim();
    }

    /**
     * 
     * @return property_desc 
     */
    public String getPropertyDesc() {
        return propertyDesc;
    }

    /**
     * 
     * @param propertyDesc 
     */
    public void setPropertyDesc(String propertyDesc) {
        this.propertyDesc = propertyDesc == null ? null : propertyDesc.trim();
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
     * 属性状态
     * @return property_status 属性状态
     */
    public Integer getPropertyStatus() {
        return propertyStatus;
    }

    /**
     * 属性状态
     * @param propertyStatus 属性状态
     */
    public void setPropertyStatus(Integer propertyStatus) {
        this.propertyStatus = propertyStatus;
    }

    /**
     * 品牌类型
     * @return property_type_id 品牌类型
     */
    public Integer getPropertyTypeId() {
        return propertyTypeId;
    }

    /**
     * 品牌类型
     * @param propertyTypeId 品牌类型
     */
    public void setPropertyTypeId(Integer propertyTypeId) {
        this.propertyTypeId = propertyTypeId;
    }
}