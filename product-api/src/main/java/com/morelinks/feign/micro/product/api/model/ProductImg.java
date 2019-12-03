package com.morelinks.feign.micro.product.api.model;

import java.util.Date;

/**
 * 描述:product_img表的实体类
 * @version
 */
public class ProductImg {
    /**
     * 
     */
    private Integer id;

    /**
     * 图片相对路径 显示由上层决定
     */
    private String imgPath;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 显示状态 0：不显示 1：显示
     */
    private Integer showStatus;

    /**
     * 模型Id
     */
    private Integer modelId;

    /**
     * 产品Id
     */
    private Integer productId;

    /**
     * 
     */
    private Integer delStatus;

    /**
     * 显示权重 用于展示排序 自动计算
     */
    private Integer showWeight;

    /**
     * 手动设置权重 权重最高
     */
    private Integer handWeight;

    /**
     * 图片描述
     */
    private String imgDesc;

    /**
     * 图片标题
     */
    private String imgTitle;

    /**
     * 备注
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
     * 图片相对路径 显示由上层决定
     * @return img_path 图片相对路径 显示由上层决定
     */
    public String getImgPath() {
        return imgPath;
    }

    /**
     * 图片相对路径 显示由上层决定
     * @param imgPath 图片相对路径 显示由上层决定
     */
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath == null ? null : imgPath.trim();
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
     * 显示状态 0：不显示 1：显示
     * @return show_status 显示状态 0：不显示 1：显示
     */
    public Integer getShowStatus() {
        return showStatus;
    }

    /**
     * 显示状态 0：不显示 1：显示
     * @param showStatus 显示状态 0：不显示 1：显示
     */
    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    /**
     * 模型Id
     * @return model_id 模型Id
     */
    public Integer getModelId() {
        return modelId;
    }

    /**
     * 模型Id
     * @param modelId 模型Id
     */
    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    /**
     * 产品Id
     * @return product_id 产品Id
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 产品Id
     * @param productId 产品Id
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 
     * @return del_status 
     */
    public Integer getDelStatus() {
        return delStatus;
    }

    /**
     * 
     * @param delStatus 
     */
    public void setDelStatus(Integer delStatus) {
        this.delStatus = delStatus;
    }

    /**
     * 显示权重 用于展示排序 自动计算
     * @return show_weight 显示权重 用于展示排序 自动计算
     */
    public Integer getShowWeight() {
        return showWeight;
    }

    /**
     * 显示权重 用于展示排序 自动计算
     * @param showWeight 显示权重 用于展示排序 自动计算
     */
    public void setShowWeight(Integer showWeight) {
        this.showWeight = showWeight;
    }

    /**
     * 手动设置权重 权重最高
     * @return hand_weight 手动设置权重 权重最高
     */
    public Integer getHandWeight() {
        return handWeight;
    }

    /**
     * 手动设置权重 权重最高
     * @param handWeight 手动设置权重 权重最高
     */
    public void setHandWeight(Integer handWeight) {
        this.handWeight = handWeight;
    }

    /**
     * 图片描述
     * @return img_desc 图片描述
     */
    public String getImgDesc() {
        return imgDesc;
    }

    /**
     * 图片描述
     * @param imgDesc 图片描述
     */
    public void setImgDesc(String imgDesc) {
        this.imgDesc = imgDesc == null ? null : imgDesc.trim();
    }

    /**
     * 图片标题
     * @return img_title 图片标题
     */
    public String getImgTitle() {
        return imgTitle;
    }

    /**
     * 图片标题
     * @param imgTitle 图片标题
     */
    public void setImgTitle(String imgTitle) {
        this.imgTitle = imgTitle == null ? null : imgTitle.trim();
    }

    /**
     * 备注
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}