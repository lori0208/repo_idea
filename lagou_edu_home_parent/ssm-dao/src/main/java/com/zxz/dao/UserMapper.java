package com.zxz.dao;

import com.zxz.domain.*;

import java.util.List;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Creat 2022-01-05  11:36:13
 */
public interface UserMapper {

    /*
        多条件分页查询
     */
    public List<User> findAllUserByPage(UserVo userVo);

    /*
        修改 用户 状态
     */
    public void updateUserStatus(User user);

    // 登陆
    public  User login(User user);

    // 删除 用户关联的角色
    public void deleteUserContextRole(Integer uid);

    // 添加 用户关联的角色
    public void userContextRole(User_Role_relation user_role_relation);

    // 1，分配角色(回显) 根据 uid 查询用户关联的角色
    public List<Role> findUserRoleById(Integer uid);

    // 2，根据角色id 查询角色所拥有的顶级菜单
    public List<Menu> findParentMenuByRid(List<Integer> ids);

    // 3，根据pid 查询子菜单信息
    public List<Menu> findSubMenuByPid(Integer pid);

    // 4，获取用户拥有的资源权限信息
    public List<Resource> findResourceByRid(List<Integer> ids);
}
