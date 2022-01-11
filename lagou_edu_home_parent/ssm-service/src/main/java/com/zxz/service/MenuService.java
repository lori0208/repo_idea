package com.zxz.service;

import com.zxz.domain.Menu;

import java.util.List;

/**
 * @ClassName MenuService
 * @Description TODO
 * @Creat 2022-01-10  09:45:23
 */
public interface MenuService {

    // 查询所有菜单信息
    public List<Menu> findAllMenu();

    // 根据 id 查询菜单信息
    public Menu findMenuById(Integer id);
}
