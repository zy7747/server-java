package com.example.system.dal.vo.page;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "导出")
public class PageExportVO {
    /**
     * 页面内容
     */
    @ExcelProperty("页面内容")
    private String content;
}