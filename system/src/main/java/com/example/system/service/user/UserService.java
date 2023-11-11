package com.example.system.service.user;

import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.system.dal.dto.user.LoginDTO;
import com.example.system.dal.dto.user.SignUpDTO;
import com.example.system.dal.dto.user.UserQueryDTO;
import com.example.system.dal.dto.user.UserSaveDTO;
import com.example.system.dal.entity.UserEntity;
import com.example.system.dal.vo.user.UserDetailVO;
import com.example.system.dal.vo.user.UserInfoVO;
import com.example.system.dal.vo.user.UserListVO;
import com.example.system.dal.vo.user.UserPageVO;

import java.util.List;

public interface UserService {
    /**
     * 获取列表分页
     *
     * @param user 分页入参
     * @return 列表分页
     */
    Result<PageList<UserPageVO>> pageService(UserQueryDTO user);

    /**
     * 获取列表
     *
     * @param user 入参
     * @return 列表
     */
    Result<List<UserListVO>> listService(UserQueryDTO user);

    /**
     * 获取详情
     *
     * @param id 入参
     * @return 详情
     */
    Result<UserDetailVO> detailService(Long id);

    /**
     * 批量新增/修改
     *
     * @param userList 新增/修改内容
     * @return 新增/修改后数据
     */
    Result<List<UserEntity>> saveListService(List<UserSaveDTO> userList);

    /**
     * 登录接口
     *
     * @param loginInfo 登录用户信息
     * @return 用户信息
     */
    Result<UserInfoVO> loginService(LoginDTO loginInfo);

    /**
     * 注册接口
     *
     * @param signUpInfo 注册信息
     * @return 用户信息
     */
    Result<Object> signUpService(SignUpDTO signUpInfo);

    /**
     * 通过token或者其他信息获取用户信息
     *
     * @param user 用户信息
     * @return 用户信息
     */
    Result<UserInfoVO> userInfo(UserEntity user, String loginSystem, String token);
}
