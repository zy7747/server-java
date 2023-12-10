package com.example.system.service.log;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.system.dal.convert.LogConvert;
import com.example.system.dal.dto.log.LogQueryDTO;
import com.example.system.dal.dto.log.LogSaveDTO;
import com.example.system.dal.entity.LogEntity;
import com.example.system.dal.mapper.LogMapper;
import com.example.system.dal.vo.log.LogDetailVO;
import com.example.system.dal.vo.log.LogListVO;
import com.example.system.dal.vo.log.LogPageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, LogEntity> implements LogService {
    @Resource
    LogMapper logMapper;

    /**
     * 获取列表分页
     *
     * @param log 分页入参
     * @return 列表分页
     */
    @Override
    public Result<PageList<LogPageVO>> logPageService(LogQueryDTO log) {
        return Result.success(LogConvert.INSTANCE.page(logMapper.selectPageList(log)));
    }

    /**
     * 获取列表
     *
     * @param log 入参
     * @return 列表
     */
    @Override
    public Result<List<LogListVO>> logListService(LogQueryDTO log) {
        return Result.success(LogConvert.INSTANCE.list(logMapper.selectList(log)));
    }

    /**
     * 获取详情
     *
     * @param id 入参
     * @return 详情
     */
    @Override
    public Result<LogDetailVO> logDetailService(Long id) {
        return Result.success(LogConvert.INSTANCE.detail(logMapper.selectById(id)));
    }

    /**
     * 批量新增/修改
     *
     * @param log 新增/修改内容
     * @return 新增/修改后数据
     */
    @Override
    public Result<List<LogEntity>> logSaveListService(List<LogSaveDTO> log) {
        List<LogEntity> logList = LogConvert.INSTANCE.saveList(log);
        this.saveOrUpdateBatch(logList);
        return Result.success(logList);
    }
}