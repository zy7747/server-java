package com.example.file.mapper;

import cn.hutool.core.util.StrUtil;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.framework.common.PageList;
import com.example.file.dal.dto.audio.AudioQueryDTO;
import com.example.file.dal.entity.AudioEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@DS("file")
@Mapper
public interface AudioMapper extends BaseMapper<AudioEntity> {
    default QueryWrapper<AudioEntity> search(AudioQueryDTO audio) {
        QueryWrapper<AudioEntity> wrapper = new QueryWrapper<>();

        /* 音频名称 */
        if (!StrUtil.hasBlank(audio.getAudioName())) {
            wrapper.eq("audio_name", audio.getAudioName());
        }
        /* 音频标题 */
        if (!StrUtil.hasBlank(audio.getTitle())) {
            wrapper.eq("title", audio.getTitle());
        }
        /* 音频分类 */
        if (!StrUtil.hasBlank(audio.getType())) {
            wrapper.eq("type", audio.getType());
        }
        /* 音频地区 */
        if (!StrUtil.hasBlank(audio.getRegion())) {
            wrapper.eq("region", audio.getRegion());
        }
        /* 音频类型 */
        if (!StrUtil.hasBlank(audio.getAudioType())) {
            wrapper.eq("video_type", audio.getAudioType());
        }
        /* 音频简介 */
        if (!StrUtil.hasBlank(audio.getProfile())) {
            wrapper.eq("profile", audio.getProfile());
        }
        /* 标签 */
        if (!StrUtil.hasBlank(audio.getLabel())) {
            wrapper.eq("label", audio.getLabel());
        }
        /* 歌手名称 */
        if (!StrUtil.hasBlank(audio.getSinger())) {
            wrapper.eq("singer", audio.getSinger());
        }
        /* 作词 */
        if (!StrUtil.hasBlank(audio.getLyricist())) {
            wrapper.eq("lyricist", audio.getLyricist());
        }
        /* 作曲 */
        if (!StrUtil.hasBlank(audio.getComposing())) {
            wrapper.eq("composing", audio.getComposing());
        }

        /* 状态 */
        if (!StrUtil.hasBlank(audio.getStatus())) {
            wrapper.eq("status", audio.getStatus());
        }

        wrapper.orderByDesc("create_time");
        return wrapper;
    }

    /**
     * 分页查询
     */
    default PageList<AudioEntity> selectPageList(AudioQueryDTO audio) {
        IPage<AudioEntity> pageParams = new Page<>(audio.getPage(), audio.getSize());
        return PageList.setPages(selectPage(pageParams, search(audio)));
    }

    /**
     * 列表查询
     */
    default List<AudioEntity> selectList(AudioQueryDTO audio) {
        return selectList(search(audio));
    }
}