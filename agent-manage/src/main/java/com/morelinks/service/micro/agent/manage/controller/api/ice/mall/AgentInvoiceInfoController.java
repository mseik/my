package com.morelinks.service.micro.agent.manage.controller.api.ice.mall;

import com.morelinks.core.dto.IceAjaxResult;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.util.IntUtil;
import com.morelinks.core.util.StringUtil;
import com.morelinks.feign.micro.inner.user.api.client.AgentInfoFeignClient;
import com.morelinks.feign.micro.inner.user.api.client.AgentInvoiceInfoFeignClient;
import com.morelinks.feign.micro.inner.user.api.model.AgentInfo;
import com.morelinks.feign.micro.inner.user.api.model.AgentInvoiceInfo;
import com.morelinks.feign.micro.inner.user.api.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 发票配置
 */
@RestController
@RequestMapping("/api/agentInvoiceInfo")
public class AgentInvoiceInfoController {

	@Autowired
	AgentInfoFeignClient agentInfoFeignClient;
	@Autowired
	AgentInvoiceInfoFeignClient invoiceInfoFeignClient;
	@RequestMapping(value = "/addOrUpdate", method = {RequestMethod.POST})
	public IceAjaxResult addOrUpdate(@RequestBody AgentInvoiceInfo obj, UserInfo user
	) {
		if(user==null || user.getUserStatus()!=1)
		{
			return IceAjaxResult.getFailResult("用户不存在");
		}
		if(obj==null)
		{
			return IceAjaxResult.getFailResult("请填写发票信息");
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
		IceAjaxResult result = new IceAjaxResult();
		String message = "更新成功";
		if(!IntUtil.isGreaterThanZero(obj.getId()))
		{
			obj.setCreateTime(new Date());
			obj.setInvoiceStatus(1);
			obj.setAgentId(agentInfo.getId());
			obj.setUpdateTime(new Date());
			message = "添加成功";
			invoiceInfoFeignClient.insert(obj);
		}
		else {
			ReturnValue<AgentInvoiceInfo> retInvoiceInfo =invoiceInfoFeignClient.getByPrimaryKey(obj.getId());
			if(retInvoiceInfo.getCode()!=200 || retInvoiceInfo.getObj() == null)
			{
				return IceAjaxResult.getFailResult(StringUtil.getErrorMsg(retInvoiceInfo.getMsg()));
			}
			AgentInvoiceInfo modifyInfo = retInvoiceInfo.getObj();
			modifyInfo.setAgentId(agentInfo.getId());
			modifyInfo.setUpdateTime(new Date());
			modifyInfo.setCompanyAddress(obj.getCompanyAddress());
			modifyInfo.setCompanyName(obj.getCompanyName());
			modifyInfo.setCompanyTel(obj.getCompanyTel());
			modifyInfo.setDepositBankAccount(obj.getDepositBankAccount());
			modifyInfo.setDepositBankName(obj.getDepositBankName());
			modifyInfo.setTaxNo(obj.getTaxNo());
			invoiceInfoFeignClient.updateByPrimaryKey(modifyInfo);
		}
		result.setMessage(message);
		return result;
	}

}
