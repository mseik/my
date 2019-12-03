package com.morelinks.service.micro.common.controller;

import com.alibaba.fastjson.JSON;
import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.dto.ReturnValue;
import com.morelinks.core.util.StringUtil;
import com.morelinks.feign.micro.common.api.dto.WeatherSunRealTimeInfo;
import com.morelinks.feign.micro.common.api.dto.WeatherSunTimeInfo;
import com.morelinks.feign.micro.common.api.model.SMSTemplateConfig;
import com.morelinks.feign.micro.common.api.model.WeatherCity;
import com.morelinks.feign.micro.common.api.service.ICommonController;
import com.morelinks.service.micro.common.dto.XiaoMiCurrentWeatherDTO;
import com.morelinks.service.micro.common.service.SMSService;
import com.morelinks.service.micro.common.service.WeatherService;
import com.morelinks.service.micro.common.service.impl.SMSTemplateConfigService;
import com.morelinks.service.micro.common.service.impl.WeatherCityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class CommonController implements ICommonController {

    private Logger logger = LoggerFactory.getLogger(CommonController.class);
    @Autowired
    public SMSService smsService;
    @Autowired
    @Qualifier("xiaoMiWeatherServiceImpl")
    public WeatherService xmWeatherService;
    @Autowired
    @Qualifier("calendarWeatherServiceImpl")
    public WeatherService calWeatherService;
    @Autowired
    WeatherCityService cityService;
    @Autowired
    public SMSTemplateConfigService templateConfigService;

    @Override
    public ReturnValue<Boolean> sendSMS(@RequestParam(name = "mobile") String mobile,
                                 @RequestParam(name = "content") String content,
                                 @RequestParam(name = "fromType") Integer fromType,
                                        @RequestParam(name = "fromSource") String fromSource)
    {
        ReturnValue<Boolean> ret = new ReturnValue(200,"");
        ret.setObj(smsService.sendSMS(mobile,content,fromType,fromSource));
        return ret;
    }

    @Override
    public ReturnValue<Boolean> sendSMSByTemplate( @RequestParam(name = "mobile") String mobile,
                                            @RequestParam(name = "templateType") Integer templateType,
                                            @RequestParam(name = "fromType") Integer fromType,
                                            @RequestParam(name = "fromSource") String fromSource,
                                            @RequestParam(name = "replaceMap") Map<String,String> replaceMap)
    {
        ReturnValue<Boolean> ret = new ReturnValue(200,"");
        SMSTemplateConfig query = new SMSTemplateConfig();
        query.setFromSource(fromSource);
        query.setTemplateType(templateType);
        List<SMSTemplateConfig> lstConfig = templateConfigService.find(query,null);
        if(lstConfig==null || lstConfig.size()<=0)
        {
            query.setFromSource("morelinks");
            lstConfig = templateConfigService.find(query,null);
        }
        if(lstConfig==null || lstConfig.size()<=0)
        {
            ret.setObj(false);
            ret.setMsg("未找到模板");
            return ret;
        }
        String content=lstConfig.get(0).getContent();
        if(StringUtil.isTrimBlank(content))
        {
            ret.setObj(false);
            ret.setMsg("未找到模板");
            return ret;
        }
        if(replaceMap!=null && replaceMap.size()>0)
        {
            for (String key:replaceMap.keySet()
                 ) {
                content = content.replace("$"+key+"$",replaceMap.get(key));
            }
        }
        //datetime,content,username,usersex,usertel,projname,devicename
        content = content.replace("$datetime$","")
                .replace("$content$","")
                .replace("$username$","")
                .replace("$usersex$","")
                .replace("$usertel$","")
                .replace("$projname$","")
                .replace("$devicename$","");
        for(int i=0;i<=10;i++)
        {
            content = content.replace("$arg"+i+"$","");
        }
        logger.error("template content:"+content);
        return sendSMS(mobile,content,fromType,fromSource);
    }

    @Override
    public ReturnValue<String>  getWeather(@RequestParam(name = "cityId") String cityId)
    {
        ReturnValue<String> ret = new ReturnValue(200,"");
        XiaoMiCurrentWeatherDTO dto = xmWeatherService.getWeather(cityId);
        if(dto==null || dto.getRealtime()==null || StringUtil.isTrimBlank(dto.getRealtime().getTemp()))
        {
            dto = calWeatherService.getWeather(cityId);
            if(dto==null || dto.getRealtime()==null || StringUtil.isTrimBlank(dto.getRealtime().getTemp()))
            {
                WeatherCity query = new WeatherCity();
                query.setCityId(cityId);
                WeatherCity city = cityService.findTop1(query);
                if(city!=null && city.getCityType()!=null && city.getCityType()==3)
                {
                    dto = calWeatherService.getWeather(city.getParentCityId());
                }
            }
        }
        ret.setObj(JSON.toJSONString(dto));
        return ret;
    }

    @Override
    public ReturnValue<Map<String,WeatherSunTimeInfo>>  getWeatherSunTimeMap(@RequestParam(name = "cityId") String cityId)
    {
        ReturnValue<Map<String,WeatherSunTimeInfo>> ret = new ReturnValue(200,"");

        Map<String,WeatherSunTimeInfo> map = xmWeatherService.getWeatherSunTimeMap(cityId);
        if(map==null || map.size()<=0)
        {
            map = calWeatherService.getWeatherSunTimeMap(cityId);
            if(map==null || map.size()<=0)
            {
                WeatherCity query = new WeatherCity();
                query.setCityId(cityId);
                WeatherCity city = cityService.findTop1(query);
                if(city!=null && city.getCityType()!=null && city.getCityType()==3)
                {
                    map = calWeatherService.getWeatherSunTimeMap(city.getParentCityId());
                }
            }
        }
        ret.setObj(map);
        return ret;
    }

    @Override
    public ReturnValue<WeatherSunRealTimeInfo>  getWeatherSunRealTimeInfo(@RequestParam(name = "cityId") String cityId)
    {
        ReturnValue<WeatherSunRealTimeInfo> ret = new ReturnValue(200,"");
        WeatherSunRealTimeInfo dto = xmWeatherService.getCurrentWeather(cityId);
        if(dto==null || dto.getSunRiseTime()==null || StringUtil.isTrimBlank(dto.getTemp()))
        {
            dto = calWeatherService.getCurrentWeather(cityId);
            if(dto==null || dto.getSunRiseTime()==null || StringUtil.isTrimBlank(dto.getTemp()))
            {
                WeatherCity query = new WeatherCity();
                query.setCityId(cityId);
                WeatherCity city = cityService.findTop1(query);
                if(city!=null && city.getCityType()!=null && city.getCityType()==3)
                {
                    dto = calWeatherService.getCurrentWeather(city.getParentCityId());
                }
            }
        }
        ret.setObj(dto);
        return ret;
    }
}
