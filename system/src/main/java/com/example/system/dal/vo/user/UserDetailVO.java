package com.example.system.dal.vo.user;

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
public class UserDetailVO extends BaseParamsVO {
    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private String uid;
    /**
     * 电话号码
     */
    @ApiModelProperty(value = "电话号码")
    private String phone;
    /**
     * 电子邮箱
     */
    @ApiModelProperty(value = "电子邮箱")
    private String email;
    /**
     * 账号
     */
    @ApiModelProperty(value = "账号")
    private String account;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String user;


    /**
     * 头像
     */
    @ApiModelProperty(value = "头像")
    private String avatar;

    /**
     * 用户类型
     */
    @ApiModelProperty(value = "用户类型")
    private String userType;


    /**
     * 角色
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)//雪花算法丢失精度问题
    @ApiModelProperty(value = "角色")
    private ArrayList<Long> roles;

    /**
     * 权限
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)//雪花算法丢失精度问题
    @ApiModelProperty(value = "权限")
    private ArrayList<Long> permissions;
}
