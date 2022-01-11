package com.zxz.service;

import com.zxz.domain.Menu;
import com.zxz.domain.Role;
import com.zxz.domain.RoleMenuVo;

import java.util.List;

/**
 * @ClassName RoleService
 * @Description TODO
 * @Creat 2022-01-05  14:58:42
 */
public interface RoleService {

    // 查询所有角色（根据条件）
    public List<Role> findAllRole(Role role);

    // 查询所有菜单信息（父子级）
    public List<Menu> findAllMenuById(Integer id);

    // 根据角色 id 查询关联的 菜单 id
    public List<Integer> findMenuByRoleId(Integer roleId);

    // 为角色分配菜单
    public void roleContextMenu(RoleMenuVo roleMenuVo);

    // 删除角色
    public void deleteRoleByRoleId(Integer roleId);
}
