package com.zxz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxz.dao.UserMapper;
import com.zxz.domain.*;
import com.zxz.service.UserService;
import com.zxz.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Creat 2022-01-05  11:55:01
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo findAllUserByPage(UserVo userVo) {

        PageHelper.startPage(userVo.getCurrentPage(),userVo.getPageSize());

        List<User> userList = userMapper.findAllUserByPage(userVo);

        PageInfo<User> pageInfo = new PageInfo<>(userList);

        return pageInfo;
    }

    @Override
    public User login(User user) throws Exception {

        User user1 = userMapper.login(user);
        if (user1 != null && Md5.verify(user.getPassword(),"lagou",user1.getPassword())){

            return user1;
        } else {
            // 用户不存在 或 密码不正确
            return null;
        }
    }

    @Override
    public List<Role> findUserRoleById(Integer uid) {

        List<Role> roleList = userMapper.findUserRoleById(uid);

        return roleList;
    }

    @Override
    public Map<String, Object> getUserPermissions(Integer uid) {

        // 1，获取用户角色
        List<Role> roleList = userMapper.findUserRoleById(uid);
        // 2,获取角色id，保存到list 中
        ArrayList<Integer> rids = new ArrayList<>();
        for (Role role : roleList) {
            rids.add(role.getId());
        }
        // 3,根据角色id查询父级菜单
        List<Menu> menuList = userMapper.findParentMenuByRid(rids);
        // 4,查询父级菜单的子级菜单
        for (Menu menu : menuList) {
            List<Menu> subMenuList = userMapper.findSubMenuByPid(menu.getParentId());
            menu.setSubMenuList(subMenuList);
        }
        // 5,获取资源信息
        List<Resource> resourceList = userMapper.findResourceByRid(rids);

        // 6，封装信息
        Map<String, Object> map = new HashMap<>();
        map.put("menuList",menuList);
        map.put("resourceList",resourceList);

        return map;
    }

    @Override
    public void userContextRole(UserVo userVo) {

        // 删除 关联关系
        userMapper.deleteUserContextRole(userVo.getUserId());

        // 添加 关联关系
        List<Integer> roleIdList = userVo.getRoleIdList();
        for (Integer rid : roleIdList) {

            User_Role_relation relation = new User_Role_relation();
            relation.setUserId(userVo.getUserId());
            relation.setRoleId(rid);
            relation.setCreatedBy("system");
            relation.setUpdatedby("system");
            Date date = new Date();
            relation.setCreatedTime(date);
            relation.setUpdatedTime(date);

            userMapper.userContextRole(relation);
        }
    }

    @Override
    public void updateUserStatus(Integer id, String status) {

        User user = new User();
        user.setId(id);
        user.setStatus(status);
        user.setUpdate_time(new Date());

        userMapper.updateUserStatus(user);
    }
}
