package com.morelinks.service.micro.inner.user.service;

import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.exception.BusinessException;
import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.core.util.StringUtil;
import com.morelinks.core.util.TelUtil;
import com.morelinks.feign.micro.inner.user.api.dto.UserRegisterForm;
import com.morelinks.feign.micro.inner.user.api.model.ManageSystemInfo;
import com.morelinks.feign.micro.inner.user.api.model.UserInfo;
import com.morelinks.service.micro.inner.user.mapper.UserInfoMapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;

@Transactional
@Service
public class UserInfoService extends BaseServiceWithQueryPage<UserInfo,Integer,UserInfoMapper> {

	@Autowired
	ManageSystemInfoService manageSystemInfoService;
	public UserInfo registerUser(UserRegisterForm form)
	{
		if(StringUtil.isTrimBlank(form.getUserName()))
		{
			throw new BusinessException("用户名不能为空");
		}
		if(StringUtil.isTrimBlank(form.getSystemName()))
		{
			throw new BusinessException("系统不存在");
		}
		if(StringUtil.isNotTrimBlank(form.getPassword()))
		{
			if(StringUtil.isTrimBlank(form.getConfirmPassword()) || !form.getConfirmPassword().equals(form.getPassword())) {
				throw new BusinessException("密码不正确");
			}
		}
		if(StringUtil.isNotTrimBlank(form.getUserTel()) && !TelUtil.isMobile(form.getUserTel()))
		{
			throw new BusinessException("手机号不正确");
		}
		ManageSystemInfo system = manageSystemInfoService.getBySystemName(form.getSystemName());
		if(system==null)
		{
			throw new BusinessException("未知系统");
		}
		UserInfo queryOld = new UserInfo();
		queryOld.setSystemType(system.getSystemType());
		queryOld.setUserName(form.getUserName());
		UserInfo oldUser = this.findTop1(queryOld);
		if(oldUser!=null)
		{
			throw new BusinessException("登录名已存在，请更换后重新注册");
		}
		if(StringUtil.isNotTrimBlank(form.getUserTel())) {
			queryOld = new UserInfo();
			queryOld.setUserTel(form.getUserTel());
			queryOld.setSystemType(system.getSystemType());
			oldUser = this.findTop1(queryOld);
			if (oldUser != null) {
				throw new BusinessException("该手机号已经绑定其他账号，请解绑后重新注册");
			}
		}
		UserInfo user = new UserInfo();
		user.setUserName(form.getUserName());
		user.setUserTel(form.getUserTel());
		user.setNickName(form.getNickName());
		user.setRealName(form.getRealName());
		user.setPassword(DigestUtils.md5Hex(form.getPassword()));
		user.setSystemType(system.getSystemType());
		user.setUpdateTime(new Date());
		user.setUserStatus(1);
		mapper.insert(user);
		return user;
	}

}