package com.morelinks.service.micro.order.controller;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.core.util.IntUtil;
import com.morelinks.feign.micro.order.api.dto.ExpressOrder4Submit;
import com.morelinks.feign.micro.order.api.model.ExpressOrder;
import com.morelinks.feign.micro.order.api.service.IExpressOrderController;
import com.morelinks.service.micro.order.service.ExpressOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class ExpressOrderController
   implements IExpressOrderController
{
    private Logger logger = LoggerFactory.getLogger(ExpressOrderController.class);
    @Autowired
    public ExpressOrderService baseService;

    @Override
    public ReturnValue<ExpressOrder> submitExpressOrder(@RequestBody ExpressOrder4Submit expressOrder)
    {
        return ReturnValue.get200OK(baseService.submitExpressOrder(expressOrder));
    }
}
