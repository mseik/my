package com.morelinks.feign.micro.device.config.api.service;


import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.feign.micro.device.config.api.model.Category;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//import org.springframework.cloud.netflix.feign.FeignClient;

@RequestMapping("/category")
public interface ICategoryController {

    @RequestMapping(value = "/insert", method = {RequestMethod.POST})
    int insert(@RequestBody Category obj);

    @RequestMapping(value = "/insertSelective", method = {RequestMethod.POST})
    int insertSelective(@RequestBody Category  log);

    @RequestMapping(value = "/updateByPrimaryKeySelective", method = {RequestMethod.POST})
    int updateByPrimaryKeySelective(@RequestBody Category  obj);

    @RequestMapping(value = "/getByPrimaryKey", method = {RequestMethod.GET})
    Category getByPrimaryKey(@RequestParam(name = "id") Integer id);

    @RequestMapping(value = "/deleteByPrimaryKey", method = {RequestMethod.GET})
    int deleteByPrimaryKey(@RequestParam(name = "id") Integer id);

    @RequestMapping(value = "/updateByPrimaryKey", method = {RequestMethod.POST})
    int updateByPrimaryKey(@RequestBody Category obj);

    @RequestMapping(value = "/find", method = {RequestMethod.POST})
    List<Category> find(@RequestBody QueryPageParam<Category> query);

    @RequestMapping(value = "/findCategoryByMember", method = {RequestMethod.GET})
    List<Category> findCategoryByMember(@RequestParam(name = "projectId", required = false) Integer projectId,
                                        @RequestParam(name = "memberId", required = false) Integer memberId,
                                        @RequestParam(name = "status", required = false) Integer status,
                                        @RequestParam(name = "sort", required = false) String sort,
                                        @RequestParam(name = "order", required = false) String order
    );
}