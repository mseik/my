package com.morelinks.service.micro.common.service;

import com.morelinks.core.dto.ReturnValue;

public interface SMSService {

    /**
     *
     * @param mobile
     * @param content
     * @param fromType 来源 1：app登录验证
     */
    Boolean sendSMS(String mobile, String content, int fromType,String fromSource);
}
