package com.example.file.convert;

import com.example.framework.common.PageList;
import com.example.file.dal.dto.file.FileSaveDTO;
import com.example.file.dal.entity.FileEntity;
import com.example.file.dal.vo.file.FileDetailVO;
import com.example.file.dal.vo.file.FileExportVO;
import com.example.file.dal.vo.file.FileListVO;
import com.example.file.dal.vo.file.FilePageVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FileConvert {
    FileConvert INSTANCE = Mappers.getMapper(FileConvert.class);

    PageList<FilePageVO> page(PageList<FileEntity> files);

    List<FileListVO> list(List<FileEntity> files);

    FileDetailVO detail(FileEntity files);

    List<FileEntity> saveList(List<FileSaveDTO> files);

    List<FileExportVO> export(List<FileEntity> files);
}
