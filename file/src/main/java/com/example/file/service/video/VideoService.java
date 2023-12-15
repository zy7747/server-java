package com.example.file.service.video;

import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.file.dal.dto.video.HotVideoListQueryDTO;
import com.example.file.dal.dto.video.VideoQueryDTO;
import com.example.file.dal.dto.video.VideoSaveDTO;
import com.example.file.dal.entity.VideoEntity;
import com.example.file.dal.vo.video.VideoDetailVO;
import com.example.file.dal.vo.video.VideoListVO;
import com.example.file.dal.vo.video.VideoPageVO;

import java.util.List;

public interface VideoService {
    /**
     * 获取列表分页
     *
     * @param video 分页入参
     * @return 列表分页
     */
    Result<PageList<VideoPageVO>> pageService(VideoQueryDTO video);

    /**
     * 获取列表
     *
     * @param video 入参
     * @return 列表
     */
    Result<List<VideoListVO>> listService(VideoQueryDTO video);

    /**
     * 获取详情
     *
     * @param id 入参
     * @return 详情
     */
    Result<VideoDetailVO> detailService(Long id);

    /**
     * 批量新增/修改
     *
     * @param videoList 新增/修改内容
     * @return 新增/修改后数据
     */
    Result<List<VideoEntity>> saveListService(List<VideoSaveDTO> videoList);

    /**
     * 记录播放量
     *
     * @param video 记录播放量
     * @return 播放量
     */
    Result<VideoEntity> playNumService(VideoEntity video);

    /**
     * 热门视频查询
     *
     * @return 返回热门视频列表
     */
    Result<HotVideoListQueryDTO> hotVideoService();
}