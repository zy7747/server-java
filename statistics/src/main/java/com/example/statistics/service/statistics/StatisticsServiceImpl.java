package com.example.statistics.service.statistics;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.file.dal.entity.VideoEntity;
import com.example.file.mapper.VideoMapper;
import com.example.framework.common.Result;
import com.example.statistics.dal.vo.StatisticsGetVO;
import com.example.system.dal.entity.DictEntity;
import com.example.system.dal.entity.UserEntity;
import com.example.system.mapper.DictMapper;
import com.example.system.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class StatisticsServiceImpl implements StatisticsService {
    @Resource
    UserMapper userMapper;

    @Resource
    VideoMapper videoMapper;

    @Resource
    DictMapper dictMapper;

    //用户总数
    Integer UserTotal;

    //字典总数
    Integer DictTotal;

    //视频总数
    Integer VideoTotal;

    //统计用户
    public void getUserStatistics() {
        QueryWrapper<UserEntity> userWrapper = new QueryWrapper<>();
        //获取所有用户
        List<UserEntity> userList = userMapper.selectList(userWrapper);

        UserTotal = userList.size();
    }

    //统计字典
    public void getDictStatistics() {
        QueryWrapper<DictEntity> dictWrapper = new QueryWrapper<>();

        dictWrapper.isNull("parent_id");
        //获取所有字典
        List<DictEntity> dictList = dictMapper.selectList(dictWrapper);

        DictTotal = dictList.size();
    }

    //统计视频
    public void getVideoStatistics() {
        QueryWrapper<VideoEntity> videoWrapper = new QueryWrapper<>();

        videoWrapper.isNull("parent_id");
        //获取所有字典
        List<VideoEntity> dictList = videoMapper.selectList(videoWrapper);

        VideoTotal = dictList.size();
    }

    // 数据组装
    @Override
    public Result<StatisticsGetVO> getStatistics() {
        //所有统计数据
        StatisticsGetVO statistics = new StatisticsGetVO();

        getUserStatistics();
        getDictStatistics();
        getVideoStatistics();

        statistics.setUserTotal(UserTotal);
        statistics.setDictTotal(DictTotal);
        statistics.setVideoTotal(VideoTotal);

        return Result.success(statistics);
    }

}
