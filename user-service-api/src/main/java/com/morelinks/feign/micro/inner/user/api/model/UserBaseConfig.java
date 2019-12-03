package com.morelinks.feign.micro.inner.user.api.model;

import java.util.Date;

/**
 * 描述:user_base_config表的实体类
 * @version
 */
public class UserBaseConfig {
    /**
     * 
     */
    private Integer id;

    /**
     * 配置类别：
     */
    private String configType;

    /**
     * 
     */
    private String configKey;

    /**
     * 
     */
    private String configVal;

    /**
     * 配置排序
     */
    private Integer configSort;

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
     * 配置类别：
     * @return config_type 配置类别：
     */
    public String getConfigType() {
        return configType;
    }

    /**
     * 配置类别：
     * @param configType 配置类别：
     */
    public void setConfigType(String configType) {
        this.configType = configType == null ? null : configType.trim();
    }

    /**
     * 
     * @return config_key 
     */
    public String getConfigKey() {
        return configKey;
    }

    /**
     * 
     * @param configKey 
     */
    public void setConfigKey(String configKey) {
        this.configKey = configKey == null ? null : configKey.trim();
    }

    /**
     * 
     * @return config_val 
     */
    public String getConfigVal() {
        return configVal;
    }

    /**
     * 
     * @param configVal 
     */
    public void setConfigVal(String configVal) {
        this.configVal = configVal == null ? null : configVal.trim();
    }

    /**
     * 配置排序
     * @return config_sort 配置排序
     */
    public Integer getConfigSort() {
        return configSort;
    }

    /**
     * 配置排序
     * @param configSort 配置排序
     */
    public void setConfigSort(Integer configSort) {
        this.configSort = configSort;
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