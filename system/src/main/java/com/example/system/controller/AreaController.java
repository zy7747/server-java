package com.example.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.framework.utils.Excel;
import com.example.system.convert.AreaConvert;
import com.example.system.dal.dto.area.AreaQueryDTO;
import com.example.system.dal.dto.area.AreaSaveDTO;
import com.example.system.dal.entity.AreaEntity;
import com.example.system.mapper.AreaMapper;
import com.example.system.dal.vo.area.AreaDetailVO;
import com.example.system.dal.vo.area.AreaExportVO;
import com.example.system.dal.vo.area.AreaListVO;
import com.example.system.dal.vo.area.AreaPageVO;
import com.example.system.service.area.AreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Slf4j
@Validated
@CrossOrigin
@RestController
@Api(tags = "地区接口")
@RequestMapping("/area")
public class AreaController {
    @Resource
    AreaService areaService;
    @Resource
    AreaMapper areaMapper;

    @GetMapping("/page")
    @ApiOperation(value = "分页")
    public Result<PageList<AreaPageVO>> areaPage(@Valid AreaQueryDTO area) {
        return areaService.areaPageService(area);
    }

    @GetMapping("/list")
    @ApiOperation(value = "列表")
    public Result<List<AreaListVO>> areaList(@Valid AreaQueryDTO area) {
        return areaService.areaListService(area);
    }

    @GetMapping("/detail")
    @ApiOperation(value = "详情")
    @PreAuthorize("hasAuthority('system:area:detail')")
    public Result<AreaDetailVO> areaDetail(Long id) {
        return areaService.areaDetailService(id);
    }

    @PostMapping("/saveList")
    @ApiOperation(value = "批量新增/修改")
    public Result<List<AreaEntity>> areaSaveList(@RequestBody @Valid List<AreaSaveDTO> areas) {
        return areaService.areaSaveListService(areas);
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除")
    public Result<Object> areaDelete(@RequestBody List<AreaEntity> ids) {
        ids.forEach(item -> areaMapper.deleteById(item.getId()));
        return Result.success("删除成功");
    }

    @GetMapping("/export")
    @ApiOperation(value = "导出")
    public void areaExport(HttpServletResponse response) throws IOException {
        Excel.export(response, "地区.xlsx", "地区", AreaExportVO.class, AreaConvert.INSTANCE.export(areaMapper.selectList(new QueryWrapper<>())));
    }
}