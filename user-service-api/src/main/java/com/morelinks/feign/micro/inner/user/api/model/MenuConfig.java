package com.morelinks.feign.micro.inner.user.api.model;

/**
 * 描述:menu_config表的实体类
 * @version
 */
public class MenuConfig {
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
     * 匹配类型 1：角色 2：用户
     */
    private Integer mapType;

    /**
     * 
     */
    private String mapKey;

    /**
     * 路由的id
     */
    private Integer menuId;

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
     * 匹配类型 1：角色 2：用户
     * @return map_type 匹配类型 1：角色 2：用户
     */
    public Integer getMapType() {
        return mapType;
    }

    /**
     * 匹配类型 1：角色 2：用户
     * @param mapType 匹配类型 1：角色 2：用户
     */
    public void setMapType(Integer mapType) {
        this.mapType = mapType;
    }

    /**
     * 
     * @return map_key 
     */
    public String getMapKey() {
        return mapKey;
    }

    /**
     * 
     * @param mapKey 
     */
    public void setMapKey(String mapKey) {
        this.mapKey = mapKey == null ? null : mapKey.trim();
    }

    /**
     * 路由的id
     * @return menu_id 路由的id
     */
    public Integer getMenuId() {
        return menuId;
    }

    /**
     * 路由的id
     * @param menuId 路由的id
     */
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
}