package com.example.system.dal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName(value = "user_role")
@ApiModel(value = "用户角色关联表")
public class UserRoleEntity {
    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Long userId;
    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色id")
    private Long roleId;
}
