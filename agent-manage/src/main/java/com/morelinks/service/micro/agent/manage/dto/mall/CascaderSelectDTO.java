package com.morelinks.service.micro.agent.manage.dto.mall;

import java.util.List;

/**
 * 级联选择对象
 */
public class CascaderSelectDTO {
	/**
	 * 标签名
	 */
	private String label;

	/**
	 * 标签Id
	 */
	private String value;

	/**
	 * 下属标签
	 */
	private List<CascaderSelectDTO> children;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<CascaderSelectDTO> getChildren() {
		return children;
	}

	public void setChildren(List<CascaderSelectDTO> children) {
		this.children = children;
	}

@Override
public String toString() {
	return "CascaderSelectDTO{" +
		"label='" + label + '\'' +
		", value='" + value + '\'' +
		", children=" + children +
		'}';
}
}
