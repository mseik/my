package com.morelinks.feign.micro.file.api.model;

import java.util.Date;

/**
 * 描述:scene_config表的实体类
 * @version
 * @author:  sgfily
 * @创建时间: 2018-12-03
 */
public class SceneConfig {
    /**
     * 
     */
    private Integer id;

    /**
     * 文件存储场景
     */
    private String scene;

    /**
     * 文件路径
     */
    private String path;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 阿里云oss的name
     */
    private String ossBucketName;

    /**
     * 是否上传至oss
     */
    private Integer uploadOss;

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
     * 文件存储场景
     * @return scene 文件存储场景
     */
    public String getScene() {
        return scene;
    }

    /**
     * 文件存储场景
     * @param scene 文件存储场景
     */
    public void setScene(String scene) {
        this.scene = scene == null ? null : scene.trim();
    }

    /**
     * 文件路径
     * @return path 文件路径
     */
    public String getPath() {
        return path;
    }

    /**
     * 文件路径
     * @param path 文件路径
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
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
     * 阿里云oss的name
     * @return oss_bucket_name 阿里云oss的name
     */
    public String getOssBucketName() {
        return ossBucketName;
    }

    /**
     * 阿里云oss的name
     * @param ossBucketName 阿里云oss的name
     */
    public void setOssBucketName(String ossBucketName) {
        this.ossBucketName = ossBucketName == null ? null : ossBucketName.trim();
    }

    /**
     * 是否上传至oss
     * @return upload_oss 是否上传至oss
     */
    public Integer getUploadOss() {
        return uploadOss;
    }

    /**
     * 是否上传至oss
     * @param uploadOss 是否上传至oss
     */
    public void setUploadOss(Integer uploadOss) {
        this.uploadOss = uploadOss;
    }
}