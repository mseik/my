package com.morelinks.service.micro.common.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.morelinks.core.util.DateUtil;
import com.morelinks.core.util.IntUtil;
import com.morelinks.core.util.http.UtilHttp;
import com.morelinks.feign.micro.common.api.dto.WeatherSunRealTimeInfo;
import com.morelinks.feign.micro.common.api.dto.WeatherSunTimeInfo;
import com.morelinks.service.micro.common.dto.XiaoMiCurrentWeatherDTO;
import com.morelinks.service.micro.common.dto.XiaoMiRealTimeWeatherDTO;
import com.morelinks.service.micro.common.dto.XiaoMiSunInfo;
import com.morelinks.service.micro.common.service.SMSService;
import com.morelinks.service.micro.common.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 短信帮助类
 */
@Service
public class XiaoMiWeatherServiceImpl implements WeatherService {
    private static Logger logger = LoggerFactory.getLogger(XiaoMiWeatherServiceImpl.class);

    public ConcurrentHashMap<String,Map<String,WeatherSunTimeInfo>> mapWeatherSunTime = new ConcurrentHashMap<String,Map<String,WeatherSunTimeInfo>>();

    public XiaoMiCurrentWeatherDTO getWeather(String cityId)
    {
        XiaoMiCurrentWeatherDTO dto = new XiaoMiCurrentWeatherDTO();


        Map<String,String> params=new HashMap<String,String>();
        params.put("cityId", cityId);
        String text = UtilHttp.get("http://weatherapi.market.xiaomi.com/wtr-v2/weather",params);
        JSONObject jsonObj = JSON.parseObject(text);



        JSONObject realtimeObj = jsonObj.getJSONObject("realtime");
//        resultObj.put("realtime", realtimeObj);
        dto.setRealtime(realtimeObj.toJavaObject(XiaoMiRealTimeWeatherDTO.class));

        JSONObject aqiObj = jsonObj.getJSONObject("aqi");
        if(aqiObj!=null && dto.getRealtime()!=null)
        {
            dto.getRealtime().setAqi(aqiObj.getString("aqi"));
            dto.getRealtime().setPm25(aqiObj.getString("pm25"));
            //从一级优，二级良，三级轻度污染，四级中度污染，直至五级重度污染，六级严重污染。
            Integer nAqi = IntUtil.parseInt(dto.getRealtime().getAqi(),false);
            if(nAqi!=null && nAqi>=0)
            {
                String quality ="";
                //0－50、51－100、101－150、151－200、201－300和大于300六档
                if(nAqi>300)
                {
                    quality="严重污染";
                }
                else if(nAqi>200)
                {
                    quality="重度污染";
                }
                else if(nAqi>150)
                {
                    quality="中度污染";
                }
                else if(nAqi>150)
                {
                    quality="轻度污染";
                }
                else if(nAqi>50)
                {
                    quality="良";
                }
                else
                {
                    quality="优";
                }
                dto.getRealtime().setQuality(quality);
            }
        }
        //System.out.println(realtimeObj.toJSONString());
        //{"SD":"45%","isRadar":"1","time":"10:10","WSE":"","WS":"3级","WD":"西南偏西风","weather":"晴","temp":"21","radar":"JC_RADAR_AZ9010_JB","cityid":"101210101","city":""}


        //JSONObject accuCcObj = jsonObj.getJSONObject("accu_cc");
        //resultObj.put("accu_cc", accuCcObj);
        //System.out.println(accuCcObj.toJSONString());
        //{"EpochTime":"1493345400","RelativeHumidity":"45","UVIndex":"8","WindDirectionDegrees":"248","Visibility":"16.1","WindSpeed":"13.0","RealFeelTemperature":"24.7","Pressure":"1017.0","LocalObservationDateTime":"2017-04-28T10:10:00+08:00"}

        JSONObject DailyForecasts0 = jsonObj.getJSONObject("accu_f5").getJSONArray("DailyForecasts").getJSONObject(0);
//        resultObj.put("accu_f0", DailyForecasts0.toJSONString());
        dto.setSunInfo(DailyForecasts0.toJavaObject(XiaoMiSunInfo.class));
        //System.out.println(DailyForecasts0.toJSONString());
        //{"Sun_Rise":"2017-04-28T05:20:00+08:00","Date":"2017-04-28T07:00:00+08:00","PrecipitationProbability":"0","Sun_EpochSet":"1493375700","Sun_EpochRise":"1493328000","Sun_Set":"2017-04-28T18:35:00+08:00","EpochDate":"1493334000"}


        //根据经纬度计算日出日落时间
        //System.out.println(SunTimes.GetSunTime(120.20000,30.26667));

        return dto;
    }

    public WeatherSunRealTimeInfo getCurrentWeather(String cityId)
    {
        JSONObject resultObj=new JSONObject(true);


        Map<String,String> params=new HashMap<String,String>();
        params.put("cityId", cityId);
        String text = UtilHttp.get("http://weatherapi.market.xiaomi.com/wtr-v2/weather",params);
        JSONObject jsonObj = JSON.parseObject(text);
        //System.out.println(text);
        WeatherSunRealTimeInfo info = new WeatherSunRealTimeInfo();
        JSONObject realtimeObj = jsonObj.getJSONObject("realtime");
        if(realtimeObj!=null)
        {
            info.setHumidity(realtimeObj.getString("SD"));
            info.setCurWeather(realtimeObj.getString("weather"));
            info.setCurWindLevel(realtimeObj.getString("WS"));
            info.setWindSpeed(realtimeObj.getString("WS"));
            info.setWindDirection(realtimeObj.getString("WD"));
            info.setTemp(realtimeObj.getString("temp"));
        }
        JSONObject aqiObj = jsonObj.getJSONObject("aqi");
        if(aqiObj!=null)
        {
            info.setAqi(aqiObj.getString("aqi"));
            info.setPm25(aqiObj.getString("pm25"));
            //从一级优，二级良，三级轻度污染，四级中度污染，直至五级重度污染，六级严重污染。
            Integer nAqi = IntUtil.parseInt(info.getAqi(),false);
            if(nAqi!=null && nAqi>=0)
            {
                String quality ="";
                //0－50、51－100、101－150、151－200、201－300和大于300六档
                if(nAqi>300)
                {
                    quality="严重污染";
                }
                else if(nAqi>200)
                {
                    quality="重度污染";
                }
                else if(nAqi>150)
                {
                    quality="中度污染";
                }
                else if(nAqi>150)
                {
                    quality="轻度污染";
                }
                else if(nAqi>50)
                {
                    quality="良";
                }
                else
                {
                    quality="优";
                }
                info.setQuality(quality);
            }
        }
        JSONObject DailyForecasts0 = jsonObj.getJSONObject("accu_f5").getJSONArray("DailyForecasts").getJSONObject(0);
         if(DailyForecasts0!=null) {
            info.setSunRiseTime(DateUtil.parse(DailyForecasts0.getString("Sun_Rise"), "yyyy-MM-dd'T'HH:mm:ssX"));
            info.setSunSetTime(DateUtil.parse(DailyForecasts0.getString("Sun_Set"), "yyyy-MM-dd'T'HH:mm:ssXXX"));
        }
        return info;
    }

    public Map<String,WeatherSunTimeInfo> getWeatherSunTimeMap(String cityId)
    {
        Calendar curTime = Calendar.getInstance();
        curTime.setTime(new Date());
        curTime.add(Calendar.DAY_OF_MONTH,-1);
        String key = cityId + DateUtil.format(curTime.getTime(),"yyyyMMdd");
        if(mapWeatherSunTime.containsKey(key) )
        {
            //清除数据
            mapWeatherSunTime.remove(key);
        }
        key = cityId + DateUtil.format(new Date(),"yyyyMMdd");
        Map<String,WeatherSunTimeInfo> map;
        if(mapWeatherSunTime.containsKey(key) )
        {
            map = mapWeatherSunTime.get(key);
            if(map!=null && map.size()>0) {
                return map;
            }
        }
        JSONObject resultObj=new JSONObject(true);
        map =new HashMap<String,WeatherSunTimeInfo>();
        try {
            Map<String, String> params = new HashMap<String, String>();
            params.put("cityId", cityId);
            String text = UtilHttp.get("http://weatherapi.market.xiaomi.com/wtr-v2/weather", params);
            JSONObject jsonObj = JSON.parseObject(text);
            //System.out.println(text);

            JSONObject realtimeObj = jsonObj.getJSONObject("realtime");
            resultObj.put("realtime", realtimeObj);
            JSONArray DailyForecasts = jsonObj.getJSONObject("accu_f5").getJSONArray("DailyForecasts");
            for(int i =0;i<DailyForecasts.size();i++)
            {
                JSONObject obj = DailyForecasts.getJSONObject(i);
                WeatherSunTimeInfo info = new WeatherSunTimeInfo();
                info.setSunRiseTime(DateUtil.parse(obj.getString("Sun_Rise"),"yyyy-MM-dd'T'HH:mm:ssX"));
                info.setSunSetTime(DateUtil.parse(obj.getString("Sun_Set"),"yyyy-MM-dd'T'HH:mm:ssXXX"));
                info.setWeatherDate(DateUtil.parse(obj.getString("Date"),"yyyy-MM-dd'T'HH:mm:ssXXX"));
                if(!map.containsKey(info.getWeatherDate()))
                {
                    map.put(DateUtil.format(info.getWeatherDate(),"yyyy-MM-dd"),info);
                }
            }
            mapWeatherSunTime.put(key,map);
        }
        catch (Exception ex)
        {
            logger.error("getWeatherSunTimeMap:",ex);
        }
        return map;
    }
}
