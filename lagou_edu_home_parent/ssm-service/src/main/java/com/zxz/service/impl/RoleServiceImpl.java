package com.zxz.service.impl;

import com.zxz.dao.RoleMapper;
import com.zxz.domain.Menu;
import com.zxz.domain.Role;
import com.zxz.domain.RoleMenuVo;
import com.zxz.domain.Role_menu_relation;
import com.zxz.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName RoleServiceImpl
 * @Description TODO
 * @Creat 2022-01-05  14:58:59
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findAllRole(Role role) {

        List<Role> roleList = roleMapper.findAllRole(role);

        return roleList;
    }

    @Override
    public List<Integer> findMenuByRoleId(Integer roleId) {

        List<Integer> menuidList = roleMapper.findMenuByRoleId(roleId);

        return menuidList;
    }

    @Override
    public void deleteRoleByRoleId(Integer roleId) {

        // 清空关联关系
        roleMapper.deleteRoleContextMenu(roleId);

        // 删除 角色
        roleMapper.deleteRoleByRoleId(roleId);

    }

    @Override
    public void roleContextMenu(RoleMenuVo roleMenuVo) {

        Integer roleId = roleMenuVo.getRoleId();
        // 删除关联关系
        roleMapper.deleteRoleContextMenu(roleId);

        // 添加新的关联关系
        List<Integer> menuIdList = roleMenuVo.getMenuIdList();

        for (Integer mid : menuIdList) {

            Role_menu_relation role_menu_relation = new Role_menu_relation();
            role_menu_relation.setRoleId(roleId);
            role_menu_relation.setMenuId(mid);
            role_menu_relation.setCreatedBy("system");
            role_menu_relation.setUpdatedby("system");
            Date date = new Date();
            role_menu_relation.setCreatedTime(date);
            role_menu_relation.setUpdatedTime(date);

            roleMapper.saveRoleContextMenu(role_menu_relation);
        }



    }

    @Override
    public List<Menu> findAllMenuById(Integer id) {

        List<Menu> menuList = roleMapper.findAllMenuById(id);

        return menuList;
    }
}
