package com.example.system.utils;

import com.example.system.dal.entity.MenuEntity;

import java.util.List;

public class GetMenuList {

    //获取某个节点下的菜单
    public void getTree(List<MenuEntity> menus, Long pid, List<MenuEntity> systemMenu) {
        for (MenuEntity menu : menus) {
            if (pid.equals(menu.getParentId())) {
                systemMenu.add(menu);
                getTree(menus, menu.getId(), systemMenu);
            }
        }
    }
}
