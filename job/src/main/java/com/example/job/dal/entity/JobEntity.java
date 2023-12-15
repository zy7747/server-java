package com.example.job.dal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.framework.dal.entity.BaseParamsEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@TableName(value = "job")
@ApiModel(value = "定时任务")
@EqualsAndHashCode(callSuper = true)
public class JobEntity extends BaseParamsEntity {
    /**
     * 任务名称
     */
    @ApiModelProperty(value = "任务名称")
    private String jobName;
    /**
     * 任务编码
     */
    @ApiModelProperty(value = "任务编码")
    private String jobCode;
    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间")
    private Date startTime;
    /**
     * 执行次数
     */
    @ApiModelProperty(value = "执行次数")
    private Integer executeCount;
    /**
     * 执行间隔
     */
    @ApiModelProperty(value = "执行间隔")
    private Long executeInterval;

}
