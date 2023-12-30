package com.example.job.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.framework.utils.ExcelUtils;
import com.example.job.convert.JobConvert;
import com.example.job.dal.dto.job.JobQueryDTO;
import com.example.job.dal.dto.job.JobSaveDTO;
import com.example.job.dal.entity.JobEntity;
import com.example.job.mapper.JobMapper;
import com.example.job.dal.vo.job.JobDetailVO;
import com.example.job.dal.vo.job.JobExportVO;
import com.example.job.dal.vo.job.JobListVO;
import com.example.job.dal.vo.job.JobPageVO;
import com.example.job.service.job.JobService;
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
@Api(tags = "定时任务接口")
@RequestMapping("/job")
public class JobController {
    @Resource
    JobService jobService;
    @Resource
    JobMapper jobMapper;

    @GetMapping("/page")
    @ApiOperation(value = "分页")
    public Result<PageList<JobPageVO>> jobPage(@Valid JobQueryDTO job) {
        return jobService.jobPageService(job);
    }

    @GetMapping("/list")
    @ApiOperation(value = "列表")
    public Result<List<JobListVO>> jobList(@Valid JobQueryDTO job) {
        return jobService.jobListService(job);
    }

    @GetMapping("/detail")
    @ApiOperation(value = "详情")
    public Result<JobDetailVO> jobDetail(Long id) {
        return jobService.jobDetailService(id);
    }

    @PostMapping("/saveList")
    @ApiOperation(value = "批量新增/修改")
    public Result<List<JobEntity>> jobSaveList(@RequestBody @Valid List<JobSaveDTO> jobs) {
        return jobService.jobSaveListService(jobs);
    }

    @PostMapping("/changeJobStatus")
    @ApiOperation(value = "修改定时器状态")
    public Result<Object> changeJobStatus(@RequestBody @Valid List<JobSaveDTO> jobs) {
        return jobService.changeJobStatusService(jobs);
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除")
    public Result<Object> jobDelete(@RequestBody List<JobQueryDTO> ids) {
        ids.forEach(item -> jobMapper.deleteById(item.getId()));
        return Result.success("删除成功");
    }

    @GetMapping("/export")
    @ApiOperation(value = "导出")
    public void jobExport(HttpServletResponse response) throws IOException {
        ExcelUtils.export(response, "定时任务.xlsx", "定时任务", JobExportVO.class, JobConvert.INSTANCE.export(jobMapper.selectList(new QueryWrapper<>())));
    }
}
