package com.morelinks.feign.micro.order.api.model;

import java.math.BigDecimal;

/**
 * 描述:config_order_discount_info表的实体类
 * @version
 */
public class ConfigOrderDiscountInfo {
    /**
     * 
     */
    private Integer id;

    /**
     * 代理商Id 0：代表所有 
     */
    private Integer agentId;

    /**
     * 配单Id
     */
    private String configOrderId;

    /**
     * 折扣的类别 1：百分比 2：固定金额
     */
    private Integer conditionType;

    /**
     * 折扣的对象 0:不匹配即所有 1：产品类别 2：产品
     */
    private Integer discountType;

    /**
     * 匹配关键词
     */
    private String discountKey;

    /**
     * 百分比的时候 为百分位数据 固定金额时为金额数据
     */
    private BigDecimal conditionAmount;

    /**
     * 1:默认 2：代理商默认 3：具体订单
     */
    private Integer fromType;

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
     * 代理商Id 0：代表所有 
     * @return agent_id 代理商Id 0：代表所有 
     */
    public Integer getAgentId() {
        return agentId;
    }

    /**
     * 代理商Id 0：代表所有 
     * @param agentId 代理商Id 0：代表所有 
     */
    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    /**
     * 配单Id
     * @return config_order_id 配单Id
     */
    public String getConfigOrderId() {
        return configOrderId;
    }

    /**
     * 配单Id
     * @param configOrderId 配单Id
     */
    public void setConfigOrderId(String configOrderId) {
        this.configOrderId = configOrderId == null ? null : configOrderId.trim();
    }

    /**
     * 折扣的类别 1：百分比 2：固定金额
     * @return condition_type 折扣的类别 1：百分比 2：固定金额
     */
    public Integer getConditionType() {
        return conditionType;
    }

    /**
     * 折扣的类别 1：百分比 2：固定金额
     * @param conditionType 折扣的类别 1：百分比 2：固定金额
     */
    public void setConditionType(Integer conditionType) {
        this.conditionType = conditionType;
    }

    /**
     * 折扣的对象 0:不匹配即所有 1：产品类别 2：产品
     * @return discount_type 折扣的对象 0:不匹配即所有 1：产品类别 2：产品
     */
    public Integer getDiscountType() {
        return discountType;
    }

    /**
     * 折扣的对象 0:不匹配即所有 1：产品类别 2：产品
     * @param discountType 折扣的对象 0:不匹配即所有 1：产品类别 2：产品
     */
    public void setDiscountType(Integer discountType) {
        this.discountType = discountType;
    }

    /**
     * 匹配关键词
     * @return discount_key 匹配关键词
     */
    public String getDiscountKey() {
        return discountKey;
    }

    /**
     * 匹配关键词
     * @param discountKey 匹配关键词
     */
    public void setDiscountKey(String discountKey) {
        this.discountKey = discountKey == null ? null : discountKey.trim();
    }

    /**
     * 百分比的时候 为百分位数据 固定金额时为金额数据
     * @return condition_amount 百分比的时候 为百分位数据 固定金额时为金额数据
     */
    public BigDecimal getConditionAmount() {
        return conditionAmount;
    }

    /**
     * 百分比的时候 为百分位数据 固定金额时为金额数据
     * @param conditionAmount 百分比的时候 为百分位数据 固定金额时为金额数据
     */
    public void setConditionAmount(BigDecimal conditionAmount) {
        this.conditionAmount = conditionAmount;
    }

    /**
     * 1:默认 2：代理商默认 3：具体订单
     * @return from_type 1:默认 2：代理商默认 3：具体订单
     */
    public Integer getFromType() {
        return fromType;
    }

    /**
     * 1:默认 2：代理商默认 3：具体订单
     * @param fromType 1:默认 2：代理商默认 3：具体订单
     */
    public void setFromType(Integer fromType) {
        this.fromType = fromType;
    }
}