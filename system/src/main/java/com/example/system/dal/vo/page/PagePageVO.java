package com.example.system.dal.vo.page;

import com.example.framework.dal.vo.BaseParamsVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@ApiModel(value = "分页查询结果")
@EqualsAndHashCode(callSuper = true)
public class PagePageVO extends BaseParamsVO {
    /**
     * 页面id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)//雪花算法丢失精度问题
    @ApiModelProperty(value = "页面id")
    private Long menuId;
    /**
     * 页面内容
     */
    @ApiModelProperty(value = "页面内容")
    private String content;
}