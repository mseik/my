package com.morelinks.service.micro.agent.manage.dto.mall;

import java.util.List;

/**
 * 地址列表对象
 */
public class DeliverAddressListDTO {

	private List<DeliverAddressUnit> list;
	/**
	 * 选中的地址Id
	 */
	private DeliverAddressUnit checkedAddress;

	public List<DeliverAddressUnit> getList() {
		return list;
	}

	public void setList(List<DeliverAddressUnit> list) {
		this.list = list;
	}

	public DeliverAddressUnit getCheckedAddress() {
		return checkedAddress;
	}

	public void setCheckedAddress(DeliverAddressUnit checkedAddress) {
		this.checkedAddress = checkedAddress;
	}
}
