package com.example.system.dal.vo.role;

import com.example.framework.dal.vo.BaseParamsVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;

@Data
@ApiModel(value = "详情")
@EqualsAndHashCode(callSuper = true)
public class RoleDetailVO extends BaseParamsVO {
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
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty(value = "菜单列表")
    private ArrayList<Long> menuList;

}