package com.morelinks.feign.micro.product.api.dto;

import com.morelinks.feign.micro.product.api.model.ConfigProduct;
import com.morelinks.feign.micro.product.api.model.ConfigProductAgentExtra;

/**
 * 配单产品DTO
 */
public class ConfigProductDTO extends ConfigProduct {

	/**
	 * 产品额外代理商信息
	 */
	private ConfigProductAgentExtra configProductAgentExtra;

	/**
	 *
	 * @return
	 */


	public ConfigProductAgentExtra getConfigProductAgentExtra() {
		return configProductAgentExtra;
	}

	public void setConfigProductAgentExtra(ConfigProductAgentExtra configProductAgentExtra) {
		this.configProductAgentExtra = configProductAgentExtra;
	}
}
