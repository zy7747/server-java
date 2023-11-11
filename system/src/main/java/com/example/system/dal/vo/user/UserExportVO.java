package com.example.system.dal.vo.user;

import com.alibaba.excel.annotation.ExcelProperty;
import com.example.framework.dal.vo.ExcelParamsVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@ApiModel(value = "导出")
@EqualsAndHashCode(callSuper = true)
public class UserExportVO extends ExcelParamsVO {
    /**
     * 用户id
     */
    @ExcelProperty("用户id")
    private Long uid;
    /**
     * 电话号码
     */
    @ExcelProperty("电话号码")
    private String phone;
    /**
     * 电子邮箱
     */
    @ExcelProperty("电子邮箱")
    private String email;
    /**
     * 账号
     */
    @ExcelProperty("账号")
    private String account;
    /**
     * 密码
     */
    @ExcelProperty("密码")
    private String password;
    /**
     * 用户名
     */
    @ExcelProperty("用户名")
    private String user;
    /**
     * 真实姓名
     */
    @ExcelProperty("真实姓名")
    private String name;
    /**
     * 身份证号码
     */
    @ExcelProperty("身份证号码")
    private String idCard;
    /**
     * 头像
     */
    @ExcelProperty("头像")
    private String avatar;
    /**
     * 性别
     */
    @ExcelProperty("性别")
    private String sex;
    /**
     * 用户类型
     */
    @ExcelProperty("用户类型")
    private String userType;
    /**
     * 年龄
     */
    @ExcelProperty("年龄")
    private Integer age;
    /**
     * 出生日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ExcelProperty("出生日期")
    private Date birthDate;
}
