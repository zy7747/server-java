package com.example.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.framework.utils.ExcelUtils;
import com.example.system.convert.PermissionConvert;
import com.example.system.dal.dto.permission.PermissionQueryDTO;
import com.example.system.dal.dto.permission.PermissionSaveDTO;
import com.example.system.dal.entity.PermissionEntity;
import com.example.system.mapper.PermissionMapper;
import com.example.system.dal.vo.permission.PermissionDetailVO;
import com.example.system.dal.vo.permission.PermissionExportVO;
import com.example.system.dal.vo.permission.PermissionListVO;
import com.example.system.dal.vo.permission.PermissionPageVO;
import com.example.system.service.permission.PermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Slf4j
@Validated
@CrossOrigin
@RestController
@Api(tags = "权限接口")
@RequestMapping("/permission")
public class PermissionController {
    @Resource
    PermissionService permissionService;
    @Resource
    PermissionMapper permissionMapper;

    @GetMapping("/page")
    @ApiOperation(value = "分页")
    public Result<PageList<PermissionPageVO>> permissionPage(@Valid PermissionQueryDTO permission) {
        return permissionService.permissionPageService(permission);
    }

    @GetMapping("/list")
    @ApiOperation(value = "列表")
    public Result<List<PermissionListVO>> permissionList(@Valid PermissionQueryDTO permission) {
        return permissionService.permissionListService(permission);
    }

    @GetMapping("/detail")
    @ApiOperation(value = "详情")
    public Result<PermissionDetailVO> permissionDetail(Long id) {
        return permissionService.permissionDetailService(id);
    }

    @PostMapping("/saveList")
    @ApiOperation(value = "批量新增/修改")
    public Result<List<PermissionEntity>> permissionSaveList(@RequestBody @Valid List<PermissionSaveDTO> permissions) {
        return permissionService.permissionSaveListService(permissions);
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除")
    public Result<Object> permissionDelete(@RequestBody List<PermissionQueryDTO> ids) {
        ids.forEach(item -> permissionMapper.deleteById(item.getId()));
        return Result.success("删除成功");
    }

    @PostMapping("/import")
    @ApiOperation(value = "导入")
    public Result<List<PermissionEntity>> permissionImport(@RequestParam("file") MultipartFile multipartFile) throws Exception {
        List<PermissionSaveDTO> permissionList = PermissionConvert.INSTANCE.imports(ExcelUtils.imports(multipartFile.getInputStream(), PermissionExportVO.class));
        return permissionService.permissionSaveListService(permissionList);
    }

    @GetMapping("/export")
    @ApiOperation(value = "导出")
    public void permissionExport(HttpServletResponse response) throws IOException {
        ExcelUtils.export(response, "权限.xlsx", "权限", PermissionExportVO.class, PermissionConvert.INSTANCE.export(permissionMapper.selectList(new QueryWrapper<>())));
    }
}