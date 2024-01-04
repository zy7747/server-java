package com.example.system.dal.vo.area;

import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "导出")
public class AreaExportVO {
    /**
     * 名称
     */
    @ExcelProperty("名称")
    private String name;
    /**
     * 中文名称
     */
    @ExcelProperty("中文名称")
    private String cname;
    /**
     * 全称
     */
    @ExcelProperty("全称")
    private String fullName;
    /**
     * 中文全称
     */
    @ExcelProperty("中文全称")
    private String fullCname;
    /**
     * 别称
     */
    @ExcelProperty("别称")
    private String otherName;
    /**
     * 地址
     */
    @ExcelProperty("地址")
    private String address;
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
    @ExcelProperty("层级")
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
