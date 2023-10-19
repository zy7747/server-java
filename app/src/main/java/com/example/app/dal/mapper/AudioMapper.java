package com.example.app.dal.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.framework.common.PageList;
import com.example.app.dal.dto.audio.AudioQueryDTO;
import com.example.app.dal.entity.AudioEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AudioMapper extends BaseMapper<AudioEntity> {
    /**
     * 分页查询
     */
    default PageList<AudioEntity> selectPageList(AudioQueryDTO audio) {
        IPage<AudioEntity> pageParams = new Page<>(audio.getPage(), audio.getSize());
        QueryWrapper<AudioEntity> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("create_time");
        return PageList.setPages(selectPage(pageParams, wrapper));
    }

    /**
     * 列表查询
     */
    default List<AudioEntity> selectList(AudioQueryDTO audio) {
        QueryWrapper<AudioEntity> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("create_time");
        return selectList(wrapper);
    }
}
