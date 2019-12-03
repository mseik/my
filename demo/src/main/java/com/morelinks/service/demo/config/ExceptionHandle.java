package com.morelinks.service.demo.config;

import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice(basePackages = {"com.morelinks.service.micro.order.controller"})
public class ExceptionHandle {
	private Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ReturnValue handle(Exception e) {
		ReturnValue ret = new ReturnValue(404,"系统繁忙，请稍后再试");
		ret.setRawMessage(e.toString());
		if (e instanceof BusinessException) {
			BusinessException businessException = (BusinessException) e;
//			if(businessException.getCode()==null){
//				return ReturnValue.error(businessException.getMessage());
//			}
			ret.setCode(500);
			ret.setMsg(businessException.getMessage());
		}
		logger.error("ExceptionHandle",e);
		return ret;
	}
}
