package com.example.system.service.operationLog;

import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.system.dal.dto.operationLog.OperationLogQueryDTO;
import com.example.system.dal.dto.operationLog.OperationLogSaveDTO;
import com.example.system.dal.entity.OperationLogEntity;
import com.example.system.dal.vo.operationLog.OperationLogDetailVO;
import com.example.system.dal.vo.operationLog.OperationLogListVO;
import com.example.system.dal.vo.operationLog.OperationLogPageVO;

import java.util.List;

public interface OperationLogService {
    /**
     * 获取列表分页
     *
     * @param operationLog 分页入参
     * @return 列表分页
     */
    Result<PageList<OperationLogPageVO>> operationLogPageService(OperationLogQueryDTO operationLog);

    /**
     * 获取列表
     *
     * @param operationLog 入参
     * @return 列表
     */
    Result<List<OperationLogListVO>> operationLogListService(OperationLogQueryDTO operationLog);

    /**
     * 获取详情
     *
     * @param id 入参
     * @return 详情
     */
    Result<OperationLogDetailVO> operationLogDetailService(Long id);

    /**
     * 批量新增/修改
     *
     * @param operationLog 新增/修改内容
     * @return 新增/修改后数据
     */
    Result<List<OperationLogEntity>> operationLogSaveListService(List<OperationLogSaveDTO> operationLog);
}