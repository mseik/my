package com.morelinks.service.micro.agent.manage.controller.api.ice.mall;

import com.morelinks.core.dto.IceAjaxResult;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.util.IntUtil;
import com.morelinks.feign.micro.product.api.client.ProductExtraInfoFeignClient;
import com.morelinks.feign.micro.product.api.client.ProductFeignClient;
import com.morelinks.feign.micro.product.api.client.ProductModelFeignClient;
import com.morelinks.feign.micro.product.api.model.ProductExtraInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品额外信息
 */
@RestController
@RequestMapping("/api/productExtra")
public class ProductExtraInfoController {
	@Autowired
	ProductFeignClient productFeignClient;
	@Autowired
	ProductExtraInfoFeignClient extraInfoFeignClient;
	@Autowired
	ProductModelFeignClient modelFeignClient;

	@RequestMapping(value = "/getExtraInfo", method = {RequestMethod.GET,RequestMethod.POST})
	public IceAjaxResult<ProductExtraInfo> getExtraInfo(
			Integer modelId,Integer productId
	) {
		IceAjaxResult<ProductExtraInfo> result = new IceAjaxResult<ProductExtraInfo>();
		String key ="";
		Integer type =0;
		if(IntUtil.isGreaterThanZero(modelId))
		{
			type =1;
			key =modelId.toString();
		}
		if(IntUtil.isGreaterThanZero(productId))
		{
			type =2;
			key =productId.toString();
		}
		if(type<=0)
		{
			return IceAjaxResult.getFailResult("获取信息失败");
		}
		ReturnValue<ProductExtraInfo> retExtra = extraInfoFeignClient.getByExtraKey(key,type);
		if(retExtra.getCode()!=200)
		{
			return IceAjaxResult.getFailResult("系统繁忙，请稍后再试！");
		}
		result.setData(retExtra.getObj());
		return result;
	}



}
