package com.morelinks.feign.micro.order.api.model.dto;

import com.morelinks.core.model.Page;

import javax.xml.crypto.Data;
import java.util.List;

public class Query4ConfigOrder {

   private  String orderName;
   private  String customerName;
   private  String customerTel;
   private  Integer orderStatus;
   private  Byte  isDelete;
   private  Integer  uerId;
   private    Page  page;

public Query4ConfigOrder(){
    Page  page1=new Page();
    page1.setSort("update_time");
    page1.setOrder(Page .ORDER_DESC);
    this.page=page1;
}
public String getOrderName() {
    return orderName;
}

public void setOrderName(String orderName) {
    this.orderName = orderName;
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

public Integer getOrderStatus() {
    return orderStatus;
}

public void setOrderStatus(Integer orderStatus) {
    this.orderStatus = orderStatus;
}

public Page getPage() {
    return page;
}

public Integer getUerId() {
    return uerId;
}

public void setUerId(Integer uerId) {
    this.uerId = uerId;
}

public Byte getIsDelete() {
    return isDelete;
}

public void setIsDelete(Byte isDelete) {
    this.isDelete = isDelete;
}

public void setPage(Page page) {
    this.page = page;
}

}
