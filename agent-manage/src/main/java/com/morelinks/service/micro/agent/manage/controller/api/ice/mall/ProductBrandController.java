package com.morelinks.service.micro.agent.manage.controller.api.ice.mall;

import com.morelinks.core.dto.*;
import com.morelinks.core.model.Page;
import com.morelinks.core.model.QueryResult;
import com.morelinks.core.util.IntUtil;
import com.morelinks.feign.micro.product.api.client.ProductBrandFeignClient;
import com.morelinks.feign.micro.product.api.client.ProductSupplierFeignClient;
import com.morelinks.feign.micro.product.api.model.ProductBrand;
import com.morelinks.feign.micro.product.api.model.ProductSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 品牌
 */
@RestController
@RequestMapping("/api/productBrand")
public class ProductBrandController {
	@Autowired
	ProductBrandFeignClient productBrandFeignClient;
	@Autowired
	ProductSupplierFeignClient supplierFeignClient;

	@RequestMapping(value = "/getList", method = {RequestMethod.GET,RequestMethod.POST})
	public IceAjaxResult<IcePageData<ProductBrand> > getList(
			Integer page,Integer pageSize
	) {
		IceAjaxResult<IcePageData<ProductBrand> > result = new IceAjaxResult<>();
		if(!IntUtil.isGreaterThanZero(page))
		{
			page =1;
		}
		if(!IntUtil.isGreaterThanZero(pageSize))
		{
			pageSize =10;
		}
		IcePageData<ProductBrand> pageResult = new IcePageData<ProductBrand>();
		pageResult.setCurrentPage(page);
		QueryPageParam<ProductBrand> queryPageParam = new QueryPageParam<ProductBrand>();
		ProductBrand query = new ProductBrand();
		queryPageParam.setQuery(query);
		Page pageQuery = new Page();
		pageQuery.setLimit(pageSize);
		pageQuery.setOffset((page-1)*pageSize);
		queryPageParam.setPage(pageQuery);
		ReturnValue<QueryResult<ProductBrand>> retResult = productBrandFeignClient.getQueryResult(queryPageParam);
		if(retResult.getCode()==200 && retResult.getObj()!=null)
		{
			pageResult.setList(retResult.getObj().getItems());
			pageResult.setTotal(retResult.getObj().getTotalCount());
			pageResult.setPageSize(pageSize);
		}
		result.setData(pageResult);
		return result;
	}


	@RequestMapping(value = "/getSelectDataList", method = {RequestMethod.GET,RequestMethod.POST})
	public IceAjaxResult<IceSelectListData> getSelectDataList() {
		IceAjaxResult<IceSelectListData> result = new IceAjaxResult<IceSelectListData>();
		IceSelectListData lstData = new IceSelectListData();
		lstData.setList( new ArrayList<IceSelectData>());
		result.setData(lstData);
		QueryPageParam<ProductBrand> param = new QueryPageParam<ProductBrand>();
		ProductBrand query = new ProductBrand();
		query.setBrandStatus(1);
		param.setQuery( query);
		ReturnValue<List<ProductBrand>> retLstBrand = productBrandFeignClient.find(param);
		if(retLstBrand.getCode()==200 && retLstBrand.getObj()!=null)
		{
			for (ProductBrand brand:retLstBrand.getObj()
			     ) {
				IceSelectData data = new IceSelectData();
				data.setLabel(brand.getBrandName());
				data.setValue(brand.getId().toString());
				lstData.getList().add(data);
			}
		}
		return result;
	}
}
