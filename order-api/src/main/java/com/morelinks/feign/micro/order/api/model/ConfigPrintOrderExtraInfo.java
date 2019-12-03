package com.morelinks.feign.micro.order.api.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述:config_print_order_extra_info表的实体类
 * @version
 */
public class ConfigPrintOrderExtraInfo {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String configOrderId;

    /**
     * 折扣类别 1：设备安装 2：设备调试 3：增值税 4:其他费用
     */
    private Integer extraType;

    /**
     * 折扣的类别 1：参与折扣百分比 2：不参与折扣百分比 3：固定金额
     */
    private Integer conditionType;

    /**
     * 折扣的对象 0:不匹配即所有 1：产品类别 2：产品
     */
    private Integer mapType;

    /**
     * 匹配关键词 
     */
    private String mapKey;

    /**
     * 设置数据 百分比的时候 为百分位数据 固定金额时为金额数据
     */
    private BigDecimal extraAmount;

    /**
     * 
     */
    private String extraName;

    /**
     * 
     */
    private String extraRemark;

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
     * @return config_order_id 
     */
    public String getConfigOrderId() {
        return configOrderId;
    }

    /**
     * 
     * @param configOrderId 
     */
    public void setConfigOrderId(String configOrderId) {
        this.configOrderId = configOrderId == null ? null : configOrderId.trim();
    }

    /**
     * 折扣类别 1：设备安装 2：设备调试 3：增值税 4:其他费用
     * @return extra_type 折扣类别 1：设备安装 2：设备调试 3：增值税 4:其他费用
     */
    public Integer getExtraType() {
        return extraType;
    }

    /**
     * 折扣类别 1：设备安装 2：设备调试 3：增值税 4:其他费用
     * @param extraType 折扣类别 1：设备安装 2：设备调试 3：增值税 4:其他费用
     */
    public void setExtraType(Integer extraType) {
        this.extraType = extraType;
    }

    /**
     * 折扣的类别 1：参与折扣百分比 2：不参与折扣百分比 3：固定金额
     * @return condition_type 折扣的类别 1：参与折扣百分比 2：不参与折扣百分比 3：固定金额
     */
    public Integer getConditionType() {
        return conditionType;
    }

    /**
     * 折扣的类别 1：参与折扣百分比 2：不参与折扣百分比 3：固定金额
     * @param conditionType 折扣的类别 1：参与折扣百分比 2：不参与折扣百分比 3：固定金额
     */
    public void setConditionType(Integer conditionType) {
        this.conditionType = conditionType;
    }

    /**
     * 折扣的对象 0:不匹配即所有 1：产品类别 2：产品
     * @return map_type 折扣的对象 0:不匹配即所有 1：产品类别 2：产品
     */
    public Integer getMapType() {
        return mapType;
    }

    /**
     * 折扣的对象 0:不匹配即所有 1：产品类别 2：产品
     * @param mapType 折扣的对象 0:不匹配即所有 1：产品类别 2：产品
     */
    public void setMapType(Integer mapType) {
        this.mapType = mapType;
    }

    /**
     * 匹配关键词 
     * @return map_key 匹配关键词 
     */
    public String getMapKey() {
        return mapKey;
    }

    /**
     * 匹配关键词 
     * @param mapKey 匹配关键词 
     */
    public void setMapKey(String mapKey) {
        this.mapKey = mapKey == null ? null : mapKey.trim();
    }

    /**
     * 设置数据 百分比的时候 为百分位数据 固定金额时为金额数据
     * @return extra_amount 设置数据 百分比的时候 为百分位数据 固定金额时为金额数据
     */
    public BigDecimal getExtraAmount() {
        return extraAmount;
    }

    /**
     * 设置数据 百分比的时候 为百分位数据 固定金额时为金额数据
     * @param extraAmount 设置数据 百分比的时候 为百分位数据 固定金额时为金额数据
     */
    public void setExtraAmount(BigDecimal extraAmount) {
        this.extraAmount = extraAmount;
    }

    /**
     * 
     * @return extra_name 
     */
    public String getExtraName() {
        return extraName;
    }

    /**
     * 
     * @param extraName 
     */
    public void setExtraName(String extraName) {
        this.extraName = extraName == null ? null : extraName.trim();
    }

    /**
     * 
     * @return extra_remark 
     */
    public String getExtraRemark() {
        return extraRemark;
    }

    /**
     * 
     * @param extraRemark 
     */
    public void setExtraRemark(String extraRemark) {
        this.extraRemark = extraRemark == null ? null : extraRemark.trim();
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