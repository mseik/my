package com.morelinks.feign.micro.order.api.model;

import java.util.Date;

/**
 * 描述:config_order_detail表的实体类
 * @version
 */
public class ConfigOrderDetail {
    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String orderId;

    /**
     * 产品类型 1：迈联提供的产品Id 2：自定义的产品Id
     */
    private Integer productType;

    /**
     * 
     */
    private Integer productId;

    /**
     * 产品数量
     */
    private Integer productNum;

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
     */
    private Integer categoryId;

    /**
     * 存储一级菜单id分类
     */
    private Integer firstCategory;

    /**
     * 
     * @return id 
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 
     * @return order_id 
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 
     * @param orderId 
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * 产品类型 1：迈联提供的产品Id 2：自定义的产品Id
     * @return product_type 产品类型 1：迈联提供的产品Id 2：自定义的产品Id
     */
    public Integer getProductType() {
        return productType;
    }

    /**
     * 产品类型 1：迈联提供的产品Id 2：自定义的产品Id
     * @param productType 产品类型 1：迈联提供的产品Id 2：自定义的产品Id
     */
    public void setProductType(Integer productType) {
        this.productType = productType;
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
     * 产品数量
     * @return product_num 产品数量
     */
    public Integer getProductNum() {
        return productNum;
    }

    /**
     * 产品数量
     * @param productNum 产品数量
     */
    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
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
     * 存储一级菜单id分类
     * @return first_category 存储一级菜单id分类
     */
    public Integer getFirstCategory() {
        return firstCategory;
    }

    /**
     * 存储一级菜单id分类
     * @param firstCategory 存储一级菜单id分类
     */
    public void setFirstCategory(Integer firstCategory) {
        this.firstCategory = firstCategory;
    }
}