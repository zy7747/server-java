package com.example.web.dal.mapper;

import cn.hutool.core.util.StrUtil;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.framework.common.PageList;
import com.example.web.dal.dto.video.VideoQueryDTO;
import com.example.web.dal.entity.VideoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@DS("web")
@Mapper
public interface VideoMapper extends BaseMapper<VideoEntity> {
    default QueryWrapper<VideoEntity> search(VideoQueryDTO video) {
        QueryWrapper<VideoEntity> wrapper = new QueryWrapper<>();

        if (!StrUtil.hasBlank(video.getTitle())) {
            wrapper.like("title", video.getTitle());
        }

        if (!StrUtil.hasBlank(video.getVideoName())) {
            wrapper.like("video_name", video.getVideoName());
        }

        if (!StrUtil.hasBlank(video.getRegion())) {
            wrapper.eq("region", video.getRegion());
        }

        if (!StrUtil.hasBlank(video.getVideoType())) {
            wrapper.eq("video_type", video.getVideoType());
        }

        if (!StrUtil.hasBlank(video.getType())) {
            wrapper.eq("type", video.getType());
        }

        if (!StrUtil.hasBlank(video.getAuthor())) {
            wrapper.like("author", video.getAuthor());
        }

        //排序方式
        if (!StrUtil.hasBlank(video.getSortWay())) {
            if ("playNum".equals(video.getSortWay())) {
                wrapper.orderByDesc("play_num");
            } else {
                wrapper.orderByDesc("create_time");
            }
        } else {
            wrapper.orderByDesc("create_time");
        }


        wrapper.isNull("parent_id");

        return wrapper;
    }

    //分页
    default PageList<VideoEntity> selectPage(VideoQueryDTO video) {
        IPage<VideoEntity> pageParams = new Page<>(video.getPage(), video.getSize());

        return PageList.setPages(selectPage(pageParams, search(video)));
    }

    //列表查询
    default List<VideoEntity> selectList(VideoQueryDTO video) {

        return selectList(search(video));
    }

    //视频子列表查询
    default List<VideoEntity> selectVideoList(Long id) {
        QueryWrapper<VideoEntity> wrapper = new QueryWrapper<>();

        wrapper.eq("parent_id", id);

        return selectList(wrapper);
    }

    //短视频查询
    default List<VideoEntity> selectSortVideo(Long id) {
        QueryWrapper<VideoEntity> wrapper = new QueryWrapper<>();

        wrapper.eq("id", id);

        return selectList(wrapper);
    }
}

