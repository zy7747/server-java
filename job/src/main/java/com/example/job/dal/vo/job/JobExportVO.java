package com.example.job.dal.vo.job;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "导出")
public class JobExportVO {
    @ExcelProperty("任务名称")
    private String jobName;
    /**
     * 任务编码
     */
    @ExcelProperty("任务编码")
    private String jobCode;
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
