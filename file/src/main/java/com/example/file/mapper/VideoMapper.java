package com.example.file.mapper;

import cn.hutool.core.util.StrUtil;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.framework.common.PageList;
import com.example.file.dal.dto.video.VideoQueryDTO;
import com.example.file.dal.entity.VideoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@DS("file")
@Mapper
public interface VideoMapper extends BaseMapper<VideoEntity> {
    default QueryWrapper<VideoEntity> search(VideoQueryDTO video) {
        QueryWrapper<VideoEntity> wrapper = new QueryWrapper<>();

        /* 视频名称 */
        if (!StrUtil.hasBlank(video.getVideoName())) {
            wrapper.eq("video_name", video.getVideoName());
        }
        /* 视频标题 */
        if (!StrUtil.hasBlank(video.getTitle())) {
            wrapper.eq("title", video.getTitle());
        }
        /* 视频分类 */
        if (!StrUtil.hasBlank(video.getType())) {
            wrapper.eq("type", video.getType());
        }
        /* 视频地区 */
        if (!StrUtil.hasBlank(video.getRegion())) {
            wrapper.eq("region", video.getRegion());
        }
        /* url地址 */
        if (!StrUtil.hasBlank(video.getUrl())) {
            wrapper.eq("url", video.getUrl());
        }
        /* 视频图片 */
        if (!StrUtil.hasBlank(video.getPicture())) {
            wrapper.eq("picture", video.getPicture());
        }
        /* 视频类型 */
        if (!StrUtil.hasBlank(video.getVideoType())) {
            wrapper.eq("video_type", video.getVideoType());
        }
        /* 视频简介 */
        if (!StrUtil.hasBlank(video.getProfile())) {
            wrapper.eq("profile", video.getProfile());
        }
        /* 标签 */
        if (!StrUtil.hasBlank(video.getLabel())) {
            wrapper.eq("label", video.getLabel());
        }
        /* 作者 */
        if (!StrUtil.hasBlank(video.getAuthor())) {
            wrapper.eq("author", video.getAuthor());
        }
        /* 状态 */
        if (!StrUtil.hasBlank(video.getStatus())) {
            wrapper.eq("status", video.getStatus());
        }
        /* 备注 */
        if (!StrUtil.hasBlank(video.getRemark())) {
            wrapper.eq("remark", video.getRemark());
        }
        /* 创建人 */
        if (!StrUtil.hasBlank(video.getCreator())) {
            wrapper.eq("creator", video.getCreator());
        }
        /* 更新人 */
        if (!StrUtil.hasBlank(video.getUpdater())) {
            wrapper.eq("updater", video.getUpdater());
        }
        /* 是否是集合 */
        if (video.getIsCollection() != null) {
            wrapper.eq("isCollection", video.getIsCollection());
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

        wrapper.orderByAsc("episode");

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

