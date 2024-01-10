package com.example.file.dal.vo.audio;

import com.alibaba.excel.annotation.ExcelProperty;
import com.example.framework.dal.vo.ExcelParamsVO;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@ApiModel(value = "导出")
public class AudioExportVO {

    /**
     * 音频名称
     */
    @ExcelProperty("音频名称")
    private String audioName;
    /**
     * 音频标题
     */
    @ExcelProperty("音频标题")
    private String title;
    /**
     * 音频分类
     */
    @ExcelProperty("音频分类")
    private String type;
    /**
     * 音频存储节点
     */
    @ExcelProperty("音频存储节点")
    private Long savePath;
    /**
     * 音频地区
     */
    @ExcelProperty("音频地区")
    private String region;
    /**
     * url地址
     */
    @ExcelProperty("url地址")
    private String url;
    /**
     * 音频图片
     */
    @ExcelProperty("音频图片")
    private String picture;
    /**
     * 音频类型
     */
    @ExcelProperty("音频类型")
    private String audioType;
    /**
     * 音频简介
     */
    @ExcelProperty("音频简介")
    private String profile;
    /**
     * 标签
     */
    @ExcelProperty("标签")
    private String label;
    /**
     * 歌手名称
     */
    @ExcelProperty("歌手名称")
    private String singer;
    /**
     * 作词
     */
    @ExcelProperty("作词")
    private String lyricist;
    /**
     * 作曲
     */
    @ExcelProperty("作曲")
    private String composing;
    /**
     * 歌词
     */
    @ExcelProperty("歌词")
    private String lyrics;
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