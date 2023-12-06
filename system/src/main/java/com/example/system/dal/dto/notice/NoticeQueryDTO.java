package com.example.system.dal.dto.notice;

import com.example.framework.dal.dto.PageParamsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@ApiModel(value = "分页查询条件")
@EqualsAndHashCode(callSuper = true)
public class NoticeQueryDTO extends PageParamsDTO {
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