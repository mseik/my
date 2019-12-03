package com.morelinks.feign.micro.order.api.model;

import java.util.Date;

/**
 * 描述:agent_delivery_address表的实体类
 * @version
 */
public class AgentDeliveryAddress {
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
    private String deliveryAddress;

    /**
     * 
     */
    private String contactTel;

    /**
     * 
     */
    private String cityId;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 地址状态
     */
    private Integer addressStatus;

    /**
     * 联系邮箱
     */
    private String contactEmail;

    /**
     * 
     */
    private String userName;

    /**
     * 是否是默认配送地址
     */
    private Boolean isDefault;

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
     * @return delivery_address 
     */
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    /**
     * 
     * @param deliveryAddress 
     */
    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress == null ? null : deliveryAddress.trim();
    }

    /**
     * 
     * @return contact_tel 
     */
    public String getContactTel() {
        return contactTel;
    }

    /**
     * 
     * @param contactTel 
     */
    public void setContactTel(String contactTel) {
        this.contactTel = contactTel == null ? null : contactTel.trim();
    }

    /**
     * 
     * @return city_id 
     */
    public String getCityId() {
        return cityId;
    }

    /**
     * 
     * @param cityId 
     */
    public void setCityId(String cityId) {
        this.cityId = cityId == null ? null : cityId.trim();
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
     * 地址状态
     * @return address_status 地址状态
     */
    public Integer getAddressStatus() {
        return addressStatus;
    }

    /**
     * 地址状态
     * @param addressStatus 地址状态
     */
    public void setAddressStatus(Integer addressStatus) {
        this.addressStatus = addressStatus;
    }

    /**
     * 联系邮箱
     * @return contact_email 联系邮箱
     */
    public String getContactEmail() {
        return contactEmail;
    }

    /**
     * 联系邮箱
     * @param contactEmail 联系邮箱
     */
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail == null ? null : contactEmail.trim();
    }

    /**
     * 
     * @return user_name 
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 
     * @param userName 
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 是否是默认配送地址
     * @return is_default 是否是默认配送地址
     */
    public Boolean getIsDefault() {
        return isDefault;
    }

    /**
     * 是否是默认配送地址
     * @param isDefault 是否是默认配送地址
     */
    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }
}