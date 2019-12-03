package com.morelinks.feign.micro.product.api.model;

import java.util.Date;

/**
 * 描述:config_product_property_map表的实体类
 * @version
 */
public class ConfigProductPropertyMap {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer mapId;

    /**
     * 属性名
     */
    private String propertyId;

    /**
     * 属性性质 1:需要 2：提供
     */
    private Integer needOfferStatus;

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
    private Integer propertyNum;

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
     * @return map_id 
     */
    public Integer getMapId() {
        return mapId;
    }

    /**
     * 
     * @param mapId 
     */
    public void setMapId(Integer mapId) {
        this.mapId = mapId;
    }

    /**
     * 属性名
     * @return property_id 属性名
     */
    public String getPropertyId() {
        return propertyId;
    }

    /**
     * 属性名
     * @param propertyId 属性名
     */
    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId == null ? null : propertyId.trim();
    }

    /**
     * 属性性质 1:需要 2：提供
     * @return need_offer_status 属性性质 1:需要 2：提供
     */
    public Integer getNeedOfferStatus() {
        return needOfferStatus;
    }

    /**
     * 属性性质 1:需要 2：提供
     * @param needOfferStatus 属性性质 1:需要 2：提供
     */
    public void setNeedOfferStatus(Integer needOfferStatus) {
        this.needOfferStatus = needOfferStatus;
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
     * @return property_num 
     */
    public Integer getPropertyNum() {
        return propertyNum;
    }

    /**
     * 
     * @param propertyNum 
     */
    public void setPropertyNum(Integer propertyNum) {
        this.propertyNum = propertyNum;
    }
}