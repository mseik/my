package com.morelinks.feign.micro.product.api.model;

import java.util.Date;

/**
 * 描述:config_category表的实体类
 * @version
 */
public class ConfigCategory {
    /**
     * 
     */
    private Integer id;

    /**
     * 类别名称
     */
    private String categoryName;

    /**
     * 类别图标
     */
    private String icon;

    /**
     * 父项Id
     */
    private Integer parentId;

    /**
     * 排序字段 数值越大 越在前
     */
    private Integer sort;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

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
     * 类别名称
     * @return category_name 类别名称
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 类别名称
     * @param categoryName 类别名称
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    /**
     * 类别图标
     * @return icon 类别图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 类别图标
     * @param icon 类别图标
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * 父项Id
     * @return parent_id 父项Id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 父项Id
     * @param parentId 父项Id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 排序字段 数值越大 越在前
     * @return sort 排序字段 数值越大 越在前
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 排序字段 数值越大 越在前
     * @param sort 排序字段 数值越大 越在前
     */
    public void setSort(Integer sort) {
        this.sort = sort;
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
}