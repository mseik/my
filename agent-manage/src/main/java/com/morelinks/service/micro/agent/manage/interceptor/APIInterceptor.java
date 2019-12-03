package com.morelinks.service.micro.agent.manage.interceptor;

import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.util.StringUtil;
import com.morelinks.core.webutil.IpUtil;
import com.morelinks.feign.micro.inner.user.api.client.UserInfoFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.chuanjinet.common.redis.RedisClientTemplate;
//import com.chuanjinet.common.util.StringUtil;
//import com.morelinks.cloud.vo.Jcookie;
//import com.morelinks.cloud.vo.UtilConf;


@Component
public class APIInterceptor extends HandlerInterceptorAdapter {

    private Logger logger = LoggerFactory.getLogger(APIInterceptor.class);
    public static final String TOKEN_KEY = "abc123";

    @Value("${feign.white.ip:127.0.0.1}")
    String[] feignWhiteIp;

    private static final String[] IGNORE_URI = {
    		"/api/login/loginin",
		    "/upload"
    };

    @Value("${login.valid.time:259200}")
    String loginValidTime;

   private Logger log = LoggerFactory.getLogger(APIInterceptor.class);

//    @Autowired
//    private RedisUtil redisUtil;
//	@Autowired
//	private AppTicketService ticketService;
	@Autowired
	UserInfoFeignClient userInfoFeignClient;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        log.debug("request:" + request.getRequestURI());
        boolean flag = false;
//	    response.setHeader("Access-Control-Allow-Origin", "*");
//	    response.setHeader("Access-Control-Allow-Credentials", "true");
//	    response.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With");
//	    response.setHeader("Access-Control-Allow-Methods","*");//PUT,POST,GET,DELETE,OPTIONS
//	    response.setHeader("Access-Control-Expose-Headers", "*");
	    String url = request.getRequestURL().toString();
	    log.error("url:"+url);
       if(feignWhiteIp!=null && feignWhiteIp.length>0)
       {
	      String sourceIp = IpUtil.getIpAddr(request);
	      if(StringUtil.isNotTrimBlank(sourceIp)) {
		      log.info("sourceIp:" + sourceIp);
		      for (String ip : feignWhiteIp
				      ) {
					if(ip.equals(sourceIp))
					{
						return true;
					}
		      }
	      }
       }
//        if(url.contains("localhost") || url.contains("127.0.0.1"))
//        {
//            return true;
//        }
        for (String s : IGNORE_URI) {
            if (url.endsWith(s)) {
                flag = true;
                break;
            }
        }
        if (flag)
            return flag;
	    if(request.getMethod().equalsIgnoreCase("OPTIONS"))
	    {
		    return true;
	    }


	    request.setCharacterEncoding("UTF-8");
        String token=request.getHeader("token");
        if(StringUtil.isTrimBlank(token))
        {
	        log.error("url:"+url+"token非法");
	        response.setStatus(401);
	        return false;
        }
	    ReturnValue<Boolean> retCheckToken= userInfoFeignClient.checkUserTokenValid(token);
		if(retCheckToken.getCode()!=200 || retCheckToken.getObj()==null || !retCheckToken.getObj())
		{
			log.error("url:"+url+"token:"+token+" 已过期");
			//token失效
			response.setStatus(401);
			return false;
		}
		return true;
    	    //log.info("jcookie:" + jcookie);
//        String token = null;
//        String redisId = "";
//        //判断是否是app请求
//        if(!StringUtil.isBlank(jcookie)){//app请求
//        	String jcookieStr = URLDecoder.decode(jcookie, "UTF-8");
//        	Jcookie jcookieObj = JSONObject.parseObject(jcookieStr,Jcookie.class);
//        	if(jcookieObj!=null&&jcookieObj.getUserAgent()!=null){
//        		token = jcookieObj.getUserAgent().getToken();
//        		redisId = jcookieObj.getUserAgent().getMemberId();
//        	}
//        }
//
//        if (StringUtil.isTrimBlank(token)) {
//        }
//	    AppTicket ticket = ticketService.getByPrimaryKey(token);
//        if (ticket==null || IntUtil.isGreaterThanZero(ticket.getExpired()) || ticket.getExpireTime().before(new Date()) ) {
//            response.setStatus(403);
//            return false;
//        }
//        else {
//            if (!ticket.getMemberId().equals(redisId)) {
//                response.setStatus(403);
//                logger.error("token错误：redisId："+redisId+" redisToken:"+ticket.getMemberId());
//                return false;
//            }
//        }
//        if (StringUtils.isEmpty(loginValidTime)) {
//            loginValidTime = "3600";
//		}
//		ticket.setExpireTime(DateUtil.add(new Date(),Calendar.SECOND,Integer.parseInt(loginValidTime)));
//        ticketService.updateByPrimaryKeySelective(ticket);

   //     return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        //log.info("requesturl=" + request.getRequestURI());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }
}