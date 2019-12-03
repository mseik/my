package com.morelinks.service.micro.agent.manage.controller.api.ice.mall;

import com.morelinks.core.dto.*;
import com.morelinks.core.model.Page;
import com.morelinks.core.model.QueryResult;
import com.morelinks.core.util.IntUtil;
import com.morelinks.feign.micro.product.api.client.ProductCategoryFeignClient;
import com.morelinks.feign.micro.product.api.model.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 商品类别
 */
@RestController
@RequestMapping("/api/productCategory")
public class ProductCategoryController {
	@Autowired
	ProductCategoryFeignClient productCategoryFeignClient;

	@RequestMapping(value = "/getSelectDataList", method = {RequestMethod.GET,RequestMethod.POST})
	public IceAjaxResult<IceSelectListData> getSelectDataList() {
		IceAjaxResult<IceSelectListData> result = new IceAjaxResult<IceSelectListData>();
		IceSelectListData lstData = new IceSelectListData();
		lstData.setList( new ArrayList());
		result.setData(lstData);
		QueryPageParam<ProductCategory> param = new QueryPageParam<ProductCategory>();
		ProductCategory query = new ProductCategory();
		query.setCategoryStatus(1);
		param.setQuery( query);
		ReturnValue<List<ProductCategory>> retLstBrand = productCategoryFeignClient.find(param);
		if(retLstBrand.getCode()==200 && retLstBrand.getObj()!=null)
		{
			for (ProductCategory obj:retLstBrand.getObj()
					) {
				IceSelectData data = new IceSelectData();
				data.setLabel(obj.getCategoryName());
				data.setValue(obj.getId().toString());
				lstData.getList().add(data);
			}
		}
		return result;
	}
}
