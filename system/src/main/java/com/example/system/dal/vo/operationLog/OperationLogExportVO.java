package com.example.system.dal.vo.operationLog;

import com.alibaba.excel.annotation.ExcelProperty;
import com.example.framework.dal.vo.ExcelParamsVO;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@ApiModel(value = "导出")
public class OperationLogExportVO {
    /**
     * 标题
     */
    @ExcelProperty("标题")
    private String title;
    /**
     * 操作模块
     */
    @ExcelProperty("操作模块")
    private String module;
    /**
     * 操作内容
     */
    @ExcelProperty("操作内容")
    private String content;
    /**
     * 操作类型
     */
    @ExcelProperty("操作类型")
    private String type;
    /**
     * 操作IP
     */
    @ExcelProperty("操作IP")
    private String operateIp;
    /**
     * 操作地
     */
    @ExcelProperty("操作地")
    private String operatePlace;
    /**
     * 耗时
     */
    @ExcelProperty("耗时")
    private Integer time;
    /**
     * 错误信息
     */
    @ExcelProperty("错误信息")
    private String errorMsg;

}