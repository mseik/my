package com.morelinks.service.micro.agent.manage.dto.mall;

/**
 * 产品售卖对象
 */
public class SaleProductModelListUnit {

	/**
	 * 产品名 产品型号名称
	 */
	private String modelId;

	/**
	 * 默认产品Id 用于加入购物车 和计算金额 等显示
	 */
	private String defaultProductId;
	/**
	 * 产品名 产品型号名称
	 */
	private String productName;
	/**
	 * 产品简述
	 */
	private String productResume;
	/**
	 * 封面图片链接
	 */
	private String coverPicUrl;
	/**
	 * 市场价格
	 */
	private Double marketAmount;
	/**
	 * 是否核心设备
	 */
	private Boolean core;
	/**
	 * 产品价格
	 */
	private Double productAmount;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductResume() {
		return productResume;
	}

	public void setProductResume(String productResume) {
		this.productResume = productResume;
	}

	public String getCoverPicUrl() {
		return coverPicUrl;
	}

	public void setCoverPicUrl(String coverPicUrl) {
		this.coverPicUrl = coverPicUrl;
	}

	public Double getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(Double productAmount) {
		this.productAmount = productAmount;
	}

	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	public String getDefaultProductId() {
		return defaultProductId;
	}

	public void setDefaultProductId(String defaultProductId) {
		this.defaultProductId = defaultProductId;
	}

	public Double getMarketAmount() {
		return marketAmount;
	}

	public void setMarketAmount(Double marketAmount) {
		this.marketAmount = marketAmount;
	}

	public Boolean getCore() {
		return core;
	}

	public void setCore(Boolean core) {
		core = core;
	}
}
