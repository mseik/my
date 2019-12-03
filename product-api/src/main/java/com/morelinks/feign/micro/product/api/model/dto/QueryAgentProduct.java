package com.morelinks.feign.micro.product.api.model.dto;

import com.morelinks.core.model.Page;

import java.util.List;

public class QueryAgentProduct {
private Page page;
private List<Integer> listMapKey;
private List<Integer>  listBrand;
public QueryAgentProduct(){

    this.page=new Page();
}
public Page getPage() {
    return page;
}

public void setPage(Page page) {
    this.page = page;
}

public List<Integer> getListMapKey() {
    return listMapKey;
}

public void setListMapKey(List<Integer> listMapKey) {
    this.listMapKey = listMapKey;
}

public List<Integer> getListBrand() {
    return listBrand;
}

public void setListBrand(List<Integer> listBrand) {
    this.listBrand = listBrand;
}

@Override
public String toString() {
    return "QueryAgentProduct{" +
        "page=" + page +
        ", listMapKey=" + listMapKey +
        ", listBrand=" + listBrand +
        '}';
}
}


