package com.example.system.convert;

import com.example.framework.common.PageList;
import com.example.system.dal.dto.permission.PermissionSaveDTO;
import com.example.system.dal.entity.PermissionEntity;
import com.example.system.dal.vo.permission.PermissionDetailVO;
import com.example.system.dal.vo.permission.PermissionExportVO;
import com.example.system.dal.vo.permission.PermissionListVO;
import com.example.system.dal.vo.permission.PermissionPageVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-29T15:35:26+0800",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 1.8.0_311 (Oracle Corporation)"
)
public class PermissionConvertImpl implements PermissionConvert {

    @Override
    public PageList<PermissionPageVO> page(PageList<PermissionEntity> permissions) {
        if ( permissions == null ) {
            return null;
        }

        PageList<PermissionPageVO> pageList = new PageList<PermissionPageVO>();

        pageList.setPage( permissions.getPage() );
        pageList.setTotal( permissions.getTotal() );
        pageList.setSize( permissions.getSize() );
        pageList.setList( permissionEntityListToPermissionPageVOList( permissions.getList() ) );

        return pageList;
    }

    @Override
    public List<PermissionListVO> list(List<PermissionEntity> permissions) {
        if ( permissions == null ) {
            return null;
        }

        List<PermissionListVO> list = new ArrayList<PermissionListVO>( permissions.size() );
        for ( PermissionEntity permissionEntity : permissions ) {
            list.add( permissionEntityToPermissionListVO( permissionEntity ) );
        }

        return list;
    }

    @Override
    public PermissionDetailVO detail(PermissionEntity permissions) {
        if ( permissions == null ) {
            return null;
        }

        PermissionDetailVO permissionDetailVO = new PermissionDetailVO();

        permissionDetailVO.setId( permissions.getId() );
        permissionDetailVO.setStatus( permissions.getStatus() );
        permissionDetailVO.setRemark( permissions.getRemark() );
        permissionDetailVO.setCreator( permissions.getCreator() );
        permissionDetailVO.setUpdater( permissions.getUpdater() );
        permissionDetailVO.setCreateTime( permissions.getCreateTime() );
        permissionDetailVO.setUpdateTime( permissions.getUpdateTime() );
        permissionDetailVO.setIsDeleted( permissions.getIsDeleted() );
        permissionDetailVO.setTenantId( permissions.getTenantId() );
        permissionDetailVO.setVersion( permissions.getVersion() );
        permissionDetailVO.setParentId( permissions.getParentId() );
        permissionDetailVO.setName( permissions.getName() );
        permissionDetailVO.setCode( permissions.getCode() );
        permissionDetailVO.setPermission( permissions.getPermission() );
        permissionDetailVO.setType( permissions.getType() );
        permissionDetailVO.setSort( permissions.getSort() );
        permissionDetailVO.setVisible( permissions.getVisible() );
        permissionDetailVO.setIcon( permissions.getIcon() );
        permissionDetailVO.setDescription( permissions.getDescription() );

        return permissionDetailVO;
    }

    @Override
    public List<PermissionEntity> saveList(List<PermissionSaveDTO> permissions) {
        if ( permissions == null ) {
            return null;
        }

        List<PermissionEntity> list = new ArrayList<PermissionEntity>( permissions.size() );
        for ( PermissionSaveDTO permissionSaveDTO : permissions ) {
            list.add( permissionSaveDTOToPermissionEntity( permissionSaveDTO ) );
        }

        return list;
    }

    @Override
    public List<PermissionExportVO> export(List<PermissionEntity> permissions) {
        if ( permissions == null ) {
            return null;
        }

        List<PermissionExportVO> list = new ArrayList<PermissionExportVO>( permissions.size() );
        for ( PermissionEntity permissionEntity : permissions ) {
            list.add( permissionEntityToPermissionExportVO( permissionEntity ) );
        }

        return list;
    }

    @Override
    public List<PermissionSaveDTO> imports(List<PermissionExportVO> permissions) {
        if ( permissions == null ) {
            return null;
        }

        List<PermissionSaveDTO> list = new ArrayList<PermissionSaveDTO>( permissions.size() );
        for ( PermissionExportVO permissionExportVO : permissions ) {
            list.add( permissionExportVOToPermissionSaveDTO( permissionExportVO ) );
        }

        return list;
    }

    protected PermissionPageVO permissionEntityToPermissionPageVO(PermissionEntity permissionEntity) {
        if ( permissionEntity == null ) {
            return null;
        }

        PermissionPageVO permissionPageVO = new PermissionPageVO();

        permissionPageVO.setId( permissionEntity.getId() );
        permissionPageVO.setStatus( permissionEntity.getStatus() );
        permissionPageVO.setRemark( permissionEntity.getRemark() );
        permissionPageVO.setCreator( permissionEntity.getCreator() );
        permissionPageVO.setUpdater( permissionEntity.getUpdater() );
        permissionPageVO.setCreateTime( permissionEntity.getCreateTime() );
        permissionPageVO.setUpdateTime( permissionEntity.getUpdateTime() );
        permissionPageVO.setIsDeleted( permissionEntity.getIsDeleted() );
        permissionPageVO.setTenantId( permissionEntity.getTenantId() );
        permissionPageVO.setVersion( permissionEntity.getVersion() );
        permissionPageVO.setParentId( permissionEntity.getParentId() );
        permissionPageVO.setName( permissionEntity.getName() );
        permissionPageVO.setCode( permissionEntity.getCode() );
        permissionPageVO.setPermission( permissionEntity.getPermission() );
        permissionPageVO.setType( permissionEntity.getType() );
        permissionPageVO.setSort( permissionEntity.getSort() );
        permissionPageVO.setVisible( permissionEntity.getVisible() );
        permissionPageVO.setIcon( permissionEntity.getIcon() );
        permissionPageVO.setDescription( permissionEntity.getDescription() );

        return permissionPageVO;
    }

    protected List<PermissionPageVO> permissionEntityListToPermissionPageVOList(List<PermissionEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<PermissionPageVO> list1 = new ArrayList<PermissionPageVO>( list.size() );
        for ( PermissionEntity permissionEntity : list ) {
            list1.add( permissionEntityToPermissionPageVO( permissionEntity ) );
        }

        return list1;
    }

    protected PermissionListVO permissionEntityToPermissionListVO(PermissionEntity permissionEntity) {
        if ( permissionEntity == null ) {
            return null;
        }

        PermissionListVO permissionListVO = new PermissionListVO();

        permissionListVO.setId( permissionEntity.getId() );
        permissionListVO.setStatus( permissionEntity.getStatus() );
        permissionListVO.setRemark( permissionEntity.getRemark() );
        permissionListVO.setCreator( permissionEntity.getCreator() );
        permissionListVO.setUpdater( permissionEntity.getUpdater() );
        permissionListVO.setCreateTime( permissionEntity.getCreateTime() );
        permissionListVO.setUpdateTime( permissionEntity.getUpdateTime() );
        permissionListVO.setIsDeleted( permissionEntity.getIsDeleted() );
        permissionListVO.setTenantId( permissionEntity.getTenantId() );
        permissionListVO.setVersion( permissionEntity.getVersion() );
        permissionListVO.setParentId( permissionEntity.getParentId() );
        permissionListVO.setName( permissionEntity.getName() );
        permissionListVO.setCode( permissionEntity.getCode() );
        permissionListVO.setPermission( permissionEntity.getPermission() );
        permissionListVO.setType( permissionEntity.getType() );
        permissionListVO.setSort( permissionEntity.getSort() );
        permissionListVO.setVisible( permissionEntity.getVisible() );
        permissionListVO.setIcon( permissionEntity.getIcon() );
        permissionListVO.setDescription( permissionEntity.getDescription() );

        return permissionListVO;
    }

    protected PermissionEntity permissionSaveDTOToPermissionEntity(PermissionSaveDTO permissionSaveDTO) {
        if ( permissionSaveDTO == null ) {
            return null;
        }

        PermissionEntity permissionEntity = new PermissionEntity();

        permissionEntity.setId( permissionSaveDTO.getId() );
        permissionEntity.setStatus( permissionSaveDTO.getStatus() );
        permissionEntity.setRemark( permissionSaveDTO.getRemark() );
        permissionEntity.setCreator( permissionSaveDTO.getCreator() );
        permissionEntity.setUpdater( permissionSaveDTO.getUpdater() );
        permissionEntity.setCreateTime( permissionSaveDTO.getCreateTime() );
        permissionEntity.setUpdateTime( permissionSaveDTO.getUpdateTime() );
        permissionEntity.setIsDeleted( permissionSaveDTO.getIsDeleted() );
        permissionEntity.setTenantId( permissionSaveDTO.getTenantId() );
        permissionEntity.setVersion( permissionSaveDTO.getVersion() );
        permissionEntity.setParentId( permissionSaveDTO.getParentId() );
        permissionEntity.setName( permissionSaveDTO.getName() );
        permissionEntity.setCode( permissionSaveDTO.getCode() );
        permissionEntity.setPermission( permissionSaveDTO.getPermission() );
        permissionEntity.setType( permissionSaveDTO.getType() );
        permissionEntity.setSort( permissionSaveDTO.getSort() );
        permissionEntity.setVisible( permissionSaveDTO.getVisible() );
        permissionEntity.setIcon( permissionSaveDTO.getIcon() );
        permissionEntity.setDescription( permissionSaveDTO.getDescription() );

        return permissionEntity;
    }

    protected PermissionExportVO permissionEntityToPermissionExportVO(PermissionEntity permissionEntity) {
        if ( permissionEntity == null ) {
            return null;
        }

        PermissionExportVO permissionExportVO = new PermissionExportVO();

        permissionExportVO.setParentId( permissionEntity.getParentId() );
        permissionExportVO.setName( permissionEntity.getName() );
        permissionExportVO.setCode( permissionEntity.getCode() );
        permissionExportVO.setPermission( permissionEntity.getPermission() );
        permissionExportVO.setType( permissionEntity.getType() );
        permissionExportVO.setSort( permissionEntity.getSort() );
        permissionExportVO.setVisible( permissionEntity.getVisible() );
        permissionExportVO.setIcon( permissionEntity.getIcon() );
        permissionExportVO.setDescription( permissionEntity.getDescription() );

        return permissionExportVO;
    }

    protected PermissionSaveDTO permissionExportVOToPermissionSaveDTO(PermissionExportVO permissionExportVO) {
        if ( permissionExportVO == null ) {
            return null;
        }

        PermissionSaveDTO permissionSaveDTO = new PermissionSaveDTO();

        permissionSaveDTO.setParentId( permissionExportVO.getParentId() );
        permissionSaveDTO.setName( permissionExportVO.getName() );
        permissionSaveDTO.setCode( permissionExportVO.getCode() );
        permissionSaveDTO.setPermission( permissionExportVO.getPermission() );
        permissionSaveDTO.setType( permissionExportVO.getType() );
        permissionSaveDTO.setSort( permissionExportVO.getSort() );
        permissionSaveDTO.setVisible( permissionExportVO.getVisible() );
        permissionSaveDTO.setIcon( permissionExportVO.getIcon() );
        permissionSaveDTO.setDescription( permissionExportVO.getDescription() );

        return permissionSaveDTO;
    }
}
