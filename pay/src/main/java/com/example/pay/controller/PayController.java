package com.example.pay.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.framework.utils.ExcelUtils;
import com.example.pay.convert.PayConvert;
import com.example.pay.dal.dto.pay.PayQueryDTO;
import com.example.pay.dal.dto.pay.PaySaveDTO;
import com.example.pay.dal.entity.PayEntity;
import com.example.pay.mapper.PayMapper;
import com.example.pay.dal.vo.pay.PayDetailVO;
import com.example.pay.dal.vo.pay.PayExportVO;
import com.example.pay.dal.vo.pay.PayListVO;
import com.example.pay.dal.vo.pay.PayPageVO;
import com.example.pay.service.pay.PayService;
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
@Api(tags = "支付功能接口")
@RequestMapping("/pay")
public class PayController {
    @Resource
    PayService payService;
    @Resource
    PayMapper payMapper;

    @GetMapping("/page")
    @ApiOperation(value = "分页")
    public Result<PageList<PayPageVO>> payPage(@Valid PayQueryDTO pay) {
        return payService.payPageService(pay);
    }

    @GetMapping("/list")
    @ApiOperation(value = "列表")
    public Result<List<PayListVO>> payList(@Valid PayQueryDTO pay) {
        return payService.payListService(pay);
    }

    @GetMapping("/detail")
    @ApiOperation(value = "详情")
    public Result<PayDetailVO> payDetail(Long id) {
        return payService.payDetailService(id);
    }

    @PostMapping("/saveList")
    @ApiOperation(value = "批量新增/修改")
    public Result<List<PayEntity>> paySaveList(@RequestBody @Valid List<PaySaveDTO> pays) {
        return payService.paySaveListService(pays);
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除")
    public Result<Object> payDelete(@RequestBody List<PayEntity> ids) {
        ids.forEach(item -> payMapper.deleteById(item.getId()));
        return Result.success("删除成功");
    }

    @PostMapping("/import")
    @ApiOperation(value = "导入")
    public Result<List<PayEntity>> payImport(@RequestParam("file") MultipartFile multipartFile) throws Exception {
        List<PaySaveDTO> payList = PayConvert.INSTANCE.imports(ExcelUtils.imports(multipartFile.getInputStream(), PayExportVO.class));
        return payService.paySaveListService(payList);
    }

    @GetMapping("/export")
    @ApiOperation(value = "导出")
    public void payExport(HttpServletResponse response) throws IOException {
        ExcelUtils.export(response, "支付功能.xlsx", "支付功能", PayExportVO.class, PayConvert.INSTANCE.export(payMapper.selectList(new QueryWrapper<>())));
    }
}