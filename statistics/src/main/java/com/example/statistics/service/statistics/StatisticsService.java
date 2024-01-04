package com.example.statistics.service.statistics;

import com.example.framework.common.Result;
import com.example.statistics.dal.dto.statistics.StatisticsDTO;
import com.example.statistics.dal.vo.StatisticsGetVO;

public interface StatisticsService {
    /**
     * 获取列t统计后数据
     *
     * @param
     * @return 获取列t统计后数据
     */
    Result<StatisticsGetVO> getStatistics(StatisticsDTO statistics);
}
