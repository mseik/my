package com.morelinks.service.micro.product.service;

import com.morelinks.core.exception.BusinessException;
import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.micro.product.api.model.ProductBrand;
import com.morelinks.feign.micro.product.api.model.dto.QueryProduct;
import com.morelinks.service.micro.product.mapper.ProductBrandMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class ProductBrandService extends BaseServiceWithQueryPage<ProductBrand,Integer,ProductBrandMapper> {
    public List<ProductBrand> queryProduct( QueryProduct product){
        if(product==null){

            throw  new BusinessException("引用对象为空");

        }
        if(product.getBrandIds().size()==0){

            return  new ArrayList<>();

        }
        List<ProductBrand>   productBrands=this.mapper.queryProduct(product);

    if (productBrands.size()==0){

        return  new ArrayList<>();

    }
        return productBrands;
    }
}