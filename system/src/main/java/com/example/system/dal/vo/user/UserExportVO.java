package com.example.system.dal.vo.user;

import com.alibaba.excel.annotation.ExcelProperty;
import com.example.framework.dal.vo.ExcelParamsVO;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@ApiModel(value = "导出")
@EqualsAndHashCode(callSuper = true)
public class UserExportVO extends ExcelParamsVO {
    /**
     * 用户id
     */
    @ExcelProperty("用户id")
    private String uid;
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
     * 头像
     */
    @ExcelProperty("头像")
    private String avatar;
    /**
     * 用户类型
     */
    @ExcelProperty("用户类型")
    private String userType;
}
