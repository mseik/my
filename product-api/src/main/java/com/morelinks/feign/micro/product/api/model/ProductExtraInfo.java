package com.morelinks.feign.micro.product.api.model;

import java.util.Date;

/**
 * 描述:product_extra_info表的实体类
 * @version
 */
public class ProductExtraInfo {
    /**
     * 
     */
    private Integer id;

    /**
     * 类型说明 1：产品归类即model 2：产品即product
     */
    private Integer extraType;

    /**
     * 
     */
    private String extraKey;

    /**
     * 商品介绍
     */
    private String introduce;

    /**
     * 参数介绍
     */
    private String parametersIntro;

    /**
     * 售后介绍
     */
    private String afterSaleIntro;

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
     * 类型说明 1：产品归类即model 2：产品即product
     * @return extra_type 类型说明 1：产品归类即model 2：产品即product
     */
    public Integer getExtraType() {
        return extraType;
    }

    /**
     * 类型说明 1：产品归类即model 2：产品即product
     * @param extraType 类型说明 1：产品归类即model 2：产品即product
     */
    public void setExtraType(Integer extraType) {
        this.extraType = extraType;
    }

    /**
     * 
     * @return extra_key 
     */
    public String getExtraKey() {
        return extraKey;
    }

    /**
     * 
     * @param extraKey 
     */
    public void setExtraKey(String extraKey) {
        this.extraKey = extraKey == null ? null : extraKey.trim();
    }

    /**
     * 商品介绍
     * @return introduce 商品介绍
     */
    public String getIntroduce() {
        return introduce;
    }

    /**
     * 商品介绍
     * @param introduce 商品介绍
     */
    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    /**
     * 参数介绍
     * @return parameters_intro 参数介绍
     */
    public String getParametersIntro() {
        return parametersIntro;
    }

    /**
     * 参数介绍
     * @param parametersIntro 参数介绍
     */
    public void setParametersIntro(String parametersIntro) {
        this.parametersIntro = parametersIntro == null ? null : parametersIntro.trim();
    }

    /**
     * 售后介绍
     * @return after_sale_intro 售后介绍
     */
    public String getAfterSaleIntro() {
        return afterSaleIntro;
    }

    /**
     * 售后介绍
     * @param afterSaleIntro 售后介绍
     */
    public void setAfterSaleIntro(String afterSaleIntro) {
        this.afterSaleIntro = afterSaleIntro == null ? null : afterSaleIntro.trim();
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