package com.example.system.dal.vo.role;

import com.alibaba.excel.annotation.ExcelProperty;
import com.example.framework.dal.vo.ExcelParamsVO;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@ApiModel(value = "导出")
@EqualsAndHashCode(callSuper = true)
public class RoleExportVO extends ExcelParamsVO {
    /**
     * 角色名称
     */
    @ExcelProperty("角色名称")
    private String roleName;

}
