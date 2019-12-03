package com.morelinks.feign.micro.common.api.service;


import com.morelinks.core.dto.ReturnValue;
import com.morelinks.feign.micro.common.api.dto.WeatherSunRealTimeInfo;
import com.morelinks.feign.micro.common.api.dto.WeatherSunTimeInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

//import org.springframework.cloud.netflix.feign.FeignClient;

@RequestMapping("/")
public interface ICommonController {
    /**
     *
     * @param mobile
     * @param content
     * @param fromType 1:app服务
     * @param fromSource
     * @return
     */
    @RequestMapping(value = "/sendSMS", method = {RequestMethod.POST})
    ReturnValue<Boolean> sendSMS( @RequestParam(name = "mobile") String mobile,
                                 @RequestParam(name = "content") String content,
                                 @RequestParam(name = "fromType") Integer fromType,
                                  @RequestParam(name = "fromSource") String fromSource);

    /**
     *
     * @param mobile 手机号
     * @param templateType 模板类型 1：场景通知模板
     * @param fromType 服务类型 1：app服务
     * @param fromSource 来源：不同来源对应不同模板 如不传值则默认为morelinks
     * @param replaceMap 替换的map值 一一对应替换 默认有 datetime,content,username,usersex,usertel,projname,devicename
     *                   或者 用 arg0 arg1----arg10 默认支持10个参数
     * @return
     */
    @RequestMapping(value = "/sendSMSByTemplate", method = {RequestMethod.POST})
    ReturnValue<Boolean> sendSMSByTemplate( @RequestParam(name = "mobile") String mobile,
                                  @RequestParam(name = "templateType") Integer templateType,
                                  @RequestParam(name = "fromType") Integer fromType,
                                  @RequestParam(name = "fromSource") String fromSource,
                                  @RequestParam(name = "replaceMap") Map<String,String> replaceMap);


    @RequestMapping(value = "/getWeather", method = {RequestMethod.GET})
    ReturnValue<String>  getWeather(@RequestParam(name = "cityId") String cityId);

    @RequestMapping(value = "/getWeatherSunTimeMap", method = {RequestMethod.GET})
    ReturnValue<Map<String,WeatherSunTimeInfo>>  getWeatherSunTimeMap(@RequestParam(name = "cityId") String cityId);

    @RequestMapping(value = "/getWeatherSunRealTimeInfo", method = {RequestMethod.GET})
    ReturnValue<WeatherSunRealTimeInfo>  getWeatherSunRealTimeInfo(@RequestParam(name = "cityId") String cityId);
}