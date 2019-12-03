package com.morelinks.feign.micro.order.api.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述:agent_order表的实体类
 * @version
 */
public class AgentOrder {
    /**
     * 
     */
    private String id;

    /**
     * 代理商Id
     */
    private Integer agentId;

    /**
     * 用户Id
     */
    private String userId;

    /**
     * 订单类型:0：普通订单 1:项目订单 
     */
    private Integer orderType;

    /**
     * 原始金额
     */
    private BigDecimal oriAmount;

    /**
     * 折扣总金额
     */
    private BigDecimal discountAmount;

    /**
     * 核心货款修改
     */
    private BigDecimal goodsModifyAmount;

    /**
     * 通用金额修改
     */
    private BigDecimal commonModifyAmount;

    /**
     * 订单最终总金额
     */
    private BigDecimal orderAmount;

    /**
     * 订单状态：1：下单 2：等待发货 3：等待收货 4：订单完成 5：订单取消
     */
    private Integer orderStatus;

    /**
     * 订单来源：1.后台下单	
     */
    private Integer fromType;

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
     * 支付方式 1：线下转账 2：线上付款
     */
    private Integer payType;

    /**
     * 支付成功的时间
     */
    private Date paySuccessTime;

    /**
     * 支付状态 0：待支付 1：正在支付 2：已支付
     */
    private Integer payStatus;

    /**
     * 收货时间
     */
    private Date receiptTime;

    /**
     * 发货时间
     */
    private Date sendTime;

    /**
     * 配送地址Id
     */
    private Integer deliveryAddressId;

    /**
     * 
     */
    private String deliveryUserName;

    /**
     * 
     */
    private String deliveryCityId;

    /**
     * 
     */
    private String deliveryContactTel;

    /**
     * 
     */
    private String deliveryAddress;

    /**
     * 
     */
    private Long version;

    /**
     * 
     */
    private BigDecimal goodsAmount;

    /**
     * 
     */
    private BigDecimal commonAmount;

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
     * 代理商Id
     * @return agent_id 代理商Id
     */
    public Integer getAgentId() {
        return agentId;
    }

    /**
     * 代理商Id
     * @param agentId 代理商Id
     */
    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    /**
     * 用户Id
     * @return user_id 用户Id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 用户Id
     * @param userId 用户Id
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 订单类型:0：普通订单 1:项目订单 
     * @return order_type 订单类型:0：普通订单 1:项目订单 
     */
    public Integer getOrderType() {
        return orderType;
    }

    /**
     * 订单类型:0：普通订单 1:项目订单 
     * @param orderType 订单类型:0：普通订单 1:项目订单 
     */
    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
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
     * 折扣总金额
     * @return discount_amount 折扣总金额
     */
    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    /**
     * 折扣总金额
     * @param discountAmount 折扣总金额
     */
    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    /**
     * 核心货款修改
     * @return goods_modify_amount 核心货款修改
     */
    public BigDecimal getGoodsModifyAmount() {
        return goodsModifyAmount;
    }

    /**
     * 核心货款修改
     * @param goodsModifyAmount 核心货款修改
     */
    public void setGoodsModifyAmount(BigDecimal goodsModifyAmount) {
        this.goodsModifyAmount = goodsModifyAmount;
    }

    /**
     * 通用金额修改
     * @return common_modify_amount 通用金额修改
     */
    public BigDecimal getCommonModifyAmount() {
        return commonModifyAmount;
    }

    /**
     * 通用金额修改
     * @param commonModifyAmount 通用金额修改
     */
    public void setCommonModifyAmount(BigDecimal commonModifyAmount) {
        this.commonModifyAmount = commonModifyAmount;
    }

    /**
     * 订单最终总金额
     * @return order_amount 订单最终总金额
     */
    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    /**
     * 订单最终总金额
     * @param orderAmount 订单最终总金额
     */
    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    /**
     * 订单状态：1：下单 2：等待发货 3：等待收货 4：订单完成 5：订单取消
     * @return order_status 订单状态：1：下单 2：等待发货 3：等待收货 4：订单完成 5：订单取消
     */
    public Integer getOrderStatus() {
        return orderStatus;
    }

    /**
     * 订单状态：1：下单 2：等待发货 3：等待收货 4：订单完成 5：订单取消
     * @param orderStatus 订单状态：1：下单 2：等待发货 3：等待收货 4：订单完成 5：订单取消
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * 订单来源：1.后台下单	
     * @return from_type 订单来源：1.后台下单	
     */
    public Integer getFromType() {
        return fromType;
    }

    /**
     * 订单来源：1.后台下单	
     * @param fromType 订单来源：1.后台下单	
     */
    public void setFromType(Integer fromType) {
        this.fromType = fromType;
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
     * 支付方式 1：线下转账 2：线上付款
     * @return pay_type 支付方式 1：线下转账 2：线上付款
     */
    public Integer getPayType() {
        return payType;
    }

    /**
     * 支付方式 1：线下转账 2：线上付款
     * @param payType 支付方式 1：线下转账 2：线上付款
     */
    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    /**
     * 支付成功的时间
     * @return pay_success_time 支付成功的时间
     */
    public Date getPaySuccessTime() {
        return paySuccessTime;
    }

    /**
     * 支付成功的时间
     * @param paySuccessTime 支付成功的时间
     */
    public void setPaySuccessTime(Date paySuccessTime) {
        this.paySuccessTime = paySuccessTime;
    }

    /**
     * 支付状态 0：待支付 1：正在支付 2：已支付
     * @return pay_status 支付状态 0：待支付 1：正在支付 2：已支付
     */
    public Integer getPayStatus() {
        return payStatus;
    }

    /**
     * 支付状态 0：待支付 1：正在支付 2：已支付
     * @param payStatus 支付状态 0：待支付 1：正在支付 2：已支付
     */
    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    /**
     * 收货时间
     * @return receipt_time 收货时间
     */
    public Date getReceiptTime() {
        return receiptTime;
    }

    /**
     * 收货时间
     * @param receiptTime 收货时间
     */
    public void setReceiptTime(Date receiptTime) {
        this.receiptTime = receiptTime;
    }

    /**
     * 发货时间
     * @return send_time 发货时间
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * 发货时间
     * @param sendTime 发货时间
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * 配送地址Id
     * @return delivery_address_id 配送地址Id
     */
    public Integer getDeliveryAddressId() {
        return deliveryAddressId;
    }

    /**
     * 配送地址Id
     * @param deliveryAddressId 配送地址Id
     */
    public void setDeliveryAddressId(Integer deliveryAddressId) {
        this.deliveryAddressId = deliveryAddressId;
    }

    /**
     * 
     * @return delivery_user_name 
     */
    public String getDeliveryUserName() {
        return deliveryUserName;
    }

    /**
     * 
     * @param deliveryUserName 
     */
    public void setDeliveryUserName(String deliveryUserName) {
        this.deliveryUserName = deliveryUserName == null ? null : deliveryUserName.trim();
    }

    /**
     * 
     * @return delivery_city_id 
     */
    public String getDeliveryCityId() {
        return deliveryCityId;
    }

    /**
     * 
     * @param deliveryCityId 
     */
    public void setDeliveryCityId(String deliveryCityId) {
        this.deliveryCityId = deliveryCityId == null ? null : deliveryCityId.trim();
    }

    /**
     * 
     * @return delivery_contact_tel 
     */
    public String getDeliveryContactTel() {
        return deliveryContactTel;
    }

    /**
     * 
     * @param deliveryContactTel 
     */
    public void setDeliveryContactTel(String deliveryContactTel) {
        this.deliveryContactTel = deliveryContactTel == null ? null : deliveryContactTel.trim();
    }

    /**
     * 
     * @return delivery_address 
     */
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    /**
     * 
     * @param deliveryAddress 
     */
    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress == null ? null : deliveryAddress.trim();
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

    /**
     * 
     * @return goods_amount 
     */
    public BigDecimal getGoodsAmount() {
        return goodsAmount;
    }

    /**
     * 
     * @param goodsAmount 
     */
    public void setGoodsAmount(BigDecimal goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    /**
     * 
     * @return common_amount 
     */
    public BigDecimal getCommonAmount() {
        return commonAmount;
    }

    /**
     * 
     * @param commonAmount 
     */
    public void setCommonAmount(BigDecimal commonAmount) {
        this.commonAmount = commonAmount;
    }
}