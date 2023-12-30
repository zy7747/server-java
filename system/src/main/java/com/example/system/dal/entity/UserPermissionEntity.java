package com.example.system.dal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName(value = "user_permission")
@ApiModel(value = "用户权限关联表")
public class UserPermissionEntity {
    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Long userId;
    /**
     * 权限id
     */
    @ApiModelProperty(value = "权限id")
    private Long permissionId;
}
