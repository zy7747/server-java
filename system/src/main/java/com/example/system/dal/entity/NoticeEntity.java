package com.example.system.dal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.framework.dal.entity.BaseParamsEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@TableName(value = "notice")
@ApiModel(value = "消息通知")
@EqualsAndHashCode(callSuper = true)
public class NoticeEntity extends BaseParamsEntity {
    /**
     * 消息名称
     */
    @ApiModelProperty(value = "消息名称")
    private String noticeName;
    /**
     * 消息内容
     */
    @ApiModelProperty(value = "消息内容")
    private String noticeContent;
    /**
     * 推送模块
     */
    @ApiModelProperty(value = "推送模块")
    private String pushModule;
    /**
     * 类型
     */
    @ApiModelProperty(value = "类型")
    private String type;
    /**
     * 是否已读
     */
    @ApiModelProperty(value = "是否已读")
    private String isRead;
}