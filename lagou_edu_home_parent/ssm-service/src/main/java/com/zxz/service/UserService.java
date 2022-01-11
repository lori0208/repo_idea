package com.zxz.service;

import com.github.pagehelper.PageInfo;
import com.zxz.domain.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName UserService
 * @Description TODO
 * @Creat 2022-01-05  11:54:28
 */
public interface UserService {

    /*
       多条件分页查询
    */
    public PageInfo findAllUserByPage(UserVo userVo);


    /*
        修改 用户 状态
     */
    public void updateUserStatus(Integer id, String status);

    // 登陆
    public  User login(User user) throws Exception;



    // 分配角色
    public void userContextRole(UserVo userVo);

    // 1，分配角色(回显) 根据 uid 查询用户关联的角色
    public List<Role> findUserRoleById(Integer uid);

    // 获取用户权限信息
    public Map<String,Object> getUserPermissions(Integer uid);



}
