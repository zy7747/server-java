package com.example.system.dal.dto.user;

import com.example.framework.dal.dto.PageParamsDTO;
import com.example.system.annotation.Dict;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ApiModel(value = "分页查询条件")
@EqualsAndHashCode(callSuper = true)
public class UserQueryDTO extends PageParamsDTO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)//雪花算法丢失精度问题
    @ApiModelProperty(value = "id")
    private Long id;
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
}
