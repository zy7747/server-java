package com.example.system.dal.dto.file;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "文件上传入参")
public class FileUploadDTO {
    /**
     * 文件上传路径
     */
    @ApiModelProperty(value = "上传路径")
    private String path;

    /**
     * 父节点id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)//雪花算法丢失精度问题
    @ApiModelProperty(value = "父节点id")
    private Long parentId;
}
