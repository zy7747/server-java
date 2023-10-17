package com.example.system.dal.convert;

import com.example.framework.common.PageList;
import com.example.system.dal.dto.file.FileSaveDTO;
import com.example.system.dal.entity.FileEntity;
import com.example.system.dal.vo.file.FileDetailVO;
import com.example.system.dal.vo.file.FileExportVO;
import com.example.system.dal.vo.file.FileListVO;
import com.example.system.dal.vo.file.FilePageVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-17T10:13:54+0800",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 1.8.0_311 (Oracle Corporation)"
)
public class FileConvertImpl implements FileConvert {

    @Override
    public PageList<FilePageVO> page(PageList<FileEntity> files) {
        if ( files == null ) {
            return null;
        }

        PageList<FilePageVO> pageList = new PageList<FilePageVO>();

        pageList.setPage( files.getPage() );
        pageList.setTotal( files.getTotal() );
        pageList.setSize( files.getSize() );
        pageList.setList( fileEntityListToFilePageVOList( files.getList() ) );

        return pageList;
    }

    @Override
    public List<FileListVO> list(List<FileEntity> files) {
        if ( files == null ) {
            return null;
        }

        List<FileListVO> list = new ArrayList<FileListVO>( files.size() );
        for ( FileEntity fileEntity : files ) {
            list.add( fileEntityToFileListVO( fileEntity ) );
        }

        return list;
    }

    @Override
    public FileDetailVO detail(FileEntity files) {
        if ( files == null ) {
            return null;
        }

        FileDetailVO fileDetailVO = new FileDetailVO();

        fileDetailVO.setId( files.getId() );
        fileDetailVO.setStatus( files.getStatus() );
        fileDetailVO.setRemark( files.getRemark() );
        fileDetailVO.setCreator( files.getCreator() );
        fileDetailVO.setUpdater( files.getUpdater() );
        fileDetailVO.setCreateTime( files.getCreateTime() );
        fileDetailVO.setUpdateTime( files.getUpdateTime() );
        fileDetailVO.setIsDeleted( files.getIsDeleted() );
        fileDetailVO.setTenantId( files.getTenantId() );
        fileDetailVO.setVersion( files.getVersion() );
        fileDetailVO.setParentId( files.getParentId() );
        fileDetailVO.setFileName( files.getFileName() );
        fileDetailVO.setUrl( files.getUrl() );
        fileDetailVO.setFileType( files.getFileType() );
        fileDetailVO.setFilePath( files.getFilePath() );
        fileDetailVO.setFileSize( files.getFileSize() );

        return fileDetailVO;
    }

    @Override
    public List<FileEntity> saveList(List<FileSaveDTO> files) {
        if ( files == null ) {
            return null;
        }

        List<FileEntity> list = new ArrayList<FileEntity>( files.size() );
        for ( FileSaveDTO fileSaveDTO : files ) {
            list.add( fileSaveDTOToFileEntity( fileSaveDTO ) );
        }

        return list;
    }

    @Override
    public List<FileExportVO> export(List<FileEntity> files) {
        if ( files == null ) {
            return null;
        }

        List<FileExportVO> list = new ArrayList<FileExportVO>( files.size() );
        for ( FileEntity fileEntity : files ) {
            list.add( fileEntityToFileExportVO( fileEntity ) );
        }

        return list;
    }

    protected FilePageVO fileEntityToFilePageVO(FileEntity fileEntity) {
        if ( fileEntity == null ) {
            return null;
        }

        FilePageVO filePageVO = new FilePageVO();

        filePageVO.setId( fileEntity.getId() );
        filePageVO.setStatus( fileEntity.getStatus() );
        filePageVO.setRemark( fileEntity.getRemark() );
        filePageVO.setCreator( fileEntity.getCreator() );
        filePageVO.setUpdater( fileEntity.getUpdater() );
        filePageVO.setCreateTime( fileEntity.getCreateTime() );
        filePageVO.setUpdateTime( fileEntity.getUpdateTime() );
        filePageVO.setIsDeleted( fileEntity.getIsDeleted() );
        filePageVO.setTenantId( fileEntity.getTenantId() );
        filePageVO.setVersion( fileEntity.getVersion() );
        filePageVO.setParentId( fileEntity.getParentId() );
        filePageVO.setFileName( fileEntity.getFileName() );
        filePageVO.setUrl( fileEntity.getUrl() );
        filePageVO.setFileType( fileEntity.getFileType() );
        filePageVO.setFilePath( fileEntity.getFilePath() );
        filePageVO.setFileSize( fileEntity.getFileSize() );

        return filePageVO;
    }

    protected List<FilePageVO> fileEntityListToFilePageVOList(List<FileEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<FilePageVO> list1 = new ArrayList<FilePageVO>( list.size() );
        for ( FileEntity fileEntity : list ) {
            list1.add( fileEntityToFilePageVO( fileEntity ) );
        }

        return list1;
    }

    protected FileListVO fileEntityToFileListVO(FileEntity fileEntity) {
        if ( fileEntity == null ) {
            return null;
        }

        FileListVO fileListVO = new FileListVO();

        fileListVO.setId( fileEntity.getId() );
        fileListVO.setStatus( fileEntity.getStatus() );
        fileListVO.setRemark( fileEntity.getRemark() );
        fileListVO.setCreator( fileEntity.getCreator() );
        fileListVO.setUpdater( fileEntity.getUpdater() );
        fileListVO.setCreateTime( fileEntity.getCreateTime() );
        fileListVO.setUpdateTime( fileEntity.getUpdateTime() );
        fileListVO.setIsDeleted( fileEntity.getIsDeleted() );
        fileListVO.setTenantId( fileEntity.getTenantId() );
        fileListVO.setVersion( fileEntity.getVersion() );
        fileListVO.setParentId( fileEntity.getParentId() );
        fileListVO.setFileName( fileEntity.getFileName() );
        fileListVO.setUrl( fileEntity.getUrl() );
        fileListVO.setFileType( fileEntity.getFileType() );
        fileListVO.setFilePath( fileEntity.getFilePath() );
        fileListVO.setFileSize( fileEntity.getFileSize() );

        return fileListVO;
    }

    protected FileEntity fileSaveDTOToFileEntity(FileSaveDTO fileSaveDTO) {
        if ( fileSaveDTO == null ) {
            return null;
        }

        FileEntity fileEntity = new FileEntity();

        fileEntity.setId( fileSaveDTO.getId() );
        fileEntity.setStatus( fileSaveDTO.getStatus() );
        fileEntity.setRemark( fileSaveDTO.getRemark() );
        fileEntity.setCreator( fileSaveDTO.getCreator() );
        fileEntity.setUpdater( fileSaveDTO.getUpdater() );
        fileEntity.setCreateTime( fileSaveDTO.getCreateTime() );
        fileEntity.setUpdateTime( fileSaveDTO.getUpdateTime() );
        fileEntity.setIsDeleted( fileSaveDTO.getIsDeleted() );
        fileEntity.setTenantId( fileSaveDTO.getTenantId() );
        fileEntity.setVersion( fileSaveDTO.getVersion() );
        fileEntity.setParentId( fileSaveDTO.getParentId() );
        fileEntity.setFileName( fileSaveDTO.getFileName() );
        fileEntity.setUrl( fileSaveDTO.getUrl() );
        fileEntity.setFileType( fileSaveDTO.getFileType() );
        fileEntity.setFilePath( fileSaveDTO.getFilePath() );
        fileEntity.setFileSize( fileSaveDTO.getFileSize() );

        return fileEntity;
    }

    protected FileExportVO fileEntityToFileExportVO(FileEntity fileEntity) {
        if ( fileEntity == null ) {
            return null;
        }

        FileExportVO fileExportVO = new FileExportVO();

        fileExportVO.setId( fileEntity.getId() );
        fileExportVO.setStatus( fileEntity.getStatus() );
        fileExportVO.setRemark( fileEntity.getRemark() );
        fileExportVO.setCreator( fileEntity.getCreator() );
        fileExportVO.setUpdater( fileEntity.getUpdater() );
        fileExportVO.setCreateTime( fileEntity.getCreateTime() );
        fileExportVO.setUpdateTime( fileEntity.getUpdateTime() );
        fileExportVO.setIsDeleted( fileEntity.getIsDeleted() );
        fileExportVO.setFileName( fileEntity.getFileName() );
        fileExportVO.setUrl( fileEntity.getUrl() );
        fileExportVO.setFileType( fileEntity.getFileType() );
        fileExportVO.setFilePath( fileEntity.getFilePath() );
        fileExportVO.setFileSize( fileEntity.getFileSize() );

        return fileExportVO;
    }
}
