package com.zxz.service;

import com.github.pagehelper.PageInfo;
import com.zxz.domain.Resource;
import com.zxz.domain.ResourceVo;

import java.util.List;

/**
 * @ClassName ResourceService
 * @Description TODO
 * @Creat 2022-01-10  10:38:53
 */
public interface ResourceService {

    // 分页 多条件查询
    public PageInfo<Resource> findAllResourceByPage(ResourceVo resourceVo);
}
