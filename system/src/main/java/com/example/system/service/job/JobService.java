package com.example.system.service.job;

import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.system.dal.dto.job.JobQueryDTO;
import com.example.system.dal.dto.job.JobSaveDTO;
import com.example.system.dal.entity.JobEntity;
import com.example.system.dal.vo.job.JobDetailVO;
import com.example.system.dal.vo.job.JobListVO;
import com.example.system.dal.vo.job.JobPageVO;

import java.util.List;

public interface JobService {
    /**
     * 获取列表分页
     *
     * @param job 分页入参
     * @return 列表分页
     */
    Result<PageList<JobPageVO>> jobPageService(JobQueryDTO job);

    /**
     * 获取列表
     *
     * @param job 入参
     * @return 列表
     */
    Result<List<JobListVO>> jobListService(JobQueryDTO job);

    /**
     * 获取详情
     *
     * @param id 入参
     * @return 详情
     */
    Result<JobDetailVO> jobDetailService(Long id);

    /**
     * 批量新增/修改
     *
     * @param job 新增/修改内容
     * @return 新增/修改后数据
     */
    Result<List<JobEntity>> jobSaveListService(List<JobSaveDTO> job);

    /**
     * 暂停或重新开启定时器
     *
     * @param job 状态
     * @return 修改后提示
     */
    Result<Object> changeJobStatusService(List<JobSaveDTO> job);
}
