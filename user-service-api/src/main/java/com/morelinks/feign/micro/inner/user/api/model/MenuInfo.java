package com.morelinks.feign.micro.inner.user.api.model;

import java.util.Date;

/**
 * 描述:menu_info表的实体类
 * @version
 */
public class MenuInfo {
    /**
     * 
     */
    private Integer id;

    /**
     * 路由的id
     */
    private Integer routeId;

    /**
     * 
     */
    private Integer systemType;

    /**
     * 
     */
    private Integer systemId;

    /**
     * 菜单类别 1：头部菜单 2：左侧菜单 3：内容头部菜单 4：项目菜单
     */
    private Integer menuType;

    /**
     * 
     */
    private String menuName;

    /**
     * 
     */
    private String menuDesc;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 菜单图标索引
     */
    private String icon;

    /**
     * 菜单排序字段
     */
    private Integer sort;

    /**
     * 父项Id -1表示根
     */
    private Integer parentId;

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
     * 路由的id
     * @return route_id 路由的id
     */
    public Integer getRouteId() {
        return routeId;
    }

    /**
     * 路由的id
     * @param routeId 路由的id
     */
    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
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
     * 菜单类别 1：头部菜单 2：左侧菜单 3：内容头部菜单 4：项目菜单
     * @return menu_type 菜单类别 1：头部菜单 2：左侧菜单 3：内容头部菜单 4：项目菜单
     */
    public Integer getMenuType() {
        return menuType;
    }

    /**
     * 菜单类别 1：头部菜单 2：左侧菜单 3：内容头部菜单 4：项目菜单
     * @param menuType 菜单类别 1：头部菜单 2：左侧菜单 3：内容头部菜单 4：项目菜单
     */
    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    /**
     * 
     * @return menu_name 
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * 
     * @param menuName 
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    /**
     * 
     * @return menu_desc 
     */
    public String getMenuDesc() {
        return menuDesc;
    }

    /**
     * 
     * @param menuDesc 
     */
    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc == null ? null : menuDesc.trim();
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
     * 菜单图标索引
     * @return icon 菜单图标索引
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 菜单图标索引
     * @param icon 菜单图标索引
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * 菜单排序字段
     * @return sort 菜单排序字段
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 菜单排序字段
     * @param sort 菜单排序字段
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 父项Id -1表示根
     * @return parent_id 父项Id -1表示根
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 父项Id -1表示根
     * @param parentId 父项Id -1表示根
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}