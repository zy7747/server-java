package com.example.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.framework.utils.Excel;
import com.example.system.convert.RoleConvert;
import com.example.system.dal.dto.role.RoleQueryDTO;
import com.example.system.dal.dto.role.RoleSaveDTO;
import com.example.system.dal.entity.RoleEntity;
import com.example.system.mapper.RoleMapper;
import com.example.system.dal.vo.role.RoleDetailVO;
import com.example.system.dal.vo.role.RoleExportVO;
import com.example.system.dal.vo.role.RoleListVO;
import com.example.system.dal.vo.role.RolePageVO;
import com.example.system.service.role.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@CrossOrigin
@Validated
@Api(tags = "角色接口")
@RequestMapping("/role")
public class RoleController {
    @Resource
    RoleService roleService;
    @Resource
    RoleMapper roleMapper;

    @GetMapping("/page")
    @ApiOperation(value = "分页")
    public Result<PageList<RolePageVO>> rolePage(@Valid RoleQueryDTO role) {
        return roleService.pageService(role);
    }

    @GetMapping("/list")
    @ApiOperation(value = "列表")
    public Result<List<RoleListVO>> roleList(@Valid RoleQueryDTO role) {
        return roleService.listService(role);
    }

    @GetMapping("/detail")
    @ApiOperation(value = "详情")
    public Result<RoleDetailVO> roleDetail(Long id) {
        return roleService.detailService(id);
    }

    @PostMapping("/saveList")
    @ApiOperation(value = "批量新增/修改")
    public Result<List<RoleEntity>> roleSaveList(@RequestBody @Valid List<RoleSaveDTO> roles) {
        return roleService.saveListService(roles);
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除")
    public Result<Object> roleDelete(@RequestBody List<RoleQueryDTO> ids) {
        ids.forEach(item -> {
            roleMapper.deleteRoleMenu(item.getId());
            roleMapper.deleteUserRole(item.getId());
            roleMapper.deleteById(item.getId());
        });
        return Result.success("删除成功");
    }

    @PostMapping("/import")
    @ApiOperation(value = "导入")
    public Result<List<RoleEntity>> roleImport(@RequestParam("file") MultipartFile multipartFile) throws Exception {
        List<RoleSaveDTO> roleList = RoleConvert.INSTANCE.imports(Excel.imports(multipartFile.getInputStream(), RoleExportVO.class));
        return roleService.saveListService(roleList);
    }

    @GetMapping("/export")
    @ApiOperation(value = "导出")
    public void roleExport(HttpServletResponse response) throws IOException {
        Excel.export(response, "角色.xlsx", "角色", RoleExportVO.class, RoleConvert.INSTANCE.export(roleMapper.selectList(new QueryWrapper<>())));
    }
}