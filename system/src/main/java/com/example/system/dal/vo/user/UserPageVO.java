package com.example.system.dal.vo.user;

import com.example.framework.dal.vo.BaseParamsVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Date;

@Data
@ApiModel(value = "分页查询结果")
@EqualsAndHashCode(callSuper = true)
public class UserPageVO extends BaseParamsVO {
    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Long uid;
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
     * 真实姓名
     */
    @ApiModelProperty(value = "真实姓名")
    private String name;
    /**
     * 身份证号码
     */
    @ApiModelProperty(value = "身份证号码")
    private String idCard;
    /**
     * 头像
     */
    @ApiModelProperty(value = "头像")
    private String avatar;
    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    private String sex;
    /**
     * 用户类型
     */
    @ApiModelProperty(value = "用户类型")
    private String userType;
    /**
     * 年龄
     */
    @ApiModelProperty(value = "年龄")
    private Integer age;
    /**
     * 出生日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "出生日期")
    private Date birthDate;
    /**
     * 角色
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)//雪花算法丢失精度问题
    @ApiModelProperty(value = "角色")
    private ArrayList<Long> roles;
}
