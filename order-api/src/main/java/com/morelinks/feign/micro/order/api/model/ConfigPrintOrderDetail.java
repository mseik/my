package com.morelinks.feign.micro.order.api.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述:config_print_order_detail表的实体类
 * @version
 */
public class ConfigPrintOrderDetail {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String orderId;

    /**
     * 产品类型 1：迈联提供的产品Id 2：自定义的产品Id
     */
    private Integer mapType;

    /**
     * 
     */
    private Integer mapKey;

    /**
     * 名字
     */
    private String mapName;

    /**
     * 产品数量
     */
    private Integer num;

    /**
     * 原始价格
     */
    private BigDecimal oriMount;

    /**
     * 最终价格
     */
    private BigDecimal finalAmount;

    /**
     * 折扣类型 1：百分比 2：固定金额
     */
    private Integer discountType;

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
     * 
     */
    private String categoryName;

    /**
     * 
     */
    private Integer brandId;

    /**
     * 
     */
    private String brandName;

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
     * @return map_type 产品类型 1：迈联提供的产品Id 2：自定义的产品Id
     */
    public Integer getMapType() {
        return mapType;
    }

    /**
     * 产品类型 1：迈联提供的产品Id 2：自定义的产品Id
     * @param mapType 产品类型 1：迈联提供的产品Id 2：自定义的产品Id
     */
    public void setMapType(Integer mapType) {
        this.mapType = mapType;
    }

    /**
     * 
     * @return map_key 
     */
    public Integer getMapKey() {
        return mapKey;
    }

    /**
     * 
     * @param mapKey 
     */
    public void setMapKey(Integer mapKey) {
        this.mapKey = mapKey;
    }

    /**
     * 名字
     * @return map_name 名字
     */
    public String getMapName() {
        return mapName;
    }

    /**
     * 名字
     * @param mapName 名字
     */
    public void setMapName(String mapName) {
        this.mapName = mapName == null ? null : mapName.trim();
    }

    /**
     * 产品数量
     * @return num 产品数量
     */
    public Integer getNum() {
        return num;
    }

    /**
     * 产品数量
     * @param num 产品数量
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * 原始价格
     * @return ori_mount 原始价格
     */
    public BigDecimal getOriMount() {
        return oriMount;
    }

    /**
     * 原始价格
     * @param oriMount 原始价格
     */
    public void setOriMount(BigDecimal oriMount) {
        this.oriMount = oriMount;
    }

    /**
     * 最终价格
     * @return final_amount 最终价格
     */
    public BigDecimal getFinalAmount() {
        return finalAmount;
    }

    /**
     * 最终价格
     * @param finalAmount 最终价格
     */
    public void setFinalAmount(BigDecimal finalAmount) {
        this.finalAmount = finalAmount;
    }

    /**
     * 折扣类型 1：百分比 2：固定金额
     * @return discount_type 折扣类型 1：百分比 2：固定金额
     */
    public Integer getDiscountType() {
        return discountType;
    }

    /**
     * 折扣类型 1：百分比 2：固定金额
     * @param discountType 折扣类型 1：百分比 2：固定金额
     */
    public void setDiscountType(Integer discountType) {
        this.discountType = discountType;
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
     * 
     * @return category_name 
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 
     * @param categoryName 
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    /**
     * 
     * @return brand_id 
     */
    public Integer getBrandId() {
        return brandId;
    }

    /**
     * 
     * @param brandId 
     */
    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    /**
     * 
     * @return brand_name 
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * 
     * @param brandName 
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }
}