package com.example.system.dal.dto.user;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel(value = "修改密码")
public class ChangePasswordDTO {
    @ApiModelProperty(value = "id")
    @TableId
    @JsonFormat(shape = JsonFormat.Shape.STRING)//雪花算法丢失精度问题
    private Long id;

    @NotBlank(message = "账号不能为空！")
    @ApiModelProperty(value = "账号")
    private String account;

    @NotBlank(message = "旧密码不能为空！")
    @ApiModelProperty(value = "旧密码")
    private String oldPassword;

    @NotBlank(message = "新密码不能为空！")
    @ApiModelProperty(value = "新密码")
    private String newPassword;
}
