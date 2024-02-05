package com.example.system.convert;

import com.example.framework.common.PageList;
import com.example.system.dal.dto.page.PageSaveDTO;
import com.example.system.dal.entity.PageEntity;
import com.example.system.dal.vo.page.PageDetailVO;
import com.example.system.dal.vo.page.PageExportVO;
import com.example.system.dal.vo.page.PageListVO;
import com.example.system.dal.vo.page.PagePageVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-05T16:38:56+0800",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 1.8.0_311 (Oracle Corporation)"
)
public class PageConvertImpl implements PageConvert {

    @Override
    public PageList<PagePageVO> page(PageList<PageEntity> pages) {
        if ( pages == null ) {
            return null;
        }

        PageList<PagePageVO> pageList = new PageList<PagePageVO>();

        pageList.setPage( pages.getPage() );
        pageList.setTotal( pages.getTotal() );
        pageList.setSize( pages.getSize() );
        pageList.setList( pageEntityListToPagePageVOList( pages.getList() ) );

        return pageList;
    }

    @Override
    public List<PageListVO> list(List<PageEntity> pages) {
        if ( pages == null ) {
            return null;
        }

        List<PageListVO> list = new ArrayList<PageListVO>( pages.size() );
        for ( PageEntity pageEntity : pages ) {
            list.add( pageEntityToPageListVO( pageEntity ) );
        }

        return list;
    }

    @Override
    public PageDetailVO detail(PageEntity pages) {
        if ( pages == null ) {
            return null;
        }

        PageDetailVO pageDetailVO = new PageDetailVO();

        pageDetailVO.setId( pages.getId() );
        pageDetailVO.setStatus( pages.getStatus() );
        pageDetailVO.setRemark( pages.getRemark() );
        pageDetailVO.setCreator( pages.getCreator() );
        pageDetailVO.setUpdater( pages.getUpdater() );
        pageDetailVO.setCreateTime( pages.getCreateTime() );
        pageDetailVO.setUpdateTime( pages.getUpdateTime() );
        pageDetailVO.setIsDeleted( pages.getIsDeleted() );
        pageDetailVO.setTenantId( pages.getTenantId() );
        pageDetailVO.setVersion( pages.getVersion() );
        pageDetailVO.setMenuId( pages.getMenuId() );
        pageDetailVO.setTitle( pages.getTitle() );
        pageDetailVO.setApi( pages.getApi() );
        pageDetailVO.setPermission( pages.getPermission() );
        pageDetailVO.setContent( pages.getContent() );

        return pageDetailVO;
    }

    @Override
    public List<PageEntity> saveList(List<PageSaveDTO> pages) {
        if ( pages == null ) {
            return null;
        }

        List<PageEntity> list = new ArrayList<PageEntity>( pages.size() );
        for ( PageSaveDTO pageSaveDTO : pages ) {
            list.add( pageSaveDTOToPageEntity( pageSaveDTO ) );
        }

        return list;
    }

    @Override
    public List<PageExportVO> export(List<PageEntity> pages) {
        if ( pages == null ) {
            return null;
        }

        List<PageExportVO> list = new ArrayList<PageExportVO>( pages.size() );
        for ( PageEntity pageEntity : pages ) {
            list.add( pageEntityToPageExportVO( pageEntity ) );
        }

        return list;
    }

    @Override
    public List<PageSaveDTO> imports(List<PageExportVO> pages) {
        if ( pages == null ) {
            return null;
        }

        List<PageSaveDTO> list = new ArrayList<PageSaveDTO>( pages.size() );
        for ( PageExportVO pageExportVO : pages ) {
            list.add( pageExportVOToPageSaveDTO( pageExportVO ) );
        }

        return list;
    }

    protected PagePageVO pageEntityToPagePageVO(PageEntity pageEntity) {
        if ( pageEntity == null ) {
            return null;
        }

        PagePageVO pagePageVO = new PagePageVO();

        pagePageVO.setId( pageEntity.getId() );
        pagePageVO.setStatus( pageEntity.getStatus() );
        pagePageVO.setRemark( pageEntity.getRemark() );
        pagePageVO.setCreator( pageEntity.getCreator() );
        pagePageVO.setUpdater( pageEntity.getUpdater() );
        pagePageVO.setCreateTime( pageEntity.getCreateTime() );
        pagePageVO.setUpdateTime( pageEntity.getUpdateTime() );
        pagePageVO.setIsDeleted( pageEntity.getIsDeleted() );
        pagePageVO.setTenantId( pageEntity.getTenantId() );
        pagePageVO.setVersion( pageEntity.getVersion() );
        pagePageVO.setMenuId( pageEntity.getMenuId() );
        pagePageVO.setTitle( pageEntity.getTitle() );
        pagePageVO.setApi( pageEntity.getApi() );
        pagePageVO.setPermission( pageEntity.getPermission() );
        pagePageVO.setContent( pageEntity.getContent() );

        return pagePageVO;
    }

    protected List<PagePageVO> pageEntityListToPagePageVOList(List<PageEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<PagePageVO> list1 = new ArrayList<PagePageVO>( list.size() );
        for ( PageEntity pageEntity : list ) {
            list1.add( pageEntityToPagePageVO( pageEntity ) );
        }

        return list1;
    }

    protected PageListVO pageEntityToPageListVO(PageEntity pageEntity) {
        if ( pageEntity == null ) {
            return null;
        }

        PageListVO pageListVO = new PageListVO();

        pageListVO.setId( pageEntity.getId() );
        pageListVO.setStatus( pageEntity.getStatus() );
        pageListVO.setRemark( pageEntity.getRemark() );
        pageListVO.setCreator( pageEntity.getCreator() );
        pageListVO.setUpdater( pageEntity.getUpdater() );
        pageListVO.setCreateTime( pageEntity.getCreateTime() );
        pageListVO.setUpdateTime( pageEntity.getUpdateTime() );
        pageListVO.setIsDeleted( pageEntity.getIsDeleted() );
        pageListVO.setTenantId( pageEntity.getTenantId() );
        pageListVO.setVersion( pageEntity.getVersion() );
        pageListVO.setMenuId( pageEntity.getMenuId() );
        pageListVO.setTitle( pageEntity.getTitle() );
        pageListVO.setApi( pageEntity.getApi() );
        pageListVO.setPermission( pageEntity.getPermission() );
        pageListVO.setContent( pageEntity.getContent() );

        return pageListVO;
    }

    protected PageEntity pageSaveDTOToPageEntity(PageSaveDTO pageSaveDTO) {
        if ( pageSaveDTO == null ) {
            return null;
        }

        PageEntity pageEntity = new PageEntity();

        pageEntity.setId( pageSaveDTO.getId() );
        pageEntity.setStatus( pageSaveDTO.getStatus() );
        pageEntity.setRemark( pageSaveDTO.getRemark() );
        pageEntity.setCreator( pageSaveDTO.getCreator() );
        pageEntity.setUpdater( pageSaveDTO.getUpdater() );
        pageEntity.setCreateTime( pageSaveDTO.getCreateTime() );
        pageEntity.setUpdateTime( pageSaveDTO.getUpdateTime() );
        pageEntity.setIsDeleted( pageSaveDTO.getIsDeleted() );
        pageEntity.setTenantId( pageSaveDTO.getTenantId() );
        pageEntity.setVersion( pageSaveDTO.getVersion() );
        pageEntity.setMenuId( pageSaveDTO.getMenuId() );
        pageEntity.setTitle( pageSaveDTO.getTitle() );
        pageEntity.setApi( pageSaveDTO.getApi() );
        pageEntity.setPermission( pageSaveDTO.getPermission() );
        pageEntity.setContent( pageSaveDTO.getContent() );

        return pageEntity;
    }

    protected PageExportVO pageEntityToPageExportVO(PageEntity pageEntity) {
        if ( pageEntity == null ) {
            return null;
        }

        PageExportVO pageExportVO = new PageExportVO();

        pageExportVO.setContent( pageEntity.getContent() );

        return pageExportVO;
    }

    protected PageSaveDTO pageExportVOToPageSaveDTO(PageExportVO pageExportVO) {
        if ( pageExportVO == null ) {
            return null;
        }

        PageSaveDTO pageSaveDTO = new PageSaveDTO();

        pageSaveDTO.setContent( pageExportVO.getContent() );

        return pageSaveDTO;
    }
}
