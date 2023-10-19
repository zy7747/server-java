package com.example.system.dal.dto.dict;

import com.example.framework.dal.dto.PageParamsDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@ApiModel(value = "分页查询条件")
@EqualsAndHashCode(callSuper = true)
public class DictQueryDTO extends PageParamsDTO {
    /**
     * 父节点id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)//雪花算法丢失精度问题
    @ApiModelProperty(value = "父节点id")
    private Long parentId;
    /**
     * 字典名称
     */
    @ApiModelProperty(value = "字典名称")
    private String dictName;
    /**
     * 字典编码
     */
    @ApiModelProperty(value = "字典编码")
    private String dictCode;
    /**
     * 字典类型
     */
    @ApiModelProperty(value = "字典类型")
    private String dictType;
    /**
     * 名
     */
    @ApiModelProperty(value = "名")
    private String label;
    /**
     * 值
     */
    @ApiModelProperty(value = "值")
    private String value;
    /**
     * 自定义颜色
     */
    @ApiModelProperty(value = "自定义颜色")
    private String color;
    /**
     * 自定义CSS样式
     */
    @ApiModelProperty(value = "自定义CSS样式")
    private String css;
    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sort;
    /**
     * 其他参数
     */
    @ApiModelProperty(value = "其他参数")
    private String params;
}
