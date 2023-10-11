package com.example.system.dal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName(value = "user_menu")
@ApiModel(value = "角色菜单关联表")
public class RoleMenuEntity {
    /**
     * 菜单id
     */
    @ApiModelProperty(value = "菜单id")
    private Long menuId;
    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色id")
    private Long roleId;
}
