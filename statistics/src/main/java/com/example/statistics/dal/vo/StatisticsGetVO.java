package com.example.statistics.dal.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "数据统计")
public class StatisticsGetVO {
    /**
     * 用户总数
     */
    @ApiModelProperty(value = "用户总数")
    private Integer userTotal;

    /**
     * 视频总数
     */
    @ApiModelProperty(value = "视频总数")
    private Integer videoTotal;

    /**
     * 人员总数
     */
    @ApiModelProperty(value = "人员总数")
    private Integer personTotal;

    /**
     * 文件总数
     */
    @ApiModelProperty(value = "文件总数")
    private Integer fileTotal;

    /**
     * 视频类型统计
     */
    @ApiModelProperty(value = "视频类型统计")
    private Object videoType;

    /**
     * 文件类型统计
     */
    @ApiModelProperty(value = "文件类型统计")
    private Object fileType;

    /**
     * 用户性别统计
     */
    @ApiModelProperty(value = "用户性别统计")
    private Object sex;

}

