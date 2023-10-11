package com.example.system.dal.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.framework.common.PageList;
import com.example.system.dal.dto.menu.MenuQueryDTO;
import com.example.system.dal.entity.MenuEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper extends BaseMapper<MenuEntity> {
    //分页
    default PageList<MenuEntity> selectPage(MenuQueryDTO menu) {
        IPage<MenuEntity> pageParams = new Page<>(menu.getPage(), menu.getSize());
        QueryWrapper<MenuEntity> wrapper = new QueryWrapper<>();

        if (menu.getTitle() != null) {
            wrapper.eq("title", menu.getTitle());
        }

        if (menu.getType() != null) {
            wrapper.eq("type", menu.getType());
        }

        if (menu.getStatus() != null) {
            wrapper.eq("status", menu.getStatus());
        }

        wrapper.orderByDesc("create_time");

        return PageList.setPages(selectPage(pageParams, wrapper));
    }

    //列表查询
    default List<MenuEntity> selectList(MenuQueryDTO menu) {
        QueryWrapper<MenuEntity> wrapper = new QueryWrapper<>();

        if (menu.getTitle() != null) {
            wrapper.eq("title", menu.getTitle());
        }

        if (menu.getType() != null) {
            wrapper.eq("type", menu.getType());
        }

        if (menu.getStatus() != null) {
            wrapper.eq("status", menu.getStatus());
        }

        wrapper.orderByDesc("create_time");

        return selectList(wrapper);
    }

    @Delete(" DELETE FROM role_menu WHERE menu_id= #{menuId}")
    void deleteRoleMenu(Long menuId);
}
