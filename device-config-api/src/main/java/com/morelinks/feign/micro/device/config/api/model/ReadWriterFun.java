package com.morelinks.feign.micro.device.config.api.model;

import java.util.Date;

/**
 * 描述:p_read_writer_fun表的实体类
 * @version
 * @author:  sgfily
 */
public class ReadWriterFun {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer rwType;

    /**
     * 
     */
    private String funName;

    /**
     * 
     */
    private Integer status;

    /**
     * 
     */
    private Date ctime;

    /**
     * 
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
     * 
     * @return RW_TYPE 
     */
    public Integer getRwType() {
        return rwType;
    }

    /**
     * 
     * @param rwType 
     */
    public void setRwType(Integer rwType) {
        this.rwType = rwType;
    }

    /**
     * 
     * @return FUN_NAME 
     */
    public String getFunName() {
        return funName;
    }

    /**
     * 
     * @param funName 
     */
    public void setFunName(String funName) {
        this.funName = funName == null ? null : funName.trim();
    }

    /**
     * 
     * @return STATUS 
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 
     * @param status 
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 
     * @return CTIME 
     */
    public Date getCtime() {
        return ctime;
    }

    /**
     * 
     * @param ctime 
     */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    /**
     * 
     * @return UTIME 
     */
    public Date getUtime() {
        return utime;
    }

    /**
     * 
     * @param utime 
     */
    public void setUtime(Date utime) {
        this.utime = utime;
    }
}