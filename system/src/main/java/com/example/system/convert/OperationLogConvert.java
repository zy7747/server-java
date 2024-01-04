package com.example.system.convert;

import com.example.framework.common.PageList;
import com.example.system.dal.dto.operationLog.OperationLogSaveDTO;
import com.example.system.dal.entity.OperationLogEntity;
import com.example.system.dal.vo.operationLog.OperationLogDetailVO;
import com.example.system.dal.vo.operationLog.OperationLogExportVO;
import com.example.system.dal.vo.operationLog.OperationLogListVO;
import com.example.system.dal.vo.operationLog.OperationLogPageVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OperationLogConvert {
    OperationLogConvert INSTANCE = Mappers.getMapper(OperationLogConvert.class);

    PageList<OperationLogPageVO> page(PageList<OperationLogEntity> operationLogs);

    List<OperationLogListVO> list(List<OperationLogEntity> operationLogs);

    OperationLogDetailVO detail(OperationLogEntity operationLogs);

    List<OperationLogEntity> saveList(List<OperationLogSaveDTO> operationLogs);

    List<OperationLogExportVO> export(List<OperationLogEntity> operationLogs);

    List<OperationLogSaveDTO> imports(List<OperationLogExportVO> operationLogs);
}