package com.morelinks.feign.micro.inner.user.api.dto;


import com.morelinks.feign.micro.inner.user.api.model.MenuInfo;
import com.morelinks.feign.micro.inner.user.api.model.RouteInfo;

import java.util.List;

public class MenuInfoDTO extends MenuInfo {
	private RouteInfo routeInfo;

	private List<MenuInfoDTO> children;

	public RouteInfo getRouteInfo() {
		return routeInfo;
	}

	public void setRouteInfo(RouteInfo routeInfo) {
		this.routeInfo = routeInfo;
	}

	public List<MenuInfoDTO> getChildren() {
		return children;
	}

	public void setChildren(List<MenuInfoDTO> children) {
		this.children = children;
	}
}
