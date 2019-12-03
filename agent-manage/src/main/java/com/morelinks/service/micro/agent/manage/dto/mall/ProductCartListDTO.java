package com.morelinks.service.micro.agent.manage.dto.mall;

import java.util.List;

/**
 * 产品售卖对象
 */
public class ProductCartListDTO {

	private List<ProductCartUnit> list;

	private double totalAmount;
	private List<String> selectedKeys;
	public List<ProductCartUnit> getList() {
		return list;
	}

	public void setList(List<ProductCartUnit> list) {
		this.list = list;
	}

	public List<String> getSelectedKeys() {
		return selectedKeys;
	}

	public void setSelectedKeys(List<String> selectedKeys) {
		this.selectedKeys = selectedKeys;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
}
