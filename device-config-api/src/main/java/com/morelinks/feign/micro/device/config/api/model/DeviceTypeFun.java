package com.morelinks.feign.micro.device.config.api.model;

import java.util.Date;

/**
 * 描述:p_device_type_fun表的实体类
 * @version
 * @author:  sgfily
 */
public class DeviceTypeFun {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 设备型号ID
     */
    private Integer deviceTypeId;

    /**
     * 分类功能ID
     */
    private Integer categoryFunId;

    /**
     * 端点号
     */
    private Integer funPointNo;

    /**
     * 读函数
     */
    private String readFunction;

    /**
     * 写函数
     */
    private String writeFunction;

    /**
     * 寄存器地址值
     */
    private String registerValJson;

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
     * 数字阀值字符
     */
    private String delta;

    /**
     * 是否读写数据相同
     */
    private Integer sameVal;

    /**
     * 初始值 如果是数字代表
     */
    private String startVal;

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
     * 设备型号ID
     * @return DEVICE_TYPE_ID 设备型号ID
     */
    public Integer getDeviceTypeId() {
        return deviceTypeId;
    }

    /**
     * 设备型号ID
     * @param deviceTypeId 设备型号ID
     */
    public void setDeviceTypeId(Integer deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    /**
     * 分类功能ID
     * @return CATEGORY_FUN_ID 分类功能ID
     */
    public Integer getCategoryFunId() {
        return categoryFunId;
    }

    /**
     * 分类功能ID
     * @param categoryFunId 分类功能ID
     */
    public void setCategoryFunId(Integer categoryFunId) {
        this.categoryFunId = categoryFunId;
    }

    /**
     * 端点号
     * @return FUN_POINT_NO 端点号
     */
    public Integer getFunPointNo() {
        return funPointNo;
    }

    /**
     * 端点号
     * @param funPointNo 端点号
     */
    public void setFunPointNo(Integer funPointNo) {
        this.funPointNo = funPointNo;
    }

    /**
     * 读函数
     * @return READ_FUNCTION 读函数
     */
    public String getReadFunction() {
        return readFunction;
    }

    /**
     * 读函数
     * @param readFunction 读函数
     */
    public void setReadFunction(String readFunction) {
        this.readFunction = readFunction == null ? null : readFunction.trim();
    }

    /**
     * 写函数
     * @return WRITE_FUNCTION 写函数
     */
    public String getWriteFunction() {
        return writeFunction;
    }

    /**
     * 写函数
     * @param writeFunction 写函数
     */
    public void setWriteFunction(String writeFunction) {
        this.writeFunction = writeFunction == null ? null : writeFunction.trim();
    }

    /**
     * 寄存器地址值
     * @return REGISTER_VAL_JSON 寄存器地址值
     */
    public String getRegisterValJson() {
        return registerValJson;
    }

    /**
     * 寄存器地址值
     * @param registerValJson 寄存器地址值
     */
    public void setRegisterValJson(String registerValJson) {
        this.registerValJson = registerValJson == null ? null : registerValJson.trim();
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
     * 数字阀值字符
     * @return DELTA 数字阀值字符
     */
    public String getDelta() {
        return delta;
    }

    /**
     * 数字阀值字符
     * @param delta 数字阀值字符
     */
    public void setDelta(String delta) {
        this.delta = delta == null ? null : delta.trim();
    }

    /**
     * 是否读写数据相同
     * @return same_val 是否读写数据相同
     */
    public Integer getSameVal() {
        return sameVal;
    }

    /**
     * 是否读写数据相同
     * @param sameVal 是否读写数据相同
     */
    public void setSameVal(Integer sameVal) {
        this.sameVal = sameVal;
    }

    /**
     * 初始值 如果是数字代表
     * @return start_val 初始值 如果是数字代表
     */
    public String getStartVal() {
        return startVal;
    }

    /**
     * 初始值 如果是数字代表
     * @param startVal 初始值 如果是数字代表
     */
    public void setStartVal(String startVal) {
        this.startVal = startVal == null ? null : startVal.trim();
    }
}