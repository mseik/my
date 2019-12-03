//package com.morelinks.service.micro.product.service;
//
//import com.morelinks.core.exception.BusinessException;
//import com.morelinks.core.service.BaseServiceWithQueryPage;
//import com.morelinks.feign.micro.product.api.model.ConfigProductCategoryMap;
//import com.morelinks.feign.micro.product.api.model.dto.QueryParentAggregate;
//import com.morelinks.feign.micro.product.api.model.dto.QueryProduct;
//import com.morelinks.service.micro.product.mapper.ConfigProductCategoryMapMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Transactional
//@Service
//public class ConfigProductCategoryMapService extends BaseServiceWithQueryPage<ConfigProductCategoryMap,Integer,ConfigProductCategoryMapMapper> {
//    @Autowired
//    ConfigCategoryService configCategoryService;
//    public List<String>  getMapKeyList(List<Integer> list){
//
//
//
//        QueryParentAggregate query =new QueryParentAggregate();
//        query.setTreeRoot(list);
//        List<Integer> buf= this.configCategoryService.parentAggregate(query);
//
//       if(buf==null){
//            throw  new BusinessException("未知类别");
//
//        }
//
//       return  this.mapper.getMapKey(buf);
//    }
//
// public   List<ConfigProductCategoryMap> queryProduct( QueryProduct queryProduct){
//        if (queryProduct==null){
//            throw  new BusinessException("引用对象为空");
//
//        }
//        if(queryProduct.getBrandIds().size()!=0||queryProduct.getCategoryIds().size()!=0||queryProduct.getProductName()!=null){
//            List<ConfigProductCategoryMap>      mapList=this.mapper.queryProduct(queryProduct);
//            if(mapList.size()==0){
//
//                return  new ArrayList<>();
//
//            }
//
//            return  mapList;
//        }else {
//            return  new ArrayList<>();
//
//        }
//
//
//}
//
//}