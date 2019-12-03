package com.morelinks.service.micro.product.controller;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.product.api.model.DiscountInfo;
import com.morelinks.feign.micro.product.api.service.IDiscountInfoController;
import com.morelinks.service.micro.product.service.DiscountInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class DiscountInfoController
   implements IDiscountInfoController
{
    private Logger logger = LoggerFactory.getLogger(DiscountInfoController.class);
    @Autowired
    public DiscountInfoService baseService;

    @Override
    public ReturnValue<Integer> insert(@RequestBody DiscountInfo obj)
    {
        baseService.insert(obj);
        return ReturnValue.get200OK(obj.getId());
    }

    @Override
    public ReturnValue<DiscountInfo> getByPrimaryKey(@RequestParam(name = "id") Integer id)
    {
        return ReturnValue.get200OK(baseService.getByPrimaryKey(id));
    }

    @Override
    public ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id")Integer id)
    {
        return ReturnValue.get200OK(baseService.deleteByPrimaryKey(id));
    }

    @Override
    public ReturnValue<Integer> updateByPrimaryKey(@RequestBody DiscountInfo obj)
    {
        return ReturnValue.get200OK(baseService.updateByPrimaryKey(obj));
    }

    @Override
    public ReturnValue<List<DiscountInfo>> find(@RequestBody QueryPageParam<DiscountInfo> query) {
        return ReturnValue.get200OK(baseService.find(query.getQuery(), query.getPage()));
    }
    @Override
    public ReturnValue<QueryResult<DiscountInfo>> getQueryResult(@RequestBody QueryPageParam<DiscountInfo> query) {
        return ReturnValue.get200OK(baseService.getQueryResult(query.getQuery(), query.getPage()));
    }
    @Override
    public ReturnValue<List<DiscountInfo>> getValidDiscounts(@RequestParam(name = "id")String discountKey,
                                                @RequestParam(name = "discountType")Integer discountType,
                                                @RequestParam(name = "memberLevel")Integer memberLevel
    ) {
        ReturnValue<List<DiscountInfo>> ret = new ReturnValue<>();
        ret.setObj(new ArrayList<DiscountInfo>());
        DiscountInfo query = new DiscountInfo();
        query.setDiscountKey(discountKey);
        query.setDiscountType(discountType);
        query.setDiscountStatus(2);
        List<DiscountInfo> lst =baseService.find(query,null);
        if(lst!=null)
        {
            for (DiscountInfo discount:lst
                 ) {
                if(discount.getValidStartTime()!=null
                        && discount.getValidStartTime().after(new Date()))
                {
                    continue;
                }
                if(discount.getValidEndTime()!=null
                        && discount.getValidEndTime().before(new Date()))
                {
                    discount.setDiscountStatus(3);
                    discount.setUpdateTime(new Date());
                    baseService.updateByPrimaryKeySelective(discount);
                    continue;
                }
                ret.getObj().add(discount);
            }
        }
        return ReturnValue.get200OK(ret);
    }


}
