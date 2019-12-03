package com.morelinks.feign.micro.order.api.model;

import java.util.Date;

/**
 * 描述:agent_order_invoice_info表的实体类
 * @version
 */
public class AgentOrderInvoiceInfo {
    /**
     * 
     */
    private String orderId;

    /**
     * 
     */
    private Integer invoiceId;

    /**
     * 发票抬头 公司名
     */
    private String invoiceTitle;

    /**
     * 税号
     */
    private String invoiceNo;

    /**
     * 发票 公司地址
     */
    private String invoiceCompanyAddress;

    /**
     * 发票手机号
     */
    private String invoiceCompanyTel;

    /**
     * 发票开户银行
     */
    private String invoiceBankName;

    /**
     * 发票银行账户
     */
    private String invoiceBankAccount;

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
     * 
     * @return invoice_id 
     */
    public Integer getInvoiceId() {
        return invoiceId;
    }

    /**
     * 
     * @param invoiceId 
     */
    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    /**
     * 发票抬头 公司名
     * @return invoice_title 发票抬头 公司名
     */
    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    /**
     * 发票抬头 公司名
     * @param invoiceTitle 发票抬头 公司名
     */
    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle == null ? null : invoiceTitle.trim();
    }

    /**
     * 税号
     * @return invoice_no 税号
     */
    public String getInvoiceNo() {
        return invoiceNo;
    }

    /**
     * 税号
     * @param invoiceNo 税号
     */
    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo == null ? null : invoiceNo.trim();
    }

    /**
     * 发票 公司地址
     * @return invoice_company_address 发票 公司地址
     */
    public String getInvoiceCompanyAddress() {
        return invoiceCompanyAddress;
    }

    /**
     * 发票 公司地址
     * @param invoiceCompanyAddress 发票 公司地址
     */
    public void setInvoiceCompanyAddress(String invoiceCompanyAddress) {
        this.invoiceCompanyAddress = invoiceCompanyAddress == null ? null : invoiceCompanyAddress.trim();
    }

    /**
     * 发票手机号
     * @return invoice_company_tel 发票手机号
     */
    public String getInvoiceCompanyTel() {
        return invoiceCompanyTel;
    }

    /**
     * 发票手机号
     * @param invoiceCompanyTel 发票手机号
     */
    public void setInvoiceCompanyTel(String invoiceCompanyTel) {
        this.invoiceCompanyTel = invoiceCompanyTel == null ? null : invoiceCompanyTel.trim();
    }

    /**
     * 发票开户银行
     * @return invoice_bank_name 发票开户银行
     */
    public String getInvoiceBankName() {
        return invoiceBankName;
    }

    /**
     * 发票开户银行
     * @param invoiceBankName 发票开户银行
     */
    public void setInvoiceBankName(String invoiceBankName) {
        this.invoiceBankName = invoiceBankName == null ? null : invoiceBankName.trim();
    }

    /**
     * 发票银行账户
     * @return invoice_bank_account 发票银行账户
     */
    public String getInvoiceBankAccount() {
        return invoiceBankAccount;
    }

    /**
     * 发票银行账户
     * @param invoiceBankAccount 发票银行账户
     */
    public void setInvoiceBankAccount(String invoiceBankAccount) {
        this.invoiceBankAccount = invoiceBankAccount == null ? null : invoiceBankAccount.trim();
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