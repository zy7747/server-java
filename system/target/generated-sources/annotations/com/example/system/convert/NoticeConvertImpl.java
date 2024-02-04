package com.example.system.convert;

import com.example.framework.common.PageList;
import com.example.system.dal.dto.notice.NoticeSaveDTO;
import com.example.system.dal.entity.NoticeEntity;
import com.example.system.dal.vo.notice.NoticeDetailVO;
import com.example.system.dal.vo.notice.NoticeExportVO;
import com.example.system.dal.vo.notice.NoticeListVO;
import com.example.system.dal.vo.notice.NoticePageVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-04T15:46:33+0800",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 1.8.0_311 (Oracle Corporation)"
)
public class NoticeConvertImpl implements NoticeConvert {

    @Override
    public PageList<NoticePageVO> page(PageList<NoticeEntity> notices) {
        if ( notices == null ) {
            return null;
        }

        PageList<NoticePageVO> pageList = new PageList<NoticePageVO>();

        pageList.setPage( notices.getPage() );
        pageList.setTotal( notices.getTotal() );
        pageList.setSize( notices.getSize() );
        pageList.setList( noticeEntityListToNoticePageVOList( notices.getList() ) );

        return pageList;
    }

    @Override
    public List<NoticeListVO> list(List<NoticeEntity> notices) {
        if ( notices == null ) {
            return null;
        }

        List<NoticeListVO> list = new ArrayList<NoticeListVO>( notices.size() );
        for ( NoticeEntity noticeEntity : notices ) {
            list.add( noticeEntityToNoticeListVO( noticeEntity ) );
        }

        return list;
    }

    @Override
    public NoticeDetailVO detail(NoticeEntity notices) {
        if ( notices == null ) {
            return null;
        }

        NoticeDetailVO noticeDetailVO = new NoticeDetailVO();

        noticeDetailVO.setId( notices.getId() );
        noticeDetailVO.setStatus( notices.getStatus() );
        noticeDetailVO.setRemark( notices.getRemark() );
        noticeDetailVO.setCreator( notices.getCreator() );
        noticeDetailVO.setUpdater( notices.getUpdater() );
        noticeDetailVO.setCreateTime( notices.getCreateTime() );
        noticeDetailVO.setUpdateTime( notices.getUpdateTime() );
        noticeDetailVO.setIsDeleted( notices.getIsDeleted() );
        noticeDetailVO.setTenantId( notices.getTenantId() );
        noticeDetailVO.setVersion( notices.getVersion() );
        noticeDetailVO.setNoticeName( notices.getNoticeName() );
        noticeDetailVO.setNoticeContent( notices.getNoticeContent() );
        noticeDetailVO.setPushModule( notices.getPushModule() );
        noticeDetailVO.setType( notices.getType() );
        noticeDetailVO.setIsRead( notices.getIsRead() );
        noticeDetailVO.setReceiver( notices.getReceiver() );

        return noticeDetailVO;
    }

    @Override
    public List<NoticeEntity> saveList(List<NoticeSaveDTO> notices) {
        if ( notices == null ) {
            return null;
        }

        List<NoticeEntity> list = new ArrayList<NoticeEntity>( notices.size() );
        for ( NoticeSaveDTO noticeSaveDTO : notices ) {
            list.add( save( noticeSaveDTO ) );
        }

        return list;
    }

    @Override
    public NoticeEntity save(NoticeSaveDTO notices) {
        if ( notices == null ) {
            return null;
        }

        NoticeEntity noticeEntity = new NoticeEntity();

        noticeEntity.setId( notices.getId() );
        noticeEntity.setStatus( notices.getStatus() );
        noticeEntity.setRemark( notices.getRemark() );
        noticeEntity.setCreator( notices.getCreator() );
        noticeEntity.setUpdater( notices.getUpdater() );
        noticeEntity.setCreateTime( notices.getCreateTime() );
        noticeEntity.setUpdateTime( notices.getUpdateTime() );
        noticeEntity.setIsDeleted( notices.getIsDeleted() );
        noticeEntity.setTenantId( notices.getTenantId() );
        noticeEntity.setVersion( notices.getVersion() );
        noticeEntity.setNoticeName( notices.getNoticeName() );
        noticeEntity.setNoticeContent( notices.getNoticeContent() );
        noticeEntity.setPushModule( notices.getPushModule() );
        noticeEntity.setType( notices.getType() );
        noticeEntity.setIsRead( notices.getIsRead() );

        return noticeEntity;
    }

    @Override
    public List<NoticeExportVO> export(List<NoticeEntity> notices) {
        if ( notices == null ) {
            return null;
        }

        List<NoticeExportVO> list = new ArrayList<NoticeExportVO>( notices.size() );
        for ( NoticeEntity noticeEntity : notices ) {
            list.add( noticeEntityToNoticeExportVO( noticeEntity ) );
        }

        return list;
    }

    @Override
    public List<NoticeSaveDTO> imports(List<NoticeExportVO> notices) {
        if ( notices == null ) {
            return null;
        }

        List<NoticeSaveDTO> list = new ArrayList<NoticeSaveDTO>( notices.size() );
        for ( NoticeExportVO noticeExportVO : notices ) {
            list.add( noticeExportVOToNoticeSaveDTO( noticeExportVO ) );
        }

        return list;
    }

    protected NoticePageVO noticeEntityToNoticePageVO(NoticeEntity noticeEntity) {
        if ( noticeEntity == null ) {
            return null;
        }

        NoticePageVO noticePageVO = new NoticePageVO();

        noticePageVO.setId( noticeEntity.getId() );
        noticePageVO.setStatus( noticeEntity.getStatus() );
        noticePageVO.setRemark( noticeEntity.getRemark() );
        noticePageVO.setCreator( noticeEntity.getCreator() );
        noticePageVO.setUpdater( noticeEntity.getUpdater() );
        noticePageVO.setCreateTime( noticeEntity.getCreateTime() );
        noticePageVO.setUpdateTime( noticeEntity.getUpdateTime() );
        noticePageVO.setIsDeleted( noticeEntity.getIsDeleted() );
        noticePageVO.setTenantId( noticeEntity.getTenantId() );
        noticePageVO.setVersion( noticeEntity.getVersion() );
        noticePageVO.setNoticeName( noticeEntity.getNoticeName() );
        noticePageVO.setNoticeContent( noticeEntity.getNoticeContent() );
        noticePageVO.setPushModule( noticeEntity.getPushModule() );
        noticePageVO.setType( noticeEntity.getType() );
        noticePageVO.setIsRead( noticeEntity.getIsRead() );
        noticePageVO.setReceiver( noticeEntity.getReceiver() );

        return noticePageVO;
    }

    protected List<NoticePageVO> noticeEntityListToNoticePageVOList(List<NoticeEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<NoticePageVO> list1 = new ArrayList<NoticePageVO>( list.size() );
        for ( NoticeEntity noticeEntity : list ) {
            list1.add( noticeEntityToNoticePageVO( noticeEntity ) );
        }

        return list1;
    }

    protected NoticeListVO noticeEntityToNoticeListVO(NoticeEntity noticeEntity) {
        if ( noticeEntity == null ) {
            return null;
        }

        NoticeListVO noticeListVO = new NoticeListVO();

        noticeListVO.setId( noticeEntity.getId() );
        noticeListVO.setStatus( noticeEntity.getStatus() );
        noticeListVO.setRemark( noticeEntity.getRemark() );
        noticeListVO.setCreator( noticeEntity.getCreator() );
        noticeListVO.setUpdater( noticeEntity.getUpdater() );
        noticeListVO.setCreateTime( noticeEntity.getCreateTime() );
        noticeListVO.setUpdateTime( noticeEntity.getUpdateTime() );
        noticeListVO.setIsDeleted( noticeEntity.getIsDeleted() );
        noticeListVO.setTenantId( noticeEntity.getTenantId() );
        noticeListVO.setVersion( noticeEntity.getVersion() );
        noticeListVO.setNoticeName( noticeEntity.getNoticeName() );
        noticeListVO.setNoticeContent( noticeEntity.getNoticeContent() );
        noticeListVO.setPushModule( noticeEntity.getPushModule() );
        noticeListVO.setType( noticeEntity.getType() );
        noticeListVO.setIsRead( noticeEntity.getIsRead() );
        noticeListVO.setReceiver( noticeEntity.getReceiver() );

        return noticeListVO;
    }

    protected NoticeExportVO noticeEntityToNoticeExportVO(NoticeEntity noticeEntity) {
        if ( noticeEntity == null ) {
            return null;
        }

        NoticeExportVO noticeExportVO = new NoticeExportVO();

        noticeExportVO.setNoticeName( noticeEntity.getNoticeName() );
        noticeExportVO.setNoticeContent( noticeEntity.getNoticeContent() );
        noticeExportVO.setPushModule( noticeEntity.getPushModule() );
        noticeExportVO.setType( noticeEntity.getType() );
        noticeExportVO.setIsRead( noticeEntity.getIsRead() );
        noticeExportVO.setReceiver( noticeEntity.getReceiver() );

        return noticeExportVO;
    }

    protected NoticeSaveDTO noticeExportVOToNoticeSaveDTO(NoticeExportVO noticeExportVO) {
        if ( noticeExportVO == null ) {
            return null;
        }

        NoticeSaveDTO noticeSaveDTO = new NoticeSaveDTO();

        noticeSaveDTO.setNoticeName( noticeExportVO.getNoticeName() );
        noticeSaveDTO.setNoticeContent( noticeExportVO.getNoticeContent() );
        noticeSaveDTO.setPushModule( noticeExportVO.getPushModule() );
        noticeSaveDTO.setType( noticeExportVO.getType() );
        noticeSaveDTO.setIsRead( noticeExportVO.getIsRead() );

        return noticeSaveDTO;
    }
}
