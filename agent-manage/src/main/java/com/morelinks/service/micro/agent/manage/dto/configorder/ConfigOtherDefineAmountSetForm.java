package com.morelinks.service.micro.agent.manage.dto.configorder;

import java.util.List;
import java.util.Map;

/**
 * 其他自定义金额设置对象
 */
public class ConfigOtherDefineAmountSetForm {

	/**
	 * 名称
	 */
	private String name;
	/**
	 * 金额
	 */
	private String amount;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

@Override
public String toString() {
	return "ConfigOtherDefineAmountSetForm{" +
		"name='" + name + '\'' +
		", amount='" + amount + '\'' +
		'}';
}
}
