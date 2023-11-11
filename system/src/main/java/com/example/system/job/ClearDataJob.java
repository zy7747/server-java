package com.example.system.job;

import com.example.system.dal.mapper.*;
import com.example.system.utils.SpringUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClearDataJob {

    MenuMapper menuMapper = SpringUtils.getBean(MenuMapper.class);
    RoleMapper roleMapper = SpringUtils.getBean(RoleMapper.class);
    UserMapper userMapper = SpringUtils.getBean(UserMapper.class);
    DictMapper dictMapper = SpringUtils.getBean(DictMapper.class);
    FileMapper fileMapper = SpringUtils.getBean(FileMapper.class);

    public void clearRole() {
        roleMapper.clearRole();
    }

    public void clearMenu() {
        menuMapper.clearMenu();
    }

    public void clearUser() {
        userMapper.clearUser();
    }

    public void clearDict() {
        dictMapper.clearDict();
    }

    public void clearFile() {
        fileMapper.clearFile();
    }

}
