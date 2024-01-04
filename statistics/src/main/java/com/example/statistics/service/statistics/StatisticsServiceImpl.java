package com.example.statistics.service.statistics;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.file.dal.entity.FileEntity;
import com.example.file.dal.entity.VideoEntity;
import com.example.file.mapper.FileMapper;
import com.example.file.mapper.VideoMapper;
import com.example.framework.common.Result;
import com.example.statistics.dal.dto.statistics.StatisticsDTO;
import com.example.statistics.dal.vo.StatisticsGetVO;
import com.example.system.dal.entity.DictEntity;
import com.example.system.dal.entity.PersonEntity;
import com.example.system.dal.entity.UserEntity;
import com.example.system.mapper.PersonMapper;
import com.example.system.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.example.system.utils.DictUtil;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class StatisticsServiceImpl implements StatisticsService {
    @Resource
    UserMapper userMapper;

    @Resource
    PersonMapper personMapper;

    @Resource
    VideoMapper videoMapper;

    @Resource
    FileMapper fileMapper;


    //用户总数
    Integer userTotal;

    //人信息资料总数
    Integer personTotal;

    //视频总数
    Integer videoTotal;

    //文件总数
    Integer fileTotal;

    //文件类型
    private Map<String, Long> fileTypeMap;

    //视频类型
    private final Map<String, Long> videoType = new HashMap<>();

    //用户性别
    private final Map<String, Long> sex = new HashMap<>();

    //统计用户
    public void getUserStatistics() {
        QueryWrapper<UserEntity> userWrapper = new QueryWrapper<>();

        List<UserEntity> userList = userMapper.selectList(userWrapper);

        userTotal = userList.size();
    }

    //统计个人信息资料
    public void getPersonStatistics() {
        QueryWrapper<PersonEntity> personWrapper = new QueryWrapper<>();

        List<PersonEntity> personList = personMapper.selectList(personWrapper);

        Map<String, Long> sexMap = personList.stream().collect(Collectors.groupingBy(PersonEntity::getSex, Collectors.counting()));

        //获取字典
        List<DictEntity> dict = DictUtil.getDictList("user_sex");
        //翻译key
        sexMap.forEach((k, v) -> sex.put(DictUtil.translate(dict, k), v));

        personTotal = personList.size();
    }

    //统计文件
    public void getFileStatistics() {
        QueryWrapper<FileEntity> fileWrapper = new QueryWrapper<>();

        fileWrapper.ne("file_type", "folder");

        List<FileEntity> fileList = fileMapper.selectList(fileWrapper);

        fileTypeMap = fileList.stream().collect(Collectors.groupingBy(FileEntity::getFileType, Collectors.counting()));

        fileTotal = fileList.size();
    }

    //统计视频
    public void getVideoStatistics() {
        QueryWrapper<VideoEntity> videoWrapper = new QueryWrapper<>();

        videoWrapper.isNull("parent_id");

        List<VideoEntity> videoList = videoMapper.selectList(videoWrapper);

        //统计数据
        Map<String, Long> videoTypeMap = videoList.stream().collect(Collectors.groupingBy(VideoEntity::getType, Collectors.counting()));
        //获取字典
        List<DictEntity> dict = DictUtil.getDictList("video_category");
        //翻译key
        videoTypeMap.forEach((k, v) -> videoType.put(DictUtil.translate(dict, k), v));

        videoTotal = videoList.size();
    }

    // 数据组装
    @Override
    public Result<StatisticsGetVO> getStatistics(StatisticsDTO statisticsQuery) {
        //所有统计数据
        StatisticsGetVO statistics = new StatisticsGetVO();

        //执行统计
        getUserStatistics();
        getVideoStatistics();
        getPersonStatistics();
        getFileStatistics();

        //塞入数据
        statistics.setUserTotal(userTotal);
        statistics.setVideoTotal(videoTotal);
        statistics.setPersonTotal(personTotal);
        statistics.setFileTotal(fileTotal);

        statistics.setFileType(fileTypeMap);
        statistics.setVideoType(videoType);
        statistics.setSex(sex);

        return Result.success(statistics);
    }

}
