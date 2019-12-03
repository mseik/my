package com.morelinks.service.micro.common.service.impl;

import com.morelinks.core.util.StringUtil;
import com.morelinks.core.util.http.UtilHttp;
import com.morelinks.feign.micro.common.api.model.SMSConfig;
import com.morelinks.service.micro.common.service.SMSService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 短信帮助类
 */
@Service
public class CmppServiceImpl implements SMSService {

    private static Logger logger = LoggerFactory.getLogger(CmppServiceImpl.class);
//    @Value("${cmpp.server.ym.cdkey}")
//    String cdkey;
//    @Value("${cmpp.server.ym.password}")
//    String password;
//    @Value("${cmpp.server.ym.url}")
//    String url;

    @Autowired
    SMSConfigService smsConfigService;


	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Boolean sendSMS(String mobile, String content, int fromType,String fromSource) {

	    if(StringUtil.isTrimBlank(fromSource))
        {
            fromSource="morelinks";
        }
        SMSConfig config = smsConfigService.getByFromSource(fromSource);
	    if(config==null)
        {
            return false;
        }
	    if(!content.contains(config.getSignature()))
        {
            content="【"+config.getSignature()+"】"+content;
        }
        Map params = new HashMap();

        logger.error("cdkey:"+config.getYmCdkey());
        logger.error("password:"+config.getYmPassword());
        params.put("phone", mobile);
        params.put("message", content);
        params.put("cdkey", config.getYmCdkey());
        params.put("password", config.getYmPassword());
        //params.put("seqid", seqid);
        params.put("addserial", "");
        logger.error("url:"+config.getYmUrl());

        String str = UtilHttp.post(config.getYmUrl(), params);
        logger.error(str);
        return true;
        //System.out.println("短信返回："+str);
    }
	
	
//	public static void main(String[] args) {
//		String url="http://sdk4rptws.eucp.b2m.cn:8080/sdkproxy/sendsms.action";
//		String mobile="18668098821";
//		String message="【迈联智家】今天天气不错3";
//		String cdkey="6SDK-EMY-6688-SBWOT";
//		String password="986258";
//		Map params = new HashMap();
//        params.put("phone", mobile);
//        params.put("message", message);
//        params.put("cdkey", cdkey);
//        params.put("password", password);
//        params.put("seqid", "123");
//        params.put("addserial", "");
//        String str = UtilHttp.post(url, params);
//        System.out.println("短信返回："+str);
//	}
}
