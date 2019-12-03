package com.morelinks.feign.micro.device.config.api.model;

import java.util.Date;

/**
 * 描述:p_driver_type表的实体类
 * @version
 * @author:  sgfily
 */
public class DriverType {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 驱动名称
     */
    private String name;

    /**
     * 唯一键
     */
    private String onlyKey;

    /**
     * 寄存器配置类型 0:固定 1:预配置 2:不可配置
     */
    private Integer registerSetType;

    /**
     * 驱动类型配置
     */
    private String driverTypeSetting;

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
     * 驱动名称
     * @return NAME 驱动名称
     */
    public String getName() {
        return name;
    }

    /**
     * 驱动名称
     * @param name 驱动名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 唯一键
     * @return ONLY_KEY 唯一键
     */
    public String getOnlyKey() {
        return onlyKey;
    }

    /**
     * 唯一键
     * @param onlyKey 唯一键
     */
    public void setOnlyKey(String onlyKey) {
        this.onlyKey = onlyKey == null ? null : onlyKey.trim();
    }

    /**
     * 寄存器配置类型 0:固定 1:预配置 2:不可配置
     * @return REGISTER_SET_TYPE 寄存器配置类型 0:固定 1:预配置 2:不可配置
     */
    public Integer getRegisterSetType() {
        return registerSetType;
    }

    /**
     * 寄存器配置类型 0:固定 1:预配置 2:不可配置
     * @param registerSetType 寄存器配置类型 0:固定 1:预配置 2:不可配置
     */
    public void setRegisterSetType(Integer registerSetType) {
        this.registerSetType = registerSetType;
    }

    /**
     * 驱动类型配置
     * @return DRIVER_TYPE_SETTING 驱动类型配置
     */
    public String getDriverTypeSetting() {
        return driverTypeSetting;
    }

    /**
     * 驱动类型配置
     * @param driverTypeSetting 驱动类型配置
     */
    public void setDriverTypeSetting(String driverTypeSetting) {
        this.driverTypeSetting = driverTypeSetting == null ? null : driverTypeSetting.trim();
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