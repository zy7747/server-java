package com.example.system.dal.vo.user;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserBaseInfoVO {
    /**
     * id
     */
    @TableId
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
