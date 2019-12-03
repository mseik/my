package com.morelinks.service.micro.product.controller;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.product.api.model.ProductImg;
import com.morelinks.feign.micro.product.api.model.ProductModel;
import com.morelinks.feign.micro.product.api.service.IProductImgController;
import com.morelinks.service.micro.product.service.ProductImgService;
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
public class ProductImgController
   implements IProductImgController
{
    private Logger logger = LoggerFactory.getLogger(ProductImgController.class);
    @Autowired
    public ProductImgService baseService;
    @Autowired
    public ProductModelService modelService;

    @Override
    public ReturnValue<Integer> insert(@RequestBody ProductImg obj)
    {
        baseService.insert(obj);
        return ReturnValue.get200OK(obj.getId());
    }

    @Override
    public ReturnValue<ProductImg> getByPrimaryKey(@RequestParam(name = "id") Integer id)
    {
        return ReturnValue.get200OK(baseService.getByPrimaryKey(id));
    }

    @Override
    public ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id")Integer id)
    {
        return ReturnValue.get200OK(baseService.deleteByPrimaryKey(id));
    }

    @Override
    public ReturnValue<Integer> updateByPrimaryKey(@RequestBody ProductImg obj)
    {
        return ReturnValue.get200OK(baseService.updateByPrimaryKey(obj));
    }

    @Override
    public ReturnValue<List<ProductImg>> find(@RequestBody QueryPageParam<ProductImg> query) {
        return ReturnValue.get200OK(baseService.find(query.getQuery(), query.getPage()));
    }
    @Override
    public ReturnValue<QueryResult<ProductImg>> getQueryResult(@RequestBody QueryPageParam<ProductImg> query) {
        return ReturnValue.get200OK(baseService.getQueryResult(query.getQuery(), query.getPage()));
    }


}
