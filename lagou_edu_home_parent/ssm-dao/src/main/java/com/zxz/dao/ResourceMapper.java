package com.zxz.dao;

import com.zxz.domain.Resource;
import com.zxz.domain.ResourceVo;

import java.util.List;

/**
 * @ClassName ResourceMapper
 * @Description TODO
 * @Creat 2022-01-10  10:20:47
 */
public interface ResourceMapper {

    // 分页 多条件查询
    public List<Resource> findAllResourceByPage(ResourceVo resourceVo);
}
