package com.morelinks.feign.micro.order.api.dto;



public class ConfigOrder4Creator {
private  Integer  uerId;
private  String   projectId;
private  String ConfigCategoryIds;
private  String orderName;
private  String  CityId;
private String projectAddress;
private String  customerName;
private  String customerTel;

public Integer getUerId() {
    return uerId;
}

public void setUerId(Integer uerId) {
    this.uerId = uerId;
}

public String getProjectId() {
    return projectId;
}

public void setProjectId(String projectId) {
    this.projectId = projectId;
}

public String getConfigCategoryIds() {
    return ConfigCategoryIds;
}

public void setConfigCategoryIds(String configCategoryIds) {
    ConfigCategoryIds = configCategoryIds;
}

public String getOrderName() {
    return orderName;
}

public void setOrderName(String orderName) {
    this.orderName = orderName;
}

public String getCityId() {
    return CityId;
}

public void setCityId(String cityId) {
    CityId = cityId;
}

public String getProjectAddress() {
    return projectAddress;
}

public void setProjectAddress(String projectAddress) {
    this.projectAddress = projectAddress;
}

public String getCustomerName() {
    return customerName;
}

public void setCustomerName(String customerName) {
    this.customerName = customerName;
}

public String getCustomerTel() {
    return customerTel;
}

public void setCustomerTel(String customerTel) {
    this.customerTel = customerTel;
}

@Override
public java.lang.String toString() {
    return "ConfigOrder4Creator{" +
        "uerId=" + uerId +
        ", projectId=" + projectId +
        ", ConfigCategoryIds=" + ConfigCategoryIds +
        ", orderName=" + orderName +
        ", CityId=" + CityId +
        ", projectAddress=" + projectAddress +
        ", customerName=" + customerName +
        ", customerTel=" + customerTel +
        '}';
}
}
