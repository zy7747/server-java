package com.example.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.framework.utils.ExcelUtils;
import com.example.system.annotation.Log;
import com.example.system.convert.MenuConvert;
import com.example.system.dal.dto.menu.MenuQueryDTO;
import com.example.system.dal.dto.menu.MenuSaveDTO;
import com.example.system.dal.entity.MenuEntity;
import com.example.system.enums.OperateType;
import com.example.system.mapper.MenuMapper;
import com.example.system.dal.vo.menu.MenuDetailVO;
import com.example.system.dal.vo.menu.MenuExportVO;
import com.example.system.dal.vo.menu.MenuListVO;
import com.example.system.dal.vo.menu.MenuPageVO;
import com.example.system.service.menu.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@CrossOrigin
@Validated
@Api(tags = "菜单接口")
@RequestMapping("/menu")
public class MenuController {
    @Resource
    MenuService menuService;

    @Resource
    MenuMapper menuMapper;

    @GetMapping("/page")
    @ApiOperation(value = "分页")
    public Result<PageList<MenuPageVO>> menuPage(@Valid MenuQueryDTO menu) {
        return menuService.pageService(menu);
    }

    @GetMapping("/list")
    @ApiOperation(value = "列表")
    public Result<List<MenuListVO>> menuList(@Valid MenuQueryDTO menu) {
        return menuService.listService(menu);
    }

    @GetMapping("/detail")
    @ApiOperation(value = "详情")
    public Result<MenuDetailVO> menuDetail(Long id) {
        return menuService.detailService(id);
    }

    @PostMapping("/saveList")
    @ApiOperation(value = "批量新增/修改")
    @Log(title = "菜单新增/修改", module = "配置中心", content = "菜单新增/修改", type = OperateType.INSERT)
    public Result<List<MenuEntity>> menuSaveList(@RequestBody @Valid List<MenuSaveDTO> menus) {
        return menuService.saveListService(menus);
    }

    @Transactional
    @DeleteMapping("/delete")
    @ApiOperation(value = "删除")
    @PreAuthorize("hasAuthority('system:menu:delete')")
    @Log(title = "菜单删除", module = "配置中心", content = "菜单删除", type = OperateType.DELETE)
    public Result<Object> menuDelete(@RequestBody List<MenuQueryDTO> ids) {
        try {
            ids.forEach(item -> {
                menuMapper.deleteById(item.getId());
                menuMapper.deleteRoleMenu(item.getId());
            });
            return Result.success("删除成功");
        } catch (Exception e) {
            return Result.error(e);
        }
    }

    @GetMapping("/export")
    @ApiOperation(value = "导出")
    public void menuExport(HttpServletResponse response) throws IOException {
        ExcelUtils.export(response, "菜单.xlsx", "菜单", MenuExportVO.class, MenuConvert.INSTANCE.export(menuMapper.selectList(new QueryWrapper<>())));
    }
}
