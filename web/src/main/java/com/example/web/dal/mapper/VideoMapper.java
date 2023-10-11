package com.example.web.dal.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.framework.common.PageList;
import com.example.web.dal.dto.video.VideoQueryDTO;
import com.example.web.dal.entity.VideoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VideoMapper extends BaseMapper<VideoEntity> {
    //分页
    default PageList<VideoEntity> selectPage(VideoQueryDTO video) {
        IPage<VideoEntity> pageParams = new Page<>(video.getPage(), video.getSize());
        QueryWrapper<VideoEntity> wrapper = new QueryWrapper<>();
        if (video.getTitle() != null) {
            wrapper.like("title", video.getTitle());
        }

        if (video.getVideoName() != null) {
            wrapper.like("video_name", video.getVideoName());
        }

        if (video.getRegion() != null) {
            wrapper.eq("region", video.getRegion());
        }

        if (video.getVideoType() != null) {
            wrapper.eq("video_type", video.getVideoType());
        }

        if (video.getType() != null) {
            wrapper.eq("type", video.getType());
        }

        if (video.getAuthor() != null) {
            wrapper.like("author", video.getAuthor());
        }


        //排序方式
        if (video.getSortWay() != null) {
            if (video.getSortWay().equals("playNum")) {
                wrapper.orderByDesc("play_num");
            } else if (video.getSortWay().equals("collectionNum")) {
                wrapper.orderByDesc("collection_num");
            } else if (video.getSortWay().equals("starsNum")) {
                wrapper.orderByDesc("stars_num");
            } else {
                wrapper.orderByDesc("create_time");
            }
        } else {
            wrapper.orderByDesc("create_time");
        }


        wrapper.isNull("parent_id");

        return PageList.setPages(selectPage(pageParams, wrapper));
    }

    //列表查询
    default List<VideoEntity> selectList(VideoQueryDTO video) {
        QueryWrapper<VideoEntity> wrapper = new QueryWrapper<>();

        return selectList(wrapper);
    }

    //视频列表查询
    default List<VideoEntity> selectVideoList(Long id) {
        QueryWrapper<VideoEntity> wrapper = new QueryWrapper<>();

        wrapper.eq("parent_id", id);

        return selectList(wrapper);
    }
}

