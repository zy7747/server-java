package com.example.system.dal.vo.role;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "导出")
public class RoleExportVO {
    /**
     * 角色名称
     */
    @ExcelProperty("角色名称")
    private String roleName;

}
