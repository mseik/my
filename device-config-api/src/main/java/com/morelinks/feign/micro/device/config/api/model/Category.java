package com.morelinks.feign.micro.device.config.api.model;

import java.util.Date;

/**
 * 描述:p_category表的实体类
 * @version
 * @author:  sgfily
 */
public class Category {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 状态 0:删除 1:正常
     */
    private Integer status;

    /**
     * 排序
     */
    private Integer ord;

    /**
     * 创建时间
     */
    private Date ctime;

    /**
     * 修改时间
     */
    private Date utime;

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
     * 分类名称
     * @return NAME 分类名称
     */
    public String getName() {
        return name;
    }

    /**
     * 分类名称
     * @param name 分类名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 状态 0:删除 1:正常
     * @return STATUS 状态 0:删除 1:正常
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态 0:删除 1:正常
     * @param status 状态 0:删除 1:正常
     */
    public void setStatus(Integer status) {
        this.status = status;
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