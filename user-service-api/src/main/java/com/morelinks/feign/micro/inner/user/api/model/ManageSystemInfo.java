package com.morelinks.feign.micro.inner.user.api.model;

import java.util.Date;

/**
 * 描述:manage_system_info表的实体类
 * @version
 */
public class ManageSystemInfo {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String systemName;

    /**
     * 
     */
    private String systemDesc;

    /**
     * 系统使用状态1：可使用 2：废弃
     */
    private Integer systemStatus;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 系统类别 用以区分账号重名 1:内部管理系统 2：代理商管理系统
     */
    private Integer systemType;

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
     * @return system_name 
     */
    public String getSystemName() {
        return systemName;
    }

    /**
     * 
     * @param systemName 
     */
    public void setSystemName(String systemName) {
        this.systemName = systemName == null ? null : systemName.trim();
    }

    /**
     * 
     * @return system_desc 
     */
    public String getSystemDesc() {
        return systemDesc;
    }

    /**
     * 
     * @param systemDesc 
     */
    public void setSystemDesc(String systemDesc) {
        this.systemDesc = systemDesc == null ? null : systemDesc.trim();
    }

    /**
     * 系统使用状态1：可使用 2：废弃
     * @return system_status 系统使用状态1：可使用 2：废弃
     */
    public Integer getSystemStatus() {
        return systemStatus;
    }

    /**
     * 系统使用状态1：可使用 2：废弃
     * @param systemStatus 系统使用状态1：可使用 2：废弃
     */
    public void setSystemStatus(Integer systemStatus) {
        this.systemStatus = systemStatus;
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
     * 系统类别 用以区分账号重名 1:内部管理系统 2：代理商管理系统
     * @return system_type 系统类别 用以区分账号重名 1:内部管理系统 2：代理商管理系统
     */
    public Integer getSystemType() {
        return systemType;
    }

    /**
     * 系统类别 用以区分账号重名 1:内部管理系统 2：代理商管理系统
     * @param systemType 系统类别 用以区分账号重名 1:内部管理系统 2：代理商管理系统
     */
    public void setSystemType(Integer systemType) {
        this.systemType = systemType;
    }
}