package com.example.framework.dal.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "基础导出参数")
public class ExcelParamsVO {
    /**
     * id
     */
    @TableId
    @JsonFormat(shape = JsonFormat.Shape.STRING)//雪花算法丢失精度问题
    @ExcelProperty(value = "id")
    private Long id;
    /**
     * 状态
     */
    @ExcelProperty(value = "状态")
    private String status;
    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;
    /**
     * 创建人
     */
    @ExcelProperty(value = "创建人")
    private String creator;
    /**
     * 更新人
     */
    @ExcelProperty(value = "更新人")
    private String updater;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ExcelProperty(value = "创建时间")
    private Date createTime;
    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ExcelProperty(value = "更新时间")
    private Date updateTime;
    /**
     * 是否删除
     */
    @ExcelProperty(value = "是否删除")
    private Integer isDeleted;
}
