package com.morelinks.feign.micro.inner.user.api.model;

import java.util.Date;

/**
 * 描述:agent_invoice_info表的实体类
 * @version
 * @author:  sgfily
 * @创建时间: 2018-12-13
 */
public class AgentInvoiceInfo {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer agentId;

    /**
     * 发票抬头
     */
    private String companyName;

    /**
     * 税号
     */
    private String taxNo;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 发票状态 1：有效 2：无效
     */
    private Integer invoiceStatus;

    /**
     * 
     */
    private String companyAddress;

    /**
     * 
     */
    private String companyTel;

    /**
     * 开户银行
     */
    private String depositBankName;

    /**
     * 银行账户
     */
    private String depositBankAccount;

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
     * 发票抬头
     * @return company_name 发票抬头
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 发票抬头
     * @param companyName 发票抬头
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    /**
     * 税号
     * @return tax_no 税号
     */
    public String getTaxNo() {
        return taxNo;
    }

    /**
     * 税号
     * @param taxNo 税号
     */
    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo == null ? null : taxNo.trim();
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
     * 发票状态 1：有效 2：无效
     * @return invoice_status 发票状态 1：有效 2：无效
     */
    public Integer getInvoiceStatus() {
        return invoiceStatus;
    }

    /**
     * 发票状态 1：有效 2：无效
     * @param invoiceStatus 发票状态 1：有效 2：无效
     */
    public void setInvoiceStatus(Integer invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
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
     * @return company_tel 
     */
    public String getCompanyTel() {
        return companyTel;
    }

    /**
     * 
     * @param companyTel 
     */
    public void setCompanyTel(String companyTel) {
        this.companyTel = companyTel == null ? null : companyTel.trim();
    }

    /**
     * 开户银行
     * @return deposit_bank_name 开户银行
     */
    public String getDepositBankName() {
        return depositBankName;
    }

    /**
     * 开户银行
     * @param depositBankName 开户银行
     */
    public void setDepositBankName(String depositBankName) {
        this.depositBankName = depositBankName == null ? null : depositBankName.trim();
    }

    /**
     * 银行账户
     * @return deposit_bank_account 银行账户
     */
    public String getDepositBankAccount() {
        return depositBankAccount;
    }

    /**
     * 银行账户
     * @param depositBankAccount 银行账户
     */
    public void setDepositBankAccount(String depositBankAccount) {
        this.depositBankAccount = depositBankAccount == null ? null : depositBankAccount.trim();
    }
}