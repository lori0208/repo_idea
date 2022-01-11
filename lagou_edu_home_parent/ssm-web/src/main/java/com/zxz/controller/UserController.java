package com.zxz.controller;

import com.github.pagehelper.PageInfo;
import com.zxz.domain.ResponseResult;
import com.zxz.domain.Role;
import com.zxz.domain.User;
import com.zxz.domain.UserVo;
import com.zxz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName UserController
 * @Description TODO
 * @Creat 2022-01-05  11:56:42
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /*
       多条件分页查询
    */
    @RequestMapping("/findAllUserByPage")
    public ResponseResult findAllUserByPage(@RequestBody UserVo userVo){

        PageInfo pageInfo = userService.findAllUserByPage(userVo);

        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        responseResult.setState(200);
        responseResult.setMessage("请求成功");
        responseResult.setContent(pageInfo);

        return responseResult;
    }

    /*
        修改 用户 状态
     */
    @RequestMapping("/updateUserStatus")
    public ResponseResult updateUserStatus(Integer id, String status){

        userService.updateUserStatus(id,status);

        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        responseResult.setState(200);
        responseResult.setMessage("请求成功");
        responseResult.setContent(status);

        return responseResult;
    }

    // 登陆
    @RequestMapping("/login")
    public ResponseResult login(User user, HttpServletRequest request){

        try {
            User user1 = userService.login(user);

            if (user1 == null) {

                ResponseResult responseResult = new ResponseResult();
                responseResult.setSuccess(true);
                responseResult.setState(400);
                responseResult.setMessage("用户名或密码错误");
                responseResult.setContent(null);

                return responseResult;

            } else {

                HttpSession session = request.getSession();
                String access_token = UUID.randomUUID().toString();
                session.setAttribute("access_token",access_token);
                session.setAttribute("user_id",user1.getId());

                Map<String, Object> map = new HashMap<>();
                map.put("access_token",access_token);
                map.put("user_id",user1.getId());
                map.put("user",user1);

                ResponseResult responseResult = new ResponseResult();
                responseResult.setSuccess(true);
                responseResult.setState(1);
                responseResult.setMessage("登陆成功");
                responseResult.setContent(map);

                return responseResult;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    // 分配角色(回显) 根据 uid 查询用户关联的角色
    @RequestMapping("/findUserRoleById")
    public ResponseResult findUserRoleById(@RequestParam("id") Integer uid){

        List<Role> roleList = userService.findUserRoleById(uid);

        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        responseResult.setState(200);
        responseResult.setMessage("请求成功");
        responseResult.setContent(roleList);

        return responseResult;
    }

    // 分配角色
    @RequestMapping("/userContextRole")
    public ResponseResult userContextRole(@RequestBody UserVo userVo){

        userService.userContextRole(userVo);

        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        responseResult.setState(200);
        responseResult.setMessage("请求成功");
        responseResult.setContent(null);

        return responseResult;
    }

    // 获取用户权限信息
    @RequestMapping("/getUserPermissions")
    public ResponseResult getUserPermissions(HttpServletRequest request){
        // 1,获取请求头中的 token
        String header_token = request.getHeader("Authorization");
        // 2,获取session中的 token
        HttpSession session = request.getSession();
        String session_token = (String) session.getAttribute("access_token");

        // 3,判断 token 是否一致
        if (header_token.equals(session_token)){

            // session 中 获取 uid
            Integer userId = (Integer) session.getAttribute("user_id");

            // 调用 service 方法，获取 map 封装对象
            Map<String, Object> map = userService.getUserPermissions(userId);

            ResponseResult responseResult = new ResponseResult();
            responseResult.setSuccess(true);
            responseResult.setState(200);
            responseResult.setMessage("请求成功");
            responseResult.setContent(map);

            return responseResult;
        } else {
            ResponseResult responseResult = new ResponseResult();
            responseResult.setSuccess(false);
            responseResult.setState(400);
            responseResult.setMessage("请求失败");
            responseResult.setContent(null);

            return responseResult;
        }

    }
}
