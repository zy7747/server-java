package com.example.system.dal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.framework.dal.entity.BaseParamsEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@TableName(value = "permission")
@ApiModel(value = "权限")
@EqualsAndHashCode(callSuper = true)
public class PermissionEntity extends BaseParamsEntity {

    /**
     * 父节点id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)//雪花算法丢失精度问题
    @ApiModelProperty(value = "父节点id")
    private Long parentId;
    /**
     * 权限名称
     */
    @ApiModelProperty(value = "权限名称")
    private String name;
    /**
     * 权限编码
     */
    @ApiModelProperty(value = "权限编码")
    private String code;
    /**
     * 权限标识
     */
    @ApiModelProperty(value = "权限标识")
    private String permission;
    /**
     * 类型
     */
    @ApiModelProperty(value = "类型")
    private String type;
    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sort;
    /**
     * 是否可见
     */
    @ApiModelProperty(value = "是否可见")
    private Integer visible;
    /**
     * 图标
     */
    @ApiModelProperty(value = "图标")
    private String icon;
    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String description;

}