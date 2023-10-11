package com.example.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.framework.utils.Excel;
import com.example.system.dal.convert.UserConvert;
import com.example.system.dal.dto.user.LoginDTO;
import com.example.system.dal.dto.user.SignUpDTO;
import com.example.system.dal.dto.user.UserQueryDTO;
import com.example.system.dal.dto.user.UserSaveDTO;
import com.example.system.dal.entity.UserEntity;
import com.example.system.dal.mapper.UserMapper;
import com.example.system.dal.vo.user.*;
import com.example.system.service.user.UserService;
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
@Api(tags = "用户接口")
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;

    @Resource
    UserMapper userMapper;

    @GetMapping("/page")
    @ApiOperation(value = "分页")
    public Result<PageList<UserPageVO>> userPage(@Valid UserQueryDTO user) {
        return userService.pageService(user);
    }

    @GetMapping("/list")
    @ApiOperation(value = "列表")
    public Result<List<UserListVO>> userList(@Valid UserQueryDTO user) {
        return userService.listService(user);
    }

    @GetMapping("/detail")
    @ApiOperation(value = "详情")
    public Result<UserDetailVO> userDetail(Long id) {
        return userService.detailService(id);
    }

    @PostMapping("/saveList")
    @ApiOperation(value = "批量新增/修改")
    public Result<List<UserEntity>> userSaveList(@RequestBody @Valid List<UserSaveDTO> users) {
        return userService.saveListService(users);
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除")
    public Result<Object> userDelete(@RequestBody List<UserQueryDTO> ids) {
        ids.forEach(item -> {
            userMapper.deleteById(item.getId());
            userMapper.deleteUserRole(item.getId());
        });
        return Result.success("删除成功");
    }

    @GetMapping("/export")
    @ApiOperation(value = "导出")
    public void roleExport(HttpServletResponse response) throws IOException {
        Excel.export(response, "用户.xlsx", "用户", UserExportVO.class, UserConvert.INSTANCE.export(userMapper.selectList(new QueryWrapper<>())));
    }

    @GetMapping("/login")
    @ApiOperation(value = "登录")
    public Result<UserInfoVO> login(@Valid LoginDTO loginInfo) {
        return userService.loginService(loginInfo);
    }

    @PostMapping("/signUp")
    @ApiOperation(value = "注册")
    public Result<Object> signUp(@Valid @RequestBody SignUpDTO signUpInfo) {
        return userService.signUpService(signUpInfo);
    }
}