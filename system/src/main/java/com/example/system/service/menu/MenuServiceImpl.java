package com.example.system.service.menu;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.system.convert.MenuConvert;
import com.example.system.dal.dto.menu.MenuQueryDTO;
import com.example.system.dal.dto.menu.MenuSaveDTO;
import com.example.system.dal.entity.MenuEntity;
import com.example.system.mapper.MenuMapper;
import com.example.system.dal.vo.menu.MenuDetailVO;
import com.example.system.dal.vo.menu.MenuListVO;
import com.example.system.dal.vo.menu.MenuPageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, MenuEntity> implements MenuService {
    @Resource
    MenuMapper menuMapper;

    /**
     * 获取列表分页
     *
     * @param menu 分页入参
     * @return 列表分页
     */
    @Override
    public Result<PageList<MenuPageVO>> pageService(MenuQueryDTO menu) {
        return Result.success(MenuConvert.INSTANCE.page(menuMapper.selectPage(menu)));
    }

    /**
     * 获取列表
     *
     * @param menu 查询参数
     * @return 列表
     */
    @Override
    public Result<List<MenuListVO>> listService(MenuQueryDTO menu) {
        return Result.success(MenuConvert.INSTANCE.list(menuMapper.selectList(menu)));
    }

    /**
     * 获取详情
     *
     * @param id 入参
     * @return 详情
     */
    @Override
    public Result<MenuDetailVO> detailService(Long id) {
        return Result.success(MenuConvert.INSTANCE.detail(menuMapper.selectById(id)));
    }

    /**
     * 批量新增/修改
     *
     * @param menu 新增/修改内容
     * @return 新增/修改后数据
     */
    @Override
    public Result<List<MenuEntity>> saveListService(List<MenuSaveDTO> menu) {
        List<MenuEntity> menuList = MenuConvert.INSTANCE.saveList(menu);
        this.saveOrUpdateBatch(menuList);
        return Result.success(menuList);
    }
}
