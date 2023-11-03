package com.example.system.dal.mapper;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.framework.common.PageList;
import com.example.system.dal.dto.role.RoleQueryDTO;
import com.example.system.dal.entity.RoleEntity;
import com.example.system.dal.entity.RoleMenuEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleMapper extends BaseMapper<RoleEntity> {
    default QueryWrapper<RoleEntity> search(RoleQueryDTO role) {
        QueryWrapper<RoleEntity> wrapper = new QueryWrapper<>();

        /* 角色名称 */
        if (!StrUtil.hasBlank(role.getRoleName())) {
            wrapper.eq("role_name", role.getRoleName());
        }
        /* 角色编码 */
        if (!StrUtil.hasBlank(role.getRoleCode())) {
            wrapper.eq("role_code", role.getRoleCode());
        }
        /* 状态 */
        if (!StrUtil.hasBlank(role.getStatus())) {
            wrapper.eq("status", role.getStatus());
        }
        wrapper.orderByDesc("create_time");
        return wrapper;
    }

    //分页
    default PageList<RoleEntity> selectPage(RoleQueryDTO role) {
        IPage<RoleEntity> pageParams = new Page<>(role.getPage(), role.getSize());

        return PageList.setPages(this.selectPage(pageParams, search(role)));
    }

    //列表查询
    default List<RoleEntity> selectList(RoleQueryDTO role) {
        return selectList(search(role));
    }

    @Select("SELECT * FROM role_menu WHERE role_id = #{roleId}")
    List<RoleMenuEntity> selectRoleMenu(Long roleId);

    @Insert("INSERT INTO role_menu(role_id, menu_id) VALUES (#{roleId}, #{menuId})")
    void insertRoleMenu(RoleMenuEntity roleMenu);

    @Delete("DELETE FROM role_menu WHERE role_id = #{roleId}")
    void deleteRoleMenu(Long roleId);

    @Delete("DELETE FROM role WHERE is_deleted = 1")
    void clearRole();

    @Delete("DELETE FROM user_role WHERE role_id = #{roleId}")
    void deleteUserRole(Long roleId);
}