package com.morelinks.service.micro.agent.manage.dto.mall;

/**
 * 代理商账户信息
 */
public class AgentAccountDTO {

	/**
	 * 会员等级
	 */
	private Integer level;

	/**
	 * 等级名称 用来显示
	 */
	private String levelName;

	/**
	 * 货款账户
	 */
	private Double goodsAccountAmount;

	/**
	 * 普通账户
	 */
	private Double accountAmount;

	private String validEndTime;

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public Double getGoodsAccountAmount() {
		return goodsAccountAmount;
	}

	public void setGoodsAccountAmount(Double goodsAccountAmount) {
		this.goodsAccountAmount = goodsAccountAmount;
	}

	public Double getAccountAmount() {
		return accountAmount;
	}

	public void setAccountAmount(Double accountAmount) {
		this.accountAmount = accountAmount;
	}

	public String getValidEndTime() {
		return validEndTime;
	}

	public void setValidEndTime(String validEndTime) {
		this.validEndTime = validEndTime;
	}
}
