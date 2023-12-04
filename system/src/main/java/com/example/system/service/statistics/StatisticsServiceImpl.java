package com.example.system.service.statistics;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.framework.common.Result;
import com.example.system.dal.dto.dict.DictQueryDTO;
import com.example.system.dal.entity.DictEntity;
import com.example.system.dal.entity.UserEntity;
import com.example.system.dal.mapper.DictMapper;
import com.example.system.dal.mapper.UserMapper;
import com.example.system.dal.vo.statistics.StatisticsGetVO;
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
    DictMapper dictMapper;

    //用户总数
    Integer UserTotal;

    public List<DictEntity> getDictList(String dictCode) {
        DictQueryDTO dict = new DictQueryDTO();

        dict.setDictCode(dictCode);

        return dictMapper.subList(dict);
    }

    public void getUserStatistics() {
        QueryWrapper<UserEntity> userWrapper = new QueryWrapper<>();
        //获取所有用户
        List<UserEntity> userList = userMapper.selectList(userWrapper);

        UserTotal = userList.size();
    }

    @Override
    public Result<StatisticsGetVO> getStatistics() {
        //所有统计数据
        StatisticsGetVO statistics = new StatisticsGetVO();

        getUserStatistics();

        statistics.setUserTotal(UserTotal);

        return Result.success(statistics);
    }

}
