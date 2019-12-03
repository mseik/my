package com.morelinks.feign.micro.device.config.api.model;

import java.util.Date;

/**
 * 描述:p_sys_constant表的实体类
 * @version
 * @author:  sgfily
 */
public class SysConstant {
    /**
     * 
     */
    private Integer id;

    /**
     * 常量名称
     */
    private String name;

    /**
     * 常量类型 1:房间类型 
     */
    private Integer type;

    /**
     * 排序
     */
    private Integer ord;

    /**
     * 状态：0：失效 1：有效
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
     * 
     * @return ID 
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
     * 常量名称
     * @return NAME 常量名称
     */
    public String getName() {
        return name;
    }

    /**
     * 常量名称
     * @param name 常量名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 常量类型 1:房间类型 
     * @return TYPE 常量类型 1:房间类型 
     */
    public Integer getType() {
        return type;
    }

    /**
     * 常量类型 1:房间类型 
     * @param type 常量类型 1:房间类型 
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 排序
     * @return ORD 排序
     */
    public Integer getOrd() {
        return ord;
    }

    /**
     * 排序
     * @param ord 排序
     */
    public void setOrd(Integer ord) {
        this.ord = ord;
    }

    /**
     * 状态：0：失效 1：有效
     * @return STATUS 状态：0：失效 1：有效
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态：0：失效 1：有效
     * @param status 状态：0：失效 1：有效
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
}