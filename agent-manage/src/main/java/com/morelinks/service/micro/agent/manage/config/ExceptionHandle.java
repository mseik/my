package com.morelinks.service.micro.agent.manage.config;

import com.morelinks.core.dto.IceAjaxResult;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常抓取配置
 */
@ControllerAdvice(basePackages = {"com.morelinks.service.micro.agent.manage.controller.api.ice"})
public class ExceptionHandle {
	private Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public IceAjaxResult handle(Exception e) {
		IceAjaxResult ret =IceAjaxResult.getFailResult("系统繁忙，请稍后再试");
		if (e instanceof BusinessException) {
			BusinessException businessException = (BusinessException) e;
			ret.setMessage(businessException.getMessage());
		}
		logger.error("ExceptionHandle",e);
		return ret;
	}
}
