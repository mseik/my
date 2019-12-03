package com.morelinks.service.micro.agent.manage.config;

import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.util.StringUtil;
import com.morelinks.feign.micro.inner.user.api.client.UserInfoFeignClient;
import com.morelinks.feign.micro.inner.user.api.model.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 参数注解
 */
@Component
public class UserAgentArgumentResolver implements HandlerMethodArgumentResolver {

    private Logger logger = LoggerFactory.getLogger(UserAgentArgumentResolver.class);
//    @Resource(name = "redisClientTemplate")
//    private RedisClientTemplate redisClientTemplate;


	@Autowired
	UserInfoFeignClient userInfoFeignClient;
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(UserInfo.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {
	    String token=webRequest.getHeader("token");
	    if(StringUtil.isTrimBlank(token))
	    {
		    return null;
	    }
	    ReturnValue<UserInfo> ret= userInfoFeignClient.getUserInfoByToken(token);
        return ret.getObj();
    }
}