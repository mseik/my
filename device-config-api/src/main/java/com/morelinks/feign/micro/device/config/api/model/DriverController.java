package com.morelinks.feign.micro.device.config.api.model;

import java.util.Date;

/**
 * 描述:p_driver_controller表的实体类
 * @version
 * @author:  sgfily
 */
public class DriverController {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 控制器名称
     */
    private String name;

    /**
     * 驱动类型ID
     */
    private Integer driverTypeId;

    /**
     * 寄存器地址范围
     */
    private String registerScope;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date ctime;

    /**
     * 修改时间
     */
    private Date utime;

    /**
     * 显示名称
     */
    private String showName;

    /**
     * 主键
     * @return ID 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 控制器名称
     * @return NAME 控制器名称
     */
    public String getName() {
        return name;
    }

    /**
     * 控制器名称
     * @param name 控制器名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 驱动类型ID
     * @return DRIVER_TYPE_ID 驱动类型ID
     */
    public Integer getDriverTypeId() {
        return driverTypeId;
    }

    /**
     * 驱动类型ID
     * @param driverTypeId 驱动类型ID
     */
    public void setDriverTypeId(Integer driverTypeId) {
        this.driverTypeId = driverTypeId;
    }

    /**
     * 寄存器地址范围
     * @return REGISTER_SCOPE 寄存器地址范围
     */
    public String getRegisterScope() {
        return registerScope;
    }

    /**
     * 寄存器地址范围
     * @param registerScope 寄存器地址范围
     */
    public void setRegisterScope(String registerScope) {
        this.registerScope = registerScope == null ? null : registerScope.trim();
    }

    /**
     * 状态
     * @return STATUS 状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态
     * @param status 状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 创建时间
     * @return CTIME 创建时间
     */
    public Date getCtime() {
        return ctime;
    }

    /**
     * 创建时间
     * @param ctime 创建时间
     */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    /**
     * 修改时间
     * @return UTIME 修改时间
     */
    public Date getUtime() {
        return utime;
    }

    /**
     * 修改时间
     * @param utime 修改时间
     */
    public void setUtime(Date utime) {
        this.utime = utime;
    }

    /**
     * 显示名称
     * @return SHOW_NAME 显示名称
     */
    public String getShowName() {
        return showName;
    }

    /**
     * 显示名称
     * @param showName 显示名称
     */
    public void setShowName(String showName) {
        this.showName = showName == null ? null : showName.trim();
    }
}