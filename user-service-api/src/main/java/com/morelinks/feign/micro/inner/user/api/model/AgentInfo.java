package com.morelinks.feign.micro.inner.user.api.model;

import java.util.Date;

/**
 * 描述:agent_info表的实体类
 * @version
 */
public class AgentInfo {
    /**
     * 代理商Id
     */
    private Integer id;

    /**
     * 会员级别
     */
    private Integer agentLevel;

    /**
     * 用户可修改的信息
     */
    private String contactEmail;

    /**
     * 
     */
    private String contactTel;

    /**
     * 
     */
    private String companyName;

    /**
     * 
     */
    private String companyAddress;

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
     * 会员等级状态 0:添加 1：有效
     */
    private Integer levelStatus;

    /**
     * 等级结束时间
     */
    private Date levelEndTime;

    /**
     * 等级开始时间
     */
    private Date levelStartTime;

    /**
     * 是否需要票据 1：不需要 其他是需要
     */
    private Integer noTaxBill;

    /**
     * 原有的公司信息 用户不能修改
     */
    private String oriContactEmail;

    /**
     * 
     */
    private String oriContactTel;

    /**
     * 
     */
    private String oriCompanyName;

    /**
     * 
     */
    private String oriCompanyAddress;

    /**
     * 
     */
    private String oriCityId;

    /**
     * 代理商状态 0：添加 1：有效 2：失效
     */
    private Integer agentStatus;

    /**
     * 支付密码
     */
    private String payPassword;

    /**
     * 代理商Id
     * @return id 代理商Id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 代理商Id
     * @param id 代理商Id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 会员级别
     * @return agent_level 会员级别
     */
    public Integer getAgentLevel() {
        return agentLevel;
    }

    /**
     * 会员级别
     * @param agentLevel 会员级别
     */
    public void setAgentLevel(Integer agentLevel) {
        this.agentLevel = agentLevel;
    }

    /**
     * 用户可修改的信息
     * @return contact_email 用户可修改的信息
     */
    public String getContactEmail() {
        return contactEmail;
    }

    /**
     * 用户可修改的信息
     * @param contactEmail 用户可修改的信息
     */
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail == null ? null : contactEmail.trim();
    }

    /**
     * 
     * @return contact_tel 
     */
    public String getContactTel() {
        return contactTel;
    }

    /**
     * 
     * @param contactTel 
     */
    public void setContactTel(String contactTel) {
        this.contactTel = contactTel == null ? null : contactTel.trim();
    }

    /**
     * 
     * @return company_name 
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 
     * @param companyName 
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    /**
     * 
     * @return company_address 
     */
    public String getCompanyAddress() {
        return companyAddress;
    }

    /**
     * 
     * @param companyAddress 
     */
    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress == null ? null : companyAddress.trim();
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
     * 会员等级状态 0:添加 1：有效
     * @return level_status 会员等级状态 0:添加 1：有效
     */
    public Integer getLevelStatus() {
        return levelStatus;
    }

    /**
     * 会员等级状态 0:添加 1：有效
     * @param levelStatus 会员等级状态 0:添加 1：有效
     */
    public void setLevelStatus(Integer levelStatus) {
        this.levelStatus = levelStatus;
    }

    /**
     * 等级结束时间
     * @return level_end_time 等级结束时间
     */
    public Date getLevelEndTime() {
        return levelEndTime;
    }

    /**
     * 等级结束时间
     * @param levelEndTime 等级结束时间
     */
    public void setLevelEndTime(Date levelEndTime) {
        this.levelEndTime = levelEndTime;
    }

    /**
     * 等级开始时间
     * @return level_start_time 等级开始时间
     */
    public Date getLevelStartTime() {
        return levelStartTime;
    }

    /**
     * 等级开始时间
     * @param levelStartTime 等级开始时间
     */
    public void setLevelStartTime(Date levelStartTime) {
        this.levelStartTime = levelStartTime;
    }

    /**
     * 是否需要票据 1：不需要 其他是需要
     * @return no_tax_bill 是否需要票据 1：不需要 其他是需要
     */
    public Integer getNoTaxBill() {
        return noTaxBill;
    }

    /**
     * 是否需要票据 1：不需要 其他是需要
     * @param noTaxBill 是否需要票据 1：不需要 其他是需要
     */
    public void setNoTaxBill(Integer noTaxBill) {
        this.noTaxBill = noTaxBill;
    }

    /**
     * 原有的公司信息 用户不能修改
     * @return ori_contact_email 原有的公司信息 用户不能修改
     */
    public String getOriContactEmail() {
        return oriContactEmail;
    }

    /**
     * 原有的公司信息 用户不能修改
     * @param oriContactEmail 原有的公司信息 用户不能修改
     */
    public void setOriContactEmail(String oriContactEmail) {
        this.oriContactEmail = oriContactEmail == null ? null : oriContactEmail.trim();
    }

    /**
     * 
     * @return ori_contact_tel 
     */
    public String getOriContactTel() {
        return oriContactTel;
    }

    /**
     * 
     * @param oriContactTel 
     */
    public void setOriContactTel(String oriContactTel) {
        this.oriContactTel = oriContactTel == null ? null : oriContactTel.trim();
    }

    /**
     * 
     * @return ori_company_name 
     */
    public String getOriCompanyName() {
        return oriCompanyName;
    }

    /**
     * 
     * @param oriCompanyName 
     */
    public void setOriCompanyName(String oriCompanyName) {
        this.oriCompanyName = oriCompanyName == null ? null : oriCompanyName.trim();
    }

    /**
     * 
     * @return ori_company_address 
     */
    public String getOriCompanyAddress() {
        return oriCompanyAddress;
    }

    /**
     * 
     * @param oriCompanyAddress 
     */
    public void setOriCompanyAddress(String oriCompanyAddress) {
        this.oriCompanyAddress = oriCompanyAddress == null ? null : oriCompanyAddress.trim();
    }

    /**
     * 
     * @return ori_city_id 
     */
    public String getOriCityId() {
        return oriCityId;
    }

    /**
     * 
     * @param oriCityId 
     */
    public void setOriCityId(String oriCityId) {
        this.oriCityId = oriCityId == null ? null : oriCityId.trim();
    }

    /**
     * 代理商状态 0：添加 1：有效 2：失效
     * @return agent_status 代理商状态 0：添加 1：有效 2：失效
     */
    public Integer getAgentStatus() {
        return agentStatus;
    }

    /**
     * 代理商状态 0：添加 1：有效 2：失效
     * @param agentStatus 代理商状态 0：添加 1：有效 2：失效
     */
    public void setAgentStatus(Integer agentStatus) {
        this.agentStatus = agentStatus;
    }

    /**
     * 支付密码
     * @return pay_password 支付密码
     */
    public String getPayPassword() {
        return payPassword;
    }

    /**
     * 支付密码
     * @param payPassword 支付密码
     */
    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword == null ? null : payPassword.trim();
    }
}