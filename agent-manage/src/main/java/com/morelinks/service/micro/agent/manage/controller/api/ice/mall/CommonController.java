package com.morelinks.service.micro.agent.manage.controller.api.ice.mall;

import com.morelinks.core.dto.IceAjaxResult;
import com.morelinks.core.dto.IceValueDTO;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.webutil.ResourceUtil;
import com.morelinks.feign.micro.common.api.client.WeatherCityFeignClient;
import com.morelinks.feign.micro.common.api.dto.TreeCityDTO;
import com.morelinks.feign.micro.inner.user.api.model.UserInfo;
import com.morelinks.feign.micro.order.api.client.AgentCartFeignClient;
import com.morelinks.feign.micro.order.api.client.AgentMallBaseConfigFeignClient;
import com.morelinks.feign.micro.order.api.model.AgentMallBaseConfig;
import com.morelinks.feign.micro.product.api.client.ProductFeignClient;
import com.morelinks.feign.micro.product.api.client.ProductInfoFeignClient;
import com.morelinks.feign.micro.product.api.client.ProductModelFeignClient;
import com.morelinks.feign.micro.product.api.client.ProductSupplierFeignClient;
import com.morelinks.service.micro.agent.manage.dto.mall.CascaderSelectDTO;
import com.morelinks.service.micro.agent.manage.dto.mall.CascaderSelectLstDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 一些共用调用方法
 */
@RestController
@RequestMapping("/api/common")
public class CommonController {
	@Autowired
	ProductInfoFeignClient productInfoFeignClient;
	@Autowired
	ProductSupplierFeignClient supplierFeignClient;
	@Autowired
	ProductModelFeignClient productModelFeignClient;
	@Autowired
	ProductFeignClient productFeignClient;
	@Autowired
	ResourceUtil resourceUtil;
	@Autowired
	AgentCartFeignClient agentCartFeignClient;
    @Autowired
    WeatherCityFeignClient cityFeignClient;
    @Autowired
	AgentMallBaseConfigFeignClient agentMallBaseConfigFeignClient;

    //城市对象 存入内存
    private CascaderSelectLstDTO citys = null;

	/**
	 * 获取城市选择列表
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/getCascaderSelectCitys", method = {RequestMethod.GET,RequestMethod.POST})
	public IceAjaxResult<CascaderSelectLstDTO> getCascaderSelectCitys(UserInfo user
	) {
		IceAjaxResult<CascaderSelectLstDTO> result = new IceAjaxResult<CascaderSelectLstDTO>();
		if(user==null || user.getUserStatus()!=1)
		{
			return IceAjaxResult.getFailResult("用户不存在");
		}
		synchronized(this) {
			if (citys != null) {
				result.setData(citys);
				return result;
			}
			List<TreeCityDTO> lstDTO =null;
			ReturnValue<List<TreeCityDTO>> ret = cityFeignClient.getTreeCityListByCityId();
			if(ret.getCode()==200)
			{
				lstDTO =ret.getObj();
			}
			List<CascaderSelectDTO> lst = new ArrayList<CascaderSelectDTO>();
			if (lstDTO != null) {
				for (TreeCityDTO treeCityDTO : lstDTO
						) {
					lst.add(convertToCascaderSelectCityDTO(treeCityDTO));
				}
			}
			CascaderSelectLstDTO dto = new CascaderSelectLstDTO();
			dto.setList(lst);
			result.setData(dto);
			citys = dto;
		}
		return result;
	}
	private CascaderSelectDTO convertToCascaderSelectCityDTO(TreeCityDTO treeCityDTO)
	{
		CascaderSelectDTO dto = new CascaderSelectDTO();
		dto.setLabel(treeCityDTO.getCityName());
		dto.setValue(treeCityDTO.getCityId());
		List<CascaderSelectDTO> lst = new ArrayList<CascaderSelectDTO>();
		if(treeCityDTO.getChildren()!=null)
		{
			for (TreeCityDTO unit:treeCityDTO.getChildren()
			     ) {
				lst.add( convertToCascaderSelectCityDTO(unit));
			}
		}
		dto.setChildren(lst);
		return dto;
	}

	/**
	 * 获取会员等级
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/getMemberLevelTip", method = {RequestMethod.GET,RequestMethod.POST})
	public IceAjaxResult<IceValueDTO> getMemberLevelTip(UserInfo user
	) {
		IceAjaxResult<IceValueDTO> result = new IceAjaxResult();
		ReturnValue<AgentMallBaseConfig> retMall = agentMallBaseConfigFeignClient.getByConfigTypeAndConfigKey("explain","member_level");
		if(retMall.getCode()!=200)
		{
			IceAjaxResult.getFailResult("系统繁忙请稍后再试");
		}
		IceValueDTO dto = new IceValueDTO();
			dto.setValue("");
		if(retMall.getObj()!=null) {
			dto.setValue(retMall.getObj().getConfigVal());
		}
		result.setData(dto);
		return result;
	}

	/**
	 * 获取核心货款提示
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/getGoodsAmountTip", method = {RequestMethod.GET,RequestMethod.POST})
	public IceAjaxResult<IceValueDTO> getGoodsAmountTip(UserInfo user
	) {
		IceAjaxResult<IceValueDTO> result = new IceAjaxResult();
		ReturnValue<AgentMallBaseConfig> retMall = agentMallBaseConfigFeignClient.getByConfigTypeAndConfigKey(
				"explain","goods_amount");
		if(retMall.getCode()!=200)
		{
			IceAjaxResult.getFailResult("系统繁忙请稍后再试");
		}
		IceValueDTO dto = new IceValueDTO();
		dto.setValue("");
		if(retMall.getObj()!=null) {
			dto.setValue(retMall.getObj().getConfigVal());
		}
		result.setData(dto);
		return result;
	}

	/**
	 * 获取通用货款提示
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/getCommonAmountTip", method = {RequestMethod.GET,RequestMethod.POST})
	public IceAjaxResult<IceValueDTO> getCommonAmountTip(UserInfo user
	) {
		IceAjaxResult<IceValueDTO> result = new IceAjaxResult();
		ReturnValue<AgentMallBaseConfig> retMall = agentMallBaseConfigFeignClient.getByConfigTypeAndConfigKey(
				"explain","common_amount");
		if(retMall.getCode()!=200)
		{
			IceAjaxResult.getFailResult("系统繁忙请稍后再试");
		}
		IceValueDTO dto = new IceValueDTO();
		dto.setValue("");
		if(retMall.getObj()!=null) {
			dto.setValue(retMall.getObj().getConfigVal());
		}
		result.setData(dto);
		return result;
	}


}
