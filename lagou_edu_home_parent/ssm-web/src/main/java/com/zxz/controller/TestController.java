package com.zxz.controller;

import com.zxz.domain.Test;
import com.zxz.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName TestController
 * @Description TODO
 * @Creat 2021-12-30  11:13:46
 */
@RestController // @Controller + @ResponseBody
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/findAllTest")
    public List<Test> findAllTest(){

        List<Test> testList = testService.findAll();
        return testList;
    }
}
