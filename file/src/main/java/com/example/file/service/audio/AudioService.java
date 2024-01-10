package com.example.file.service.audio;

import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.file.dal.dto.audio.AudioQueryDTO;
import com.example.file.dal.dto.audio.AudioSaveDTO;
import com.example.file.dal.entity.AudioEntity;
import com.example.file.dal.vo.audio.AudioDetailVO;
import com.example.file.dal.vo.audio.AudioListVO;
import com.example.file.dal.vo.audio.AudioPageVO;

import java.util.List;

public interface AudioService {
    /**
     * 获取列表分页
     *
     * @param audio 分页入参
     * @return 列表分页
     */
    Result<PageList<AudioPageVO>> audioPageService(AudioQueryDTO audio);

    /**
     * 获取列表
     *
     * @param audio 入参
     * @return 列表
     */
    Result<List<AudioListVO>> audioListService(AudioQueryDTO audio);

    /**
     * 获取详情
     *
     * @param id 入参
     * @return 详情
     */
    Result<AudioDetailVO> audioDetailService(Long id);

    /**
     * 批量新增/修改
     *
     * @param audio 新增/修改内容
     * @return 新增/修改后数据
     */
    Result<List<AudioEntity>> audioSaveListService(List<AudioSaveDTO> audio);
}