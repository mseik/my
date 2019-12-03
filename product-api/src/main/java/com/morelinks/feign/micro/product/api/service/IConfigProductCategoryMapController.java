//package com.morelinks.feign.micro.product.api.service;
//
//import com.morelinks.core.dto.QueryPageParam;
//import com.morelinks.core.dto.ReturnValue;
//import com.morelinks.core.model.QueryResult;
//import com.morelinks.feign.micro.product.api.model.ConfigProductCategoryMap;
//import com.morelinks.feign.micro.product.api.model.dto.QueryProduct;
//import org.apache.ibatis.annotations.Param;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//@RequestMapping("configProductCategoryMap")
//public interface IConfigProductCategoryMapController {
//@RequestMapping(value = "/insert", method = {RequestMethod.POST})
//ReturnValue<Integer> insert(@RequestBody ConfigProductCategoryMap obj);
//
//@RequestMapping(value = "/getByPrimaryKey", method = {RequestMethod.GET})
//ReturnValue<ConfigProductCategoryMap> getByPrimaryKey(@RequestParam(name = "id") Integer id);
//
//
//@RequestMapping(value = "/deleteByPrimaryKey", method = {RequestMethod.GET})
//ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id") Integer id);
//
//@RequestMapping(value = "/updateByPrimaryKey", method = {RequestMethod.POST})
//ReturnValue<Integer> updateByPrimaryKey(@RequestBody ConfigProductCategoryMap  obj);
//
//@RequestMapping(value = "/find", method = {RequestMethod.POST})
//ReturnValue<List<ConfigProductCategoryMap>> find(@RequestBody QueryPageParam<ConfigProductCategoryMap> query);
//
//@RequestMapping(value = "/getQueryResult", method = {RequestMethod.POST})
//ReturnValue<QueryResult<ConfigProductCategoryMap>> getQueryResult(@RequestBody QueryPageParam<ConfigProductCategoryMap> query);
//
//
//@RequestMapping(value = "/getMapKeyList", method = {RequestMethod.POST})
//ReturnValue<List<String>>  getMapKeyList(@RequestBody List<Integer> list);
//
//@RequestMapping(value = "/queryProduct", method = {RequestMethod.POST})
//ReturnValue<List<ConfigProductCategoryMap>>  queryProduct(@RequestBody  QueryProduct queryProduct);
//}
