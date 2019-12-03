package com.morelinks.feign.micro.product.api.model;

import java.util.Date;

/**
 * 描述:product_model表的实体类
 * @version
 */
public class ProductModel {
    /**
     * 产品型号Id 暂时保留五位 前两位为类别编号
     */
    private Integer id;

    /**
     * 
     */
    private Integer categoryId;

    /**
     * 
     */
    private Integer brandId;

    /**
     * 流水号从1开始
     */
    private Integer serialNo;

    /**
     * 对内显示名称
     */
    private String modelName;

    /**
     * 产品状态 1：添加 2：上线零售 2：下架零售
     */
    private Integer modelStatus;

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
     * 对外显示名称
     */
    private String showName;

    /**
     * 
     */
    private String categoryName;

    /**
     * 
     */
    private String brandName;

    /**
     * 是否对外销售 0：不对外 1：对外
     */
    private Integer isAgentSale;

    /**
     * 产品简述
     */
    private String resume;

    /**
     * 封面图片路径
     */
    private String coverImgPath;

    /**
     * 产品型号Id 暂时保留五位 前两位为类别编号
     * @return id 产品型号Id 暂时保留五位 前两位为类别编号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 产品型号Id 暂时保留五位 前两位为类别编号
     * @param id 产品型号Id 暂时保留五位 前两位为类别编号
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
     * 流水号从1开始
     * @return serial_no 流水号从1开始
     */
    public Integer getSerialNo() {
        return serialNo;
    }

    /**
     * 流水号从1开始
     * @param serialNo 流水号从1开始
     */
    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    /**
     * 对内显示名称
     * @return model_name 对内显示名称
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * 对内显示名称
     * @param modelName 对内显示名称
     */
    public void setModelName(String modelName) {
        this.modelName = modelName == null ? null : modelName.trim();
    }

    /**
     * 产品状态 1：添加 2：上线零售 2：下架零售
     * @return model_status 产品状态 1：添加 2：上线零售 2：下架零售
     */
    public Integer getModelStatus() {
        return modelStatus;
    }

    /**
     * 产品状态 1：添加 2：上线零售 2：下架零售
     * @param modelStatus 产品状态 1：添加 2：上线零售 2：下架零售
     */
    public void setModelStatus(Integer modelStatus) {
        this.modelStatus = modelStatus;
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

    /**
     * 对外显示名称
     * @return show_name 对外显示名称
     */
    public String getShowName() {
        return showName;
    }

    /**
     * 对外显示名称
     * @param showName 对外显示名称
     */
    public void setShowName(String showName) {
        this.showName = showName == null ? null : showName.trim();
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
     * 是否对外销售 0：不对外 1：对外
     * @return is_agent_sale 是否对外销售 0：不对外 1：对外
     */
    public Integer getIsAgentSale() {
        return isAgentSale;
    }

    /**
     * 是否对外销售 0：不对外 1：对外
     * @param isAgentSale 是否对外销售 0：不对外 1：对外
     */
    public void setIsAgentSale(Integer isAgentSale) {
        this.isAgentSale = isAgentSale;
    }

    /**
     * 产品简述
     * @return resume 产品简述
     */
    public String getResume() {
        return resume;
    }

    /**
     * 产品简述
     * @param resume 产品简述
     */
    public void setResume(String resume) {
        this.resume = resume == null ? null : resume.trim();
    }

    /**
     * 封面图片路径
     * @return cover_img_path 封面图片路径
     */
    public String getCoverImgPath() {
        return coverImgPath;
    }

    /**
     * 封面图片路径
     * @param coverImgPath 封面图片路径
     */
    public void setCoverImgPath(String coverImgPath) {
        this.coverImgPath = coverImgPath == null ? null : coverImgPath.trim();
    }
}