package com.morelinks.service.micro.agent.manage.dto.configorder;

import java.math.BigDecimal;
import java.util.List;

/**
 * 商品 其他金额单元
 */
public class ConfigOrderOtherAmountListUnit {
	private String name;
	private BigDecimal amount;
	private  BigDecimal Percentage;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public BigDecimal getAmount() {
	return amount;
}

public void setAmount(BigDecimal amount) {
	this.amount = amount;
}

public BigDecimal getPercentage() {
	return Percentage;
}

public void setPercentage(BigDecimal percentage) {
	Percentage = percentage;
}

@Override
public String toString() {
	return "ConfigOrderOtherAmountListUnit{" +
		"name='" + name + '\'' +
		", amount=" + amount +
		", Percentage=" + Percentage +
		'}';
}
}
