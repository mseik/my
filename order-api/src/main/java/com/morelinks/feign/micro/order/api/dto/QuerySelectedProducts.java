package com.morelinks.feign.micro.order.api.dto;

import com.morelinks.core.model.Page;

import java.util.List;

public class QuerySelectedProducts {
    private  Page page=new Page();
    private  String  orderId;
    private List<Integer>  ListCategoryId;

public Page getPage() {
    return page;
}

public void setPage(Page page) {
    this.page = page;
}

public String getOrderId() {
    return orderId;
}

public void setOrderId(String orderId) {
    this.orderId = orderId;
}

public List<Integer> getListCategoryId() {
    return ListCategoryId;
}

public void setListCategoryId(List<Integer> listCategoryId) {
    ListCategoryId = listCategoryId;
}

@Override
public String toString() {
    return "QuerySelectedProducts{" +
        "page=" + page +
        ", orderId='" + orderId + '\'' +
        ", ListCategoryId=" + ListCategoryId +
        '}';
}
}
