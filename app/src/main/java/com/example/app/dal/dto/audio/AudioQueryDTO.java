package com.example.app.dal.dto.audio;

import com.example.framework.dal.dto.PageParamsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@ApiModel(value = "分页查询条件")
@EqualsAndHashCode(callSuper = true)
public class AudioQueryDTO extends PageParamsDTO {
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
    private String videoType;
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
     * 点赞量
     */
    @ApiModelProperty(value = "点赞量")
    private Integer starsNum;
    /**
     * 收藏量
     */
    @ApiModelProperty(value = "收藏量")
    private Integer collectionNum;
    /**
     * 播放量
     */
    @ApiModelProperty(value = "播放量")
    private Integer playNum;

}