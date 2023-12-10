package com.example.system.dal.dto.log;

import com.example.framework.dal.dto.PageParamsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@ApiModel(value = "分页查询条件")
@EqualsAndHashCode(callSuper = true)
public class LogQueryDTO extends PageParamsDTO {

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