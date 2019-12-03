package com.morelinks.feign.micro.product.api.model;

import java.util.Date;

/**
 * 描述:product_brand表的实体类
 * @version
 */

public class ProductBrand {//产品品牌
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String brandName;

    /**
     * 产家Id
     */
    private Integer supplierId;

    /**
     * 
     */
    private Integer brandStatus;

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
     * 供应商名称
     */
    private String supplierName;

    /**
     * 外部显示名称
     */
    private String showName;

    /**
     * 
     */
    private String logoImgPath;

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

    /**
     * 产家Id
     * @return supplier_id 产家Id
     */
    public Integer getSupplierId() {
        return supplierId;
    }

    /**
     * 产家Id
     * @param supplierId 产家Id
     */
    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    /**
     * 
     * @return brand_status 
     */
    public Integer getBrandStatus() {
        return brandStatus;
    }

    /**
     * 
     * @param brandStatus 
     */
    public void setBrandStatus(Integer brandStatus) {
        this.brandStatus = brandStatus;
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

    /**
     * 供应商名称
     * @return supplier_name 供应商名称
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * 供应商名称
     * @param supplierName 供应商名称
     */
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName == null ? null : supplierName.trim();
    }

    /**
     * 外部显示名称
     * @return show_name 外部显示名称
     */
    public String getShowName() {
        return showName;
    }

    /**
     * 外部显示名称
     * @param showName 外部显示名称
     */
    public void setShowName(String showName) {
        this.showName = showName == null ? null : showName.trim();
    }

    /**
     * 
     * @return logo_img_path 
     */
    public String getLogoImgPath() {
        return logoImgPath;
    }

    /**
     * 
     * @param logoImgPath 
     */
    public void setLogoImgPath(String logoImgPath) {
        this.logoImgPath = logoImgPath == null ? null : logoImgPath.trim();
    }
}