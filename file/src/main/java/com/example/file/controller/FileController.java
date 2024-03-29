package com.example.file.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.framework.utils.ExcelUtils;
import com.example.file.convert.FileConvert;
import com.example.file.dal.dto.file.FileQueryDTO;
import com.example.file.dal.dto.file.FileSaveDTO;
import com.example.file.dal.dto.file.FileUploadDTO;
import com.example.file.dal.entity.FileEntity;
import com.example.file.mapper.FileMapper;
import com.example.file.dal.vo.file.FileDetailVO;
import com.example.file.dal.vo.file.FileExportVO;
import com.example.file.dal.vo.file.FileListVO;
import com.example.file.dal.vo.file.FilePageVO;
import com.example.file.service.file.FileService;
import com.example.system.annotation.Log;
import com.example.system.enums.OperateType;
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
@Api(tags = "文件接口")
@RequestMapping("/file")
public class FileController {
    @Resource
    FileService fileService;
    @Resource
    FileMapper fileMapper;

    @GetMapping("/page")
    @ApiOperation(value = "分页")
    public Result<PageList<FilePageVO>> filePage(@Valid FileQueryDTO file) {
        return fileService.pageService(file);
    }

    @PostMapping("/upload")
    @ApiOperation(value = "文件上传")
    @Log(title = "文件上传", module = "文件管理", content = "文件上传", type = OperateType.INSERT)
    public Result<FileEntity> upload(@RequestParam("file") MultipartFile file, FileUploadDTO params) {
        return fileService.uploadService(file, params);
    }

    @PostMapping("/createFolder")
    @ApiOperation(value = "创建文件夹")
    public Result<FileEntity> createFolder(@RequestBody @Valid FileEntity file) {
        return fileService.createFolderService(file);
    }

    @GetMapping("/getFileParent")
    @ApiOperation(value = "查找父级信息")
    public Result<FileEntity> getFileParent(@Valid FileEntity file) {
        return fileService.getFileParentService(file);
    }

    @GetMapping("/list")
    @ApiOperation(value = "列表")
    public Result<List<FileListVO>> list(@Valid FileQueryDTO file) {
        return fileService.listService(file);
    }

    @GetMapping("/fileList")
    @ApiOperation(value = "文件夹内容查询")
    public Result<List<FileListVO>> fileList(@Valid FileQueryDTO file) {
        return fileService.fileListService(file);
    }

    @GetMapping("/detail")
    @ApiOperation(value = "详情")
    public Result<FileDetailVO> fileDetail(Long id) {
        return fileService.detailService(id);
    }

    @PostMapping("/saveList")
    @ApiOperation(value = "批量新增/修改")
    @Log(title = "文件新增/修改", module = "文件管理", content = "文件新增/修改", type = OperateType.INSERT)
    @PreAuthorize("hasAuthority('file:file:save')")
    public Result<List<FileEntity>> fileSaveList(@RequestBody @Valid List<FileSaveDTO> files) {
        return fileService.saveListService(files);
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除")
    @Log(title = "文件删除", module = "文件管理", content = "文件删除", type = OperateType.DELETE)
    @PreAuthorize("hasAuthority('file:file:delete')")
    public Result<Object> fileDelete(@RequestBody List<FileQueryDTO> ids) {
        ids.forEach(item -> fileMapper.deleteById(item.getId()));
        return Result.success("删除成功");
    }

    @GetMapping("/export")
    @ApiOperation(value = "导出")
    public void fileExport(HttpServletResponse response) throws IOException {
        ExcelUtils.export(response, "文件.xlsx", "文件", FileExportVO.class, FileConvert.INSTANCE.export(fileMapper.selectList(new QueryWrapper<>())));
    }
}
