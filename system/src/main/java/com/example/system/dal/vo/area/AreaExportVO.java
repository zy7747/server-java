package com.example.system.dal.vo.area;

import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "导出")
public class AreaExportVO {
    /**
     * 父节点id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)//雪花算法丢失精度问题
    @ExcelProperty("父节点id")
    private Long parentId;
    /**
     * 名称
     */
    @ExcelProperty("名称")
    private String areaName;
    /**
     * 地址
     */
    @ExcelProperty("地址")
    private String address;
    /**
     * 别称
     */
    @ExcelProperty("别称")
    private String otherName;
    /**
     * 区域类型
     */
    @ExcelProperty("区域类型")
    private String type;
    /**
     * 区域编码
     */
    @ExcelProperty("区域编码")
    private String code;
    /**
     * 坐标
     */
    @ExcelProperty("坐标")
    private String axis;
    /**
     * 面积
     */
    @ExcelProperty("面积")
    private String acreage;
    /**
     * 人口
     */
    @ExcelProperty("人口")
    private String population;
    /**
     * 气候
     */
    @ExcelProperty("气候")
    private String climate;
    /**
     * 首都
     */
    @ExcelProperty("首都")
    private String capital;
    /**
     * 排序
     */
    @ExcelProperty("排序")
    private Integer sort;
    /**
     * 层级
     */
    @ExcelProperty(value = "层级")
    private Integer level;
    /**
     * 地区图标
     */
    @ExcelProperty("地区图标")
    private String icon;
    /**
     * 描述
     */
    @ExcelProperty("描述")
    private String description;
}
