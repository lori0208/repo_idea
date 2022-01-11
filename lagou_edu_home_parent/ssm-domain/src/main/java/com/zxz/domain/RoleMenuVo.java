package com.zxz.domain;

import java.util.List;

/**
 * @ClassName RoleMenuVo
 * @Description TODO
 * @Creat 2022-01-06  11:32:53
 */
public class RoleMenuVo {

    private Integer roleId;
    private List<Integer> menuIdList;

    @Override
    public String toString() {
        return "RoleMenuVo{" +
                "roleId=" + roleId +
                ", menuIdList=" + menuIdList +
                '}';
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public List getMenuIdList() {
        return menuIdList;
    }

    public void setMenuIdList(List menuIdList) {
        this.menuIdList = menuIdList;
    }
}
