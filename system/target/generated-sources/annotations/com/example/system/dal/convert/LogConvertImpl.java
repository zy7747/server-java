package com.example.system.dal.convert;

import com.example.framework.common.PageList;
import com.example.system.dal.dto.log.LogSaveDTO;
import com.example.system.dal.entity.LogEntity;
import com.example.system.dal.vo.log.LogDetailVO;
import com.example.system.dal.vo.log.LogExportVO;
import com.example.system.dal.vo.log.LogListVO;
import com.example.system.dal.vo.log.LogPageVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-07T22:09:28+0800",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 1.8.0_311 (Oracle Corporation)"
)
public class LogConvertImpl implements LogConvert {

    @Override
    public PageList<LogPageVO> page(PageList<LogEntity> logs) {
        if ( logs == null ) {
            return null;
        }

        PageList<LogPageVO> pageList = new PageList<LogPageVO>();

        pageList.setPage( logs.getPage() );
        pageList.setTotal( logs.getTotal() );
        pageList.setSize( logs.getSize() );
        pageList.setList( logEntityListToLogPageVOList( logs.getList() ) );

        return pageList;
    }

    @Override
    public List<LogListVO> list(List<LogEntity> logs) {
        if ( logs == null ) {
            return null;
        }

        List<LogListVO> list = new ArrayList<LogListVO>( logs.size() );
        for ( LogEntity logEntity : logs ) {
            list.add( logEntityToLogListVO( logEntity ) );
        }

        return list;
    }

    @Override
    public LogDetailVO detail(LogEntity logs) {
        if ( logs == null ) {
            return null;
        }

        LogDetailVO logDetailVO = new LogDetailVO();

        logDetailVO.setId( logs.getId() );
        logDetailVO.setStatus( logs.getStatus() );
        logDetailVO.setCreator( logs.getCreator() );
        logDetailVO.setUpdater( logs.getUpdater() );
        logDetailVO.setCreateTime( logs.getCreateTime() );
        logDetailVO.setUpdateTime( logs.getUpdateTime() );
        logDetailVO.setIsDeleted( logs.getIsDeleted() );
        logDetailVO.setTenantId( logs.getTenantId() );
        logDetailVO.setVersion( logs.getVersion() );
        logDetailVO.setOperateModules( logs.getOperateModules() );
        logDetailVO.setOperateContent( logs.getOperateContent() );
        logDetailVO.setOperateType( logs.getOperateType() );
        logDetailVO.setOperatePlace( logs.getOperatePlace() );
        logDetailVO.setRemark( logs.getRemark() );
        logDetailVO.setTime( logs.getTime() );

        return logDetailVO;
    }

    @Override
    public List<LogEntity> saveList(List<LogSaveDTO> logs) {
        if ( logs == null ) {
            return null;
        }

        List<LogEntity> list = new ArrayList<LogEntity>( logs.size() );
        for ( LogSaveDTO logSaveDTO : logs ) {
            list.add( logSaveDTOToLogEntity( logSaveDTO ) );
        }

        return list;
    }

    @Override
    public List<LogExportVO> export(List<LogEntity> logs) {
        if ( logs == null ) {
            return null;
        }

        List<LogExportVO> list = new ArrayList<LogExportVO>( logs.size() );
        for ( LogEntity logEntity : logs ) {
            list.add( logEntityToLogExportVO( logEntity ) );
        }

        return list;
    }

    @Override
    public List<LogSaveDTO> imports(List<LogExportVO> logs) {
        if ( logs == null ) {
            return null;
        }

        List<LogSaveDTO> list = new ArrayList<LogSaveDTO>( logs.size() );
        for ( LogExportVO logExportVO : logs ) {
            list.add( logExportVOToLogSaveDTO( logExportVO ) );
        }

        return list;
    }

    protected LogPageVO logEntityToLogPageVO(LogEntity logEntity) {
        if ( logEntity == null ) {
            return null;
        }

        LogPageVO logPageVO = new LogPageVO();

        logPageVO.setId( logEntity.getId() );
        logPageVO.setStatus( logEntity.getStatus() );
        logPageVO.setCreator( logEntity.getCreator() );
        logPageVO.setUpdater( logEntity.getUpdater() );
        logPageVO.setCreateTime( logEntity.getCreateTime() );
        logPageVO.setUpdateTime( logEntity.getUpdateTime() );
        logPageVO.setIsDeleted( logEntity.getIsDeleted() );
        logPageVO.setTenantId( logEntity.getTenantId() );
        logPageVO.setVersion( logEntity.getVersion() );
        logPageVO.setOperateModules( logEntity.getOperateModules() );
        logPageVO.setOperateContent( logEntity.getOperateContent() );
        logPageVO.setOperateType( logEntity.getOperateType() );
        logPageVO.setOperatePlace( logEntity.getOperatePlace() );
        logPageVO.setRemark( logEntity.getRemark() );
        logPageVO.setTime( logEntity.getTime() );

        return logPageVO;
    }

    protected List<LogPageVO> logEntityListToLogPageVOList(List<LogEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<LogPageVO> list1 = new ArrayList<LogPageVO>( list.size() );
        for ( LogEntity logEntity : list ) {
            list1.add( logEntityToLogPageVO( logEntity ) );
        }

        return list1;
    }

    protected LogListVO logEntityToLogListVO(LogEntity logEntity) {
        if ( logEntity == null ) {
            return null;
        }

        LogListVO logListVO = new LogListVO();

        logListVO.setId( logEntity.getId() );
        logListVO.setStatus( logEntity.getStatus() );
        logListVO.setCreator( logEntity.getCreator() );
        logListVO.setUpdater( logEntity.getUpdater() );
        logListVO.setCreateTime( logEntity.getCreateTime() );
        logListVO.setUpdateTime( logEntity.getUpdateTime() );
        logListVO.setIsDeleted( logEntity.getIsDeleted() );
        logListVO.setTenantId( logEntity.getTenantId() );
        logListVO.setVersion( logEntity.getVersion() );
        logListVO.setOperateModules( logEntity.getOperateModules() );
        logListVO.setOperateContent( logEntity.getOperateContent() );
        logListVO.setOperateType( logEntity.getOperateType() );
        logListVO.setOperatePlace( logEntity.getOperatePlace() );
        logListVO.setRemark( logEntity.getRemark() );
        logListVO.setTime( logEntity.getTime() );

        return logListVO;
    }

    protected LogEntity logSaveDTOToLogEntity(LogSaveDTO logSaveDTO) {
        if ( logSaveDTO == null ) {
            return null;
        }

        LogEntity logEntity = new LogEntity();

        logEntity.setId( logSaveDTO.getId() );
        logEntity.setStatus( logSaveDTO.getStatus() );
        logEntity.setCreator( logSaveDTO.getCreator() );
        logEntity.setUpdater( logSaveDTO.getUpdater() );
        logEntity.setCreateTime( logSaveDTO.getCreateTime() );
        logEntity.setUpdateTime( logSaveDTO.getUpdateTime() );
        logEntity.setIsDeleted( logSaveDTO.getIsDeleted() );
        logEntity.setTenantId( logSaveDTO.getTenantId() );
        logEntity.setVersion( logSaveDTO.getVersion() );
        logEntity.setOperateModules( logSaveDTO.getOperateModules() );
        logEntity.setOperateContent( logSaveDTO.getOperateContent() );
        logEntity.setOperateType( logSaveDTO.getOperateType() );
        logEntity.setOperatePlace( logSaveDTO.getOperatePlace() );
        logEntity.setRemark( logSaveDTO.getRemark() );
        logEntity.setTime( logSaveDTO.getTime() );

        return logEntity;
    }

    protected LogExportVO logEntityToLogExportVO(LogEntity logEntity) {
        if ( logEntity == null ) {
            return null;
        }

        LogExportVO logExportVO = new LogExportVO();

        logExportVO.setOperateModules( logEntity.getOperateModules() );
        logExportVO.setOperateContent( logEntity.getOperateContent() );
        logExportVO.setOperateType( logEntity.getOperateType() );
        logExportVO.setOperatePlace( logEntity.getOperatePlace() );
        logExportVO.setRemark( logEntity.getRemark() );
        logExportVO.setTime( logEntity.getTime() );

        return logExportVO;
    }

    protected LogSaveDTO logExportVOToLogSaveDTO(LogExportVO logExportVO) {
        if ( logExportVO == null ) {
            return null;
        }

        LogSaveDTO logSaveDTO = new LogSaveDTO();

        logSaveDTO.setOperateModules( logExportVO.getOperateModules() );
        logSaveDTO.setOperateContent( logExportVO.getOperateContent() );
        logSaveDTO.setOperateType( logExportVO.getOperateType() );
        logSaveDTO.setOperatePlace( logExportVO.getOperatePlace() );
        logSaveDTO.setRemark( logExportVO.getRemark() );
        logSaveDTO.setTime( logExportVO.getTime() );

        return logSaveDTO;
    }
}
