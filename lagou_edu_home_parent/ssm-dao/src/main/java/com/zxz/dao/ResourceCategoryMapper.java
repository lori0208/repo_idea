package com.zxz.dao;

import com.zxz.domain.ResourceCategory;

import java.util.List;

/**
 * @ClassName ResourceCategoryMapper
 * @Description TODO
 * @Creat 2022-01-10  10:48:39
 */
public interface ResourceCategoryMapper {

    // 查询所有资源分类
    public List<ResourceCategory> findAllResourceCategory();
}
