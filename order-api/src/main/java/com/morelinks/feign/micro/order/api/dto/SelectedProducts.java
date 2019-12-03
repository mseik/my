package com.morelinks.feign.micro.order.api.dto;

import java.util.List;

public class SelectedProducts {

    private  String orderId;
    private List<Integer> listId;

public String getOrderId() {
    return orderId;
}

public void setOrderId(String orderId) {
    this.orderId = orderId;
}

public List<Integer> getListId() {
    return listId;
}

public void setListId(List<Integer> listId) {
    this.listId = listId;
}

@Override
public String toString() {
    return "SelectedProducts{" +
        "orderId='" + orderId + '\'' +
        ", listId=" + listId +
        '}';
}
}
