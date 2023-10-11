package com.example.system.dal.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel(value = "注册信息")
public class SignUpDTO {
    @NotBlank(message = "账号不能为空！")
    @ApiModelProperty(value = "账号")
    private String account;

    @ApiModelProperty(value = "用户id")
    private Long uid;

    @ApiModelProperty(value = "电话号码")
    private String phone;

    @ApiModelProperty(value = "电子邮箱")
    private String email;

    @NotBlank(message = "用户名不能为空！")
    @ApiModelProperty(value = "用户名")
    private String user;

    @NotBlank(message = "密码不能为空！")
    @ApiModelProperty(value = "密码")
    private String password;
}
