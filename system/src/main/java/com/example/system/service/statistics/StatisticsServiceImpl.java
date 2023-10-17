package com.example.system.service.statistics;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.framework.common.Result;
import com.example.system.dal.entity.UserEntity;
import com.example.system.dal.mapper.UserMapper;
import com.example.system.dal.vo.statistics.StatisticsGetVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class StatisticsServiceImpl implements StatisticsService {
    @Resource
    UserMapper userMapper;

    @Override
    public Result<StatisticsGetVO> getStatistics() {
        StatisticsGetVO statistics = new StatisticsGetVO();

        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        //获取所有用户
        List<UserEntity> userCount = userMapper.selectList(wrapper);
        //性别统计
        int manCount = 0;//男性数量
        int woManCount = 0;//女性数量
        int otherCount = 0;//未填性别数量

        for (UserEntity userItem : userCount) {
            if (userItem.getSex().equals("man")) {
                manCount += 1;
            } else if (userItem.getSex().equals("woman")) {
                woManCount += 1;
            } else {
                otherCount += 1;
            }
        }

        Map<String, Object> sexCount = new HashMap<>();

        sexCount.put("男", manCount);
        sexCount.put("女", woManCount);
        sexCount.put("其他", otherCount);
        statistics.setUserSex(sexCount);
        //总用户量统计
        statistics.setUserTotal(userCount.size());

        return Result.success(statistics);
    }

}
