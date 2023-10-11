package com.example.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.framework.utils.Excel;
import com.example.system.dal.convert.FileConvert;
import com.example.system.dal.dto.file.FileQueryDTO;
import com.example.system.dal.dto.file.FileSaveDTO;
import com.example.system.dal.dto.file.FileUploadDTO;
import com.example.system.dal.entity.FileEntity;
import com.example.system.dal.mapper.FileMapper;
import com.example.system.dal.vo.file.FileDetailVO;
import com.example.system.dal.vo.file.FileExportVO;
import com.example.system.dal.vo.file.FileListVO;
import com.example.system.dal.vo.file.FilePageVO;
import com.example.system.service.file.FileService;
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
    public Result<List<FileEntity>> fileSaveList(@RequestBody @Valid List<FileSaveDTO> files) {
        return fileService.saveListService(files);
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除")
    public Result<Object> fileDelete(@RequestBody List<FileQueryDTO> ids) {
        ids.forEach(item -> fileMapper.deleteById(item.getId()));
        return Result.success("删除成功");
    }

    @GetMapping("/export")
    @ApiOperation(value = "导出")
    public void fileExport(HttpServletResponse response) throws IOException {
        Excel.export(response, "文件.xlsx", "文件", FileExportVO.class, FileConvert.INSTANCE.export(fileMapper.selectList(new QueryWrapper<>())));
    }
}
