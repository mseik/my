package com.morelinks.feign.micro.pay.api.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述:pay_order_detail表的实体类
 * @version
 */
public class PayOrderDetail {
    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String payOrderId;

    /**
     * 支付类型 微信1 支付宝2 账户支付3
     */
    private Integer payType;

    /**
     * 
     */
    private String detailTitle;

    /**
     * 
     */
    private String detailDesc;

    /**
     * 
     */
    private String assetId;

    /**
     * 
     */
    private BigDecimal origAmount;

    /**
     * 
     */
    private BigDecimal waitPayAmount;

    /**
     * 支付完成时间
     */
    private Date payResultTime;

    /**
     * 支付状态，1：等待支付，2：支付中，3：支付成功，4：支付失败 
     */
    private Integer payStatus;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 
     */
    private Long version;

    /**
     * 
     * @return id 
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 
     * @return pay_order_id 
     */
    public String getPayOrderId() {
        return payOrderId;
    }

    /**
     * 
     * @param payOrderId 
     */
    public void setPayOrderId(String payOrderId) {
        this.payOrderId = payOrderId == null ? null : payOrderId.trim();
    }

    /**
     * 支付类型 微信1 支付宝2 账户支付3
     * @return pay_type 支付类型 微信1 支付宝2 账户支付3
     */
    public Integer getPayType() {
        return payType;
    }

    /**
     * 支付类型 微信1 支付宝2 账户支付3
     * @param payType 支付类型 微信1 支付宝2 账户支付3
     */
    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    /**
     * 
     * @return detail_title 
     */
    public String getDetailTitle() {
        return detailTitle;
    }

    /**
     * 
     * @param detailTitle 
     */
    public void setDetailTitle(String detailTitle) {
        this.detailTitle = detailTitle == null ? null : detailTitle.trim();
    }

    /**
     * 
     * @return detail_desc 
     */
    public String getDetailDesc() {
        return detailDesc;
    }

    /**
     * 
     * @param detailDesc 
     */
    public void setDetailDesc(String detailDesc) {
        this.detailDesc = detailDesc == null ? null : detailDesc.trim();
    }

    /**
     * 
     * @return asset_id 
     */
    public String getAssetId() {
        return assetId;
    }

    /**
     * 
     * @param assetId 
     */
    public void setAssetId(String assetId) {
        this.assetId = assetId == null ? null : assetId.trim();
    }

    /**
     * 
     * @return orig_amount 
     */
    public BigDecimal getOrigAmount() {
        return origAmount;
    }

    /**
     * 
     * @param origAmount 
     */
    public void setOrigAmount(BigDecimal origAmount) {
        this.origAmount = origAmount;
    }

    /**
     * 
     * @return wait_pay_amount 
     */
    public BigDecimal getWaitPayAmount() {
        return waitPayAmount;
    }

    /**
     * 
     * @param waitPayAmount 
     */
    public void setWaitPayAmount(BigDecimal waitPayAmount) {
        this.waitPayAmount = waitPayAmount;
    }

    /**
     * 支付完成时间
     * @return pay_result_time 支付完成时间
     */
    public Date getPayResultTime() {
        return payResultTime;
    }

    /**
     * 支付完成时间
     * @param payResultTime 支付完成时间
     */
    public void setPayResultTime(Date payResultTime) {
        this.payResultTime = payResultTime;
    }

    /**
     * 支付状态，1：等待支付，2：支付中，3：支付成功，4：支付失败 
     * @return pay_status 支付状态，1：等待支付，2：支付中，3：支付成功，4：支付失败 
     */
    public Integer getPayStatus() {
        return payStatus;
    }

    /**
     * 支付状态，1：等待支付，2：支付中，3：支付成功，4：支付失败 
     * @param payStatus 支付状态，1：等待支付，2：支付中，3：支付成功，4：支付失败 
     */
    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
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
     * 操作人
     * @return operator 操作人
     */
    public String getOperator() {
        return operator;
    }

    /**
     * 操作人
     * @param operator 操作人
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    /**
     * 
     * @return version 
     */
    public Long getVersion() {
        return version;
    }

    /**
     * 
     * @param version 
     */
    public void setVersion(Long version) {
        this.version = version;
    }
}