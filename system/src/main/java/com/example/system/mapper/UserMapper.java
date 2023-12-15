package com.example.system.mapper;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.framework.common.PageList;
import com.example.system.dal.dto.user.UserQueryDTO;
import com.example.system.dal.dto.user.UserSaveDTO;
import com.example.system.dal.entity.UserEntity;
import com.example.system.dal.entity.UserRoleEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Objects;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

    //按条件搜索
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

    //唯一性校验
    default String onlyValid(UserSaveDTO user) {
        //一次查出所以数据
        List<UserEntity> userList = selectList(new UserQueryDTO());

        for (UserEntity item : userList) {
            //修改跳过自己
            if (user.getId() != null && item.getId().equals(user.getId())) {
                continue;
            }

            if (!StrUtil.hasBlank(user.getAccount()) && Objects.equals(user.getAccount(), item.getAccount())) {
                return "账号已被注册";
            }

            if (!StrUtil.hasBlank(user.getUser()) && Objects.equals(user.getUser(), item.getUser())) {
                return "用户名已被注册";
            }

            if (!StrUtil.hasBlank(user.getEmail()) && Objects.equals(user.getEmail(), item.getEmail())) {
                return "邮箱已被注册";
            }

            if (!StrUtil.hasBlank(user.getPhone()) && Objects.equals(user.getPhone(), item.getPhone())) {
                return "手机号已被注册";
            }
        }

        return "新增成功";

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

    // 清除历史删除数据
    @Delete("DELETE FROM user WHERE is_deleted = 1")
    void clearUser();

    //批量删除中间表
    @Delete("DELETE FROM user_role WHERE user_id IN (${ids})")
    void deleteUserRoleByIds(String ids);

    @Insert("INSERT INTO user_role(user_id, role_id) VALUES (#{userId}, #{roleId})")
    void insertUserRole(Long userId, Long roleId);

    //批量插入中间表数据
    void batchInsertUserRole(List<UserRoleEntity> UserRoleList);

    //查询关角色联表的数据
    List<UserRoleEntity> selectUserRole(Long userId);

    //删除关角色联表的数据
    void deleteUserRole(Long userId);
}
