package com.example.system.dal.dto.notice;

import com.example.framework.dal.dto.BaseParamsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;

@Data
@ApiModel(value = "修改")
@EqualsAndHashCode(callSuper = true)
public class NoticeSaveDTO extends BaseParamsDTO {
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
    /**
     * 接收人
     */
    @ApiModelProperty(value = "接收人")
    private ArrayList<String> receiverList;
}