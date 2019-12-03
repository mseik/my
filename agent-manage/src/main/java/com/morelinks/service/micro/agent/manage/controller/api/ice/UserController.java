package com.morelinks.service.micro.agent.manage.controller.api.ice;

import com.morelinks.core.dto.IceAjaxResult;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.util.DateUtil;
import com.morelinks.core.util.StringUtil;
import com.morelinks.core.util.TelUtil;
import com.morelinks.core.webutil.ResourceUtil;
import com.morelinks.feign.micro.inner.user.api.client.AgentInfoFeignClient;
import com.morelinks.feign.micro.inner.user.api.client.AgentInvoiceInfoFeignClient;
import com.morelinks.feign.micro.inner.user.api.client.AgentLevelFeignClient;
import com.morelinks.feign.micro.inner.user.api.client.UserInfoFeignClient;
import com.morelinks.feign.micro.inner.user.api.model.AgentInfo;
import com.morelinks.feign.micro.inner.user.api.model.AgentInvoiceInfo;
import com.morelinks.feign.micro.inner.user.api.model.AgentLevel;
import com.morelinks.feign.micro.inner.user.api.model.UserInfo;
import com.morelinks.feign.micro.pay.api.client.AccountFeignClient;
import com.morelinks.feign.micro.pay.api.model.Account;
import com.morelinks.service.micro.agent.manage.dto.mall.AgentAccountDTO;
import com.morelinks.service.micro.agent.manage.dto.mall.MallSettingDTO;
import com.morelinks.service.micro.agent.manage.dto.UserInfoDTO;
import com.morelinks.service.micro.agent.manage.dto.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * 用户信息相关
 */
@Controller
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	UserInfoFeignClient userInfoFeignClient;
	@Autowired
	ResourceUtil resourceUtil;
	@Autowired
	AgentInfoFeignClient agentInfoFeignClient;
	@Autowired
	AgentLevelFeignClient agentLevelFeignClient;
	@Autowired
	AccountFeignClient accountFeignClient;
	@Autowired
	AgentInvoiceInfoFeignClient invoiceInfoFeignClient;

	@ResponseBody
	@RequestMapping(value = "/getUserProfile", method = {RequestMethod.GET})
	public IceAjaxResult<UserProfile> getUserProfile(UserInfo user) {
		IceAjaxResult<UserProfile> result = new IceAjaxResult<UserProfile>();
		if(user==null || user.getUserStatus()!=1)
		{
			return IceAjaxResult.getFailResult("用户不存在");
		}
		UserProfile profile = new UserProfile();
		if(StringUtil.isNotTrimBlank(user.getHeadImgPath())) {
			profile.setHeadImg(resourceUtil.getImgUrl(user.getHeadImgPath()));
		}
		profile.setNickName(user.getNickName());
		result.setData(profile);
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/getUserInfoDTO", method = {RequestMethod.GET})
	public IceAjaxResult<UserInfoDTO> getUserInfoDTO(UserInfo user) {
		IceAjaxResult<UserInfoDTO> result = new IceAjaxResult<UserInfoDTO>();
		if(user==null || user.getUserStatus()!=1)
		{
			return IceAjaxResult.getFailResult("用户不存在");
		}
		UserInfoDTO dto = new UserInfoDTO();
//		if(StringUtil.isNotTrimBlank(user.getHeadImgPath())) {
//			dto(resourceUtil.getImgUrl(user.getHeadImgPath()));
//		}
		dto.setNickName(user.getNickName());
		dto.setUserName(user.getUserName());
		dto.setUserTel(TelUtil.getTelShow(user.getUserTel()));
		ReturnValue<AgentInfo> retAgent = agentInfoFeignClient.getByUserId(user.getId());
		if(retAgent.getCode()==200 && retAgent.getObj()!=null) {
			dto.setAgentTel(TelUtil.getTelShow(retAgent.getObj().getContactTel()));
			dto.setAgentName(retAgent.getObj().getCompanyName());
			dto.setAgentEmail(retAgent.getObj().getContactEmail());
			dto.setAgentAddress(retAgent.getObj().getCompanyAddress());
		}
		result.setData(dto);
		return result;
	}


	@ResponseBody
	@RequestMapping(value = "/getAgentAccountDTO", method = {RequestMethod.GET})
	public IceAjaxResult<AgentAccountDTO> getAgentAccountDTO(UserInfo user) {
		IceAjaxResult<AgentAccountDTO> result = new IceAjaxResult<AgentAccountDTO>();
		if(user==null || user.getUserStatus()!=1)
		{
			return IceAjaxResult.getFailResult("用户不存在");
		}
		AgentAccountDTO dto = new AgentAccountDTO();
//		if(StringUtil.isNotTrimBlank(user.getHeadImgPath())) {
//			dto(resourceUtil.getImgUrl(user.getHeadImgPath()));
//		}
		ReturnValue<AgentInfo> retAgent = agentInfoFeignClient.getByUserId(user.getId());
		if(retAgent.getCode()!=200)
		{
			return IceAjaxResult.getFailResult("系统繁忙，请稍后再试");
		}
		AgentInfo agentInfo = retAgent.getObj();
		if(agentInfo==null)
		{
			dto = new AgentAccountDTO();
			dto.setAccountAmount(0d);
			dto.setGoodsAccountAmount(0d);
			dto.setLevel(0);
			dto.setLevelName("VIP0");
			dto.setValidEndTime("永久");
		}
		else{
			dto.setAccountAmount(0d);
			dto.setGoodsAccountAmount(0d);
			dto.setLevel(agentInfo.getAgentLevel());
			if(agentInfo.getLevelEndTime()!=null) {
				dto.setValidEndTime(DateUtil.format(agentInfo.getLevelEndTime(),"yyyy-MM-dd"));
			}
			ReturnValue<AgentLevel> retLevel = agentLevelFeignClient.getByLevel(agentInfo.getAgentLevel());
			if(retLevel.getCode()!=200 || retLevel.getObj()==null)
			{
				return IceAjaxResult.getFailResult("系统繁忙，请稍后再试");
			}
			dto.setLevelName(retLevel.getObj().getLevelName());

			ReturnValue<Account> retAccount = accountFeignClient.getAccount(agentInfo.getId().toString(),1);
			if(retAccount.getCode()!=200)
			{
				return IceAjaxResult.getFailResult("系统繁忙，请稍后再试");
			}
			if(retAccount.getObj()!=null)
			{
				dto.setAccountAmount(retAccount.getObj().getBalance().doubleValue());
			}
			ReturnValue<Account> retGoodsAccount = accountFeignClient.getAccount(agentInfo.getId().toString(),2);
			if(retGoodsAccount.getCode()!=200)
			{
				return IceAjaxResult.getFailResult("系统繁忙，请稍后再试");
			}
			if(retGoodsAccount.getObj()!=null)
			{
				dto.setGoodsAccountAmount(retGoodsAccount.getObj().getBalance().doubleValue());
			}
		}
		result.setData(dto);
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/setNeedTaxBill", method = {RequestMethod.POST})
	public IceAjaxResult setNeedTaxBill(Boolean needTax,UserInfo user) {
		IceAjaxResult result = new IceAjaxResult();
		if(user==null || user.getUserStatus()!=1)
		{
			return IceAjaxResult.getFailResult("用户不存在");
		}
		AgentAccountDTO dto = new AgentAccountDTO();
		ReturnValue<AgentInfo> retAgent = agentInfoFeignClient.getByUserId(user.getId());
		if(retAgent.getCode()!=200)
		{
			return IceAjaxResult.getFailResult("系统繁忙，请稍后再试");
		}
		AgentInfo agentInfo = retAgent.getObj();
		if(agentInfo==null)
		{
			return IceAjaxResult.getFailResult("请联系管理员录入信息");
		}
		agentInfo.setUpdateTime(new Date());
		agentInfo.setNoTaxBill(0);
		if(!needTax)
		{
			agentInfo.setNoTaxBill(1);
		}
		agentInfoFeignClient.updateByPrimaryKey(agentInfo);
		return result;
	}


	@ResponseBody
	@RequestMapping(value = "/modifyPassword", method = {RequestMethod.POST})
	public IceAjaxResult modifyPassword(String oldPassword,
	                                    String newPassword1,
	                                    String newPassword2,UserInfo user) {
		IceAjaxResult result = new IceAjaxResult();
		if(user==null || user.getUserStatus()!=1)
		{
			return IceAjaxResult.getFailResult("用户不存在");
		}
		if(StringUtil.isTrimBlank(newPassword1))
		{
			return IceAjaxResult.getFailResult("新密码不能为空");
		}
		if(!newPassword1.equals(newPassword2))
		{
			return IceAjaxResult.getFailResult("两次输入新密码不一致");
		}
		ReturnValue ret = userInfoFeignClient.modifyByPassword(user.getId(),oldPassword,newPassword1);
		if(ret.getCode()!=200)
		{
			return IceAjaxResult.getFailResult(ret.getMsg());
		}
		result.setMessage("修改密码成功");
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/getMallSetting", method = {RequestMethod.GET})
	public IceAjaxResult<MallSettingDTO> getMallSetting(Boolean needTax, UserInfo user) {
		IceAjaxResult<MallSettingDTO> result = new IceAjaxResult<MallSettingDTO>();
		MallSettingDTO settingDTO = new MallSettingDTO();
		settingDTO.setNeedTaxBill(true);
		result.setData(settingDTO);
		if(user==null || user.getUserStatus()!=1)
		{
			return IceAjaxResult.getFailResult("用户不存在");
		}
		AgentAccountDTO dto = new AgentAccountDTO();
		ReturnValue<AgentInfo> retAgent = agentInfoFeignClient.getByUserId(user.getId());
		if(retAgent.getCode()!=200)
		{
			return IceAjaxResult.getFailResult("系统繁忙，请稍后再试");
		}
		AgentInfo agentInfo = retAgent.getObj();
		if(agentInfo==null)
		{
			return IceAjaxResult.getFailResult("请联系管理员录入信息");
		}
		if(agentInfo.getNoTaxBill()!=null && agentInfo.getNoTaxBill()==1)
		{
			settingDTO.setNeedTaxBill(false);
		}
		ReturnValue<AgentInvoiceInfo> retInvoice = invoiceInfoFeignClient.getByAgentId(agentInfo.getId());
		if(retInvoice.getCode()!=200)
		{
			return IceAjaxResult.getFailResult("系统繁忙，请稍后再试");
		}
		settingDTO.setInvoice(retInvoice.getObj());
		return result;
	}


	@ResponseBody
	@RequestMapping(value = "/modifyUserInfo", method = {RequestMethod.POST})
	public IceAjaxResult modifyUserInfo(String userName,
	                                                    String nickName,
	                                                    String userTel,
	                                                    UserInfo user) {
		IceAjaxResult result = new IceAjaxResult();
		if(user==null || user.getUserStatus()!=1)
		{
			return IceAjaxResult.getFailResult("用户不存在");
		}
		user.setUserName(userName);
		user.setNickName(nickName);
		if(userTel!=null && !userTel.contains("*")) {
			user.setUserTel(userTel);
		}
		userInfoFeignClient.updateByPrimaryKey(user);
		result.setMessage("修改成功");
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/modifyCompanyInfo", method = {RequestMethod.POST})
	public IceAjaxResult modifyCompanyInfo(String agentName,
	                                    String agentAddress,
	                                    String agentTel,
	                                       String agentEmail,
	                                    UserInfo user) {
		IceAjaxResult result = new IceAjaxResult();
		if(user==null || user.getUserStatus()!=1)
		{
			return IceAjaxResult.getFailResult("用户不存在");
		}
		ReturnValue<AgentInfo> retAgent = agentInfoFeignClient.getByUserId(user.getId());
		if(retAgent.getCode()!=200)
		{
			return IceAjaxResult.getFailResult("系统繁忙，请稍后再试");
		}
		AgentInfo agentInfo = retAgent.getObj();
		if(agentInfo==null)
		{
			return IceAjaxResult.getFailResult("请联系管理员录入信息");
		}
		agentInfo.setCompanyAddress(agentAddress);
		agentInfo.setCompanyName(agentName);
		agentInfo.setContactEmail(agentEmail);
		if(agentTel!=null && !agentTel.contains("*")) {
			agentInfo.setContactTel(agentTel);
		}
		agentInfo.setUpdateTime(new Date());
		agentInfoFeignClient.updateByPrimaryKey(agentInfo);
		result.setMessage("修改成功");
		return result;
	}

}
