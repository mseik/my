package com.morelinks.feign.micro.product.api.model;

import java.util.Date;

/**
 * 描述:product_supplier表的实体类
 * @version
 */
public class ProductSupplier {//供应商
    /**
     * 
     */
    private Integer id;

    /**
     * 供应商名称即公司名
     */
    private String supplierName;

    /**
     * 
     */
    private String supplierAddress;

    /**
     * 供应商联系电话
     */
    private String supplierTels;

    /**
     * 供应商状态
     */
    private Integer supplierStatus;

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
    private String remark;

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
     * 供应商名称即公司名
     * @return supplier_name 供应商名称即公司名
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * 供应商名称即公司名
     * @param supplierName 供应商名称即公司名
     */
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName == null ? null : supplierName.trim();
    }

    /**
     * 
     * @return supplier_address 
     */
    public String getSupplierAddress() {
        return supplierAddress;
    }

    /**
     * 
     * @param supplierAddress 
     */
    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress == null ? null : supplierAddress.trim();
    }

    /**
     * 供应商联系电话
     * @return supplier_tels 供应商联系电话
     */
    public String getSupplierTels() {
        return supplierTels;
    }

    /**
     * 供应商联系电话
     * @param supplierTels 供应商联系电话
     */
    public void setSupplierTels(String supplierTels) {
        this.supplierTels = supplierTels == null ? null : supplierTels.trim();
    }

    /**
     * 供应商状态
     * @return supplier_status 供应商状态
     */
    public Integer getSupplierStatus() {
        return supplierStatus;
    }

    /**
     * 供应商状态
     * @param supplierStatus 供应商状态
     */
    public void setSupplierStatus(Integer supplierStatus) {
        this.supplierStatus = supplierStatus;
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
}