package com.morelinks.feign.micro.pay.api.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述:account表的实体类
 * @version
 */
public class Account {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String accountKey;

    /**
     * 账户类别 1:代理商余额账户 2:代理商货款账户
     */
    private Integer accountType;

    /**
     * 余额
     */
    private BigDecimal balance;

    /**
     * 冻结金额
     */
    private BigDecimal lockAmount;

    /**
     * 账户状态 0：添加 1：生效 2：失效 3：冻结
     */
    private Integer accountStatus;

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
    private Long version;

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
     * @return account_key 
     */
    public String getAccountKey() {
        return accountKey;
    }

    /**
     * 
     * @param accountKey 
     */
    public void setAccountKey(String accountKey) {
        this.accountKey = accountKey == null ? null : accountKey.trim();
    }

    /**
     * 账户类别 1:代理商余额账户 2:代理商货款账户
     * @return account_type 账户类别 1:代理商余额账户 2:代理商货款账户
     */
    public Integer getAccountType() {
        return accountType;
    }

    /**
     * 账户类别 1:代理商余额账户 2:代理商货款账户
     * @param accountType 账户类别 1:代理商余额账户 2:代理商货款账户
     */
    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    /**
     * 余额
     * @return balance 余额
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * 余额
     * @param balance 余额
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * 冻结金额
     * @return lock_amount 冻结金额
     */
    public BigDecimal getLockAmount() {
        return lockAmount;
    }

    /**
     * 冻结金额
     * @param lockAmount 冻结金额
     */
    public void setLockAmount(BigDecimal lockAmount) {
        this.lockAmount = lockAmount;
    }

    /**
     * 账户状态 0：添加 1：生效 2：失效 3：冻结
     * @return account_status 账户状态 0：添加 1：生效 2：失效 3：冻结
     */
    public Integer getAccountStatus() {
        return accountStatus;
    }

    /**
     * 账户状态 0：添加 1：生效 2：失效 3：冻结
     * @param accountStatus 账户状态 0：添加 1：生效 2：失效 3：冻结
     */
    public void setAccountStatus(Integer accountStatus) {
        this.accountStatus = accountStatus;
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
     * @return version 
     */
    public Long getVersion() {
        return version;
    }

    /**
     * 
     * @param version 
     */
    public void setVersion(Long version) {
        this.version = version;
    }
}