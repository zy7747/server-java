package com.example.file.convert;

import com.example.file.dal.dto.video.VideoSaveDTO;
import com.example.framework.common.PageList;
import com.example.file.dal.entity.VideoEntity;
import com.example.file.dal.vo.video.VideoDetailVO;
import com.example.file.dal.vo.video.VideoExportVO;
import com.example.file.dal.vo.video.VideoListVO;
import com.example.file.dal.vo.video.VideoPageVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VideoConvert {
    VideoConvert INSTANCE = Mappers.getMapper(VideoConvert.class);

    PageList<VideoPageVO> page(PageList<VideoEntity> videos);

    List<VideoListVO> list(List<VideoEntity> videos);

    VideoDetailVO detail(VideoEntity videos);

    List<VideoEntity> saveList(List<VideoSaveDTO> videos);

    List<VideoExportVO> export(List<VideoEntity> videos);
}
