package com.example.system.dal.dto.page;

import com.example.framework.dal.dto.PageParamsDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@ApiModel(value = "分页查询条件")
@EqualsAndHashCode(callSuper = true)
public class PageQueryDTO extends PageParamsDTO {
    /**
     * 页面id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)//雪花算法丢失精度问题
    @ApiModelProperty(value = "页面id")
    private Long menuId;
    /**
     * 标题
     */
    @ApiModelProperty(value = "标题")
    private String title;
    /**
     * 接口
     */
    @ApiModelProperty(value = "接口")
    private String api;
    /**
     * 权限
     */
    @ApiModelProperty(value = "权限")
    private String permission;
    /**
     * 页面内容
     */
    @ApiModelProperty(value = "页面内容")
    private String content;
}