package com.morelinks.service.micro.agent.manage.controller.api.ice;

import com.morelinks.core.dto.IceAjaxResult;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.util.StringUtil;
import com.morelinks.feign.micro.inner.user.api.client.UserInfoFeignClient;
import com.morelinks.feign.micro.inner.user.api.dto.UserLoginDTO;
import com.morelinks.service.micro.agent.manage.constants.ProductManageConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录
 */
@Controller
@RequestMapping("/api/login")
public class LoginController {
	@Autowired
	UserInfoFeignClient userInfoFeignClient;

	/**
	 * 登录接口
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/loginin", method = {RequestMethod.POST})
	public IceAjaxResult<UserLoginDTO> loginin( String username, String password) {


//		IceAjaxResult<UserLoginDTO> result = new IceAjaxResult<UserLoginDTO>();
		if(StringUtil.isTrimBlank(username))
		{
			return IceAjaxResult.getFailResult("用户名为空");
		}
		if(StringUtil.isTrimBlank(password))
		{
			return IceAjaxResult.getFailResult("密码为空");
		}
		ReturnValue<UserLoginDTO> retUser = userInfoFeignClient.loginByPassword(
				username,password, ProductManageConstant.SYSTEM_NAME,null);
        if(retUser.getCode()!=200)
        {
	        return IceAjaxResult.getFailResult(retUser.getMsg());
        }
		if(retUser.getObj()==null)
		{
			return IceAjaxResult.getFailResult("登录失败，请稍后再试");
		}
		IceAjaxResult<UserLoginDTO> result = new IceAjaxResult<UserLoginDTO>();
		result.setData(retUser.getObj());
		return result;
	}

	/**
	 * 登出
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/logout", method = {RequestMethod.POST})
	public IceAjaxResult logout(HttpServletRequest request) {
		IceAjaxResult result = new IceAjaxResult();
		String token=request.getHeader("token");
		if(StringUtil.isTrimBlank(token))
		{
			return result;
		}
		ReturnValue ret = userInfoFeignClient.logoutByTicket(token);
		if(ret.getCode()!=200)
		{
			return IceAjaxResult.getFailResult(StringUtil.getErrorMsg(ret.getMsg()));
		}
		return result;
	}

}
