package com.morelinks.service.micro.agent.manage;

import com.alibaba.fastjson.JSON;
import com.morelinks.feign.micro.inner.user.api.model.UserInfo;
import com.morelinks.service.micro.agent.manage.controller.api.ice.configorder.ConfigOrderController;
import com.morelinks.service.micro.agent.manage.controller.api.ice.configorder.ConfigProductCategoryController;
import com.morelinks.service.micro.agent.manage.controller.api.ice.configorder.ConfigProductController;
import com.morelinks.service.micro.agent.manage.dto.ExtraDiscountDTO;
import com.morelinks.service.micro.agent.manage.dto.configorder.ConfigCategoryAmountSetUnit;
import com.morelinks.service.micro.agent.manage.dto.configorder.ConfigOrderForm;
import com.morelinks.service.micro.agent.manage.dto.configorder.ConfigOtherAmountSetForm;
import com.morelinks.service.micro.agent.manage.dto.configorder.ConfigOtherDefineAmountSetForm;
import com.morelinks.service.micro.agent.manage.dto.mall.TemplatePdfDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MicroAgentManageApplicationTests {
	@Autowired
ConfigProductCategoryController configProductCategoryController;
@Autowired
ConfigOrderController configOrderController;
@Autowired
ConfigProductController productController;

	@Test
	public void contextLoads() {
/*		ConfigOrderForm{id='', orderName='gt', customerName='gtr', customerTel='17354288993',
		lstCategorySelData=[3, 4, 5], lstCategory=null, cityId='101010300', listCity=null, address='tr'}*/

			List<String>  strings=new ArrayList<>();
		strings.add("2");
		strings.add("3");
		ConfigOrderForm  configOrderForm=new ConfigOrderForm();
		configOrderForm.setAddress("我我");
		configOrderForm.setCityId("101010300");
		configOrderForm.setLstCategorySelData(strings);
		configOrderForm.setCustomerName("哈哈");
		configOrderForm.setCustomerTel("18868119999");
		configOrderForm.setOrderName("新增");
		configOrderForm.setId("");
		UserInfo user =new UserInfo();
		user.setId(4);

		user.setUserName("xzb");
		user.setPassword("xzb");
		user.setUserStatus(1);
System.out.println(this.configOrderController.submitOrder(configOrderForm,user)
);


	}
@Test
public  void testA() {
	UserInfo user =new UserInfo();
	user.setId(4);

	user.setUserName("xzb");
	user.setPassword("xzb");
	user.setUserStatus(1);
System.out.println(	this.configProductCategoryController.getCategoryMenus(user,"75741084055921").getData().getValue());

}
@Test
public  void testB() {
	UserInfo user =new UserInfo();
	user.setId(32);

	user.setUserName("xzb");
	user.setPassword("xzb");
	user.setUserStatus(1);
	System.out.println(this.configOrderController.addProduct("08341597355727","1","0",user).getMessage());

}
@Test
public  void testC() {
	UserInfo user =new UserInfo();
	user.setId(4);

	user.setUserName("xzb");
	user.setPassword("xzb");
	user.setUserStatus(1);
	System.out.println(this.configOrderController.getSelectedProductList("014539415590506",1,10,user).getData().getList());


}
@Test
public  void  testD(){
	UserInfo user =new UserInfo();
	user.setId(32);

	user.setUserName("xzb");
	user.setPassword("xzb");
	user.setUserStatus(1);
	System.out.println(this.configOrderController.deleteSelectedProducts("30141008155774","2,1", user).getMessage());
	//this.configOrderController.deleteSelectedProducts("014539415590506","2", user);

}
@Test
public  void  testE(){
	UserInfo user =new UserInfo();
	user.setId(4);

	user.setUserName("xzb");
	user.setPassword("xzb");
	user.setUserStatus(1);
	System.out.println(	this.configOrderController.getSumSelectedProductList("014539415590506","2,3",1,10,user).getData().getIcePageData().getList());

}
@Test
public  void  testF() {
	UserInfo user =new UserInfo();
	user.setId(4);

	user.setUserName("xzb");
	user.setPassword("xzb");
	user.setUserStatus(1);
	System.out.println(this.configOrderController.getTotalSelectedProductDTO("40041442855927",user).getData());

}
@Test
public  void  testG() {
	UserInfo user =new UserInfo();
	user.setId(4);

	user.setUserName("xzb");
	user.setPassword("xzb");
	user.setUserStatus(1);
	System.out.println(this.productController.getConfigProductList(null,"dsjfbjds",null,
		1,10,user,"014539415590506").getData().getList());
}
@Test
public void testH(){
	UserInfo user =new UserInfo();
	user.setId(4);

	user.setUserName("xzb");
	user.setPassword("xzb");
	user.setUserStatus(1);
	System.out.println(	this.configOrderController.getOrderForm("014539415590506",user).getData().getLstCategory());

}
@Test
public void testZ(){
	UserInfo user =new UserInfo();
	user.setId(4);
	user.setUserName("xzb");
	user.setPassword("xzb");
	user.setUserStatus(1);
	ConfigOtherAmountSetForm  form=new ConfigOtherAmountSetForm();
	form.setInstallAmountType(2);
	form.setInstallAmountRate(73.0);
	List<ConfigCategoryAmountSetUnit>  unitList=new ArrayList<>();
	ConfigCategoryAmountSetUnit  unit=new ConfigCategoryAmountSetUnit();
	unit.setCategoryId(8);
	unit.setCategoryName("分类2");
	unit.setAmount("0.59");
	unitList.add(unit);
	form.setLstInstallCateogry(unitList);
	unit.setAmountType(1);
	form.setDebugAmountType(2);
	form.setDebugAmountRate(44.0);
	form.setTaxType(1);
	form.setTaxRate(88.0);
	ConfigOtherDefineAmountSetForm  otherDefineAmountSetForm=new ConfigOtherDefineAmountSetForm();
	otherDefineAmountSetForm.setName("车费");
	otherDefineAmountSetForm.setAmount("-5000");
	List<ConfigOtherDefineAmountSetForm>  forms=new ArrayList<>();
	forms.add(otherDefineAmountSetForm);
	form.setOtherAmounts(forms);
form.setOrderId("30341483755896");

	//System.out.println();
	System.out.println(JSON.toJSONString(this.configOrderController.submitOtherAmountSetForm(form,user)));

}
@Test
public void testW(){
	UserInfo user =new UserInfo();
	user.setId(4);
	user.setUserName("xzb");
	user.setPassword("xzb");
	user.setUserStatus(1);
	System.out.println(this.configOrderController.getOtherAmountSetForm("014539415590506",user).getMessage());
}
@Test
public void testY(){
	UserInfo user =new UserInfo();
	user.setId(4);
	user.setUserName("xzb");
	user.setPassword("xzb");
	user.setUserStatus(1);
	System.out.println(this.configOrderController.modifyStatus("23941432255722","3",user).getStatus());

}
@Test
public void testO(){
	UserInfo user =new UserInfo();
	user.setId(4);
	user.setUserName("xzb");
	user.setPassword("xzb");
	user.setUserStatus(1);
	System.out.println(this.configOrderController.getStatistics("04641253955901",user).getData());

}
@Test
public void testK(){
	UserInfo user =new UserInfo();
	user.setId(4);
	user.setUserName("xzb");
	user.setPassword("xzb");
	user.setUserStatus(1);
	System.out.println(this.configProductCategoryController.getBrandList(user).getData());
}

@Test
public void  testV(){
	UserInfo user =new UserInfo();
	user.setId(4);
	user.setUserName("xzb");
	user.setPassword("xzb");
	user.setUserStatus(1);
	System.out.println(this.configOrderController.putDiscount("14","1","29",user));
}
@Test
public  void testR(){
	UserInfo user =new UserInfo();
	user.setId(4);
	user.setUserName("xzb");
	user.setPassword("xzb");
	user.setUserStatus(1);
	System.out.println(this.configOrderController.deleteOrder("014539415590506",user).getMessage());
}
@Test
public void testJ(){
	UserInfo user =new UserInfo();
	user.setId(4);
	user.setUserName("xzb");
	user.setPassword("xzb");
	user.setUserStatus(1);
	ExtraDiscountDTO  extraDiscountDTO=new ExtraDiscountDTO();
	extraDiscountDTO.setTaxation(".425");
	extraDiscountDTO.setDebugging("33");
	extraDiscountDTO.setEquipment("29");
	System.out.println(this.configOrderController.putCostSetup(extraDiscountDTO,user).getMessage());

}
@Test
public void tesA(){
	UserInfo user =new UserInfo();
	user.setId(4);
	user.setUserName("xzb");
	user.setPassword("xzb");
	user.setUserStatus(1);
	//System.out.println(this.configProductCategoryController.getClassification().getData());

}
@Test
public void tesB(){
	UserInfo user =new UserInfo();
	user.setId(4);
	user.setUserName("xzb");
	user.setPassword("xzb");
	user.setUserStatus(1);
	System.out.println(this.configOrderController.getCostSetup(user).getData());

}

@Test
public  void tesC(){
	UserInfo user =new UserInfo();
	user.setId(4);
	user.setUserName("xzb");
	user.setPassword("xzb");
	user.setUserStatus(1);
	System.out.println(this.configOrderController.getTemplate(user).getData())	;
}

@Test
public void tesD(){
	UserInfo user =new UserInfo();
	user.setId(4);
	user.setUserName("xzb");
	user.setPassword("xzb");
	user.setUserStatus(1);
	TemplatePdfDTO  templatePdfDTO=new TemplatePdfDTO();
	templatePdfDTO.setFooterMessage("页眉");
	templatePdfDTO.setHeaderMessage("提示");
	templatePdfDTO.setTipsMessage("页脚");
	templatePdfDTO.setWatermarkMessage("水印信息");
	System.out.println(this.configOrderController.setTemplate(templatePdfDTO,user));

}
@Test
public void tesE(){
	UserInfo user =new UserInfo();
	user.setId(4);
	user.setUserName("xzb");
	user.setPassword("xzb");
	user.setUserStatus(1);
	System.out.println(this.configOrderController.getTemplate(user).getData());
}

@Test
public  void  tesFg(){
	UserInfo user =new UserInfo();
	user.setId(4);
	user.setUserName("xzb");
	user.setPassword("xzb");
	user.setUserStatus(1);
//	System.out.println(this.configOrderController.PrintingOrder("014539415590506",user).getMessage());
}
@Test
public void tesg(){
	UserInfo user =new UserInfo();
	user.setId(100);
	user.setUserStatus(1);
	user.setUserName("xzb");
	user.setPassword("xzb");
	this.configOrderController.modifyStatus("068541415590508","1",user);
}

@Test
public void  tes(){
	UserInfo user =new UserInfo();
	user.setId(4);
	user.setUserStatus(1);
	user.setUserName("xzb");
	user.setPassword("xzb");
	//System.out.println();
	System.out.println(this.configOrderController.getSystemCommodity("30341483755896", user).getMessage());
}
	@Test
public  void testT(){

		UserInfo user =new UserInfo();
		user.setId(4);
		user.setUserStatus(1);
		user.setUserName("xzb");
		user.setPassword("xzb");
		System.out.println(this.configOrderController.getOrderList(null,null,1,40,user).getData().getList());


	}



}
