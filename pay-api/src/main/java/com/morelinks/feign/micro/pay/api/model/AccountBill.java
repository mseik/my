package com.morelinks.feign.micro.pay.api.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述:account_bill表的实体类
 * @version
 */
public class AccountBill {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer accountId;

    /**
     * 
     */
    private BigDecimal amount;

    /**
     * 收入或者支出 0:默认 1：收入 2：支出
     */
    private Integer inOutType;

    /**
     * 
     */
    private String title;

    /**
     * 
     */
    private String remark;

    /**
     * 
     */
    private String operator;

    /**
     * 
     */
    private String payOrderId;

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
     * 
     * @return account_id 
     */
    public Integer getAccountId() {
        return accountId;
    }

    /**
     * 
     * @param accountId 
     */
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    /**
     * 
     * @return amount 
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 
     * @param amount 
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 收入或者支出 0:默认 1：收入 2：支出
     * @return in_out_type 收入或者支出 0:默认 1：收入 2：支出
     */
    public Integer getInOutType() {
        return inOutType;
    }

    /**
     * 收入或者支出 0:默认 1：收入 2：支出
     * @param inOutType 收入或者支出 0:默认 1：收入 2：支出
     */
    public void setInOutType(Integer inOutType) {
        this.inOutType = inOutType;
    }

    /**
     * 
     * @return title 
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title 
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
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
     * @return operator 
     */
    public String getOperator() {
        return operator;
    }

    /**
     * 
     * @param operator 
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
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