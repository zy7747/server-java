package com.example.system.dal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.framework.dal.entity.BaseParamsEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@TableName(value = "log")
@ApiModel(value = "日志")
@EqualsAndHashCode(callSuper = true)
public class LogEntity extends BaseParamsEntity {
    /**
     * 操作模块
     */
    @ApiModelProperty(value = "操作模块")
    private String operateModules;
    /**
     * 操作内容
     */
    @ApiModelProperty(value = "操作内容")
    private String operateContent;
    /**
     * 操作类型
     */
    @ApiModelProperty(value = "操作类型")
    private String operateType;
    /**
     * 操作地
     */
    @ApiModelProperty(value = "操作地")
    private String operatePlace;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;
    /**
     * 耗时
     */
    @ApiModelProperty(value = "耗时")
    private Integer time;
}