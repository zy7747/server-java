package com.example.system.dal.vo.permission;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "导出")
public class PermissionExportVO {
    /**
     * 父节点id
     */
    @ExcelProperty("父节点id")
    private Long parentId;
    /**
     * 权限名称
     */
    @ExcelProperty("权限名称")
    private String name;
    /**
     * 权限编码
     */
    @ExcelProperty("权限编码")
    private String code;
    /**
     * 权限标识
     */
    @ExcelProperty("权限标识")
    private String permission;
    /**
     * 类型
     */
    @ExcelProperty("类型")
    private String type;
    /**
     * 排序
     */
    @ExcelProperty("排序")
    private Integer sort;
    /**
     * 是否可见
     */
    @ExcelProperty("是否可见")
    private Integer visible;
    /**
     * 图标
     */
    @ExcelProperty("图标")
    private String icon;
    /**
     * 描述
     */
    @ExcelProperty("描述")
    private String description;
}