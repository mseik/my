package com.morelinks.feign.micro.inner.user.api.model;

import java.util.Date;

/**
 * 描述:user_system_role表的实体类
 * @version
 * @author:  sgfily
 * @创建时间: 2018-12-13
 */
public class UserSystemRole {
    /**
     * 
     */
    private Integer id;

    /**
     * 用户Id
     */
    private Integer userId;

    /**
     * 管理系统Id
     */
    private Integer manageSystemId;

    /**
     * 用户在系统中所处的角色 暂时分为 admin 管理员 manage 普通管理 user 普通用户 guest 访问客户
     */
    private String roles;

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
     * 用户Id
     * @return user_id 用户Id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 用户Id
     * @param userId 用户Id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 管理系统Id
     * @return manage_system_id 管理系统Id
     */
    public Integer getManageSystemId() {
        return manageSystemId;
    }

    /**
     * 管理系统Id
     * @param manageSystemId 管理系统Id
     */
    public void setManageSystemId(Integer manageSystemId) {
        this.manageSystemId = manageSystemId;
    }

    /**
     * 用户在系统中所处的角色 暂时分为 admin 管理员 manage 普通管理 user 普通用户 guest 访问客户
     * @return roles 用户在系统中所处的角色 暂时分为 admin 管理员 manage 普通管理 user 普通用户 guest 访问客户
     */
    public String getRoles() {
        return roles;
    }

    /**
     * 用户在系统中所处的角色 暂时分为 admin 管理员 manage 普通管理 user 普通用户 guest 访问客户
     * @param roles 用户在系统中所处的角色 暂时分为 admin 管理员 manage 普通管理 user 普通用户 guest 访问客户
     */
    public void setRoles(String roles) {
        this.roles = roles == null ? null : roles.trim();
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