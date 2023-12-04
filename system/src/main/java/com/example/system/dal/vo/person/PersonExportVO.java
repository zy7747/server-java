package com.example.system.dal.vo.person;

import com.alibaba.excel.annotation.ExcelProperty;
import com.example.framework.dal.vo.ExcelParamsVO;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@ApiModel(value = "导出")
@EqualsAndHashCode(callSuper = true)
public class PersonExportVO extends ExcelParamsVO {

    /**
     * 用户id
     */
    @ExcelProperty("用户id")
    private Long userId;
    /**
     * 照片
     */
    @ExcelProperty("照片")
    private String photo;
    /**
     * 姓名
     */
    @ExcelProperty("姓名")
    private String name;
    /**
     * 性别
     */
    @ExcelProperty("性别")
    private String sex;
    /**
     * 职业
     */
    @ExcelProperty("职业")
    private String profession;
    /**
     * 国家
     */
    @ExcelProperty("国家")
    private String nation;
    /**
     * 籍贯
     */
    @ExcelProperty("籍贯")
    private String origin;
    /**
     * 住址
     */
    @ExcelProperty("住址")
    private String address;
    /**
     * 最高学历
     */
    @ExcelProperty("最高学历")
    private String degree;
    /**
     * 身高
     */
    @ExcelProperty("身高")
    private String height;
    /**
     * 体重
     */
    @ExcelProperty("体重")
    private String weight;
    /**
     * 爱好
     */
    @ExcelProperty("爱好")
    private String hobby;
    /**
     * 年龄
     */
    @ExcelProperty("年龄")
    private Integer age;
    /**
     * 身份证号码
     */
    @ExcelProperty("身份证号码")
    private String idCard;
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
     * 出生日期
     */
    @ExcelProperty("出生日期")
    private Date birthDate;
}
