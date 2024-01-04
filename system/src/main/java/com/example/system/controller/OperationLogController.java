package com.example.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.framework.utils.ExcelUtils;
import com.example.system.convert.OperationLogConvert;
import com.example.system.dal.dto.operationLog.OperationLogQueryDTO;
import com.example.system.dal.dto.operationLog.OperationLogSaveDTO;
import com.example.system.dal.entity.OperationLogEntity;
import com.example.system.mapper.OperationLogMapper;
import com.example.system.dal.vo.operationLog.OperationLogDetailVO;
import com.example.system.dal.vo.operationLog.OperationLogExportVO;
import com.example.system.dal.vo.operationLog.OperationLogListVO;
import com.example.system.dal.vo.operationLog.OperationLogPageVO;
import com.example.system.service.operationLog.OperationLogService;
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
@Api(tags = "操作日志接口")
@RequestMapping("/operationLog")
public class OperationLogController {
    @Resource
    OperationLogService operationLogService;
    @Resource
    OperationLogMapper operationLogMapper;

    @GetMapping("/page")
    @ApiOperation(value = "分页")
    public Result<PageList<OperationLogPageVO>> operationLogPage(@Valid OperationLogQueryDTO operationLog) {
        return operationLogService.operationLogPageService(operationLog);
    }

    @GetMapping("/list")
    @ApiOperation(value = "列表")
    public Result<List<OperationLogListVO>> operationLogList(@Valid OperationLogQueryDTO operationLog) {
        return operationLogService.operationLogListService(operationLog);
    }

    @GetMapping("/detail")
    @ApiOperation(value = "详情")
    public Result<OperationLogDetailVO> operationLogDetail(Long id) {
        return operationLogService.operationLogDetailService(id);
    }

    @PostMapping("/saveList")
    @ApiOperation(value = "批量新增/修改")
    public Result<List<OperationLogEntity>> operationLogSaveList(@RequestBody @Valid List<OperationLogSaveDTO> operationLogs) {
        return operationLogService.operationLogSaveListService(operationLogs);
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除")
    public Result<Object> operationLogDelete(@RequestBody List<OperationLogQueryDTO> ids) {
        ids.forEach(item -> operationLogMapper.deleteById(item.getId()));
        return Result.success("删除成功");
    }

    @PostMapping("/import")
    @ApiOperation(value = "导入")
    public Result<List<OperationLogEntity>> operationLogImport(@RequestParam("file") MultipartFile multipartFile) throws Exception {
        List<OperationLogSaveDTO> operationLogList = OperationLogConvert.INSTANCE.imports(ExcelUtils.imports(multipartFile.getInputStream(), OperationLogExportVO.class));
        return operationLogService.operationLogSaveListService(operationLogList);
    }

    @GetMapping("/export")
    @ApiOperation(value = "导出")
    public void operationLogExport(HttpServletResponse response) throws IOException {
        ExcelUtils.export(response, "操作日志.xlsx", "操作日志", OperationLogExportVO.class, OperationLogConvert.INSTANCE.export(operationLogMapper.selectList(new QueryWrapper<>())));
    }
}