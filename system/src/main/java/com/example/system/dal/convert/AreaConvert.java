package com.example.system.dal.convert;

import com.example.framework.common.PageList;
import com.example.system.dal.dto.area.AreaSaveDTO;
import com.example.system.dal.entity.AreaEntity;
import com.example.system.dal.vo.area.AreaDetailVO;
import com.example.system.dal.vo.area.AreaExportVO;
import com.example.system.dal.vo.area.AreaListVO;
import com.example.system.dal.vo.area.AreaPageVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AreaConvert {
    AreaConvert INSTANCE = Mappers.getMapper(AreaConvert.class);

    PageList<AreaPageVO> page(PageList<AreaEntity> areas);

    List<AreaListVO> list(List<AreaEntity> areas);

    AreaDetailVO detail(AreaEntity areas);

    List<AreaEntity> saveList(List<AreaSaveDTO> areas);

    List<AreaExportVO> export(List<AreaEntity> areas);
}
