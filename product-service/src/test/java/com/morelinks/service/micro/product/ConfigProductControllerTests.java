package com.morelinks.service.micro.product;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.feign.micro.product.api.model.dto.Query4ConfigProductDTO;
import com.morelinks.service.micro.product.controller.ConfigCategoryController;
import com.morelinks.service.micro.product.controller.ConfigProductController;
import com.morelinks.service.micro.product.service.ConfigCategoryService;
//import com.morelinks.service.micro.product.service.ConfigProductCategoryMapService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MicroProductApplication.class)
public class ConfigProductControllerTests {
	@Autowired
	ConfigProductController configProductController;

	@Test
	public void testQueryConfigProductDTOs(){
//		Query4ConfigProductDTO query = new Query4ConfigProductDTO();
//		List<Integer> lstCategoryId  =new ArrayList<>();
//		lstCategoryId.add(2);
//		query.setCategoryIds(lstCategoryId);
//		query.setAgentId(3);
//		ReturnValue ret = configProductController.queryConfigProductDTOs(
//				new QueryPageParam<Query4ConfigProductDTO>(query,null));
	}
}
