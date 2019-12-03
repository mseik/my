package com.morelinks.service.micro.order.service;

import com.morelinks.core.exception.BusinessException;
import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.core.util.IntUtil;
import com.morelinks.core.util.StringUtil;
import com.morelinks.feign.micro.order.api.dto.ExpressOrder4Submit;
import com.morelinks.feign.micro.order.api.model.ExpressOrder;
import com.morelinks.feign.micro.order.api.model.ExpressOrderLog;
import com.morelinks.service.micro.order.mapper.ExpressOrderMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.prefs.BackingStoreException;

@Transactional
@Service
public class ExpressOrderService extends BaseServiceWithQueryPage<ExpressOrder,Integer,ExpressOrderMapper> {

	@Autowired
	AgentOrderService agentOrderService;
	@Autowired
	ExpressOrderLogService expressOrderLogService;
	/**
	 * 提交物流订单
	 * @param obj
	 * @return
	 */
	public ExpressOrder submitExpressOrder(ExpressOrder4Submit obj)
	{
		if(!IntUtil.isGreaterThanZero(obj.getOrderType()))
		{
			throw new BusinessException("当前订单不支持物流");
		}
		ExpressOrder expressOrder = new ExpressOrder();
		BeanUtils.copyProperties(obj,expressOrder);
		switch (expressOrder.getOrderType())
		{
			case 1:exAgentOrder( expressOrder);break;
		}
		expressOrder.setCreateTime(new Date());
		expressOrder.setUpdateTime(new Date());
		this.insert(expressOrder);
		ExpressOrderLog log = new ExpressOrderLog();
		log.setCityId("");
		log.setCreateTime(new Date());
		log.setExpressOrderId(expressOrder.getId());
		log.setLogContent("填写快递信息");
		log.setOperatorType(obj.getOrderType());
		log.setOperator(obj.getOperator());
		log.setRemark(obj.getOperatorRemark());
		log.setUpdateTime(new Date());
		expressOrderLogService.insert(log);
		return expressOrder;
	}

	private void exAgentOrder(ExpressOrder expressOrder)
	{
		agentOrderService.sendExpress(expressOrder);
	}
}