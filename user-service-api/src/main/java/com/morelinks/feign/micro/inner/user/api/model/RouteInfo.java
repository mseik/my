package com.morelinks.feign.micro.inner.user.api.model;

import java.util.Date;

/**
 * 描述:route_info表的实体类
 * @version
 */
public class RouteInfo {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer systemType;

    /**
     * 
     */
    private Integer systemId;

    /**
     * 路径url名称
     */
    private String routePath;

    /**
     * 
     */
    private Integer routeStatus;

    /**
     * 
     */
    private String remark;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 路由地址 是否需要带上 项目id
     */
    private Integer pathWithId;

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
     * @return system_type 
     */
    public Integer getSystemType() {
        return systemType;
    }

    /**
     * 
     * @param systemType 
     */
    public void setSystemType(Integer systemType) {
        this.systemType = systemType;
    }

    /**
     * 
     * @return system_id 
     */
    public Integer getSystemId() {
        return systemId;
    }

    /**
     * 
     * @param systemId 
     */
    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    /**
     * 路径url名称
     * @return route_path 路径url名称
     */
    public String getRoutePath() {
        return routePath;
    }

    /**
     * 路径url名称
     * @param routePath 路径url名称
     */
    public void setRoutePath(String routePath) {
        this.routePath = routePath == null ? null : routePath.trim();
    }

    /**
     * 
     * @return route_status 
     */
    public Integer getRouteStatus() {
        return routeStatus;
    }

    /**
     * 
     * @param routeStatus 
     */
    public void setRouteStatus(Integer routeStatus) {
        this.routeStatus = routeStatus;
    }

    /**
     * 
     * @return remark 
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 
     * @param remark 
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
     * 路由地址 是否需要带上 项目id
     * @return path_with_id 路由地址 是否需要带上 项目id
     */
    public Integer getPathWithId() {
        return pathWithId;
    }

    /**
     * 路由地址 是否需要带上 项目id
     * @param pathWithId 路由地址 是否需要带上 项目id
     */
    public void setPathWithId(Integer pathWithId) {
        this.pathWithId = pathWithId;
    }
}