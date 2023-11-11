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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class StatisticsServiceImpl implements StatisticsService {
    @Resource
    UserMapper userMapper;

    @Resource
    DictMapper dictMapper;

    //性别
    Map<String, Integer> UserSex = new HashMap<>();

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

        for (DictEntity dictItem : getDictList("user_sex")) {
            int count = 0;
            for (UserEntity user : userList) {
                if (user.getSex().equals(dictItem.getValue())) {
                    count += 1;
                }
            }
            UserSex.put(dictItem.getLabel(), count);
        }

        UserTotal = userList.size();
    }

    @Override
    public Result<StatisticsGetVO> getStatistics() {
        //所有统计数据
        StatisticsGetVO statistics = new StatisticsGetVO();

        getUserStatistics();

        statistics.setUserSex(UserSex);
        statistics.setUserTotal(UserTotal);

        return Result.success(statistics);
    }

}
