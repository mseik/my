package com.morelinks.feign.micro.inner.user.api.service;


import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.model.QueryResult;
import com.morelinks.feign.micro.inner.user.api.model.UserSystemRole;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//import org.springframework.cloud.netflix.feign.FeignClient;

@RequestMapping("/userSystemRole")
public interface IUserSystemRoleController {

    @RequestMapping(value = "/insert", method = {RequestMethod.POST})
    ReturnValue<Integer> insert(@RequestBody UserSystemRole obj);

    @RequestMapping(value = "/getByPrimaryKey", method = {RequestMethod.GET})
    ReturnValue<UserSystemRole> getByPrimaryKey(@RequestParam(name = "id") Integer id);

    @RequestMapping(value = "/deleteByPrimaryKey", method = {RequestMethod.GET})
    ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id") Integer id);

    @RequestMapping(value = "/updateByPrimaryKey", method = {RequestMethod.POST})
    ReturnValue<Integer> updateByPrimaryKey(@RequestBody UserSystemRole obj);

    @RequestMapping(value = "/find", method = {RequestMethod.POST})
    ReturnValue<List<UserSystemRole>> find(@RequestBody QueryPageParam<UserSystemRole> query);

    @RequestMapping(value = "/getQueryResult", method = {RequestMethod.POST})
    ReturnValue<QueryResult<UserSystemRole>> getQueryResult(@RequestBody QueryPageParam<UserSystemRole> query) ;

    @RequestMapping(value = "/getByUserIdAndSystemId", method = {RequestMethod.GET})
    ReturnValue<UserSystemRole> getByUserIdAndSystemId(@RequestParam(name = "userId")Integer userId,
                                                       @RequestParam(name = "systemId")Integer systemId);

    @RequestMapping(value = "/getByUserIdAndSystemName", method = {RequestMethod.GET})
    ReturnValue<UserSystemRole> getByUserIdAndSystemName(@RequestParam(name = "userId")Integer userId,
                                                         @RequestParam(name = "systemName")String systemName);

    @RequestMapping(value = "/modifyUserRoles", method = {RequestMethod.POST})
    ReturnValue<UserSystemRole> modifyUserRoles(@RequestParam(name = "userId")Integer userId,
                                                @RequestParam(name = "roles")String roles,
                                                @RequestParam(name = "systemName")String systemName);


}