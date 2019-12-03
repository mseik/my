package com.morelinks.service.micro.agent.manage.dto.configorder;

import java.math.BigDecimal;
import java.util.List;

/**
 * 订单商品对象
 */
public class ConfigTotalSelectedProductDTO {
	/**
	 * 类别商品集合
	 */
	private List<ConfigCategorySelectedProductListUnit> listProduct;

	/**
	 * 产品总价
	 */
	private BigDecimal productTotalAmount;
	/**
	 * 其他额外价格
	 */
	private List<ConfigOrderOtherAmountListUnit> lstOtherAmount;

	/**
	 * 订单总价
	 */
	private BigDecimal totalAmount;

public List<ConfigCategorySelectedProductListUnit> getListProduct() {
	return listProduct;
}

public void setListProduct(List<ConfigCategorySelectedProductListUnit> listProduct) {
	this.listProduct = listProduct;
}

public BigDecimal getProductTotalAmount() {
	return productTotalAmount;
}

public void setProductTotalAmount(BigDecimal productTotalAmount) {
	this.productTotalAmount = productTotalAmount;
}

public List<ConfigOrderOtherAmountListUnit> getLstOtherAmount() {
	return lstOtherAmount;
}

public void setLstOtherAmount(List<ConfigOrderOtherAmountListUnit> lstOtherAmount) {
	this.lstOtherAmount = lstOtherAmount;
}

public BigDecimal getTotalAmount() {
	return totalAmount;
}

public void setTotalAmount(BigDecimal totalAmount) {
	this.totalAmount = totalAmount;
}

@Override
public String toString() {
	return "ConfigTotalSelectedProductDTO{" +
		"listProduct=" + listProduct +
		", productTotalAmount=" + productTotalAmount +
		", lstOtherAmount=" + lstOtherAmount +
		", totalAmount=" + totalAmount +
		'}';
}
}
