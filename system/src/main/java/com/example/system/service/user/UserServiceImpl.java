package com.example.system.service.user;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.system.dal.convert.UserConvert;
import com.example.system.dal.dto.menu.MenuQueryDTO;
import com.example.system.dal.dto.role.RoleQueryDTO;
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
import com.example.system.utils.GetMenuList;
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
        List<UserEntity> user = UserConvert.INSTANCE.saveList(userList);

        String res = userMapper.onlyValid(userList.get(0));

        if (res.equals("新增成功")) {
            this.saveOrUpdateBatch(user);
        } else {
            return Result.error(res);
        }

        StringBuilder ids = new StringBuilder();
        List<UserRoleEntity> UserRoleList = new ArrayList<>();
        //保存角色
        for (int i = 0; i < userList.size(); i++) {
            UserSaveDTO item = userList.get(i);
            //先全部删除用户的角色
            if (item.getId() != null) {
                ids.append(item.getId()).append(",");
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
        }
        //删除所有关联的角色
        userMapper.deleteUserRoleByIds(ids.substring(0, ids.length() - 1));
        //插入新的角色
        userMapper.batchInsertUserRole(UserRoleList);

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
            new JwtUtil().getTokenInfo(Token);
            //返回个人信息
            return userInfo(loginInfo.getLoginSystem(), Token);
        } else {
            return Result.fail("登录失败,请检查账号密码是否正确");
        }


    }

    /**
     * 通过token或者其他信息获取用户信息
     *
     * @return 用户信息
     */
    @Override
    public Result<UserInfoVO> userInfo(String loginSystem, String token) {
        Object userId = new JwtUtil().getTokenInfo(token);

        UserEntity userInfo = userMapper.selectById(userId.toString());

        UserInfoVO userInfoVo = new UserInfoVO();

        userInfoVo.setToken(token);

        //2.注入用户信息
        userInfoVo.setUserInfo(UserConvert.INSTANCE.UserBaseInfoVO(userInfo));

        //获取该用户所有角色
        List<RoleEntity> role = new ArrayList<>();
        List<UserRoleEntity> userRoleList = userMapper.selectUserRole(userInfo.getId());
        List<RoleEntity> roleList = roleMapper.selectList(new RoleQueryDTO());

        //获取角色所有菜单
        List<MenuEntity> menus = new ArrayList<>();
        List<RoleMenuEntity> roleMenuList = roleMapper.selectRoleMenuList();
        List<MenuEntity> menuList = menuMapper.selectList(new MenuQueryDTO());

        userRoleList.forEach(items -> {
            roleList.forEach(item -> {
                if (items.getRoleId().equals(item.getId())) {
                    role.add(item);
                }
            });

            roleMenuList.forEach(menuItem -> {
                //找出这个人所有菜单ID
                if (menuItem.getRoleId().equals(items.getRoleId())) {
                    menus.add(menuList.stream().filter(c -> c.getId().equals(menuItem.getMenuId())).collect(Collectors.toList()).get(0));
                }
            });
        });

        // 菜单去重
        List<MenuEntity> menusList = menus.stream()
                .distinct()
                .sorted(Comparator.comparing(MenuEntity::getId))
                .collect(Collectors.toList());

        userInfoVo.setRoles(role);
        //系统菜单过滤
        List<MenuEntity> systemMenu = new ArrayList<>();

        for (MenuEntity menu : menusList) {
            if (menu.getType().equals("system") && menu.getPath().equals(loginSystem)) {
                new GetMenuList().getTree(menusList, menu.getId(), systemMenu);
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
