package com.morelinks.service.micro.product.controller;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.Page;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.product.api.dto.ProductDTO;
import com.morelinks.feign.micro.product.api.dto.ProductModelDTO;
import com.morelinks.feign.micro.product.api.model.*;
import com.morelinks.feign.micro.product.api.model.dto.Query4ProductModel;
import com.morelinks.feign.micro.product.api.service.IProductModelController;
import com.morelinks.service.micro.product.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductModelController
   implements IProductModelController
{
    private Logger logger = LoggerFactory.getLogger(ProductModelController.class);
    @Autowired
    public ProductModelService baseService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductImgService productImgService;

    @Autowired
    private ProductPropertyService productPropertyService;

    @Autowired
    private ProductPropertyTypeService productPropertyTypeService;

    @Override
    public ReturnValue<Integer> insert(@RequestBody ProductModel obj)
    {
        baseService.insert(obj);
        return ReturnValue.get200OK(obj.getId());
    }

    @Override
    public ReturnValue<ProductModel> getByPrimaryKey(@RequestParam(name = "id") Integer id)
    {
        return ReturnValue.get200OK(baseService.getByPrimaryKey(id));
    }

    @Override
    public ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id")Integer id)
    {
        return ReturnValue.get200OK(baseService.deleteByPrimaryKey(id));
    }

    @Override
    public ReturnValue<Integer> updateByPrimaryKey(@RequestBody ProductModel obj)
    {
        return ReturnValue.get200OK(baseService.updateByPrimaryKey(obj));
    }

    @Override
    public ReturnValue<List<ProductModel>> find(@RequestBody QueryPageParam<ProductModel> query) {
        return ReturnValue.get200OK(baseService.find(query.getQuery(), query.getPage()));
    }
    @Override
    public ReturnValue<QueryResult<ProductModel>> getQueryResult(@RequestBody QueryPageParam<ProductModel> query) {
        return ReturnValue.get200OK(baseService.getQueryResult(query.getQuery(), query.getPage()));
    }

    @Override
    public ReturnValue<QueryResult<ProductModelDTO>> getModelDTOQueryResult(@RequestBody QueryPageParam<Query4ProductModel> query) {
        QueryResult<ProductModelDTO> dtoQueryResult = new QueryResult<ProductModelDTO>();
        dtoQueryResult.setTotalCount(0);
        QueryResult<ProductModel> modelResult = baseService.getQueryResultNew(query.getQuery(), query.getPage());
        if(modelResult==null)
        {
            return ReturnValue.get200OK(dtoQueryResult);
        }
        dtoQueryResult.setTotalCount(modelResult.getTotalCount());
        List<ProductModelDTO> lstDTO = new ArrayList<ProductModelDTO>();
        if(modelResult.getItems()!=null)
        {
            for (ProductModel model:modelResult.getItems()
                 ) {
                ProductModelDTO dto = convertToDTO(model);
                lstDTO.add(dto);
            }
        }
        dtoQueryResult.setItems(lstDTO);
        return ReturnValue.get200OK(dtoQueryResult);
    }

    @Override
    public ReturnValue<ProductModelDTO> getModelDTO(@RequestParam(name = "id")Integer id) {
        ProductModel model = baseService.getByPrimaryKey(id);
        return ReturnValue.get200OK(convertToDTO(model));
    }

    private ProductModelDTO convertToDTO(ProductModel model )
    {
        ProductModelDTO dto = new ProductModelDTO();
        BeanUtils.copyProperties(model,dto);
        Product queryProduct = new Product();
        queryProduct.setModelId(model.getId());
        queryProduct.setProductStatus(1);
        List<Product> lstProduct = productService.find(queryProduct,null);
        if(lstProduct!=null){
            List<ProductDTO> lstDTO = new ArrayList<ProductDTO>();
            for (Product product:lstProduct
                 ) {
                ProductDTO productDTO = productService.getProductDTO(product);
                if(productDTO==null)
                {
                    continue;
                }
                lstDTO.add(productDTO);
            }
            dto.setLstProduct(lstDTO);
        }
        ProductImg queryImg = new ProductImg();
        queryImg.setModelId(model.getId());
        queryImg.setShowStatus(1);
        queryImg.setDelStatus(0);
        Page pageImg = new Page();
        pageImg.setLimit(10);
        dto.setLstImg(productImgService.getQueryResult(queryImg,pageImg).getItems());
        ProductProperty queryProperty = new ProductProperty();
        queryProperty.setModelId(model.getId());
        queryProperty.setPropertyStatus(1);
        dto.setLstProperty(productPropertyService.find(queryProperty,null));
        ProductPropertyType queryPropertyType = new ProductPropertyType();
        queryPropertyType.setModelId(model.getId());
        queryPropertyType.setPropertyTypeStatus(1);
        dto.setLstPropertyType(productPropertyTypeService.find(queryPropertyType,null));
        return dto;
    }
}
