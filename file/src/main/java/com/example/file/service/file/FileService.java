package com.example.file.service.file;

import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.file.dal.dto.file.FileQueryDTO;
import com.example.file.dal.dto.file.FileSaveDTO;
import com.example.file.dal.entity.FileEntity;
import com.example.file.dal.vo.file.FileDetailVO;
import com.example.file.dal.vo.file.FileListVO;
import com.example.file.dal.vo.file.FilePageVO;
import com.example.file.dal.dto.file.FileUploadDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {
    /**
     * 获取列表分页
     *
     * @param file 分页入参
     * @return 列表分页
     */
    Result<PageList<FilePageVO>> pageService(FileQueryDTO file);

    /**
     * 获取列表
     *
     * @param file 入参
     * @return 列表
     */
    Result<List<FileListVO>> listService(FileQueryDTO file);

    /**
     * 获取列表
     *
     * @param file 入参
     * @return 列表
     */
    Result<List<FileListVO>> fileListService(FileQueryDTO file);

    /**
     * 获取父级信息
     *
     * @param file 入参
     * @return 父级信息
     */
    Result<FileEntity> getFileParentService(FileEntity file);

    /**
     * 获取详情
     *
     * @param id 入参
     * @return 详情
     */
    Result<FileDetailVO> detailService(Long id);

    /**
     * 批量新增/修改
     *
     * @param fileList 新增/修改内容
     * @return 新增/修改后数据
     */
    Result<List<FileEntity>> saveListService(List<FileSaveDTO> fileList);


    /**
     * 文件上传
     *
     * @param file 文件
     * @return 文件上传信息
     */
    Result<FileEntity> uploadService(MultipartFile file, FileUploadDTO params);


    /**
     * 新增文件夹
     *
     * @param file 文件夹
     * @return 文件信息
     */
    Result<FileEntity> createFolderService(FileEntity file);
}
