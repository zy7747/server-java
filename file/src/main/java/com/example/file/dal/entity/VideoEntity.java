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
@TableName(value = "video")
@ApiModel(value = "视频")
@EqualsAndHashCode(callSuper = true)
public class VideoEntity extends BaseParamsEntity {
    /**
     * 父节点id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)//雪花算法丢失精度问题
    @ApiModelProperty(value = "父节点id")
    private Long parentId;
    /**
     * 视频名称
     */
    @ApiModelProperty(value = "视频名称")
    private String videoName;
    /**
     * 视频标题
     */
    @ApiModelProperty(value = "视频标题")
    private String title;
    /**
     * 视频分类
     */
    @ApiModelProperty(value = "视频分类")
    private String type;
    /**
     * 视频地区
     */
    @ApiModelProperty(value = "视频地区")
    private String region;
    /**
     * url地址
     */
    @ApiModelProperty(value = "url地址")
    private String url;
    /**
     * 视频图片
     */
    @ApiModelProperty(value = "视频图片")
    private String picture;
    /**
     * 视频类型
     */
    @ApiModelProperty(value = "视频类型")
    private String videoType;
    /**
     * 视频简介
     */
    @ApiModelProperty(value = "视频简介")
    private String profile;
    /**
     * 标签
     */
    @ApiModelProperty(value = "标签")
    private String label;
    /**
     * 作者
     */
    @ApiModelProperty(value = "作者")
    private String author;
    /**
     * 季
     */
    @ApiModelProperty(value = "季")
    private Integer season;
    /**
     * 集
     */
    @ApiModelProperty(value = "集")
    private Integer episode;
    /**
     * 时长
     */
    @ApiModelProperty(value = "时长")
    private Integer duration;
    /**
     * 视频存储节点
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)//雪花算法丢失精度问题
    @ApiModelProperty(value = "视频存储节点")
    private Long savePath;
    /**
     * 是否是集合
     */
    @ApiModelProperty(value = "是否是集合")
    private Integer isCollection;
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
