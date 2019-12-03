package com.morelinks.service.micro.agent.manage.dto;

import com.morelinks.core.dto.IcePageData;
import com.morelinks.service.micro.agent.manage.dto.configorder.ConfigSumSelectedProductListUnit;

import java.math.BigDecimal;

public class PackagingProduct {

    private IcePageData<ConfigSumSelectedProductListUnit> icePageData;
    /**
     * 设备合计
     */
    private BigDecimal total;

    public IcePageData<ConfigSumSelectedProductListUnit> getIcePageData() {
        return icePageData;
    }

    public void setIcePageData(IcePageData<ConfigSumSelectedProductListUnit> icePageData) {
        this.icePageData = icePageData;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "PackagingProduct{" +
            "icePageData=" + icePageData +
            ", total=" + total +
            '}';
    }
}
