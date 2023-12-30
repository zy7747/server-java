package com.example.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.framework.utils.ExcelUtils;
import com.example.system.convert.PersonConvert;
import com.example.system.dal.dto.person.PersonQueryDTO;
import com.example.system.dal.dto.person.PersonSaveDTO;
import com.example.system.dal.entity.PersonEntity;
import com.example.system.mapper.PersonMapper;
import com.example.system.dal.vo.person.PersonDetailVO;
import com.example.system.dal.vo.person.PersonExportVO;
import com.example.system.dal.vo.person.PersonListVO;
import com.example.system.dal.vo.person.PersonPageVO;
import com.example.system.service.person.PersonService;
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
@Api(tags = "个人信息接口")
@RequestMapping("/person")
public class PersonController {
    @Resource
    PersonService personService;
    @Resource
    PersonMapper personMapper;

    @GetMapping("/page")
    @ApiOperation(value = "分页")
    public Result<PageList<PersonPageVO>> personPage(@Valid PersonQueryDTO person) {
        return personService.personPageService(person);
    }

    @GetMapping("/list")
    @ApiOperation(value = "列表")
    public Result<List<PersonListVO>> personList(@Valid PersonQueryDTO person) {
        return personService.personListService(person);
    }

    @GetMapping("/detail")
    @ApiOperation(value = "详情")
    public Result<PersonDetailVO> personDetail(Long id) {
        return personService.personDetailService(id);
    }

    @PostMapping("/saveList")
    @ApiOperation(value = "批量新增/修改")
    public Result<List<PersonEntity>> personSaveList(@RequestBody @Valid List<PersonSaveDTO> persons) {
        return personService.personSaveListService(persons);
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除")
    public Result<Object> personDelete(@RequestBody List<PersonQueryDTO> ids) {
        ids.forEach(item -> personMapper.deleteById(item.getId()));
        return Result.success("删除成功");
    }

    @PostMapping("/import")
    @ApiOperation(value = "导入")
    public Result<List<PersonEntity>> noticeImport(@RequestParam("file") MultipartFile multipartFile) throws Exception {

        List<PersonSaveDTO> personList = PersonConvert.INSTANCE.imports(ExcelUtils.imports(multipartFile.getInputStream(), PersonExportVO.class));

        return personService.personSaveListService(personList);
    }

    @GetMapping("/export")
    @ApiOperation(value = "导出")
    public void personExport(HttpServletResponse response) throws IOException {
        ExcelUtils.export(response, "个人信息.xlsx", "个人信息", PersonExportVO.class, PersonConvert.INSTANCE.export(personMapper.selectList(new QueryWrapper<>())));
    }
}
