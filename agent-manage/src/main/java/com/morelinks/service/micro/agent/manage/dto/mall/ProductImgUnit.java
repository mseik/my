package com.morelinks.service.micro.agent.manage.dto.mall;

import com.morelinks.feign.micro.product.api.model.ProductProperty;

import java.util.List;

/**
 * 产品图片对象
 */
public class ProductImgUnit {

	/**
	 * 图片Id
	 */
	private String imgId;
	/**
	 * 图片路径
	 */
	private String imgPath;
	/**
	 * 图片Url
	 */
	private String imgUrl;
	/**
	 * 是否是系列封面
	 */
	private Boolean modelCover;
	/**
	 * 是否是产品封面
	 */
	private Boolean productCover;

	public String getImgId() {
		return imgId;
	}

	public void setImgId(String imgId) {
		this.imgId = imgId;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Boolean getModelCover() {
		return modelCover;
	}

	public void setModelCover(Boolean modelCover) {
		this.modelCover = modelCover;
	}

	public Boolean getProductCover() {
		return productCover;
	}

	public void setProductCover(Boolean productCover) {
		this.productCover = productCover;
	}
}
