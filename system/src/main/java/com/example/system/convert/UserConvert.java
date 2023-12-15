package com.example.system.convert;

import com.example.framework.common.PageList;
import com.example.system.dal.dto.user.SignUpDTO;
import com.example.system.dal.dto.user.UserSaveDTO;
import com.example.system.dal.entity.UserEntity;
import com.example.system.dal.vo.user.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserConvert {
    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    PageList<UserPageVO> page(PageList<UserEntity> users);

    List<UserListVO> list(List<UserEntity> users);

    UserDetailVO detail(UserEntity users);

    UserBaseInfoVO UserBaseInfoVO(UserEntity users);

    List<UserEntity> saveList(List<UserSaveDTO> users);

    List<UserSaveDTO> imports(List<UserExportVO> users);

    List<UserExportVO> export(List<UserEntity> users);

    UserEntity signUp(SignUpDTO signUpInfo);

    UserSaveDTO signUpValid(SignUpDTO signUpInfo);
}
