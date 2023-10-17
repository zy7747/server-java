package com.example.app.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.framework.utils.Excel;
import com.example.app.dal.convert.AudioConvert;
import com.example.app.dal.dto.audio.AudioQueryDTO;
import com.example.app.dal.dto.audio.AudioSaveDTO;
import com.example.app.dal.entity.AudioEntity;
import com.example.app.dal.mapper.AudioMapper;
import com.example.app.dal.vo.audio.AudioDetailVO;
import com.example.app.dal.vo.audio.AudioExportVO;
import com.example.app.dal.vo.audio.AudioListVO;
import com.example.app.dal.vo.audio.AudioPageVO;
import com.example.app.service.AudioService;
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
@Validated
@CrossOrigin
@RestController
@Api(tags = "音频接口")
@RequestMapping("/audio")
public class AudioController {
    @Resource
    AudioService audioService;

    @Resource
    AudioMapper audioMapper;

    @GetMapping("/page")
    @ApiOperation(value = "分页")
    public Result<PageList<AudioPageVO>> audioPage(@Valid AudioQueryDTO audio) {
        return audioService.audioPageService(audio);
    }

    @GetMapping("/list")
    @ApiOperation(value = "列表")
    public Result<List<AudioListVO>> audioList(@Valid AudioQueryDTO audio) {
        return audioService.audioListService(audio);
    }

    @GetMapping("/detail")
    @ApiOperation(value = "详情")
    public Result<AudioDetailVO> audioDetail(Long id) {
        return audioService.audioDetailService(id);
    }

    @PostMapping("/saveList")
    @ApiOperation(value = "批量新增/修改")
    public Result<List<AudioEntity>> audioSaveList(@RequestBody @Valid List<AudioSaveDTO> audios) {
        return audioService.audioSaveListService(audios);
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除")
    public Result<Object> audioDelete(@RequestBody List<AudioEntity> ids) {
        ids.forEach(item -> audioMapper.deleteById(item.getId()));
        return Result.success("删除成功");
    }

    @GetMapping("/export")
    @ApiOperation(value = "导出")
    public void audioExport(HttpServletResponse response) throws IOException {
        Excel.export(response, "音频.xlsx", "音频", AudioExportVO.class, AudioConvert.INSTANCE.export(audioMapper.selectList(new QueryWrapper<>())));
    }
}
