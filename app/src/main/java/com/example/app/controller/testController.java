package com.example.app.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.app.dal.entity.UserEntity;
import com.example.app.dal.mapper.TestMapper;
import com.example.framework.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@CrossOrigin
@Validated
@Api(tags = "测试接口")
@RequestMapping("/test")
public class testController {
    @Resource
    TestMapper testMapper;

    @GetMapping("/list")
    @ApiOperation(value = "列表")
    public Result<List<UserEntity>> testList() {
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();

        return Result.success(testMapper.selectList(wrapper));
    }
}
