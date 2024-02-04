package com.example.system.convert;

import com.example.framework.common.PageList;
import com.example.system.dal.dto.page.PageSaveDTO;
import com.example.system.dal.entity.PageEntity;
import com.example.system.dal.vo.page.PageDetailVO;
import com.example.system.dal.vo.page.PageExportVO;
import com.example.system.dal.vo.page.PageListVO;
import com.example.system.dal.vo.page.PagePageVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PageConvert {
    PageConvert INSTANCE = Mappers.getMapper(PageConvert.class);

    PageList<PagePageVO> page(PageList<PageEntity> pages);

    List<PageListVO> list(List<PageEntity> pages);

    PageDetailVO detail(PageEntity pages);

    List<PageEntity> saveList(List<PageSaveDTO> pages);

    List<PageExportVO> export(List<PageEntity> pages);

    List<PageSaveDTO> imports(List<PageExportVO> pages);
}