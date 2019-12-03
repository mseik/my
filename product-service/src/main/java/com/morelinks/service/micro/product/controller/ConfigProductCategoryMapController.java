//package com.morelinks.service.micro.product.controller;
//
//import com.morelinks.core.dto.QueryPageParam;
//import com.morelinks.core.dto.ReturnValue;
//import com.morelinks.core.model.QueryResult;
//import com.morelinks.feign.micro.product.api.model.ConfigProductCategoryMap;
//import com.morelinks.feign.micro.product.api.model.dto.QueryProduct;
//import com.morelinks.feign.micro.product.api.service.IConfigProductCategoryMapController;
//import com.morelinks.service.micro.product.service.ConfigProductCategoryMapService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//@RestController
//public class ConfigProductCategoryMapController  implements IConfigProductCategoryMapController {
//
//    @Autowired
//ConfigProductCategoryMapService configProductCategoryMapService;
//@Override
//public ReturnValue<Integer> insert(@RequestBody ConfigProductCategoryMap obj) {
//
//    return ReturnValue.get200OK(this.configProductCategoryMapService.insert(obj));
//}
//
//@Override
//public ReturnValue<ConfigProductCategoryMap> getByPrimaryKey(@RequestParam(name ="id") Integer id) {
//    return ReturnValue.get200OK(this.configProductCategoryMapService.getByPrimaryKey(id));
//}
//
//@Override
//public ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name ="id") Integer id) {
//    return ReturnValue.get200OK(this.configProductCategoryMapService.deleteByPrimaryKey(id));
//}
//
//@Override
//public ReturnValue<Integer> updateByPrimaryKey(@RequestBody ConfigProductCategoryMap obj) {
//    return ReturnValue.get200OK(this.configProductCategoryMapService.updateByPrimaryKey(obj));
//}
//
//@Override
//public ReturnValue<List<ConfigProductCategoryMap>> find(@RequestBody QueryPageParam<ConfigProductCategoryMap> query) {
//    return ReturnValue.get200OK(this.configProductCategoryMapService.find(query.getQuery(),query.getPage()));
//}
//
//@Override
//public ReturnValue<QueryResult<ConfigProductCategoryMap>> getQueryResult(@RequestBody QueryPageParam<ConfigProductCategoryMap> query) {
//    return  ReturnValue.get200OK(this.configProductCategoryMapService.getQueryResult(query.getQuery(),query.getPage()));
//}
//
//@Override
//public  ReturnValue<List<String>> getMapKeyList(@RequestBody List<Integer> list) {
//    return ReturnValue.get200OK(this.configProductCategoryMapService.getMapKeyList(list));
//}
//
//@Override
//public ReturnValue<List<ConfigProductCategoryMap>> queryProduct(@RequestBody QueryProduct queryProduct) {
//    return ReturnValue.get200OK(this.configProductCategoryMapService.queryProduct(queryProduct));
//}
//}
