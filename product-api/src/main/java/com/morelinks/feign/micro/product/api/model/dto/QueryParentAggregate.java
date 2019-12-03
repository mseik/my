package com.morelinks.feign.micro.product.api.model.dto;

import java.util.ArrayList;
import java.util.List;

public class QueryParentAggregate {
	private List<Integer> treeRoot;
	private List<Integer> countId = new ArrayList<>();

	public List<Integer> getTreeRoot() {
		return treeRoot;
	}

	public void setTreeRoot(List<Integer> treeRoot) {
		this.treeRoot = treeRoot;
	}

	public List<Integer> getCountId() {
		return countId;
	}

	public void setCountId(List<Integer> countId) {
		this.countId = countId;
	}

}
