package com.zxz.controller;

import com.github.pagehelper.PageInfo;
import com.zxz.domain.Resource;
import com.zxz.domain.ResourceVo;
import com.zxz.domain.ResponseResult;
import com.zxz.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ResourceController
 * @Description TODO
 * @Creat 2022-01-10  10:41:32
 */
@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    // 分页 多条件查询
    @RequestMapping("/findAllResource")
    public ResponseResult findAllResourceByPage(@RequestBody ResourceVo resourceVo){

        PageInfo<Resource> pageInfo = resourceService.findAllResourceByPage(resourceVo);

        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        responseResult.setState(200);
        responseResult.setMessage("请求成功");
        responseResult.setContent(pageInfo);

        return responseResult;
    }
}
