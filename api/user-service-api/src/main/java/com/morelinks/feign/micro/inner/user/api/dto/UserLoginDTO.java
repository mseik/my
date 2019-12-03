package com.morelinks.feign.micro.inner.user.api.dto;

public class UserLoginDTO {
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
	 * 系统类别，同一个系统只能有一个登录名，如1：迈联内部系统 2：迈联代理商销售系统
	 */
	private Integer systemType;

	/**
	 * 通行票据
	 */
	private String token;
	/**
	 * 所有角色名
	 */
	private String roles;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Integer getSystemType() {
		return systemType;
	}

	public void setSystemType(Integer systemType) {
		this.systemType = systemType;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}
}
