package com.morelinks.service.micro.inner.user.controller;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.encrypt.AESUtil;
import com.morelinks.core.exception.BusinessException;
import com.morelinks.core.model.QueryResult;
import com.morelinks.core.util.DateUtil;
import com.morelinks.core.util.IntUtil;
import com.morelinks.core.util.StringUtil;
import com.morelinks.core.util.TelUtil;
import com.morelinks.feign.micro.inner.user.api.dto.UserLoginDTO;
import com.morelinks.feign.micro.inner.user.api.dto.UserRegisterForm;
import com.morelinks.feign.micro.inner.user.api.model.*;
import com.morelinks.feign.micro.inner.user.api.service.IUserInfoController;
import com.morelinks.service.micro.inner.user.service.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static com.netflix.config.DeploymentContext.ContextKey.appId;

@RestController
	public class UserInfoController
			implements IUserInfoController
	{
		private String aesKey = "morelinks@$#";
		private Logger logger = LoggerFactory.getLogger(UserInfoController.class);
		@Autowired
		public UserInfoService baseService;

		@Autowired
		UserSystemRoleService systemRoleService;

		@Autowired
		ManageSystemInfoService manageSystemInfoService;

		@Autowired
		UserTicketService ticketService;
		@Autowired
		UserWeiXinMapService weiXinMapService;

		@Override
		public ReturnValue<Integer> insert(@RequestBody UserInfo obj)
		{
			baseService.insert(obj);
			return ReturnValue.get200OK(obj.getId());
		}

		@Override
		public ReturnValue<UserInfo> getByPrimaryKey(@RequestParam(name = "id") Integer id)
		{
			return ReturnValue.get200OK(baseService.getByPrimaryKey(id));
		}

		@Override
		public ReturnValue<Integer> deleteByPrimaryKey(@RequestParam(name = "id")Integer id)
		{
			return ReturnValue.get200OK(baseService.deleteByPrimaryKey(id));
		}

		@Override
		public ReturnValue<Integer> updateByPrimaryKey(@RequestBody UserInfo obj)
		{
			return ReturnValue.get200OK(baseService.updateByPrimaryKey(obj));
		}

		@Override
		public ReturnValue<List<UserInfo>> find(@RequestBody QueryPageParam<UserInfo> query) {
			return ReturnValue.get200OK(baseService.find(query.getQuery(), query.getPage()));
		}


		@Override
		public ReturnValue<QueryResult<UserInfo>> getQueryResult(@RequestBody QueryPageParam<UserInfo> query) {
			return ReturnValue.get200OK(baseService.getQueryResult(query.getQuery(), query.getPage()));
		}






		@Override
		public ReturnValue<UserLoginDTO> loginByPassword(@RequestParam(name = "userName")String userName,
		                                                 @RequestParam(name = "password")String password,
		                                                 @RequestParam(name = "systemName")String systemName,
		                                                 @RequestParam(name = "ticketValidTime",required = false)Integer ticketValidTime) {
			ReturnValue<UserLoginDTO> ret = new ReturnValue();

//			ret.setMsg("系统繁忙，请稍后再试");
			if(StringUtil.isTrimBlank(userName))
			{
				ret.setCode(500);
				ret.setMsg("登录名为空");
				return ret;
			}
			if(StringUtil.isTrimBlank(password))
			{
				ret.setCode(500);
				ret.setMsg("密码为空");
				return ret;
			}
			if(StringUtil.isTrimBlank(systemName))
			{
				ret.setCode(500);
				ret.setMsg("未知系统");
				return ret;
			}

			ManageSystemInfo system = manageSystemInfoService.getBySystemName(systemName);
			if(system==null)
			{
				ret.setCode(500);
				ret.setMsg("未知系统");
				return ret;
			}
			UserInfo query  = new UserInfo();
			query.setUserName(userName);
			query.setPassword(DigestUtils.md5Hex(password));
			query.setSystemType(system.getSystemType());
			UserInfo baseUser = baseService.findTop1(query);
			if(baseUser==null)
			{
				ret.setCode(500);
				ret.setMsg("用户名或密码错误");
				return ret;
			}
			if(baseUser.getUserStatus()!=1)
			{
				ret.setCode(500);
				ret.setMsg("用户已失效，请联系管理员");
				return ret;
			}
			UserTicket ticket = new UserTicket();
			ticket.setDeviceId("");
			ticket.setExpired(0);
			ticket.setExpireTime(DateUtil.add(new Date(), Calendar.HOUR,24));
			if(ticketValidTime!=null && ticketValidTime>0)
			{
				ticket.setExpireTime(DateUtil.add(new Date(), Calendar.SECOND,ticketValidTime));
			}
			ticket.setExtraInfo("");
			ticket.setIpAddress("");
			ticket.setIssueTime(new Date());
			ticket.setToken(UUID.randomUUID().toString().replace("-",""));
			ticket.setUserId(baseUser.getId());
			ticket.setSystemId(system.getId());
			ticket.setSystemType(system.getSystemType());
			ticketService.insert(ticket);
			ret.setObj(getDtobyUserAndSystemId(baseUser,ticket.getToken(),system.getId()));
			ret.setCode(200);
			return ret;
		}

		@Override
		public ReturnValue<UserLoginDTO> loginBySystemType(@RequestParam(name = "userName")String userName,
		                                                   @RequestParam(name = "password")String password,
		                                                   @RequestParam(name = "systemType")Integer systemType,
		                                                   @RequestParam(name = "ticketValidTime",required = false)Integer ticketValidTime) {
			ReturnValue<UserLoginDTO> ret = new ReturnValue();

//			ret.setMsg("系统繁忙，请稍后再试");
			if(StringUtil.isTrimBlank(userName))
			{
				ret.setCode(500);
				ret.setMsg("登录名为空");
				return ret;
			}
			if(StringUtil.isTrimBlank(password))
			{
				ret.setCode(500);
				ret.setMsg("密码为空");
				return ret;
			}
			if(!IntUtil.isGreaterThanZero(systemType))
			{
				ret.setCode(500);
				ret.setMsg("未知系统");
				return ret;
			}

			UserInfo query  = new UserInfo();
			query.setUserName(userName);
			query.setPassword(DigestUtils.md5Hex(password));
			query.setSystemType(systemType);
			UserInfo baseUser = baseService.findTop1(query);
			if(baseUser==null)
			{
				ret.setCode(500);
				ret.setMsg("用户名或密码错误");
				return ret;
			}
			if(baseUser.getUserStatus()!=1)
			{
				ret.setCode(500);
				ret.setMsg("用户已失效，请联系管理员");
				return ret;
			}
			UserTicket ticket = new UserTicket();
			ticket.setDeviceId("");
			ticket.setExpired(0);
			ticket.setExpireTime(DateUtil.add(new Date(), Calendar.HOUR,24));
			if(ticketValidTime!=null && ticketValidTime>0)
			{
				ticket.setExpireTime(DateUtil.add(new Date(), Calendar.SECOND,ticketValidTime));
			}
			ticket.setExtraInfo("");
			ticket.setIpAddress("");
			ticket.setIssueTime(new Date());
			ticket.setToken(UUID.randomUUID().toString().replace("-",""));
			ticket.setUserId(baseUser.getId());
			ticket.setSystemId(0);
			ticket.setSystemType(systemType);
			ticketService.insert(ticket);
			ret.setObj(getDtobyUserAndSystemId(baseUser,ticket.getToken(),ticket.getSystemId()));
			ret.setCode(200);
			return ret;
		}


		@Override
		public ReturnValue logoutByTicket(@RequestParam(name = "ticket")String ticket) {
			ReturnValue ret = new ReturnValue();
			if(StringUtil.isTrimBlank(ticket))
			{
				return ret;
			}
			UserTicket userTicket = ticketService.getByPrimaryKey(ticket);
			if(userTicket==null || userTicket.getExpired()==1)
			{
				return ret;
			}
			userTicket.setExpired(1);
			userTicket.setExpireTime(new Date());
			ticketService.updateByPrimaryKey(userTicket);
			ret.setCode(200);
			return ret;
		}


		@Override
		public ReturnValue modifyByPassword(@RequestParam(name = "userId")Integer userId,
		                                                  @RequestParam(name = "oldPassword")String oldPassword,
		                                                 @RequestParam(name = "newPassword")String newPassword) {
			ReturnValue<UserLoginDTO> ret = new ReturnValue();
			UserInfo baseUser = baseService.getByPrimaryKey(userId);
			if(baseUser==null)
			{
				ret.setCode(500);
				ret.setMsg("用户名或密码错误");
				return ret;
			}
			if(baseUser.getUserStatus()!=1)
			{
				ret.setCode(500);
				ret.setMsg("用户已失效，请联系管理员");
				return ret;
			}
			if(!DigestUtils.md5Hex(oldPassword).equals(baseUser.getPassword()))
			{
				ret.setCode(500);
				ret.setMsg("旧密码错误,不允许修改");
				return ret;
			}
			baseUser.setPassword(DigestUtils.md5Hex(newPassword));
			baseUser.setUpdateTime(new Date());
			baseService.updateByPrimaryKeySelective(baseUser);
			ret.setCode(200);
			return ret;
		}


		private UserLoginDTO getDtobyUserAndSystemId(UserInfo baseUser,String token,Integer systemId)
		{
			UserLoginDTO dto = new UserLoginDTO();
			dto.setNickName(baseUser.getNickName());
			dto.setRealName(baseUser.getRealName());
			dto.setUserName(baseUser.getUserName());
			dto.setRoles("guest");
			if(IntUtil.isGreaterThanZero(systemId)) {
				UserSystemRole role = systemRoleService.getByUserIdAndSystemId(baseUser.getId(), systemId);
				if(role!=null && StringUtil.isNotTrimBlank(role.getRoles())) {
					dto.setRoles(role.getRoles());
				}
			}
			dto.setSystemType(baseUser.getSystemType());
			dto.setToken(token);
			return dto;
		}

		@Override
		public ReturnValue<UserLoginDTO> getUserLoginDTOByToken(@RequestParam(name = "token")String token)
		{
			ReturnValue<UserLoginDTO> ret = new ReturnValue();
			UserTicket ticket = ticketService.getByPrimaryKey(token);
			if(ticket==null ||( ticket.getExpired()!=null && ticket.getExpired()>0 )|| ticket.getExpireTime().before(new Date()))
			{
				ret.setCode(500);
				ret.setMsg("登录信息已过期，请重新登录");
				return ret;
			}
			UserInfo baseUser =baseService.getByPrimaryKey(ticket.getUserId());
			ret.setObj(getDtobyUserAndSystemId(baseUser,ticket.getToken(),ticket.getSystemId()));
			ret.setCode(200);
			return ret;
		}
		@Override
		public ReturnValue<Boolean> checkUserTokenValid(@RequestParam(name = "token")String token)
		{
			ReturnValue<Boolean> ret = new ReturnValue();
			UserTicket ticket = ticketService.getByPrimaryKey(token);
			if(ticket==null )
			{
				ret.setCode(500);
				ret.setMsg("票据不存在");
				return ret;
			}
			if((ticket.getExpired()!=null && ticket.getExpired()>0 )|| ticket.getExpireTime().before(new Date()))
			{
				ret.setObj(false);
				ret.setCode(200);
				return ret;
			}
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			calendar.add(Calendar.DAY_OF_MONTH,1);
			if( ticket.getExpireTime().before(calendar.getTime())) {
				calendar.add(Calendar.DAY_OF_MONTH,1);
				ticket.setExpireTime(calendar.getTime());
				ticketService.updateByPrimaryKey(ticket);
			}
			ret.setObj(true);
			ret.setCode(200);
			return ret;
		}


		@Override
		public ReturnValue<UserInfo> getUserInfoByToken(@RequestParam(name = "token")String token)
		{
			ReturnValue<UserInfo> ret = new ReturnValue();
			UserTicket ticket = ticketService.getByPrimaryKey(token);
			if(ticket==null ||( ticket.getExpired()!=null && ticket.getExpired()>0 )|| ticket.getExpireTime().before(new Date()))
			{
				ret.setCode(500);
				ret.setMsg("登录信息已过期，请重新登录");
				return ret;
			}
			ret.setObj(baseService.getByPrimaryKey(ticket.getUserId()));
			ret.setCode(200);
			return ret;
		}


		@Override
		public ReturnValue<UserLoginDTO> loginByWeiXinMap(@RequestParam(name = "appId")String appId,
		                                                 @RequestParam(name = "openId")String openId,
		                                                 @RequestParam(name = "systemName")String systemName,
		                                                  @RequestParam(name = "ticketValidTime",required = false)Integer ticketValidTime) {
			ReturnValue<UserLoginDTO> ret = new ReturnValue();

//			ret.setMsg("系统繁忙，请稍后再试");
			if(StringUtil.isTrimBlank(appId))
			{
				ret.setCode(500);
				ret.setMsg("appId invalid");
				return ret;
			}
			if(StringUtil.isTrimBlank(openId))
			{
				ret.setCode(500);
				ret.setMsg("openId invalid");
				return ret;
			}
			if(StringUtil.isTrimBlank(systemName))
			{
				ret.setCode(500);
				ret.setMsg("未知系统");
				return ret;
			}

			ManageSystemInfo querySystem = new ManageSystemInfo();
			querySystem.setSystemName(systemName);
			ManageSystemInfo system = manageSystemInfoService.findTop1(querySystem);
			if(system==null)
			{
				ret.setCode(500);
				ret.setMsg("未知系统");
				return ret;
			}
			UserWeiXinMap query  = new UserWeiXinMap();
			query.setAppId(appId);
			query.setOpenId(openId);
			query.setSystemType(system.getSystemType());
			UserWeiXinMap map = weiXinMapService.findTop1(query);
			if(map==null)
			{
				ret.setCode(500);
				ret.setMsg("没有找到用户");
				return ret;
			}
			if(map.getIsBind()!=1 || !IntUtil.isGreaterThanZero(map.getUserId()) )
			{
				ret.setCode(500);
				ret.setMsg("用户未绑定");
				return ret;
			}
			UserInfo baseUser = baseService.getByPrimaryKey(map.getUserId());
			if(baseUser.getUserStatus()!=1)
			{
				ret.setCode(500);
				ret.setMsg("用户已失效，请联系管理员");
				return ret;
			}
			UserTicket ticket = new UserTicket();
			ticket.setDeviceId("");
			ticket.setExpired(0);
			ticket.setExpireTime(DateUtil.add(new Date(), Calendar.HOUR,24));
			ticket.setExtraInfo("");
			ticket.setIpAddress("");
			ticket.setIssueTime(new Date());
			ticket.setToken(UUID.randomUUID().toString().replace("-",""));
			ticket.setUserId(baseUser.getId());
			ticket.setSystemId(system.getId());
			ticketService.insert(ticket);
			ret.setObj(getDtobyUserAndSystemId(baseUser,ticket.getToken(),system.getId()));
			ret.setCode(200);
			return ret;
		}




		@Override
		public ReturnValue<UserInfo> registerUser(@RequestBody UserRegisterForm form)
		{

			return ReturnValue.get200OK(baseService.registerUser(form));
		}


		@Override
		public ReturnValue resetPassword(@RequestParam(name = "userId")Integer userId,
		                          @RequestParam(name = "operator",required = false)String operator,
		                          @RequestParam(name = "remark",required = false)String remark)
		{
			UserInfo user = baseService.getByPrimaryKey(userId);
			if(user==null)
			{
				throw  new BusinessException("用户非法");
			}
			user.setPassword("");
			user.setUpdateTime(new Date());
			baseService.updateByPrimaryKeySelective(user);
			return ReturnValue.get200OK(null);
		}


	}
