package com.example.system.convert;

import com.example.framework.common.PageList;
import com.example.system.dal.dto.menu.MenuSaveDTO;
import com.example.system.dal.entity.MenuEntity;
import com.example.system.dal.vo.menu.MenuDetailVO;
import com.example.system.dal.vo.menu.MenuExportVO;
import com.example.system.dal.vo.menu.MenuListVO;
import com.example.system.dal.vo.menu.MenuPageVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-15T23:28:28+0800",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 1.8.0_311 (Oracle Corporation)"
)
public class MenuConvertImpl implements MenuConvert {

    @Override
    public PageList<MenuPageVO> page(PageList<MenuEntity> menus) {
        if ( menus == null ) {
            return null;
        }

        PageList<MenuPageVO> pageList = new PageList<MenuPageVO>();

        pageList.setPage( menus.getPage() );
        pageList.setTotal( menus.getTotal() );
        pageList.setSize( menus.getSize() );
        pageList.setList( menuEntityListToMenuPageVOList( menus.getList() ) );

        return pageList;
    }

    @Override
    public List<MenuListVO> list(List<MenuEntity> menus) {
        if ( menus == null ) {
            return null;
        }

        List<MenuListVO> list = new ArrayList<MenuListVO>( menus.size() );
        for ( MenuEntity menuEntity : menus ) {
            list.add( menuEntityToMenuListVO( menuEntity ) );
        }

        return list;
    }

    @Override
    public MenuDetailVO detail(MenuEntity menus) {
        if ( menus == null ) {
            return null;
        }

        MenuDetailVO menuDetailVO = new MenuDetailVO();

        menuDetailVO.setId( menus.getId() );
        menuDetailVO.setStatus( menus.getStatus() );
        menuDetailVO.setRemark( menus.getRemark() );
        menuDetailVO.setCreator( menus.getCreator() );
        menuDetailVO.setUpdater( menus.getUpdater() );
        menuDetailVO.setCreateTime( menus.getCreateTime() );
        menuDetailVO.setUpdateTime( menus.getUpdateTime() );
        menuDetailVO.setIsDeleted( menus.getIsDeleted() );
        menuDetailVO.setTenantId( menus.getTenantId() );
        menuDetailVO.setVersion( menus.getVersion() );
        menuDetailVO.setParentId( menus.getParentId() );
        menuDetailVO.setTitle( menus.getTitle() );
        menuDetailVO.setName( menus.getName() );
        menuDetailVO.setPath( menus.getPath() );
        menuDetailVO.setType( menus.getType() );
        menuDetailVO.setComponent( menus.getComponent() );
        menuDetailVO.setPermission( menus.getPermission() );
        menuDetailVO.setLevel( menus.getLevel() );
        menuDetailVO.setSort( menus.getSort() );
        menuDetailVO.setVisible( menus.getVisible() );
        menuDetailVO.setKeepAlive( menus.getKeepAlive() );
        menuDetailVO.setAlwaysShow( menus.getAlwaysShow() );
        menuDetailVO.setIcon( menus.getIcon() );
        menuDetailVO.setDescription( menus.getDescription() );
        menuDetailVO.setMeta( menus.getMeta() );

        return menuDetailVO;
    }

    @Override
    public List<MenuEntity> saveList(List<MenuSaveDTO> menus) {
        if ( menus == null ) {
            return null;
        }

        List<MenuEntity> list = new ArrayList<MenuEntity>( menus.size() );
        for ( MenuSaveDTO menuSaveDTO : menus ) {
            list.add( menuSaveDTOToMenuEntity( menuSaveDTO ) );
        }

        return list;
    }

    @Override
    public List<MenuExportVO> export(List<MenuEntity> menus) {
        if ( menus == null ) {
            return null;
        }

        List<MenuExportVO> list = new ArrayList<MenuExportVO>( menus.size() );
        for ( MenuEntity menuEntity : menus ) {
            list.add( menuEntityToMenuExportVO( menuEntity ) );
        }

        return list;
    }

    protected MenuPageVO menuEntityToMenuPageVO(MenuEntity menuEntity) {
        if ( menuEntity == null ) {
            return null;
        }

        MenuPageVO menuPageVO = new MenuPageVO();

        menuPageVO.setId( menuEntity.getId() );
        menuPageVO.setStatus( menuEntity.getStatus() );
        menuPageVO.setRemark( menuEntity.getRemark() );
        menuPageVO.setCreator( menuEntity.getCreator() );
        menuPageVO.setUpdater( menuEntity.getUpdater() );
        menuPageVO.setCreateTime( menuEntity.getCreateTime() );
        menuPageVO.setUpdateTime( menuEntity.getUpdateTime() );
        menuPageVO.setIsDeleted( menuEntity.getIsDeleted() );
        menuPageVO.setTenantId( menuEntity.getTenantId() );
        menuPageVO.setVersion( menuEntity.getVersion() );
        menuPageVO.setParentId( menuEntity.getParentId() );
        menuPageVO.setTitle( menuEntity.getTitle() );
        menuPageVO.setName( menuEntity.getName() );
        menuPageVO.setPath( menuEntity.getPath() );
        menuPageVO.setType( menuEntity.getType() );
        menuPageVO.setComponent( menuEntity.getComponent() );
        menuPageVO.setPermission( menuEntity.getPermission() );
        menuPageVO.setLevel( menuEntity.getLevel() );
        menuPageVO.setSort( menuEntity.getSort() );
        menuPageVO.setVisible( menuEntity.getVisible() );
        menuPageVO.setKeepAlive( menuEntity.getKeepAlive() );
        menuPageVO.setAlwaysShow( menuEntity.getAlwaysShow() );
        menuPageVO.setIcon( menuEntity.getIcon() );
        menuPageVO.setDescription( menuEntity.getDescription() );
        menuPageVO.setMeta( menuEntity.getMeta() );

        return menuPageVO;
    }

    protected List<MenuPageVO> menuEntityListToMenuPageVOList(List<MenuEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<MenuPageVO> list1 = new ArrayList<MenuPageVO>( list.size() );
        for ( MenuEntity menuEntity : list ) {
            list1.add( menuEntityToMenuPageVO( menuEntity ) );
        }

        return list1;
    }

    protected MenuListVO menuEntityToMenuListVO(MenuEntity menuEntity) {
        if ( menuEntity == null ) {
            return null;
        }

        MenuListVO menuListVO = new MenuListVO();

        menuListVO.setId( menuEntity.getId() );
        menuListVO.setStatus( menuEntity.getStatus() );
        menuListVO.setRemark( menuEntity.getRemark() );
        menuListVO.setCreator( menuEntity.getCreator() );
        menuListVO.setUpdater( menuEntity.getUpdater() );
        menuListVO.setCreateTime( menuEntity.getCreateTime() );
        menuListVO.setUpdateTime( menuEntity.getUpdateTime() );
        menuListVO.setIsDeleted( menuEntity.getIsDeleted() );
        menuListVO.setTenantId( menuEntity.getTenantId() );
        menuListVO.setVersion( menuEntity.getVersion() );
        menuListVO.setParentId( menuEntity.getParentId() );
        menuListVO.setTitle( menuEntity.getTitle() );
        menuListVO.setName( menuEntity.getName() );
        menuListVO.setPath( menuEntity.getPath() );
        menuListVO.setType( menuEntity.getType() );
        menuListVO.setComponent( menuEntity.getComponent() );
        menuListVO.setPermission( menuEntity.getPermission() );
        menuListVO.setLevel( menuEntity.getLevel() );
        menuListVO.setSort( menuEntity.getSort() );
        menuListVO.setVisible( menuEntity.getVisible() );
        menuListVO.setKeepAlive( menuEntity.getKeepAlive() );
        menuListVO.setAlwaysShow( menuEntity.getAlwaysShow() );
        menuListVO.setIcon( menuEntity.getIcon() );
        menuListVO.setDescription( menuEntity.getDescription() );
        menuListVO.setMeta( menuEntity.getMeta() );

        return menuListVO;
    }

    protected MenuEntity menuSaveDTOToMenuEntity(MenuSaveDTO menuSaveDTO) {
        if ( menuSaveDTO == null ) {
            return null;
        }

        MenuEntity menuEntity = new MenuEntity();

        menuEntity.setId( menuSaveDTO.getId() );
        menuEntity.setStatus( menuSaveDTO.getStatus() );
        menuEntity.setRemark( menuSaveDTO.getRemark() );
        menuEntity.setCreator( menuSaveDTO.getCreator() );
        menuEntity.setUpdater( menuSaveDTO.getUpdater() );
        menuEntity.setCreateTime( menuSaveDTO.getCreateTime() );
        menuEntity.setUpdateTime( menuSaveDTO.getUpdateTime() );
        menuEntity.setIsDeleted( menuSaveDTO.getIsDeleted() );
        menuEntity.setTenantId( menuSaveDTO.getTenantId() );
        menuEntity.setVersion( menuSaveDTO.getVersion() );
        menuEntity.setParentId( menuSaveDTO.getParentId() );
        menuEntity.setTitle( menuSaveDTO.getTitle() );
        menuEntity.setName( menuSaveDTO.getName() );
        menuEntity.setPath( menuSaveDTO.getPath() );
        menuEntity.setType( menuSaveDTO.getType() );
        menuEntity.setComponent( menuSaveDTO.getComponent() );
        menuEntity.setPermission( menuSaveDTO.getPermission() );
        menuEntity.setLevel( menuSaveDTO.getLevel() );
        menuEntity.setSort( menuSaveDTO.getSort() );
        menuEntity.setVisible( menuSaveDTO.getVisible() );
        menuEntity.setKeepAlive( menuSaveDTO.getKeepAlive() );
        menuEntity.setAlwaysShow( menuSaveDTO.getAlwaysShow() );
        menuEntity.setIcon( menuSaveDTO.getIcon() );
        menuEntity.setDescription( menuSaveDTO.getDescription() );
        menuEntity.setMeta( menuSaveDTO.getMeta() );

        return menuEntity;
    }

    protected MenuExportVO menuEntityToMenuExportVO(MenuEntity menuEntity) {
        if ( menuEntity == null ) {
            return null;
        }

        MenuExportVO menuExportVO = new MenuExportVO();

        menuExportVO.setId( menuEntity.getId() );
        menuExportVO.setParentId( menuEntity.getParentId() );
        menuExportVO.setTitle( menuEntity.getTitle() );
        menuExportVO.setName( menuEntity.getName() );
        menuExportVO.setPath( menuEntity.getPath() );
        menuExportVO.setType( menuEntity.getType() );
        menuExportVO.setComponent( menuEntity.getComponent() );
        menuExportVO.setPermission( menuEntity.getPermission() );
        menuExportVO.setLevel( menuEntity.getLevel() );
        menuExportVO.setSort( menuEntity.getSort() );
        menuExportVO.setVisible( menuEntity.getVisible() );
        menuExportVO.setKeepAlive( menuEntity.getKeepAlive() );
        menuExportVO.setAlwaysShow( menuEntity.getAlwaysShow() );
        menuExportVO.setIcon( menuEntity.getIcon() );
        menuExportVO.setDescription( menuEntity.getDescription() );
        menuExportVO.setMeta( menuEntity.getMeta() );

        return menuExportVO;
    }
}
