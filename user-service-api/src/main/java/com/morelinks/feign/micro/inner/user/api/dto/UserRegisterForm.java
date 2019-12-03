package com.morelinks.feign.micro.inner.user.api.dto;

/**
 * 用户注册form
 */
public class UserRegisterForm {
	/**
	 * 登录名
	 */
	private String userName;
	/**
	 * 昵称
	 */
	private String nickName;
	/**
	 * 真实姓名
	 */
	private String realName;
	/**
	 * 手机号
	 */
	private String userTel;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 确认密码
	 */
	private String confirmPassword;
	/**
	 * 注册的系统名称
	 */
	private String systemName;

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

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
}
