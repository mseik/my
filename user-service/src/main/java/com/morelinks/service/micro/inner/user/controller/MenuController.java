package com.morelinks.service.micro.inner.user.controller;

import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.util.IntUtil;
import com.morelinks.core.util.StringUtil;
import com.morelinks.feign.micro.inner.user.api.dto.MenuInfoDTO;
import com.morelinks.feign.micro.inner.user.api.model.MenuConfig;
import com.morelinks.feign.micro.inner.user.api.model.MenuInfo;
import com.morelinks.feign.micro.inner.user.api.model.RouteInfo;
import com.morelinks.feign.micro.inner.user.api.model.UserSystemRole;
import com.morelinks.feign.micro.inner.user.api.service.IMenuController;
import com.morelinks.service.micro.inner.user.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MenuController
		implements IMenuController {
	private Logger logger = LoggerFactory.getLogger(UserInfoController.class);
	@Autowired
	public UserInfoService baseService;
	@Autowired
	MenuConfigService menuConfigService;
	@Autowired
	MenuInfoService menuInfoService;
	@Autowired
	RouteInfoService routeInfoService;
	@Autowired
	UserSystemRoleService systemRoleService;

	@Override
	public ReturnValue<List<MenuInfoDTO>> getMenuTree(@RequestParam(name = "userId") Integer userId,
	                                                  @RequestParam(name = "systemType") Integer systemType) {
		if (!IntUtil.isGreaterThanZero(userId)) {
			return ReturnValue.get200OK(null);
		}
		UserSystemRole queryRole = new UserSystemRole();
		queryRole.setUserId(userId);
		queryRole.setSystemType(systemType);
		List<UserSystemRole> lstRole = systemRoleService.find(queryRole, null);
		List<MenuConfig> lstUserMenu = new ArrayList<>();
		if (lstRole != null && lstRole.size() > 0) {
			for (UserSystemRole userRole : lstRole
					) {
				if (StringUtil.isTrimBlank(userRole.getRoles())) {
					continue;
				}
				String[] arrRoleId = userRole.getRoles().split(",");
				if (arrRoleId == null || arrRoleId.length <= 0) {
					continue;
				}
				for (String roleId : arrRoleId
						) {
					if (StringUtil.isTrimBlank(roleId)) {
						continue;
					}
					MenuConfig queryRoleMenu = new MenuConfig();
					queryRoleMenu.setSystemType(systemType);
					queryRoleMenu.setMapType(1);
					queryRoleMenu.setMapKey(roleId);
					List<MenuConfig> lstMenu = menuConfigService.find(queryRoleMenu, null);
					if (lstMenu != null && lstMenu.size() > 0) {
						lstUserMenu.addAll(lstMenu);
					}
				}
			}


		}
		MenuConfig queryRoleMenu = new MenuConfig();
		queryRoleMenu.setMapType(2);
		queryRoleMenu.setMapKey(userId.toString());
		List<MenuConfig> lstMenu = menuConfigService.find(queryRoleMenu, null);
		if (lstMenu != null && lstMenu.size() > 0) {
			lstUserMenu.addAll(lstMenu);
		}
		Map<Integer, MenuConfig> mapMenu = new HashMap<>();
		for (MenuConfig menuConfig : lstUserMenu
				) {
			if (!IntUtil.isGreaterThanZero(menuConfig.getMenuId())) {
				continue;
			}
			mapMenu.put(menuConfig.getMenuId(), menuConfig);
		}
		List<MenuInfoDTO> lst = getMenuTreeSubList(-1, systemType, null, mapMenu);
//			List<MenuInfoDTO> lst = new ArrayList<>();
//			MenuInfo query = new MenuInfoDTO();
//			query.setParentId(-1);
//			List<MenuInfo> lstInfo = menuInfoService.find(query,null);
//			if(lstInfo==null || lstInfo.size()<=0)
//			{
//				return ReturnValue.get200OK(null);
//			}
//			for (MenuInfo menuInfo:lstInfo
//					) {
//				if(!mapMenu.containsKey(menuInfo.getId()))
//				{
//					continue;
//				}
//				RouteInfo routeInfo = routeInfoService.getByPrimaryKey(menuInfo.getRouteId());
//				if(routeInfo==null)
//				{
//					continue;
//				}
//				MenuInfoDTO dto = new MenuInfoDTO();
//				BeanUtils.copyProperties(menuInfo,dto);
//				dto.setRouteInfo(routeInfo);
//				dto.setChildren(getMenuTreeSubList(dto.getId(),mapMenu));
//				lst.add(dto);
//			}

		return ReturnValue.get200OK(lst);
	}

	private List<MenuInfoDTO> getMenuTreeSubList(Integer menuId, Integer systemType, Integer systemId, Map<Integer, MenuConfig> mapMenu) {
		MenuInfo query = new MenuInfoDTO();
		query.setParentId(menuId);
		query.setSystemType(systemType);
		query.setSystemId(systemId);
		List<MenuInfo> lstInfo = menuInfoService.find(query, null);
		if (lstInfo == null || lstInfo.size() <= 0) {
			return new ArrayList<>();
		}
		List<MenuInfoDTO> lst = new ArrayList<>();
		for (MenuInfo menuInfo : lstInfo
				) {
			if (!mapMenu.containsKey(menuInfo.getId())) {
				continue;
			}
			RouteInfo routeInfo = routeInfoService.getByPrimaryKey(menuInfo.getRouteId());
			if (routeInfo == null) {
				continue;
			}
			MenuInfoDTO dto = new MenuInfoDTO();
			BeanUtils.copyProperties(menuInfo, dto);
			dto.setRouteInfo(routeInfo);
			dto.setChildren(getMenuTreeSubList(dto.getId(), dto.getSystemType(), dto.getSystemId(), mapMenu));
			lst.add(dto);
		}
		return lst;
	}

}
