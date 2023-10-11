package com.example.system.dal.vo.menu;

import com.alibaba.excel.annotation.ExcelProperty;
import com.example.framework.dal.vo.ExcelParamsVO;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@ApiModel(value = "导出")
@EqualsAndHashCode(callSuper = true)
public class MenuExportVO extends ExcelParamsVO {
    /**
     * id
     */
    @ExcelProperty("id")
    private Long id;
    /**
     * 父节点id
     */
    @ExcelProperty("父节点id")
    private Long parentId;
    /**
     * 名称
     */
    @ExcelProperty(value = "菜单名")
    private String title;
    /**
     * 名称
     */
    @ExcelProperty(value = "组件名")
    private String name;
    /**
     * 路由路径
     */
    @ExcelProperty("路由路径")
    private String path;
    /**
     * 类型
     */
    @ExcelProperty("类型")
    private String type;
    /**
     * 组件
     */
    @ExcelProperty("组件")
    private String component;
    /**
     * 权限标识
     */
    @ExcelProperty("权限标识")
    private String permission;
    /**
     * 层级
     */
    @ExcelProperty("层级")
    private Integer level;
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
     * 是否缓存
     */
    @ExcelProperty("是否缓存")
    private Integer keepAlive;
    /**
     * 是否总是显示
     */
    @ExcelProperty("是否总是显示")
    private Integer alwaysShow;
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
    /**
     * 其他信息
     */
    @ExcelProperty("其他信息")
    private String meta;
}
