package com.example.system.dal.vo.file;

import com.alibaba.excel.annotation.ExcelProperty;
import com.example.framework.dal.vo.ExcelParamsVO;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@ApiModel(value = "导出")
@EqualsAndHashCode(callSuper = true)
public class FileExportVO extends ExcelParamsVO {
    /**
     * 文件名称
     */
    @ExcelProperty("文件名称")
    private String fileName;
    /**
     * url地址
     */
    @ExcelProperty("url地址")
    private String url;
    /**
     * 文件类型
     */
    @ExcelProperty("文件类型")
    private String fileType;
    /**
     * 文件路径
     */
    @ExcelProperty("文件路径")
    private String filePath;
    /**
     * 文件大小
     */
    @ExcelProperty("文件大小")
    private Long fileSize;
}