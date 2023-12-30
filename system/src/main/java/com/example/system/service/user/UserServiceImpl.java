package com.example.system.service.user;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.system.convert.UserConvert;
import com.example.system.dal.dto.menu.MenuQueryDTO;
import com.example.system.dal.dto.role.RoleQueryDTO;
import com.example.system.dal.dto.user.LoginDTO;
import com.example.system.dal.dto.user.SignUpDTO;
import com.example.system.dal.dto.user.UserQueryDTO;
import com.example.system.dal.dto.user.UserSaveDTO;
import com.example.system.dal.entity.*;
import com.example.system.mapper.MenuMapper;
import com.example.system.mapper.RoleMapper;
import com.example.system.mapper.UserMapper;
import com.example.system.dal.vo.user.UserDetailVO;
import com.example.system.dal.vo.user.UserInfoVO;
import com.example.system.dal.vo.user.UserListVO;
import com.example.system.dal.vo.user.UserPageVO;
import com.example.system.utils.JwtUtil;
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
        ArrayList<Long> permissions = new ArrayList<>();

        userMapper.selectUserRole(id).forEach(item -> roles.add(item.getRoleId()));
        userMapper.selectUserPermission(id).forEach(item -> permissions.add(item.getPermissionId()));

        UserDetailVO userDetail = UserConvert.INSTANCE.detail(userMapper.selectById(id));

        userDetail.setRoles(roles);
        userDetail.setPermissions(permissions);

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
        List<UserEntity> user = UserConvert.INSTANCE.saveList(userList);

        String res = userMapper.onlyValid(userList.get(0));

        if (res.equals("新增成功")) {
            this.saveOrUpdateBatch(user);
        } else {
            return Result.error(res);
        }

        //角色
        List<UserRoleEntity> UserRoleList = new ArrayList<>();
        //权限
        List<UserPermissionEntity> UserPermissionList = new ArrayList<>();
        //保存角色
        for (int i = 0; i < userList.size(); i++) {
            //获取用户信息
            UserSaveDTO item = userList.get(i);
            UserEntity userItem = user.get(i);

            if (userItem.getId() != null) {
                //查询用户角色
                List<UserRoleEntity> userRoleList = userMapper.selectUserRole(userItem.getId());
                //删除用户角色
                if (userRoleList.size() > 0) {
                    userMapper.deleteUserRoleById(userItem.getId());
                }

                //查询用户角色
                List<UserPermissionEntity> permissionList = userMapper.selectUserPermission(userItem.getId());

                if (permissionList.size() > 0) {
                    userMapper.deleteUserPermissionById(userItem.getId());
                }
            }

            if (item.getRoles() != null) {
                //循环角色列表
                for (Long role : item.getRoles()) {
                    //将角色数据塞进去
                    UserRoleEntity userRole = new UserRoleEntity();

                    userRole.setUserId(user.get(i).getId());

                    userRole.setRoleId(role);

                    UserRoleList.add(userRole);
                }
            }

            if (item.getPermissions() != null) {
                //循环权限列表
                for (Long permissions : item.getPermissions()) {
                    //将权限数据塞进去
                    UserPermissionEntity userPermission = new UserPermissionEntity();

                    userPermission.setUserId(user.get(i).getId());

                    userPermission.setPermissionId(permissions);

                    UserPermissionList.add(userPermission);
                }
            }
        }

        //插入新的角色
        userMapper.batchInsertUserRole(UserRoleList);
        userMapper.batchInsertUserPermission(UserPermissionList);

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
                if (StrUtil.hasBlank(loginInfo.getAccount())) {
                    return Result.fail("账号不能为空");
                } else if (StrUtil.hasBlank(loginInfo.getPassword())) {
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

        //登录成功返回用户信息
        if (userInfo != null) {
            //1.注入token
            String Token = new JwtUtil().getToken(userInfo);
            JwtUtil.getTokenInfo(Token);
            //返回个人信息
            return userInfo(loginInfo.getLoginSystem(), Token);
        } else {
            return Result.fail("登录失败,请检查账号密码是否正确");
        }
    }

    public void getTree(List<MenuEntity> menus, Long pid, List<MenuEntity> systemMenu) {
        for (MenuEntity menu : menus) {
            if (pid.equals(menu.getParentId())) {
                systemMenu.add(menu);
                getTree(menus, menu.getId(), systemMenu);
            }
        }
    }

    /**
     * 通过token或者其他信息获取用户信息
     *
     * @return 用户信息
     */
    @Override
    public Result<UserInfoVO> userInfo(String loginSystem, String token) {
        Object userId = JwtUtil.getTokenInfo(token);

        UserEntity userInfo = userMapper.selectById(userId.toString());

        UserInfoVO userInfoVo = new UserInfoVO();

        userInfoVo.setToken(token);

        //2.注入用户信息
        userInfoVo.setUserInfo(UserConvert.INSTANCE.UserBaseInfoVO(userInfo));

        //获取该用户所有角色
        List<RoleEntity> role = new ArrayList<>();
        List<UserRoleEntity> userRoleList = userMapper.selectUserRole(userInfo.getId());
        List<RoleEntity> roleList = roleMapper.selectList(new RoleQueryDTO());
        List<RoleMenuEntity> roleMenuList = roleMapper.selectRoleMenuList();

        //获取角色所有菜单
        List<MenuEntity> menus = new ArrayList<>();
        List<MenuEntity> menuList = menuMapper.selectList(new MenuQueryDTO());

        //判断有没有管理员角色
        userRoleList.forEach(items -> {
            roleList.forEach(item -> {
                if (items.getRoleId().equals(item.getId())) {
                    role.add(item);
                }
            });

            //如果这个人有管理员角色，则获取所有菜单
            if (items.getRoleId() == 1704391853990109185L) {
                menus.addAll(menuList);
                //如果没有
            } else {
                roleMenuList.forEach(menuItem -> {

                    MenuEntity menuInfo = menuList.stream().filter(c -> c.getId().equals(menuItem.getMenuId())).collect(Collectors.toList()).get(0);
                    //判断这个人有没有这个菜单权限
                    if (menuItem.getRoleId().equals(items.getRoleId())) {
                        menus.add(menuInfo);
                    }
                });
            }


        });


        userInfoVo.setRoles(role);
        // 菜单去重
        List<MenuEntity> menusList = menus.stream()
                .distinct()
                .sorted(Comparator.comparing(MenuEntity::getId))
                .collect(Collectors.toList());

        //系统菜单过滤
        List<MenuEntity> systemMenu = new ArrayList<>();

        for (MenuEntity menu : menusList) {
            if (menu.getType().equals("system") && menu.getPath().equals(loginSystem)) {
                getTree(menusList, menu.getId(), systemMenu);
            }
        }

        //4.注入菜单
        userInfoVo.setMenuList(systemMenu);

        return Result.success(userInfoVo);
    }


    /**
     * 注册接口
     *
     * @param signUpInfo 注册信息
     * @return 用户信息
     */
    @Override
    public Result<Object> signUpService(SignUpDTO signUpInfo) {

        String res = userMapper.onlyValid(UserConvert.INSTANCE.signUpValid(signUpInfo));

        if (res.equals("新增成功")) {
            UserEntity user = UserConvert.INSTANCE.signUp(signUpInfo);

            this.save(user);
            //注册成功默认添加普通用户角色
            userMapper.insertUserRole(user.getId(), 1704391937444175873L);
            return Result.success("注册成功");
        } else {
            return Result.error(res);
        }
    }
}
