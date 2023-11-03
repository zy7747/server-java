package com.example.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.framework.utils.Excel;
import com.example.system.dal.convert.DictConvert;
import com.example.system.dal.dto.dict.DictQueryDTO;
import com.example.system.dal.dto.dict.DictSaveDTO;
import com.example.system.dal.entity.DictEntity;
import com.example.system.dal.mapper.DictMapper;
import com.example.system.dal.vo.dict.DictDetailVO;
import com.example.system.dal.vo.dict.DictExportVO;
import com.example.system.dal.vo.dict.DictListVO;
import com.example.system.dal.vo.dict.DictPageVO;
import com.example.system.service.dict.DictService;
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
@Api(tags = "字典接口")
@RequestMapping("/dict")
public class DictController {
    @Resource
    DictService dictService;
    @Resource
    DictMapper dictMapper;

    @GetMapping("/page")
    @ApiOperation(value = "分页")
    public Result<PageList<DictPageVO>> dictPage(@Valid DictQueryDTO dict) {
        return dictService.pageService(dict);
    }

    @GetMapping("/list")
    @ApiOperation(value = "列表")
    public Result<List<DictListVO>> dictList(@Valid DictQueryDTO dict) {
        return dictService.listService(dict);
    }

    @GetMapping("/subList")
    @ApiOperation(value = "字典子集列表")
    public Result<List<DictListVO>> subList(@Valid DictQueryDTO dict) {
        return dictService.subListService(dict);
    }

    @GetMapping("/dictAllList")
    @ApiOperation(value = "获取所有字典集")
    public Result<Object> dictAllList() {
        return dictService.dictAllListService();
    }

    @GetMapping("/detail")
    @ApiOperation(value = "详情")
    public Result<DictDetailVO> dictDetail(Long id) {
        return dictService.detailService(id);
    }

    @PostMapping("/saveList")
    @ApiOperation(value = "批量新增/修改")
    public Result<List<DictEntity>> dictSaveList(@RequestBody @Valid List<DictSaveDTO> dict) {
        return dictService.saveListService(dict);
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除")
    public Result<Object> dictDelete(@RequestBody List<DictQueryDTO> ids) {

        ids.forEach(item -> {
            if (item.getParentId() == null) {
                //查询出所有子项
                QueryWrapper<DictEntity> wrapperId = new QueryWrapper<>();

                wrapperId.eq("parent_id", item.getId());

                List<DictEntity> dictList = dictMapper.selectList(wrapperId);

                //有子项先删除子项
                dictList.forEach(items -> dictMapper.deleteById(items.getId()));
            }
            //删除
            dictMapper.deleteById(item.getId());
        });
        return Result.success("删除成功");
    }

    @GetMapping("/export")
    @ApiOperation(value = "导出")
    public void dictExport(HttpServletResponse response) throws IOException {
        Excel.export(response, "字典.xlsx", "字典", DictExportVO.class, DictConvert.INSTANCE.export(dictMapper.selectList(new QueryWrapper<>())));
    }
}