package com.example.system.dal.mapper;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.framework.common.PageList;
import com.example.system.dal.dto.user.UserQueryDTO;
import com.example.system.dal.entity.UserEntity;
import com.example.system.dal.entity.UserRoleEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

    default QueryWrapper<UserEntity> search(UserQueryDTO user) {
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();

        /* 电话号码 */
        if (!StrUtil.hasBlank(user.getPhone())) {
            wrapper.eq("phone", user.getPhone());
        }
        /* 电子邮箱 */
        if (!StrUtil.hasBlank(user.getEmail())) {
            wrapper.eq("email", user.getEmail());
        }
        /* 账号 */
        if (!StrUtil.hasBlank(user.getAccount())) {
            wrapper.eq("account", user.getAccount());
        }
        /* 密码 */
        if (!StrUtil.hasBlank(user.getPassword())) {
            wrapper.eq("password", user.getPassword());
        }
        /* 用户名 */
        if (!StrUtil.hasBlank(user.getUser())) {
            wrapper.eq("user", user.getUser());
        }
        /* 真实姓名 */
        if (!StrUtil.hasBlank(user.getName())) {
            wrapper.eq("name", user.getName());
        }
        /* 身份证号码 */
        if (!StrUtil.hasBlank(user.getIdCard())) {
            wrapper.eq("id_card", user.getIdCard());
        }
        /* 性别 */
        if (!StrUtil.hasBlank(user.getSex())) {
            wrapper.eq("sex", user.getSex());
        }
        /* 用户类型 */
        if (!StrUtil.hasBlank(user.getUserType())) {
            wrapper.eq("user_type", user.getUserType());
        }
        /* 状态 */
        if (!StrUtil.hasBlank(user.getStatus())) {
            wrapper.eq("status", user.getStatus());
        }

        wrapper.orderByDesc("create_time");

        return wrapper;
    }

    //分页
    default PageList<UserEntity> selectPage(UserQueryDTO user) {
        IPage<UserEntity> pageParams = new Page<>(user.getPage(), user.getSize());

        return PageList.setPages(this.selectPage(pageParams, search(user)));
    }

    //列表查询
    default List<UserEntity> selectList(UserQueryDTO user) {
        return selectList(search(user));
    }

    List<UserRoleEntity> selectUserRole(Long userId);

    void insertUserRole(UserRoleEntity userRole);

    @Delete("DELETE FROM user WHERE is_deleted = 1")
    void clearUser();

    void deleteUserRole(Long userId);

}
