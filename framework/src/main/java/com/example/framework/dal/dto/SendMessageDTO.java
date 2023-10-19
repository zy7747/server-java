package com.example.framework.dal.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SendMessageDTO {
    /**
     * 发送对象id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)//雪花算法丢失精度问题
    @ApiModelProperty(value = "用户id")
    private Long userId;
    /**
     * 发送内容
     */
    @ApiModelProperty(value = "message")
    private String message;
}
