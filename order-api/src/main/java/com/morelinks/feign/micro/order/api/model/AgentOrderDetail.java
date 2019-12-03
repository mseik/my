package com.morelinks.feign.micro.order.api.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述:agent_order_detail表的实体类
 * @version
 */
public class AgentOrderDetail {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String agentOrderId;

    /**
     * 
     */
    private Integer productId;

    /**
     * 产品数量
     */
    private Integer productNum;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 折扣描述
     */
    private String discountDesc;

    /**
     * 订单描述
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
     * 原始金额
     */
    private BigDecimal oriAmount;

    /**
     * 最终产品价格
     */
    private BigDecimal productAmount;

    /**
     * 折扣价格
     */
    private BigDecimal discountAmount;

    /**
     * 是否是核心产品 0：不是 1：是
     */
    private Integer coreProductType;

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
     * @return agent_order_id 
     */
    public String getAgentOrderId() {
        return agentOrderId;
    }

    /**
     * 
     * @param agentOrderId 
     */
    public void setAgentOrderId(String agentOrderId) {
        this.agentOrderId = agentOrderId == null ? null : agentOrderId.trim();
    }

    /**
     * 
     * @return product_id 
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 
     * @param productId 
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 产品数量
     * @return product_num 产品数量
     */
    public Integer getProductNum() {
        return productNum;
    }

    /**
     * 产品数量
     * @param productNum 产品数量
     */
    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
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
     * 折扣描述
     * @return discount_desc 折扣描述
     */
    public String getDiscountDesc() {
        return discountDesc;
    }

    /**
     * 折扣描述
     * @param discountDesc 折扣描述
     */
    public void setDiscountDesc(String discountDesc) {
        this.discountDesc = discountDesc == null ? null : discountDesc.trim();
    }

    /**
     * 订单描述
     * @return remark 订单描述
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 订单描述
     * @param remark 订单描述
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
     * 原始金额
     * @return ori_amount 原始金额
     */
    public BigDecimal getOriAmount() {
        return oriAmount;
    }

    /**
     * 原始金额
     * @param oriAmount 原始金额
     */
    public void setOriAmount(BigDecimal oriAmount) {
        this.oriAmount = oriAmount;
    }

    /**
     * 最终产品价格
     * @return product_amount 最终产品价格
     */
    public BigDecimal getProductAmount() {
        return productAmount;
    }

    /**
     * 最终产品价格
     * @param productAmount 最终产品价格
     */
    public void setProductAmount(BigDecimal productAmount) {
        this.productAmount = productAmount;
    }

    /**
     * 折扣价格
     * @return discount_amount 折扣价格
     */
    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    /**
     * 折扣价格
     * @param discountAmount 折扣价格
     */
    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    /**
     * 是否是核心产品 0：不是 1：是
     * @return core_product_type 是否是核心产品 0：不是 1：是
     */
    public Integer getCoreProductType() {
        return coreProductType;
    }

    /**
     * 是否是核心产品 0：不是 1：是
     * @param coreProductType 是否是核心产品 0：不是 1：是
     */
    public void setCoreProductType(Integer coreProductType) {
        this.coreProductType = coreProductType;
    }
}