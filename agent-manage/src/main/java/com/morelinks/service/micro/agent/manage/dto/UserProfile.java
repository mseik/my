package com.morelinks.service.micro.agent.manage.dto;

/**
 * 用户简介
 */
public class UserProfile {

	/**
	 * 用户头像
	 */
	private String headImg;
	/**
	 * 用户昵称
	 */
	private String nickName;

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
}
