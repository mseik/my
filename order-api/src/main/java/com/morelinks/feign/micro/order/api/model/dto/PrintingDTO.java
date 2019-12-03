package com.morelinks.feign.micro.order.api.model.dto;

import com.morelinks.feign.micro.order.api.model.ConfigPrintOrder;
import com.morelinks.feign.micro.order.api.model.ConfigPrintOrderDetail;
import com.morelinks.feign.micro.order.api.model.ConfigPrintOrderExtraInfo;

import java.util.List;

public class PrintingDTO {
private ConfigPrintOrder order;
private List<ConfigPrintOrderDetail>  ListDetail;
private    List<ConfigPrintOrderExtraInfo> ListExtraInfo;

public ConfigPrintOrder getOrder() {
    return order;
}

public void setOrder(ConfigPrintOrder order) {
    this.order = order;
}

public List<ConfigPrintOrderDetail> getListDetail() {
    return ListDetail;
}

public void setListDetail(List<ConfigPrintOrderDetail> listDetail) {
    ListDetail = listDetail;
}

public List<ConfigPrintOrderExtraInfo> getListExtraInfo() {
    return ListExtraInfo;
}

public void setListExtraInfo(List<ConfigPrintOrderExtraInfo> listExtraInfo) {
    ListExtraInfo = listExtraInfo;
}
}
