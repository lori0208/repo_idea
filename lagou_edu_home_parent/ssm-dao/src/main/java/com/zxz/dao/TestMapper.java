package com.zxz.dao;

import com.zxz.domain.Test;

import java.util.List;

/**
 * @ClassName TestMapper
 * @Description TODO
 * @Creat 2021-12-30  10:06:09
 */
public interface TestMapper {

    /*
        查找所有 test
     */

    public List<Test> findAll();
}
