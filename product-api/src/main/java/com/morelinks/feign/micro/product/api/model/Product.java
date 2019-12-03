package com.morelinks.feign.micro.product.api.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述:product表的实体类
 * @version
 */
public class Product {
    /**
     * 产品型号Id 暂时保留五位 前两位为类别编号
     */
    private Integer id;

    /**
     * 
     */
    private Integer modelId;

    /**
     * 产品属性，多个属性以逗号分隔
     */
    private String productProperties;

    /**
     * 对外售卖价
     */
    private BigDecimal productAmount;

    /**
     * 产品会员价
     */
    private BigDecimal productMemberAmount;

    /**
     * 采购价
     */
    private BigDecimal purchaseAmount;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品状态 0：添加 1:生效
     */
    private Integer productStatus;

    /**
     * 产品备注
     */
    private String productRemark;

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
     * 对内显示名称
     */
    private String modelName;

    /**
     * 是否对外销售 0：不对外 1：对外
     */
    private Integer isAgentSale;

    /**
     * 是否需要采购 0：不需要 1：需要
     */
    private Integer needPurchase;

    /**
     * 产品简述
     */
    private String resume;

    /**
     * 
     */
    private Integer categoryId;

    /**
     * 
     */
    private Integer brandId;

    /**
     * 封面图片路径
     */
    private String coverImgPath;

    /**
     * 是否抵扣账户货款
     */
    private Integer deduceGoodsAccount;

    /**
     * 是否已删除
     */
    private Integer delStatus;

    /**
     * 配单导出状态 0：待配置 1：已配置 2：无需进入配单
     */
    private Integer configOrderExportStatus;

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
     * @return model_id 
     */
    public Integer getModelId() {
        return modelId;
    }

    /**
     * 
     * @param modelId 
     */
    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    /**
     * 产品属性，多个属性以逗号分隔
     * @return product_properties 产品属性，多个属性以逗号分隔
     */
    public String getProductProperties() {
        return productProperties;
    }

    /**
     * 产品属性，多个属性以逗号分隔
     * @param productProperties 产品属性，多个属性以逗号分隔
     */
    public void setProductProperties(String productProperties) {
        this.productProperties = productProperties == null ? null : productProperties.trim();
    }

    /**
     * 对外售卖价
     * @return product_amount 对外售卖价
     */
    public BigDecimal getProductAmount() {
        return productAmount;
    }

    /**
     * 对外售卖价
     * @param productAmount 对外售卖价
     */
    public void setProductAmount(BigDecimal productAmount) {
        this.productAmount = productAmount;
    }

    /**
     * 产品会员价
     * @return product_member_amount 产品会员价
     */
    public BigDecimal getProductMemberAmount() {
        return productMemberAmount;
    }

    /**
     * 产品会员价
     * @param productMemberAmount 产品会员价
     */
    public void setProductMemberAmount(BigDecimal productMemberAmount) {
        this.productMemberAmount = productMemberAmount;
    }

    /**
     * 采购价
     * @return purchase_amount 采购价
     */
    public BigDecimal getPurchaseAmount() {
        return purchaseAmount;
    }

    /**
     * 采购价
     * @param purchaseAmount 采购价
     */
    public void setPurchaseAmount(BigDecimal purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    /**
     * 产品名称
     * @return product_name 产品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 产品名称
     * @param productName 产品名称
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * 产品状态 0：添加 1:生效
     * @return product_status 产品状态 0：添加 1:生效
     */
    public Integer getProductStatus() {
        return productStatus;
    }

    /**
     * 产品状态 0：添加 1:生效
     * @param productStatus 产品状态 0：添加 1:生效
     */
    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    /**
     * 产品备注
     * @return product_remark 产品备注
     */
    public String getProductRemark() {
        return productRemark;
    }

    /**
     * 产品备注
     * @param productRemark 产品备注
     */
    public void setProductRemark(String productRemark) {
        this.productRemark = productRemark == null ? null : productRemark.trim();
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
     * 是否需要采购 0：不需要 1：需要
     * @return need_purchase 是否需要采购 0：不需要 1：需要
     */
    public Integer getNeedPurchase() {
        return needPurchase;
    }

    /**
     * 是否需要采购 0：不需要 1：需要
     * @param needPurchase 是否需要采购 0：不需要 1：需要
     */
    public void setNeedPurchase(Integer needPurchase) {
        this.needPurchase = needPurchase;
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

    /**
     * 是否抵扣账户货款
     * @return deduce_goods_account 是否抵扣账户货款
     */
    public Integer getDeduceGoodsAccount() {
        return deduceGoodsAccount;
    }

    /**
     * 是否抵扣账户货款
     * @param deduceGoodsAccount 是否抵扣账户货款
     */
    public void setDeduceGoodsAccount(Integer deduceGoodsAccount) {
        this.deduceGoodsAccount = deduceGoodsAccount;
    }

    /**
     * 是否已删除
     * @return del_status 是否已删除
     */
    public Integer getDelStatus() {
        return delStatus;
    }

    /**
     * 是否已删除
     * @param delStatus 是否已删除
     */
    public void setDelStatus(Integer delStatus) {
        this.delStatus = delStatus;
    }

    /**
     * 配单导出状态 0：待配置 1：已配置 2：无需进入配单
     * @return config_order_export_status 配单导出状态 0：待配置 1：已配置 2：无需进入配单
     */
    public Integer getConfigOrderExportStatus() {
        return configOrderExportStatus;
    }

    /**
     * 配单导出状态 0：待配置 1：已配置 2：无需进入配单
     * @param configOrderExportStatus 配单导出状态 0：待配置 1：已配置 2：无需进入配单
     */
    public void setConfigOrderExportStatus(Integer configOrderExportStatus) {
        this.configOrderExportStatus = configOrderExportStatus;
    }
}