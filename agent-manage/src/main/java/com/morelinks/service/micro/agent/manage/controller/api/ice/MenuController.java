package com.morelinks.service.micro.agent.manage.controller.api.ice;

import com.morelinks.core.dto.IceAjaxResult;
import com.morelinks.core.dto.IceValueDTO;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.exception.BusinessException;
import com.morelinks.core.util.StringUtil;
import com.morelinks.core.webutil.ResourceUtil;
import com.morelinks.feign.micro.inner.user.api.client.MenuFeignClient;
import com.morelinks.feign.micro.inner.user.api.client.UserInfoFeignClient;
import com.morelinks.feign.micro.inner.user.api.dto.MenuInfoDTO;
import com.morelinks.feign.micro.inner.user.api.model.UserInfo;
import com.morelinks.service.micro.agent.manage.constants.ProductManageConstant;
import com.morelinks.service.micro.agent.manage.dto.MenuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {
	@Autowired
	UserInfoFeignClient userInfoFeignClient;
	@Autowired
	ResourceUtil resourceUtil;

	@Autowired
	MenuFeignClient menuFeignClient;

	@RequestMapping(value = "/getMenus", method = {RequestMethod.GET,RequestMethod.POST})
	private IceAjaxResult<IceValueDTO<List<MenuDTO>>> getMenus(UserInfo userInfo
	)
	{
		IceAjaxResult<IceValueDTO<List<MenuDTO>>> result = new IceAjaxResult<>();
		IceValueDTO<List<MenuDTO>> valueDTO = new IceValueDTO<>();
		List<MenuDTO> lstMenu = new ArrayList<>();
		ReturnValue<List<MenuInfoDTO>> ret = menuFeignClient.getMenuTree(userInfo.getId(), ProductManageConstant.SYSTEM_TYPE);
		if(ret.getCode()!=200)
		{
			throw new BusinessException(StringUtil.getErrorMsg(ret.getMsg()));
		}
		if(ret.getObj()!=null)
		{
			lstMenu = convertMenu(ret.getObj());
		}
		valueDTO.setValue(lstMenu);
		result.setData(valueDTO);
		return result;
	}

	private List<MenuDTO> convertMenu(List<MenuInfoDTO> lstInfoDTO)
	{
		List<MenuDTO> lstMenu = new ArrayList<>();
		for (MenuInfoDTO infoDTO:lstInfoDTO
				) {
			MenuDTO menuDTO = new MenuDTO();
			menuDTO.setChildren(convertMenu(infoDTO.getChildren()));
			menuDTO.setIcon(infoDTO.getIcon());
			menuDTO.setName(infoDTO.getMenuName());
			menuDTO.setPath(infoDTO.getRouteInfo().getRoutePath());
			menuDTO.setRedirect(true);
			menuDTO.setMenuType(infoDTO.getMenuType());
			menuDTO.setRedirectType(1);
			lstMenu.add(menuDTO);
		}
		return lstMenu;
	}

}
