package com.morelinks.feign.micro.order.api.model;

import java.util.Date;

/**
 * 描述:express表的实体类
 * @version
 */
public class Express {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String expressName;

    /**
     * 快递官网
     */
    private String expressSite;

    /**
     * 
     */
    private String contactTel;

    /**
     * 
     */
    private String remark;

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
     * 
     * @return express_name 
     */
    public String getExpressName() {
        return expressName;
    }

    /**
     * 
     * @param expressName 
     */
    public void setExpressName(String expressName) {
        this.expressName = expressName == null ? null : expressName.trim();
    }

    /**
     * 快递官网
     * @return express_site 快递官网
     */
    public String getExpressSite() {
        return expressSite;
    }

    /**
     * 快递官网
     * @param expressSite 快递官网
     */
    public void setExpressSite(String expressSite) {
        this.expressSite = expressSite == null ? null : expressSite.trim();
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
     * @return remark 
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 
     * @param remark 
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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