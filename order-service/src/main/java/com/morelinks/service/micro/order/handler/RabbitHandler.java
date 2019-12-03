package com.morelinks.service.micro.order.handler;

import com.alibaba.fastjson.JSON;
import com.morelinks.common.core.rabbit.model.PayOrderSuccMessage;
import com.morelinks.service.micro.order.service.AgentOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitHandler {
	private Logger logger = LoggerFactory.getLogger(RabbitHandler.class);

	@Autowired
	AgentOrderService orderService;
	@RabbitListener(queues = "${rabbitmq.message.pay_order.succ.name}")
	public void processPayOrderSucc(String message) {
		try {
			PayOrderSuccMessage msg = JSON.parseObject(message.toString(), PayOrderSuccMessage.class);
			if (msg == null) {
				logger.error("processPayOrderSucc msg null",message);
				return;
			}
			orderService.paySucc(msg.getOrderId());
		}
		catch (Exception e)
		{
			logger.error("processPayOrderSucc error",e);
		}
	}
}
