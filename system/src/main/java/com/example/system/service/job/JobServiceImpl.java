package com.example.system.service.job;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.system.utils.Task;
import com.example.system.dal.convert.JobConvert;
import com.example.system.dal.dto.job.JobQueryDTO;
import com.example.system.dal.dto.job.JobSaveDTO;
import com.example.system.dal.entity.JobEntity;
import com.example.system.dal.mapper.JobMapper;
import com.example.system.dal.vo.job.JobDetailVO;
import com.example.system.dal.vo.job.JobListVO;
import com.example.system.dal.vo.job.JobPageVO;
import lombok.extern.slf4j.Slf4j;
import org.quartz.SchedulerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class JobServiceImpl extends ServiceImpl<JobMapper, JobEntity> implements JobService {
    @Resource
    JobMapper jobMapper;

    /**
     * 获取列表分页
     *
     * @param job 分页入参
     * @return 列表分页
     */
    @Override
    public Result<PageList<JobPageVO>> jobPageService(JobQueryDTO job) {
        return Result.success(JobConvert.INSTANCE.page(jobMapper.selectPageList(job)));
    }

    /**
     * 获取列表
     *
     * @param job 入参
     * @return 列表
     */
    @Override
    public Result<List<JobListVO>> jobListService(JobQueryDTO job) {
        return Result.success(JobConvert.INSTANCE.list(jobMapper.selectList(job)));
    }

    /**
     * 获取详情
     *
     * @param id 入参
     * @return 详情
     */
    @Override
    public Result<JobDetailVO> jobDetailService(Long id) {
        return Result.success(JobConvert.INSTANCE.detail(jobMapper.selectById(id)));
    }

    /**
     * 批量新增/修改
     *
     * @param job 新增/修改内容
     * @return 新增/修改后数据
     */
    @Override
    public Result<List<JobEntity>> jobSaveListService(List<JobSaveDTO> job) {

        //创建任务并加入队列
        for (JobSaveDTO jobItem : job) {
            //新增定时器
            if (jobItem.getId() == null) {
                try {
                    Task.addTask(jobItem.getJobCode(), jobItem.getExecuteInterval().intValue());
                } catch (SchedulerException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        List<JobEntity> jobList = JobConvert.INSTANCE.saveList(job);
        this.saveOrUpdateBatch(jobList);
        return Result.success(jobList);
    }

    /**
     * 暂停或重新开启定时器
     *
     * @param job 状态
     * @return 修改后提示
     */
    @Override
    public Result<Object> changeJobStatusService(List<JobSaveDTO> job) {
        for (JobSaveDTO jobItem : job) {
            //如果要改变的状态为运行
            if (jobItem.getStatus().equals("run")) {
                try {
                    Task.runTask(jobItem.getJobName());
                    //重新定义开始时间
                    jobItem.setStartTime(new Date());
                } catch (SchedulerException e) {
                    e.printStackTrace();
                }
            }
        }
        /*
         保存数据
         */
        List<JobEntity> jobList = JobConvert.INSTANCE.saveList(job);
        this.saveOrUpdateBatch(jobList);
        return Result.success(jobList);
    }
}