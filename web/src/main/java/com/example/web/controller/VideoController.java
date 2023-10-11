package com.example.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.framework.utils.Excel;
import com.example.web.dal.convert.VideoConvert;
import com.example.web.dal.dto.video.HotVideoListQueryDTO;
import com.example.web.dal.dto.video.VideoQueryDTO;
import com.example.web.dal.dto.video.VideoSaveDTO;
import com.example.web.dal.entity.VideoEntity;
import com.example.web.dal.mapper.VideoMapper;
import com.example.web.dal.vo.video.VideoDetailVO;
import com.example.web.dal.vo.video.VideoExportVO;
import com.example.web.dal.vo.video.VideoListVO;
import com.example.web.dal.vo.video.VideoPageVO;
import com.example.web.service.video.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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
@Api(tags = "视频接口")
@RequestMapping("/video")
public class VideoController {
    @Resource
    VideoService videoService;
    @Resource
    VideoMapper videoMapper;

    @GetMapping("/page")
    @ApiOperation(value = "分页")
    public Result<PageList<VideoPageVO>> videoPage(@Valid VideoQueryDTO video) {
        return videoService.pageService(video);
    }

    @GetMapping("/list")
    @ApiOperation(value = "列表")
    public Result<List<VideoListVO>> videoList(@Valid VideoQueryDTO video) {
        return videoService.listService(video);
    }

    @GetMapping("/detail")
    @ApiOperation(value = "详情")
    public Result<VideoDetailVO> videoDetail(Long id) {
        return videoService.detailService(id);
    }

    @PostMapping("/saveList")
    @ApiOperation(value = "批量新增/修改")
    public Result<List<VideoEntity>> videoSaveList(@RequestBody @Valid List<VideoSaveDTO> videos) {
        return videoService.saveListService(videos);
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除")
    public Result<Object> videoDelete(@RequestBody List<VideoQueryDTO> ids) {
        ids.forEach(item -> videoMapper.deleteById(item.getId()));
        return Result.success("删除成功");
    }

    @GetMapping("/playNum")
    @ApiOperation(value = "播放数量修改")
    public Result<VideoEntity> playNumService(@Valid VideoEntity video) {
        return videoService.playNumService(video);
    }

    @GetMapping("/hotVideo")
    @ApiOperation(value = "热门视频集获取")
    public Result<HotVideoListQueryDTO> hotVideoService() {
        return videoService.hotVideoService();
    }

    @GetMapping("/export")
    @ApiOperation(value = "导出")
    public void videoExport(HttpServletResponse response) throws IOException {
        Excel.export(response, "视频.xlsx", "视频", VideoExportVO.class, VideoConvert.INSTANCE.export(videoMapper.selectList(new QueryWrapper<>())));
    }
}