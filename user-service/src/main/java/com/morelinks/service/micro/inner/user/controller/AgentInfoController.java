package com.morelinks.service.micro.inner.user.controller;

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
import com.morelinks.feign.micro.inner.user.api.model.UserAgentMap;
import com.morelinks.feign.micro.inner.user.api.model.UserInfo;
import com.morelinks.feign.micro.inner.user.api.service.IAgentInfoController;
import com.morelinks.service.micro.inner.user.service.AgentInfoService;
import com.morelinks.service.micro.inner.user.service.UserAgentMapService;
import com.morelinks.service.micro.inner.user.service.UserInfoService;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class AgentInfoController
   implements IAgentInfoController
{
    private Logger logger = LoggerFactory.getLogger(AgentInfoController.class);
    @Autowired
    public AgentInfoService baseService;

    @Autowired
    public UserAgentMapService mapService;

    @Autowired
    UserInfoService userInfoService;

    @Override
    public ReturnValue<Integer> insert(@RequestBody AgentInfo obj)
    {
        baseService.insert(obj);
        return ReturnValue.get200OK(obj.getId());
    }

    @Override
    public ReturnValue<AgentInfo> getByPrimaryKey(@RequestParam(name = "id") Integer id)
    {
        return ReturnValue.get200OK(baseService.getByPrimaryKey(id));
    }

    @Override
    public ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id")Integer id)
    {
        return ReturnValue.get200OK(baseService.deleteByPrimaryKey(id));
    }

    @Override
    public ReturnValue<Integer> updateByPrimaryKey(@RequestBody AgentInfo obj)
    {
        return ReturnValue.get200OK(baseService.updateByPrimaryKey(obj));
    }

    @Override
    public ReturnValue<List<AgentInfo>> find(@RequestBody QueryPageParam<AgentInfo> query) {
        return ReturnValue.get200OK(baseService.find(query.getQuery(), query.getPage()));
    }
    @Override
    public ReturnValue<QueryResult<AgentInfo>> getQueryResult(@RequestBody QueryPageParam<AgentInfo> query) {
        return ReturnValue.get200OK(baseService.getQueryResult(query.getQuery(), query.getPage()));
    }
    @Override
    public ReturnValue<AgentInfo> getByUserId(@RequestParam(name = "userId")Integer userId)
    {
        UserAgentMap map = mapService.getByPrimaryKey(userId);
        AgentInfo agentInfo = null;
        if(map!=null)
        {
            agentInfo=baseService.getByPrimaryKey(map.getAgentId());
        }
        return ReturnValue.get200OK(agentInfo);
    }

    @Override
    public ReturnValue<List<UserInfo>> getUserInfosByAgentId(@RequestParam(name = "agentId")Integer agentId)
    {
        List<UserInfo> lstInfo = new ArrayList<>();
        UserAgentMap queryMap = new UserAgentMap();
        queryMap.setAgentId(agentId);
        List<UserAgentMap> lstMap = mapService.find(queryMap,null);
        AgentInfo agentInfo = null;
        if(lstMap!=null)
        {
            for (UserAgentMap map:lstMap
                 ) {
                UserInfo user = userInfoService.getByPrimaryKey(map.getUserId());
                if(user==null)
                {
                    continue;
                }
                lstInfo.add(user);
            }
        }
        return ReturnValue.get200OK(lstInfo);
    }

    @Override
    public ReturnValue<UserInfo> registerUser4Agent(@RequestBody UserRegisterForm4Agent form)
    {

        return ReturnValue.get200OK(baseService.registerUser4Agent(form));
    }

}
