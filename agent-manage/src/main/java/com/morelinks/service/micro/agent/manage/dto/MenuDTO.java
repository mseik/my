package com.morelinks.service.micro.agent.manage.dto;

import java.util.List;

/**
 * 菜单对象
 */
public class MenuDTO {
	/**
	 * 菜单显示名称
	 */
	private String name;
	/**
	 * 菜单路径
	 */
	private String path;
	/**
	 * 菜单图标
	 */
	private String icon;
	/**
	 * 菜单类型 1：头部菜单 2：左侧菜单 3：内容头部菜单 4：项目菜单
	 */
	private Integer menuType;
	/**
	 * 是否跳转页面 只针对父元素有效 true 为跳转加展开 false为展开
	 */
	private boolean redirect;

	/**
	 * 跳转类型 1：内部链接 2：外部链接 3：新窗口
	 */
	private Integer redirectType;

	private List<MenuDTO> children;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public List<MenuDTO> getChildren() {
		return children;
	}

	public void setChildren(List<MenuDTO> children) {
		this.children = children;
	}

	public boolean isRedirect() {
		return redirect;
	}

	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}

	public Integer getMenuType() {
		return menuType;
	}

	public void setMenuType(Integer menuType) {
		this.menuType = menuType;
	}

	public Integer isRedirectType() {
		return redirectType;
	}

	public void setRedirectType(Integer redirectType) {
		this.redirectType = redirectType;
	}
}
