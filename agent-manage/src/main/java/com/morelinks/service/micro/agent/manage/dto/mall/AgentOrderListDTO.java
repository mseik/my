package com.morelinks.service.micro.agent.manage.dto.mall;

import java.util.List;

/**
 * 订单列表对象
 */
public class AgentOrderListDTO {

	private List<AgentOrderListUnitDTO> list;

	public List<AgentOrderListUnitDTO> getList() {
		return list;
	}

	public void setList(List<AgentOrderListUnitDTO> list) {
		this.list = list;
	}
}
