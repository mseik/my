package com.morelinks.feign.project.api.model;

import java.util.Date;

/**
 * 描述:project_info表的实体类
 * @version
 */
public class ProjectInfo {
    /**
     * 项目id 
     */
    private String id;

    /**
     * 项目类型 0：未知 1：开发商 2：别墅 3.平层
     */
    private Integer projectType;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 城市Id
     */
    private String cityId;

    /**
     * 项目地址 除却城市之后的详细地址
     */
    private String projectAddress;

    /**
     * 项目状态 1：添加沟通 2：配单阶段 3：成交 4:调试阶段 5：上线阶段 6：失败
     */
    private Integer projectStatus;

    /**
     * 项目描述
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
     * 项目id 
     * @return id 项目id 
     */
    public String getId() {
        return id;
    }

    /**
     * 项目id 
     * @param id 项目id 
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 项目类型 0：未知 1：开发商 2：别墅 3.平层
     * @return project_type 项目类型 0：未知 1：开发商 2：别墅 3.平层
     */
    public Integer getProjectType() {
        return projectType;
    }

    /**
     * 项目类型 0：未知 1：开发商 2：别墅 3.平层
     * @param projectType 项目类型 0：未知 1：开发商 2：别墅 3.平层
     */
    public void setProjectType(Integer projectType) {
        this.projectType = projectType;
    }

    /**
     * 项目名称
     * @return project_name 项目名称
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * 项目名称
     * @param projectName 项目名称
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    /**
     * 城市Id
     * @return city_id 城市Id
     */
    public String getCityId() {
        return cityId;
    }

    /**
     * 城市Id
     * @param cityId 城市Id
     */
    public void setCityId(String cityId) {
        this.cityId = cityId == null ? null : cityId.trim();
    }

    /**
     * 项目地址 除却城市之后的详细地址
     * @return project_address 项目地址 除却城市之后的详细地址
     */
    public String getProjectAddress() {
        return projectAddress;
    }

    /**
     * 项目地址 除却城市之后的详细地址
     * @param projectAddress 项目地址 除却城市之后的详细地址
     */
    public void setProjectAddress(String projectAddress) {
        this.projectAddress = projectAddress == null ? null : projectAddress.trim();
    }

    /**
     * 项目状态 1：添加沟通 2：配单阶段 3：成交 4:调试阶段 5：上线阶段 6：失败
     * @return project_status 项目状态 1：添加沟通 2：配单阶段 3：成交 4:调试阶段 5：上线阶段 6：失败
     */
    public Integer getProjectStatus() {
        return projectStatus;
    }

    /**
     * 项目状态 1：添加沟通 2：配单阶段 3：成交 4:调试阶段 5：上线阶段 6：失败
     * @param projectStatus 项目状态 1：添加沟通 2：配单阶段 3：成交 4:调试阶段 5：上线阶段 6：失败
     */
    public void setProjectStatus(Integer projectStatus) {
        this.projectStatus = projectStatus;
    }

    /**
     * 项目描述
     * @return remark 项目描述
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 项目描述
     * @param remark 项目描述
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
}