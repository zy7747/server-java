package com.example.system.service.operationLog;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.system.convert.OperationLogConvert;
import com.example.system.dal.dto.operationLog.OperationLogQueryDTO;
import com.example.system.dal.dto.operationLog.OperationLogSaveDTO;
import com.example.system.dal.entity.OperationLogEntity;
import com.example.system.mapper.OperationLogMapper;
import com.example.system.dal.vo.operationLog.OperationLogDetailVO;
import com.example.system.dal.vo.operationLog.OperationLogListVO;
import com.example.system.dal.vo.operationLog.OperationLogPageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class OperationLogServiceImpl extends ServiceImpl<OperationLogMapper, OperationLogEntity> implements OperationLogService {
    @Resource
    OperationLogMapper operationLogMapper;

    /**
     * 获取列表分页
     *
     * @param operationLog 分页入参
     * @return 列表分页
     */
    @Override
    public Result<PageList<OperationLogPageVO>> operationLogPageService(OperationLogQueryDTO operationLog) {
        return Result.success(OperationLogConvert.INSTANCE.page(operationLogMapper.selectPageList(operationLog)));
    }

    /**
     * 获取列表
     *
     * @param operationLog 入参
     * @return 列表
     */
    @Override
    public Result<List<OperationLogListVO>> operationLogListService(OperationLogQueryDTO operationLog) {
        return Result.success(OperationLogConvert.INSTANCE.list(operationLogMapper.selectList(operationLog)));
    }

    /**
     * 获取详情
     *
     * @param id 入参
     * @return 详情
     */
    @Override
    public Result<OperationLogDetailVO> operationLogDetailService(Long id) {
        return Result.success(OperationLogConvert.INSTANCE.detail(operationLogMapper.selectById(id)));
    }

    /**
     * 批量新增/修改
     *
     * @param operationLog 新增/修改内容
     * @return 新增/修改后数据
     */
    @Override
    public Result<List<OperationLogEntity>> operationLogSaveListService(List<OperationLogSaveDTO> operationLog) {
        List<OperationLogEntity> operationLogList = OperationLogConvert.INSTANCE.saveList(operationLog);
        this.saveOrUpdateBatch(operationLogList);
        return Result.success(operationLogList);
    }
}