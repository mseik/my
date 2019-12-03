package com.morelinks.feign.micro.product.api.model;

import java.util.Date;

/**
 * 描述:product_category表的实体类
 * @version
 */
public class ProductCategory {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String categoryName;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 类别状态
     */
    private Integer categoryStatus;

    /**
     * 
     */
    private String remark;

    /**
     * 外部名称
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
     * 类别状态
     * @return category_status 类别状态
     */
    public Integer getCategoryStatus() {
        return categoryStatus;
    }

    /**
     * 类别状态
     * @param categoryStatus 类别状态
     */
    public void setCategoryStatus(Integer categoryStatus) {
        this.categoryStatus = categoryStatus;
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
     * 外部名称
     * @return show_name 外部名称
     */
    public String getShowName() {
        return showName;
    }

    /**
     * 外部名称
     * @param showName 外部名称
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