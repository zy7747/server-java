package com.example.system.convert;

import com.example.framework.common.PageList;
import com.example.system.dal.dto.operationLog.OperationLogSaveDTO;
import com.example.system.dal.entity.OperationLogEntity;
import com.example.system.dal.vo.operationLog.OperationLogDetailVO;
import com.example.system.dal.vo.operationLog.OperationLogExportVO;
import com.example.system.dal.vo.operationLog.OperationLogListVO;
import com.example.system.dal.vo.operationLog.OperationLogPageVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-03T17:15:49+0800",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 1.8.0_311 (Oracle Corporation)"
)
public class OperationLogConvertImpl implements OperationLogConvert {

    @Override
    public PageList<OperationLogPageVO> page(PageList<OperationLogEntity> operationLogs) {
        if ( operationLogs == null ) {
            return null;
        }

        PageList<OperationLogPageVO> pageList = new PageList<OperationLogPageVO>();

        pageList.setPage( operationLogs.getPage() );
        pageList.setTotal( operationLogs.getTotal() );
        pageList.setSize( operationLogs.getSize() );
        pageList.setList( operationLogEntityListToOperationLogPageVOList( operationLogs.getList() ) );

        return pageList;
    }

    @Override
    public List<OperationLogListVO> list(List<OperationLogEntity> operationLogs) {
        if ( operationLogs == null ) {
            return null;
        }

        List<OperationLogListVO> list = new ArrayList<OperationLogListVO>( operationLogs.size() );
        for ( OperationLogEntity operationLogEntity : operationLogs ) {
            list.add( operationLogEntityToOperationLogListVO( operationLogEntity ) );
        }

        return list;
    }

    @Override
    public OperationLogDetailVO detail(OperationLogEntity operationLogs) {
        if ( operationLogs == null ) {
            return null;
        }

        OperationLogDetailVO operationLogDetailVO = new OperationLogDetailVO();

        operationLogDetailVO.setId( operationLogs.getId() );
        operationLogDetailVO.setStatus( operationLogs.getStatus() );
        operationLogDetailVO.setRemark( operationLogs.getRemark() );
        operationLogDetailVO.setCreator( operationLogs.getCreator() );
        operationLogDetailVO.setUpdater( operationLogs.getUpdater() );
        operationLogDetailVO.setCreateTime( operationLogs.getCreateTime() );
        operationLogDetailVO.setUpdateTime( operationLogs.getUpdateTime() );
        operationLogDetailVO.setIsDeleted( operationLogs.getIsDeleted() );
        operationLogDetailVO.setTenantId( operationLogs.getTenantId() );
        operationLogDetailVO.setVersion( operationLogs.getVersion() );
        operationLogDetailVO.setTitle( operationLogs.getTitle() );
        operationLogDetailVO.setModule( operationLogs.getModule() );
        operationLogDetailVO.setContent( operationLogs.getContent() );
        operationLogDetailVO.setType( operationLogs.getType() );
        operationLogDetailVO.setOperateIp( operationLogs.getOperateIp() );
        operationLogDetailVO.setOperatePlace( operationLogs.getOperatePlace() );
        operationLogDetailVO.setTime( operationLogs.getTime() );
        operationLogDetailVO.setErrorMsg( operationLogs.getErrorMsg() );

        return operationLogDetailVO;
    }

    @Override
    public List<OperationLogEntity> saveList(List<OperationLogSaveDTO> operationLogs) {
        if ( operationLogs == null ) {
            return null;
        }

        List<OperationLogEntity> list = new ArrayList<OperationLogEntity>( operationLogs.size() );
        for ( OperationLogSaveDTO operationLogSaveDTO : operationLogs ) {
            list.add( operationLogSaveDTOToOperationLogEntity( operationLogSaveDTO ) );
        }

        return list;
    }

    @Override
    public List<OperationLogExportVO> export(List<OperationLogEntity> operationLogs) {
        if ( operationLogs == null ) {
            return null;
        }

        List<OperationLogExportVO> list = new ArrayList<OperationLogExportVO>( operationLogs.size() );
        for ( OperationLogEntity operationLogEntity : operationLogs ) {
            list.add( operationLogEntityToOperationLogExportVO( operationLogEntity ) );
        }

        return list;
    }

    @Override
    public List<OperationLogSaveDTO> imports(List<OperationLogExportVO> operationLogs) {
        if ( operationLogs == null ) {
            return null;
        }

        List<OperationLogSaveDTO> list = new ArrayList<OperationLogSaveDTO>( operationLogs.size() );
        for ( OperationLogExportVO operationLogExportVO : operationLogs ) {
            list.add( operationLogExportVOToOperationLogSaveDTO( operationLogExportVO ) );
        }

        return list;
    }

    protected OperationLogPageVO operationLogEntityToOperationLogPageVO(OperationLogEntity operationLogEntity) {
        if ( operationLogEntity == null ) {
            return null;
        }

        OperationLogPageVO operationLogPageVO = new OperationLogPageVO();

        operationLogPageVO.setId( operationLogEntity.getId() );
        operationLogPageVO.setStatus( operationLogEntity.getStatus() );
        operationLogPageVO.setRemark( operationLogEntity.getRemark() );
        operationLogPageVO.setCreator( operationLogEntity.getCreator() );
        operationLogPageVO.setUpdater( operationLogEntity.getUpdater() );
        operationLogPageVO.setCreateTime( operationLogEntity.getCreateTime() );
        operationLogPageVO.setUpdateTime( operationLogEntity.getUpdateTime() );
        operationLogPageVO.setIsDeleted( operationLogEntity.getIsDeleted() );
        operationLogPageVO.setTenantId( operationLogEntity.getTenantId() );
        operationLogPageVO.setVersion( operationLogEntity.getVersion() );
        operationLogPageVO.setTitle( operationLogEntity.getTitle() );
        operationLogPageVO.setModule( operationLogEntity.getModule() );
        operationLogPageVO.setContent( operationLogEntity.getContent() );
        operationLogPageVO.setType( operationLogEntity.getType() );
        operationLogPageVO.setOperateIp( operationLogEntity.getOperateIp() );
        operationLogPageVO.setOperatePlace( operationLogEntity.getOperatePlace() );
        operationLogPageVO.setTime( operationLogEntity.getTime() );
        operationLogPageVO.setErrorMsg( operationLogEntity.getErrorMsg() );

        return operationLogPageVO;
    }

    protected List<OperationLogPageVO> operationLogEntityListToOperationLogPageVOList(List<OperationLogEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<OperationLogPageVO> list1 = new ArrayList<OperationLogPageVO>( list.size() );
        for ( OperationLogEntity operationLogEntity : list ) {
            list1.add( operationLogEntityToOperationLogPageVO( operationLogEntity ) );
        }

        return list1;
    }

    protected OperationLogListVO operationLogEntityToOperationLogListVO(OperationLogEntity operationLogEntity) {
        if ( operationLogEntity == null ) {
            return null;
        }

        OperationLogListVO operationLogListVO = new OperationLogListVO();

        operationLogListVO.setId( operationLogEntity.getId() );
        operationLogListVO.setStatus( operationLogEntity.getStatus() );
        operationLogListVO.setRemark( operationLogEntity.getRemark() );
        operationLogListVO.setCreator( operationLogEntity.getCreator() );
        operationLogListVO.setUpdater( operationLogEntity.getUpdater() );
        operationLogListVO.setCreateTime( operationLogEntity.getCreateTime() );
        operationLogListVO.setUpdateTime( operationLogEntity.getUpdateTime() );
        operationLogListVO.setIsDeleted( operationLogEntity.getIsDeleted() );
        operationLogListVO.setTenantId( operationLogEntity.getTenantId() );
        operationLogListVO.setVersion( operationLogEntity.getVersion() );
        operationLogListVO.setTitle( operationLogEntity.getTitle() );
        operationLogListVO.setModule( operationLogEntity.getModule() );
        operationLogListVO.setContent( operationLogEntity.getContent() );
        operationLogListVO.setType( operationLogEntity.getType() );
        operationLogListVO.setOperateIp( operationLogEntity.getOperateIp() );
        operationLogListVO.setOperatePlace( operationLogEntity.getOperatePlace() );
        operationLogListVO.setTime( operationLogEntity.getTime() );
        operationLogListVO.setErrorMsg( operationLogEntity.getErrorMsg() );

        return operationLogListVO;
    }

    protected OperationLogEntity operationLogSaveDTOToOperationLogEntity(OperationLogSaveDTO operationLogSaveDTO) {
        if ( operationLogSaveDTO == null ) {
            return null;
        }

        OperationLogEntity operationLogEntity = new OperationLogEntity();

        operationLogEntity.setId( operationLogSaveDTO.getId() );
        operationLogEntity.setStatus( operationLogSaveDTO.getStatus() );
        operationLogEntity.setRemark( operationLogSaveDTO.getRemark() );
        operationLogEntity.setCreator( operationLogSaveDTO.getCreator() );
        operationLogEntity.setUpdater( operationLogSaveDTO.getUpdater() );
        operationLogEntity.setCreateTime( operationLogSaveDTO.getCreateTime() );
        operationLogEntity.setUpdateTime( operationLogSaveDTO.getUpdateTime() );
        operationLogEntity.setIsDeleted( operationLogSaveDTO.getIsDeleted() );
        operationLogEntity.setTenantId( operationLogSaveDTO.getTenantId() );
        operationLogEntity.setVersion( operationLogSaveDTO.getVersion() );
        operationLogEntity.setTitle( operationLogSaveDTO.getTitle() );
        operationLogEntity.setModule( operationLogSaveDTO.getModule() );
        operationLogEntity.setContent( operationLogSaveDTO.getContent() );
        operationLogEntity.setType( operationLogSaveDTO.getType() );
        operationLogEntity.setOperateIp( operationLogSaveDTO.getOperateIp() );
        operationLogEntity.setOperatePlace( operationLogSaveDTO.getOperatePlace() );
        operationLogEntity.setTime( operationLogSaveDTO.getTime() );
        operationLogEntity.setErrorMsg( operationLogSaveDTO.getErrorMsg() );

        return operationLogEntity;
    }

    protected OperationLogExportVO operationLogEntityToOperationLogExportVO(OperationLogEntity operationLogEntity) {
        if ( operationLogEntity == null ) {
            return null;
        }

        OperationLogExportVO operationLogExportVO = new OperationLogExportVO();

        operationLogExportVO.setTitle( operationLogEntity.getTitle() );
        operationLogExportVO.setModule( operationLogEntity.getModule() );
        operationLogExportVO.setContent( operationLogEntity.getContent() );
        operationLogExportVO.setType( operationLogEntity.getType() );
        operationLogExportVO.setOperateIp( operationLogEntity.getOperateIp() );
        operationLogExportVO.setOperatePlace( operationLogEntity.getOperatePlace() );
        operationLogExportVO.setTime( operationLogEntity.getTime() );
        operationLogExportVO.setErrorMsg( operationLogEntity.getErrorMsg() );

        return operationLogExportVO;
    }

    protected OperationLogSaveDTO operationLogExportVOToOperationLogSaveDTO(OperationLogExportVO operationLogExportVO) {
        if ( operationLogExportVO == null ) {
            return null;
        }

        OperationLogSaveDTO operationLogSaveDTO = new OperationLogSaveDTO();

        operationLogSaveDTO.setTitle( operationLogExportVO.getTitle() );
        operationLogSaveDTO.setModule( operationLogExportVO.getModule() );
        operationLogSaveDTO.setContent( operationLogExportVO.getContent() );
        operationLogSaveDTO.setType( operationLogExportVO.getType() );
        operationLogSaveDTO.setOperateIp( operationLogExportVO.getOperateIp() );
        operationLogSaveDTO.setOperatePlace( operationLogExportVO.getOperatePlace() );
        operationLogSaveDTO.setTime( operationLogExportVO.getTime() );
        operationLogSaveDTO.setErrorMsg( operationLogExportVO.getErrorMsg() );

        return operationLogSaveDTO;
    }
}
