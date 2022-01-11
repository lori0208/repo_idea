package com.zxz.service.impl;

import com.zxz.dao.ResourceCategoryMapper;
import com.zxz.domain.ResourceCategory;
import com.zxz.service.ResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ResourceCategoryServiceImpl
 * @Description TODO
 * @Creat 2022-01-10  10:55:23
 */
@Service
public class ResourceCategoryServiceImpl implements ResourceCategoryService {

    @Autowired
    private ResourceCategoryMapper resourceCategoryMapper;

    @Override
    public List<ResourceCategory> findAllResourceCategory() {

        List<ResourceCategory> resourceCategoryList = resourceCategoryMapper.findAllResourceCategory();
        return resourceCategoryList;
    }
}
