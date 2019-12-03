package com.morelinks.feign.micro.product.api.dto;

import java.util.List;

/**
 * 类别菜单对象
 */
public class ConfigCategoryMenuDTO {
	/*
	* 类别ID
	* */
	private Integer id;
	/**
	 * 显示名称
	 */
	private String name;
	/**
	 * 设备数量
	 */
	private String num;
	/**
	 * 菜单图标
	 */
	private String icon;
	/**
	 * 是否选中
	 */
	private Integer selected;
	/**
	 * 子类别
	 */
	private List<ConfigCategoryMenuDTO> children;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getSelected() {
		return selected;
	}

	public void setSelected(Integer selected) {
		this.selected = selected;
	}

	public List<ConfigCategoryMenuDTO> getChildren() {
		return children;
	}

	public void setChildren(List<ConfigCategoryMenuDTO> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "ConfigCategoryMenuDTO{" +
				"id=" + id +
				", name='" + name + '\'' +
				", num='" + num + '\'' +
				", icon='" + icon + '\'' +
				", selected=" + selected +
				", children=" + children +
				'}';
	}
}
