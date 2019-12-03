package com.morelinks.service.micro.product.service;

import com.morelinks.core.exception.BusinessException;
import com.morelinks.core.model.Page;
import com.morelinks.core.model.QueryResult;
import com.morelinks.core.model.Sort;
import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.core.util.IntUtil;
import com.morelinks.feign.micro.product.api.dto.ConfigProductDTO;
import com.morelinks.feign.micro.product.api.model.ConfigProduct;
import com.morelinks.feign.micro.product.api.model.ConfigProductAgentExtra;
import com.morelinks.feign.micro.product.api.model.dto.Query4ConfigProductDTO;
import com.morelinks.feign.micro.product.api.model.dto.QueryAgentProduct;
import com.morelinks.service.micro.product.mapper.ConfigProductMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class ConfigProductService extends BaseServiceWithQueryPage<ConfigProduct, Integer, ConfigProductMapper> {

//	public List<ConfigProduct> QuerySortProduct(QueryAgentProduct query) {
//
//		if (query == null) {
//			throw new BusinessException("引用对象为空");
//		}
//
//		if ((query.getListMapKey() != null && query.getListMapKey().size() != 0) || (query.getListBrand() != null && query.getListBrand().size() != 0)) {
//			List<ConfigProduct> list = this.mapper.QuerySortProduct(query);
//
//			if (list.size() == 0) {
//				return new ArrayList<>();
//			}
//
//			return list;
//
//		} else {
//			return new ArrayList<>();
//		}
//
//	}

	@Autowired
	ConfigProductAgentExtraService configProductAgentExtraService;

	public QueryResult<ConfigProductDTO> queryConfigProductDTOs(Query4ConfigProductDTO query, Page page) {
		QueryResult<ConfigProductDTO> result = new QueryResult();
		result.setTotalCount(0);
		if (query == null || page == null) {
			return result;
		}
		result.setTotalCount(this.mapper.queryConfigProductPageResultCount(query));
		List<ConfigProductDTO> lstDTO = new ArrayList<>();
		result.setItems(lstDTO);
		if (!IntUtil.isGreaterThanZero(result.getTotalCount())) {
			return result;
		}
		List<ConfigProduct> lstProduct = this.mapper.queryConfigProductPageResult(query, page);
		if (lstProduct == null || lstProduct.size() <= 0) {
			return result;
		}
		for (ConfigProduct product : lstProduct
				) {
			ConfigProductDTO productDTO = new ConfigProductDTO();
			BeanUtils.copyProperties(product, productDTO);
			if (IntUtil.isGreaterThanZero(product.getAgentId())) {
				ConfigProductAgentExtra queryExtra = new ConfigProductAgentExtra();
				queryExtra.setAgentId(product.getAgentId());
				queryExtra.setConfigProductId(product.getId());
				ConfigProductAgentExtra extra = configProductAgentExtraService.findTop1(queryExtra);
				if (extra != null) {
					productDTO.setConfigProductAgentExtra(extra);
				}
			}
			lstDTO.add(productDTO);
		}
		return result;
	}


}