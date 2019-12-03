package com.morelinks.service.micro.product.controller;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.product.api.model.ProductExtraInfo;
import com.morelinks.feign.micro.product.api.model.ProductModel;
import com.morelinks.feign.micro.product.api.service.IProductExtraInfoController;
import com.morelinks.service.micro.product.service.ProductExtraInfoService;
import com.morelinks.service.micro.product.service.ProductModelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class ProductExtraInfoController
   implements IProductExtraInfoController
{
    private Logger logger = LoggerFactory.getLogger(ProductExtraInfoController.class);
    @Autowired
    public ProductExtraInfoService baseService;
    @Override
    public ReturnValue<Integer> insert(@RequestBody ProductExtraInfo obj)
    {
        baseService.insert(obj);
        return ReturnValue.get200OK(obj.getId());
    }

    @Override
    public ReturnValue<ProductExtraInfo> getByPrimaryKey(@RequestParam(name = "id") Integer id)
    {
        return ReturnValue.get200OK(baseService.getByPrimaryKey(id));
    }

    @Override
    public ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id")Integer id)
    {
        return ReturnValue.get200OK(baseService.deleteByPrimaryKey(id));
    }

    @Override
    public ReturnValue<Integer> updateByPrimaryKey(@RequestBody ProductExtraInfo obj)
    {
        return ReturnValue.get200OK(baseService.updateByPrimaryKey(obj));
    }

    @Override
    public ReturnValue<List<ProductExtraInfo>> find(@RequestBody QueryPageParam<ProductExtraInfo> query) {
        return ReturnValue.get200OK(baseService.find(query.getQuery(), query.getPage()));
    }
    @Override
    public ReturnValue<QueryResult<ProductExtraInfo>> getQueryResult(@RequestBody QueryPageParam<ProductExtraInfo> query) {
        return ReturnValue.get200OK(baseService.getQueryResult(query.getQuery(), query.getPage()));
    }
    @Override
    public ReturnValue<ProductExtraInfo> getByExtraKey(@RequestParam(name = "extraKey")String extraKey,
                                                       @RequestParam(name = "extraType")Integer extraType) {

        ProductExtraInfo query = new ProductExtraInfo();
        query.setExtraKey(extraKey);
        query.setExtraType(extraType);

        return ReturnValue.get200OK(baseService.findTop1(query)) ;
    }

}
