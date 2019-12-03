package com.morelinks.feign.micro.inner.user.api.service;


import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.exception.BusinessException;
import com.morelinks.core.model.QueryResult;
import com.morelinks.core.util.StringUtil;
import com.morelinks.core.util.TelUtil;
import com.morelinks.feign.micro.inner.user.api.dto.UserRegisterForm;
import com.morelinks.feign.micro.inner.user.api.dto.UserRegisterForm4Agent;
import com.morelinks.feign.micro.inner.user.api.model.AgentInfo;
import com.morelinks.feign.micro.inner.user.api.model.ManageSystemInfo;
import com.morelinks.feign.micro.inner.user.api.model.UserInfo;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

//import org.springframework.cloud.netflix.feign.FeignClient;

@RequestMapping("/agentInfo")
public interface IAgentInfoController {

    @RequestMapping(value = "/insert", method = {RequestMethod.POST})
    ReturnValue<Integer> insert(@RequestBody AgentInfo obj);

    @RequestMapping(value = "/getByPrimaryKey", method = {RequestMethod.GET})
    ReturnValue<AgentInfo> getByPrimaryKey(@RequestParam(name = "id") Integer id);

    @RequestMapping(value = "/deleteByPrimaryKey", method = {RequestMethod.GET})
    ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id") Integer id);

    @RequestMapping(value = "/updateByPrimaryKey", method = {RequestMethod.POST})
    ReturnValue<Integer> updateByPrimaryKey(@RequestBody AgentInfo obj);

    @RequestMapping(value = "/find", method = {RequestMethod.POST})
    ReturnValue<List<AgentInfo>> find(@RequestBody QueryPageParam<AgentInfo> query);

    @RequestMapping(value = "/getQueryResult", method = {RequestMethod.POST})
    ReturnValue<QueryResult<AgentInfo>> getQueryResult(@RequestBody QueryPageParam<AgentInfo> query) ;

    @RequestMapping(value = "/getByUserId", method = {RequestMethod.GET})
    ReturnValue<AgentInfo> getByUserId(@RequestParam(name = "userId")Integer userId);

    @RequestMapping(value = "/getUserInfosByAgentId", method = {RequestMethod.GET})
    ReturnValue<List<UserInfo>> getUserInfosByAgentId(@RequestParam(name = "agentId")Integer agentId);

    @RequestMapping(value = "/registerUser4Agent", method = {RequestMethod.POST})
    ReturnValue<UserInfo> registerUser4Agent(@RequestBody UserRegisterForm4Agent form);


}