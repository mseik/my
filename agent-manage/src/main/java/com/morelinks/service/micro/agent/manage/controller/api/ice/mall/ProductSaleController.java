package com.morelinks.service.micro.agent.manage.controller.api.ice.mall;

import com.morelinks.core.dto.*;
import com.morelinks.core.model.Page;
import com.morelinks.core.model.QueryResult;
import com.morelinks.core.util.IntUtil;
import com.morelinks.core.util.StringUtil;
import com.morelinks.core.webutil.ResourceUtil;
import com.morelinks.feign.micro.inner.user.api.client.AgentInfoFeignClient;
import com.morelinks.feign.micro.inner.user.api.model.AgentInfo;
import com.morelinks.feign.micro.inner.user.api.model.UserInfo;
import com.morelinks.feign.micro.product.api.client.*;
import com.morelinks.feign.micro.product.api.dto.ProductDTO;
import com.morelinks.feign.micro.product.api.dto.ProductModelDTO;
import com.morelinks.feign.micro.product.api.model.*;
import com.morelinks.feign.micro.product.api.model.dto.Query4ProductModel;
import com.morelinks.service.micro.agent.manage.dto.mall.*;
import com.morelinks.service.micro.agent.manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.*;

/**
 * 商品售卖类
 */
@RestController
@RequestMapping("/api/productsale")
public class ProductSaleController {
	@Autowired
	ProductFeignClient productFeignClient;
	@Autowired
	ProductSupplierFeignClient supplierFeignClient;
	@Autowired
	ProductModelFeignClient productModelFeignClient;
	@Autowired
	ResourceUtil resourceUtil;
	@Autowired
	AgentInfoFeignClient agentInfoFeignClient;
	@Autowired
	DiscountInfoFeignClient discountInfoFeignClient;
	@Autowired
	UserService userService;
	@Autowired
	ProductExtraInfoFeignClient productExtraInfoFeignClient;

	@RequestMapping(value = "/getSaleProductModelList", method = {RequestMethod.GET,RequestMethod.POST})
	public IceAjaxResult<IcePageData<SaleProductModelListUnit> > getSaleProductModelList(String brandIds, String categoryIds,
	                                                                                     Integer page, Integer pageSize, UserInfo user
	) {
		IceAjaxResult<IcePageData<SaleProductModelListUnit> > result = new IceAjaxResult<IcePageData<SaleProductModelListUnit> >();
		if(!IntUtil.isGreaterThanZero(page))
		{
			page =1;
		}
		if(!IntUtil.isGreaterThanZero(pageSize))
		{
			pageSize =10;
		}
		BigDecimal discountRate =new BigDecimal("1");
		int userLevel =-1;
		Integer noTaxBill =0;
		AgentInfo agentUserInfo=null;
		if(user!=null && user.getId()>0)
		{
			ReturnValue<AgentInfo> retAgent = agentInfoFeignClient.getByUserId(user.getId());
			if(retAgent.getCode()!=200)
			{
				IceAjaxResult.getFailResult("系统繁忙请稍后再试");
			}
			agentUserInfo = retAgent.getObj();
			if(agentUserInfo!=null) {
				noTaxBill=agentUserInfo.getNoTaxBill();
				userLevel = userService.getUserLevel(agentUserInfo);
				ReturnValue<BigDecimal> retRate = productFeignClient.getUserDiscountRate(userLevel);
				if(retRate.getCode()==200 && retRate.getObj()!=null)
				{
					discountRate=retRate.getObj();
				}
			}
		}
		IcePageData<SaleProductModelListUnit> pageResult = new IcePageData<SaleProductModelListUnit>();
		pageResult.setCurrentPage(page);
		QueryPageParam<Query4ProductModel> queryPageParam = new QueryPageParam<Query4ProductModel>();
		Query4ProductModel query = new Query4ProductModel();
		List<Integer> lstBrandId = new ArrayList<>();
		if(StringUtil.isNotTrimBlank(brandIds))
		{
			String[] arrId = brandIds.split(",");
			for (String sId:arrId
			     ) {
				Integer id = IntUtil.parseInt(sId,false);
				if(IntUtil.isGreaterThanZero(id))
				{
					lstBrandId.add(id);
				}
			}
		}
		if(lstBrandId.size()>0) {
			query.setBrandIds(lstBrandId);
		}

		List<Integer> lstCategoryId = new ArrayList<>();
		if(StringUtil.isNotTrimBlank(categoryIds))
		{
			String[] arrId = categoryIds.split(",");
			for (String sId:arrId
					) {
				Integer id = IntUtil.parseInt(sId,false);
				if(IntUtil.isGreaterThanZero(id))
				{
					lstCategoryId.add(id);
				}
			}
		}
		if(lstCategoryId.size()>0) {
			query.setCategoryIds(lstCategoryId);
		}
		query.setIsAgentSale(1);
		queryPageParam.setQuery(query);
		Page pageQuery = new Page();
		pageQuery.setLimit(pageSize);
		pageQuery.setOffset((page-1)*pageSize);
		queryPageParam.setPage(pageQuery);
		ReturnValue<QueryResult<ProductModelDTO>> retResult = productModelFeignClient.getModelDTOQueryResult(queryPageParam);
		if(retResult.getCode()==200 && retResult.getObj()!=null)
		{
			List<SaleProductModelListUnit> lstDTO = new ArrayList<SaleProductModelListUnit>();
			if(retResult.getObj().getItems()!=null)
			{
				for (ProductModelDTO dto:retResult.getObj().getItems()
						) {
					if(dto.getLstProduct()==null || dto.getLstProduct().size()<=0)
					{
						continue;
					}
					ProductDTO defaultProduct =dto.getLstProduct().get(0);
					SaleProductModelListUnit sale = new SaleProductModelListUnit();
					sale.setCoverPicUrl(resourceUtil.getImgUrl("/i/product/img/nopic.png"));
					if(StringUtil.isNotTrimBlank(defaultProduct.getCoverImgPath()))
					{
						sale.setCoverPicUrl(resourceUtil.getImgUrl(defaultProduct.getCoverImgPath()));
					}
					else {
						if(StringUtil.isNotTrimBlank(dto.getCoverImgPath()))
						{
							sale.setCoverPicUrl(resourceUtil.getImgUrl(dto.getCoverImgPath()));
						}
						else if(dto.getLstImg() != null && dto.getLstImg().size() > 0)
						{
							sale.setCoverPicUrl(resourceUtil.getImgUrl(dto.getLstImg().get(0).getImgPath()));
						}
					}
					sale.setDefaultProductId(defaultProduct.getId().toString());
					sale.setModelId(dto.getId().toString());
					if(defaultProduct.getProductAmount()==null)
					{
						continue;
					}
					ReturnValue<BigDecimal> retAmount =  productFeignClient.calProductShowAmount(defaultProduct.getProductAmount(),
							defaultProduct.getProductMemberAmount(),
							userLevel,noTaxBill,
							discountRate,
							defaultProduct.getDeduceGoodsAccount());
					if(retAmount.getCode()!=200 )
					{
						continue;
					}
					if(retAmount.getObj()==null ||retAmount.getObj().compareTo(new BigDecimal("0"))<=0)
					{
						continue;
					}
					if(defaultProduct.getProductAmount()==null)
					{
						continue;
					}
					sale.setProductAmount(retAmount.getObj().doubleValue());
					ReturnValue<BigDecimal> retMarketAmount =  productFeignClient.calProductShowAmount(defaultProduct.getProductAmount(),
							defaultProduct.getProductAmount(),
							-1,noTaxBill,
							new BigDecimal("1"),0);
					if(retMarketAmount.getCode()!=200)
					{
						continue;
					}
					if(retMarketAmount.getObj()==null ||retMarketAmount.getObj().compareTo(new BigDecimal("0"))<=0)
					{
						continue;
					}
					sale.setMarketAmount(retMarketAmount.getObj().doubleValue());
					String propertyName ="";
					if(dto.getLstProperty()!=null && dto.getLstProperty().size()>1) {
						for (ProductProperty property:dto.getLstProperty()
					     ){
//							if(propertyName!="")
//							{
//								propertyName+=" ";
//							}
							propertyName+=" "+property.getPropertyName();
						}
					}
					sale.setProductName(dto.getShowName()+propertyName);
					sale.setProductResume(defaultProduct.getResume());
					sale.setCore(false);
					if(defaultProduct.getDeduceGoodsAccount()!=null && defaultProduct.getDeduceGoodsAccount()==1) {
						sale.setCore(true);
					}
					lstDTO.add(sale);
				}
			}
			pageResult.setList(lstDTO);
			pageResult.setTotal(retResult.getObj().getTotalCount());
			pageResult.setPageSize(pageSize);
		}
		result.setData(pageResult);
		return result;
	}

	@RequestMapping(value = "/getSaleProductModelDTO", method = {RequestMethod.GET,RequestMethod.POST})
	public IceAjaxResult<SaleProductModelDTO> getList(Integer modelId, Integer productId, UserInfo user
	) {
		IceAjaxResult<SaleProductModelDTO> result = new IceAjaxResult<SaleProductModelDTO>();
		SaleProductModelDTO dto = new SaleProductModelDTO();
		result.setData(dto);
		if(IntUtil.isGreaterThanZero(productId))
		{
			modelId=0;
			ReturnValue<Product> retProduct = productFeignClient.getByPrimaryKey(productId);
			if(retProduct.getCode()!=200)
			{
				return IceAjaxResult.getFailResult(StringUtil.getErrorMsg(retProduct.getMsg()));
			}
			Product product = retProduct.getObj();
			if(product!=null && product.getProductStatus()==1 && product.getIsAgentSale()!=null && product.getIsAgentSale()==1)
			{
				modelId =product.getModelId();
			}
		}
		if(!IntUtil.isGreaterThanZero(modelId))
		{
			return IceAjaxResult.getFailResult("商品不存在");
		}
		ReturnValue<ProductModelDTO> retModel = productModelFeignClient.getModelDTO(modelId);
		if(retModel.getCode()!=200 || retModel.getObj()==null)
		{
			return IceAjaxResult.getFailResult("商品不存在");
		}
		ProductModelDTO model =retModel.getObj();
		if(model==null
				|| model.getLstPropertyType() == null|| model.getLstPropertyType().size()<=0
				|| model.getLstProduct()==null ||  model.getLstProduct().size()<=0 || model.getIsAgentSale()==null
				|| model.getIsAgentSale()!=1)
		{
			return IceAjaxResult.getFailResult("商品不存在");
		}

		BigDecimal discountRate =new BigDecimal("1");
		int userLevel =-1;
		Integer noTaxBill =0;
		AgentInfo agentUserInfo=null;
		if(user!=null && user.getId()>0)
		{
			//region 获取价格配置
			ReturnValue<AgentInfo> retAgent = agentInfoFeignClient.getByUserId(user.getId());
			if(retAgent.getCode()!=200)
			{
				IceAjaxResult.getFailResult("系统繁忙请稍后再试");
			}
			agentUserInfo = retAgent.getObj();
			if(agentUserInfo!=null) {
				noTaxBill=agentUserInfo.getNoTaxBill();
				userLevel = userService.getUserLevel(agentUserInfo);
				ReturnValue<BigDecimal> retRate = productFeignClient.getUserDiscountRate(userLevel);
				if(retRate.getCode()==200 && retRate.getObj()!=null)
				{
					discountRate=retRate.getObj();
				}
			}
			//endregion
		}
//		dto.setProductAmount(-1);
//		dto.setProductName(model.getShowName());
//		List<String> lstPic = new ArrayList<>();
//		lstPic.add(resourceUtil.getImgUrl("/i/product/img/nopic.png"));
//		dto.setShowPics(lstPic);
//		if(model.getLstImg()!=null && model.getLstImg().size()>0) {
//			lstPic.clear();
//			for (ProductImg img :model.getLstImg()
//					) {
//				if(StringUtil.isTrimBlank(img.getImgPath()))
//				{
//					continue;
//				}
//				lstPic.add(resourceUtil.getImgUrl(img.getImgPath()));
//			}
//		}
		dto.setProductResume(model.getResume());
		dto.setModelId(model.getId().toString());
		Map<Integer,Map<Integer,ProductProperty>> mapPropertyType = new HashMap<>();//过滤不存在的属性
		List<SaleProductDTO> lstSale = new ArrayList<SaleProductDTO>();
		boolean checkProjectExist = false;
		for (ProductDTO productDTO:model.getLstProduct()) {

			//商品不售卖 不显示
			if(productDTO==null || productDTO.getProductStatus()!=1 || productDTO.getIsAgentSale()==null || productDTO.getIsAgentSale()!=1)
			{
				continue;
			}
			SaleProductDTO saleProductDTO = new SaleProductDTO();
			saleProductDTO.setProductId(productDTO.getId().toString());
			saleProductDTO.setProductResume(productDTO.getResume());
			saleProductDTO.setCoverPicUrl(resourceUtil.getImgUrl("/i/product/img/nopic.png"));
			if(productDTO.getLstImg()!=null && productDTO.getLstImg().size()>0) {
				saleProductDTO.setCoverPicUrl(resourceUtil.getImgUrl(productDTO.getLstImg().get(0).getImgPath()));
			}
			//region 检测商品价格
			if( productDTO.getProductAmount()==null || productDTO.getProductAmount().compareTo(new BigDecimal("0"))<=0)
			{
				continue;
			}
			ReturnValue<BigDecimal> retAmount =  productFeignClient.calProductShowAmount(productDTO.getProductAmount(),
					productDTO.getProductMemberAmount(),
					userLevel,noTaxBill,
					discountRate,
					productDTO.getDeduceGoodsAccount());
			if(retAmount.getCode()!=200 || retAmount.getObj()==null ||retAmount.getObj().compareTo(new BigDecimal("0"))<=0)
			{
				continue;
			}
			saleProductDTO.setProductAmount(retAmount.getObj().doubleValue());
			//endregion
			saleProductDTO.setLstProperty(productDTO.getLstProperty());
			StringBuilder productName = new StringBuilder();
			productName.append(productDTO.getProductName());
			Map<Integer,Integer> mapPropertyIds = new HashMap<>();
			if(productDTO.getLstProperty()!=null)
			{
				for (ProductProperty property:productDTO.getLstProperty()
						) {
					mapPropertyIds.put(property.getPropertyTypeId(),property.getId());
					productName.append(" ");
					productName.append(property.getPropertyName());
					if(!mapPropertyType.containsKey(property.getPropertyTypeId()))
					{
						mapPropertyType.put(property.getPropertyTypeId(),new HashMap<Integer,ProductProperty>());
					}
					if(!mapPropertyType.get(property.getPropertyTypeId()).containsKey(property.getId())) {
						mapPropertyType.get(property.getPropertyTypeId()).put(property.getId(), property);
					}
				}
			}
			saleProductDTO.setProductName(productName.toString());
			if(productDTO.getId().equals(productId))
			{
				checkProjectExist=true;
				dto.setProductName(saleProductDTO.getProductName());
				dto.setProductResume(saleProductDTO.getProductResume());
				dto.setSelectedPropertys(mapPropertyIds);
				List<String> lstPic = new ArrayList<>();
				if(productDTO.getLstImg()!=null && productDTO.getLstImg().size()>0) {
					for (ProductImg img:productDTO.getLstImg()
					     ) {
						lstPic.add(resourceUtil.getImgUrl(img.getImgPath()));
					}
				}
				dto.setShowPics(lstPic);
				dto.setProductAmount(saleProductDTO.getProductAmount());
			}
			lstSale.add(saleProductDTO);
		}
		if(!checkProjectExist)
		{
			IceAjaxResult.getFailResult("商品不存在");
			return result;
		}
		dto.setLstProduct(lstSale);
		//region 过滤不存在的类别属性 显示只存在的属性
		List<SaleProductProperyTypeDTO> lstTypeDTO =new ArrayList<SaleProductProperyTypeDTO>();
		for (ProductPropertyType type:model.getLstPropertyType()
				) {
			if(!mapPropertyType.containsKey(type.getId()))
			{
				continue;
			}
			SaleProductProperyTypeDTO typeDTO = new SaleProductProperyTypeDTO();
			typeDTO.setPropertyTypeId(type.getId());
			typeDTO.setPropertyTypeName(type.getPropertyTypeName());

			Map<Integer,ProductProperty> mapProperty = mapPropertyType.get(type.getId());
			if(mapProperty!=null)
			{
				List<SaleProductProperyDTO> lstPropertyDTO = new ArrayList<>();
				for (Integer key:mapProperty.keySet()
						) {
					SaleProductProperyDTO productProperyDTO = new SaleProductProperyDTO();
					productProperyDTO.setPropertyId(mapProperty.get(key).getId());
					productProperyDTO.setPropertyName(mapProperty.get(key).getPropertyName());
					lstPropertyDTO.add(productProperyDTO);
				}
				typeDTO.setLstProperty(lstPropertyDTO);
			}

			lstTypeDTO.add(typeDTO);
		}
		//endregion
		dto.setLstPropertyType(lstTypeDTO);//设置只存在的属性
		return result;
	}

	@RequestMapping(value = "/getExtraInfo", method = {RequestMethod.GET,RequestMethod.POST})
	public IceAjaxResult<ProductExtraInfo> getExtraInfo(
			Integer modelId,Integer productId
	) {
		IceAjaxResult<ProductExtraInfo> result = new IceAjaxResult<ProductExtraInfo>();
		String key ="";
		Integer type =0;
		if(IntUtil.isGreaterThanZero(modelId))
		{
			type =1;
			key =modelId.toString();
		}
		if(IntUtil.isGreaterThanZero(productId))
		{
			type =2;
			key =productId.toString();
			ReturnValue<Product> retProduct = productFeignClient.getByPrimaryKey(productId);
			if(retProduct.getCode()!=200 || retProduct.getObj()==null)
			{
				return IceAjaxResult.getFailResult("商品不存在");
			}
			modelId=retProduct.getObj().getModelId();
		}
		if(type<=0)
		{
			return IceAjaxResult.getFailResult("获取信息失败");
		}
		ProductExtraInfo extraInfo = null;
		ReturnValue<ProductExtraInfo> retExtra = productExtraInfoFeignClient.getByExtraKey(key,type);
		if(retExtra.getCode()!=200)
		{
			return IceAjaxResult.getFailResult("系统繁忙，请稍后再试！");
		}
		extraInfo = retExtra.getObj();
		if(type==2 && IntUtil.isGreaterThanZero(modelId))
		{
			retExtra = productExtraInfoFeignClient.getByExtraKey(modelId.toString(),1);
			if(retExtra.getObj()!=null)
			{
				ProductExtraInfo modelExtra = retExtra.getObj();
				if(extraInfo==null)
				{
					extraInfo = new ProductExtraInfo();
				}
				if(StringUtil.isTrimBlank(extraInfo.getIntroduce()))
				{
					extraInfo.setIntroduce(modelExtra.getIntroduce());
				}
				if(StringUtil.isTrimBlank(extraInfo.getParametersIntro()))
				{
					extraInfo.setParametersIntro(modelExtra.getParametersIntro());
				}
				if(StringUtil.isTrimBlank(extraInfo.getAfterSaleIntro()))
				{
					extraInfo.setAfterSaleIntro(modelExtra.getAfterSaleIntro());
				}
			}
		}
		if(extraInfo==null)
		{
			extraInfo = new ProductExtraInfo();
		}
		result.setData(extraInfo);
		return result;
	}


}
