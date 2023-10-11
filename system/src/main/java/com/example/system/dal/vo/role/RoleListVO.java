package com.example.system.dal.vo.role;

import com.example.framework.dal.vo.BaseParamsVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@ApiModel(value = "列表查询结果")
@EqualsAndHashCode(callSuper = true)
public class RoleListVO extends BaseParamsVO {
    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称")
    private String roleName;

    /**
     * 角色编码
     */
    @ApiModelProperty(value = "角色编码")
    private String roleCode;
}