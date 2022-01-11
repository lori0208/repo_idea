package com.zxz.controller;

import com.zxz.domain.Menu;
import com.zxz.domain.ResponseResult;
import com.zxz.domain.Role;
import com.zxz.domain.RoleMenuVo;
import com.zxz.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName RoleController
 * @Description TODO
 * @Creat 2022-01-05  14:59:59
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    // 查询所有角色（根据条件）
    @RequestMapping("/findAllRole")
    public ResponseResult findAllRole(@RequestBody Role role){

        List<Role> roleList = roleService.findAllRole(role);

        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        responseResult.setState(200);
        responseResult.setMessage("请求成功");
        responseResult.setContent(roleList);

        return responseResult;
    }

    // 查询所有菜单信息（父子级）
    @RequestMapping("/findAllMenu")
    public ResponseResult findAllMenuById(){

        // parent_id = -1 ，表示 查询父级元素
        List<Menu> menuList = roleService.findAllMenuById(-1);

        Map<String, Object> map = new HashMap<>();
        map.put("parentMenuList",menuList);

        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        responseResult.setState(200);
        responseResult.setMessage("请求成功");
        responseResult.setContent(map);

        return responseResult;
    }

    // 根据角色 id 查询关联的 菜单 id
    @RequestMapping("/findMenuByRoleId")
    public ResponseResult findMenuByRoleId(Integer roleId){

        List<Integer> list = roleService.findMenuByRoleId(roleId);

        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        responseResult.setState(200);
        responseResult.setMessage("请求成功");
        responseResult.setContent(list);

        return responseResult;
    }

    // 为角色分配菜单
    @RequestMapping("/RoleContextMenu")
    public ResponseResult roleContextMenu(@RequestBody RoleMenuVo roleMenuVo){

        roleService.roleContextMenu(roleMenuVo);

        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        responseResult.setState(200);
        responseResult.setMessage("请求成功");
        responseResult.setContent(null);

        return responseResult;
    }

    // 删除角色
    @RequestMapping("/deleteRole")
    public ResponseResult deleteRoleByRoleId(Integer id){

        roleService.deleteRoleByRoleId(id);

        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        responseResult.setState(200);
        responseResult.setMessage("请求成功");
        responseResult.setContent(null);

        return responseResult;
    }

}
