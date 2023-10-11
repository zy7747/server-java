package com.example.system.dal.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.framework.common.PageList;
import com.example.system.dal.dto.user.UserQueryDTO;
import com.example.system.dal.entity.UserEntity;
import com.example.system.dal.entity.UserRoleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
    //分页
    default PageList<UserEntity> selectPage(UserQueryDTO user) {
        IPage<UserEntity> pageParams = new Page<>(user.getPage(), user.getSize());

        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();

        wrapper.orderByDesc("create_time");

        return PageList.setPages(this.selectPage(pageParams, wrapper));
    }

    //列表查询
    default List<UserEntity> selectList(UserQueryDTO user) {
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();

        wrapper.orderByDesc("create_time");

        return selectList(wrapper);
    }

    List<UserRoleEntity> selectUserRole(Long userId);

    void insertUserRole(UserRoleEntity userRole);

    void deleteUserRole(Long userId);

}
