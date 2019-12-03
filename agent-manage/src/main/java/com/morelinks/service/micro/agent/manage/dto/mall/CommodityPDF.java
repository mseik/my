package com.morelinks.service.micro.agent.manage.dto.mall;

import java.util.ArrayList;
import java.util.List;

public class CommodityPDF {
    String  systemName;//系统名
    List<CommodityDTO> commodityDTOList;


public String getSystemName() {
    return systemName;
}

public void setSystemName(String systemName) {
    this.systemName = systemName;
}

public List<CommodityDTO> getCommodityDTOList() {
    return commodityDTOList=this.commodityDTOList==null ? new ArrayList<>() : this.commodityDTOList;
}

public void setCommodityDTOList(List<CommodityDTO> commodityDTOList) {
    this.commodityDTOList = commodityDTOList;
}
}
