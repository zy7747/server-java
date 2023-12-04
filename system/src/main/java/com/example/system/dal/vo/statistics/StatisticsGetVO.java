package com.example.system.dal.vo.statistics;

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
     * 视频类型统计
     */
    @ApiModelProperty(value = "视频类型统计")
    private Object videoType;
}
