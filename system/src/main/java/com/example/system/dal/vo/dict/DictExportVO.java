package com.example.system.dal.vo.dict;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@ApiModel(value = "导出")
public class DictExportVO {
    /**
     * 父节点id
     */
    @ExcelProperty("父节点id")
    private Long parentId;
    /**
     * 字典名称
     */
    @ExcelProperty("字典名称")
    private String dictName;
    /**
     * 字典编码
     */
    @ExcelProperty("字典编码")
    private String dictCode;
    /**
     * 字典类型
     */
    @ExcelProperty("字典类型")
    private String dictType;
    /**
     * 名
     */
    @ExcelProperty("名")
    private String label;
    /**
     * 值
     */
    @ExcelProperty("值")
    private String value;
    /**
     * 自定义颜色
     */
    @ExcelProperty("自定义颜色")
    private String color;
    /**
     * 自定义CSS样式
     */
    @ExcelProperty("自定义CSS样式")
    private String css;
    /**
     * 排序
     */
    @ExcelProperty("排序")
    private Integer sort;
    /**
     * 其他参数
     */
    @ExcelProperty("其他参数")
    private String params;

}
