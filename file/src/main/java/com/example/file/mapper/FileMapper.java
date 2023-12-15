package com.example.file.mapper;

import cn.hutool.core.util.StrUtil;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.file.dal.entity.FileEntity;
import com.example.framework.common.PageList;
import com.example.file.dal.dto.file.FileQueryDTO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@DS("file")
@Mapper
public interface FileMapper extends BaseMapper<FileEntity> {
    default QueryWrapper<FileEntity> search(FileQueryDTO file) {
        QueryWrapper<FileEntity> wrapper = new QueryWrapper<>();

        /* url地址 */
        if (!StrUtil.hasBlank(file.getUrl())) {
            wrapper.eq("url", file.getUrl());
        }
        /* 文件类型 */
        if (!StrUtil.hasBlank(file.getFileType())) {
            wrapper.eq("file_type", file.getFileType());
        }
        /* 文件路径 */
        if (!StrUtil.hasBlank(file.getFilePath())) {
            wrapper.eq("file_path", file.getFilePath());
        }
        /* 状态 */
        if (!StrUtil.hasBlank(file.getStatus())) {
            wrapper.eq("status", file.getStatus());
        }
        /* 备注 */
        if (!StrUtil.hasBlank(file.getRemark())) {
            wrapper.eq("remark", file.getRemark());
        }
        /* 创建人 */
        if (!StrUtil.hasBlank(file.getCreator())) {
            wrapper.eq("creator", file.getCreator());
        }
        /* 更新人 */
        if (!StrUtil.hasBlank(file.getUpdater())) {
            wrapper.eq("updater", file.getUpdater());
        }
        wrapper.orderByDesc("create_time");
        return wrapper;
    }

    //分页
    default PageList<FileEntity> selectPage(FileQueryDTO file) {
        IPage<FileEntity> pageParams = new Page<>(file.getPage(), file.getSize());

        return PageList.setPages(selectPage(pageParams, search(file)));
    }

    //列表查询
    default List<FileEntity> selectFileList(FileQueryDTO file) {
        QueryWrapper<FileEntity> wrapper = new QueryWrapper<>();

        if (file.getId() != null) {
            wrapper.eq("parent_id", file.getId());
        } else {
            wrapper.isNull("parent_id");
        }

        return selectList(wrapper);
    }

    //列表查询
    default List<FileEntity> selectList(FileQueryDTO file) {
        return selectList(search(file));
    }

    @Delete("DELETE FROM file WHERE is_deleted = 1")
    void clearFile();
}
