package com.example.file.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.framework.utils.ExcelUtils;
import com.example.file.convert.AudioConvert;
import com.example.file.dal.dto.audio.AudioQueryDTO;
import com.example.file.dal.dto.audio.AudioSaveDTO;
import com.example.file.dal.entity.AudioEntity;
import com.example.file.mapper.AudioMapper;
import com.example.file.dal.vo.audio.AudioDetailVO;
import com.example.file.dal.vo.audio.AudioExportVO;
import com.example.file.dal.vo.audio.AudioListVO;
import com.example.file.dal.vo.audio.AudioPageVO;
import com.example.file.service.audio.AudioService;
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
    public Result<Object> audioDelete(@RequestBody List<AudioQueryDTO> ids) {
        ids.forEach(item -> audioMapper.deleteById(item.getId()));
        return Result.success("删除成功");
    }

    @PostMapping("/import")
    @ApiOperation(value = "导入")
    public Result<List<AudioEntity>> audioImport(@RequestParam("file") MultipartFile multipartFile) throws Exception {
        List<AudioSaveDTO> audioList = AudioConvert.INSTANCE.imports(ExcelUtils.imports(multipartFile.getInputStream(), AudioExportVO.class));
        return audioService.audioSaveListService(audioList);
    }

    @GetMapping("/export")
    @ApiOperation(value = "导出")
    public void audioExport(HttpServletResponse response) throws IOException {
        ExcelUtils.export(response, "音频.xlsx", "音频", AudioExportVO.class, AudioConvert.INSTANCE.export(audioMapper.selectList(new QueryWrapper<>())));
    }
}