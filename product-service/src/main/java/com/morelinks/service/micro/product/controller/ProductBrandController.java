package com.morelinks.service.micro.product.controller;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.product.api.model.ProductBrand;
import com.morelinks.feign.micro.product.api.model.dto.QueryProduct;
import com.morelinks.feign.micro.product.api.service.IProductBrandController;
import com.morelinks.service.micro.product.service.ProductBrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductBrandController
   implements IProductBrandController
{
    private Logger logger = LoggerFactory.getLogger(ProductBrandController.class);
    @Autowired
    public ProductBrandService baseService;

    @Override
    public ReturnValue<Integer> insert(@RequestBody ProductBrand obj)
    {
        baseService.insert(obj);
        return ReturnValue.get200OK(obj.getId());
    }

    @Override
    public ReturnValue<ProductBrand> getByPrimaryKey(@RequestParam(name = "id") Integer id)
    {
        return ReturnValue.get200OK(baseService.getByPrimaryKey(id));
    }

    @Override
    public ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id")Integer id)
    {
        return ReturnValue.get200OK(baseService.deleteByPrimaryKey(id));
    }

    @Override
    public ReturnValue<Integer> updateByPrimaryKey(@RequestBody ProductBrand obj)
    {
        return ReturnValue.get200OK(baseService.updateByPrimaryKey(obj));
    }

    @Override
    public ReturnValue<List<ProductBrand>> find(@RequestBody QueryPageParam<ProductBrand> query) {
        return ReturnValue.get200OK(baseService.find(query.getQuery(), query.getPage()));
    }
    @Override
    public ReturnValue<QueryResult<ProductBrand>> getQueryResult(@RequestBody QueryPageParam<ProductBrand> query) {
        return ReturnValue.get200OK(baseService.getQueryResult(query.getQuery(), query.getPage()));
    }

    @Override
    public ReturnValue<List<ProductBrand>> queryProduct(@RequestBody QueryProduct product) {
    return   ReturnValue.get200OK(this.baseService.queryProduct(product));
}
}
