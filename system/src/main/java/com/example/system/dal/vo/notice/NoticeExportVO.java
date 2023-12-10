package com.example.system.dal.vo.notice;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "导出")
public class NoticeExportVO {
    /**
     * 消息名称
     */
    @ExcelProperty("消息名称")
    private String noticeName;
    /**
     * 消息内容
     */
    @ExcelProperty("消息内容")
    private String noticeContent;
    /**
     * 推送模块
     */
    @ExcelProperty("推送模块")
    private String pushModule;
    /**
     * 类型
     */
    @ExcelProperty("类型")
    private String type;
    /**
     * 是否已读
     */
    @ExcelProperty("是否已读")
    private String isRead;
    /**
     * 接收人
     */
    @ExcelProperty("接收人")
    private String receiver;

}