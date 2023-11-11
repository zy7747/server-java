package com.example.system.dal.convert;

import com.example.framework.common.PageList;
import com.example.system.dal.dto.user.SignUpDTO;
import com.example.system.dal.dto.user.UserSaveDTO;
import com.example.system.dal.entity.UserEntity;
import com.example.system.dal.vo.user.UserDetailVO;
import com.example.system.dal.vo.user.UserExportVO;
import com.example.system.dal.vo.user.UserListVO;
import com.example.system.dal.vo.user.UserPageVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserConvert {
    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    PageList<UserPageVO> page(PageList<UserEntity> users);

    List<UserListVO> list(List<UserEntity> users);

    UserDetailVO detail(UserEntity users);

    List<UserEntity> saveList(List<UserSaveDTO> users);

    List<UserExportVO> export(List<UserEntity> users);

    UserEntity signUp(SignUpDTO signUpInfo);

    UserSaveDTO signUpValid(SignUpDTO signUpInfo);
}
