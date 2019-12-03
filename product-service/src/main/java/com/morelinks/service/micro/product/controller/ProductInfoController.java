package com.morelinks.service.micro.product.controller;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.product.api.model.ProductInfo;
import com.morelinks.feign.micro.product.api.model.ProductModel;
import com.morelinks.feign.micro.product.api.service.IProductInfoController;
import com.morelinks.service.micro.product.service.ProductInfoService;
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
public class ProductInfoController
   implements IProductInfoController
{
    private Logger logger = LoggerFactory.getLogger(ProductInfoController.class);
    @Autowired
    public ProductInfoService baseService;
    @Autowired
    public ProductModelService modelService;

    @Override
    public ReturnValue<Integer> insert(@RequestBody ProductInfo obj)
    {
        baseService.insert(obj);
        return ReturnValue.get200OK(obj.getId());
    }

    @Override
    public ReturnValue<ProductInfo> getByPrimaryKey(@RequestParam(name = "id") Integer id)
    {
        return ReturnValue.get200OK(baseService.getByPrimaryKey(id));
    }

    @Override
    public ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id")Integer id)
    {
        return ReturnValue.get200OK(baseService.deleteByPrimaryKey(id));
    }

    @Override
    public ReturnValue<Integer> updateByPrimaryKey(@RequestBody ProductInfo obj)
    {
        return ReturnValue.get200OK(baseService.updateByPrimaryKey(obj));
    }

    @Override
    public ReturnValue<List<ProductInfo>> find(@RequestBody QueryPageParam<ProductInfo> query) {
        return ReturnValue.get200OK(baseService.find(query.getQuery(), query.getPage()));
    }
    @Override
    public ReturnValue<QueryResult<ProductInfo>> getQueryResult(@RequestBody QueryPageParam<ProductInfo> query) {
        return ReturnValue.get200OK(baseService.getQueryResult(query.getQuery(), query.getPage()));
    }

    @Override
    public ReturnValue<ProductInfo> createNewProductInfo(@RequestParam(name = "modelId") Integer modelId)
    {
        ReturnValue<ProductInfo> ret = new ReturnValue<ProductInfo>();
        ProductModel model = modelService.getByPrimaryKey(modelId);
        if(model==null)
        {
            ret.setCode(500);
            ret.setMsg("未找到该型号");
            return ReturnValue.get200OK(ret);
        }
        ProductInfo info = new ProductInfo();
        info.setCategoryId(model.getCategoryId());
        info.setCreateTime(new Date());
        info.setModelId(model.getId());
        info.setProductStatus(0);
        info.setUpdateTime(new Date());
        info.setBrandId(model.getBrandId());
        info.setModelName(model.getModelName());
        baseService.insert(info);
        ProductInfo infoUpdate = new ProductInfo();
        infoUpdate.setId(info.getId());
        infoUpdate.setSerialNo(baseService.getSerialNoById(info.getId(),8));
        baseService.updateByPrimaryKeySelective(infoUpdate);
        info.setSerialNo(infoUpdate.getSerialNo());
        ret.setObj(info);
        return ReturnValue.get200OK(ret);
    }


}
