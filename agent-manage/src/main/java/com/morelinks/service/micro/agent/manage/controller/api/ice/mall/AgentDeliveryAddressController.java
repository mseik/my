package com.morelinks.service.micro.agent.manage.controller.api.ice.mall;

import com.morelinks.core.dto.IceAjaxResult;
import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.Page;
import com.morelinks.core.model.QueryResult;
import com.morelinks.core.util.IntUtil;
import com.morelinks.core.util.StringUtil;
import com.morelinks.core.webutil.ResourceUtil;
import com.morelinks.feign.micro.common.api.client.WeatherCityFeignClient;
import com.morelinks.feign.micro.common.api.model.WeatherCity;
import com.morelinks.feign.micro.inner.user.api.model.UserInfo;
import com.morelinks.feign.micro.order.api.client.AgentDeliveryAddressFeignClient;
import com.morelinks.feign.micro.order.api.client.AgentMallBaseConfigFeignClient;
import com.morelinks.feign.micro.order.api.client.AgentOrderFormConfigFeignClient;
import com.morelinks.feign.micro.order.api.model.AgentDeliveryAddress;
import com.morelinks.feign.micro.order.api.model.AgentOrderFormConfig;
import com.morelinks.service.micro.agent.manage.dto.mall.DeliverAddressListDTO;
import com.morelinks.service.micro.agent.manage.dto.mall.DeliverAddressUnit;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 * 快递地址
 */
@RestController
@RequestMapping("/api/agentDeliveryAddress")
public class AgentDeliveryAddressController {
	@Autowired
	AgentDeliveryAddressFeignClient agentDeliveryAddressFeignClient;
	@Autowired
	ResourceUtil resourceUtil;
	@Autowired
	WeatherCityFeignClient cityFeignClient;
	@Autowired
	AgentMallBaseConfigFeignClient configFeignClient;
	@Autowired
	AgentOrderFormConfigFeignClient orderFormConfigFeignClient;

	@RequestMapping(value = "/getList", method = {RequestMethod.GET,RequestMethod.POST})
	public IceAjaxResult<DeliverAddressListDTO> getList(
			Integer page,Integer pageSize,UserInfo user
	) {
		if(user==null || user.getUserStatus()!=1)
		{
			return IceAjaxResult.getFailResult("用户不存在");
		}
		Integer lastAddressId =0;
		ReturnValue<AgentOrderFormConfig> retOrderFormConfig = orderFormConfigFeignClient.getByPrimaryKey(user.getId());
		if(retOrderFormConfig.getCode()==200 && retOrderFormConfig.getObj()!=null) {
			lastAddressId = retOrderFormConfig.getObj().getLastAddressId();
		}
		IceAjaxResult<DeliverAddressListDTO> result = new IceAjaxResult<DeliverAddressListDTO>();
		DeliverAddressListDTO dto = new DeliverAddressListDTO();
		dto.setList(new ArrayList());
		result.setData(dto);
		if(!IntUtil.isGreaterThanZero(page))
		{
			page =1;
		}
		if(!IntUtil.isGreaterThanZero(pageSize))
		{
			pageSize =100;
		}
		QueryPageParam<AgentDeliveryAddress> queryPageParam = new QueryPageParam<AgentDeliveryAddress>();
		AgentDeliveryAddress query = new AgentDeliveryAddress();
		query.setUserId(user.getId());
		query.setAddressStatus(1);
		queryPageParam.setQuery(query);
		Page pageQuery = new Page();
		pageQuery.setLimit(pageSize);
		pageQuery.setOffset((page-1)*pageSize);
		queryPageParam.setPage(pageQuery);
		ReturnValue<QueryResult<AgentDeliveryAddress>> retResult = agentDeliveryAddressFeignClient.getQueryResult(queryPageParam);
		if(retResult.getCode()==200 && retResult.getObj()!=null && retResult.getObj().getItems()!=null && retResult.getObj().getItems().size()>0)
		{
			DeliverAddressUnit checkedAddress =null;
			for (AgentDeliveryAddress address:retResult.getObj().getItems()
			     ) {
				DeliverAddressUnit unit = new DeliverAddressUnit();
				BeanUtils.copyProperties(address,unit);
				ReturnValue<Map<Integer,WeatherCity>> retMapCity = cityFeignClient.getMapCityByCityId(address.getCityId());
				if(retMapCity.getCode()!=200 || retMapCity.getObj()==null)
				{
					continue;
				}
				Map<Integer,WeatherCity> mapCity = retMapCity.getObj();
				String cityName ="";
				if(mapCity.containsKey(1))
				{
					cityName+=mapCity.get(1).getCityName()+" ";
				}
				if(mapCity.containsKey(2))
				{
					cityName+=mapCity.get(2).getCityName()+" ";
				}
				if(mapCity.containsKey(3))
				{
					cityName+=mapCity.get(3).getCityName()+" ";
				}
				if(cityName.endsWith(" "))
				{
					cityName =cityName.substring(0,cityName.length()-1);
				}
				unit.setCityName(cityName);
				if(checkedAddress==null)
				{
					checkedAddress=unit;
				}
				if(lastAddressId!=null && lastAddressId==unit.getId())
				{
					checkedAddress=unit;
				}
				if((lastAddressId==null || lastAddressId<=0) && unit.getIsDefault()!=null && unit.getIsDefault())
				{
					checkedAddress=unit;
				}
				dto.getList().add(unit);
			}
			dto.setCheckedAddress(checkedAddress);
		}
		return result;
	}

	@RequestMapping(value = "/delById", method = {RequestMethod.GET,RequestMethod.POST})
	public IceAjaxResult delById(Integer id,UserInfo user
	) {
		if(!IntUtil.isGreaterThanZero(id))
		{
			return IceAjaxResult.getFailResult("id非法");
		}
		ReturnValue<AgentDeliveryAddress> retAddress = agentDeliveryAddressFeignClient.getByPrimaryKey(id);
		if(retAddress.getCode()!=200 || retAddress.getObj()==null)
		{
			return IceAjaxResult.getFailResult("地址不存在");
		}
		AgentDeliveryAddress address = retAddress.getObj();
		address.setAddressStatus(2);
		address.setUpdateTime(new Date());
		agentDeliveryAddressFeignClient.updateByPrimaryKey(address);
		IceAjaxResult result = new IceAjaxResult();
		result.setMessage("删除成功");
		return result;
	}

	@RequestMapping(value = "/addOrUpdate", method = {RequestMethod.POST})
	public IceAjaxResult addOrUpdate(@RequestBody AgentDeliveryAddress obj,UserInfo user
	) {
		if(user==null || user.getUserStatus()!=1)
		{
			return IceAjaxResult.getFailResult("用户不存在");
		}
		IceAjaxResult result = new IceAjaxResult();
		String message = "更新成功";
		if(!IntUtil.isGreaterThanZero(obj.getId()))
		{
			message = "添加成功";
			obj.setCreateTime(new Date());
			obj.setAddressStatus(1);
			obj.setIsDefault(false);
			obj.setUserId(user.getId());
			obj.setUpdateTime(new Date());
			agentDeliveryAddressFeignClient.insert(obj);
		}
		else {
			ReturnValue<AgentDeliveryAddress> retAddress =  agentDeliveryAddressFeignClient.getByPrimaryKey(obj.getId());
			if(retAddress.getCode()!=200 || retAddress.getObj()==null)
			{
				return IceAjaxResult.getFailResult(StringUtil.getErrorMsg(retAddress.getMsg()));
			}
			AgentDeliveryAddress modifyObj = retAddress.getObj();
			modifyObj.setUpdateTime(new Date());
			modifyObj.setCityId(obj.getCityId());
			modifyObj.setContactTel(obj.getContactTel());
			modifyObj.setDeliveryAddress(obj.getDeliveryAddress());
			modifyObj.setUserName(obj.getUserName());
			agentDeliveryAddressFeignClient.updateByPrimaryKey(modifyObj);
		}
		result.setMessage(message);
		return result;
	}

	@RequestMapping(value = "/selectAddress", method = {RequestMethod.GET,RequestMethod.POST})
	public IceAjaxResult selectAddress(Integer addressId,UserInfo user
	) {
		if(!IntUtil.isGreaterThanZero(addressId))
		{
			return IceAjaxResult.getFailResult("地址不存在");
		}
		if(user==null || user.getUserStatus()!=1)
		{
			return IceAjaxResult.getFailResult("用户不存在");
		}
		ReturnValue<AgentOrderFormConfig> retOrderFormConfig = orderFormConfigFeignClient.getByPrimaryKey(user.getId());

		if(retOrderFormConfig.getCode()!=200)
		{
			return IceAjaxResult.getFailResult(StringUtil.getErrorMsg(retOrderFormConfig.getMsg()));
		}
		AgentOrderFormConfig orderFormConfig = retOrderFormConfig.getObj();
		if(orderFormConfig ==null) {
			AgentOrderFormConfig modifyConfig = new AgentOrderFormConfig();
			modifyConfig.setLastAddressId(addressId);
			modifyConfig.setUpdateTime(new Date());
			modifyConfig.setUserId(user.getId());
			modifyConfig.setCreateTime(new Date());
			orderFormConfigFeignClient.insert(modifyConfig);
		}
		else{
			orderFormConfig.setLastAddressId(addressId);
			orderFormConfig.setUpdateTime(new Date());
			orderFormConfig.setUserId(user.getId());
			orderFormConfigFeignClient.updateByPrimaryKey(orderFormConfig);
		}
		IceAjaxResult result = new IceAjaxResult();
		return result;
	}

}
