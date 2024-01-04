package com.example.system.dal.dto.area;

import com.example.framework.dal.dto.BaseParamsDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@ApiModel(value = "修改")
@EqualsAndHashCode(callSuper = true)
public class AreaSaveDTO extends BaseParamsDTO {
    /**
     * 父节点id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)//雪花算法丢失精度问题
    @ApiModelProperty(value = "父节点id")
    private Long parentId;
    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;
    /**
     * 中文名称
     */
    @ApiModelProperty(value = "中文名称")
    private String cname;
    /**
     * 全称
     */
    @ApiModelProperty(value = "全称")
    private String fullName;
    /**
     * 中文全称
     */
    @ApiModelProperty(value = "中文全称")
    private String fullCname;
    /**
     * 别称
     */
    @ApiModelProperty(value = "别称")
    private String otherName;
    /**
     * 地址
     */
    @ApiModelProperty(value = "地址")
    private String address;
    /**
     * 区域类型
     */
    @ApiModelProperty(value = "区域类型")
    private String type;
    /**
     * 区域编码
     */
    @ApiModelProperty(value = "区域编码")
    private String code;
    /**
     * 坐标
     */
    @ApiModelProperty(value = "坐标")
    private String axis;
    /**
     * 面积
     */
    @ApiModelProperty(value = "面积")
    private String acreage;
    /**
     * 人口
     */
    @ApiModelProperty(value = "人口")
    private String population;
    /**
     * 气候
     */
    @ApiModelProperty(value = "气候")
    private String climate;
    /**
     * 首都
     */
    @ApiModelProperty(value = "首都")
    private String capital;
    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sort;
    /**
     * 层级
     */
    @ApiModelProperty(value = "层级")
    private Integer level;
    /**
     * 地区图标
     */
    @ApiModelProperty(value = "地区图标")
    private String icon;
    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String description;
}
