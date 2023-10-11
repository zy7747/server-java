package com.example.system.dal.convert;

import com.example.framework.common.PageList;
import com.example.system.dal.dto.dict.DictSaveDTO;
import com.example.system.dal.entity.DictEntity;
import com.example.system.dal.vo.dict.DictDetailVO;
import com.example.system.dal.vo.dict.DictExportVO;
import com.example.system.dal.vo.dict.DictListVO;
import com.example.system.dal.vo.dict.DictPageVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DictConvert {
    DictConvert INSTANCE = Mappers.getMapper(DictConvert.class);

    PageList<DictPageVO> page(PageList<DictEntity> dict);

    List<DictListVO> list(List<DictEntity> dict);

    List<DictListVO> dictList(List<DictEntity> dict);

    DictDetailVO detail(DictEntity dict);

    List<DictEntity> saveList(List<DictSaveDTO> dict);

    List<DictExportVO> export(List<DictEntity> dict);
}