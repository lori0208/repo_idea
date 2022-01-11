package com.zxz.dao;

import com.zxz.domain.Menu;
import com.zxz.domain.Role;
import com.zxz.domain.Role_menu_relation;

import java.util.List;

/**
 * @ClassName RoleMapper
 * @Description TODO
 * @Creat 2022-01-05  14:55:37
 */
public interface RoleMapper {

    // 查询所有角色（根据条件）
    public List<Role> findAllRole(Role role);

    // 查询所有菜单信息（父子级）
    public List<Menu> findAllMenuById(Integer id);

    // 根据角色 id 查询关联的 菜单 id
    public List<Integer> findMenuByRoleId(Integer roleId);

    // 根据 角色 id 删除 角色菜单表中的 关联关系
    public void deleteRoleContextMenu(Integer roleId);

    // 角色菜单表中 添加 角色 和菜单的 关联关系
    public void saveRoleContextMenu(Role_menu_relation role_menu_relation);

    // 删除角色
    public void deleteRoleByRoleId(Integer roleId);

}
