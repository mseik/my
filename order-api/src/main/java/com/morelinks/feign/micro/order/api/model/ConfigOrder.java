package com.morelinks.feign.micro.order.api.model;

import java.util.Date;

/**
 * 描述:config_order表的实体类
 * @version
 */
public class ConfigOrder {
    /**
     * 
     */
    private String id;

    /**
     * 代理商Id
     */
    private Integer agentId;

    /**
     * 代理商用户Id
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
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 成交订单Id
     */
    private String configPrintOrderId;

    /**
     * 配单名称
     */
    private String orderName;

    /**
     * 城市Id
     */
    private String cityId;

    /**
     * 项目地址 除却城市之后的详细地址
     */
    private String projectAddress;

    /**
     * 
     */
    private String customerName;

    /**
     * 顾客电话
     */
    private String customerTel;

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
     * 是否删除 
     */
    private Byte delStatus;

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
     * 代理商用户Id
     * @return user_id 代理商用户Id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 代理商用户Id
     * @param userId 代理商用户Id
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
     * 成交订单Id
     * @return config_print_order_id 成交订单Id
     */
    public String getConfigPrintOrderId() {
        return configPrintOrderId;
    }

    /**
     * 成交订单Id
     * @param configPrintOrderId 成交订单Id
     */
    public void setConfigPrintOrderId(String configPrintOrderId) {
        this.configPrintOrderId = configPrintOrderId == null ? null : configPrintOrderId.trim();
    }

    /**
     * 配单名称
     * @return order_name 配单名称
     */
    public String getOrderName() {
        return orderName;
    }

    /**
     * 配单名称
     * @param orderName 配单名称
     */
    public void setOrderName(String orderName) {
        this.orderName = orderName == null ? null : orderName.trim();
    }

    /**
     * 城市Id
     * @return city_id 城市Id
     */
    public String getCityId() {
        return cityId;
    }

    /**
     * 城市Id
     * @param cityId 城市Id
     */
    public void setCityId(String cityId) {
        this.cityId = cityId == null ? null : cityId.trim();
    }

    /**
     * 项目地址 除却城市之后的详细地址
     * @return project_address 项目地址 除却城市之后的详细地址
     */
    public String getProjectAddress() {
        return projectAddress;
    }

    /**
     * 项目地址 除却城市之后的详细地址
     * @param projectAddress 项目地址 除却城市之后的详细地址
     */
    public void setProjectAddress(String projectAddress) {
        this.projectAddress = projectAddress == null ? null : projectAddress.trim();
    }

    /**
     * 
     * @return customer_name 
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * 
     * @param customerName 
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    /**
     * 顾客电话
     * @return customer_tel 顾客电话
     */
    public String getCustomerTel() {
        return customerTel;
    }

    /**
     * 顾客电话
     * @param customerTel 顾客电话
     */
    public void setCustomerTel(String customerTel) {
        this.customerTel = customerTel == null ? null : customerTel.trim();
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

    /**
     * 是否删除 
     * @return del_status 是否删除 
     */
    public Byte getDelStatus() {
        return delStatus;
    }

    /**
     * 是否删除 
     * @param delStatus 是否删除 
     */
    public void setDelStatus(Byte delStatus) {
        this.delStatus = delStatus;
    }
}