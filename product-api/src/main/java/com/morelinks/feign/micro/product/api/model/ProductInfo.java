package com.morelinks.feign.micro.product.api.model;

import java.util.Date;

/**
 * 描述:product_info表的实体类
 * @version
 */
public class ProductInfo {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer categoryId;

    /**
     * 
     */
    private Integer modelId;

    /**
     * 产品更换编号 原先Id
     */
    private Integer brandId;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 产品状态，1：产品入库
     */
    private Integer productStatus;

    /**
     * 产品流水号 根据id规则计算 全表唯一
     */
    private String serialNo;

    /**
     * 
     */
    private String modelName;

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
     * @return category_id 
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 
     * @param categoryId 
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
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
     * 产品更换编号 原先Id
     * @return brand_id 产品更换编号 原先Id
     */
    public Integer getBrandId() {
        return brandId;
    }

    /**
     * 产品更换编号 原先Id
     * @param brandId 产品更换编号 原先Id
     */
    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
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
     * 产品状态，1：产品入库
     * @return product_status 产品状态，1：产品入库
     */
    public Integer getProductStatus() {
        return productStatus;
    }

    /**
     * 产品状态，1：产品入库
     * @param productStatus 产品状态，1：产品入库
     */
    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    /**
     * 产品流水号 根据id规则计算 全表唯一
     * @return serial_no 产品流水号 根据id规则计算 全表唯一
     */
    public String getSerialNo() {
        return serialNo;
    }

    /**
     * 产品流水号 根据id规则计算 全表唯一
     * @param serialNo 产品流水号 根据id规则计算 全表唯一
     */
    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo == null ? null : serialNo.trim();
    }

    /**
     * 
     * @return model_name 
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * 
     * @param modelName 
     */
    public void setModelName(String modelName) {
        this.modelName = modelName == null ? null : modelName.trim();
    }
}