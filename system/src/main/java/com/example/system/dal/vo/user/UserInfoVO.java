package com.example.system.dal.vo.user;

import com.example.system.dal.entity.MenuEntity;
import com.example.system.dal.entity.RoleEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
@ApiModel(value = "登录信息")
public class UserInfoVO {
    @ApiModelProperty(value = "token")
    private String token;

    @ApiModelProperty(value = "用户信息")
    private UserBaseInfoVO userInfo;

    @ApiModelProperty(value = "角色列表")
    private List<RoleEntity> roles;

    @ApiModelProperty(value = "菜单列表")
    private List<MenuEntity> menuList;
}
