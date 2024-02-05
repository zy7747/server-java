package com.example.system.dal.dto.person;

import com.example.framework.dal.dto.BaseParamsDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ApiModel(value = "修改")
@EqualsAndHashCode(callSuper = true)
public class PersonSaveDTO extends BaseParamsDTO {
    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Long userId;
    /**
     * 照片
     */
    @ApiModelProperty(value = "照片")
    private String photo;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String name;
    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    private String sex;
    /**
     * 职业
     */
    @ApiModelProperty(value = "职业")
    private String profession;
    /**
     * 国家
     */
    @ApiModelProperty(value = "国家")
    private String nation;
    /**
     * 籍贯
     */
    @ApiModelProperty(value = "籍贯")
    private String origin;
    /**
     * 住址
     */
    @ApiModelProperty(value = "住址")
    private String address;
    /**
     * 最高学历
     */
    @ApiModelProperty(value = "最高学历")
    private String degree;
    /**
     * 身高
     */
    @ApiModelProperty(value = "身高")
    private String height;
    /**
     * 体重
     */
    @ApiModelProperty(value = "体重")
    private String weight;
    /**
     * 爱好
     */
    @ApiModelProperty(value = "爱好")
    private String hobby;
    /**
     * 年龄
     */
    @ApiModelProperty(value = "年龄")
    private Integer age;
    /**
     * 身份证号码
     */
    @ApiModelProperty(value = "身份证号码")
    private String idCard;
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
     * 出生日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "出生日期")
    private Date birthDate;
}
