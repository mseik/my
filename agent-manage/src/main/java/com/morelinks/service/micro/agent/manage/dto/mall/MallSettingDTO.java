package com.morelinks.service.micro.agent.manage.dto.mall;

import com.morelinks.feign.micro.inner.user.api.model.AgentInvoiceInfo;

/**
 * 商城设置对象
 */
public class MallSettingDTO {
	private Boolean needTaxBill;

	private AgentInvoiceInfo invoice;

	public Boolean getNeedTaxBill() {
		return needTaxBill;
	}

	public void setNeedTaxBill(Boolean needTaxBill) {
		this.needTaxBill = needTaxBill;
	}

	public AgentInvoiceInfo getInvoice() {
		return invoice;
	}

	public void setInvoice(AgentInvoiceInfo invoice) {
		this.invoice = invoice;
	}
}
