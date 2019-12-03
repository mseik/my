package com.morelinks.service.micro.agent.manage.dto.mall;

/**
 * 商品额外信息保存
 */
public class ProductExtraInfo4Save {

	private Integer modelId;
	private Integer productId;
	/**
	 * 商品介绍
	 */
	private String introduce;

	/**
	 * 参数介绍
	 */
	private String parametersIntro;

	/**
	 * 售后介绍
	 */
	private String afterSaleIntro;

	public Integer getModelId() {
		return modelId;
	}

	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getParametersIntro() {
		return parametersIntro;
	}

	public void setParametersIntro(String parametersIntro) {
		this.parametersIntro = parametersIntro;
	}

	public String getAfterSaleIntro() {
		return afterSaleIntro;
	}

	public void setAfterSaleIntro(String afterSaleIntro) {
		this.afterSaleIntro = afterSaleIntro;
	}
}
