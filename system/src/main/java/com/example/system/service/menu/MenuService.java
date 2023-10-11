package com.example.system.service.menu;

import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.system.dal.dto.menu.MenuQueryDTO;
import com.example.system.dal.dto.menu.MenuSaveDTO;
import com.example.system.dal.entity.MenuEntity;
import com.example.system.dal.vo.menu.MenuDetailVO;
import com.example.system.dal.vo.menu.MenuListVO;
import com.example.system.dal.vo.menu.MenuPageVO;

import java.util.List;

public interface MenuService {
    /**
     * 获取列表分页
     *
     * @param menu 分页入参
     * @return 列表分页
     */
    Result<PageList<MenuPageVO>> pageService(MenuQueryDTO menu);

    /**
     * 获取列表
     *
     * @param menu 入参
     * @return 列表
     */
    Result<List<MenuListVO>> listService(MenuQueryDTO menu);

    /**
     * 获取详情
     *
     * @param id 入参
     * @return 详情
     */
    Result<MenuDetailVO> detailService(Long id);

    /**
     * 批量新增/修改
     *
     * @param menuList 新增/修改内容
     * @return 新增/修改后数据
     */
    Result<List<MenuEntity>> saveListService(List<MenuSaveDTO> menuList);
}
