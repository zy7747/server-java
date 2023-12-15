package com.example.system.mapper;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.framework.common.PageList;
import com.example.system.dal.dto.permission.PermissionQueryDTO;
import com.example.system.dal.entity.PermissionEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissionMapper extends BaseMapper<PermissionEntity> {
    default QueryWrapper<PermissionEntity> search(PermissionQueryDTO permission) {
        QueryWrapper<PermissionEntity> wrapper = new QueryWrapper<>();

        /* 权限名称 */
        if (!StrUtil.hasBlank(permission.getName())) {
            wrapper.eq("name", permission.getName());
        }
        /* 权限编码 */
        if (!StrUtil.hasBlank(permission.getCode())) {
            wrapper.eq("code", permission.getCode());
        }
        /* 权限标识 */
        if (!StrUtil.hasBlank(permission.getPermission())) {
            wrapper.eq("permission", permission.getPermission());
        }
        /* 类型 */
        if (!StrUtil.hasBlank(permission.getType())) {
            wrapper.eq("type", permission.getType());
        }
        /* 图标 */
        if (!StrUtil.hasBlank(permission.getIcon())) {
            wrapper.eq("icon", permission.getIcon());
        }
        /* 描述 */
        if (!StrUtil.hasBlank(permission.getDescription())) {
            wrapper.eq("description", permission.getDescription());
        }
        /* 状态 */
        if (!StrUtil.hasBlank(permission.getStatus())) {
            wrapper.eq("status", permission.getStatus());
        }
        /* 备注 */
        if (!StrUtil.hasBlank(permission.getRemark())) {
            wrapper.eq("remark", permission.getRemark());
        }
        /* 创建人 */
        if (!StrUtil.hasBlank(permission.getCreator())) {
            wrapper.eq("creator", permission.getCreator());
        }
        /* 更新人 */
        if (!StrUtil.hasBlank(permission.getUpdater())) {
            wrapper.eq("updater", permission.getUpdater());
        }
        wrapper.orderByDesc("create_time");
        return wrapper;
    }

    /**
     * 分页查询
     */
    default PageList<PermissionEntity> selectPageList(PermissionQueryDTO permission) {
        IPage<PermissionEntity> pageParams = new Page<>(permission.getPage(), permission.getSize());
        return PageList.setPages(selectPage(pageParams, search(permission)));
    }

    /**
     * 列表查询
     */
    default List<PermissionEntity> selectList(PermissionQueryDTO permission) {
        return selectList(search(permission));
    }
}