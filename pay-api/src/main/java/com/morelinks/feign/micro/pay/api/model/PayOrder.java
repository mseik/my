package com.morelinks.feign.micro.pay.api.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述:pay_order表的实体类
 * @version
 */
public class PayOrder {
    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String merchantOrderId;

    /**
     * 1:代理商订单 2：充值订单
     */
    private Integer orderType;

    /**
     * 
     */
    private BigDecimal origAmount;

    /**
     * 
     */
    private BigDecimal waitPayAmount;

    /**
     * 交易名称
     */
    private String orderTitle;

    /**
     * 支付完成时间
     */
    private Date paySuccessTime;

    /**
     * 订单状态：1：订单创建 2：支付确认（进行券码折扣余额等操作） 3：等待支付 4：部分支付 5：支付成功 6：支付失败 7:交易成功（即金额相关确认等）8:交易失败 
     */
    private Integer orderStatus;

    /**
     * 
     */
    private String appName;

    /**
     * 操作人
     */
    private String operator;

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
    private String orderDesc;

    /**
     * 支出账户
     */
    private Integer outAccountId;

    /**
     * 收入账户
     */
    private Integer inAccountId;

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
     * @return merchant_order_id 
     */
    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    /**
     * 
     * @param merchantOrderId 
     */
    public void setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId == null ? null : merchantOrderId.trim();
    }

    /**
     * 1:代理商订单 2：充值订单
     * @return order_type 1:代理商订单 2：充值订单
     */
    public Integer getOrderType() {
        return orderType;
    }

    /**
     * 1:代理商订单 2：充值订单
     * @param orderType 1:代理商订单 2：充值订单
     */
    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
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
     * 交易名称
     * @return order_title 交易名称
     */
    public String getOrderTitle() {
        return orderTitle;
    }

    /**
     * 交易名称
     * @param orderTitle 交易名称
     */
    public void setOrderTitle(String orderTitle) {
        this.orderTitle = orderTitle == null ? null : orderTitle.trim();
    }

    /**
     * 支付完成时间
     * @return pay_success_time 支付完成时间
     */
    public Date getPaySuccessTime() {
        return paySuccessTime;
    }

    /**
     * 支付完成时间
     * @param paySuccessTime 支付完成时间
     */
    public void setPaySuccessTime(Date paySuccessTime) {
        this.paySuccessTime = paySuccessTime;
    }

    /**
     * 订单状态：1：订单创建 2：支付确认（进行券码折扣余额等操作） 3：等待支付 4：部分支付 5：支付成功 6：支付失败 7:交易成功（即金额相关确认等）8:交易失败 
     * @return order_status 订单状态：1：订单创建 2：支付确认（进行券码折扣余额等操作） 3：等待支付 4：部分支付 5：支付成功 6：支付失败 7:交易成功（即金额相关确认等）8:交易失败 
     */
    public Integer getOrderStatus() {
        return orderStatus;
    }

    /**
     * 订单状态：1：订单创建 2：支付确认（进行券码折扣余额等操作） 3：等待支付 4：部分支付 5：支付成功 6：支付失败 7:交易成功（即金额相关确认等）8:交易失败 
     * @param orderStatus 订单状态：1：订单创建 2：支付确认（进行券码折扣余额等操作） 3：等待支付 4：部分支付 5：支付成功 6：支付失败 7:交易成功（即金额相关确认等）8:交易失败 
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * 
     * @return app_name 
     */
    public String getAppName() {
        return appName;
    }

    /**
     * 
     * @param appName 
     */
    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
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
     * @return order_desc 
     */
    public String getOrderDesc() {
        return orderDesc;
    }

    /**
     * 
     * @param orderDesc 
     */
    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc == null ? null : orderDesc.trim();
    }

    /**
     * 支出账户
     * @return out_account_id 支出账户
     */
    public Integer getOutAccountId() {
        return outAccountId;
    }

    /**
     * 支出账户
     * @param outAccountId 支出账户
     */
    public void setOutAccountId(Integer outAccountId) {
        this.outAccountId = outAccountId;
    }

    /**
     * 收入账户
     * @return in_account_id 收入账户
     */
    public Integer getInAccountId() {
        return inAccountId;
    }

    /**
     * 收入账户
     * @param inAccountId 收入账户
     */
    public void setInAccountId(Integer inAccountId) {
        this.inAccountId = inAccountId;
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