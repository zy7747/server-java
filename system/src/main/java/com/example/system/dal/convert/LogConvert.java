package com.example.system.dal.convert;

import com.example.framework.common.PageList;
import com.example.system.dal.dto.log.LogSaveDTO;
import com.example.system.dal.entity.LogEntity;
import com.example.system.dal.vo.log.LogDetailVO;
import com.example.system.dal.vo.log.LogExportVO;
import com.example.system.dal.vo.log.LogListVO;
import com.example.system.dal.vo.log.LogPageVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface LogConvert {
    LogConvert INSTANCE = Mappers.getMapper(LogConvert.class);

    PageList<LogPageVO> page(PageList<LogEntity> logs);

    List<LogListVO> list(List<LogEntity> logs);

    LogDetailVO detail(LogEntity logs);

    List<LogEntity> saveList(List<LogSaveDTO> logs);

    List<LogExportVO> export(List<LogEntity> logs);

    List<LogSaveDTO> imports(List<LogExportVO> logs);
}