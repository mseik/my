package com.morelinks.service.micro.product.service;

import com.morelinks.core.model.Page;
import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.core.util.IntUtil;
import com.morelinks.core.util.StringUtil;
import com.morelinks.feign.micro.product.api.dto.ProductDTO;
import com.morelinks.feign.micro.product.api.model.Product;
import com.morelinks.feign.micro.product.api.model.ProductImg;
import com.morelinks.feign.micro.product.api.model.ProductProperty;
import com.morelinks.service.micro.product.mapper.ProductMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class ProductService extends BaseServiceWithQueryPage<Product,Integer,ProductMapper> {

	@Autowired
	ProductPropertyService productPropertyService;
	@Autowired
	ProductImgService productImgService;
	public ProductDTO getProductDTO(Integer id) {
		Product obj = this.getByPrimaryKey(id);
		return getProductDTO(obj);
	}


	public ProductDTO getProductDTO(Product obj ) {
		ProductDTO dto = new ProductDTO();
		BeanUtils.copyProperties(obj,dto);
		if(StringUtil.isNotTrimBlank(obj.getProductProperties()))
		{
			String[] arrId = obj.getProductProperties().split(",");
			List<ProductProperty> lstProperty = new ArrayList<>();
			for (String propertyId:arrId
			     ) {
				Integer nPropertyId = IntUtil.parseInt(propertyId,false);
				if(!IntUtil.isGreaterThanZero(nPropertyId))
				{
					continue;
				}
				ProductProperty property = productPropertyService.getByPrimaryKey(nPropertyId);
				if(property==null)
				{
					continue;
				}
				lstProperty.add(property);
			}
			dto.setLstProperty(lstProperty);
		}

		ProductImg queryImg = new ProductImg();
		queryImg.setProductId(obj.getId());
		queryImg.setShowStatus(1);
		queryImg.setDelStatus(0);
		Page pageImg = new Page();
		pageImg.setSort("show_weight");
		pageImg.setOrder("desc");
		pageImg.setLimit(5);
		dto.setLstImg(productImgService.getQueryResult(queryImg,pageImg).getItems());
		return dto;
	}
}