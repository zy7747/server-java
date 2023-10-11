package com.example.system.dal.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "用户登录")
public class LoginDTO {
    @ApiModelProperty(value = "登录方式")
    private String loginType;

    @ApiModelProperty(value = "账号")
    private String account;

    @ApiModelProperty(value = "电话号码")
    private String phone;

    @ApiModelProperty(value = "用户名")
    private String user;

    @ApiModelProperty(value = "短信验证码")
    private String sms;

    @ApiModelProperty(value = "电子邮箱")
    private String email;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "验证码")
    private String code;

    @ApiModelProperty(value = "登录IP")
    private String loginIp;
}
