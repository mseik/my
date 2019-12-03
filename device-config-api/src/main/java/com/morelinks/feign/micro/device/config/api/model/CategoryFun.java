package com.morelinks.feign.micro.device.config.api.model;

import java.util.Date;

/**
 * 描述:p_category_fun表的实体类
 * @version
 * @author:  sgfily
 */
public class CategoryFun {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 分类ID
     */
    private Integer categoryId;

    /**
     * 端点号
     */
    private Integer funPointNo;

    /**
     * 功能名称
     */
    private String funName;

    /**
     * 数据类型 logic:逻辑开关 number:数值型 string:字符串 object:通用型
     */
    private String dataType;

    /**
     * 读写类型  R：只读 W：只写 RW：读写
     */
    private String rwType;

    /**
     * 状态：0：删除 1：正常
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
     * 分类ID
     * @return CATEGORY_ID 分类ID
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 分类ID
     * @param categoryId 分类ID
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
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
     * 功能名称
     * @return FUN_NAME 功能名称
     */
    public String getFunName() {
        return funName;
    }

    /**
     * 功能名称
     * @param funName 功能名称
     */
    public void setFunName(String funName) {
        this.funName = funName == null ? null : funName.trim();
    }

    /**
     * 数据类型 logic:逻辑开关 number:数值型 string:字符串 object:通用型
     * @return DATA_TYPE 数据类型 logic:逻辑开关 number:数值型 string:字符串 object:通用型
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * 数据类型 logic:逻辑开关 number:数值型 string:字符串 object:通用型
     * @param dataType 数据类型 logic:逻辑开关 number:数值型 string:字符串 object:通用型
     */
    public void setDataType(String dataType) {
        this.dataType = dataType == null ? null : dataType.trim();
    }

    /**
     * 读写类型  R：只读 W：只写 RW：读写
     * @return RW_TYPE 读写类型  R：只读 W：只写 RW：读写
     */
    public String getRwType() {
        return rwType;
    }

    /**
     * 读写类型  R：只读 W：只写 RW：读写
     * @param rwType 读写类型  R：只读 W：只写 RW：读写
     */
    public void setRwType(String rwType) {
        this.rwType = rwType == null ? null : rwType.trim();
    }

    /**
     * 状态：0：删除 1：正常
     * @return STATUS 状态：0：删除 1：正常
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态：0：删除 1：正常
     * @param status 状态：0：删除 1：正常
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