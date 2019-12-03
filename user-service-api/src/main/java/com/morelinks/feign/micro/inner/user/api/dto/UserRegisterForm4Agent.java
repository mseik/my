package com.morelinks.feign.micro.inner.user.api.dto;

/**
 *  代理商下面 用户注册form
 */
public class UserRegisterForm4Agent extends UserRegisterForm {
	private  Integer agentId;

	public Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}
}
