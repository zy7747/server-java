package com.example.system.dal.vo.job;

import com.alibaba.excel.annotation.ExcelProperty;
import com.example.framework.dal.vo.ExcelParamsVO;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@ApiModel(value = "导出")
@EqualsAndHashCode(callSuper = true)
public class JobExportVO extends ExcelParamsVO {
    @ExcelProperty("任务名称")
    private String jobName;
    /**
     * 开始时间
     */
    @ExcelProperty("开始时间")
    private Date startTime;
    /**
     * 执行次数
     */
    @ExcelProperty("执行次数")
    private Integer executeCount;
    /**
     * 执行间隔
     */
    @ExcelProperty("执行间隔")
    private Long executeInterval;
}
