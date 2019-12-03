package com.morelinks.service.micro.order;

import com.morelinks.core.util.GenIdUtil;
import com.morelinks.feign.micro.order.api.dto.ConfigOrder4Creator;
import com.morelinks.feign.micro.order.api.model.AgentOrderDetail;
import com.morelinks.feign.micro.order.api.model.ConfigOrder;
import com.morelinks.feign.micro.order.api.model.dto.Query4ConfigOrder;
import com.morelinks.service.micro.order.controller.AgentOrderDetailController;
import com.morelinks.service.micro.order.controller.ConfigOrderController;
import com.morelinks.service.micro.order.service.ConfigOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MicroOrderApplicationTests {
	@Autowired
ConfigOrderController configOrderController;
@Autowired
ConfigOrderService  configOrderService;

@Autowired
AgentOrderDetailController agentOrderDetailController;


	@Test
	public void contextLoads() {
		AgentOrderDetail	agentOrderDetail=new AgentOrderDetail();
	agentOrderDetail.setId(77);
	agentOrderDetail.setAgentOrderId("666666");
	agentOrderDetail.setCoreProductType(1);
	agentOrderDetail.setCreateTime(new Date());
		agentOrderDetail.setDiscountAmount(new BigDecimal("6666666"));
		agentOrderDetail.setDiscountDesc("22");
		agentOrderDetail.setDiscountDesc("11");
		agentOrderDetail.setOriAmount(new BigDecimal("44"));
		agentOrderDetail.setProductAmount(new BigDecimal("17"));
		agentOrderDetail.setProductId(15);
		agentOrderDetail.setProductName("黑色");
		agentOrderDetail.setProductNum(178);
		agentOrderDetail.setRemark("ccs");
		agentOrderDetail.setUpdateTime(new Date());
		agentOrderDetailController.insert(agentOrderDetail);

	}
	@Test
	public void test4(){
		for(int i=0;i<100;i++){
			ConfigOrder4Creator  configOrder4Creator=new ConfigOrder4Creator();

			configOrder4Creator.setUerId(i+1);
			configOrder4Creator.setOrderName("嘿嘿");
			configOrder4Creator.setCityId("12306"+i);
			configOrder4Creator.setConfigCategoryIds("1,2,3,4,5,6,7,8");
			configOrder4Creator.setCustomerName("海骆驼");
			configOrder4Creator.setCustomerTel("17354288994");
			configOrder4Creator.setProjectAddress("芝加哥"+i);
			this.configOrderController.createrConfigOrder(configOrder4Creator);
		}
		/*ConfigOrder4Creator  configOrder4Creator=new ConfigOrder4Creator();
		configOrder4Creator.setUerId(123);
		configOrder4Creator.setOrderName("嘿嘿");
		configOrder4Creator.setCityId("12306");
		configOrder4Creator.setConfigCategoryIds("1,2,3,4,5,6,7,8");
		configOrder4Creator.setCustomerName("海骆驼");
		configOrder4Creator.setCustomerTel("17354288993");
		configOrder4Creator.setProjectAddress("芝加哥");

		System.out.println(this.configOrderController.createrConfigOrder(configOrder4Creator));*/


	}

	@Test
	public void modify(){

System.out.println(GenIdUtil.getIdByTimeStamp("123".toString(),17,false));
	}

	@Test
public  void testT(){
		Query4ConfigOrder query4ConfigOrder=new Query4ConfigOrder();
		query4ConfigOrder.setCustomerTel("17354288994");
		query4ConfigOrder.getPage().setLimit(10);
		query4ConfigOrder.getPage().setOffset(20);
		System.out.println(this.configOrderService.getQueryResultNew(query4ConfigOrder).getTotalCount());


	}
}
