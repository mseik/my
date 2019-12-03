package com.morelinks.feign.micro.order.api.model;

import java.util.Date;

/**
 * 描述:agent_order_log表的实体类
 * @version
 */
public class AgentOrderLog {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String orderId;

    /**
     * 日志类型 1：订单显示日志 2：普通记录日志
     */
    private Integer logType;

    /**
     * 
     */
    private Integer oriOrderStatus;

    /**
     * 
     */
    private Integer afterOrderStatus;

    /**
     * 
     */
    private String logContent;

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
    private String modifyRecord;

    /**
     * 
     */
    private String operator;

    /**
     * 操作类型 1：用户 2：系统 3：管理用户
     */
    private Integer operatorType;

    /**
     * 
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
     * 
     * @return order_id 
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 
     * @param orderId 
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * 日志类型 1：订单显示日志 2：普通记录日志
     * @return log_type 日志类型 1：订单显示日志 2：普通记录日志
     */
    public Integer getLogType() {
        return logType;
    }

    /**
     * 日志类型 1：订单显示日志 2：普通记录日志
     * @param logType 日志类型 1：订单显示日志 2：普通记录日志
     */
    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    /**
     * 
     * @return ori_order_status 
     */
    public Integer getOriOrderStatus() {
        return oriOrderStatus;
    }

    /**
     * 
     * @param oriOrderStatus 
     */
    public void setOriOrderStatus(Integer oriOrderStatus) {
        this.oriOrderStatus = oriOrderStatus;
    }

    /**
     * 
     * @return after_order_status 
     */
    public Integer getAfterOrderStatus() {
        return afterOrderStatus;
    }

    /**
     * 
     * @param afterOrderStatus 
     */
    public void setAfterOrderStatus(Integer afterOrderStatus) {
        this.afterOrderStatus = afterOrderStatus;
    }

    /**
     * 
     * @return log_content 
     */
    public String getLogContent() {
        return logContent;
    }

    /**
     * 
     * @param logContent 
     */
    public void setLogContent(String logContent) {
        this.logContent = logContent == null ? null : logContent.trim();
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
     * @return modify_record 
     */
    public String getModifyRecord() {
        return modifyRecord;
    }

    /**
     * 
     * @param modifyRecord 
     */
    public void setModifyRecord(String modifyRecord) {
        this.modifyRecord = modifyRecord == null ? null : modifyRecord.trim();
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
     * 操作类型 1：用户 2：系统 3：管理用户
     * @return operator_type 操作类型 1：用户 2：系统 3：管理用户
     */
    public Integer getOperatorType() {
        return operatorType;
    }

    /**
     * 操作类型 1：用户 2：系统 3：管理用户
     * @param operatorType 操作类型 1：用户 2：系统 3：管理用户
     */
    public void setOperatorType(Integer operatorType) {
        this.operatorType = operatorType;
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
}