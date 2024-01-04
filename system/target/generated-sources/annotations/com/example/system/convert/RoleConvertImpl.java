package com.example.system.convert;

import com.example.framework.common.PageList;
import com.example.system.dal.dto.role.RoleSaveDTO;
import com.example.system.dal.entity.RoleEntity;
import com.example.system.dal.vo.role.RoleDetailVO;
import com.example.system.dal.vo.role.RoleExportVO;
import com.example.system.dal.vo.role.RoleListVO;
import com.example.system.dal.vo.role.RolePageVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-03T17:15:49+0800",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 1.8.0_311 (Oracle Corporation)"
)
public class RoleConvertImpl implements RoleConvert {

    @Override
    public PageList<RolePageVO> page(PageList<RoleEntity> roles) {
        if ( roles == null ) {
            return null;
        }

        PageList<RolePageVO> pageList = new PageList<RolePageVO>();

        pageList.setPage( roles.getPage() );
        pageList.setTotal( roles.getTotal() );
        pageList.setSize( roles.getSize() );
        pageList.setList( roleEntityListToRolePageVOList( roles.getList() ) );

        return pageList;
    }

    @Override
    public List<RoleListVO> list(List<RoleEntity> roles) {
        if ( roles == null ) {
            return null;
        }

        List<RoleListVO> list = new ArrayList<RoleListVO>( roles.size() );
        for ( RoleEntity roleEntity : roles ) {
            list.add( roleEntityToRoleListVO( roleEntity ) );
        }

        return list;
    }

    @Override
    public RoleDetailVO detail(RoleEntity roles) {
        if ( roles == null ) {
            return null;
        }

        RoleDetailVO roleDetailVO = new RoleDetailVO();

        roleDetailVO.setId( roles.getId() );
        roleDetailVO.setStatus( roles.getStatus() );
        roleDetailVO.setRemark( roles.getRemark() );
        roleDetailVO.setCreator( roles.getCreator() );
        roleDetailVO.setUpdater( roles.getUpdater() );
        roleDetailVO.setCreateTime( roles.getCreateTime() );
        roleDetailVO.setUpdateTime( roles.getUpdateTime() );
        roleDetailVO.setIsDeleted( roles.getIsDeleted() );
        roleDetailVO.setTenantId( roles.getTenantId() );
        roleDetailVO.setVersion( roles.getVersion() );
        roleDetailVO.setRoleName( roles.getRoleName() );
        roleDetailVO.setRoleCode( roles.getRoleCode() );

        return roleDetailVO;
    }

    @Override
    public List<RoleEntity> saveList(List<RoleSaveDTO> roles) {
        if ( roles == null ) {
            return null;
        }

        List<RoleEntity> list = new ArrayList<RoleEntity>( roles.size() );
        for ( RoleSaveDTO roleSaveDTO : roles ) {
            list.add( roleSaveDTOToRoleEntity( roleSaveDTO ) );
        }

        return list;
    }

    @Override
    public List<RoleExportVO> export(List<RoleEntity> roles) {
        if ( roles == null ) {
            return null;
        }

        List<RoleExportVO> list = new ArrayList<RoleExportVO>( roles.size() );
        for ( RoleEntity roleEntity : roles ) {
            list.add( roleEntityToRoleExportVO( roleEntity ) );
        }

        return list;
    }

    @Override
    public List<RoleSaveDTO> imports(List<RoleExportVO> roles) {
        if ( roles == null ) {
            return null;
        }

        List<RoleSaveDTO> list = new ArrayList<RoleSaveDTO>( roles.size() );
        for ( RoleExportVO roleExportVO : roles ) {
            list.add( roleExportVOToRoleSaveDTO( roleExportVO ) );
        }

        return list;
    }

    protected RolePageVO roleEntityToRolePageVO(RoleEntity roleEntity) {
        if ( roleEntity == null ) {
            return null;
        }

        RolePageVO rolePageVO = new RolePageVO();

        rolePageVO.setId( roleEntity.getId() );
        rolePageVO.setStatus( roleEntity.getStatus() );
        rolePageVO.setRemark( roleEntity.getRemark() );
        rolePageVO.setCreator( roleEntity.getCreator() );
        rolePageVO.setUpdater( roleEntity.getUpdater() );
        rolePageVO.setCreateTime( roleEntity.getCreateTime() );
        rolePageVO.setUpdateTime( roleEntity.getUpdateTime() );
        rolePageVO.setIsDeleted( roleEntity.getIsDeleted() );
        rolePageVO.setTenantId( roleEntity.getTenantId() );
        rolePageVO.setVersion( roleEntity.getVersion() );
        rolePageVO.setRoleName( roleEntity.getRoleName() );
        rolePageVO.setRoleCode( roleEntity.getRoleCode() );

        return rolePageVO;
    }

    protected List<RolePageVO> roleEntityListToRolePageVOList(List<RoleEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<RolePageVO> list1 = new ArrayList<RolePageVO>( list.size() );
        for ( RoleEntity roleEntity : list ) {
            list1.add( roleEntityToRolePageVO( roleEntity ) );
        }

        return list1;
    }

    protected RoleListVO roleEntityToRoleListVO(RoleEntity roleEntity) {
        if ( roleEntity == null ) {
            return null;
        }

        RoleListVO roleListVO = new RoleListVO();

        roleListVO.setId( roleEntity.getId() );
        roleListVO.setStatus( roleEntity.getStatus() );
        roleListVO.setRemark( roleEntity.getRemark() );
        roleListVO.setCreator( roleEntity.getCreator() );
        roleListVO.setUpdater( roleEntity.getUpdater() );
        roleListVO.setCreateTime( roleEntity.getCreateTime() );
        roleListVO.setUpdateTime( roleEntity.getUpdateTime() );
        roleListVO.setIsDeleted( roleEntity.getIsDeleted() );
        roleListVO.setTenantId( roleEntity.getTenantId() );
        roleListVO.setVersion( roleEntity.getVersion() );
        roleListVO.setRoleName( roleEntity.getRoleName() );
        roleListVO.setRoleCode( roleEntity.getRoleCode() );

        return roleListVO;
    }

    protected RoleEntity roleSaveDTOToRoleEntity(RoleSaveDTO roleSaveDTO) {
        if ( roleSaveDTO == null ) {
            return null;
        }

        RoleEntity roleEntity = new RoleEntity();

        roleEntity.setId( roleSaveDTO.getId() );
        roleEntity.setStatus( roleSaveDTO.getStatus() );
        roleEntity.setRemark( roleSaveDTO.getRemark() );
        roleEntity.setCreator( roleSaveDTO.getCreator() );
        roleEntity.setUpdater( roleSaveDTO.getUpdater() );
        roleEntity.setCreateTime( roleSaveDTO.getCreateTime() );
        roleEntity.setUpdateTime( roleSaveDTO.getUpdateTime() );
        roleEntity.setIsDeleted( roleSaveDTO.getIsDeleted() );
        roleEntity.setTenantId( roleSaveDTO.getTenantId() );
        roleEntity.setVersion( roleSaveDTO.getVersion() );
        roleEntity.setRoleName( roleSaveDTO.getRoleName() );
        roleEntity.setRoleCode( roleSaveDTO.getRoleCode() );

        return roleEntity;
    }

    protected RoleExportVO roleEntityToRoleExportVO(RoleEntity roleEntity) {
        if ( roleEntity == null ) {
            return null;
        }

        RoleExportVO roleExportVO = new RoleExportVO();

        roleExportVO.setRoleName( roleEntity.getRoleName() );
        roleExportVO.setRoleCode( roleEntity.getRoleCode() );

        return roleExportVO;
    }

    protected RoleSaveDTO roleExportVOToRoleSaveDTO(RoleExportVO roleExportVO) {
        if ( roleExportVO == null ) {
            return null;
        }

        RoleSaveDTO roleSaveDTO = new RoleSaveDTO();

        roleSaveDTO.setRoleName( roleExportVO.getRoleName() );
        roleSaveDTO.setRoleCode( roleExportVO.getRoleCode() );

        return roleSaveDTO;
    }
}
