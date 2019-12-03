package com.morelinks.service.micro.agent.manage.controller.api.ice.mall;

import com.morelinks.core.dto.IceAjaxResult;
import com.morelinks.core.dto.IcePageData;
import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.Page;
import com.morelinks.core.model.QueryResult;
import com.morelinks.core.util.IntUtil;
import com.morelinks.core.util.StringUtil;
import com.morelinks.core.webutil.ResourceUtil;
import com.morelinks.feign.micro.product.api.client.ProductFeignClient;
import com.morelinks.feign.micro.product.api.client.ProductImgFeignClient;
import com.morelinks.feign.micro.product.api.client.ProductModelFeignClient;
import com.morelinks.feign.micro.product.api.model.Product;
import com.morelinks.feign.micro.product.api.model.ProductImg;
import com.morelinks.feign.micro.product.api.model.ProductModel;
import com.morelinks.service.micro.agent.manage.dto.mall.ProductImgUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品图片
 */
@RestController
@RequestMapping("/api/productImg")
public class ProductImgController {
	@Autowired
	ProductImgFeignClient imgFeignClient;
	@Autowired
	ProductFeignClient productFeignClient;
	@Autowired
	ProductModelFeignClient productModelFeignClient;

	@Autowired
	ResourceUtil resourceUtil;
	@RequestMapping(value = "/getList", method = {RequestMethod.GET,RequestMethod.POST})
	public IceAjaxResult<IcePageData<ProductImgUnit> > getList(
			Integer productId,
			Integer page,Integer pageSize
	) {
		IceAjaxResult<IcePageData<ProductImgUnit> > result = new IceAjaxResult<IcePageData<ProductImgUnit> >();
		if(!IntUtil.isGreaterThanZero(productId))
		{
			return IceAjaxResult.getFailResult("未找到该产品");
		}
		ReturnValue<Product> retProduct = productFeignClient.getByPrimaryKey(productId);
		if(retProduct.getCode()!=200 || retProduct.getObj()==null)
		{
			return IceAjaxResult.getFailResult("未找到该产品");
		}
		Product product = retProduct.getObj();
		ReturnValue<ProductModel> retModel = productModelFeignClient.getByPrimaryKey(product.getModelId());
		if(retModel.getCode()!=200 || retModel.getObj()==null )
		{
			return IceAjaxResult.getFailResult("产品的主系列未找到");
		}
		ProductModel model = retModel.getObj();
		if(!IntUtil.isGreaterThanZero(pageSize))
		{
			pageSize =200;
		}
		IcePageData<ProductImgUnit> pageResult = new IcePageData<ProductImgUnit>();
		pageResult.setCurrentPage(page);
		QueryPageParam<ProductImg> queryPageParam = new QueryPageParam<ProductImg>();
		ProductImg query = new ProductImg();
		query.setProductId(productId);
		query.setDelStatus(0);
		queryPageParam.setQuery(query);
		Page pageQuery = new Page();
		pageQuery.setLimit(pageSize);
		pageQuery.setOffset((page-1)*pageSize);
		queryPageParam.setPage(pageQuery);
		ReturnValue<QueryResult<ProductImg>> retResult = imgFeignClient.getQueryResult(queryPageParam);
		if(retResult.getCode()==200 && retResult.getObj()!=null  && retResult.getObj().getItems()!=null)
		{
			List<ProductImgUnit> lstUnit = new ArrayList<ProductImgUnit>();
			for (ProductImg img:retResult.getObj().getItems()
			     ) {
				ProductImgUnit imgUnit = new ProductImgUnit();
				imgUnit.setImgId(img.getId().toString());
				imgUnit.setImgPath(img.getImgPath());
				imgUnit.setImgUrl(resourceUtil.getImgUrl("/i/product/img/nopic.png"));
				if(StringUtil.isNotTrimBlank(img.getImgPath())) {
					imgUnit.setImgUrl(resourceUtil.getImgUrl(img.getImgPath()));
				}
				imgUnit.setProductCover(false);
				if(StringUtil.isNotTrimBlank(product.getCoverImgPath())
						&& product.getCoverImgPath().equalsIgnoreCase(img.getImgPath()))
				{
					imgUnit.setProductCover(true);
				}
				imgUnit.setModelCover(false);
				if(StringUtil.isNotTrimBlank(model.getCoverImgPath())
						&& model.getCoverImgPath().equalsIgnoreCase(img.getImgPath()))
				{
					imgUnit.setModelCover(true);
				}
				lstUnit.add(imgUnit);
			}
			pageResult.setList(lstUnit);
			pageResult.setTotal(retResult.getObj().getTotalCount());
			pageResult.setPageSize(pageSize);
		}
		result.setData(pageResult);
		return result;
	}


}
