package com.morelinks.feign.micro.inner.user.api.model;

import java.util.Date;

/**
 * 描述:user_info表的实体类
 * @version
 */
public class UserInfo {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 登录名
     */
    private String userName;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 真是姓名
     */
    private String realName;

    /**
     * 密码
     */
    private String password;

    /**
     * 系统类别，同一个系统只能有一个登录名，如1：迈联内部系统 2：迈联代理商销售系统
     */
    private Integer systemType;

    /**
     * 用户状态 1：有效 2:无效
     */
    private Integer userStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 头像路径
     */
    private String headImgPath;

    /**
     * 用户手机号
     */
    private String userTel;

    /**
     * 主键
     * @return id 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 登录名
     * @return user_name 登录名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 登录名
     * @param userName 登录名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 昵称
     * @return nick_name 昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 昵称
     * @param nickName 昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * 真是姓名
     * @return real_name 真是姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 真是姓名
     * @param realName 真是姓名
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * 密码
     * @return password 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 系统类别，同一个系统只能有一个登录名，如1：迈联内部系统 2：迈联代理商销售系统
     * @return system_type 系统类别，同一个系统只能有一个登录名，如1：迈联内部系统 2：迈联代理商销售系统
     */
    public Integer getSystemType() {
        return systemType;
    }

    /**
     * 系统类别，同一个系统只能有一个登录名，如1：迈联内部系统 2：迈联代理商销售系统
     * @param systemType 系统类别，同一个系统只能有一个登录名，如1：迈联内部系统 2：迈联代理商销售系统
     */
    public void setSystemType(Integer systemType) {
        this.systemType = systemType;
    }

    /**
     * 用户状态 1：有效 2:无效
     * @return user_status 用户状态 1：有效 2:无效
     */
    public Integer getUserStatus() {
        return userStatus;
    }

    /**
     * 用户状态 1：有效 2:无效
     * @param userStatus 用户状态 1：有效 2:无效
     */
    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改时间
     * @return update_time 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 头像路径
     * @return head_img_path 头像路径
     */
    public String getHeadImgPath() {
        return headImgPath;
    }

    /**
     * 头像路径
     * @param headImgPath 头像路径
     */
    public void setHeadImgPath(String headImgPath) {
        this.headImgPath = headImgPath == null ? null : headImgPath.trim();
    }

    /**
     * 用户手机号
     * @return user_tel 用户手机号
     */
    public String getUserTel() {
        return userTel;
    }

    /**
     * 用户手机号
     * @param userTel 用户手机号
     */
    public void setUserTel(String userTel) {
        this.userTel = userTel == null ? null : userTel.trim();
    }
}