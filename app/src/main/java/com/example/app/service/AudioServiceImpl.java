package com.example.app.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.app.dal.convert.AudioConvert;
import com.example.app.dal.dto.audio.AudioQueryDTO;
import com.example.app.dal.dto.audio.AudioSaveDTO;
import com.example.app.dal.entity.AudioEntity;
import com.example.app.dal.mapper.AudioMapper;
import com.example.app.dal.vo.audio.AudioDetailVO;
import com.example.app.dal.vo.audio.AudioListVO;
import com.example.app.dal.vo.audio.AudioPageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@DS("app")
@Service
public class AudioServiceImpl extends ServiceImpl<AudioMapper, AudioEntity> implements AudioService {
    @Resource
    AudioMapper audioMapper;

    /**
     * 获取列表分页
     *
     * @param audio 分页入参
     * @return 列表分页
     */
    @Override
    public Result<PageList<AudioPageVO>> audioPageService(AudioQueryDTO audio) {
        return Result.success(AudioConvert.INSTANCE.page(audioMapper.selectPageList(audio)));
    }

    /**
     * 获取列表
     *
     * @param audio 入参
     * @return 列表
     */
    @Override
    public Result<List<AudioListVO>> audioListService(AudioQueryDTO audio) {
        return Result.success(AudioConvert.INSTANCE.list(audioMapper.selectList(audio)));
    }

    /**
     * 获取详情
     *
     * @param id 入参
     * @return 详情
     */
    @Override
    public Result<AudioDetailVO> audioDetailService(Long id) {
        return Result.success(AudioConvert.INSTANCE.detail(audioMapper.selectById(id)));
    }

    /**
     * 批量新增/修改
     *
     * @param audio 新增/修改内容
     * @return 新增/修改后数据
     */
    @Override
    public Result<List<AudioEntity>> audioSaveListService(List<AudioSaveDTO> audio) {
        List<AudioEntity> audioList = AudioConvert.INSTANCE.saveList(audio);
        this.saveOrUpdateBatch(audioList);
        return Result.success(audioList);
    }
}