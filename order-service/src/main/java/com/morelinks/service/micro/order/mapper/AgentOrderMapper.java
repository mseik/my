package com.morelinks.service.micro.order.mapper;

import com.morelinks.core.mapper.BaseMapperWithQueryPage;
import com.morelinks.core.model.Page;
import com.morelinks.feign.micro.order.api.model.AgentOrder;
import com.morelinks.feign.micro.order.api.model.dto.Query4Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgentOrderMapper extends BaseMapperWithQueryPage<AgentOrder,String> {
	List<AgentOrder> queryPageResultNew(
			@Param(value="condition") Query4Order query,
			@Param(value="page")Page page);
	Integer queryPageResultCountNew(@Param(value="condition")Query4Order query);

}