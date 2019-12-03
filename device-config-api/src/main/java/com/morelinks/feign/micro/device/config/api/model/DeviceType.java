package com.morelinks.feign.micro.device.config.api.model;

import java.util.Date;

/**
 * 描述:p_device_type表的实体类
 * @version
 * @author:  sgfily
 */
public class DeviceType {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 编号, DT0000001
     */
    private String code;

    /**
     * 设备分类ID
     */
    private Integer categoryId;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 型号名称
     */
    private String typeName;

    /**
     * 驱动ID
     */
    private Integer driverTypeId;

    /**
     * 控制品ID
     */
    private Integer controllerId;

    /**
     * 隐藏 0:隐藏 1:显示
     */
    private Integer isHide;

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
     * 是否需要关联设备
     */
    private Integer needMapProjectDevice;

    /**
     * 相同的功能点集合 按照;号分隔组 组内按,号分隔
     */
    private String sameTypeFun;

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
     * 编号, DT0000001
     * @return CODE 编号, DT0000001
     */
    public String getCode() {
        return code;
    }

    /**
     * 编号, DT0000001
     * @param code 编号, DT0000001
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 设备分类ID
     * @return CATEGORY_ID 设备分类ID
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 设备分类ID
     * @param categoryId 设备分类ID
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 品牌
     * @return BRAND 品牌
     */
    public String getBrand() {
        return brand;
    }

    /**
     * 品牌
     * @param brand 品牌
     */
    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    /**
     * 型号名称
     * @return TYPE_NAME 型号名称
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * 型号名称
     * @param typeName 型号名称
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    /**
     * 驱动ID
     * @return DRIVER_TYPE_ID 驱动ID
     */
    public Integer getDriverTypeId() {
        return driverTypeId;
    }

    /**
     * 驱动ID
     * @param driverTypeId 驱动ID
     */
    public void setDriverTypeId(Integer driverTypeId) {
        this.driverTypeId = driverTypeId;
    }

    /**
     * 控制品ID
     * @return CONTROLLER_ID 控制品ID
     */
    public Integer getControllerId() {
        return controllerId;
    }

    /**
     * 控制品ID
     * @param controllerId 控制品ID
     */
    public void setControllerId(Integer controllerId) {
        this.controllerId = controllerId;
    }

    /**
     * 隐藏 0:隐藏 1:显示
     * @return IS_HIDE 隐藏 0:隐藏 1:显示
     */
    public Integer getIsHide() {
        return isHide;
    }

    /**
     * 隐藏 0:隐藏 1:显示
     * @param isHide 隐藏 0:隐藏 1:显示
     */
    public void setIsHide(Integer isHide) {
        this.isHide = isHide;
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
     * 是否需要关联设备
     * @return need_map_project_device 是否需要关联设备
     */
    public Integer getNeedMapProjectDevice() {
        return needMapProjectDevice;
    }

    /**
     * 是否需要关联设备
     * @param needMapProjectDevice 是否需要关联设备
     */
    public void setNeedMapProjectDevice(Integer needMapProjectDevice) {
        this.needMapProjectDevice = needMapProjectDevice;
    }

    /**
     * 相同的功能点集合 按照;号分隔组 组内按,号分隔
     * @return same_type_fun 相同的功能点集合 按照;号分隔组 组内按,号分隔
     */
    public String getSameTypeFun() {
        return sameTypeFun;
    }

    /**
     * 相同的功能点集合 按照;号分隔组 组内按,号分隔
     * @param sameTypeFun 相同的功能点集合 按照;号分隔组 组内按,号分隔
     */
    public void setSameTypeFun(String sameTypeFun) {
        this.sameTypeFun = sameTypeFun == null ? null : sameTypeFun.trim();
    }
}