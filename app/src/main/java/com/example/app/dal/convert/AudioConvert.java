package com.example.app.dal.convert;

import com.example.framework.common.PageList;
import com.example.app.dal.dto.audio.AudioSaveDTO;
import com.example.app.dal.entity.AudioEntity;
import com.example.app.dal.vo.audio.AudioDetailVO;
import com.example.app.dal.vo.audio.AudioExportVO;
import com.example.app.dal.vo.audio.AudioListVO;
import com.example.app.dal.vo.audio.AudioPageVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AudioConvert {
    AudioConvert INSTANCE = Mappers.getMapper(AudioConvert.class);

    PageList<AudioPageVO> page(PageList<AudioEntity> audios);

    List<AudioListVO> list(List<AudioEntity> audios);

    AudioDetailVO detail(AudioEntity audios);

    List<AudioEntity> saveList(List<AudioSaveDTO> audios);

    List<AudioExportVO> export(List<AudioEntity> audios);
}
