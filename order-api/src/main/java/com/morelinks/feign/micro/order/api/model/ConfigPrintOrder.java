package com.morelinks.feign.micro.order.api.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述:config_print_order表的实体类
 * @version
 */
public class ConfigPrintOrder {
    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private Integer agentId;

    /**
     * 
     */
    private Integer userId;

    /**
     * 项目Id
     */
    private String projectId;

    /**
     * 功能Id列表 以逗号分隔
     */
    private String configCategoryIds;

    /**
     * 订单状态 0：添加 1：正在报价 2：已报价 3：成功 4：失败
     */
    private Integer orderStatus;

    /**
     * 设备总价
     */
    private BigDecimal oriMount;

    /**
     * 最终价格 即成交价格
     */
    private BigDecimal finalAmount;

    /**
     * 折扣类型 1：百分比 2：固定金额
     */
    private Integer discountType;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 安装费 收费类别 1：参与折扣 2：不参与折扣 3：按类别
     */
    private Integer installAmountType;

    /**
     * 调试费 收费类别 1：参与折扣 2：不参与折扣 3：按类别
     */
    private Integer debugAmountType;

    /**
     * 增值税费 收费类别 1：默认 2：自定义
     */
    private Integer taxAmountType;

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
     * @return agent_id 
     */
    public Integer getAgentId() {
        return agentId;
    }

    /**
     * 
     * @param agentId 
     */
    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    /**
     * 
     * @return user_id 
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 
     * @param userId 
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 项目Id
     * @return project_id 项目Id
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * 项目Id
     * @param projectId 项目Id
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    /**
     * 功能Id列表 以逗号分隔
     * @return config_category_ids 功能Id列表 以逗号分隔
     */
    public String getConfigCategoryIds() {
        return configCategoryIds;
    }

    /**
     * 功能Id列表 以逗号分隔
     * @param configCategoryIds 功能Id列表 以逗号分隔
     */
    public void setConfigCategoryIds(String configCategoryIds) {
        this.configCategoryIds = configCategoryIds == null ? null : configCategoryIds.trim();
    }

    /**
     * 订单状态 0：添加 1：正在报价 2：已报价 3：成功 4：失败
     * @return order_status 订单状态 0：添加 1：正在报价 2：已报价 3：成功 4：失败
     */
    public Integer getOrderStatus() {
        return orderStatus;
    }

    /**
     * 订单状态 0：添加 1：正在报价 2：已报价 3：成功 4：失败
     * @param orderStatus 订单状态 0：添加 1：正在报价 2：已报价 3：成功 4：失败
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * 设备总价
     * @return ori_mount 设备总价
     */
    public BigDecimal getOriMount() {
        return oriMount;
    }

    /**
     * 设备总价
     * @param oriMount 设备总价
     */
    public void setOriMount(BigDecimal oriMount) {
        this.oriMount = oriMount;
    }

    /**
     * 最终价格 即成交价格
     * @return final_amount 最终价格 即成交价格
     */
    public BigDecimal getFinalAmount() {
        return finalAmount;
    }

    /**
     * 最终价格 即成交价格
     * @param finalAmount 最终价格 即成交价格
     */
    public void setFinalAmount(BigDecimal finalAmount) {
        this.finalAmount = finalAmount;
    }

    /**
     * 折扣类型 1：百分比 2：固定金额
     * @return discount_type 折扣类型 1：百分比 2：固定金额
     */
    public Integer getDiscountType() {
        return discountType;
    }

    /**
     * 折扣类型 1：百分比 2：固定金额
     * @param discountType 折扣类型 1：百分比 2：固定金额
     */
    public void setDiscountType(Integer discountType) {
        this.discountType = discountType;
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
     * 安装费 收费类别 1：参与折扣 2：不参与折扣 3：按类别
     * @return install_amount_type 安装费 收费类别 1：参与折扣 2：不参与折扣 3：按类别
     */
    public Integer getInstallAmountType() {
        return installAmountType;
    }

    /**
     * 安装费 收费类别 1：参与折扣 2：不参与折扣 3：按类别
     * @param installAmountType 安装费 收费类别 1：参与折扣 2：不参与折扣 3：按类别
     */
    public void setInstallAmountType(Integer installAmountType) {
        this.installAmountType = installAmountType;
    }

    /**
     * 调试费 收费类别 1：参与折扣 2：不参与折扣 3：按类别
     * @return debug_amount_type 调试费 收费类别 1：参与折扣 2：不参与折扣 3：按类别
     */
    public Integer getDebugAmountType() {
        return debugAmountType;
    }

    /**
     * 调试费 收费类别 1：参与折扣 2：不参与折扣 3：按类别
     * @param debugAmountType 调试费 收费类别 1：参与折扣 2：不参与折扣 3：按类别
     */
    public void setDebugAmountType(Integer debugAmountType) {
        this.debugAmountType = debugAmountType;
    }

    /**
     * 增值税费 收费类别 1：默认 2：自定义
     * @return tax_amount_type 增值税费 收费类别 1：默认 2：自定义
     */
    public Integer getTaxAmountType() {
        return taxAmountType;
    }

    /**
     * 增值税费 收费类别 1：默认 2：自定义
     * @param taxAmountType 增值税费 收费类别 1：默认 2：自定义
     */
    public void setTaxAmountType(Integer taxAmountType) {
        this.taxAmountType = taxAmountType;
    }
}