package com.example.system.dal.dto.role;

import com.example.framework.dal.dto.BaseParamsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;

@Data
@ApiModel(value = "修改")
@EqualsAndHashCode(callSuper = true)
public class RoleSaveDTO extends BaseParamsDTO {
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
    /**
     * 菜单列表
     */
    @ApiModelProperty(value = "菜单列表")
    private ArrayList<Long> menuList;
}

