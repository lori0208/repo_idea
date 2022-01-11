package com.zxz.controller;

import com.zxz.domain.ResourceCategory;
import com.zxz.domain.ResponseResult;
import com.zxz.service.ResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName ResourceCategoryController
 * @Description TODO
 * @Creat 2022-01-10  10:56:21
 */
@RestController
@RequestMapping("/ResourceCategory")
public class ResourceCategoryController {

    @Autowired
    private ResourceCategoryService resourceCategoryService;

    // 查询所有资源分类
    @RequestMapping("/findAllResourceCategory")
    public ResponseResult findAllResourceCategory(){

        List<ResourceCategory> resourceCategoryList = resourceCategoryService.findAllResourceCategory();

        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        responseResult.setState(200);
        responseResult.setMessage("请求成功");
        responseResult.setContent(resourceCategoryList);

        return responseResult;
    }


}
