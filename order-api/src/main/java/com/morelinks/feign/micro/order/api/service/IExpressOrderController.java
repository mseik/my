package com.morelinks.feign.micro.order.api.service;


import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.order.api.dto.ExpressOrder4Submit;
import com.morelinks.feign.micro.order.api.model.ExpressOrder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//import org.springframework.cloud.netflix.feign.FeignClient;

@RequestMapping("/expressOrder")
public interface IExpressOrderController {

	@RequestMapping(value = "/submitExpressOrder", method = {RequestMethod.POST})
	ReturnValue<ExpressOrder> submitExpressOrder(@RequestBody ExpressOrder4Submit expressOrder);
}