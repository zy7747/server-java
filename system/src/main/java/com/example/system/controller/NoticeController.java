package com.example.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.framework.utils.Excel;
import com.example.system.convert.NoticeConvert;
import com.example.system.dal.dto.notice.NoticeQueryDTO;
import com.example.system.dal.dto.notice.NoticeSaveDTO;
import com.example.system.dal.entity.NoticeEntity;
import com.example.system.mapper.NoticeMapper;
import com.example.system.dal.vo.notice.NoticeDetailVO;
import com.example.system.dal.vo.notice.NoticeExportVO;
import com.example.system.dal.vo.notice.NoticeListVO;
import com.example.system.dal.vo.notice.NoticePageVO;
import com.example.system.service.notice.NoticeService;
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
@Api(tags = "消息通知接口")
@RequestMapping("/notice")
public class NoticeController {
    @Resource
    NoticeService noticeService;
    @Resource
    NoticeMapper noticeMapper;

    @GetMapping("/page")
    @ApiOperation(value = "分页")
    public Result<PageList<NoticePageVO>> noticePage(@Valid NoticeQueryDTO notice) {
        return noticeService.noticePageService(notice);
    }

    @GetMapping("/list")
    @ApiOperation(value = "列表")
    public Result<List<NoticeListVO>> noticeList(@Valid NoticeQueryDTO notice) {
        return noticeService.noticeListService(notice);
    }

    @GetMapping("/detail")
    @ApiOperation(value = "详情")
    public Result<NoticeDetailVO> noticeDetail(Long id) {
        return noticeService.noticeDetailService(id);
    }

    @PostMapping("/saveList")
    @ApiOperation(value = "批量新增/修改")
    public Result<List<NoticeEntity>> noticeSaveList(@RequestBody @Valid List<NoticeSaveDTO> notices) {
        return noticeService.noticeSaveListService(notices);
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除")
    public Result<Object> noticeDelete(@RequestBody List<NoticeEntity> ids) {
        ids.forEach(item -> noticeMapper.deleteById(item.getId()));
        return Result.success("删除成功");
    }

    @PostMapping("/import")
    @ApiOperation(value = "导入")
    public Result<List<NoticeEntity>> noticeImport(@RequestParam("file") MultipartFile multipartFile) throws Exception {

        List<NoticeSaveDTO> noticeList = NoticeConvert.INSTANCE.imports(Excel.imports(multipartFile.getInputStream(), NoticeExportVO.class));

        return noticeService.noticeSaveListService(noticeList);
    }

    @GetMapping("/export")
    @ApiOperation(value = "导出")
    public void noticeExport(HttpServletResponse response) throws IOException {
        Excel.export(response, "消息通知.xlsx", "消息通知", NoticeExportVO.class, NoticeConvert.INSTANCE.export(noticeMapper.selectList(new QueryWrapper<>())));
    }
}