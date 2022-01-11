package com.zxz.service.impl;

import com.zxz.dao.TestMapper;
import com.zxz.domain.Test;
import com.zxz.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName TestServiceImpl
 * @Description TODO
 * @Creat 2021-12-30  10:54:54
 */

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public List<Test> findAll() {

        List<Test> testList = testMapper.findAll();

        return testList;
    }
}
