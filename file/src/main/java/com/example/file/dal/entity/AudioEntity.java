package com.example.file.dal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.framework.dal.entity.BaseParamsEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
@TableName(value = "audio")
@ApiModel(value = "音频")
@EqualsAndHashCode(callSuper = true)
public class AudioEntity extends BaseParamsEntity {

    /**
     * 音频名称
     */
    @ApiModelProperty(value = "音频名称")
    private String audioName;
    /**
     * 音频标题
     */
    @ApiModelProperty(value = "音频标题")
    private String title;
    /**
     * 音频分类
     */
    @ApiModelProperty(value = "音频分类")
    private String type;
    /**
     * 音频存储节点
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)//雪花算法丢失精度问题
    @ApiModelProperty(value = "音频存储节点")
    private Long savePath;
    /**
     * 音频地区
     */
    @ApiModelProperty(value = "音频地区")
    private String region;
    /**
     * url地址
     */
    @ApiModelProperty(value = "url地址")
    private String url;
    /**
     * 音频图片
     */
    @ApiModelProperty(value = "音频图片")
    private String picture;
    /**
     * 音频类型
     */
    @ApiModelProperty(value = "音频类型")
    private String audioType;
    /**
     * 音频简介
     */
    @ApiModelProperty(value = "音频简介")
    private String profile;
    /**
     * 标签
     */
    @ApiModelProperty(value = "标签")
    private String label;
    /**
     * 歌手名称
     */
    @ApiModelProperty(value = "歌手名称")
    private String singer;
    /**
     * 作词
     */
    @ApiModelProperty(value = "作词")
    private String lyricist;
    /**
     * 作曲
     */
    @ApiModelProperty(value = "作曲")
    private String composing;
    /**
     * 歌词
     */
    @ApiModelProperty(value = "歌词")
    private String lyrics;
    /**
     * 时长
     */
    @ApiModelProperty(value = "时长")
    private Integer duration;
    /**
     * 播放量
     */
    @ApiModelProperty(value = "播放量")
    private Integer playNum;
    /**
     * 创作年份
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "创作年份")
    private Date createYear;
}