package com.example.file.dal.vo.video;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "导出")
public class VideoExportVO {
    /**
     * 视频名称
     */
    @ExcelProperty("视频名称")
    private String videoName;
    /**
     * 视频标题
     */
    @ExcelProperty("视频标题")
    private String title;
    /**
     * 视频分类
     */
    @ExcelProperty("视频分类")
    private String type;
    /**
     * 视频地区
     */
    @ExcelProperty("视频地区")
    private String region;
    /**
     * url地址
     */
    @ExcelProperty("url地址")
    private String url;
    /**
     * 视频图片
     */
    @ExcelProperty("视频图片")
    private String picture;
    /**
     * 视频类型
     */
    @ExcelProperty("视频类型")
    private String videoType;
    /**
     * 视频简介
     */
    @ExcelProperty("视频简介")
    private String profile;
    /**
     * 标签
     */
    @ExcelProperty("标签")
    private String label;
    /**
     * 作者名称
     */
    @ExcelProperty("作者名称")
    private String author;
    /**
     * 季
     */
    @ExcelProperty("季")
    private Integer season;
    /**
     * 集
     */
    @ExcelProperty("集")
    private Integer episode;
    /**
     * 时长
     */
    @ExcelProperty("时长")
    private Integer duration;
    /**
     * 播放量
     */
    @ExcelProperty("播放量")
    private Integer playNum;

}