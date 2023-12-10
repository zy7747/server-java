package com.example.system.dal.vo.log;

import com.alibaba.excel.annotation.ExcelProperty;
import com.example.framework.dal.vo.ExcelParamsVO;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@ApiModel(value = "导出")
public class LogExportVO {
    /**
     * 操作模块
     */
    @ExcelProperty("操作模块")
    private String operateModules;
    /**
     * 操作内容
     */
    @ExcelProperty("操作内容")
    private String operateContent;
    /**
     * 操作类型
     */
    @ExcelProperty("操作类型")
    private String operateType;
    /**
     * 操作地
     */
    @ExcelProperty("操作地")
    private String operatePlace;
    /**
     * 备注
     */
    @ExcelProperty("备注")
    private String remark;
    /**
     * 耗时
     */
    @ExcelProperty("耗时")
    private Integer time;
}