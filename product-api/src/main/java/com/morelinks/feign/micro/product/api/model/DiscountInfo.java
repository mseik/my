package com.morelinks.feign.micro.product.api.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述:discount_info表的实体类
 * @version
 */
public class DiscountInfo {
    /**
     * 
     */
    private Integer id;

    /**
     * 折扣类型 1：产品折扣 2：归类折扣 3:会员折扣 4：品牌折扣
     */
    private Integer discountType;

    /**
     * 折扣的关键词
     */
    private String discountKey;

    /**
     * 可用的会员最低级别
     */
    private Integer memberMinLevel;

    /**
     * 可用的会员最高级别
     */
    private Integer memberMaxLevel;

    /**
     * 
     */
    private Date validStartTime;

    /**
     * 
     */
    private Date validEndTime;

    /**
     * 折扣状态 1：创建 2：有效 3：无效
     */
    private Integer discountStatus;

    /**
     * 
     */
    private String createUser;

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
    private String discountName;

    /**
     * 
     */
    private String remark;

    /**
     * 满减能用的次数
     */
    private Integer discountNum;

    /**
     * 所折扣的金额 比如8折 为20
     */
    private BigDecimal discountAmount;

    /**
     * 满足条件的金额
     */
    private BigDecimal conditionAmount;

    /**
     * 折扣条件类型  1：折扣 2：满减
     */
    private Integer conditionType;

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
     * 折扣类型 1：产品折扣 2：归类折扣 3:会员折扣 4：品牌折扣
     * @return discount_type 折扣类型 1：产品折扣 2：归类折扣 3:会员折扣 4：品牌折扣
     */
    public Integer getDiscountType() {
        return discountType;
    }

    /**
     * 折扣类型 1：产品折扣 2：归类折扣 3:会员折扣 4：品牌折扣
     * @param discountType 折扣类型 1：产品折扣 2：归类折扣 3:会员折扣 4：品牌折扣
     */
    public void setDiscountType(Integer discountType) {
        this.discountType = discountType;
    }

    /**
     * 折扣的关键词
     * @return discount_key 折扣的关键词
     */
    public String getDiscountKey() {
        return discountKey;
    }

    /**
     * 折扣的关键词
     * @param discountKey 折扣的关键词
     */
    public void setDiscountKey(String discountKey) {
        this.discountKey = discountKey == null ? null : discountKey.trim();
    }

    /**
     * 可用的会员最低级别
     * @return member_min_level 可用的会员最低级别
     */
    public Integer getMemberMinLevel() {
        return memberMinLevel;
    }

    /**
     * 可用的会员最低级别
     * @param memberMinLevel 可用的会员最低级别
     */
    public void setMemberMinLevel(Integer memberMinLevel) {
        this.memberMinLevel = memberMinLevel;
    }

    /**
     * 可用的会员最高级别
     * @return member_max_level 可用的会员最高级别
     */
    public Integer getMemberMaxLevel() {
        return memberMaxLevel;
    }

    /**
     * 可用的会员最高级别
     * @param memberMaxLevel 可用的会员最高级别
     */
    public void setMemberMaxLevel(Integer memberMaxLevel) {
        this.memberMaxLevel = memberMaxLevel;
    }

    /**
     * 
     * @return valid_start_time 
     */
    public Date getValidStartTime() {
        return validStartTime;
    }

    /**
     * 
     * @param validStartTime 
     */
    public void setValidStartTime(Date validStartTime) {
        this.validStartTime = validStartTime;
    }

    /**
     * 
     * @return valid_end_time 
     */
    public Date getValidEndTime() {
        return validEndTime;
    }

    /**
     * 
     * @param validEndTime 
     */
    public void setValidEndTime(Date validEndTime) {
        this.validEndTime = validEndTime;
    }

    /**
     * 折扣状态 1：创建 2：有效 3：无效
     * @return discount_status 折扣状态 1：创建 2：有效 3：无效
     */
    public Integer getDiscountStatus() {
        return discountStatus;
    }

    /**
     * 折扣状态 1：创建 2：有效 3：无效
     * @param discountStatus 折扣状态 1：创建 2：有效 3：无效
     */
    public void setDiscountStatus(Integer discountStatus) {
        this.discountStatus = discountStatus;
    }

    /**
     * 
     * @return create_user 
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 
     * @param createUser 
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
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
     * @return discount_name 
     */
    public String getDiscountName() {
        return discountName;
    }

    /**
     * 
     * @param discountName 
     */
    public void setDiscountName(String discountName) {
        this.discountName = discountName == null ? null : discountName.trim();
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
     * 满减能用的次数
     * @return discount_num 满减能用的次数
     */
    public Integer getDiscountNum() {
        return discountNum;
    }

    /**
     * 满减能用的次数
     * @param discountNum 满减能用的次数
     */
    public void setDiscountNum(Integer discountNum) {
        this.discountNum = discountNum;
    }

    /**
     * 所折扣的金额 比如8折 为20
     * @return discount_amount 所折扣的金额 比如8折 为20
     */
    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    /**
     * 所折扣的金额 比如8折 为20
     * @param discountAmount 所折扣的金额 比如8折 为20
     */
    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    /**
     * 满足条件的金额
     * @return condition_amount 满足条件的金额
     */
    public BigDecimal getConditionAmount() {
        return conditionAmount;
    }

    /**
     * 满足条件的金额
     * @param conditionAmount 满足条件的金额
     */
    public void setConditionAmount(BigDecimal conditionAmount) {
        this.conditionAmount = conditionAmount;
    }

    /**
     * 折扣条件类型  1：折扣 2：满减
     * @return condition_type 折扣条件类型  1：折扣 2：满减
     */
    public Integer getConditionType() {
        return conditionType;
    }

    /**
     * 折扣条件类型  1：折扣 2：满减
     * @param conditionType 折扣条件类型  1：折扣 2：满减
     */
    public void setConditionType(Integer conditionType) {
        this.conditionType = conditionType;
    }
}