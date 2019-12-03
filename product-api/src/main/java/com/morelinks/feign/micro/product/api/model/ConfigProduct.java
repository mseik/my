package com.morelinks.feign.micro.product.api.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述:config_product表的实体类
 * @version
 */
public class ConfigProduct {
    /**
     * 
     */
    private Integer id;

    /**
     * 品牌Id
     */
    private Integer brandId;

    /**
     * 匹配的产品Id 
     */
    private Integer productId;

    /**
     * 配单系统产品名称
     */
    private String productName;

    /**
     * 
     */
    private String showName;

    /**
     * 配单产品状态 1：有效 2：无效
     */
    private Integer productStatus;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * logo图片
     */
    private String logoPath;

    /**
     * 产品备注
     */
    private String remark;

    /**
     * 产品配单价格
     */
    private BigDecimal productAmount;

    /**
     * 产品简述
     */
    private String productResume;

    /**
     * 
     */
    private String modelName;

    /**
     * 1:迈联添加 2：代理商添加
     */
    private Byte productType;

    /**
     * 代理商Id 
     */
    private Integer agentId;

    /**
     * 排序字段
     */
    private Integer sort;

    /**
     * 
     */
    private Integer categoryId;

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
     * 品牌Id
     * @return brand_id 品牌Id
     */
    public Integer getBrandId() {
        return brandId;
    }

    /**
     * 品牌Id
     * @param brandId 品牌Id
     */
    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    /**
     * 匹配的产品Id 
     * @return product_id 匹配的产品Id 
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 匹配的产品Id 
     * @param productId 匹配的产品Id 
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 配单系统产品名称
     * @return product_name 配单系统产品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 配单系统产品名称
     * @param productName 配单系统产品名称
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * 
     * @return show_name 
     */
    public String getShowName() {
        return showName;
    }

    /**
     * 
     * @param showName 
     */
    public void setShowName(String showName) {
        this.showName = showName == null ? null : showName.trim();
    }

    /**
     * 配单产品状态 1：有效 2：无效
     * @return product_status 配单产品状态 1：有效 2：无效
     */
    public Integer getProductStatus() {
        return productStatus;
    }

    /**
     * 配单产品状态 1：有效 2：无效
     * @param productStatus 配单产品状态 1：有效 2：无效
     */
    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
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
     * logo图片
     * @return logo_path logo图片
     */
    public String getLogoPath() {
        return logoPath;
    }

    /**
     * logo图片
     * @param logoPath logo图片
     */
    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath == null ? null : logoPath.trim();
    }

    /**
     * 产品备注
     * @return remark 产品备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 产品备注
     * @param remark 产品备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 产品配单价格
     * @return product_amount 产品配单价格
     */
    public BigDecimal getProductAmount() {
        return productAmount;
    }

    /**
     * 产品配单价格
     * @param productAmount 产品配单价格
     */
    public void setProductAmount(BigDecimal productAmount) {
        this.productAmount = productAmount;
    }

    /**
     * 产品简述
     * @return product_resume 产品简述
     */
    public String getProductResume() {
        return productResume;
    }

    /**
     * 产品简述
     * @param productResume 产品简述
     */
    public void setProductResume(String productResume) {
        this.productResume = productResume == null ? null : productResume.trim();
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

    /**
     * 1:迈联添加 2：代理商添加
     * @return product_type 1:迈联添加 2：代理商添加
     */
    public Byte getProductType() {
        return productType;
    }

    /**
     * 1:迈联添加 2：代理商添加
     * @param productType 1:迈联添加 2：代理商添加
     */
    public void setProductType(Byte productType) {
        this.productType = productType;
    }

    /**
     * 代理商Id 
     * @return agent_id 代理商Id 
     */
    public Integer getAgentId() {
        return agentId;
    }

    /**
     * 代理商Id 
     * @param agentId 代理商Id 
     */
    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    /**
     * 排序字段
     * @return sort 排序字段
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 排序字段
     * @param sort 排序字段
     */
    public void setSort(Integer sort) {
        this.sort = sort;
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
}