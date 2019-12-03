package com.morelinks.service.micro.product.service;

import com.morelinks.core.dto.QueryPageParam;
import com.morelinks.core.exception.BusinessException;
import com.morelinks.core.model.Page;
import com.morelinks.core.service.BaseServiceWithQueryPage;
import com.morelinks.feign.micro.product.api.dto.ConfigCategoryMenuDTO;
import com.morelinks.feign.micro.product.api.model.ConfigCategory;
import com.morelinks.feign.micro.product.api.model.dto.QueryParentAggregate;
import com.morelinks.service.micro.product.mapper.ConfigCategoryMapper;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class ConfigCategoryService extends BaseServiceWithQueryPage<ConfigCategory, Integer, ConfigCategoryMapper> {


    public List<ConfigCategoryMenuDTO> getTreeQueryT(List<Integer> treeRoot, List<Integer> countId) {
        List<ConfigCategoryMenuDTO> list = new ArrayList<>();
        for (Integer I : treeRoot) {
            ConfigCategory Category = new ConfigCategory();
            Category.setId(I);
            ConfigCategory category = this.findTop1(Category);
            if (category == null) {
                throw new BusinessException("未知分类信息");

            }
            countId.add(I);
            ConfigCategoryMenuDTO dto = new ConfigCategoryMenuDTO();
            dto.setId(category.getId());
            dto.setName(category.getCategoryName());
            dto.setIcon(category.getIcon());
            dto.setChildren(this.treeQueryT(I, countId));

            list.add(dto);
        }

        return list;
    }

    public List<ConfigCategoryMenuDTO> treeQueryT(Integer category, List<Integer> countId) {
        ConfigCategory configCategory = new ConfigCategory();
        configCategory.setParentId(category);
        List<ConfigCategory> list = this.queryPageResult(configCategory, null);
        if (list == null && list.size() <= 0) {
            return new ArrayList<>();

        }
        List<ConfigCategoryMenuDTO> listDTO = new ArrayList<>();
        for (ConfigCategory configCategory1 : list) {
            ConfigCategoryMenuDTO dto = new ConfigCategoryMenuDTO();
            countId.add(configCategory1.getId());
            dto.setId(configCategory1.getId());
            dto.setName(configCategory1.getCategoryName());
            dto.setIcon(configCategory1.getIcon());
            dto.setChildren(treeQueryT(configCategory1.getId(), countId));
            listDTO.add(dto);

        }
        return listDTO;
    }

    public List<Integer> parentAggregate(QueryParentAggregate query) {

        this.getTreeQueryT(query.getTreeRoot(), query.getCountId());

        return query.getCountId();
    }

    /**
     *  赋值所有的类别Id 查询的类别Id和子类别Id列表
     * @param lstCategoryId 需要遍历的类别Id
     * @return
     */
    public List<Integer> findAllCateogyrIds(List<Integer> lstCategoryId) {

        List<Integer> lstAll = new ArrayList<>();
        for (Integer categoryId:lstCategoryId
             ) {
            lstAll.add(categoryId);
            ConfigCategory configCategory = new ConfigCategory();
            configCategory.setParentId(categoryId);
            List<ConfigCategory> lstSubCategory = this.queryPageResult(configCategory, null);
            if (lstSubCategory == null && lstSubCategory.size() <= 0) {
                continue;
            }
            for (ConfigCategory category:lstSubCategory
                 ) {
                List<Integer> lstQuery = new ArrayList<>();
                lstQuery.add(category.getId());
                List<Integer> lstSub = findAllCateogyrIds(lstQuery);
                if(lstSub!=null && lstSub.size()>0)
                {
                    lstAll.addAll(lstSub);
                }
            }
        }
        return lstAll;
    }

    public List<ConfigCategoryMenuDTO> getTreeQuery(List<Integer> treeRoot) {
        List<ConfigCategoryMenuDTO> list = new ArrayList<>();
        for (Integer I : treeRoot) {
            ConfigCategory Category = new ConfigCategory();
            Category.setId(I);
            ConfigCategory category = this.findTop1(Category);
            if (category == null) {
                throw new BusinessException("未知分类信息");

            }

            ConfigCategoryMenuDTO dto = new ConfigCategoryMenuDTO();
            dto.setId(category.getId());
            dto.setName(category.getCategoryName());
            dto.setIcon(category.getIcon());
            dto.setChildren(this.treeQuery(I));

            list.add(dto);
        }

        return list;
    }

    public List<ConfigCategoryMenuDTO> treeQuery(Integer category) {
        ConfigCategory configCategory = new ConfigCategory();
        configCategory.setParentId(category);
        List<ConfigCategory> list = this.queryPageResult(configCategory, null);
        if (list == null && list.size() <= 0) {
            return new ArrayList<>();

        }
        List<ConfigCategoryMenuDTO> listDTO = new ArrayList<>();
        for (ConfigCategory configCategory1 : list) {
            ConfigCategoryMenuDTO dto = new ConfigCategoryMenuDTO();
            dto.setId(configCategory1.getId());
            dto.setName(configCategory1.getCategoryName());
            dto.setIcon(configCategory1.getIcon());
            dto.setChildren(treeQuery(configCategory1.getId()));
            listDTO.add(dto);

        }


        return listDTO;
    }

    public ConfigCategory CategoryTopFloor(Integer id) {
        if (id == null || "".equals(id.toString().trim())) {

            throw new BusinessException("引用对象为空");
        }
        ConfigCategory configCategory = this.getByPrimaryKey(id);
        if (configCategory == null) {

            throw new BusinessException("未知分类商品");
        }
        if (configCategory.getParentId() <= 0) {
            return configCategory;
        }
        return CategoryTopFloor(configCategory.getParentId());
    }
}