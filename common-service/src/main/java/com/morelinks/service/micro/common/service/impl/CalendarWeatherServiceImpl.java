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
import com.morelinks.service.micro.common.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class CalendarWeatherServiceImpl implements WeatherService {
    private static Logger logger = LoggerFactory.getLogger(CalendarWeatherServiceImpl.class);
    private  String url ="http://zhwnlapi.etouch.cn/Ecalender/api/v2/weather";
    private Date lastDate = new Date();
    public ConcurrentHashMap<String,Map<String,WeatherSunTimeInfo>> mapWeatherSunTime = new ConcurrentHashMap<String,Map<String,WeatherSunTimeInfo>>();

    public XiaoMiCurrentWeatherDTO getWeather(String cityId)
    {
        XiaoMiCurrentWeatherDTO dto = new XiaoMiCurrentWeatherDTO();
        try {
            Map<String, String> params = new HashMap<String, String>();
            params.put("citykey", cityId);
            String text = UtilHttp.get(url, params);
            JSONObject jsonObj = JSON.parseObject(text);
            //System.out.println(text);

            JSONObject observeObj = jsonObj.getJSONObject("observe");
            XiaoMiRealTimeWeatherDTO realtime = new XiaoMiRealTimeWeatherDTO();
            realtime.setTemp(observeObj.getString("temp"));
            realtime.setSD(observeObj.getString("shidu"));
            realtime.setWD(observeObj.getString("wd"));
            realtime.setWeather(observeObj.getString("wthr"));
            realtime.setWS(observeObj.getString("wp"));

            JSONObject evnObj = jsonObj.getJSONObject("evn");
            realtime.setAqi(evnObj.getString("aqi"));
            realtime.setQuality(evnObj.getString("quality"));
            realtime.setPm25(evnObj.getString("pm25"));
            dto.setRealtime(realtime);
            JSONArray DailyForecasts0 = jsonObj.getJSONArray("forecast15");
            for (int i = 0; i < DailyForecasts0.size(); i++
                    ) {
                JSONObject obj = DailyForecasts0.getJSONObject(i);
                if (obj == null) {
                    continue;
                }
                Object date = obj.getString("date");
                if (date != null && date.toString().equalsIgnoreCase(DateUtil.format(new Date(), "yyyyMMdd"))) {
                    XiaoMiSunInfo sunTimeInfo = new XiaoMiSunInfo();
                    String sunRise = obj.getString("sunrise");
                    if (sunRise != null) {
                        String dateStr = DateUtil.format(new Date(), "yyyy-MM-dd ") + sunRise;
                        sunTimeInfo.setSun_EpochRise(DateUtil.parse(dateStr, "yyyy-MM-dd HH:mm").getTime() / 1000 + "");
                    }
                    String sunSet = obj.getString("sunset");
                    if (sunSet != null) {
                        String dateStr = DateUtil.format(new Date(), "yyyy-MM-dd ") + sunSet;
                        sunTimeInfo.setSun_EpochSet(DateUtil.parse(dateStr, "yyyy-MM-dd HH:mm").getTime() / 1000 + "");
                    }
                    dto.setSunInfo(sunTimeInfo);
                }
            }
        }
        catch (Exception e)
        {
            logger.error("getWeather",e);
        }

        return dto;
    }

    public WeatherSunRealTimeInfo getCurrentWeather(String cityId)
    {
        WeatherSunRealTimeInfo info = new WeatherSunRealTimeInfo();
        XiaoMiCurrentWeatherDTO dto = getWeather(cityId);
        if(dto==null)
        {
            return info;
        }
        if(dto.getRealtime()!=null)
        {
            info.setHumidity(dto.getRealtime().getSD());
            info.setCurWeather(dto.getRealtime().getWeather());
            info.setCurWindLevel(dto.getRealtime().getWS());
            info.setTemp(dto.getRealtime().getTemp());
            info.setPm25(dto.getRealtime().getPm25());
            info.setQuality(dto.getRealtime().getQuality());
            info.setAqi(dto.getRealtime().getAqi());
            info.setWindDirection(dto.getRealtime().getWD());
            info.setWindSpeed(dto.getRealtime().getWS());
        }
        if(dto.getSunInfo()!=null) {
            Integer sunRise = IntUtil.parseInt(dto.getSunInfo().getSun_EpochRise(),false);
            if(IntUtil.isGreaterThanZero(sunRise)) {
                info.setSunRiseTime(new Date(sunRise*1000L));
            }
            Integer sunSet = IntUtil.parseInt(dto.getSunInfo().getSun_EpochSet(),false);
            if(IntUtil.isGreaterThanZero(sunSet)) {
                info.setSunSetTime(new Date(sunSet*1000L));
            }
        }
        return info;
    }

    public Map<String,WeatherSunTimeInfo> getWeatherSunTimeMap(String cityId)
    {
        Calendar curCal = Calendar.getInstance();
        curCal.setTime(new Date());
        curCal.add(Calendar.DAY_OF_MONTH,-1);
        if(lastDate.before(curCal.getTime()))
        {
            lastDate = new Date();
            mapWeatherSunTime.clear();
        }
        Map<String,WeatherSunTimeInfo> map;
        if(mapWeatherSunTime.containsKey(cityId) )
        {
            map = mapWeatherSunTime.get(cityId);
            if(map!=null && map.containsKey(DateUtil.format(new Date(),"yyyy-MM-dd"))) {
                return map;
            }
            mapWeatherSunTime.remove(cityId);
        }
        JSONObject resultObj=new JSONObject(true);
        map =new HashMap<String,WeatherSunTimeInfo>();
        try {
            Map<String, String> params = new HashMap<String, String>();
            params.put("citykey", cityId);
            String text = UtilHttp.get(url, params);
            JSONObject jsonObj = JSON.parseObject(text);
            //System.out.println(text);
            JSONArray DailyForecasts = jsonObj.getJSONArray("forecast15");
            for(int i =0;i<DailyForecasts.size();i++)
            {
                JSONObject obj = DailyForecasts.getJSONObject(i);
                if(obj==null)
                {
                    continue;
                }
                Object date = obj.getString("date");
                if(date!=null)
                {
                    WeatherSunTimeInfo info = new WeatherSunTimeInfo();
                    String sunRise = obj.getString("sunrise");
                    if(sunRise!=null)
                    {
                        String dateStr = DateUtil.format(new Date(),"yyyy-MM-dd ")+sunRise;
                        info.setSunRiseTime(DateUtil.parse(dateStr,"yyyy-MM-dd HH:mm"));
                    }
                    String sunSet = obj.getString("sunset");
                    if(sunSet!=null)
                    {
                        String dateStr = DateUtil.format(new Date(),"yyyy-MM-dd ")+sunSet;
                        info.setSunSetTime(DateUtil.parse(dateStr,"yyyy-MM-dd HH:mm"));
                    }
                    info.setWeatherDate(DateUtil.parse(date.toString(),"yyyyMMdd"));
                    map.put(DateUtil.format(info.getWeatherDate(),"yyyy-MM-dd "),info);

                }

            }
            mapWeatherSunTime.put(cityId,map);
        }
        catch (Exception ex)
        {
            logger.error("getWeatherSunTimeMap:",ex);
        }
        return map;
    }
}
