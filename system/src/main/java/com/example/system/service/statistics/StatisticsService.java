package com.example.system.service.statistics;

import com.example.framework.common.Result;
import com.example.system.dal.vo.statistics.StatisticsGetVO;

public interface StatisticsService {
    /**
     * 获取列t统计后数据
     *
     * @param
     * @return 获取列t统计后数据
     */
    Result<StatisticsGetVO> getStatistics();
}
