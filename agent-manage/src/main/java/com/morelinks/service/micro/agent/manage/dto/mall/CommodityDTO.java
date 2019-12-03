package com.morelinks.service.micro.agent.manage.dto.mall;

import com.morelinks.service.micro.agent.manage.dto.configorder.ConfigSelectedProductListUnit;

import java.math.BigDecimal;

public class CommodityDTO extends ConfigSelectedProductListUnit {
    private String brandCountry;//商品国
    private BigDecimal unitPrice;//单价

public String getBrandCountry() {
    return brandCountry;
}

public void setBrandCountry(String brandCountry) {
    this.brandCountry = brandCountry;
}

public BigDecimal getUnitPrice() {
    return unitPrice;
}

public void setUnitPrice(BigDecimal unitPrice) {
    this.unitPrice = unitPrice;
}
}
