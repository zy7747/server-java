package com.example.system.dal.dto.role;

import com.example.framework.dal.dto.PageParamsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@ApiModel(value = "分页查询条件")
@EqualsAndHashCode(callSuper = true)
public class RoleQueryDTO extends PageParamsDTO {
    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称")
    private String roleName;

    /**
     * 角色编码
     */
    @ApiModelProperty(value = "角色编码")
    private String roleCode;
}
