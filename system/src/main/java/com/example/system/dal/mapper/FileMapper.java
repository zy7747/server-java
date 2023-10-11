package com.example.system.dal.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.framework.common.PageList;
import com.example.system.dal.dto.file.FileQueryDTO;
import com.example.system.dal.entity.FileEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileMapper extends BaseMapper<FileEntity> {
    //分页
    default PageList<FileEntity> selectPage(FileQueryDTO file) {
        IPage<FileEntity> pageParams = new Page<>(file.getPage(), file.getSize());
        QueryWrapper<FileEntity> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("create_time");
        return PageList.setPages(selectPage(pageParams, wrapper));
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
        QueryWrapper<FileEntity> wrapper = new QueryWrapper<>();

        return selectList(wrapper);
    }
}
