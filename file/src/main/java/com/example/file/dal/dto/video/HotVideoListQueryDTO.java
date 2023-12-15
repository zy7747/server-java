package com.example.file.dal.dto.video;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class HotVideoListQueryDTO {
    @ApiModelProperty(value = "所有集合")
    private Map<String, Object> all = new HashMap<>();

    @ApiModelProperty(value = "动漫集合")
    private Map<String, Object> anime = new HashMap<>();

    @ApiModelProperty(value = "电影集合")
    private Map<String, Object> movie = new HashMap<>();

    @ApiModelProperty(value = "综艺集合")
    private Map<String, Object> variety = new HashMap<>();

    @ApiModelProperty(value = "电视剧集合")
    private Map<String, Object> tv = new HashMap<>();

    @ApiModelProperty(value = "原创视频集合")
    private Map<String, Object> original = new HashMap<>();

    @ApiModelProperty(value = "短视频集合")
    private Map<String, Object> shorts = new HashMap<>();
}