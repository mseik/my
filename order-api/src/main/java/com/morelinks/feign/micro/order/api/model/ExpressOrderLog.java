package com.morelinks.feign.micro.order.api.model;

import java.util.Date;

/**
 * 描述:express_order_log表的实体类
 * @version
 */
public class ExpressOrderLog {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer expressOrderId;

    /**
     * 
     */
    private String logContent;

    /**
     * 
     */
    private String remark;

    /**
     * 
     */
    private String cityId;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 操作类型 1：用户 2：系统 3：管理用户
     */
    private Integer operatorType;

    /**
     * 
     */
    private String operator;

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
     * @return express_order_id 
     */
    public Integer getExpressOrderId() {
        return expressOrderId;
    }

    /**
     * 
     * @param expressOrderId 
     */
    public void setExpressOrderId(Integer expressOrderId) {
        this.expressOrderId = expressOrderId;
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
     * @return city_id 
     */
    public String getCityId() {
        return cityId;
    }

    /**
     * 
     * @param cityId 
     */
    public void setCityId(String cityId) {
        this.cityId = cityId == null ? null : cityId.trim();
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
}