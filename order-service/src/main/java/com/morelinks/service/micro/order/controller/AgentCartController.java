package com.morelinks.service.micro.order.controller;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.core.util.IntUtil;
import com.morelinks.feign.micro.order.api.model.AgentCart;
import com.morelinks.feign.micro.order.api.service.IAgentCartController;
import com.morelinks.service.micro.order.service.AgentCartService;
import com.rabbitmq.client.AMQP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class AgentCartController
   implements IAgentCartController
{
    private Logger logger = LoggerFactory.getLogger(AgentCartController.class);
    @Autowired
    public AgentCartService baseService;

    @Override
    public ReturnValue<Integer> insert(@RequestBody AgentCart obj)
    {
        baseService.insert(obj);
        return ReturnValue.get200OK(obj.getId());
    }

    @Override
    public ReturnValue<AgentCart>  getByPrimaryKey(@RequestParam(name = "id") Integer id)
    {
        return  ReturnValue.get200OK(baseService.getByPrimaryKey(id));
    }

    @Override
    public ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id")Integer id)
    {
        return  ReturnValue.get200OK(baseService.deleteByPrimaryKey(id));
    }

    @Override
    public ReturnValue<Integer> updateByPrimaryKey(@RequestBody AgentCart obj)
    {
        return  ReturnValue.get200OK(baseService.updateByPrimaryKey(obj));
    }

    @Override
    public ReturnValue<List<AgentCart>> find(@RequestBody QueryPageParam<AgentCart> query) {
        return ReturnValue.get200OK(baseService.find(query.getQuery(), query.getPage()));
    }
    @Override
    public ReturnValue<QueryResult<AgentCart>> getQueryResult(@RequestBody QueryPageParam<AgentCart> query) {
        return ReturnValue.get200OK(baseService.getQueryResult(query.getQuery(), query.getPage()));
    }

    @Override
    public ReturnValue<AgentCart> addOrSetProductNum(@RequestParam(name = "userId") Integer userId,
                                            @RequestParam(name = "productId") Integer productId,
                                            @RequestParam(name = "num") Integer num,
                                                   @RequestParam(name = "isSet") Boolean isSet)
    {
        ReturnValue<AgentCart> ret = new ReturnValue<AgentCart>();
        ret.setCode(500);
        if(!IntUtil.isGreaterThanZero(num))
        {
            ret.setMsg("num invalid");
            return ret;
        }
        if(!IntUtil.isGreaterThanZero(productId))
        {
            ret.setMsg("productId invalid");
            return ret;
        }
        if(!IntUtil.isGreaterThanZero(userId))
        {
            ret.setMsg("userId invalid");
            return ret;
        }
        AgentCart query = new AgentCart();
        query.setProductId(productId);
        query.setUserId(userId);
        AgentCart cart = baseService.findTop1(query);
        if(cart==null)
        {
            cart = new AgentCart();
            cart.setUserId(userId);
            cart.setProductId(productId);
            cart.setQuantity(num);
            cart.setCreateTime(new Date());
            cart.setUpdateTime(new Date());
            cart.setSelected(false);
            baseService.insert(cart);
        }
        else{
            cart.setQuantity(cart.getQuantity()+num);
            if(isSet!=null && isSet)
            {
                cart.setQuantity(num);
            }
            cart.setUpdateTime(new Date());
            baseService.updateByPrimaryKey(cart);
        }
        return ReturnValue.get200OK(cart);
    }

    @Override
    public ReturnValue updateProductSelStatus(@RequestParam(name = "userId") Integer userId,
                                       @RequestParam(name = "productId") Integer productId,
                                       @RequestParam(name = "selected") Boolean selected)
    {
        ReturnValue<AgentCart> ret = new ReturnValue<AgentCart>();
        ret.setCode(500);
        if(selected==null)
        {
            selected=false;
        }
        if(!IntUtil.isGreaterThanZero(productId))
        {
            ret.setMsg("productId invalid");
            return ret;
        }
        if(!IntUtil.isGreaterThanZero(userId))
        {
            ret.setMsg("userId invalid");
            return ret;
        }
        AgentCart query = new AgentCart();
        query.setProductId(productId);
        query.setUserId(userId);
        AgentCart cart = baseService.findTop1(query);
        if(cart==null)
        {
            ret.setMsg("productId invalid");
            return ret;
        }
        cart.setSelected(selected);
        cart.setUpdateTime(new Date());
        baseService.updateByPrimaryKeySelective(cart);
        return ReturnValue.get200OK(cart);
    }

    @Override
    public ReturnValue updateCartSelStatus(@RequestParam(name = "userId") Integer userId,
                                              @RequestParam(name = "selected") Boolean selected)
    {
        ReturnValue<AgentCart> ret = new ReturnValue<AgentCart>();
        ret.setCode(500);
        if(selected==null)
        {
            selected=false;
        }
        if(!IntUtil.isGreaterThanZero(userId))
        {
            ret.setMsg("userId invalid");
            return ret;
        }
        baseService.updateCartSelStatus(userId,selected);
        return ReturnValue.get200OK(null);
    }

    @Override
    public ReturnValue<Integer> getCountByUserId(@RequestParam(name = "userId") Integer userId)
    {
        ReturnValue<Integer> ret = new ReturnValue<>();
        if(!IntUtil.isGreaterThanZero(userId))
        {
            ret.setCode(500);
            ret.setMsg("userId invalid");
            return ret;
        }
        ret.setObj(baseService.getCountByUserId(userId));
        return ret;
    }
}
