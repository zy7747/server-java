package com.example.system.dal.convert;

import com.example.framework.common.PageList;
import com.example.system.dal.dto.user.SignUpDTO;
import com.example.system.dal.dto.user.UserSaveDTO;
import com.example.system.dal.entity.UserEntity;
import com.example.system.dal.vo.user.UserDetailVO;
import com.example.system.dal.vo.user.UserExportVO;
import com.example.system.dal.vo.user.UserListVO;
import com.example.system.dal.vo.user.UserPageVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-10T19:55:36+0800",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 1.8.0_311 (Oracle Corporation)"
)
public class UserConvertImpl implements UserConvert {

    @Override
    public PageList<UserPageVO> page(PageList<UserEntity> users) {
        if ( users == null ) {
            return null;
        }

        PageList<UserPageVO> pageList = new PageList<UserPageVO>();

        pageList.setPage( users.getPage() );
        pageList.setTotal( users.getTotal() );
        pageList.setSize( users.getSize() );
        pageList.setList( userEntityListToUserPageVOList( users.getList() ) );

        return pageList;
    }

    @Override
    public List<UserListVO> list(List<UserEntity> users) {
        if ( users == null ) {
            return null;
        }

        List<UserListVO> list = new ArrayList<UserListVO>( users.size() );
        for ( UserEntity userEntity : users ) {
            list.add( userEntityToUserListVO( userEntity ) );
        }

        return list;
    }

    @Override
    public UserDetailVO detail(UserEntity users) {
        if ( users == null ) {
            return null;
        }

        UserDetailVO userDetailVO = new UserDetailVO();

        userDetailVO.setId( users.getId() );
        userDetailVO.setStatus( users.getStatus() );
        userDetailVO.setRemark( users.getRemark() );
        userDetailVO.setCreator( users.getCreator() );
        userDetailVO.setUpdater( users.getUpdater() );
        userDetailVO.setCreateTime( users.getCreateTime() );
        userDetailVO.setUpdateTime( users.getUpdateTime() );
        userDetailVO.setIsDeleted( users.getIsDeleted() );
        userDetailVO.setTenantId( users.getTenantId() );
        userDetailVO.setVersion( users.getVersion() );
        userDetailVO.setUid( users.getUid() );
        userDetailVO.setPhone( users.getPhone() );
        userDetailVO.setEmail( users.getEmail() );
        userDetailVO.setAccount( users.getAccount() );
        userDetailVO.setPassword( users.getPassword() );
        userDetailVO.setUser( users.getUser() );
        userDetailVO.setName( users.getName() );
        userDetailVO.setIdCard( users.getIdCard() );
        userDetailVO.setAvatar( users.getAvatar() );
        userDetailVO.setSex( users.getSex() );
        userDetailVO.setUserType( users.getUserType() );
        userDetailVO.setAge( users.getAge() );
        userDetailVO.setBirthDate( users.getBirthDate() );

        return userDetailVO;
    }

    @Override
    public List<UserEntity> saveList(List<UserSaveDTO> users) {
        if ( users == null ) {
            return null;
        }

        List<UserEntity> list = new ArrayList<UserEntity>( users.size() );
        for ( UserSaveDTO userSaveDTO : users ) {
            list.add( userSaveDTOToUserEntity( userSaveDTO ) );
        }

        return list;
    }

    @Override
    public List<UserExportVO> export(List<UserEntity> users) {
        if ( users == null ) {
            return null;
        }

        List<UserExportVO> list = new ArrayList<UserExportVO>( users.size() );
        for ( UserEntity userEntity : users ) {
            list.add( userEntityToUserExportVO( userEntity ) );
        }

        return list;
    }

    @Override
    public UserEntity signUp(SignUpDTO signUpInfo) {
        if ( signUpInfo == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setUid( signUpInfo.getUid() );
        userEntity.setPhone( signUpInfo.getPhone() );
        userEntity.setEmail( signUpInfo.getEmail() );
        userEntity.setAccount( signUpInfo.getAccount() );
        userEntity.setPassword( signUpInfo.getPassword() );
        userEntity.setUser( signUpInfo.getUser() );

        return userEntity;
    }

    @Override
    public UserSaveDTO signUpValid(SignUpDTO signUpInfo) {
        if ( signUpInfo == null ) {
            return null;
        }

        UserSaveDTO userSaveDTO = new UserSaveDTO();

        userSaveDTO.setUid( signUpInfo.getUid() );
        userSaveDTO.setPhone( signUpInfo.getPhone() );
        userSaveDTO.setEmail( signUpInfo.getEmail() );
        userSaveDTO.setAccount( signUpInfo.getAccount() );
        userSaveDTO.setPassword( signUpInfo.getPassword() );
        userSaveDTO.setUser( signUpInfo.getUser() );

        return userSaveDTO;
    }

    protected UserPageVO userEntityToUserPageVO(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserPageVO userPageVO = new UserPageVO();

        userPageVO.setId( userEntity.getId() );
        userPageVO.setStatus( userEntity.getStatus() );
        userPageVO.setRemark( userEntity.getRemark() );
        userPageVO.setCreator( userEntity.getCreator() );
        userPageVO.setUpdater( userEntity.getUpdater() );
        userPageVO.setCreateTime( userEntity.getCreateTime() );
        userPageVO.setUpdateTime( userEntity.getUpdateTime() );
        userPageVO.setIsDeleted( userEntity.getIsDeleted() );
        userPageVO.setTenantId( userEntity.getTenantId() );
        userPageVO.setVersion( userEntity.getVersion() );
        userPageVO.setUid( userEntity.getUid() );
        userPageVO.setPhone( userEntity.getPhone() );
        userPageVO.setEmail( userEntity.getEmail() );
        userPageVO.setAccount( userEntity.getAccount() );
        userPageVO.setPassword( userEntity.getPassword() );
        userPageVO.setUser( userEntity.getUser() );
        userPageVO.setName( userEntity.getName() );
        userPageVO.setIdCard( userEntity.getIdCard() );
        userPageVO.setAvatar( userEntity.getAvatar() );
        userPageVO.setSex( userEntity.getSex() );
        userPageVO.setUserType( userEntity.getUserType() );
        userPageVO.setAge( userEntity.getAge() );
        userPageVO.setBirthDate( userEntity.getBirthDate() );

        return userPageVO;
    }

    protected List<UserPageVO> userEntityListToUserPageVOList(List<UserEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<UserPageVO> list1 = new ArrayList<UserPageVO>( list.size() );
        for ( UserEntity userEntity : list ) {
            list1.add( userEntityToUserPageVO( userEntity ) );
        }

        return list1;
    }

    protected UserListVO userEntityToUserListVO(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserListVO userListVO = new UserListVO();

        userListVO.setId( userEntity.getId() );
        userListVO.setStatus( userEntity.getStatus() );
        userListVO.setRemark( userEntity.getRemark() );
        userListVO.setCreator( userEntity.getCreator() );
        userListVO.setUpdater( userEntity.getUpdater() );
        userListVO.setCreateTime( userEntity.getCreateTime() );
        userListVO.setUpdateTime( userEntity.getUpdateTime() );
        userListVO.setIsDeleted( userEntity.getIsDeleted() );
        userListVO.setTenantId( userEntity.getTenantId() );
        userListVO.setVersion( userEntity.getVersion() );
        userListVO.setUid( userEntity.getUid() );
        userListVO.setPhone( userEntity.getPhone() );
        userListVO.setEmail( userEntity.getEmail() );
        userListVO.setAccount( userEntity.getAccount() );
        userListVO.setPassword( userEntity.getPassword() );
        userListVO.setUser( userEntity.getUser() );
        userListVO.setName( userEntity.getName() );
        userListVO.setIdCard( userEntity.getIdCard() );
        userListVO.setAvatar( userEntity.getAvatar() );
        userListVO.setSex( userEntity.getSex() );
        userListVO.setUserType( userEntity.getUserType() );
        userListVO.setAge( userEntity.getAge() );
        userListVO.setBirthDate( userEntity.getBirthDate() );

        return userListVO;
    }

    protected UserEntity userSaveDTOToUserEntity(UserSaveDTO userSaveDTO) {
        if ( userSaveDTO == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( userSaveDTO.getId() );
        userEntity.setStatus( userSaveDTO.getStatus() );
        userEntity.setRemark( userSaveDTO.getRemark() );
        userEntity.setCreator( userSaveDTO.getCreator() );
        userEntity.setUpdater( userSaveDTO.getUpdater() );
        userEntity.setCreateTime( userSaveDTO.getCreateTime() );
        userEntity.setUpdateTime( userSaveDTO.getUpdateTime() );
        userEntity.setIsDeleted( userSaveDTO.getIsDeleted() );
        userEntity.setTenantId( userSaveDTO.getTenantId() );
        userEntity.setVersion( userSaveDTO.getVersion() );
        userEntity.setUid( userSaveDTO.getUid() );
        userEntity.setPhone( userSaveDTO.getPhone() );
        userEntity.setEmail( userSaveDTO.getEmail() );
        userEntity.setAccount( userSaveDTO.getAccount() );
        userEntity.setPassword( userSaveDTO.getPassword() );
        userEntity.setUser( userSaveDTO.getUser() );
        userEntity.setName( userSaveDTO.getName() );
        userEntity.setIdCard( userSaveDTO.getIdCard() );
        userEntity.setAvatar( userSaveDTO.getAvatar() );
        userEntity.setSex( userSaveDTO.getSex() );
        userEntity.setUserType( userSaveDTO.getUserType() );
        userEntity.setAge( userSaveDTO.getAge() );
        userEntity.setBirthDate( userSaveDTO.getBirthDate() );

        return userEntity;
    }

    protected UserExportVO userEntityToUserExportVO(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserExportVO userExportVO = new UserExportVO();

        userExportVO.setId( userEntity.getId() );
        userExportVO.setStatus( userEntity.getStatus() );
        userExportVO.setRemark( userEntity.getRemark() );
        userExportVO.setCreator( userEntity.getCreator() );
        userExportVO.setUpdater( userEntity.getUpdater() );
        userExportVO.setCreateTime( userEntity.getCreateTime() );
        userExportVO.setUpdateTime( userEntity.getUpdateTime() );
        userExportVO.setIsDeleted( userEntity.getIsDeleted() );
        userExportVO.setUid( userEntity.getUid() );
        userExportVO.setPhone( userEntity.getPhone() );
        userExportVO.setEmail( userEntity.getEmail() );
        userExportVO.setAccount( userEntity.getAccount() );
        userExportVO.setPassword( userEntity.getPassword() );
        userExportVO.setUser( userEntity.getUser() );
        userExportVO.setName( userEntity.getName() );
        userExportVO.setIdCard( userEntity.getIdCard() );
        userExportVO.setAvatar( userEntity.getAvatar() );
        userExportVO.setSex( userEntity.getSex() );
        userExportVO.setUserType( userEntity.getUserType() );
        userExportVO.setAge( userEntity.getAge() );
        userExportVO.setBirthDate( userEntity.getBirthDate() );

        return userExportVO;
    }
}
