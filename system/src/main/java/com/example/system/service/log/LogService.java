package com.example.system.service.log;

import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.system.dal.dto.log.LogQueryDTO;
import com.example.system.dal.dto.log.LogSaveDTO;
import com.example.system.dal.entity.LogEntity;
import com.example.system.dal.vo.log.LogDetailVO;
import com.example.system.dal.vo.log.LogListVO;
import com.example.system.dal.vo.log.LogPageVO;

import java.util.List;

public interface LogService {
    /**
     * 获取列表分页
     *
     * @param log 分页入参
     * @return 列表分页
     */
    Result<PageList<LogPageVO>> logPageService(LogQueryDTO log);

    /**
     * 获取列表
     *
     * @param log 入参
     * @return 列表
     */
    Result<List<LogListVO>> logListService(LogQueryDTO log);

    /**
     * 获取详情
     *
     * @param id 入参
     * @return 详情
     */
    Result<LogDetailVO> logDetailService(Long id);

    /**
     * 批量新增/修改
     *
     * @param log 新增/修改内容
     * @return 新增/修改后数据
     */
    Result<List<LogEntity>> logSaveListService(List<LogSaveDTO> log);
}