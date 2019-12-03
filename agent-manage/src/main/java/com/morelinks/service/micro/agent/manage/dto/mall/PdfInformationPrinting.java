package com.morelinks.service.micro.agent.manage.dto.mall;

import java.util.List;

public class PdfInformationPrinting {
    private String  orderId;//订单号
    private String orderName;//项目名
    private String customerTel;//手机号
    private String customerName;//客户姓名
    private String projectAddress;//地址
    private String  time;//时间
    private TemplatePdfDTO  pdfInfo;//页眉页脚信息
    private  EquipmentSummary equipmentSummary;//系统
    private List<CommodityPDF>  commodityPdfs;//商品信息

public String getOrderId() {
    return orderId;
}

public void setOrderId(String orderId) {
    this.orderId = orderId;
}

public String getOrderName() {
    return orderName;
}

public void setOrderName(String orderName) {
    this.orderName = orderName;
}

public String getCustomerTel() {
    return customerTel;
}

public void setCustomerTel(String customerTel) {
    this.customerTel = customerTel;
}

public String getCustomerName() {
    return customerName;
}

public void setCustomerName(String customerName) {
    this.customerName = customerName;
}

public String getProjectAddress() {
    return projectAddress;
}

public void setProjectAddress(String projectAddress) {
    this.projectAddress = projectAddress;
}

public String getTime() {
    return time;
}

public void setTime(String time) {
    this.time = time;
}

public TemplatePdfDTO getPdfInfo() {
    return pdfInfo;
}

public void setPdfInfo(TemplatePdfDTO pdfInfo) {
    this.pdfInfo = pdfInfo;
}

public EquipmentSummary getEquipmentSummary() {
    return equipmentSummary;
}

public void setEquipmentSummary(EquipmentSummary equipmentSummary) {
    this.equipmentSummary = equipmentSummary;
}

public List<CommodityPDF> getCommodityPdfs() {
    return commodityPdfs;
}

public void setCommodityPdfs(List<CommodityPDF> commodityPdfs) {
    this.commodityPdfs = commodityPdfs;
}
}
