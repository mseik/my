package com.morelinks.service.micro.common.service.impl;


import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.core.util.StringUtil;
import com.morelinks.feign.micro.common.api.dto.CityDTO;
import com.morelinks.feign.micro.common.api.dto.TreeCityDTO;
import com.morelinks.feign.micro.common.api.model.WeatherCity;
import com.morelinks.service.micro.common.mapper.WeatherCityMapper;
import org.apache.commons.collections4.list.TransformedList;
import org.apache.commons.collections4.list.TreeList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class WeatherCityService extends BaseServiceWithQueryPage<WeatherCity,Integer, WeatherCityMapper> {
    private Logger logger = LoggerFactory.getLogger(WeatherCityService.class);
    public List<WeatherCity> getByCityName(String cityName) {
        return mapper.getByCityName(cityName);
    }

    private List<TreeCityDTO> treeCitys = null;

    public void getMapCityByCityId(String cityId,Map<Integer,WeatherCity> map )
    {
        if(map==null)
        {
            map = new HashMap<Integer,WeatherCity>();
        }
        if(StringUtil.isTrimBlank(cityId))
        {
            return;
        }
        WeatherCity query = new WeatherCity();
        query.setCityId(cityId);
        WeatherCity city = this.findTop1(query);
        if(city==null || city.getCityType()==null)
        {
            return;
        }
        if(map.containsKey(city.getCityType()))
        {
            return;
        }
        map.put(city.getCityType(),city);
        getMapCityByCityId(city.getParentCityId(),map);
    }

    /**
     * 获取树状结构所有城市
     * @return
     */
    public List<TreeCityDTO> getTreeCityListByCityId()
    {
        if(treeCitys!=null)
        {
            return treeCitys;
        }
        synchronized (this)
        {
            List<TreeCityDTO> lstTree = new ArrayList<TreeCityDTO>();
            WeatherCity query = new WeatherCity();
            query.setCityType(1);
            List<WeatherCity> lstCity = this.find(query,null);
            if(lstCity!=null)
            {
                for (WeatherCity city:lstCity
                        ) {
                    logger.error("初始化 省份："+city.getCityName());
                    TreeCityDTO dto = new TreeCityDTO();
                    dto.setCityName(city.getCityName());
                    dto.setCityId(city.getCityId());
                    dto.setCityType(city.getCityType());
                    dto.setChildren(getCitys(city.getCityId()));
                    lstTree.add(dto);
                }
            }
            if(lstTree.size()>0)
            {
                treeCitys =lstTree;
            }
        }
        return treeCitys;
    }

    private List<TreeCityDTO> getCitys(String cityId)
    {
        List<TreeCityDTO> lst = new  ArrayList<TreeCityDTO>();
        if(StringUtil.isTrimBlank(cityId))
        {
            return lst;
        }
        WeatherCity query = new WeatherCity();
        query.setParentCityId(cityId);
        List<WeatherCity> lstCity = this.find(query,null);
        if(lstCity!=null)
        {
            for (WeatherCity city:lstCity
                    ) {
                logger.error("初始化 城市："+city.getCityName()+" " + city.getCityType());
                TreeCityDTO dto = new TreeCityDTO();
                dto.setCityName(city.getCityName());
                dto.setCityId(city.getCityId());
                dto.setCityType(city.getCityType());
                dto.setChildren(new ArrayList<>());
                //区的话 直接返回 不需要再查找 已经是最后一级
                if(city.getCityType()<3)
                {
                    logger.error("获取下一级城市："+city.getCityName());
                    dto.setChildren(getCitys(city.getCityId()));
                }
                lst.add(dto);
            }
        }
        return lst;
    }
}