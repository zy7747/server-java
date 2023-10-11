package com.example.system.dal.dto.user;

import com.example.framework.dal.dto.BaseParamsDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Date;

@Data
@ApiModel(value = "修改")
@EqualsAndHashCode(callSuper = true)
public class UserSaveDTO extends BaseParamsDTO {
    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Long uid;
    /**
     * 电话号码
     */
    @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号格式有误")
    @ApiModelProperty(value = "电话号码")
    private String phone;
    /**
     * 电子邮箱
     */
    @Email(message = "邮箱格式不对")
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
    @NotBlank(message = "用户名不能为空")
    @Length(max = 20, message = "用户名不能超过20个字符")
    @Pattern(regexp = "^[\\u4E00-\\u9FA5A-Za-z0-9\\*]*$", message = "用户昵称限制：最多20字符，包含文字、字母和数字")
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
     * 角色
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)//雪花算法丢失精度问题
    @ApiModelProperty(value = "角色")
    private ArrayList<Long> roles;
    /**
     * 出生日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "出生日期")
    private Date birthDate;

}
