package com.example.statistics.controller;

import com.example.framework.common.Result;
import com.example.statistics.dal.vo.StatisticsGetVO;
import com.example.statistics.service.statistics.StatisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@CrossOrigin
@Validated
@Api(tags = "数据统计接口")
@RequestMapping("/statistics")
public class StatisticsController {
    @Resource
    StatisticsService statisticsService;

    @GetMapping("/get")
    @ApiOperation(value = "统计数据")
    public Result<StatisticsGetVO> getStatistics() {
        return statisticsService.getStatistics();
    }
}
