package com.morelinks.feign.micro.pay.api.service;


import com.morelinks.core.dto.ReturnValue;
import com.morelinks.feign.micro.pay.api.model.Account;
import com.morelinks.feign.micro.pay.api.model.PayOrder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//import org.springframework.cloud.netflix.feign.FeignClient;

@RequestMapping("/account")
public interface IAccountController {

	@RequestMapping(value = "/getById", method = {RequestMethod.GET})
	ReturnValue<Account> getById(@RequestParam(name = "id")Integer id);


	@RequestMapping(value = "/getAccount", method = {RequestMethod.GET})
	ReturnValue<Account> getAccount(@RequestParam(name = "accountKey")String accountKey,
	                                @RequestParam(name = "accountType")Integer accountType);


	@RequestMapping(value = "/createAccount", method = {RequestMethod.GET})
	ReturnValue<Integer> createAccount(@RequestParam(name = "accountKey")String accountKey,
	                                   @RequestParam(name = "accountType")Integer accountType);


}