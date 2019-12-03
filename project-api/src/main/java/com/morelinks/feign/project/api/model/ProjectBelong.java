package com.morelinks.feign.project.api.model;

/**
 * 描述:project_belong表的实体类
 * @version
 */
public class ProjectBelong {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String projectId;

    /**
     * 项目归属类别 1：所属家居客户 2：所属代理商 
     */
    private Integer belongType;

    /**
     * 
     */
    private String belongId;

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
     * @return project_id 
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * 
     * @param projectId 
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    /**
     * 项目归属类别 1：所属家居客户 2：所属代理商 
     * @return belong_type 项目归属类别 1：所属家居客户 2：所属代理商 
     */
    public Integer getBelongType() {
        return belongType;
    }

    /**
     * 项目归属类别 1：所属家居客户 2：所属代理商 
     * @param belongType 项目归属类别 1：所属家居客户 2：所属代理商 
     */
    public void setBelongType(Integer belongType) {
        this.belongType = belongType;
    }

    /**
     * 
     * @return belong_id 
     */
    public String getBelongId() {
        return belongId;
    }

    /**
     * 
     * @param belongId 
     */
    public void setBelongId(String belongId) {
        this.belongId = belongId == null ? null : belongId.trim();
    }
}