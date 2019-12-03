package com.morelinks.feign.project.api.model;

import java.util.Date;

/**
 * 描述:project_struct表的实体类
 * @version
 */
public class ProjectStruct {
    /**
     * 
     */
    private String id;

    /**
     * 项目Id
     */
    private String projectId;

    /**
     * 父项Id
     */
    private String parentId;

    /**
     * 结构名称
     */
    private String structName;

    /**
     * 结构状态 1：生效 2：失效 
     */
    private Integer structStatus;

    /**
     * 联系人姓名
     */
    private String contactName;

    /**
     * 联系人电话
     */
    private String contactTel;

    /**
     * 备注
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
     * 
     * @return id 
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 项目Id
     * @return project_id 项目Id
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * 项目Id
     * @param projectId 项目Id
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    /**
     * 父项Id
     * @return parent_id 父项Id
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 父项Id
     * @param parentId 父项Id
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * 结构名称
     * @return struct_name 结构名称
     */
    public String getStructName() {
        return structName;
    }

    /**
     * 结构名称
     * @param structName 结构名称
     */
    public void setStructName(String structName) {
        this.structName = structName == null ? null : structName.trim();
    }

    /**
     * 结构状态 1：生效 2：失效 
     * @return struct_status 结构状态 1：生效 2：失效 
     */
    public Integer getStructStatus() {
        return structStatus;
    }

    /**
     * 结构状态 1：生效 2：失效 
     * @param structStatus 结构状态 1：生效 2：失效 
     */
    public void setStructStatus(Integer structStatus) {
        this.structStatus = structStatus;
    }

    /**
     * 联系人姓名
     * @return contact_name 联系人姓名
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * 联系人姓名
     * @param contactName 联系人姓名
     */
    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    /**
     * 联系人电话
     * @return contact_tel 联系人电话
     */
    public String getContactTel() {
        return contactTel;
    }

    /**
     * 联系人电话
     * @param contactTel 联系人电话
     */
    public void setContactTel(String contactTel) {
        this.contactTel = contactTel == null ? null : contactTel.trim();
    }

    /**
     * 备注
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark 备注
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