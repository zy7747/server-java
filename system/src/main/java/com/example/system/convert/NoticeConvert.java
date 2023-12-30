package com.example.system.convert;

import com.example.framework.common.PageList;
import com.example.system.dal.dto.notice.NoticeSaveDTO;
import com.example.system.dal.entity.NoticeEntity;
import com.example.system.dal.vo.notice.NoticeDetailVO;
import com.example.system.dal.vo.notice.NoticeExportVO;
import com.example.system.dal.vo.notice.NoticeListVO;
import com.example.system.dal.vo.notice.NoticePageVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface NoticeConvert {
    NoticeConvert INSTANCE = Mappers.getMapper(NoticeConvert.class);

    PageList<NoticePageVO> page(PageList<NoticeEntity> notices);

    List<NoticeListVO> list(List<NoticeEntity> notices);

    NoticeDetailVO detail(NoticeEntity notices);

    List<NoticeEntity> saveList(List<NoticeSaveDTO> notices);

    NoticeEntity save(NoticeSaveDTO notices);

    List<NoticeExportVO> export(List<NoticeEntity> notices);

    List<NoticeSaveDTO> imports(List<NoticeExportVO> notices);
}