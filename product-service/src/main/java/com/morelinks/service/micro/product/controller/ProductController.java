package com.morelinks.service.micro.product.controller;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.exception.BusinessException;
import com.morelinks.core.model.Page;
import com.morelinks.core.model.QueryResult;
import com.morelinks.core.util.StringUtil;
import com.morelinks.feign.micro.inner.user.api.client.AgentInfoFeignClient;
import com.morelinks.feign.micro.product.api.dto.ProductDTO;
import com.morelinks.feign.micro.product.api.model.*;
import com.morelinks.feign.micro.product.api.service.IProductController;
import com.morelinks.service.micro.product.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
public class ProductController
   implements IProductController
{
    private Logger logger = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    public ProductService baseService;
    @Autowired
    public ProductModelService modelService;
    @Autowired
    ProductPropertyService productPropertyService;
    @Autowired
    ProductImgService productImgService;
    @Autowired
    ProductBaseConfigService baseConfigService;
    @Autowired
    DiscountInfoService discountInfoService;
    @Autowired
    AgentInfoFeignClient agentInfoFeignClient;
    @Override
    public ReturnValue<Integer> insert(@RequestBody Product obj)
    {
        baseService.insert(obj);
        return ReturnValue.get200OK(obj.getId());
    }
    @Override
    public ReturnValue<Product> getByPrimaryKey(@RequestParam(name = "id") Integer id)
    {
        return ReturnValue.get200OK(baseService.getByPrimaryKey(id));
    }

    @Override
    public ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id")Integer id)
    {
        return ReturnValue.get200OK(baseService.deleteByPrimaryKey(id));
    }

    @Override
    public ReturnValue<Integer> updateByPrimaryKey(@RequestBody Product obj)
    {
        return ReturnValue.get200OK(baseService.updateByPrimaryKey(obj));
    }

    @Override
    public ReturnValue<List<Product>> find(@RequestBody QueryPageParam<Product> query) {
        return ReturnValue.get200OK(baseService.find(query.getQuery(), query.getPage()));
    }
    @Override
    public ReturnValue<QueryResult<Product>> getQueryResult(@RequestBody QueryPageParam<Product> query) {
        return ReturnValue.get200OK(baseService.getQueryResult(query.getQuery(), query.getPage()));
    }
    @Override
    public ReturnValue<ProductDTO> getProductDTO(@RequestParam(name = "id")Integer id) {
        return ReturnValue.get200OK(baseService.getProductDTO(id));
    }

    @Override
    public ReturnValue<BigDecimal> calProductShowAmount(@RequestParam(name = "productAmount")BigDecimal productAmount,
                                                        @RequestParam(name = "memberAmount",required = false)BigDecimal memberAmount,
                                                        @RequestParam(name = "userLevel",required = false)Integer userLevel,
                                                        @RequestParam(name = "noTaxBill",required = false)Integer noTaxBill,
                                                        @RequestParam(name = "discountRate",required = false)BigDecimal discountRate,
                                                        @RequestParam(name = "deduceGoods",required = false)Integer deduceGoods) {
        return ReturnValue.get200OK(calAmount( productAmount,  memberAmount,  userLevel, noTaxBill,  discountRate,  deduceGoods));
    }

    @Override
    public ReturnValue<BigDecimal> getUserDiscountRate(@RequestParam(name = "userLevel",required = false)Integer userLevel){
        return ReturnValue.get200OK(getDiscountRate( userLevel));
    }


    //region 价格计算
    //获取税率

    private BigDecimal taxRate=null;//10分钟缓存
    private Date lastConfigUpdate=new Date();
    private BigDecimal getTaxRate(Integer deduceGoods)
    {
        if(deduceGoods==null)
        {
            deduceGoods=0;
        }
        Calendar curCal = Calendar.getInstance();
        curCal.setTime(new Date());
        curCal.add(Calendar.MINUTE,-10);//10分钟缓存
        if(taxRate==null || lastConfigUpdate.before(curCal.getTime()))
        {
            ProductBaseConfig query = new ProductBaseConfig();
            query.setConfigType("taxRate");
            List<ProductBaseConfig> lstConfig = baseConfigService.find(query,null);
            lastConfigUpdate=new Date();
            if(lstConfig==null || lstConfig.size()<=0){
                throw  new BusinessException("产品配置错误");
            }
            for (ProductBaseConfig config:lstConfig
                    ) {
                if(StringUtil.isTrimBlank(config.getConfigKey()))
                {
                    continue;
                }
                if(config.getConfigKey().equalsIgnoreCase("productRate"))
                {
                    Double parseDouble = Double.parseDouble(config.getConfigVal());
                    if(parseDouble!=null && !Double.isInfinite(parseDouble) && !Double.isNaN(parseDouble))
                    {
                        taxRate = BigDecimal.valueOf(parseDouble);
                    }
                }
            }
        }
        return taxRate;
    }

    public BigDecimal calAmount(BigDecimal productAmount, BigDecimal memberAmount, Integer userLevel,Integer noTaxBill, BigDecimal discountRate, Integer deduceGoods)
    {
        if(productAmount==null)
        {
            throw new IllegalArgumentException("productAmount in valid");
        }
        BigDecimal amount =productAmount;
        if(discountRate==null)
        {
            discountRate =BigDecimal.valueOf(1d);
        }
        if(userLevel==null)
        {
            userLevel =-1;
        }
        if(userLevel>0 && memberAmount!=null && memberAmount.compareTo(BigDecimal.valueOf(0d))>0)
        {
            amount=memberAmount;
        }
        if(deduceGoods!=null &&deduceGoods==1 )
        {
            amount = amount.multiply(discountRate);
        }
        //agentUserInfo.getNoTaxBill()==null || agentUserInfo.getNoTaxBill()!=1
        if(noTaxBill==null || noTaxBill!=1)
        {
            //计算费率
            BigDecimal taxRate = getTaxRate( deduceGoods);
            if(taxRate.compareTo(BigDecimal.valueOf(0d))>0 && taxRate.compareTo(BigDecimal.valueOf(1d))<0)
            {
                amount = amount.add(amount.multiply(taxRate)) ;
            }
        }
        return amount.setScale(2,BigDecimal.ROUND_UP);
    }

    /**
     * 获取实际金额的折扣率 金额 * rate =实际支付金额
     * @param userLevel
     * @return
     */
    private BigDecimal getDiscountRate(Integer userLevel)
    {
        BigDecimal discountRate =BigDecimal.valueOf(1d);
        if(userLevel!=null && userLevel>0) {
            List<DiscountInfo> lstDiscount = discountInfoService.getValidDiscounts(userLevel.toString(), 3, userLevel);
            if (lstDiscount!= null
                    && lstDiscount.size() > 0 &&lstDiscount.get(0).getConditionType() != null && lstDiscount.get(0).getConditionType() == 1) {
                DiscountInfo discountInfo =lstDiscount.get(0);
                discountRate = (discountInfo.getConditionAmount().subtract(discountInfo.getDiscountAmount()))
                        .divide(discountInfo.getConditionAmount(),2,BigDecimal.ROUND_UP);//永远进1 确保付的钱更多
            }
        }
        return discountRate;
    }


    //endregion


}
