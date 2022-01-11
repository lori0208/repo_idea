package com.zxz.service;

import com.zxz.domain.Test;

import java.util.List;

/**
 * @ClassName TestService
 * @Description TODO
 * @Creat 2021-12-30  10:54:28
 */
public interface TestService {

    /*
        查找所有 test
     */

    public List<Test> findAll();
}
