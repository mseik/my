package com.morelinks.service.micro.agent.manage.dto.configorder;

import java.util.List;
import java.util.Map;

/**
 * 其他金额设置对象
 */
public class ConfigOtherAmountSetForm {

	private String orderId;
	/**
	 * 设备安装费类型 1：参与折扣 2：不参与折扣 3：按类别
	 */
	private Integer installAmountType;
	/**
	 * 安装折扣值
	 */
	private Double installAmountRate;
	/**
	 * 安装类别设置值
	 */
	private List<ConfigCategoryAmountSetUnit> lstInstallCateogry;
	/**
	 * 设备调试费类型 1：参与折扣 2：不参与折扣 3：按类别
	 */
	private Integer debugAmountType;
	/**
	 * 调试折扣值
	 */
	private Double debugAmountRate;
	/**
	 * 调试类别设置值
	 */
	private List<ConfigCategoryAmountSetUnit> lstDebugCateogry;
	/**
	 * 税费 1：默认 2：自定义
	 */
	private Integer taxType;
	/**
	 * 税费值
	 */
	private Double taxRate;
	private  Double defaultTaxRate;
	/**
	 * 其他自定义费用
	 */
	private List<ConfigOtherDefineAmountSetForm> otherAmounts;

	public Integer getInstallAmountType() {
		return installAmountType;
	}

	public void setInstallAmountType(Integer installAmountType) {
		this.installAmountType = installAmountType;
	}

	public Double getInstallAmountRate() {
		return installAmountRate;
	}

	public void setInstallAmountRate(Double installAmountRate) {
		this.installAmountRate = installAmountRate;
	}

	public List<ConfigCategoryAmountSetUnit> getLstInstallCateogry() {
		return lstInstallCateogry;
	}

	public void setLstInstallCateogry(List<ConfigCategoryAmountSetUnit> lstInstallCateogry) {
		this.lstInstallCateogry = lstInstallCateogry;
	}

	public Integer getDebugAmountType() {
		return debugAmountType;
	}

	public void setDebugAmountType(Integer debugAmountType) {
		this.debugAmountType = debugAmountType;
	}

	public Double getDebugAmountRate() {
		return debugAmountRate;
	}

	public void setDebugAmountRate(Double debugAmountRate) {
		this.debugAmountRate = debugAmountRate;
	}

	public List<ConfigCategoryAmountSetUnit> getLstDebugCateogry() {
		return lstDebugCateogry;
	}

	public void setLstDebugCateogry(List<ConfigCategoryAmountSetUnit> lstDebugCateogry) {
		this.lstDebugCateogry = lstDebugCateogry;
	}

	public Integer getTaxType() {
		return taxType;
	}

	public void setTaxType(Integer taxType) {
		this.taxType = taxType;
	}

	public Double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(Double taxRate) {
		this.taxRate = taxRate;
	}

	public List<ConfigOtherDefineAmountSetForm> getOtherAmounts() {
		return otherAmounts;
	}

	public void setOtherAmounts(List<ConfigOtherDefineAmountSetForm> otherAmounts) {
		this.otherAmounts = otherAmounts;
	}

public Double getDefaultTaxRate() {
	return defaultTaxRate;
}

public void setDefaultTaxRate(Double defaultTaxRate) {
	this.defaultTaxRate = defaultTaxRate;
}

public String getOrderId() {
	return orderId;
}

public void setOrderId(String orderId) {
	this.orderId = orderId;
}

@Override
public String toString() {
	return "ConfigOtherAmountSetForm{" +
		"orderId='" + orderId + '\'' +
		", installAmountType=" + installAmountType +
		", installAmountRate=" + installAmountRate +
		", lstInstallCateogry=" + lstInstallCateogry +
		", debugAmountType=" + debugAmountType +
		", debugAmountRate=" + debugAmountRate +
		", lstDebugCateogry=" + lstDebugCateogry +
		", taxType=" + taxType +
		", taxRate=" + taxRate +
		", defaultTaxRate=" + defaultTaxRate +
		", otherAmounts=" + otherAmounts +
		'}';
}
}
