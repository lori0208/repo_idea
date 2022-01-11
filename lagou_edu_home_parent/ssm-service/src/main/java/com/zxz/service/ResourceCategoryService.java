package com.zxz.service;

import com.zxz.domain.ResourceCategory;

import java.util.List;

/**
 * @ClassName ResourceCategoryService
 * @Description TODO
 * @Creat 2022-01-10  10:55:05
 */
public interface ResourceCategoryService {

    // 查询所有资源分类
    public List<ResourceCategory> findAllResourceCategory();
}
