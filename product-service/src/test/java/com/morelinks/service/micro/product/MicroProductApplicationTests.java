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
public class MicroProductApplicationTests {
/*@Autowired
ConfigProductCategoryMapService  configProductCategoryMapService;
	@Test
	public void contextLoads() {
	}

	@Test
	public void testBigDecimal() {
		BigDecimal b1 = BigDecimal.valueOf(2.13d);
		BigDecimal b2 = BigDecimal.valueOf(2.34d);
		BigDecimal b3 = b1.divide(b2,2,BigDecimal.ROUND_UP);
		BigDecimal b4 = b1.setScale(1,BigDecimal.ROUND_UP);
	}


	@Test
public void testOne(){
*//*		List<Integer> list=new ArrayList();
		list.add(1);
		list.add(5);
System.out.println(this.configCategoryService.getTreeQuery(list));*//*
		List<Integer> list=new ArrayList();
		List<Integer> cid=new ArrayList();
		list.add(1);
	System.out.println(this.configProductCategoryMapService.getMapKeyList(list));
		//this.configCategoryController.parentAggregate(list,cid);


	}*/


}
