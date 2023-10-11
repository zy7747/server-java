package com.example.system.service.user;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.system.dal.convert.UserConvert;
import com.example.system.dal.dto.user.LoginDTO;
import com.example.system.dal.dto.user.SignUpDTO;
import com.example.system.dal.dto.user.UserQueryDTO;
import com.example.system.dal.dto.user.UserSaveDTO;
import com.example.system.dal.entity.*;
import com.example.system.dal.mapper.MenuMapper;
import com.example.system.dal.mapper.RoleMapper;
import com.example.system.dal.mapper.UserMapper;
import com.example.system.dal.vo.user.UserDetailVO;
import com.example.system.dal.vo.user.UserInfoVO;
import com.example.system.dal.vo.user.UserListVO;
import com.example.system.dal.vo.user.UserPageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {
    @Resource
    UserMapper userMapper;

    @Resource
    RoleMapper roleMapper;

    @Resource
    MenuMapper menuMapper;

    /**
     * 获取列表分页
     *
     * @param user 分页入参
     * @return 列表分页
     */
    @Override
    public Result<PageList<UserPageVO>> pageService(UserQueryDTO user) {
        PageList<UserPageVO> UserPageList = UserConvert.INSTANCE.page(userMapper.selectPage(user));

        UserPageList.getList().forEach(item -> {
            //从关联表中获取角色
            ArrayList<Long> roles = new ArrayList<>();
            //插入角色
            userMapper.selectUserRole(item.getId()).forEach(role -> roles.add(role.getRoleId()));
            item.setRoles(roles);
        });

        return Result.success(UserPageList);
    }

    /**
     * 获取列表
     *
     * @param user 查询参数
     * @return 列表
     */
    @Override
    public Result<List<UserListVO>> listService(UserQueryDTO user) {
        List<UserListVO> UserList = UserConvert.INSTANCE.list(userMapper.selectList(user));

        UserList.forEach(item -> {
            //从关联表中获取角色
            ArrayList<Long> roles = new ArrayList<>();
            //插入角色
            userMapper.selectUserRole(item.getId()).forEach(role -> roles.add(role.getRoleId()));
            item.setRoles(roles);
        });

        return Result.success(UserList);
    }

    /**
     * 获取详情
     *
     * @param id 入参
     * @return 详情
     */
    @Override
    public Result<UserDetailVO> detailService(Long id) {
        //从关联表中获取角色
        ArrayList<Long> roles = new ArrayList<>();

        userMapper.selectUserRole(id).forEach(item -> roles.add(item.getRoleId()));

        UserDetailVO userDetail = UserConvert.INSTANCE.detail(userMapper.selectById(id));

        userDetail.setRoles(roles);

        return Result.success(userDetail);
    }

    /**
     * 批量新增/修改
     *
     * @param userList 新增/修改内容
     * @return 新增/修改后数据
     */
    @Override
    public Result<List<UserEntity>> saveListService(List<UserSaveDTO> userList) {
        //唯一性校验
        for (UserSaveDTO item : userList) {
            QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
            //如果是修改，找不是自己ID的
            if (item.getId() != null) {
                wrapper.ne("id", item.getId()).and(i -> i.eq("account", item.getAccount()).or().eq("user", item.getUser()));
            } else {
                wrapper.eq("account", item.getAccount()).or().eq("user", item.getUser());
            }

            List<UserEntity> userInfo = userMapper.selectList(wrapper);

            if (!userInfo.isEmpty()) {
                for (UserEntity users : userInfo) {
                    if (users.getAccount().equals(item.getAccount())) {
                        return Result.fail("账号不可重复");
                    } else if (users.getUser().equals(item.getUser())) {
                        return Result.fail("用户名不可重复");
                    }
                }
            }
        }

        List<UserEntity> user = UserConvert.INSTANCE.saveList(userList);

        this.saveOrUpdateBatch(user);

        userList.forEach(item -> {
            //先全部删除
            userMapper.deleteUserRole(item.getId());
            if (item.getRoles() != null) {
                for (Long role : item.getRoles()) {
                    //将角色数据塞进去
                    UserRoleEntity userRole = new UserRoleEntity();
                    userRole.setUserId(user.get(0).getId());
                    userRole.setRoleId(role);
                    //在批量新增
                    userMapper.insertUserRole(userRole);
                }
            }

        });


        return Result.success(user);
    }

    /**
     * 登录接口
     *
     * @param loginInfo 登录用户信息
     * @return 用户信息
     */
    @Override
    public Result<UserInfoVO> loginService(LoginDTO loginInfo) {
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();

        //登录方式判断
        switch (loginInfo.getLoginType()) {
            case "account":
                if (loginInfo.getAccount() == null || loginInfo.getAccount().equals("")) {
                    return Result.fail("账号不能为空");
                } else if (loginInfo.getPassword() == null || loginInfo.getPassword().equals("")) {
                    return Result.fail("密码不能为空");
                }
                wrapper.eq("account", loginInfo.getAccount()).and(i -> i.eq("password", loginInfo.getPassword()));
                break;
            case "phone":
                wrapper.eq("phone", loginInfo.getPhone());
                break;
            case "email":
                wrapper.eq("email", loginInfo.getEmail()).and(i -> i.eq("code", loginInfo.getPassword()));
                break;
        }

        //查询数据
        UserEntity userInfo = userMapper.selectOne(wrapper);
        //返回用户信息
        if (userInfo != null) {
            UserInfoVO userInfoVo = new UserInfoVO();
            //1.注入token
            String Token = JWT.create().withAudience(String.valueOf(userInfo.getId())).withExpiresAt(new Date()).sign(Algorithm.HMAC256(userInfo.getPassword()));
            userInfoVo.setToken(Token);

            //2.注入用户信息
            userInfoVo.setUserInfo(userInfo);

            //3.注入角色列表
            List<UserRoleEntity> roleList = userMapper.selectUserRole(userInfo.getId());
            List<RoleEntity> role = new ArrayList<>();
            List<MenuEntity> menus = new ArrayList<>();

            roleList.forEach(item -> {
                role.add(roleMapper.selectById(item.getRoleId()));

                List<RoleMenuEntity> roleMenuList = roleMapper.selectRoleMenu(item.getRoleId());

                roleMenuList.forEach(menuItem -> menus.add(menuMapper.selectById(menuItem.getMenuId())));
            });

            userInfoVo.setRoles(role);


            Set<Long> idSet = new HashSet<>();

            List<MenuEntity> menuList = menus.stream()
                    .filter(menu -> idSet.add(menu.getId()))
                    .collect(Collectors.toList());

            //4.注入菜单
            userInfoVo.setMenuList(menuList);

            return Result.success(userInfoVo);
        } else {
            return Result.fail("登录失败,请检查账号密码是否正确");
        }
    }

    /**
     * 注册接口
     *
     * @param signUpInfo 注册信息
     * @return 用户信息
     */
    @Override
    public Result<Object> signUpService(SignUpDTO signUpInfo) {
        // 1.创建的时候先查询   有没有注册过
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();

        List<UserEntity> UserLength = userMapper.selectList(wrapper);

        wrapper.eq("user", signUpInfo.getUser()).or().eq("account", signUpInfo.getAccount());

        List<UserEntity> userList = userMapper.selectList(wrapper);

        if (!userList.isEmpty()) {
            //3.注册失败,用户名或账号已被注册
            return Result.fail("注册失败,用户名或账号已被注册");
        } else {
            Long uid = (long) (UserLength.size() + 1);

            signUpInfo.setUid(uid);

            this.save(UserConvert.INSTANCE.signUp(signUpInfo));

            return Result.success("注册成功");
        }


    }
}