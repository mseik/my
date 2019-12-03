package com.morelinks.feign.micro.product.api.model;

import java.util.Date;

/**
 * 描述:product_property_type表的实体类
 * @version
 */
public class ProductPropertyType {
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
    private String propertyTypeName;

    /**
     * 
     */
    private String propertyTypeDesc;

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
    private Integer propertyTypeStatus;

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
     * @return property_type_name 产品类型：对应产品类型表的值
     */
    public String getPropertyTypeName() {
        return propertyTypeName;
    }

    /**
     * 产品类型：对应产品类型表的值
     * @param propertyTypeName 产品类型：对应产品类型表的值
     */
    public void setPropertyTypeName(String propertyTypeName) {
        this.propertyTypeName = propertyTypeName == null ? null : propertyTypeName.trim();
    }

    /**
     * 
     * @return property_type_desc 
     */
    public String getPropertyTypeDesc() {
        return propertyTypeDesc;
    }

    /**
     * 
     * @param propertyTypeDesc 
     */
    public void setPropertyTypeDesc(String propertyTypeDesc) {
        this.propertyTypeDesc = propertyTypeDesc == null ? null : propertyTypeDesc.trim();
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
     * @return property_type_status 属性状态
     */
    public Integer getPropertyTypeStatus() {
        return propertyTypeStatus;
    }

    /**
     * 属性状态
     * @param propertyTypeStatus 属性状态
     */
    public void setPropertyTypeStatus(Integer propertyTypeStatus) {
        this.propertyTypeStatus = propertyTypeStatus;
    }
}