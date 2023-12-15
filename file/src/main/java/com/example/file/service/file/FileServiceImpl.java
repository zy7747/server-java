package com.example.file.service.file;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.file.convert.FileConvert;
import com.example.file.dal.dto.file.FileQueryDTO;
import com.example.file.dal.dto.file.FileSaveDTO;
import com.example.file.dal.dto.file.FileUploadDTO;
import com.example.file.dal.entity.FileEntity;
import com.example.file.mapper.FileMapper;
import com.example.file.dal.vo.file.FileDetailVO;
import com.example.file.dal.vo.file.FileListVO;
import com.example.file.dal.vo.file.FilePageVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Slf4j
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, FileEntity> implements FileService {
    @Resource
    FileMapper fileMapper;

    @Value("${file.path}") //存储路径
    private String path;

    /**
     * 获取列表分页
     *
     * @param file 分页入参
     * @return 列表分页
     */
    @Override
    public Result<PageList<FilePageVO>> pageService(FileQueryDTO file) {
        return Result.success(FileConvert.INSTANCE.page(fileMapper.selectPage(file)));
    }

    /**
     * 获取列表
     *
     * @param file 查询参数
     * @return 列表
     */
    @Override
    public Result<List<FileListVO>> fileListService(FileQueryDTO file) {
        return Result.success(FileConvert.INSTANCE.list(fileMapper.selectFileList(file)));
    }

    /**
     * 获取列表
     *
     * @param file 查询参数
     * @return 列表
     */
    @Override
    public Result<List<FileListVO>> listService(FileQueryDTO file) {
        return Result.success(FileConvert.INSTANCE.list(fileMapper.selectList(file)));
    }

    /**
     * 获取详情
     *
     * @param id 入参
     * @return 详情
     */
    @Override
    public Result<FileDetailVO> detailService(Long id) {
        return Result.success(FileConvert.INSTANCE.detail(fileMapper.selectById(id)));
    }

    /**
     * 获取父级信息
     *
     * @param file 入参
     * @return 父级信息
     */
    @Override
    public Result<FileEntity> getFileParentService(FileEntity file) {
        //用路径来查他的节点
        if (file.getFilePath() != null) {
            QueryWrapper<FileEntity> wrapper = new QueryWrapper<>();

            wrapper.eq("file_path", file.getFilePath());

            return Result.success(fileMapper.selectOne(wrapper));
            // 根据当前节点查父级节点
        } else if (file.getId() != null) {
            FileEntity parentIdRow = fileMapper.selectById(file.getId());
            if (parentIdRow.getParentId() == null) {
                return Result.fail("根目录");
            } else {
                FileEntity parentRow = fileMapper.selectById(parentIdRow.getParentId());
                return Result.success(parentRow);
            }
        } else {
            return Result.fail("缺少必填参数");
        }
    }


    /**
     * 批量新增/修改
     *
     * @param file 新增/修改内容
     * @return 新增/修改后数据
     */
    @Override
    public Result<List<FileEntity>> saveListService(List<FileSaveDTO> file) {
        List<FileEntity> fileList = FileConvert.INSTANCE.saveList(file);
        this.saveOrUpdateBatch(fileList);
        return Result.success(fileList);
    }

    /**
     * 文件上传
     *
     * @param file 文件
     * @return 文件上传信息
     */
    @Override
    public Result<FileEntity> uploadService(MultipartFile file, FileUploadDTO params) {
        FileEntity fileInfo = new FileEntity();

        // 检查文件是否为空
        if (file.isEmpty()) {
            return Result.error("文件为空");
        }

        String fileName = file.getOriginalFilename();

        if (fileName == null) {
            return Result.error("文件读取不到");
        }

        //上传成功保存文件信息
        fileInfo.setFileName(fileName);
        fileInfo.setFileSize(file.getSize());
        fileInfo.setFileType(FilenameUtils.getExtension(fileName));
        fileInfo.setUrl(params.getPath() + "/" + fileName);
        fileInfo.setFilePath(params.getPath() + "/" + fileName);
        fileInfo.setParentId(params.getParentId());

        try {
            File directory = new File(path + params.getPath() + "/");
            //如果找不到目标文件夹自动创建文件夹
            if (!directory.exists()) {
                directory.mkdirs();
            }
            //格式 上传路径 + 上传文件名称
            File dest = new File(path + params.getPath() + "/" + fileName);
            //文件写入路径
            file.transferTo(dest);

            // 将上传的文件保存到目标文件

            fileMapper.insert(fileInfo);

            return Result.success(fileInfo);
        } catch (IOException e) {
            e.printStackTrace();
            return Result.error("文件上传失败");
        }
    }


    /**
     * 新增文件夹
     *
     * @param file 文件夹
     * @return 文件上传信息
     */
    @Override
    public Result<FileEntity> createFolderService(FileEntity file) {
        String filePath;//文件夹路径
        if (file.getParentId() != null) {
            QueryWrapper<FileEntity> wrapper = new QueryWrapper<>();

            wrapper.eq("id", file.getParentId());

            FileEntity parentFolder = fileMapper.selectOne(wrapper);

            filePath = parentFolder.getFilePath() + "/" + file.getFileName();
        } else {
            filePath = "/" + file.getFileName();
        }

        File directory = new File(path + filePath);

        file.setFilePath(filePath);

        //如果找不到目标文件夹自动创建文件夹
        if (!directory.exists()) {
            directory.mkdirs();
            fileMapper.insert(file);
            return Result.success(file);
        } else {
            return Result.error("文件已存在");
        }


    }
}
