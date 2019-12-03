package com.morelinks.service.micro.agent.manage.dto.mall;

import java.util.List;
import java.util.Map;

/**
 * 产品售卖对象
 */
public class SaleProductModelDTO {

	/**
	 * 产品名 产品型号名称
	 */
	private String modelId;
	/**
	 * 产品名 产品型号名称
	 */
	private String productName;
	/**
	 * 产品简述
	 */
	private String productResume;
	/**
	 * 选择的项目Id
	 */
	private Integer productId;
	/**
	 * 可选择的类别Id
	 */
	private List<SaleProductProperyTypeDTO> lstPropertyType;

	private List<SaleProductDTO> lstProduct;

	private Map<Integer,Integer> selectedPropertys;
	/**
	 * 展示图片
	 */
	private List<String> showPics;
	/**
	 * 产品价格
	 */
	private double productAmount;

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

	public double getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(double productAmount) {
		this.productAmount = productAmount;
	}

	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	public void setLstPropertyType(List<SaleProductProperyTypeDTO> lstPropertyType) {
		this.lstPropertyType = lstPropertyType;
	}

	public List<SaleProductProperyTypeDTO> getLstPropertyType() {
		return lstPropertyType;
	}

	public List<String> getShowPics() {
		return showPics;
	}

	public void setShowPics(List<String> showPics) {
		this.showPics = showPics;
	}

	public List<SaleProductDTO> getLstProduct() {
		return lstProduct;
	}

	public void setLstProduct(List<SaleProductDTO> lstProduct) {
		this.lstProduct = lstProduct;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Map<Integer, Integer> getSelectedPropertys() {
		return selectedPropertys;
	}

	public void setSelectedPropertys(Map<Integer, Integer> selectedPropertys) {
		this.selectedPropertys = selectedPropertys;
	}
}
