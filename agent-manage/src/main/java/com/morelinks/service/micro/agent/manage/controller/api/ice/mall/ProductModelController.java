package com.morelinks.service.micro.agent.manage.controller.api.ice.mall;

import com.morelinks.core.dto.IceAjaxResult;
import com.morelinks.core.dto.IcePageData;
import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.Page;
import com.morelinks.core.model.QueryResult;
import com.morelinks.core.util.IntUtil;
import com.morelinks.feign.micro.product.api.client.ProductBrandFeignClient;
import com.morelinks.feign.micro.product.api.client.ProductCategoryFeignClient;
import com.morelinks.feign.micro.product.api.client.ProductModelFeignClient;
import com.morelinks.feign.micro.product.api.dto.ProductModelDTO;
import com.morelinks.feign.micro.product.api.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品型号详细信息相关
 */
@RestController
@RequestMapping("/api/productModel")
public class ProductModelController {
	@Autowired
	ProductModelFeignClient productModelFeignClient;
	@Autowired
	ProductCategoryFeignClient categoryFeignClient;

	@Autowired
	ProductBrandFeignClient brandFeignClient;

	@RequestMapping(value = "/getList", method = {RequestMethod.GET,RequestMethod.POST})
	public IceAjaxResult<IcePageData<ProductModel> > getList(Integer brandId,Integer categoryId,
			Integer page,Integer pageSize
	) {
		IceAjaxResult<IcePageData<ProductModel> > result = new IceAjaxResult< >();
		if(!IntUtil.isGreaterThanZero(page))
		{
			page =1;
		}
		if(!IntUtil.isGreaterThanZero(pageSize))
		{
			pageSize =10;
		}
		IcePageData<ProductModel> pageResult = new IcePageData<ProductModel>();
		pageResult.setCurrentPage(page);
		QueryPageParam<ProductModel> queryPageParam = new QueryPageParam<ProductModel>();
		ProductModel query = new ProductModel();
		query.setBrandId(brandId);
		query.setCategoryId(categoryId);
		queryPageParam.setQuery(query);
		Page pageQuery = new Page();
		pageQuery.setLimit(pageSize);
		pageQuery.setOffset((page-1)*pageSize);
		queryPageParam.setPage(pageQuery);
		ReturnValue<QueryResult<ProductModel>> retResult = productModelFeignClient.getQueryResult(queryPageParam);
		if(retResult.getCode()==200 &&  retResult.getObj()!=null)
		{
			pageResult.setList(retResult.getObj().getItems());
			pageResult.setTotal(retResult.getObj().getTotalCount());
			pageResult.setPageSize(pageSize);
		}
		result.setData(pageResult);
		return result;
	}

	@RequestMapping(value = "/getProductModelDTO", method = {RequestMethod.GET,RequestMethod.POST})
	public IceAjaxResult<ProductModelDTO> getProductModelDTO(Integer modelId
	) {
		IceAjaxResult<ProductModelDTO> result = new IceAjaxResult<ProductModelDTO>();
		ReturnValue<ProductModelDTO> retModel = productModelFeignClient.getModelDTO(modelId);
		result.setData(retModel.getObj());
		return result;
	}

}
