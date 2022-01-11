package com.zxz.controller;

import com.zxz.dao.RoleMapper;
import com.zxz.domain.Menu;
import com.zxz.domain.ResponseResult;
import com.zxz.service.CourseService;
import com.zxz.service.MenuService;
import com.zxz.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName MenuController
 * @Description TODO
 * @Creat 2022-01-10  09:46:49
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAllMenu")
    public ResponseResult findAllMenu(){

        List<Menu> menuList = menuService.findAllMenu();

        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        responseResult.setState(200);
        responseResult.setMessage("请求成功");
        responseResult.setContent(menuList);

        return responseResult;
    }

    // menu 信息回显
    @RequestMapping("/findMenuInfoById")
    public ResponseResult findMenuInfoById(Integer id){

        if (id == -1){
            // 添加操作
            List<Menu> menuList = roleService.findAllMenuById(id);

            Map<String, Object> map = new HashMap<>();

            map.put("menuInfo",null);
            map.put("parentMenuList",menuList);

            ResponseResult responseResult = new ResponseResult();
            responseResult.setSuccess(true);
            responseResult.setState(200);
            responseResult.setMessage("请求成功");
            responseResult.setContent(map);

            return responseResult;

        } else {
            // 修改操作
            Menu menu = menuService.findMenuById(id);

            List<Menu> menuList = roleService.findAllMenuById(id);

            Map<String, Object> map = new HashMap<>();

            map.put("menuInfo",menu);
            map.put("parentMenuList",menuList);

            ResponseResult responseResult = new ResponseResult();
            responseResult.setSuccess(true);
            responseResult.setState(200);
            responseResult.setMessage("请求成功");
            responseResult.setContent(map);

            return responseResult;

        }
    }

}
