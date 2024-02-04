package com.example.system.controller;

import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.framework.utils.ExcelUtils;
import com.example.system.convert.PageConvert;
import com.example.system.dal.dto.page.PageQueryDTO;
import com.example.system.dal.dto.page.PageSaveDTO;
import com.example.system.dal.entity.PageEntity;
import com.example.system.mapper.PageMapper;
import com.example.system.dal.vo.page.PageDetailVO;
import com.example.system.dal.vo.page.PageExportVO;
import com.example.system.dal.vo.page.PageListVO;
import com.example.system.dal.vo.page.PagePageVO;
import com.example.system.service.page.PageService;
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
@Api(tags = "页面配置接口")
@RequestMapping("/page")
public class PageController {
    @Resource
    PageService pageService;
    @Resource
    PageMapper pageMapper;

    @GetMapping("/page")
    @ApiOperation(value = "分页")
    public Result<PageList<PagePageVO>> pagePage(@Valid PageQueryDTO page) {
        return pageService.pagePageService(page);
    }

    @GetMapping("/list")
    @ApiOperation(value = "列表")
    public Result<List<PageListVO>> pageList(@Valid PageQueryDTO page) {
        return pageService.pageListService(page);
    }

    @GetMapping("/detail")
    @ApiOperation(value = "详情")
    public Result<PageDetailVO> pageDetail(Long id) {
        return pageService.pageDetailService(id);
    }

    @PostMapping("/saveList")
    @ApiOperation(value = "批量新增/修改")
    public Result<List<PageEntity>> pageSaveList(@RequestBody @Valid List<PageSaveDTO> pages) {
        return pageService.pageSaveListService(pages);
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除")
    public Result<Object> pageDelete(@RequestBody List<PageQueryDTO> ids) {
        ids.forEach(item -> pageMapper.deleteById(item.getId()));
        return Result.success("删除成功");
    }

    @PostMapping("/import")
    @ApiOperation(value = "导入")
    public Result<List<PageEntity>> pageImport(@RequestParam("file") MultipartFile multipartFile) throws Exception {
        List<PageSaveDTO> pageList = PageConvert.INSTANCE.imports(ExcelUtils.imports(multipartFile.getInputStream(), PageExportVO.class));
        return pageService.pageSaveListService(pageList);
    }

    @GetMapping("/export")
    @ApiOperation(value = "导出")
    public void pageExport(HttpServletResponse response, @Valid PageQueryDTO page) throws IOException {
        ExcelUtils.export(response, "页面配置.xlsx", "页面配置", PageExportVO.class, PageConvert.INSTANCE.export(pageMapper.selectList(page)));
    }
}