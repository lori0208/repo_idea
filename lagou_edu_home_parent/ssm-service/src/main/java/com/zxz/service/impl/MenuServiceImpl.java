package com.zxz.service.impl;

import com.zxz.dao.MenuMapper;
import com.zxz.domain.Menu;
import com.zxz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName MenuServiceImpl
 * @Description TODO
 * @Creat 2022-01-10  09:45:48
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> findAllMenu() {

        List<Menu> menuList = menuMapper.findAllMenu();

        return menuList;
    }

    @Override
    public Menu findMenuById(Integer id) {

        Menu menu = menuMapper.findMenuById(id);

        return menu;
    }
}
