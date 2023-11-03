package com.example.system.dal.mapper;

import cn.hutool.core.util.StrUtil;
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
    default QueryWrapper<MenuEntity> search(MenuQueryDTO menu) {
        QueryWrapper<MenuEntity> wrapper = new QueryWrapper<>();
        /* 菜单名 */
        if (!StrUtil.hasBlank(menu.getTitle())) {
            wrapper.eq("title", menu.getTitle());
        }
        /* 类型 */
        if (!StrUtil.hasBlank(menu.getType())) {
            wrapper.eq("type", menu.getType());
        }
        /* 状态 */
        if (!StrUtil.hasBlank(menu.getStatus())) {
            wrapper.eq("status", menu.getStatus());
        }
        wrapper.orderByDesc("create_time");
        return wrapper;
    }

    //分页
    default PageList<MenuEntity> selectPage(MenuQueryDTO menu) {
        IPage<MenuEntity> pageParams = new Page<>(menu.getPage(), menu.getSize());
        return PageList.setPages(selectPage(pageParams, search(menu)));
    }

    //列表查询
    default List<MenuEntity> selectList(MenuQueryDTO menu) {
        return selectList(search(menu));
    }

    @Delete("DELETE FROM role_menu WHERE menu_id = #{menuId}")
    void deleteRoleMenu(Long menuId);

    @Delete("DELETE FROM menu WHERE is_deleted = 1")
    void clearMenu();
}
