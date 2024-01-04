package com.example.system.dal.dto.operationLog;

import com.example.framework.dal.dto.PageParamsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@ApiModel(value = "分页查询条件")
@EqualsAndHashCode(callSuper = true)
public class OperationLogQueryDTO extends PageParamsDTO {

    /**
     * 标题
     */
    @ApiModelProperty(value = "标题")
    private String title;
    /**
     * 操作模块
     */
    @ApiModelProperty(value = "操作模块")
    private String module;
    /**
     * 操作内容
     */
    @ApiModelProperty(value = "操作内容")
    private String content;
    /**
     * 操作类型
     */
    @ApiModelProperty(value = "操作类型")
    private String type;
    /**
     * 操作IP
     */
    @ApiModelProperty(value = "操作IP")
    private String operateIp;
    /**
     * 操作地
     */
    @ApiModelProperty(value = "操作地")
    private String operatePlace;
    /**
     * 耗时
     */
    @ApiModelProperty(value = "耗时")
    private Integer time;
    /**
     * 错误信息
     */
    @ApiModelProperty(value = "错误信息")
    private String errorMsg;
}