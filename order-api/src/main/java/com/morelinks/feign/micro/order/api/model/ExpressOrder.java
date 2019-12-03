package com.morelinks.feign.micro.order.api.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述:express_order表的实体类
 * @version
 */
public class ExpressOrder {
    /**
     * 
     */
    private Integer id;

    /**
     * 订单类型
     */
    private String orderId;

    /**
     * 订单类型 1：代理商订单 2：采购订单
     */
    private Integer orderType;

    /**
     * 快递公司Id
     */
    private Integer expressId;

    /**
     * 快递单号
     */
    private String expressNo;

    /**
     * 付款方式 1：已支付 2：货到付款
     */
    private Integer payType;

    /**
     * 配送金额
     */
    private BigDecimal expressAmount;

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
     * 快递状态 0：添加 1：已发出 快递公司收货 2：已收货 客户已收到 3：未收到货 快递出错
     */
    private Integer expressStatus;

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
     * 订单类型
     * @return order_id 订单类型
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 订单类型
     * @param orderId 订单类型
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * 订单类型 1：代理商订单 2：采购订单
     * @return order_type 订单类型 1：代理商订单 2：采购订单
     */
    public Integer getOrderType() {
        return orderType;
    }

    /**
     * 订单类型 1：代理商订单 2：采购订单
     * @param orderType 订单类型 1：代理商订单 2：采购订单
     */
    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    /**
     * 快递公司Id
     * @return express_id 快递公司Id
     */
    public Integer getExpressId() {
        return expressId;
    }

    /**
     * 快递公司Id
     * @param expressId 快递公司Id
     */
    public void setExpressId(Integer expressId) {
        this.expressId = expressId;
    }

    /**
     * 快递单号
     * @return express_no 快递单号
     */
    public String getExpressNo() {
        return expressNo;
    }

    /**
     * 快递单号
     * @param expressNo 快递单号
     */
    public void setExpressNo(String expressNo) {
        this.expressNo = expressNo == null ? null : expressNo.trim();
    }

    /**
     * 付款方式 1：已支付 2：货到付款
     * @return pay_type 付款方式 1：已支付 2：货到付款
     */
    public Integer getPayType() {
        return payType;
    }

    /**
     * 付款方式 1：已支付 2：货到付款
     * @param payType 付款方式 1：已支付 2：货到付款
     */
    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    /**
     * 配送金额
     * @return express_amount 配送金额
     */
    public BigDecimal getExpressAmount() {
        return expressAmount;
    }

    /**
     * 配送金额
     * @param expressAmount 配送金额
     */
    public void setExpressAmount(BigDecimal expressAmount) {
        this.expressAmount = expressAmount;
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
     * 快递状态 0：添加 1：已发出 快递公司收货 2：已收货 客户已收到 3：未收到货 快递出错
     * @return express_status 快递状态 0：添加 1：已发出 快递公司收货 2：已收货 客户已收到 3：未收到货 快递出错
     */
    public Integer getExpressStatus() {
        return expressStatus;
    }

    /**
     * 快递状态 0：添加 1：已发出 快递公司收货 2：已收货 客户已收到 3：未收到货 快递出错
     * @param expressStatus 快递状态 0：添加 1：已发出 快递公司收货 2：已收货 客户已收到 3：未收到货 快递出错
     */
    public void setExpressStatus(Integer expressStatus) {
        this.expressStatus = expressStatus;
    }
}