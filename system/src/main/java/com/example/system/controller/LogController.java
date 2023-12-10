package com.example.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.framework.utils.Excel;
import com.example.system.dal.convert.LogConvert;
import com.example.system.dal.dto.log.LogQueryDTO;
import com.example.system.dal.dto.log.LogSaveDTO;
import com.example.system.dal.entity.LogEntity;
import com.example.system.dal.mapper.LogMapper;
import com.example.system.dal.vo.log.LogDetailVO;
import com.example.system.dal.vo.log.LogExportVO;
import com.example.system.dal.vo.log.LogListVO;
import com.example.system.dal.vo.log.LogPageVO;
import com.example.system.service.log.LogService;
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
@Api(tags = "日志接口")
@RequestMapping("/log")
public class LogController {
    @Resource
    LogService logService;

    @Resource
    LogMapper logMapper;

    @GetMapping("/page")
    @ApiOperation(value = "分页")
    public Result<PageList<LogPageVO>> logPage(@Valid LogQueryDTO log) {
        return logService.logPageService(log);
    }

    @GetMapping("/list")
    @ApiOperation(value = "列表")
    public Result<List<LogListVO>> logList(@Valid LogQueryDTO log) {
        return logService.logListService(log);
    }

    @GetMapping("/detail")
    @ApiOperation(value = "详情")
    public Result<LogDetailVO> logDetail(Long id) {
        return logService.logDetailService(id);
    }

    @PostMapping("/saveList")
    @ApiOperation(value = "批量新增/修改")
    public Result<List<LogEntity>> logSaveList(@RequestBody @Valid List<LogSaveDTO> logs) {
        return logService.logSaveListService(logs);
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除")
    public Result<Object> logDelete(@RequestBody List<LogEntity> ids) {
        ids.forEach(item -> logMapper.deleteById(item.getId()));
        return Result.success("删除成功");
    }

    @PostMapping("/import")
    @ApiOperation(value = "导入")
    public Result<List<LogEntity>> logImport(@RequestParam("file") MultipartFile multipartFile) throws Exception {
        List<LogSaveDTO> logList = LogConvert.INSTANCE.imports(Excel.imports(multipartFile.getInputStream(), LogExportVO.class));
        return logService.logSaveListService(logList);
    }

    @GetMapping("/export")
    @ApiOperation(value = "导出")
    public void logExport(HttpServletResponse response) throws IOException {
        Excel.export(response, "日志.xlsx", "日志", LogExportVO.class, LogConvert.INSTANCE.export(logMapper.selectList(new QueryWrapper<>())));
    }
}